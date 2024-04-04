package org.chromium.content_public.browser;

import android.app.Activity;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ScreenOrientationDelegate.class */
public interface ScreenOrientationDelegate {
    boolean canUnlockOrientation(Activity activity, int i);

    boolean canLockOrientation();
}
