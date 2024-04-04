package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MhtmlLoadResult.class */
public final class MhtmlLoadResult {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SUCCESS = 0;
    public static final int EMPTY_FILE = 1;
    public static final int URL_SCHEME_NOT_ALLOWED = 2;
    public static final int INVALID_ARCHIVE = 3;
    public static final int MISSING_MAIN_RESOURCE = 4;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private MhtmlLoadResult() {
    }
}
