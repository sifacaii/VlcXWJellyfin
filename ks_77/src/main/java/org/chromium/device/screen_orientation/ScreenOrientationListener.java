package org.chromium.device.screen_orientation;

import android.provider.Settings;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.device.mojom.ConstantsConstants;

@JNINamespace(ConstantsConstants.SERVICE_NAME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/screen_orientation/ScreenOrientationListener.class */
class ScreenOrientationListener {
    ScreenOrientationListener() {
    }

    @CalledByNative
    static boolean isAutoRotateEnabledByUser() {
        return Settings.System.getInt(ContextUtils.getApplicationContext().getContentResolver(), "accelerometer_rotation", 0) == 1;
    }
}
