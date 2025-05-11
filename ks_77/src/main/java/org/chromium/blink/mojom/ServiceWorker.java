package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.network.mojom.CanonicalCookie;
import org.chromium.payments.mojom.CanMakePaymentEventData;
import org.chromium.payments.mojom.PaymentHandlerResponseCallback;
import org.chromium.payments.mojom.PaymentRequestEventData;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker.class */
public interface ServiceWorker extends Interface {
    public static final Interface.Manager<ServiceWorker, Proxy> MANAGER = ServiceWorker_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchAbortPaymentEventResponse.class */
    public interface DispatchAbortPaymentEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchActivateEventResponse.class */
    public interface DispatchActivateEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchBackgroundFetchAbortEventResponse.class */
    public interface DispatchBackgroundFetchAbortEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchBackgroundFetchClickEventResponse.class */
    public interface DispatchBackgroundFetchClickEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchBackgroundFetchFailEventResponse.class */
    public interface DispatchBackgroundFetchFailEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchBackgroundFetchSuccessEventResponse.class */
    public interface DispatchBackgroundFetchSuccessEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchCanMakePaymentEventResponse.class */
    public interface DispatchCanMakePaymentEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchContentDeleteEventResponse.class */
    public interface DispatchContentDeleteEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchCookieChangeEventResponse.class */
    public interface DispatchCookieChangeEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchExtendableMessageEventResponse.class */
    public interface DispatchExtendableMessageEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchExtendableMessageEventWithCustomTimeoutResponse.class */
    public interface DispatchExtendableMessageEventWithCustomTimeoutResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchFetchEventForMainResourceResponse.class */
    public interface DispatchFetchEventForMainResourceResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchInstallEventResponse.class */
    public interface DispatchInstallEventResponse extends Callbacks.Callback2<Integer, Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchNotificationClickEventResponse.class */
    public interface DispatchNotificationClickEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchNotificationCloseEventResponse.class */
    public interface DispatchNotificationCloseEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchPaymentRequestEventResponse.class */
    public interface DispatchPaymentRequestEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchPeriodicSyncEventResponse.class */
    public interface DispatchPeriodicSyncEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchPushEventResponse.class */
    public interface DispatchPushEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchPushSubscriptionChangeEventResponse.class */
    public interface DispatchPushSubscriptionChangeEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$DispatchSyncEventResponse.class */
    public interface DispatchSyncEventResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$PingResponse.class */
    public interface PingResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorker$Proxy.class */
    public interface Proxy extends ServiceWorker, Interface.Proxy {
    }

    void initializeGlobalScope(AssociatedInterfaceNotSupported associatedInterfaceNotSupported, ServiceWorkerRegistrationObjectInfo serviceWorkerRegistrationObjectInfo, int i);

    void dispatchInstallEvent(DispatchInstallEventResponse dispatchInstallEventResponse);

    void dispatchActivateEvent(DispatchActivateEventResponse dispatchActivateEventResponse);

    void dispatchBackgroundFetchAbortEvent(BackgroundFetchRegistration backgroundFetchRegistration, DispatchBackgroundFetchAbortEventResponse dispatchBackgroundFetchAbortEventResponse);

    void dispatchBackgroundFetchClickEvent(BackgroundFetchRegistration backgroundFetchRegistration, DispatchBackgroundFetchClickEventResponse dispatchBackgroundFetchClickEventResponse);

    void dispatchBackgroundFetchFailEvent(BackgroundFetchRegistration backgroundFetchRegistration, DispatchBackgroundFetchFailEventResponse dispatchBackgroundFetchFailEventResponse);

    void dispatchBackgroundFetchSuccessEvent(BackgroundFetchRegistration backgroundFetchRegistration, DispatchBackgroundFetchSuccessEventResponse dispatchBackgroundFetchSuccessEventResponse);

    void dispatchCookieChangeEvent(CanonicalCookie canonicalCookie, int i, DispatchCookieChangeEventResponse dispatchCookieChangeEventResponse);

    void dispatchFetchEventForMainResource(DispatchFetchEventParams dispatchFetchEventParams, ServiceWorkerFetchResponseCallback serviceWorkerFetchResponseCallback, DispatchFetchEventForMainResourceResponse dispatchFetchEventForMainResourceResponse);

    void dispatchNotificationClickEvent(String str, NotificationData notificationData, int i, String16 string16, DispatchNotificationClickEventResponse dispatchNotificationClickEventResponse);

    void dispatchNotificationCloseEvent(String str, NotificationData notificationData, DispatchNotificationCloseEventResponse dispatchNotificationCloseEventResponse);

    void dispatchPushEvent(String str, DispatchPushEventResponse dispatchPushEventResponse);

    void dispatchPushSubscriptionChangeEvent(PushSubscription pushSubscription, PushSubscription pushSubscription2, DispatchPushSubscriptionChangeEventResponse dispatchPushSubscriptionChangeEventResponse);

    void dispatchSyncEvent(String str, boolean z, TimeDelta timeDelta, DispatchSyncEventResponse dispatchSyncEventResponse);

    void dispatchPeriodicSyncEvent(String str, TimeDelta timeDelta, DispatchPeriodicSyncEventResponse dispatchPeriodicSyncEventResponse);

    void dispatchAbortPaymentEvent(PaymentHandlerResponseCallback paymentHandlerResponseCallback, DispatchAbortPaymentEventResponse dispatchAbortPaymentEventResponse);

    void dispatchCanMakePaymentEvent(CanMakePaymentEventData canMakePaymentEventData, PaymentHandlerResponseCallback paymentHandlerResponseCallback, DispatchCanMakePaymentEventResponse dispatchCanMakePaymentEventResponse);

    void dispatchPaymentRequestEvent(PaymentRequestEventData paymentRequestEventData, PaymentHandlerResponseCallback paymentHandlerResponseCallback, DispatchPaymentRequestEventResponse dispatchPaymentRequestEventResponse);

    void dispatchExtendableMessageEvent(ExtendableMessageEvent extendableMessageEvent, DispatchExtendableMessageEventResponse dispatchExtendableMessageEventResponse);

    void dispatchContentDeleteEvent(String str, DispatchContentDeleteEventResponse dispatchContentDeleteEventResponse);

    void dispatchExtendableMessageEventWithCustomTimeout(ExtendableMessageEvent extendableMessageEvent, TimeDelta timeDelta, DispatchExtendableMessageEventWithCustomTimeoutResponse dispatchExtendableMessageEventWithCustomTimeoutResponse);

    void ping(PingResponse pingResponse);

    void setIdleTimerDelayToZero();
}
