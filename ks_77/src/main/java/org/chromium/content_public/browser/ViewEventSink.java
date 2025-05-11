package org.chromium.content_public.browser;

import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.MotionEvent;
import org.chromium.content.browser.ViewEventSinkImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ViewEventSink.class */
public interface ViewEventSink {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ViewEventSink$InternalAccessDelegate.class */
    public interface InternalAccessDelegate {
        boolean super_onKeyUp(int i, KeyEvent keyEvent);

        boolean super_dispatchKeyEvent(KeyEvent keyEvent);

        boolean super_onGenericMotionEvent(MotionEvent motionEvent);

        void onScrollChanged(int i, int i2, int i3, int i4);
    }

    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onWindowFocusChanged(boolean z);

    void onViewFocusChanged(boolean z);

    void setHideKeyboardOnBlur(boolean z);

    void onConfigurationChanged(Configuration configuration);

    void setAccessDelegate(InternalAccessDelegate internalAccessDelegate);

    void onPauseForTesting();

    void onResumeForTesting();

    static ViewEventSink from(WebContents webContents) {
        return ViewEventSinkImpl.from(webContents);
    }
}
