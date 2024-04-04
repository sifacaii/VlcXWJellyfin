package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PushGetRegistrationStatus.class */
public final class PushGetRegistrationStatus {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SUCCESS = 0;
    public static final int SERVICE_NOT_AVAILABLE = 1;
    public static final int STORAGE_ERROR = 2;
    public static final int REGISTRATION_NOT_FOUND = 3;
    public static final int INCOGNITO_REGISTRATION_NOT_FOUND = 4;
    public static final int STORAGE_CORRUPT = 6;
    public static final int RENDERER_SHUTDOWN = 7;
    public static final int NO_LIVE_SERVICE_WORKER = 8;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
                return true;
            case 5:
            default:
                return false;
        }
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PushGetRegistrationStatus() {
    }
}
