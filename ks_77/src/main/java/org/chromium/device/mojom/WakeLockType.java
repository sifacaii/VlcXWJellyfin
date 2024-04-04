package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLockType.class */
public final class WakeLockType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int PREVENT_APP_SUSPENSION = 0;
    public static final int PREVENT_DISPLAY_SLEEP = 1;
    public static final int PREVENT_DISPLAY_SLEEP_ALLOW_DIMMING = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private WakeLockType() {
    }
}
