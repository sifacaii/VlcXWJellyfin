package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ScreenAvailability.class */
public final class ScreenAvailability {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int UNKNOWN = 0;
    public static final int UNAVAILABLE = 1;
    public static final int SOURCE_NOT_SUPPORTED = 2;
    public static final int DISABLED = 3;
    public static final int AVAILABLE = 4;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ScreenAvailability() {
    }
}
