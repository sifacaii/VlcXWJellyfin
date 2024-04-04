package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/ScreenOrientationLockType.class */
public final class ScreenOrientationLockType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int DEFAULT = 0;
    public static final int PORTRAIT_PRIMARY = 1;
    public static final int PORTRAIT_SECONDARY = 2;
    public static final int LANDSCAPE_PRIMARY = 3;
    public static final int LANDSCAPE_SECONDARY = 4;
    public static final int ANY = 5;
    public static final int LANDSCAPE = 6;
    public static final int PORTRAIT = 7;
    public static final int NATURAL = 8;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 8;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ScreenOrientationLockType() {
    }
}
