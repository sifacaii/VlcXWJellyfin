package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AuthenticatorStatus.class */
public final class AuthenticatorStatus {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SUCCESS = 0;
    public static final int PENDING_REQUEST = 1;
    public static final int NOT_ALLOWED_ERROR = 2;
    public static final int INVALID_DOMAIN = 3;
    public static final int INVALID_ICON_URL = 4;
    public static final int CREDENTIAL_EXCLUDED = 5;
    public static final int CREDENTIAL_NOT_RECOGNIZED = 6;
    public static final int NOT_IMPLEMENTED = 7;
    public static final int NOT_FOCUSED = 8;
    public static final int RESIDENT_CREDENTIALS_UNSUPPORTED = 9;
    public static final int USER_VERIFICATION_UNSUPPORTED = 10;
    public static final int ALGORITHM_UNSUPPORTED = 11;
    public static final int EMPTY_ALLOW_CREDENTIALS = 12;
    public static final int ANDROID_NOT_SUPPORTED_ERROR = 13;
    public static final int PROTECTION_POLICY_INCONSISTENT = 14;
    public static final int ABORT_ERROR = 15;
    public static final int UNKNOWN_ERROR = 16;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 16;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private AuthenticatorStatus() {
    }
}
