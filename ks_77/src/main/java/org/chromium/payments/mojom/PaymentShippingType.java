package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentShippingType.class */
public final class PaymentShippingType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SHIPPING = 0;
    public static final int DELIVERY = 1;
    public static final int PICKUP = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PaymentShippingType() {
    }
}
