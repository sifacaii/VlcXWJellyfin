package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentComplete.class */
public final class PaymentComplete {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int FAIL = 0;
    public static final int SUCCESS = 1;
    public static final int UNKNOWN = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PaymentComplete() {
    }
}
