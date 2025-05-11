package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SignatureAlgorithm.class */
public final class SignatureAlgorithm {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SIG_ALGO_ANONYMOUS = 0;
    public static final int SIG_ALGO_RSA = 1;
    public static final int SIG_ALGO_DSA = 2;
    public static final int SIG_ALGO_ECDSA = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private SignatureAlgorithm() {
    }
}
