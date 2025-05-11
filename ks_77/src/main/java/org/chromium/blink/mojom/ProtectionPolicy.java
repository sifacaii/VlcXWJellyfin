package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ProtectionPolicy.class */
public final class ProtectionPolicy {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int UNSPECIFIED = 0;
    public static final int NONE = 1;
    public static final int UV_OR_CRED_ID_REQUIRED = 2;
    public static final int UV_REQUIRED = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ProtectionPolicy() {
    }
}
