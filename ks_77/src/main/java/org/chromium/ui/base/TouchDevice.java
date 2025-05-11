package org.chromium.ui.base;

import android.view.InputDevice;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("ui")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/base/TouchDevice.class */
public class TouchDevice {
    private TouchDevice() {
    }

    @CalledByNative
    private static int maxTouchPoints() {
        if (ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.jazzhand")) {
            return 5;
        }
        if (ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct") || ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch")) {
            return 2;
        }
        if (ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen")) {
            return 1;
        }
        return 0;
    }

    @CalledByNative
    private static int[] availablePointerAndHoverTypes() {
        int[] deviceIds;
        int[] result = {0, 0};
        for (int deviceId : InputDevice.getDeviceIds()) {
            InputDevice inputDevice = null;
            try {
                inputDevice = InputDevice.getDevice(deviceId);
            } catch (RuntimeException e) {
            }
            if (inputDevice != null) {
                int sources = inputDevice.getSources();
                if (hasSource(sources, 8194) || hasSource(sources, 16386) || hasSource(sources, 1048584) || hasSource(sources, 65540)) {
                    result[0] = result[0] | 4;
                } else if (hasSource(sources, 4098)) {
                    result[0] = result[0] | 2;
                }
                if (hasSource(sources, 8194) || hasSource(sources, 1048584) || hasSource(sources, 65540)) {
                    result[1] = result[1] | 2;
                }
            }
        }
        if (result[0] == 0) {
            result[0] = 1;
        }
        if (result[1] == 0) {
            result[1] = 1;
        }
        return result;
    }

    private static boolean hasSource(int sources, int inputDeviceSource) {
        return (sources & inputDeviceSource) == inputDeviceSource;
    }
}
