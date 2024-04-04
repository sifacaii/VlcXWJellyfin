package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.network.mojom.CanonicalCookie;
import org.chromium.network.mojom.CookieChangeCause;
import org.chromium.payments.mojom.CanMakePaymentEventData;
import org.chromium.payments.mojom.PaymentHandlerResponseCallback;
import org.chromium.payments.mojom.PaymentRequestEventData;

class ServiceWorker_Internal {
    public static final Interface.Manager<ServiceWorker, ServiceWorker.Proxy> MANAGER = new Interface.Manager<ServiceWorker, ServiceWorker.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorker";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorker_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorker_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorker_Internal.Stub buildStub(Core core, ServiceWorker impl) {
            return new ServiceWorker_Internal.Stub(core, impl);
        }

        public ServiceWorker[] buildArray(int size) {
            return new ServiceWorker[size];
        }
    };

    private static final int INITIALIZE_GLOBAL_SCOPE_ORDINAL = 0;

    private static final int DISPATCH_INSTALL_EVENT_ORDINAL = 1;

    private static final int DISPATCH_ACTIVATE_EVENT_ORDINAL = 2;

    private static final int DISPATCH_BACKGROUND_FETCH_ABORT_EVENT_ORDINAL = 3;

    private static final int DISPATCH_BACKGROUND_FETCH_CLICK_EVENT_ORDINAL = 4;

    private static final int DISPATCH_BACKGROUND_FETCH_FAIL_EVENT_ORDINAL = 5;

    private static final int DISPATCH_BACKGROUND_FETCH_SUCCESS_EVENT_ORDINAL = 6;

    private static final int DISPATCH_COOKIE_CHANGE_EVENT_ORDINAL = 7;

    private static final int DISPATCH_FETCH_EVENT_FOR_MAIN_RESOURCE_ORDINAL = 8;

    private static final int DISPATCH_NOTIFICATION_CLICK_EVENT_ORDINAL = 9;

    private static final int DISPATCH_NOTIFICATION_CLOSE_EVENT_ORDINAL = 10;

    private static final int DISPATCH_PUSH_EVENT_ORDINAL = 11;

    private static final int DISPATCH_PUSH_SUBSCRIPTION_CHANGE_EVENT_ORDINAL = 12;

    private static final int DISPATCH_SYNC_EVENT_ORDINAL = 13;

    private static final int DISPATCH_PERIODIC_SYNC_EVENT_ORDINAL = 14;

    private static final int DISPATCH_ABORT_PAYMENT_EVENT_ORDINAL = 15;

    private static final int DISPATCH_CAN_MAKE_PAYMENT_EVENT_ORDINAL = 16;

    private static final int DISPATCH_PAYMENT_REQUEST_EVENT_ORDINAL = 17;

    private static final int DISPATCH_EXTENDABLE_MESSAGE_EVENT_ORDINAL = 18;

    private static final int DISPATCH_CONTENT_DELETE_EVENT_ORDINAL = 19;

    private static final int DISPATCH_EXTENDABLE_MESSAGE_EVENT_WITH_CUSTOM_TIMEOUT_ORDINAL = 20;

    private static final int PING_ORDINAL = 21;

    private static final int SET_IDLE_TIMER_DELAY_TO_ZERO_ORDINAL = 22;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorker.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void initializeGlobalScope(AssociatedInterfaceNotSupported serviceWorkerHost, ServiceWorkerRegistrationObjectInfo registrationInfo, int fetchHandlerExistence) {
            ServiceWorker_Internal.ServiceWorkerInitializeGlobalScopeParams _message = new ServiceWorker_Internal.ServiceWorkerInitializeGlobalScopeParams();
            _message.serviceWorkerHost = serviceWorkerHost;
            _message.registrationInfo = registrationInfo;
            _message.fetchHandlerExistence = fetchHandlerExistence;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void dispatchInstallEvent(ServiceWorker.DispatchInstallEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchInstallEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchInstallEventParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchInstallEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchActivateEvent(ServiceWorker.DispatchActivateEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchActivateEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchActivateEventParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchActivateEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchBackgroundFetchAbortEvent(BackgroundFetchRegistration registration, ServiceWorker.DispatchBackgroundFetchAbortEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchAbortEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchAbortEventParams();
            _message.registration = registration;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchAbortEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchBackgroundFetchClickEvent(BackgroundFetchRegistration registration, ServiceWorker.DispatchBackgroundFetchClickEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchClickEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchClickEventParams();
            _message.registration = registration;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchClickEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchBackgroundFetchFailEvent(BackgroundFetchRegistration registration, ServiceWorker.DispatchBackgroundFetchFailEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchFailEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchFailEventParams();
            _message.registration = registration;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchFailEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchBackgroundFetchSuccessEvent(BackgroundFetchRegistration registration, ServiceWorker.DispatchBackgroundFetchSuccessEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchSuccessEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchSuccessEventParams();
            _message.registration = registration;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchCookieChangeEvent(CanonicalCookie cookie, int cause, ServiceWorker.DispatchCookieChangeEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchCookieChangeEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchCookieChangeEventParams();
            _message.cookie = cookie;
            _message.cause = cause;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchCookieChangeEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchFetchEventForMainResource(DispatchFetchEventParams params, ServiceWorkerFetchResponseCallback responseCallback, ServiceWorker.DispatchFetchEventForMainResourceResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchFetchEventForMainResourceParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchFetchEventForMainResourceParams();
            _message.params = params;
            _message.responseCallback = responseCallback;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchFetchEventForMainResourceResponseParamsForwardToCallback(callback));
        }

        public void dispatchNotificationClickEvent(String notificationId, NotificationData notificationData, int actionIndex, String16 reply, ServiceWorker.DispatchNotificationClickEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchNotificationClickEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchNotificationClickEventParams();
            _message.notificationId = notificationId;
            _message.notificationData = notificationData;
            _message.actionIndex = actionIndex;
            _message.reply = reply;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchNotificationClickEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchNotificationCloseEvent(String notificationId, NotificationData notificationData, ServiceWorker.DispatchNotificationCloseEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchNotificationCloseEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchNotificationCloseEventParams();
            _message.notificationId = notificationId;
            _message.notificationData = notificationData;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchNotificationCloseEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchPushEvent(String payload, ServiceWorker.DispatchPushEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchPushEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchPushEventParams();
            _message.payload = payload;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchPushEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchPushSubscriptionChangeEvent(PushSubscription oldSubscription, PushSubscription newSubscription, ServiceWorker.DispatchPushSubscriptionChangeEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchPushSubscriptionChangeEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchPushSubscriptionChangeEventParams();
            _message.oldSubscription = oldSubscription;
            _message.newSubscription = newSubscription;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(12, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchPushSubscriptionChangeEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchSyncEvent(String tag, boolean lastChance, TimeDelta timeout, ServiceWorker.DispatchSyncEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchSyncEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchSyncEventParams();
            _message.tag = tag;
            _message.lastChance = lastChance;
            _message.timeout = timeout;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(13, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchSyncEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchPeriodicSyncEvent(String tag, TimeDelta timeout, ServiceWorker.DispatchPeriodicSyncEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchPeriodicSyncEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchPeriodicSyncEventParams();
            _message.tag = tag;
            _message.timeout = timeout;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(14, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchPeriodicSyncEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchAbortPaymentEvent(PaymentHandlerResponseCallback resultOfAbortPayment, ServiceWorker.DispatchAbortPaymentEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchAbortPaymentEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchAbortPaymentEventParams();
            _message.resultOfAbortPayment = resultOfAbortPayment;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(15, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchAbortPaymentEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchCanMakePaymentEvent(CanMakePaymentEventData eventData, PaymentHandlerResponseCallback resultOfCanMakePayment, ServiceWorker.DispatchCanMakePaymentEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchCanMakePaymentEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchCanMakePaymentEventParams();
            _message.eventData = eventData;
            _message.resultOfCanMakePayment = resultOfCanMakePayment;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(16, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchCanMakePaymentEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchPaymentRequestEvent(PaymentRequestEventData requestData, PaymentHandlerResponseCallback responseCallback, ServiceWorker.DispatchPaymentRequestEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchPaymentRequestEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchPaymentRequestEventParams();
            _message.requestData = requestData;
            _message.responseCallback = responseCallback;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(17, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchPaymentRequestEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchExtendableMessageEvent(ExtendableMessageEvent event, ServiceWorker.DispatchExtendableMessageEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventParams();
            _message.event = event;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(18, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchContentDeleteEvent(String id, ServiceWorker.DispatchContentDeleteEventResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchContentDeleteEventParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchContentDeleteEventParams();
            _message.id = id;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(19, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchContentDeleteEventResponseParamsForwardToCallback(callback));
        }

        public void dispatchExtendableMessageEventWithCustomTimeout(ExtendableMessageEvent event, TimeDelta timeout, ServiceWorker.DispatchExtendableMessageEventWithCustomTimeoutResponse callback) {
            ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutParams _message = new ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutParams();
            _message.event = event;
            _message.timeout = timeout;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(20, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParamsForwardToCallback(callback));
        }

        public void ping(ServiceWorker.PingResponse callback) {
            ServiceWorker_Internal.ServiceWorkerPingParams _message = new ServiceWorker_Internal.ServiceWorkerPingParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(21, 1, 0L)), new ServiceWorker_Internal.ServiceWorkerPingResponseParamsForwardToCallback(callback));
        }

        public void setIdleTimerDelayToZero() {
            ServiceWorker_Internal.ServiceWorkerSetIdleTimerDelayToZeroParams _message = new ServiceWorker_Internal.ServiceWorkerSetIdleTimerDelayToZeroParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(22)));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorker> {
        Stub(Core core, ServiceWorker impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorker_Internal.ServiceWorkerInitializeGlobalScopeParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorker_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ServiceWorker_Internal.ServiceWorkerInitializeGlobalScopeParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).initializeGlobalScope(data.serviceWorkerHost, data.registrationInfo, data.fetchHandlerExistence);
                        return true;
                    case 22:
                        ServiceWorker_Internal.ServiceWorkerSetIdleTimerDelayToZeroParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).setIdleTimerDelayToZero();
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchAbortEventParams serviceWorkerDispatchBackgroundFetchAbortEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchClickEventParams serviceWorkerDispatchBackgroundFetchClickEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchFailEventParams serviceWorkerDispatchBackgroundFetchFailEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchSuccessEventParams serviceWorkerDispatchBackgroundFetchSuccessEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchCookieChangeEventParams serviceWorkerDispatchCookieChangeEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchFetchEventForMainResourceParams serviceWorkerDispatchFetchEventForMainResourceParams;
                ServiceWorker_Internal.ServiceWorkerDispatchNotificationClickEventParams serviceWorkerDispatchNotificationClickEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchNotificationCloseEventParams serviceWorkerDispatchNotificationCloseEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchPushEventParams serviceWorkerDispatchPushEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchPushSubscriptionChangeEventParams serviceWorkerDispatchPushSubscriptionChangeEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchSyncEventParams serviceWorkerDispatchSyncEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchPeriodicSyncEventParams serviceWorkerDispatchPeriodicSyncEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchAbortPaymentEventParams serviceWorkerDispatchAbortPaymentEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchCanMakePaymentEventParams serviceWorkerDispatchCanMakePaymentEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchPaymentRequestEventParams serviceWorkerDispatchPaymentRequestEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventParams serviceWorkerDispatchExtendableMessageEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchContentDeleteEventParams serviceWorkerDispatchContentDeleteEventParams;
                ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), ServiceWorker_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        ServiceWorker_Internal.ServiceWorkerDispatchInstallEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchInstallEvent(new ServiceWorker_Internal.ServiceWorkerDispatchInstallEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        ServiceWorker_Internal.ServiceWorkerDispatchActivateEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchActivateEvent(new ServiceWorker_Internal.ServiceWorkerDispatchActivateEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        serviceWorkerDispatchBackgroundFetchAbortEventParams = ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchAbortEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchBackgroundFetchAbortEvent(serviceWorkerDispatchBackgroundFetchAbortEventParams.registration, new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchAbortEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        serviceWorkerDispatchBackgroundFetchClickEventParams = ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchClickEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchBackgroundFetchClickEvent(serviceWorkerDispatchBackgroundFetchClickEventParams.registration, new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchClickEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        serviceWorkerDispatchBackgroundFetchFailEventParams = ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchFailEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchBackgroundFetchFailEvent(serviceWorkerDispatchBackgroundFetchFailEventParams.registration, new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchFailEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        serviceWorkerDispatchBackgroundFetchSuccessEventParams = ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchSuccessEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchBackgroundFetchSuccessEvent(serviceWorkerDispatchBackgroundFetchSuccessEventParams.registration, new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        serviceWorkerDispatchCookieChangeEventParams = ServiceWorker_Internal.ServiceWorkerDispatchCookieChangeEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchCookieChangeEvent(serviceWorkerDispatchCookieChangeEventParams.cookie, serviceWorkerDispatchCookieChangeEventParams.cause, new ServiceWorker_Internal.ServiceWorkerDispatchCookieChangeEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 8:
                        serviceWorkerDispatchFetchEventForMainResourceParams = ServiceWorker_Internal.ServiceWorkerDispatchFetchEventForMainResourceParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchFetchEventForMainResource(serviceWorkerDispatchFetchEventForMainResourceParams.params, serviceWorkerDispatchFetchEventForMainResourceParams.responseCallback, new ServiceWorker_Internal.ServiceWorkerDispatchFetchEventForMainResourceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 9:
                        serviceWorkerDispatchNotificationClickEventParams = ServiceWorker_Internal.ServiceWorkerDispatchNotificationClickEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchNotificationClickEvent(serviceWorkerDispatchNotificationClickEventParams.notificationId, serviceWorkerDispatchNotificationClickEventParams.notificationData, serviceWorkerDispatchNotificationClickEventParams.actionIndex, serviceWorkerDispatchNotificationClickEventParams.reply, new ServiceWorker_Internal.ServiceWorkerDispatchNotificationClickEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 10:
                        serviceWorkerDispatchNotificationCloseEventParams = ServiceWorker_Internal.ServiceWorkerDispatchNotificationCloseEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchNotificationCloseEvent(serviceWorkerDispatchNotificationCloseEventParams.notificationId, serviceWorkerDispatchNotificationCloseEventParams.notificationData, new ServiceWorker_Internal.ServiceWorkerDispatchNotificationCloseEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 11:
                        serviceWorkerDispatchPushEventParams = ServiceWorker_Internal.ServiceWorkerDispatchPushEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchPushEvent(serviceWorkerDispatchPushEventParams.payload, new ServiceWorker_Internal.ServiceWorkerDispatchPushEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 12:
                        serviceWorkerDispatchPushSubscriptionChangeEventParams = ServiceWorker_Internal.ServiceWorkerDispatchPushSubscriptionChangeEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchPushSubscriptionChangeEvent(serviceWorkerDispatchPushSubscriptionChangeEventParams.oldSubscription, serviceWorkerDispatchPushSubscriptionChangeEventParams.newSubscription, new ServiceWorker_Internal.ServiceWorkerDispatchPushSubscriptionChangeEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 13:
                        serviceWorkerDispatchSyncEventParams = ServiceWorker_Internal.ServiceWorkerDispatchSyncEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchSyncEvent(serviceWorkerDispatchSyncEventParams.tag, serviceWorkerDispatchSyncEventParams.lastChance, serviceWorkerDispatchSyncEventParams.timeout, new ServiceWorker_Internal.ServiceWorkerDispatchSyncEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 14:
                        serviceWorkerDispatchPeriodicSyncEventParams = ServiceWorker_Internal.ServiceWorkerDispatchPeriodicSyncEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchPeriodicSyncEvent(serviceWorkerDispatchPeriodicSyncEventParams.tag, serviceWorkerDispatchPeriodicSyncEventParams.timeout, new ServiceWorker_Internal.ServiceWorkerDispatchPeriodicSyncEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 15:
                        serviceWorkerDispatchAbortPaymentEventParams = ServiceWorker_Internal.ServiceWorkerDispatchAbortPaymentEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchAbortPaymentEvent(serviceWorkerDispatchAbortPaymentEventParams.resultOfAbortPayment, new ServiceWorker_Internal.ServiceWorkerDispatchAbortPaymentEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 16:
                        serviceWorkerDispatchCanMakePaymentEventParams = ServiceWorker_Internal.ServiceWorkerDispatchCanMakePaymentEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchCanMakePaymentEvent(serviceWorkerDispatchCanMakePaymentEventParams.eventData, serviceWorkerDispatchCanMakePaymentEventParams.resultOfCanMakePayment, new ServiceWorker_Internal.ServiceWorkerDispatchCanMakePaymentEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 17:
                        serviceWorkerDispatchPaymentRequestEventParams = ServiceWorker_Internal.ServiceWorkerDispatchPaymentRequestEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchPaymentRequestEvent(serviceWorkerDispatchPaymentRequestEventParams.requestData, serviceWorkerDispatchPaymentRequestEventParams.responseCallback, new ServiceWorker_Internal.ServiceWorkerDispatchPaymentRequestEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 18:
                        serviceWorkerDispatchExtendableMessageEventParams = ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchExtendableMessageEvent(serviceWorkerDispatchExtendableMessageEventParams.event, new ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 19:
                        serviceWorkerDispatchContentDeleteEventParams = ServiceWorker_Internal.ServiceWorkerDispatchContentDeleteEventParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchContentDeleteEvent(serviceWorkerDispatchContentDeleteEventParams.id, new ServiceWorker_Internal.ServiceWorkerDispatchContentDeleteEventResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 20:
                        data = ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).dispatchExtendableMessageEventWithCustomTimeout(data.event, data.timeout, new ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 21:
                        ServiceWorker_Internal.ServiceWorkerPingParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorker)getImpl()).ping(new ServiceWorker_Internal.ServiceWorkerPingResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerInitializeGlobalScopeParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported serviceWorkerHost;

        public ServiceWorkerRegistrationObjectInfo registrationInfo;

        public int fetchHandlerExistence;

        private ServiceWorkerInitializeGlobalScopeParams(int version) {
            super(32, version);
        }

        public ServiceWorkerInitializeGlobalScopeParams() {
            this(0);
        }

        public static ServiceWorkerInitializeGlobalScopeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerInitializeGlobalScopeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerInitializeGlobalScopeParams decode(Decoder decoder0) {
            ServiceWorkerInitializeGlobalScopeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerInitializeGlobalScopeParams(elementsOrVersion);
                result.serviceWorkerHost = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.registrationInfo = ServiceWorkerRegistrationObjectInfo.decode(decoder1);
                result.fetchHandlerExistence = decoder0.readInt(24);
                FetchHandlerExistence.validate(result.fetchHandlerExistence);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerHost, 8, false);
            encoder0.encode(this.registrationInfo, 16, false);
            encoder0.encode(this.fetchHandlerExistence, 24);
        }
    }

    static final class ServiceWorkerDispatchInstallEventParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerDispatchInstallEventParams(int version) {
            super(8, version);
        }

        public ServiceWorkerDispatchInstallEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchInstallEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchInstallEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchInstallEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchInstallEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchInstallEventParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerDispatchInstallEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public boolean hasFetchHandler;

        private ServiceWorkerDispatchInstallEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchInstallEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchInstallEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchInstallEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchInstallEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchInstallEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchInstallEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
                result.hasFetchHandler = decoder0.readBoolean(12, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.hasFetchHandler, 12, 0);
        }
    }

    static class ServiceWorkerDispatchInstallEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchInstallEventResponse mCallback;

        ServiceWorkerDispatchInstallEventResponseParamsForwardToCallback(ServiceWorker.DispatchInstallEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchInstallEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchInstallEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), Boolean.valueOf(response.hasFetchHandler));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchInstallEventResponseParamsProxyToResponder implements ServiceWorker.DispatchInstallEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchInstallEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, Boolean hasFetchHandler) {
            ServiceWorker_Internal.ServiceWorkerDispatchInstallEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchInstallEventResponseParams();
            _response.status = status.intValue();
            _response.hasFetchHandler = hasFetchHandler.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchActivateEventParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerDispatchActivateEventParams(int version) {
            super(8, version);
        }

        public ServiceWorkerDispatchActivateEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchActivateEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchActivateEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchActivateEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchActivateEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchActivateEventParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerDispatchActivateEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchActivateEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchActivateEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchActivateEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchActivateEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchActivateEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchActivateEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchActivateEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchActivateEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchActivateEventResponse mCallback;

        ServiceWorkerDispatchActivateEventResponseParamsForwardToCallback(ServiceWorker.DispatchActivateEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchActivateEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchActivateEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchActivateEventResponseParamsProxyToResponder implements ServiceWorker.DispatchActivateEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchActivateEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchActivateEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchActivateEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchBackgroundFetchAbortEventParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BackgroundFetchRegistration registration;

        private ServiceWorkerDispatchBackgroundFetchAbortEventParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchBackgroundFetchAbortEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchBackgroundFetchAbortEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchBackgroundFetchAbortEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchBackgroundFetchAbortEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchBackgroundFetchAbortEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchBackgroundFetchAbortEventParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.registration = BackgroundFetchRegistration.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.registration, 8, false);
        }
    }

    static final class ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchBackgroundFetchAbortEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchBackgroundFetchAbortEventResponse mCallback;

        ServiceWorkerDispatchBackgroundFetchAbortEventResponseParamsForwardToCallback(ServiceWorker.DispatchBackgroundFetchAbortEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchBackgroundFetchAbortEventResponseParamsProxyToResponder implements ServiceWorker.DispatchBackgroundFetchAbortEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchBackgroundFetchAbortEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchAbortEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchBackgroundFetchClickEventParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BackgroundFetchRegistration registration;

        private ServiceWorkerDispatchBackgroundFetchClickEventParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchBackgroundFetchClickEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchBackgroundFetchClickEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchBackgroundFetchClickEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchBackgroundFetchClickEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchBackgroundFetchClickEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchBackgroundFetchClickEventParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.registration = BackgroundFetchRegistration.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.registration, 8, false);
        }
    }

    static final class ServiceWorkerDispatchBackgroundFetchClickEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchBackgroundFetchClickEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchBackgroundFetchClickEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchBackgroundFetchClickEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchBackgroundFetchClickEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchBackgroundFetchClickEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchBackgroundFetchClickEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchBackgroundFetchClickEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchBackgroundFetchClickEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchBackgroundFetchClickEventResponse mCallback;

        ServiceWorkerDispatchBackgroundFetchClickEventResponseParamsForwardToCallback(ServiceWorker.DispatchBackgroundFetchClickEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchClickEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchClickEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchBackgroundFetchClickEventResponseParamsProxyToResponder implements ServiceWorker.DispatchBackgroundFetchClickEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchBackgroundFetchClickEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchClickEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchClickEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchBackgroundFetchFailEventParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BackgroundFetchRegistration registration;

        private ServiceWorkerDispatchBackgroundFetchFailEventParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchBackgroundFetchFailEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchBackgroundFetchFailEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchBackgroundFetchFailEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchBackgroundFetchFailEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchBackgroundFetchFailEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchBackgroundFetchFailEventParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.registration = BackgroundFetchRegistration.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.registration, 8, false);
        }
    }

    static final class ServiceWorkerDispatchBackgroundFetchFailEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchBackgroundFetchFailEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchBackgroundFetchFailEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchBackgroundFetchFailEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchBackgroundFetchFailEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchBackgroundFetchFailEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchBackgroundFetchFailEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchBackgroundFetchFailEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchBackgroundFetchFailEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchBackgroundFetchFailEventResponse mCallback;

        ServiceWorkerDispatchBackgroundFetchFailEventResponseParamsForwardToCallback(ServiceWorker.DispatchBackgroundFetchFailEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchFailEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchFailEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchBackgroundFetchFailEventResponseParamsProxyToResponder implements ServiceWorker.DispatchBackgroundFetchFailEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchBackgroundFetchFailEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchFailEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchFailEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchBackgroundFetchSuccessEventParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public BackgroundFetchRegistration registration;

        private ServiceWorkerDispatchBackgroundFetchSuccessEventParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchBackgroundFetchSuccessEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchBackgroundFetchSuccessEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchBackgroundFetchSuccessEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchBackgroundFetchSuccessEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchBackgroundFetchSuccessEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchBackgroundFetchSuccessEventParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.registration = BackgroundFetchRegistration.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.registration, 8, false);
        }
    }

    static final class ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchBackgroundFetchSuccessEventResponse mCallback;

        ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParamsForwardToCallback(ServiceWorker.DispatchBackgroundFetchSuccessEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParamsProxyToResponder implements ServiceWorker.DispatchBackgroundFetchSuccessEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchBackgroundFetchSuccessEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchCookieChangeEventParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CanonicalCookie cookie;

        public int cause;

        private ServiceWorkerDispatchCookieChangeEventParams(int version) {
            super(24, version);
        }

        public ServiceWorkerDispatchCookieChangeEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchCookieChangeEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchCookieChangeEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchCookieChangeEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchCookieChangeEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchCookieChangeEventParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.cookie = CanonicalCookie.decode(decoder1);
                result.cause = decoder0.readInt(16);
                CookieChangeCause.validate(result.cause);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.cookie, 8, false);
            encoder0.encode(this.cause, 16);
        }
    }

    static final class ServiceWorkerDispatchCookieChangeEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchCookieChangeEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchCookieChangeEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchCookieChangeEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchCookieChangeEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchCookieChangeEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchCookieChangeEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchCookieChangeEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchCookieChangeEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchCookieChangeEventResponse mCallback;

        ServiceWorkerDispatchCookieChangeEventResponseParamsForwardToCallback(ServiceWorker.DispatchCookieChangeEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(7, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchCookieChangeEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchCookieChangeEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchCookieChangeEventResponseParamsProxyToResponder implements ServiceWorker.DispatchCookieChangeEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchCookieChangeEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchCookieChangeEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchCookieChangeEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchFetchEventForMainResourceParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DispatchFetchEventParams params;

        public ServiceWorkerFetchResponseCallback responseCallback;

        private ServiceWorkerDispatchFetchEventForMainResourceParams(int version) {
            super(24, version);
        }

        public ServiceWorkerDispatchFetchEventForMainResourceParams() {
            this(0);
        }

        public static ServiceWorkerDispatchFetchEventForMainResourceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchFetchEventForMainResourceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchFetchEventForMainResourceParams decode(Decoder decoder0) {
            ServiceWorkerDispatchFetchEventForMainResourceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchFetchEventForMainResourceParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.params = DispatchFetchEventParams.decode(decoder1);
                result.responseCallback = (ServiceWorkerFetchResponseCallback)decoder0.readServiceInterface(16, false, ServiceWorkerFetchResponseCallback.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.params, 8, false);
            encoder0.encode(this.responseCallback, 16, false, ServiceWorkerFetchResponseCallback.MANAGER);
        }
    }

    static final class ServiceWorkerDispatchFetchEventForMainResourceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchFetchEventForMainResourceResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchFetchEventForMainResourceResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchFetchEventForMainResourceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchFetchEventForMainResourceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchFetchEventForMainResourceResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchFetchEventForMainResourceResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchFetchEventForMainResourceResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchFetchEventForMainResourceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchFetchEventForMainResourceResponse mCallback;

        ServiceWorkerDispatchFetchEventForMainResourceResponseParamsForwardToCallback(ServiceWorker.DispatchFetchEventForMainResourceResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(8, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchFetchEventForMainResourceResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchFetchEventForMainResourceResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchFetchEventForMainResourceResponseParamsProxyToResponder implements ServiceWorker.DispatchFetchEventForMainResourceResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchFetchEventForMainResourceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchFetchEventForMainResourceResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchFetchEventForMainResourceResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchNotificationClickEventParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String notificationId;

        public NotificationData notificationData;

        public int actionIndex;

        public String16 reply;

        private ServiceWorkerDispatchNotificationClickEventParams(int version) {
            super(40, version);
        }

        public ServiceWorkerDispatchNotificationClickEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchNotificationClickEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchNotificationClickEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchNotificationClickEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchNotificationClickEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchNotificationClickEventParams(elementsOrVersion);
                result.notificationId = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.notificationData = NotificationData.decode(decoder1);
                result.actionIndex = decoder0.readInt(24);
                decoder1 = decoder0.readPointer(32, true);
                result.reply = String16.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.notificationId, 8, false);
            encoder0.encode(this.notificationData, 16, false);
            encoder0.encode(this.actionIndex, 24);
            encoder0.encode((Struct)this.reply, 32, true);
        }
    }

    static final class ServiceWorkerDispatchNotificationClickEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchNotificationClickEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchNotificationClickEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchNotificationClickEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchNotificationClickEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchNotificationClickEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchNotificationClickEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchNotificationClickEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchNotificationClickEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchNotificationClickEventResponse mCallback;

        ServiceWorkerDispatchNotificationClickEventResponseParamsForwardToCallback(ServiceWorker.DispatchNotificationClickEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(9, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchNotificationClickEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchNotificationClickEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchNotificationClickEventResponseParamsProxyToResponder implements ServiceWorker.DispatchNotificationClickEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchNotificationClickEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchNotificationClickEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchNotificationClickEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchNotificationCloseEventParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String notificationId;

        public NotificationData notificationData;

        private ServiceWorkerDispatchNotificationCloseEventParams(int version) {
            super(24, version);
        }

        public ServiceWorkerDispatchNotificationCloseEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchNotificationCloseEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchNotificationCloseEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchNotificationCloseEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchNotificationCloseEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchNotificationCloseEventParams(elementsOrVersion);
                result.notificationId = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.notificationData = NotificationData.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.notificationId, 8, false);
            encoder0.encode(this.notificationData, 16, false);
        }
    }

    static final class ServiceWorkerDispatchNotificationCloseEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchNotificationCloseEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchNotificationCloseEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchNotificationCloseEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchNotificationCloseEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchNotificationCloseEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchNotificationCloseEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchNotificationCloseEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchNotificationCloseEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchNotificationCloseEventResponse mCallback;

        ServiceWorkerDispatchNotificationCloseEventResponseParamsForwardToCallback(ServiceWorker.DispatchNotificationCloseEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(10, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchNotificationCloseEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchNotificationCloseEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchNotificationCloseEventResponseParamsProxyToResponder implements ServiceWorker.DispatchNotificationCloseEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchNotificationCloseEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchNotificationCloseEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchNotificationCloseEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchPushEventParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String payload;

        private ServiceWorkerDispatchPushEventParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchPushEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchPushEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchPushEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchPushEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchPushEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchPushEventParams(elementsOrVersion);
                result.payload = decoder0.readString(8, true);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.payload, 8, true);
        }
    }

    static final class ServiceWorkerDispatchPushEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchPushEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchPushEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchPushEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchPushEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchPushEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchPushEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchPushEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchPushEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchPushEventResponse mCallback;

        ServiceWorkerDispatchPushEventResponseParamsForwardToCallback(ServiceWorker.DispatchPushEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(11, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchPushEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchPushEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchPushEventResponseParamsProxyToResponder implements ServiceWorker.DispatchPushEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchPushEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchPushEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchPushEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchPushSubscriptionChangeEventParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PushSubscription oldSubscription;

        public PushSubscription newSubscription;

        private ServiceWorkerDispatchPushSubscriptionChangeEventParams(int version) {
            super(24, version);
        }

        public ServiceWorkerDispatchPushSubscriptionChangeEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchPushSubscriptionChangeEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchPushSubscriptionChangeEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchPushSubscriptionChangeEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchPushSubscriptionChangeEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchPushSubscriptionChangeEventParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.oldSubscription = PushSubscription.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.newSubscription = PushSubscription.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.oldSubscription, 8, false);
            encoder0.encode(this.newSubscription, 16, false);
        }
    }

    static final class ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchPushSubscriptionChangeEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchPushSubscriptionChangeEventResponse mCallback;

        ServiceWorkerDispatchPushSubscriptionChangeEventResponseParamsForwardToCallback(ServiceWorker.DispatchPushSubscriptionChangeEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(12, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchPushSubscriptionChangeEventResponseParamsProxyToResponder implements ServiceWorker.DispatchPushSubscriptionChangeEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchPushSubscriptionChangeEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchPushSubscriptionChangeEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(12, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchSyncEventParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String tag;

        public boolean lastChance;

        public TimeDelta timeout;

        private ServiceWorkerDispatchSyncEventParams(int version) {
            super(32, version);
        }

        public ServiceWorkerDispatchSyncEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchSyncEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchSyncEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchSyncEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchSyncEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchSyncEventParams(elementsOrVersion);
                result.tag = decoder0.readString(8, false);
                result.lastChance = decoder0.readBoolean(16, 0);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.timeout = TimeDelta.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.tag, 8, false);
            encoder0.encode(this.lastChance, 16, 0);
            encoder0.encode((Struct)this.timeout, 24, false);
        }
    }

    static final class ServiceWorkerDispatchSyncEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchSyncEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchSyncEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchSyncEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchSyncEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchSyncEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchSyncEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchSyncEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchSyncEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchSyncEventResponse mCallback;

        ServiceWorkerDispatchSyncEventResponseParamsForwardToCallback(ServiceWorker.DispatchSyncEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(13, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchSyncEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchSyncEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchSyncEventResponseParamsProxyToResponder implements ServiceWorker.DispatchSyncEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchSyncEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchSyncEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchSyncEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(13, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchPeriodicSyncEventParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String tag;

        public TimeDelta timeout;

        private ServiceWorkerDispatchPeriodicSyncEventParams(int version) {
            super(24, version);
        }

        public ServiceWorkerDispatchPeriodicSyncEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchPeriodicSyncEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchPeriodicSyncEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchPeriodicSyncEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchPeriodicSyncEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchPeriodicSyncEventParams(elementsOrVersion);
                result.tag = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.timeout = TimeDelta.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.tag, 8, false);
            encoder0.encode((Struct)this.timeout, 16, false);
        }
    }

    static final class ServiceWorkerDispatchPeriodicSyncEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchPeriodicSyncEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchPeriodicSyncEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchPeriodicSyncEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchPeriodicSyncEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchPeriodicSyncEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchPeriodicSyncEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchPeriodicSyncEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchPeriodicSyncEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchPeriodicSyncEventResponse mCallback;

        ServiceWorkerDispatchPeriodicSyncEventResponseParamsForwardToCallback(ServiceWorker.DispatchPeriodicSyncEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(14, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchPeriodicSyncEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchPeriodicSyncEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchPeriodicSyncEventResponseParamsProxyToResponder implements ServiceWorker.DispatchPeriodicSyncEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchPeriodicSyncEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchPeriodicSyncEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchPeriodicSyncEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(14, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchAbortPaymentEventParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PaymentHandlerResponseCallback resultOfAbortPayment;

        private ServiceWorkerDispatchAbortPaymentEventParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchAbortPaymentEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchAbortPaymentEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchAbortPaymentEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchAbortPaymentEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchAbortPaymentEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchAbortPaymentEventParams(elementsOrVersion);
                result.resultOfAbortPayment = (PaymentHandlerResponseCallback)decoder0.readServiceInterface(8, false, PaymentHandlerResponseCallback.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.resultOfAbortPayment, 8, false, PaymentHandlerResponseCallback.MANAGER);
        }
    }

    static final class ServiceWorkerDispatchAbortPaymentEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchAbortPaymentEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchAbortPaymentEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchAbortPaymentEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchAbortPaymentEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchAbortPaymentEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchAbortPaymentEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchAbortPaymentEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchAbortPaymentEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchAbortPaymentEventResponse mCallback;

        ServiceWorkerDispatchAbortPaymentEventResponseParamsForwardToCallback(ServiceWorker.DispatchAbortPaymentEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(15, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchAbortPaymentEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchAbortPaymentEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchAbortPaymentEventResponseParamsProxyToResponder implements ServiceWorker.DispatchAbortPaymentEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchAbortPaymentEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchAbortPaymentEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchAbortPaymentEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(15, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchCanMakePaymentEventParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CanMakePaymentEventData eventData;

        public PaymentHandlerResponseCallback resultOfCanMakePayment;

        private ServiceWorkerDispatchCanMakePaymentEventParams(int version) {
            super(24, version);
        }

        public ServiceWorkerDispatchCanMakePaymentEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchCanMakePaymentEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchCanMakePaymentEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchCanMakePaymentEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchCanMakePaymentEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchCanMakePaymentEventParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.eventData = CanMakePaymentEventData.decode(decoder1);
                result.resultOfCanMakePayment = (PaymentHandlerResponseCallback)decoder0.readServiceInterface(16, false, PaymentHandlerResponseCallback.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.eventData, 8, false);
            encoder0.encode(this.resultOfCanMakePayment, 16, false, PaymentHandlerResponseCallback.MANAGER);
        }
    }

    static final class ServiceWorkerDispatchCanMakePaymentEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchCanMakePaymentEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchCanMakePaymentEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchCanMakePaymentEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchCanMakePaymentEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchCanMakePaymentEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchCanMakePaymentEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchCanMakePaymentEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchCanMakePaymentEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchCanMakePaymentEventResponse mCallback;

        ServiceWorkerDispatchCanMakePaymentEventResponseParamsForwardToCallback(ServiceWorker.DispatchCanMakePaymentEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(16, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchCanMakePaymentEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchCanMakePaymentEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchCanMakePaymentEventResponseParamsProxyToResponder implements ServiceWorker.DispatchCanMakePaymentEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchCanMakePaymentEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchCanMakePaymentEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchCanMakePaymentEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(16, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchPaymentRequestEventParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PaymentRequestEventData requestData;

        public PaymentHandlerResponseCallback responseCallback;

        private ServiceWorkerDispatchPaymentRequestEventParams(int version) {
            super(24, version);
        }

        public ServiceWorkerDispatchPaymentRequestEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchPaymentRequestEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchPaymentRequestEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchPaymentRequestEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchPaymentRequestEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchPaymentRequestEventParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.requestData = PaymentRequestEventData.decode(decoder1);
                result.responseCallback = (PaymentHandlerResponseCallback)decoder0.readServiceInterface(16, false, PaymentHandlerResponseCallback.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.requestData, 8, false);
            encoder0.encode(this.responseCallback, 16, false, PaymentHandlerResponseCallback.MANAGER);
        }
    }

    static final class ServiceWorkerDispatchPaymentRequestEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchPaymentRequestEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchPaymentRequestEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchPaymentRequestEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchPaymentRequestEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchPaymentRequestEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchPaymentRequestEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchPaymentRequestEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchPaymentRequestEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchPaymentRequestEventResponse mCallback;

        ServiceWorkerDispatchPaymentRequestEventResponseParamsForwardToCallback(ServiceWorker.DispatchPaymentRequestEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(17, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchPaymentRequestEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchPaymentRequestEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchPaymentRequestEventResponseParamsProxyToResponder implements ServiceWorker.DispatchPaymentRequestEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchPaymentRequestEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchPaymentRequestEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchPaymentRequestEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(17, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchExtendableMessageEventParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ExtendableMessageEvent event;

        private ServiceWorkerDispatchExtendableMessageEventParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchExtendableMessageEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchExtendableMessageEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchExtendableMessageEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchExtendableMessageEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchExtendableMessageEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchExtendableMessageEventParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.event = ExtendableMessageEvent.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.event, 8, false);
        }
    }

    static final class ServiceWorkerDispatchExtendableMessageEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchExtendableMessageEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchExtendableMessageEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchExtendableMessageEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchExtendableMessageEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchExtendableMessageEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchExtendableMessageEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchExtendableMessageEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchExtendableMessageEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchExtendableMessageEventResponse mCallback;

        ServiceWorkerDispatchExtendableMessageEventResponseParamsForwardToCallback(ServiceWorker.DispatchExtendableMessageEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(18, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchExtendableMessageEventResponseParamsProxyToResponder implements ServiceWorker.DispatchExtendableMessageEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchExtendableMessageEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(18, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchContentDeleteEventParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String id;

        private ServiceWorkerDispatchContentDeleteEventParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchContentDeleteEventParams() {
            this(0);
        }

        public static ServiceWorkerDispatchContentDeleteEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchContentDeleteEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchContentDeleteEventParams decode(Decoder decoder0) {
            ServiceWorkerDispatchContentDeleteEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchContentDeleteEventParams(elementsOrVersion);
                result.id = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.id, 8, false);
        }
    }

    static final class ServiceWorkerDispatchContentDeleteEventResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchContentDeleteEventResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchContentDeleteEventResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchContentDeleteEventResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchContentDeleteEventResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchContentDeleteEventResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchContentDeleteEventResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchContentDeleteEventResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchContentDeleteEventResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchContentDeleteEventResponse mCallback;

        ServiceWorkerDispatchContentDeleteEventResponseParamsForwardToCallback(ServiceWorker.DispatchContentDeleteEventResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(19, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchContentDeleteEventResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchContentDeleteEventResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchContentDeleteEventResponseParamsProxyToResponder implements ServiceWorker.DispatchContentDeleteEventResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchContentDeleteEventResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchContentDeleteEventResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchContentDeleteEventResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(19, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ExtendableMessageEvent event;

        public TimeDelta timeout;

        private ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutParams(int version) {
            super(24, version);
        }

        public ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutParams() {
            this(0);
        }

        public static ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutParams decode(Decoder decoder0) {
            ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.event = ExtendableMessageEvent.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.timeout = TimeDelta.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.event, 8, false);
            encoder0.encode((Struct)this.timeout, 16, false);
        }
    }

    static final class ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParams() {
            this(0);
        }

        public static ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParams decode(Decoder decoder0) {
            ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.DispatchExtendableMessageEventWithCustomTimeoutResponse mCallback;

        ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParamsForwardToCallback(ServiceWorker.DispatchExtendableMessageEventWithCustomTimeoutResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(20, 2))
                    return false;
                ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParams response = ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParamsProxyToResponder implements ServiceWorker.DispatchExtendableMessageEventWithCustomTimeoutResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParams _response = new ServiceWorker_Internal.ServiceWorkerDispatchExtendableMessageEventWithCustomTimeoutResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(20, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerPingParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerPingParams(int version) {
            super(8, version);
        }

        public ServiceWorkerPingParams() {
            this(0);
        }

        public static ServiceWorkerPingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerPingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerPingParams decode(Decoder decoder0) {
            ServiceWorkerPingParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerPingParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerPingResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerPingResponseParams(int version) {
            super(8, version);
        }

        public ServiceWorkerPingResponseParams() {
            this(0);
        }

        public static ServiceWorkerPingResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerPingResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerPingResponseParams decode(Decoder decoder0) {
            ServiceWorkerPingResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerPingResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class ServiceWorkerPingResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorker.PingResponse mCallback;

        ServiceWorkerPingResponseParamsForwardToCallback(ServiceWorker.PingResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(21, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerPingResponseParamsProxyToResponder implements ServiceWorker.PingResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerPingResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            ServiceWorker_Internal.ServiceWorkerPingResponseParams _response = new ServiceWorker_Internal.ServiceWorkerPingResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(21, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerSetIdleTimerDelayToZeroParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerSetIdleTimerDelayToZeroParams(int version) {
            super(8, version);
        }

        public ServiceWorkerSetIdleTimerDelayToZeroParams() {
            this(0);
        }

        public static ServiceWorkerSetIdleTimerDelayToZeroParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerSetIdleTimerDelayToZeroParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerSetIdleTimerDelayToZeroParams decode(Decoder decoder0) {
            ServiceWorkerSetIdleTimerDelayToZeroParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerSetIdleTimerDelayToZeroParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
