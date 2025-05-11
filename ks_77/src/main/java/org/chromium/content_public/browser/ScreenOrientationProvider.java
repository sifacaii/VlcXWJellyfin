package org.chromium.content_public.browser;

import androidx.annotation.Nullable;
import org.chromium.content.browser.ScreenOrientationProviderImpl;
import org.chromium.ui.base.WindowAndroid;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ScreenOrientationProvider.class */
public interface ScreenOrientationProvider {
    void lockOrientation(@Nullable WindowAndroid windowAndroid, byte b);

    void unlockOrientation(@Nullable WindowAndroid windowAndroid);

    void delayOrientationRequests(WindowAndroid windowAndroid);

    void runDelayedOrientationRequests(WindowAndroid windowAndroid);

    void setOrientationDelegate(ScreenOrientationDelegate screenOrientationDelegate);

    static ScreenOrientationProvider getInstance() {
        return ScreenOrientationProviderImpl.getInstance();
    }
}
