package org.chromium.content.browser.androidoverlay;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.view.Surface;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.task.PostTask;
import org.chromium.content.browser.androidoverlay.DialogOverlayCore;
import org.chromium.content_public.browser.UiThreadTaskTraits;
import org.chromium.gfx.mojom.Rect;
import org.chromium.media.mojom.AndroidOverlay;
import org.chromium.media.mojom.AndroidOverlayClient;
import org.chromium.media.mojom.AndroidOverlayConfig;
import org.chromium.mojo.system.MojoException;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/androidoverlay/DialogOverlayImpl.class */
public class DialogOverlayImpl implements AndroidOverlay, DialogOverlayCore.Host {
    private static final String TAG = "DialogOverlayImpl";
    private AndroidOverlayClient mClient;
    private Handler mOverlayHandler;
    private Runnable mReleasedRunnable;
    private Runnable mReleaseCoreRunnable;
    private final ThreadHoppingHost mHoppingHost;
    private DialogOverlayCore mDialogCore;
    private long mNativeHandle;
    private int mSurfaceId;
    private boolean mClosed;
    private final int[] mCompositorOffset = new int[2];
    static final /* synthetic */ boolean $assertionsDisabled;

    private native long nativeInit(long j, long j2, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeCompleteInit(long j);

    private native void nativeDestroy(long j);

    private native void nativeGetCompositorOffset(long j, Rect rect);

    private static native int nativeRegisterSurface(Surface surface);

    private static native void nativeUnregisterSurface(int i);

    static native Surface nativeLookupSurfaceForTesting(int i);

    static {
        $assertionsDisabled = !DialogOverlayImpl.class.desiredAssertionStatus();
    }

    public DialogOverlayImpl(AndroidOverlayClient client, final AndroidOverlayConfig config, Handler overlayHandler, Runnable releasedRunnable, final boolean asPanel) {
        ThreadUtils.assertOnUiThread();
        this.mClient = client;
        this.mReleasedRunnable = releasedRunnable;
        this.mOverlayHandler = overlayHandler;
        this.mDialogCore = new DialogOverlayCore();
        this.mHoppingHost = new ThreadHoppingHost(this);
        this.mNativeHandle = nativeInit(config.routingToken.high, config.routingToken.low, config.powerEfficient);
        if (this.mNativeHandle == 0) {
            this.mClient.onDestroyed();
            cleanup();
            return;
        }
        final DialogOverlayCore dialogCore = this.mDialogCore;
        final Context context = ContextUtils.getApplicationContext();
        nativeGetCompositorOffset(this.mNativeHandle, config.rect);
        this.mOverlayHandler.post(new Runnable() { // from class: org.chromium.content.browser.androidoverlay.DialogOverlayImpl.1
            @Override // java.lang.Runnable
            public void run() {
                dialogCore.initialize(context, config, DialogOverlayImpl.this.mHoppingHost, asPanel);
                PostTask.postTask(UiThreadTaskTraits.DEFAULT, new Runnable() { // from class: org.chromium.content.browser.androidoverlay.DialogOverlayImpl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DialogOverlayImpl.this.mNativeHandle != 0) {
                            DialogOverlayImpl.this.nativeCompleteInit(DialogOverlayImpl.this.mNativeHandle);
                        }
                    }
                });
            }
        });
        this.mReleaseCoreRunnable = new Runnable() { // from class: org.chromium.content.browser.androidoverlay.DialogOverlayImpl.2
            @Override // java.lang.Runnable
            public void run() {
                dialogCore.release();
            }
        };
    }

    @Override // org.chromium.mojo.bindings.Interface, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ThreadUtils.assertOnUiThread();
        if (this.mClosed) {
            return;
        }
        this.mClosed = true;
        this.mHoppingHost.onClose();
        if (this.mReleaseCoreRunnable != null) {
            this.mOverlayHandler.post(this.mReleaseCoreRunnable);
            this.mReleaseCoreRunnable = null;
            cleanup();
        }
        this.mReleasedRunnable.run();
    }

    @Override // org.chromium.mojo.bindings.ConnectionErrorHandler
    public void onConnectionError(MojoException e) {
        ThreadUtils.assertOnUiThread();
        close();
    }

    @Override // org.chromium.media.mojom.AndroidOverlay
    public void scheduleLayout(final Rect rect) {
        ThreadUtils.assertOnUiThread();
        if (this.mDialogCore == null) {
            return;
        }
        nativeGetCompositorOffset(this.mNativeHandle, rect);
        final DialogOverlayCore dialogCore = this.mDialogCore;
        this.mOverlayHandler.post(new Runnable() { // from class: org.chromium.content.browser.androidoverlay.DialogOverlayImpl.3
            @Override // java.lang.Runnable
            public void run() {
                dialogCore.layoutSurface(rect);
            }
        });
    }

    @CalledByNative
    private static void receiveCompositorOffset(Rect rect, int x, int y) {
        rect.x += x;
        rect.y += y;
    }

    @Override // org.chromium.content.browser.androidoverlay.DialogOverlayCore.Host
    public void onSurfaceReady(Surface surface) {
        ThreadUtils.assertOnUiThread();
        if (this.mDialogCore == null || this.mClient == null) {
            return;
        }
        this.mSurfaceId = nativeRegisterSurface(surface);
        this.mClient.onSurfaceReady(this.mSurfaceId);
    }

    @Override // org.chromium.content.browser.androidoverlay.DialogOverlayCore.Host
    public void onOverlayDestroyed() {
        ThreadUtils.assertOnUiThread();
        if (this.mDialogCore == null) {
            return;
        }
        if (this.mClient != null) {
            this.mClient.onDestroyed();
        }
        cleanup();
    }

    @Override // org.chromium.content.browser.androidoverlay.DialogOverlayCore.Host
    public void waitForClose() {
        if (!$assertionsDisabled) {
            throw new AssertionError("Not reached");
        }
    }

    @Override // org.chromium.content.browser.androidoverlay.DialogOverlayCore.Host
    public void enforceClose() {
        close();
    }

    private void sendWindowTokenToCore(final IBinder token) {
        ThreadUtils.assertOnUiThread();
        if (this.mDialogCore != null) {
            final DialogOverlayCore dialogCore = this.mDialogCore;
            this.mOverlayHandler.post(new Runnable() { // from class: org.chromium.content.browser.androidoverlay.DialogOverlayImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    dialogCore.onWindowToken(token);
                }
            });
        }
    }

    @CalledByNative
    public void onWindowToken(IBinder token) {
        ThreadUtils.assertOnUiThread();
        if (this.mDialogCore == null) {
            return;
        }
        sendWindowTokenToCore(token);
    }

    @CalledByNative
    public void onDismissed() {
        ThreadUtils.assertOnUiThread();
        if (this.mClient != null) {
            this.mClient.onDestroyed();
        }
        sendWindowTokenToCore(null);
        cleanup();
    }

    @CalledByNative
    private void onPowerEfficientState(boolean isPowerEfficient) {
        ThreadUtils.assertOnUiThread();
        if (this.mDialogCore == null || this.mClient == null) {
            return;
        }
        this.mClient.onPowerEfficientState(isPowerEfficient);
    }

    private void cleanup() {
        ThreadUtils.assertOnUiThread();
        if (this.mSurfaceId != 0) {
            nativeUnregisterSurface(this.mSurfaceId);
            this.mSurfaceId = 0;
        }
        if (this.mNativeHandle != 0) {
            nativeDestroy(this.mNativeHandle);
            this.mNativeHandle = 0L;
        }
        this.mDialogCore = null;
        if (this.mClient != null) {
            this.mClient.close();
        }
        this.mClient = null;
    }
}
