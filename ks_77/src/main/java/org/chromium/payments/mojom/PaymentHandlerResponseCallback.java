package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerResponseCallback.class */
public interface PaymentHandlerResponseCallback extends Interface {
    public static final Interface.Manager<PaymentHandlerResponseCallback, Proxy> MANAGER = PaymentHandlerResponseCallback_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerResponseCallback$Proxy.class */
    public interface Proxy extends PaymentHandlerResponseCallback, Interface.Proxy {
    }

    void onResponseForAbortPayment(boolean z);

    void onResponseForCanMakePayment(boolean z);

    void onResponseForPaymentRequest(PaymentHandlerResponse paymentHandlerResponse);
}
