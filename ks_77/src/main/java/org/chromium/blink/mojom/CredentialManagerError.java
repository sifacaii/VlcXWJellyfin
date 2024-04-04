package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/CredentialManagerError.class */
public final class CredentialManagerError {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SUCCESS = 0;
    public static final int PENDING_REQUEST = 1;
    public static final int PASSWORD_STORE_UNAVAILABLE = 2;
    public static final int NOT_ALLOWED = 3;
    public static final int INVALID_DOMAIN = 4;
    public static final int INVALID_ICON_URL = 5;
    public static final int CREDENTIAL_EXCLUDED = 6;
    public static final int CREDENTIAL_NOT_RECOGNIZED = 7;
    public static final int NOT_IMPLEMENTED = 8;
    public static final int NOT_FOCUSED = 9;
    public static final int RESIDENT_CREDENTIALS_UNSUPPORTED = 10;
    public static final int PROTECTION_POLICY_INCONSISTENT = 11;
    public static final int ANDROID_ALGORITHM_UNSUPPORTED = 12;
    public static final int ANDROID_EMPTY_ALLOW_CREDENTIALS = 13;
    public static final int ANDROID_NOT_SUPPORTED_ERROR = 14;
    public static final int ANDROID_USER_VERIFICATION_UNSUPPORTED = 15;
    public static final int ABORT = 16;
    public static final int UNKNOWN = 17;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 17;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private CredentialManagerError() {
    }
}
