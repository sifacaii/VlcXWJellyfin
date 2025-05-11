package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AuthenticatorAttachment.class */
public final class AuthenticatorAttachment {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int NO_PREFERENCE = 0;
    public static final int PLATFORM = 1;
    public static final int CROSS_PLATFORM = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private AuthenticatorAttachment() {
    }
}
