package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager.class */
public interface PaymentManager extends Interface {
    public static final Interface.Manager<PaymentManager, Proxy> MANAGER = PaymentManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager$ClearPaymentInstrumentsResponse.class */
    public interface ClearPaymentInstrumentsResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager$DeletePaymentInstrumentResponse.class */
    public interface DeletePaymentInstrumentResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager$GetPaymentInstrumentResponse.class */
    public interface GetPaymentInstrumentResponse extends Callbacks.Callback2<PaymentInstrument, Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager$HasPaymentInstrumentResponse.class */
    public interface HasPaymentInstrumentResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager$KeysOfPaymentInstrumentsResponse.class */
    public interface KeysOfPaymentInstrumentsResponse extends Callbacks.Callback2<String[], Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager$Proxy.class */
    public interface Proxy extends PaymentManager, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentManager$SetPaymentInstrumentResponse.class */
    public interface SetPaymentInstrumentResponse extends Callbacks.Callback1<Integer> {
    }

    void init(Url url, String str);

    void deletePaymentInstrument(String str, DeletePaymentInstrumentResponse deletePaymentInstrumentResponse);

    void getPaymentInstrument(String str, GetPaymentInstrumentResponse getPaymentInstrumentResponse);

    void keysOfPaymentInstruments(KeysOfPaymentInstrumentsResponse keysOfPaymentInstrumentsResponse);

    void hasPaymentInstrument(String str, HasPaymentInstrumentResponse hasPaymentInstrumentResponse);

    void setPaymentInstrument(String str, PaymentInstrument paymentInstrument, SetPaymentInstrumentResponse setPaymentInstrumentResponse);

    void clearPaymentInstruments(ClearPaymentInstrumentsResponse clearPaymentInstrumentsResponse);

    void setUserHint(String str);
}
