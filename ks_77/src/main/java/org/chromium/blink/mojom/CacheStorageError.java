package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CacheStorageError.class */
public final class CacheStorageError {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SUCCESS = 0;
    public static final int ERROR_EXISTS = 1;
    public static final int ERROR_STORAGE = 2;
    public static final int ERROR_NOT_FOUND = 3;
    public static final int ERROR_QUOTA_EXCEEDED = 4;
    public static final int ERROR_CACHE_NAME_NOT_FOUND = 5;
    public static final int ERROR_QUERY_TOO_LARGE = 6;
    public static final int ERROR_NOT_IMPLEMENTED = 7;
    public static final int ERROR_DUPLICATE_OPERATION = 8;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 8;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private CacheStorageError() {
    }
}
