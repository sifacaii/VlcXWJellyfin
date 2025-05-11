package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerHost.class */
public interface PaymentHandlerHost extends Interface {
    public static final Interface.Manager<PaymentHandlerHost, Proxy> MANAGER = PaymentHandlerHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerHost$ChangePaymentMethodResponse.class */
    public interface ChangePaymentMethodResponse extends Callbacks.Callback1<PaymentMethodChangeResponse> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentHandlerHost$Proxy.class */
    public interface Proxy extends PaymentHandlerHost, Interface.Proxy {
    }

    void changePaymentMethod(PaymentHandlerMethodData paymentHandlerMethodData, ChangePaymentMethodResponse changePaymentMethodResponse);
}
