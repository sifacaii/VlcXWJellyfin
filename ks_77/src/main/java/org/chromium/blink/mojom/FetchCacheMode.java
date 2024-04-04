package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FetchCacheMode.class */
public final class FetchCacheMode {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int DEFAULT = 0;
    public static final int NO_STORE = 1;
    public static final int BYPASS_CACHE = 2;
    public static final int VALIDATE_CACHE = 3;
    public static final int FORCE_CACHE = 4;
    public static final int ONLY_IF_CACHED = 5;
    public static final int UNSPECIFIED_ONLY_IF_CACHED_STRICT = 6;
    public static final int UNSPECIFIED_FORCE_CACHE_MISS = 7;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 7;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private FetchCacheMode() {
    }
}
