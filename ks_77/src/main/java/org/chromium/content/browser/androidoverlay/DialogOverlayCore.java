package org.chromium.content.browser.androidoverlay;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.blink.mojom.WebFeature;
import org.chromium.gfx.mojom.Rect;
import org.chromium.media.mojom.AndroidOverlayConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/androidoverlay/DialogOverlayCore.class */
public class DialogOverlayCore {
    private static final String TAG = "DSCore";
    private Host mHost;
    private Dialog mDialog;
    private Callbacks mDialogCallbacks;
    private WindowManager.LayoutParams mLayoutParams;
    private boolean mAsPanel;
    private Looper mLooper;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/androidoverlay/DialogOverlayCore$Host.class */
    public interface Host {
        void onSurfaceReady(Surface surface);

        void onOverlayDestroyed();

        void waitForClose();

        void enforceClose();
    }

    public void initialize(Context context, AndroidOverlayConfig config, Host host, boolean asPanel) {
        this.mLooper = Looper.myLooper();
        this.mHost = host;
        this.mAsPanel = asPanel;
        this.mDialog = new Dialog(context, 16973909);
        this.mDialog.requestWindowFeature(1);
        this.mDialog.setCancelable(false);
        this.mLayoutParams = createLayoutParams(config.secure);
        copyRectToLayoutParams(config.rect);
    }

    public void release() {
        assertProperThread();
        dismissDialogQuietly();
        this.mLayoutParams.token = null;
        this.mHost = null;
    }

    private boolean copyRectToLayoutParams(Rect rect) {
        if (this.mLayoutParams.x == rect.x && this.mLayoutParams.y == rect.y && this.mLayoutParams.width == rect.width && this.mLayoutParams.height == rect.height) {
            return false;
        }
        this.mLayoutParams.x = rect.x;
        this.mLayoutParams.y = rect.y;
        this.mLayoutParams.width = rect.width;
        this.mLayoutParams.height = rect.height;
        return true;
    }

    public void layoutSurface(Rect rect) {
        if (this.mDialog == null || this.mLayoutParams.token == null || !copyRectToLayoutParams(rect)) {
            return;
        }
        this.mDialog.getWindow().setAttributes(this.mLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/androidoverlay/DialogOverlayCore$Callbacks.class */
    public class Callbacks implements SurfaceHolder.Callback2 {
        private Callbacks() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder holder) {
            DialogOverlayCore.this.assertProperThread();
            if (DialogOverlayCore.this.mDialog != null && DialogOverlayCore.this.mHost != null) {
                DialogOverlayCore.this.mHost.onSurfaceReady(holder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder holder) {
            if (DialogOverlayCore.this.mDialog == null || DialogOverlayCore.this.mHost == null) {
                return;
            }
            if (Build.VERSION.SDK_INT != 28) {
                DialogOverlayCore.this.assertProperThread();
            } else if (DialogOverlayCore.this.mLooper != Looper.myLooper()) {
                Log.e(DialogOverlayCore.TAG, "surfaceDestroyed called on wrong thread.  Avoiding proper shutdown.", new Object[0]);
                DialogOverlayCore.this.mHost.onOverlayDestroyed();
                return;
            }
            DialogOverlayCore.this.mHost.onOverlayDestroyed();
            DialogOverlayCore.this.mHost.waitForClose();
            DialogOverlayCore.this.mHost.enforceClose();
            DialogOverlayCore.this.mHost = null;
        }

        @Override // android.view.SurfaceHolder.Callback2
        public void surfaceRedrawNeeded(SurfaceHolder holder) {
        }
    }

    public void onWindowToken(IBinder token) {
        assertProperThread();
        if (this.mDialog == null || this.mHost == null) {
            return;
        }
        if (token == null || (this.mLayoutParams.token != null && token != this.mLayoutParams.token)) {
            this.mHost.onOverlayDestroyed();
            this.mHost = null;
            dismissDialogQuietly();
        } else if (this.mLayoutParams.token == token) {
        } else {
            this.mLayoutParams.token = token;
            this.mDialog.getWindow().setAttributes(this.mLayoutParams);
            this.mDialogCallbacks = new Callbacks();
            this.mDialog.getWindow().takeSurface(this.mDialogCallbacks);
            this.mDialog.show();
        }
    }

    @SuppressLint({"RtlHardcoded"})
    private WindowManager.LayoutParams createLayoutParams(boolean secure) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        layoutParams.type = this.mAsPanel ? 1000 : WebFeature.SELECTION_IS_COLLAPSED;
        layoutParams.flags = 568;
        if (secure) {
            layoutParams.flags |= 8192;
        }
        try {
            int currentFlags = ((Integer) layoutParams.getClass().getField("privateFlags").get(layoutParams)).intValue();
            layoutParams.getClass().getField("privateFlags").set(layoutParams, Integer.valueOf(currentFlags | 64));
        } catch (ExceptionInInitializerError e) {
        } catch (IllegalAccessException e2) {
        } catch (IllegalArgumentException e3) {
        } catch (NoSuchFieldException e4) {
        } catch (NullPointerException e5) {
        } catch (SecurityException e6) {
        }
        return layoutParams;
    }

    Dialog getDialog() {
        return this.mDialog;
    }

    private void dismissDialogQuietly() {
        if (this.mDialog != null && this.mDialog.isShowing()) {
            try {
                this.mDialog.dismiss();
            } catch (Exception e) {
                Log.w(TAG, "Failed to dismiss overlay dialog.  \"WindowLeaked\" is ignorable.", new Object[0]);
            }
        }
        this.mDialog = null;
        this.mDialogCallbacks = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void assertProperThread() {
        if (this.mLooper == Looper.myLooper()) {
            return;
        }
        if (ThreadUtils.runningOnUiThread()) {
            throw new RuntimeException("DialogOverlayCore is on the UI thread");
        }
        throw new RuntimeException("DialogOverlayCore is on the wrong thread");
    }
}
