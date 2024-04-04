package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/KeyboardLockRequestResult.class */
public final class KeyboardLockRequestResult {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SUCCESS = 0;
    public static final int FRAME_DETACHED_ERROR = 1;
    public static final int NO_VALID_KEY_CODES_ERROR = 2;
    public static final int CHILD_FRAME_ERROR = 3;
    public static final int REQUEST_FAILED_ERROR = 4;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private KeyboardLockRequestResult() {
    }
}
