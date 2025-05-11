package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/HashAlgorithm.class */
public final class HashAlgorithm {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int HASH_ALGO_NONE = 0;
    public static final int HASH_ALGO_MD5 = 1;
    public static final int HASH_ALGO_SHA1 = 2;
    public static final int HASH_ALGO_SHA224 = 3;
    public static final int HASH_ALGO_SHA256 = 4;
    public static final int HASH_ALGO_SHA384 = 5;
    public static final int HASH_ALGO_SHA512 = 6;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 6;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private HashAlgorithm() {
    }
}
