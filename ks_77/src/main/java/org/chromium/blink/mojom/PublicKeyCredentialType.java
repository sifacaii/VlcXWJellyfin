package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PublicKeyCredentialType.class */
public final class PublicKeyCredentialType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int PUBLIC_KEY = 0;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 0;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PublicKeyCredentialType() {
    }
}
