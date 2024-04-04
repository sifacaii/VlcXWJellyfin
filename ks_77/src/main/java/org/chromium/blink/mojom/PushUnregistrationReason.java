package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PushUnregistrationReason.class */
public final class PushUnregistrationReason {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int UNKNOWN = 0;
    public static final int JAVASCRIPT_API = 1;
    public static final int PERMISSION_REVOKED = 2;
    public static final int DELIVERY_UNKNOWN_APP_ID = 3;
    public static final int DELIVERY_PERMISSION_DENIED = 4;
    public static final int DELIVERY_NO_SERVICE_WORKER = 5;
    public static final int GCM_STORE_RESET = 6;
    public static final int SERVICE_WORKER_UNREGISTERED = 7;
    public static final int SUBSCRIBE_STORAGE_CORRUPT = 8;
    public static final int GET_SUBSCRIPTION_STORAGE_CORRUPT = 9;
    public static final int SERVICE_WORKER_DATABASE_WIPED = 10;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 10;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PushUnregistrationReason() {
    }
}
