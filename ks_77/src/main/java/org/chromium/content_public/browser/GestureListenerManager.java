package org.chromium.content_public.browser;

import org.chromium.content.browser.GestureListenerManagerImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/GestureListenerManager.class */
public interface GestureListenerManager {
    void addListener(GestureStateListener gestureStateListener);

    void removeListener(GestureStateListener gestureStateListener);

    boolean isScrollInProgress();

    void updateMultiTouchZoomSupport(boolean z);

    void updateDoubleTapSupport(boolean z);

    static GestureListenerManager fromWebContents(WebContents webContents) {
        return GestureListenerManagerImpl.fromWebContents(webContents);
    }
}
