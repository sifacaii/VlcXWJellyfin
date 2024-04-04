package org.chromium.content.browser;

import org.chromium.net.ProxyChangeListener;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ContentViewStaticsImpl.class */
public class ContentViewStaticsImpl {
    private static native void nativeSetWebKitSharedTimersSuspended(boolean z);

    public static void setWebKitSharedTimersSuspended(boolean suspend) {
        nativeSetWebKitSharedTimersSuspended(suspend);
    }

    public static void enablePlatformNotifications() {
        ProxyChangeListener.setEnabled(true);
    }

    public static void disablePlatformNotifications() {
        ProxyChangeListener.setEnabled(false);
    }
}
