package org.chromium.content_public.browser;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.chromium.base.VisibleForTesting;
import org.chromium.content_public.browser.ViewEventSink;
import org.chromium.ui.OverscrollRefreshHandler;
import org.chromium.ui.base.EventForwarder;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/WebContents.class */
public interface WebContents extends Parcelable {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/WebContents$InternalsHolder.class */
    public interface InternalsHolder {
        void set(WebContentsInternals webContentsInternals);

        WebContentsInternals get();
    }

    void initialize(String str, ViewAndroidDelegate viewAndroidDelegate, ViewEventSink.InternalAccessDelegate internalAccessDelegate, WindowAndroid windowAndroid, @NonNull InternalsHolder internalsHolder);

    @Nullable
    WindowAndroid getTopLevelNativeWindow();

    void setTopLevelNativeWindow(WindowAndroid windowAndroid);

    @Nullable
    ViewAndroidDelegate getViewAndroidDelegate();

    void destroy();

    boolean isDestroyed();

    void clearNativeReference();

    NavigationController getNavigationController();

    RenderFrameHost getMainFrame();

    @Nullable
    RenderFrameHost getFocusedFrame();

    @Nullable
    RenderWidgetHostView getRenderWidgetHostView();

    String getTitle();

    String getVisibleUrl();

    String getEncoding();

    boolean isLoading();

    boolean isLoadingToDifferentDocument();

    void stop();

    void onHide();

    void onShow();

    void setImportance(int i);

    void suspendAllMediaPlayers();

    void setAudioMuted(boolean z);

    boolean isShowingInterstitialPage();

    boolean focusLocationBarByDefault();

    void exitFullscreen();

    void scrollFocusedEditableNodeIntoView();

    void selectWordAroundCaret();

    void adjustSelectionByCharacterOffset(int i, int i2, boolean z);

    String getLastCommittedUrl();

    boolean isIncognito();

    void resumeLoadingCreatedWebContents();

    void evaluateJavaScript(String str, @Nullable JavaScriptCallback javaScriptCallback);

    @VisibleForTesting
    void evaluateJavaScriptForTests(String str, @Nullable JavaScriptCallback javaScriptCallback);

    void addMessageToDevToolsConsole(int i, String str);

    void postMessageToMainFrame(String str, String str2, String str3, @Nullable MessagePort[] messagePortArr);

    MessagePort[] createMessageChannel();

    boolean hasAccessedInitialDocument();

    int getThemeColor();

    int getLoadProgress();

    void requestSmartClipExtract(int i, int i2, int i3, int i4);

    void setSmartClipResultHandler(Handler handler);

    void requestAccessibilitySnapshot(AccessibilitySnapshotCallback accessibilitySnapshotCallback);

    EventForwarder getEventForwarder();

    void addObserver(WebContentsObserver webContentsObserver);

    void removeObserver(WebContentsObserver webContentsObserver);

    void setOverscrollRefreshHandler(OverscrollRefreshHandler overscrollRefreshHandler);

    void setSpatialNavigationDisabled(boolean z);

    void reloadLoFiImages();

    int downloadImage(String str, boolean z, int i, boolean z2, ImageDownloadCallback imageDownloadCallback);

    boolean hasActiveEffectivelyFullscreenVideo();

    boolean isPictureInPictureAllowedForFullscreenVideo();

    @Nullable
    Rect getFullscreenVideoSize();

    void setHasPersistentVideo(boolean z);

    void setSize(int i, int i2);

    int getWidth();

    int getHeight();

    void setDisplayCutoutSafeArea(Rect rect);

    void notifyRendererPreferenceUpdate();

    static InternalsHolder createDefaultInternalsHolder() {
        return new InternalsHolder() { // from class: org.chromium.content_public.browser.WebContents.1
            private WebContentsInternals mInternals;

            @Override // org.chromium.content_public.browser.WebContents.InternalsHolder
            public void set(WebContentsInternals internals) {
                this.mInternals = internals;
            }

            @Override // org.chromium.content_public.browser.WebContents.InternalsHolder
            public WebContentsInternals get() {
                return this.mInternals;
            }
        };
    }
}
