package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerResponseError.class */
public final class ServiceWorkerResponseError {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int UNKNOWN = 0;
    public static final int PROMISE_REJECTED = 1;
    public static final int DEFAULT_PREVENTED = 2;
    public static final int NO_V8_INSTANCE = 3;
    public static final int RESPONSE_TYPE_ERROR = 4;
    public static final int RESPONSE_TYPE_OPAQUE = 5;
    public static final int RESPONSE_TYPE_NOT_BASIC_OR_DEFAULT = 6;
    public static final int BODY_USED = 7;
    public static final int RESPONSE_TYPE_OPAQUE_FOR_CLIENT_REQUEST = 8;
    public static final int RESPONSE_TYPE_OPAQUE_REDIRECT = 9;
    public static final int BODY_LOCKED = 10;
    public static final int REDIRECTED_RESPONSE_FOR_NOT_FOLLOW_REQUEST = 14;
    public static final int DATA_PIPE_CREATION_FAILED = 15;
    public static final int RESPONSE_TYPE_CORS_FOR_REQUEST_MODE_SAME_ORIGIN = 16;
    public static final int RESPONSE_BODY_BROKEN = 17;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 14:
            case 15:
            case 16:
            case 17:
                return true;
            case 11:
            case 12:
            case 13:
            default:
                return false;
        }
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ServiceWorkerResponseError() {
    }
}
