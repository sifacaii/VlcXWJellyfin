package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient.class */
public interface PaymentRequestClient extends Interface {
    public static final Interface.Manager<PaymentRequestClient, Proxy> MANAGER = PaymentRequestClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentRequestClient$Proxy.class */
    public interface Proxy extends PaymentRequestClient, Interface.Proxy {
    }

    void onPaymentMethodChange(String str, String str2);

    void onShippingAddressChange(PaymentAddress paymentAddress);

    void onShippingOptionChange(String str);

    void onPayerDetailChange(PayerDetail payerDetail);

    void onPaymentResponse(PaymentResponse paymentResponse);

    void onError(int i, String str);

    void onComplete();

    void onAbort(boolean z);

    void onCanMakePayment(int i);

    void onHasEnrolledInstrument(int i);

    void warnNoFavicon();
}
