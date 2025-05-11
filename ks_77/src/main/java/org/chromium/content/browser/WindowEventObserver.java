package org.chromium.content.browser;

import android.content.res.Configuration;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.ui.display.DisplayAndroid;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/WindowEventObserver.class */
public interface WindowEventObserver extends DisplayAndroid.DisplayAndroidObserver {
    default void onAttachedToWindow() {
    }

    default void onDetachedFromWindow() {
    }

    default void onWindowFocusChanged(boolean gainFocus) {
    }

    default void onWindowAndroidChanged(WindowAndroid newWindowAndroid) {
    }

    default void onConfigurationChanged(Configuration newConfig) {
    }

    default void onViewFocusChanged(boolean gainFocus, boolean hideKeyboardOnBlur) {
    }
}
