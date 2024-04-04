package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PushRegistrationStatus.class */
public final class PushRegistrationStatus {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SUCCESS_FROM_PUSH_SERVICE = 0;
    public static final int NO_SERVICE_WORKER = 1;
    public static final int SERVICE_NOT_AVAILABLE = 2;
    public static final int LIMIT_REACHED = 3;
    public static final int PERMISSION_DENIED = 4;
    public static final int SERVICE_ERROR = 5;
    public static final int NO_SENDER_ID = 6;
    public static final int STORAGE_ERROR = 7;
    public static final int SUCCESS_FROM_CACHE = 8;
    public static final int NETWORK_ERROR = 9;
    public static final int INCOGNITO_PERMISSION_DENIED = 10;
    public static final int PUBLIC_KEY_UNAVAILABLE = 11;
    public static final int MANIFEST_EMPTY_OR_MISSING = 12;
    public static final int SENDER_ID_MISMATCH = 13;
    public static final int STORAGE_CORRUPT = 14;
    public static final int RENDERER_SHUTDOWN = 15;
    public static final int SUCCESS_NEW_SUBSCRIPTION_FROM_PUSH_SERVICE = 16;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 16;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PushRegistrationStatus() {
    }
}
