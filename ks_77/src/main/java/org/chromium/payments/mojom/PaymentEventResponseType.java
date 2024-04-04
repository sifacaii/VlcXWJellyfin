package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentEventResponseType.class */
public final class PaymentEventResponseType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int PAYMENT_EVENT_SUCCESS = 0;
    public static final int PAYMENT_EVENT_REJECT = 1;
    public static final int PAYMENT_EVENT_SERVICE_WORKER_ERROR = 2;
    public static final int PAYMENT_HANDLER_WINDOW_CLOSING = 3;
    public static final int PAYMENT_EVENT_INTERNAL_ERROR = 4;
    public static final int PAYMENT_EVENT_NO_RESPONSE = 5;
    public static final int PAYMENT_DETAILS_STRINGIFY_ERROR = 6;
    public static final int PAYMENT_METHOD_NAME_EMPTY = 7;
    public static final int PAYMENT_DETAILS_ABSENT = 8;
    public static final int PAYMENT_DETAILS_NOT_OBJECT = 9;
    public static final int PAYMENT_EVENT_BROWSER_ERROR = 10;
    public static final int PAYMENT_EVENT_TIMEOUT = 11;
    public static final int PAYMENT_HANDLER_INSECURE_NAVIGATION = 12;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 12;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PaymentEventResponseType() {
    }
}
