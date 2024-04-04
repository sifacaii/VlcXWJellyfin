package org.chromium.content_public.browser;

import org.chromium.content.browser.ContentViewStaticsImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ContentViewStatics.class */
public class ContentViewStatics {
    public static void setWebKitSharedTimersSuspended(boolean suspend) {
        ContentViewStaticsImpl.setWebKitSharedTimersSuspended(suspend);
    }

    public static void enablePlatformNotifications() {
        ContentViewStaticsImpl.enablePlatformNotifications();
    }

    public static void disablePlatformNotifications() {
        ContentViewStaticsImpl.disablePlatformNotifications();
    }
}
