package org.chromium.blink.test.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/ClientToAuthenticatorProtocol.class */
public final class ClientToAuthenticatorProtocol {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int U2F = 0;
    public static final int CTAP2 = 1;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ClientToAuthenticatorProtocol() {
    }
}
