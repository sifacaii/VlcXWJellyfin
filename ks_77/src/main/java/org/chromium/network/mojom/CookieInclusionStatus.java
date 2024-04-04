package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieInclusionStatus.class */
public final class CookieInclusionStatus {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int INCLUDE = 0;
    public static final int EXCLUDE_HTTP_ONLY = 1;
    public static final int EXCLUDE_SECURE_ONLY = 2;
    public static final int EXCLUDE_DOMAIN_MISMATCH = 3;
    public static final int EXCLUDE_NOT_ON_PATH = 4;
    public static final int EXCLUDE_SAMESITE_STRICT = 5;
    public static final int EXCLUDE_SAMESITE_LAX = 6;
    public static final int EXCLUDE_SAMESITE_EXTENDED = 7;
    public static final int EXCLUDE_SAMESITE_UNSPECIFIED_TREATED_AS_LAX = 8;
    public static final int EXCLUDE_SAMESITE_NONE_INSECURE = 9;
    public static final int EXCLUDE_USER_PREFERENCES = 10;
    public static final int EXCLUDE_FAILURE_TO_STORE = 11;
    public static final int EXCLUDE_NONCOOKIEABLE_SCHEME = 12;
    public static final int EXCLUDE_OVERWRITE_SECURE = 13;
    public static final int EXCLUDE_OVERWRITE_HTTP_ONLY = 14;
    public static final int EXCLUDE_INVALID_DOMAIN = 15;
    public static final int EXCLUDE_INVALID_PREFIX = 16;
    public static final int EXCLUDE_UNKNOWN_ERROR = 17;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 17;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private CookieInclusionStatus() {
    }
}
