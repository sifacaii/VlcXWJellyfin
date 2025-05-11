package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbOpenDeviceError.class */
public final class UsbOpenDeviceError {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int OK = 0;
    public static final int ACCESS_DENIED = 1;
    public static final int ALREADY_OPEN = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private UsbOpenDeviceError() {
    }
}
