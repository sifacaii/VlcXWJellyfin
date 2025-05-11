package org.chromium.content.browser.webcontents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.UserData;
import org.chromium.base.UserDataHost;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.content.browser.AppWebMessagePort;
import org.chromium.content.browser.MediaSessionImpl;
import org.chromium.content.browser.RenderCoordinatesImpl;
import org.chromium.content.browser.RenderWidgetHostViewImpl;
import org.chromium.content.browser.ViewEventSinkImpl;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.WindowEventObserverManager;
import org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;
import org.chromium.content.browser.framehost.RenderFrameHostDelegate;
import org.chromium.content.browser.framehost.RenderFrameHostImpl;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;
import org.chromium.content_public.browser.AccessibilitySnapshotCallback;
import org.chromium.content_public.browser.AccessibilitySnapshotNode;
import org.chromium.content_public.browser.ImageDownloadCallback;
import org.chromium.content_public.browser.JavaScriptCallback;
import org.chromium.content_public.browser.MessagePort;
import org.chromium.content_public.browser.NavigationController;
import org.chromium.content_public.browser.RenderFrameHost;
import org.chromium.content_public.browser.ViewEventSink;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsInternals;
import org.chromium.content_public.browser.WebContentsObserver;
import org.chromium.ui.OverscrollRefreshHandler;
import org.chromium.ui.base.EventForwarder;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/webcontents/WebContentsImpl.class */
public class WebContentsImpl implements WebContents, RenderFrameHostDelegate, WindowEventObserver {
    private static final String TAG = "cr_WebContentsImpl";
    private static final String PARCEL_VERSION_KEY = "version";
    private static final String PARCEL_WEBCONTENTS_KEY = "webcontents";
    private static final String PARCEL_PROCESS_GUARD_KEY = "processguard";
    private static final long PARCELABLE_VERSION_ID = 0;
    private static UUID sParcelableUUID;
    @SuppressLint({"ParcelClassLoader"})
    public static final Parcelable.Creator<WebContents> CREATOR;
    private final List<RenderFrameHostImpl> mFrames = new ArrayList();
    private long mNativeWebContentsAndroid;
    private NavigationController mNavigationController;
    private WebContentsObserverProxy mObserverProxy;
    private MediaSessionImpl mMediaSession;
    private SmartClipCallback mSmartClipCallback;
    private EventForwarder mEventForwarder;
    private RenderCoordinatesImpl mRenderCoordinates;
    private WebContents.InternalsHolder mInternalsHolder;
    private String mProductVersion;
    private boolean mInitialized;
    private Throwable mNativeDestroyThrowable;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/webcontents/WebContentsImpl$UserDataFactory.class */
    public interface UserDataFactory<T> {
        T create(WebContents webContents);
    }

    private static native void nativeDestroyWebContents(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native WebContents nativeFromNativePtr(long j);

    private native void nativeClearNativeReference(long j);

    private native WindowAndroid nativeGetTopLevelNativeWindow(long j);

    private native void nativeSetTopLevelNativeWindow(long j, WindowAndroid windowAndroid);

    private native RenderFrameHost nativeGetMainFrame(long j);

    private native RenderFrameHost nativeGetFocusedFrame(long j);

    private native RenderWidgetHostViewImpl nativeGetRenderWidgetHostView(long j);

    private native String nativeGetTitle(long j);

    private native String nativeGetVisibleURL(long j);

    private native String nativeGetEncoding(long j);

    private native boolean nativeIsLoading(long j);

    private native boolean nativeIsLoadingToDifferentDocument(long j);

    private native void nativeStop(long j);

    private native void nativeCut(long j);

    private native void nativeCopy(long j);

    private native void nativePaste(long j);

    private native void nativePasteAsPlainText(long j);

    private native void nativeReplace(long j, String str);

    private native void nativeSelectAll(long j);

    private native void nativeCollapseSelection(long j);

    private native void nativeOnHide(long j);

    private native void nativeOnShow(long j);

    private native void nativeSetImportance(long j, int i);

    private native void nativeSuspendAllMediaPlayers(long j);

    private native void nativeSetAudioMuted(long j, boolean z);

    private native boolean nativeIsShowingInterstitialPage(long j);

    private native boolean nativeFocusLocationBarByDefault(long j);

    private native void nativeExitFullscreen(long j);

    private native void nativeScrollFocusedEditableNodeIntoView(long j);

    private native void nativeSelectWordAroundCaret(long j);

    private native void nativeAdjustSelectionByCharacterOffset(long j, int i, int i2, boolean z);

    private native String nativeGetLastCommittedURL(long j);

    private native boolean nativeIsIncognito(long j);

    private native void nativeResumeLoadingCreatedWebContents(long j);

    private native void nativeEvaluateJavaScript(long j, String str, JavaScriptCallback javaScriptCallback);

    private native void nativeEvaluateJavaScriptForTests(long j, String str, JavaScriptCallback javaScriptCallback);

    private native void nativeAddMessageToDevToolsConsole(long j, int i, String str);

    private native void nativePostMessageToMainFrame(long j, String str, String str2, String str3, MessagePort[] messagePortArr);

    private native boolean nativeHasAccessedInitialDocument(long j);

    private native int nativeGetThemeColor(long j);

    private native int nativeGetLoadProgress(long j);

    private native void nativeRequestSmartClipExtract(long j, SmartClipCallback smartClipCallback, int i, int i2, int i3, int i4);

    private native void nativeRequestAccessibilitySnapshot(long j, AccessibilitySnapshotCallback accessibilitySnapshotCallback);

    private native void nativeSetOverscrollRefreshHandler(long j, OverscrollRefreshHandler overscrollRefreshHandler);

    private native void nativeSetSpatialNavigationDisabled(long j, boolean z);

    private native void nativeReloadLoFiImages(long j);

    private native int nativeDownloadImage(long j, String str, boolean z, int i, boolean z2, ImageDownloadCallback imageDownloadCallback);

    private native void nativeSetHasPersistentVideo(long j, boolean z);

    private native boolean nativeHasActiveEffectivelyFullscreenVideo(long j);

    private native boolean nativeIsPictureInPictureAllowedForFullscreenVideo(long j);

    private native Rect nativeGetFullscreenVideoSize(long j);

    private native void nativeSetSize(long j, int i, int i2);

    private native int nativeGetWidth(long j);

    private native int nativeGetHeight(long j);

    private native EventForwarder nativeGetOrCreateEventForwarder(long j);

    private native void nativeSetViewAndroidDelegate(long j, ViewAndroidDelegate viewAndroidDelegate);

    private native void nativeSendOrientationChangeEvent(long j, int i);

    private native void nativeOnScaleFactorChanged(long j);

    private native void nativeSetFocus(long j, boolean z);

    private native void nativeSetDisplayCutoutSafeArea(long j, int i, int i2, int i3, int i4);

    private native void nativeNotifyRendererPreferenceUpdate(long j);

    private native boolean nativeIsBeingDestroyed(long j);

    static {
        $assertionsDisabled = !WebContentsImpl.class.desiredAssertionStatus();
        sParcelableUUID = UUID.randomUUID();
        CREATOR = new Parcelable.Creator<WebContents>() { // from class: org.chromium.content.browser.webcontents.WebContentsImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WebContents createFromParcel(Parcel source) {
                Bundle bundle = source.readBundle();
                if (bundle.getLong(WebContentsImpl.PARCEL_VERSION_KEY, -1L) != 0) {
                    return null;
                }
                ParcelUuid parcelUuid = (ParcelUuid) bundle.getParcelable(WebContentsImpl.PARCEL_PROCESS_GUARD_KEY);
                if (WebContentsImpl.sParcelableUUID.compareTo(parcelUuid.getUuid()) != 0) {
                    return null;
                }
                return WebContentsImpl.nativeFromNativePtr(bundle.getLong(WebContentsImpl.PARCEL_WEBCONTENTS_KEY));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WebContents[] newArray(int size) {
                return new WebContents[size];
            }
        };
    }

    @VisibleForTesting
    public static void invalidateSerializedWebContentsForTesting() {
        sParcelableUUID = UUID.randomUUID();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/webcontents/WebContentsImpl$SmartClipCallback.class */
    private class SmartClipCallback {
        final Handler mHandler;

        public SmartClipCallback(Handler smartClipHandler) {
            this.mHandler = smartClipHandler;
        }

        public void onSmartClipDataExtracted(String text, String html, Rect clipRect) {
            RenderCoordinatesImpl coordinateSpace = WebContentsImpl.this.getRenderCoordinates();
            clipRect.offset(0, (int) (coordinateSpace.getContentOffsetYPix() / coordinateSpace.getDeviceScaleFactor()));
            Bundle bundle = new Bundle();
            bundle.putString("url", WebContentsImpl.this.getVisibleUrl());
            bundle.putString("title", WebContentsImpl.this.getTitle());
            bundle.putString("text", text);
            bundle.putString("html", html);
            bundle.putParcelable("rect", clipRect);
            Message msg = Message.obtain(this.mHandler, 0);
            msg.setData(bundle);
            msg.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/webcontents/WebContentsImpl$WebContentsInternalsImpl.class */
    public static class WebContentsInternalsImpl implements WebContentsInternals {
        public UserDataHost userDataHost;
        public ViewAndroidDelegate viewAndroidDelegate;

        private WebContentsInternalsImpl() {
        }
    }

    private WebContentsImpl(long nativeWebContentsAndroid, NavigationController navigationController) {
        if (!$assertionsDisabled && nativeWebContentsAndroid == 0) {
            throw new AssertionError();
        }
        this.mNativeWebContentsAndroid = nativeWebContentsAndroid;
        this.mNavigationController = navigationController;
    }

    @CalledByNative
    private static WebContentsImpl create(long nativeWebContentsAndroid, NavigationController navigationController) {
        return new WebContentsImpl(nativeWebContentsAndroid, navigationController);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void initialize(String productVersion, ViewAndroidDelegate viewDelegate, ViewEventSink.InternalAccessDelegate accessDelegate, WindowAndroid windowAndroid, WebContents.InternalsHolder internalsHolder) {
        if (!$assertionsDisabled && this.mInitialized) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && internalsHolder == null) {
            throw new AssertionError();
        }
        this.mProductVersion = productVersion;
        this.mInternalsHolder = internalsHolder;
        WebContentsInternalsImpl internals = new WebContentsInternalsImpl();
        internals.userDataHost = new UserDataHost();
        this.mInternalsHolder.set(internals);
        this.mRenderCoordinates = new RenderCoordinatesImpl();
        this.mRenderCoordinates.reset();
        this.mInitialized = true;
        setViewAndroidDelegate(viewDelegate);
        setTopLevelNativeWindow(windowAndroid);
        ViewEventSinkImpl.from((WebContents) this).setAccessDelegate(accessDelegate);
        getRenderCoordinates().setDeviceScaleFactor(windowAndroid.getDisplay().getDipScale());
    }

    @Nullable
    public Context getContext() {
        if ($assertionsDisabled || this.mInitialized) {
            WindowAndroid window = getTopLevelNativeWindow();
            if (window != null) {
                return window.getContext().get();
            }
            return null;
        }
        throw new AssertionError();
    }

    public String getProductVersion() {
        if ($assertionsDisabled || this.mInitialized) {
            return this.mProductVersion;
        }
        throw new AssertionError();
    }

    @CalledByNative
    private void clearNativePtr() {
        this.mNativeDestroyThrowable = new RuntimeException("clearNativePtr");
        this.mNativeWebContentsAndroid = 0L;
        this.mNavigationController = null;
        if (this.mObserverProxy != null) {
            this.mObserverProxy.destroy();
            this.mObserverProxy = null;
        }
    }

    @Override // org.chromium.content.browser.framehost.RenderFrameHostDelegate
    public void renderFrameCreated(RenderFrameHostImpl host) {
        if (!$assertionsDisabled && this.mFrames.contains(host)) {
            throw new AssertionError();
        }
        this.mFrames.add(host);
    }

    @Override // org.chromium.content.browser.framehost.RenderFrameHostDelegate
    public void renderFrameDeleted(RenderFrameHostImpl host) {
        if (!$assertionsDisabled && !this.mFrames.contains(host)) {
            throw new AssertionError();
        }
        this.mFrames.remove(host);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Bundle data = new Bundle();
        data.putLong(PARCEL_VERSION_KEY, 0L);
        data.putParcelable(PARCEL_PROCESS_GUARD_KEY, new ParcelUuid(sParcelableUUID));
        data.putLong(PARCEL_WEBCONTENTS_KEY, this.mNativeWebContentsAndroid);
        dest.writeBundle(data);
    }

    @CalledByNative
    private long getNativePointer() {
        return this.mNativeWebContentsAndroid;
    }

    @Override // org.chromium.content_public.browser.WebContents
    public WindowAndroid getTopLevelNativeWindow() {
        checkNotDestroyed();
        return nativeGetTopLevelNativeWindow(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void setTopLevelNativeWindow(WindowAndroid windowAndroid) {
        checkNotDestroyed();
        nativeSetTopLevelNativeWindow(this.mNativeWebContentsAndroid, windowAndroid);
        WindowEventObserverManager.from(this).onWindowAndroidChanged(windowAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public ViewAndroidDelegate getViewAndroidDelegate() {
        WebContentsInternals internals = this.mInternalsHolder.get();
        if (internals == null) {
            return null;
        }
        return ((WebContentsInternalsImpl) internals).viewAndroidDelegate;
    }

    public void setViewAndroidDelegate(ViewAndroidDelegate viewDelegate) {
        checkNotDestroyed();
        WebContentsInternals internals = this.mInternalsHolder.get();
        if (!$assertionsDisabled && internals == null) {
            throw new AssertionError();
        }
        WebContentsInternalsImpl impl = (WebContentsInternalsImpl) internals;
        if (!$assertionsDisabled && impl.viewAndroidDelegate != null) {
            throw new AssertionError();
        }
        impl.viewAndroidDelegate = viewDelegate;
        nativeSetViewAndroidDelegate(this.mNativeWebContentsAndroid, viewDelegate);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void destroy() {
        if (!ThreadUtils.runningOnUiThread()) {
            throw new IllegalStateException("Attempting to destroy WebContents on non-UI thread");
        }
        if (this.mNativeWebContentsAndroid != 0) {
            nativeDestroyWebContents(this.mNativeWebContentsAndroid);
        }
    }

    @Override // org.chromium.content_public.browser.WebContents
    public boolean isDestroyed() {
        return this.mNativeWebContentsAndroid == 0 || nativeIsBeingDestroyed(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void clearNativeReference() {
        if (this.mNativeWebContentsAndroid != 0) {
            nativeClearNativeReference(this.mNativeWebContentsAndroid);
        }
    }

    @Override // org.chromium.content_public.browser.WebContents
    public NavigationController getNavigationController() {
        return this.mNavigationController;
    }

    @Override // org.chromium.content_public.browser.WebContents
    public RenderFrameHost getMainFrame() {
        checkNotDestroyed();
        return nativeGetMainFrame(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public RenderFrameHost getFocusedFrame() {
        checkNotDestroyed();
        return nativeGetFocusedFrame(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    @Nullable
    public RenderWidgetHostViewImpl getRenderWidgetHostView() {
        RenderWidgetHostViewImpl rwhvi;
        if (this.mNativeWebContentsAndroid == 0 || (rwhvi = nativeGetRenderWidgetHostView(this.mNativeWebContentsAndroid)) == null || rwhvi.isDestroyed()) {
            return null;
        }
        return rwhvi;
    }

    @Override // org.chromium.content_public.browser.WebContents
    public String getTitle() {
        checkNotDestroyed();
        return nativeGetTitle(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public String getVisibleUrl() {
        checkNotDestroyed();
        return nativeGetVisibleURL(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public String getEncoding() {
        checkNotDestroyed();
        return nativeGetEncoding(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public boolean isLoading() {
        checkNotDestroyed();
        return nativeIsLoading(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public boolean isLoadingToDifferentDocument() {
        checkNotDestroyed();
        return nativeIsLoadingToDifferentDocument(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void stop() {
        checkNotDestroyed();
        nativeStop(this.mNativeWebContentsAndroid);
    }

    public void cut() {
        checkNotDestroyed();
        nativeCut(this.mNativeWebContentsAndroid);
    }

    public void copy() {
        checkNotDestroyed();
        nativeCopy(this.mNativeWebContentsAndroid);
    }

    public void paste() {
        checkNotDestroyed();
        nativePaste(this.mNativeWebContentsAndroid);
    }

    public void pasteAsPlainText() {
        checkNotDestroyed();
        nativePasteAsPlainText(this.mNativeWebContentsAndroid);
    }

    public void replace(String word) {
        checkNotDestroyed();
        nativeReplace(this.mNativeWebContentsAndroid, word);
    }

    public void selectAll() {
        checkNotDestroyed();
        nativeSelectAll(this.mNativeWebContentsAndroid);
    }

    public void collapseSelection() {
        if (isDestroyed()) {
            return;
        }
        nativeCollapseSelection(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void onHide() {
        checkNotDestroyed();
        SelectionPopupControllerImpl controller = getSelectionPopupController();
        if (controller != null) {
            controller.hidePopupsAndPreserveSelection();
        }
        nativeOnHide(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void onShow() {
        checkNotDestroyed();
        WebContentsAccessibilityImpl wcax = WebContentsAccessibilityImpl.fromWebContents((WebContents) this);
        if (wcax != null) {
            wcax.refreshState();
        }
        SelectionPopupControllerImpl controller = getSelectionPopupController();
        if (controller != null) {
            controller.restoreSelectionPopupsIfNecessary();
        }
        nativeOnShow(this.mNativeWebContentsAndroid);
    }

    private SelectionPopupControllerImpl getSelectionPopupController() {
        return SelectionPopupControllerImpl.fromWebContents((WebContents) this);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void setImportance(int mainFrameImportance) {
        checkNotDestroyed();
        nativeSetImportance(this.mNativeWebContentsAndroid, mainFrameImportance);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void suspendAllMediaPlayers() {
        checkNotDestroyed();
        nativeSuspendAllMediaPlayers(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void setAudioMuted(boolean mute) {
        checkNotDestroyed();
        nativeSetAudioMuted(this.mNativeWebContentsAndroid, mute);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public boolean isShowingInterstitialPage() {
        checkNotDestroyed();
        return nativeIsShowingInterstitialPage(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public boolean focusLocationBarByDefault() {
        checkNotDestroyed();
        return nativeFocusLocationBarByDefault(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void exitFullscreen() {
        checkNotDestroyed();
        nativeExitFullscreen(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void scrollFocusedEditableNodeIntoView() {
        checkNotDestroyed();
        nativeScrollFocusedEditableNodeIntoView(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void selectWordAroundCaret() {
        checkNotDestroyed();
        nativeSelectWordAroundCaret(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void adjustSelectionByCharacterOffset(int startAdjust, int endAdjust, boolean showSelectionMenu) {
        nativeAdjustSelectionByCharacterOffset(this.mNativeWebContentsAndroid, startAdjust, endAdjust, showSelectionMenu);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public String getLastCommittedUrl() {
        checkNotDestroyed();
        return nativeGetLastCommittedURL(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public boolean isIncognito() {
        checkNotDestroyed();
        return nativeIsIncognito(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void resumeLoadingCreatedWebContents() {
        checkNotDestroyed();
        nativeResumeLoadingCreatedWebContents(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void evaluateJavaScript(String script, JavaScriptCallback callback) {
        ThreadUtils.assertOnUiThread();
        if (isDestroyed() || script == null) {
            return;
        }
        nativeEvaluateJavaScript(this.mNativeWebContentsAndroid, script, callback);
    }

    @Override // org.chromium.content_public.browser.WebContents
    @VisibleForTesting
    public void evaluateJavaScriptForTests(String script, JavaScriptCallback callback) {
        ThreadUtils.assertOnUiThread();
        if (script == null) {
            return;
        }
        checkNotDestroyed();
        nativeEvaluateJavaScriptForTests(this.mNativeWebContentsAndroid, script, callback);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void addMessageToDevToolsConsole(int level, String message) {
        checkNotDestroyed();
        nativeAddMessageToDevToolsConsole(this.mNativeWebContentsAndroid, level, message);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void postMessageToMainFrame(String message, String sourceOrigin, String targetOrigin, MessagePort[] ports) {
        if (ports != null) {
            for (MessagePort port : ports) {
                if (port.isClosed() || port.isTransferred()) {
                    throw new IllegalStateException("Port is already closed or transferred");
                }
                if (port.isStarted()) {
                    throw new IllegalStateException("Port is already started");
                }
            }
        }
        if (targetOrigin.equals("*")) {
            targetOrigin = CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
        }
        nativePostMessageToMainFrame(this.mNativeWebContentsAndroid, message, sourceOrigin, targetOrigin, ports);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public AppWebMessagePort[] createMessageChannel() throws IllegalStateException {
        return AppWebMessagePort.createPair();
    }

    @Override // org.chromium.content_public.browser.WebContents
    public boolean hasAccessedInitialDocument() {
        checkNotDestroyed();
        return nativeHasAccessedInitialDocument(this.mNativeWebContentsAndroid);
    }

    @CalledByNative
    private static void onEvaluateJavaScriptResult(String jsonResult, JavaScriptCallback callback) {
        callback.handleJavaScriptResult(jsonResult);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public int getThemeColor() {
        checkNotDestroyed();
        return nativeGetThemeColor(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public int getLoadProgress() {
        checkNotDestroyed();
        return nativeGetLoadProgress(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void requestSmartClipExtract(int x, int y, int width, int height) {
        if (this.mSmartClipCallback == null) {
            return;
        }
        checkNotDestroyed();
        RenderCoordinatesImpl coordinateSpace = getRenderCoordinates();
        float dpi = coordinateSpace.getDeviceScaleFactor();
        nativeRequestSmartClipExtract(this.mNativeWebContentsAndroid, this.mSmartClipCallback, (int) (x / dpi), (int) ((y - ((int) coordinateSpace.getContentOffsetYPix())) / dpi), (int) (width / dpi), (int) (height / dpi));
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void setSmartClipResultHandler(Handler smartClipHandler) {
        if (smartClipHandler == null) {
            this.mSmartClipCallback = null;
        } else {
            this.mSmartClipCallback = new SmartClipCallback(smartClipHandler);
        }
    }

    @CalledByNative
    private static void onSmartClipDataExtracted(String text, String html, int left, int top, int right, int bottom, SmartClipCallback callback) {
        callback.onSmartClipDataExtracted(text, html, new Rect(left, top, right, bottom));
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void requestAccessibilitySnapshot(AccessibilitySnapshotCallback callback) {
        checkNotDestroyed();
        nativeRequestAccessibilitySnapshot(this.mNativeWebContentsAndroid, callback);
    }

    @VisibleForTesting
    public void simulateRendererKilledForTesting(boolean wasOomProtected) {
        if (this.mObserverProxy != null) {
            this.mObserverProxy.renderProcessGone(wasOomProtected);
        }
    }

    @CalledByNative
    private static void onAccessibilitySnapshot(AccessibilitySnapshotNode root, AccessibilitySnapshotCallback callback) {
        callback.onAccessibilitySnapshot(root);
    }

    @CalledByNative
    private static void addAccessibilityNodeAsChild(AccessibilitySnapshotNode parent, AccessibilitySnapshotNode child) {
        parent.addChild(child);
    }

    @CalledByNative
    private static AccessibilitySnapshotNode createAccessibilitySnapshotNode(int parentRelativeLeft, int parentRelativeTop, int width, int height, boolean isRootNode, String text, int color, int bgcolor, float size, boolean bold, boolean italic, boolean underline, boolean lineThrough, String className) {
        AccessibilitySnapshotNode node = new AccessibilitySnapshotNode(text, className);
        if (size >= 0.0d) {
            node.setStyle(color, bgcolor, size, bold, italic, underline, lineThrough);
        }
        node.setLocationInfo(parentRelativeLeft, parentRelativeTop, width, height, isRootNode);
        return node;
    }

    @CalledByNative
    private static void setAccessibilitySnapshotSelection(AccessibilitySnapshotNode node, int start, int end) {
        node.setSelection(start, end);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public EventForwarder getEventForwarder() {
        if ($assertionsDisabled || this.mNativeWebContentsAndroid != 0) {
            if (this.mEventForwarder == null) {
                checkNotDestroyed();
                this.mEventForwarder = nativeGetOrCreateEventForwarder(this.mNativeWebContentsAndroid);
            }
            return this.mEventForwarder;
        }
        throw new AssertionError();
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void addObserver(WebContentsObserver observer) {
        if (!$assertionsDisabled && this.mNativeWebContentsAndroid == 0) {
            throw new AssertionError();
        }
        if (this.mObserverProxy == null) {
            this.mObserverProxy = new WebContentsObserverProxy(this);
        }
        this.mObserverProxy.addObserver(observer);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void removeObserver(WebContentsObserver observer) {
        if (this.mObserverProxy == null) {
            return;
        }
        this.mObserverProxy.removeObserver(observer);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void setOverscrollRefreshHandler(OverscrollRefreshHandler handler) {
        checkNotDestroyed();
        nativeSetOverscrollRefreshHandler(this.mNativeWebContentsAndroid, handler);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void setSpatialNavigationDisabled(boolean disabled) {
        checkNotDestroyed();
        nativeSetSpatialNavigationDisabled(this.mNativeWebContentsAndroid, disabled);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void reloadLoFiImages() {
        checkNotDestroyed();
        nativeReloadLoFiImages(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public int downloadImage(String url, boolean isFavicon, int maxBitmapSize, boolean bypassCache, ImageDownloadCallback callback) {
        checkNotDestroyed();
        return nativeDownloadImage(this.mNativeWebContentsAndroid, url, isFavicon, maxBitmapSize, bypassCache, callback);
    }

    @CalledByNative
    private void onDownloadImageFinished(ImageDownloadCallback callback, int id, int httpStatusCode, String imageUrl, List<Bitmap> bitmaps, List<Rect> sizes) {
        callback.onFinishDownloadImage(id, httpStatusCode, imageUrl, bitmaps, sizes);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void setHasPersistentVideo(boolean value) {
        checkNotDestroyed();
        nativeSetHasPersistentVideo(this.mNativeWebContentsAndroid, value);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public boolean hasActiveEffectivelyFullscreenVideo() {
        checkNotDestroyed();
        return nativeHasActiveEffectivelyFullscreenVideo(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public boolean isPictureInPictureAllowedForFullscreenVideo() {
        checkNotDestroyed();
        return nativeIsPictureInPictureAllowedForFullscreenVideo(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    @Nullable
    public Rect getFullscreenVideoSize() {
        checkNotDestroyed();
        return nativeGetFullscreenVideoSize(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void setSize(int width, int height) {
        checkNotDestroyed();
        nativeSetSize(this.mNativeWebContentsAndroid, width, height);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public int getWidth() {
        checkNotDestroyed();
        return nativeGetWidth(this.mNativeWebContentsAndroid);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public int getHeight() {
        checkNotDestroyed();
        return nativeGetHeight(this.mNativeWebContentsAndroid);
    }

    @CalledByNative
    private final void setMediaSession(MediaSessionImpl mediaSession) {
        this.mMediaSession = mediaSession;
    }

    @CalledByNative
    private static List<Bitmap> createBitmapList() {
        return new ArrayList();
    }

    @CalledByNative
    private static void addToBitmapList(List<Bitmap> bitmaps, Bitmap bitmap) {
        bitmaps.add(bitmap);
    }

    @CalledByNative
    private static List<Rect> createSizeList() {
        return new ArrayList();
    }

    @CalledByNative
    private static void createSizeAndAddToList(List<Rect> sizes, int width, int height) {
        sizes.add(new Rect(0, 0, width, height));
    }

    @CalledByNative
    private static Rect createSize(int width, int height) {
        return new Rect(0, 0, width, height);
    }

    public RenderCoordinatesImpl getRenderCoordinates() {
        return this.mRenderCoordinates;
    }

    public <T extends UserData> T getOrSetUserData(Class<T> key, UserDataFactory<T> userDataFactory) {
        if (this.mInitialized) {
            UserDataHost userDataHost = getUserDataHost();
            if (userDataHost == null) {
                Log.e(TAG, "UserDataHost can't be found", new Object[0]);
                return null;
            }
            UserData userData = userDataHost.getUserData(key);
            if (userData == null && userDataFactory != null) {
                if (!$assertionsDisabled && userDataHost.getUserData(key) != null) {
                    throw new AssertionError();
                }
                T object = userDataFactory.create(this);
                if (!$assertionsDisabled && !key.isInstance(object)) {
                    throw new AssertionError();
                }
                userData = userDataHost.setUserData(key, object);
            }
            return key.cast(userData);
        }
        return null;
    }

    private UserDataHost getUserDataHost() {
        WebContentsInternals internals;
        if (this.mInternalsHolder == null || (internals = this.mInternalsHolder.get()) == null) {
            return null;
        }
        return ((WebContentsInternalsImpl) internals).userDataHost;
    }

    @Override // org.chromium.ui.display.DisplayAndroid.DisplayAndroidObserver
    public void onRotationChanged(int rotation) {
        int rotationDegrees;
        if (this.mNativeWebContentsAndroid == 0) {
            return;
        }
        switch (rotation) {
            case 0:
                rotationDegrees = 0;
                break;
            case 1:
                rotationDegrees = 90;
                break;
            case 2:
                rotationDegrees = 180;
                break;
            case 3:
                rotationDegrees = -90;
                break;
            default:
                throw new IllegalStateException("Display.getRotation() shouldn't return that value");
        }
        nativeSendOrientationChangeEvent(this.mNativeWebContentsAndroid, rotationDegrees);
    }

    @Override // org.chromium.ui.display.DisplayAndroid.DisplayAndroidObserver
    public void onDIPScaleChanged(float dipScale) {
        if (this.mNativeWebContentsAndroid == 0) {
            return;
        }
        this.mRenderCoordinates.setDeviceScaleFactor(dipScale);
        nativeOnScaleFactorChanged(this.mNativeWebContentsAndroid);
    }

    public void setFocus(boolean hasFocus) {
        if (this.mNativeWebContentsAndroid == 0) {
            return;
        }
        nativeSetFocus(this.mNativeWebContentsAndroid, hasFocus);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void setDisplayCutoutSafeArea(Rect insets) {
        if (this.mNativeWebContentsAndroid == 0) {
            return;
        }
        nativeSetDisplayCutoutSafeArea(this.mNativeWebContentsAndroid, insets.top, insets.left, insets.bottom, insets.right);
    }

    @Override // org.chromium.content_public.browser.WebContents
    public void notifyRendererPreferenceUpdate() {
        if (this.mNativeWebContentsAndroid == 0) {
            return;
        }
        nativeNotifyRendererPreferenceUpdate(this.mNativeWebContentsAndroid);
    }

    private void checkNotDestroyed() {
        if (this.mNativeWebContentsAndroid == 0) {
            throw new IllegalStateException("Native WebContents already destroyed", this.mNativeDestroyThrowable);
        }
    }
}
