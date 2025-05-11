package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/BasicCardNetwork.class */
public final class BasicCardNetwork {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int AMEX = 0;
    public static final int DINERS = 1;
    public static final int DISCOVER = 2;
    public static final int JCB = 3;
    public static final int MASTERCARD = 4;
    public static final int MIR = 5;
    public static final int UNIONPAY = 6;
    public static final int VISA = 7;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 7;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private BasicCardNetwork() {
    }
}
