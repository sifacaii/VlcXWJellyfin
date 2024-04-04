package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerStatus.class */
public final class PaymentHandlerStatus {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SUCCESS = 0;
    public static final int NOT_FOUND = 1;
    public static final int NO_ACTIVE_WORKER = 2;
    public static final int STORAGE_OPERATION_FAILED = 3;
    public static final int FETCH_INSTRUMENT_ICON_FAILED = 4;
    public static final int FETCH_PAYMENT_APP_INFO_FAILED = 5;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 5;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PaymentHandlerStatus() {
    }
}
