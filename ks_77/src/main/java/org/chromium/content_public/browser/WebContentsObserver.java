package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/WebContentsObserver.class */
public abstract class WebContentsObserver {
    protected WeakReference<WebContents> mWebContents;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/WebContentsObserver$ViewportFitType.class */
    public @interface ViewportFitType {
    }

    public WebContentsObserver(WebContents webContents) {
        this.mWebContents = new WeakReference<>(webContents);
        webContents.addObserver(this);
    }

    public void renderViewReady() {
    }

    public void renderProcessGone(boolean wasOomProtected) {
    }

    public void didStartNavigation(NavigationHandle navigationHandle) {
    }

    public void didRedirectNavigation(NavigationHandle navigationHandle) {
    }

    public void didFinishNavigation(NavigationHandle navigationHandle) {
    }

    public void didStartLoading(String url) {
    }

    public void didStopLoading(String url) {
    }

    public void didFailLoad(boolean isMainFrame, int errorCode, String description, String failingUrl) {
    }

    public void didFirstVisuallyNonEmptyPaint() {
    }

    public void wasShown() {
    }

    public void wasHidden() {
    }

    public void titleWasSet(String title) {
    }

    public void documentAvailableInMainFrame() {
    }

    public void didFinishLoad(long frameId, String validatedUrl, boolean isMainFrame) {
    }

    public void documentLoadedInFrame(long frameId, boolean isMainFrame) {
    }

    public void navigationEntryCommitted() {
    }

    public void navigationEntriesDeleted() {
    }

    public void navigationEntriesChanged() {
    }

    public void didAttachInterstitialPage() {
    }

    public void didDetachInterstitialPage() {
    }

    public void didChangeThemeColor(int color) {
    }

    public void hasEffectivelyFullscreenVideoChange(boolean isFullscreen) {
    }

    public void viewportFitChanged(int value) {
    }

    public void didReloadLoFiImages() {
    }

    public void onWebContentsFocused() {
    }

    public void onWebContentsLostFocus() {
    }

    public void destroy() {
        if (this.mWebContents == null) {
            return;
        }
        WebContents webContents = this.mWebContents.get();
        this.mWebContents = null;
        if (webContents == null) {
            return;
        }
        webContents.removeObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WebContentsObserver() {
    }
}
