package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest.class */
public interface PaymentRequest extends Interface {
    public static final Interface.Manager<PaymentRequest, Proxy> MANAGER = PaymentRequest_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequest$Proxy.class */
    public interface Proxy extends PaymentRequest, Interface.Proxy {
    }

    void init(PaymentRequestClient paymentRequestClient, PaymentMethodData[] paymentMethodDataArr, PaymentDetails paymentDetails, PaymentOptions paymentOptions);

    void show(boolean z, boolean z2);

    void updateWith(PaymentDetails paymentDetails);

    void noUpdatedPaymentDetails();

    void abort();

    void complete(int i);

    void retry(PaymentValidationErrors paymentValidationErrors);

    void canMakePayment(boolean z);

    void hasEnrolledInstrument(boolean z);
}
