package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/NfcErrorType.class */
public final class NfcErrorType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int NOT_ALLOWED = 0;
    public static final int NOT_SUPPORTED = 1;
    public static final int NOT_READABLE = 2;
    public static final int NOT_FOUND = 3;
    public static final int INVALID_MESSAGE = 4;
    public static final int OPERATION_CANCELLED = 5;
    public static final int TIMER_EXPIRED = 6;
    public static final int CANNOT_CANCEL = 7;
    public static final int IO_ERROR = 8;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 8;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private NfcErrorType() {
    }
}
