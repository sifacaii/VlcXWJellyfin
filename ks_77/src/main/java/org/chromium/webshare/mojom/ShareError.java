package org.chromium.webshare.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/webshare/mojom/ShareError.class */
public final class ShareError {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int OK = 0;
    public static final int INTERNAL_ERROR = 1;
    public static final int PERMISSION_DENIED = 2;
    public static final int CANCELED = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ShareError() {
    }
}
