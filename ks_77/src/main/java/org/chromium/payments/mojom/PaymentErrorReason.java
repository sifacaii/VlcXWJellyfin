package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentErrorReason.class */
public final class PaymentErrorReason {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int UNKNOWN = 0;
    public static final int USER_CANCEL = 1;
    public static final int NOT_SUPPORTED = 2;
    public static final int ALREADY_SHOWING = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PaymentErrorReason() {
    }
}
