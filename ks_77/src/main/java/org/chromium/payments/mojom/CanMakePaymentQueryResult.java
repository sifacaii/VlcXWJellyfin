package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/CanMakePaymentQueryResult.class */
public final class CanMakePaymentQueryResult {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int CAN_MAKE_PAYMENT = 0;
    public static final int CANNOT_MAKE_PAYMENT = 1;
    public static final int QUERY_QUOTA_EXCEEDED = 2;
    public static final int WARNING_CAN_MAKE_PAYMENT = 3;
    public static final int WARNING_CANNOT_MAKE_PAYMENT = 4;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private CanMakePaymentQueryResult() {
    }
}
