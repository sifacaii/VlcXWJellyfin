package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PushErrorType.class */
public final class PushErrorType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int ABORT = 0;
    public static final int NETWORK = 1;
    public static final int NONE = 2;
    public static final int NOT_ALLOWED = 3;
    public static final int NOT_FOUND = 4;
    public static final int NOT_SUPPORTED = 5;
    public static final int INVALID_STATE = 6;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 6;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PushErrorType() {
    }
}
