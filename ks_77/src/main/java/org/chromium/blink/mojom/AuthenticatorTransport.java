package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AuthenticatorTransport.class */
public final class AuthenticatorTransport {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int USB = 0;
    public static final int NFC = 1;
    public static final int BLE = 2;
    public static final int CABLE = 3;
    public static final int INTERNAL = 4;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private AuthenticatorTransport() {
    }
}
