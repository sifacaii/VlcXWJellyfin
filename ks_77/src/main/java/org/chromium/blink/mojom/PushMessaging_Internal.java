package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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

class PushMessaging_Internal {
    public static final Interface.Manager<PushMessaging, PushMessaging.Proxy> MANAGER = new Interface.Manager<PushMessaging, PushMessaging.Proxy>() {
        public String getName() {
            return "blink.mojom.PushMessaging";
        }

        public int getVersion() {
            return 0;
        }

        public PushMessaging_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PushMessaging_Internal.Proxy(core, messageReceiver);
        }

        public PushMessaging_Internal.Stub buildStub(Core core, PushMessaging impl) {
            return new PushMessaging_Internal.Stub(core, impl);
        }

        public PushMessaging[] buildArray(int size) {
            return new PushMessaging[size];
        }
    };

    private static final int SUBSCRIBE_ORDINAL = 0;

    private static final int UNSUBSCRIBE_ORDINAL = 1;

    private static final int GET_SUBSCRIPTION_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements PushMessaging.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void subscribe(long serviceWorkerRegistrationId, PushSubscriptionOptions options, boolean userGesture, PushMessaging.SubscribeResponse callback) {
            PushMessaging_Internal.PushMessagingSubscribeParams _message = new PushMessaging_Internal.PushMessagingSubscribeParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            _message.options = options;
            _message.userGesture = userGesture;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new PushMessaging_Internal.PushMessagingSubscribeResponseParamsForwardToCallback(callback));
        }

        public void unsubscribe(long serviceWorkerRegistrationId, PushMessaging.UnsubscribeResponse callback) {
            PushMessaging_Internal.PushMessagingUnsubscribeParams _message = new PushMessaging_Internal.PushMessagingUnsubscribeParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new PushMessaging_Internal.PushMessagingUnsubscribeResponseParamsForwardToCallback(callback));
        }

        public void getSubscription(long serviceWorkerRegistrationId, PushMessaging.GetSubscriptionResponse callback) {
            PushMessaging_Internal.PushMessagingGetSubscriptionParams _message = new PushMessaging_Internal.PushMessagingGetSubscriptionParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new PushMessaging_Internal.PushMessagingGetSubscriptionResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<PushMessaging> {
        Stub(Core core, PushMessaging impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PushMessaging_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                PushMessaging_Internal.PushMessagingSubscribeParams pushMessagingSubscribeParams;
                PushMessaging_Internal.PushMessagingUnsubscribeParams pushMessagingUnsubscribeParams;
                PushMessaging_Internal.PushMessagingGetSubscriptionParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), PushMessaging_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        pushMessagingSubscribeParams = PushMessaging_Internal.PushMessagingSubscribeParams.deserialize(messageWithHeader.getPayload());
                        ((PushMessaging)getImpl()).subscribe(pushMessagingSubscribeParams.serviceWorkerRegistrationId, pushMessagingSubscribeParams.options, pushMessagingSubscribeParams.userGesture, new PushMessaging_Internal.PushMessagingSubscribeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        pushMessagingUnsubscribeParams = PushMessaging_Internal.PushMessagingUnsubscribeParams.deserialize(messageWithHeader.getPayload());
                        ((PushMessaging)getImpl()).unsubscribe(pushMessagingUnsubscribeParams.serviceWorkerRegistrationId, new PushMessaging_Internal.PushMessagingUnsubscribeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = PushMessaging_Internal.PushMessagingGetSubscriptionParams.deserialize(messageWithHeader.getPayload());
                        ((PushMessaging)getImpl()).getSubscription(data.serviceWorkerRegistrationId, new PushMessaging_Internal.PushMessagingGetSubscriptionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PushMessagingSubscribeParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        public PushSubscriptionOptions options;

        public boolean userGesture;

        private PushMessagingSubscribeParams(int version) {
            super(32, version);
        }

        public PushMessagingSubscribeParams() {
            this(0);
        }

        public static PushMessagingSubscribeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PushMessagingSubscribeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PushMessagingSubscribeParams decode(Decoder decoder0) {
            PushMessagingSubscribeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PushMessagingSubscribeParams(elementsOrVersion);
                result.serviceWorkerRegistrationId = decoder0.readLong(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.options = PushSubscriptionOptions.decode(decoder1);
                result.userGesture = decoder0.readBoolean(24, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerRegistrationId, 8);
            encoder0.encode(this.options, 16, false);
            encoder0.encode(this.userGesture, 24, 0);
        }
    }

    static final class PushMessagingSubscribeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public PushSubscription subscription;

        private PushMessagingSubscribeResponseParams(int version) {
            super(24, version);
        }

        public PushMessagingSubscribeResponseParams() {
            this(0);
        }

        public static PushMessagingSubscribeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PushMessagingSubscribeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PushMessagingSubscribeResponseParams decode(Decoder decoder0) {
            PushMessagingSubscribeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PushMessagingSubscribeResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PushRegistrationStatus.validate(result.status);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.subscription = PushSubscription.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.subscription, 16, true);
        }
    }

    static class PushMessagingSubscribeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PushMessaging.SubscribeResponse mCallback;

        PushMessagingSubscribeResponseParamsForwardToCallback(PushMessaging.SubscribeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                PushMessaging_Internal.PushMessagingSubscribeResponseParams response = PushMessaging_Internal.PushMessagingSubscribeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.subscription);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PushMessagingSubscribeResponseParamsProxyToResponder implements PushMessaging.SubscribeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PushMessagingSubscribeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, PushSubscription subscription) {
            PushMessaging_Internal.PushMessagingSubscribeResponseParams _response = new PushMessaging_Internal.PushMessagingSubscribeResponseParams();
            _response.status = status.intValue();
            _response.subscription = subscription;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class PushMessagingUnsubscribeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        private PushMessagingUnsubscribeParams(int version) {
            super(16, version);
        }

        public PushMessagingUnsubscribeParams() {
            this(0);
        }

        public static PushMessagingUnsubscribeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PushMessagingUnsubscribeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PushMessagingUnsubscribeParams decode(Decoder decoder0) {
            PushMessagingUnsubscribeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PushMessagingUnsubscribeParams(elementsOrVersion);
                result.serviceWorkerRegistrationId = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerRegistrationId, 8);
        }
    }

    static final class PushMessagingUnsubscribeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int errorType;

        public boolean didUnsubscribe;

        public String errorMessage;

        private PushMessagingUnsubscribeResponseParams(int version) {
            super(24, version);
        }

        public PushMessagingUnsubscribeResponseParams() {
            this(0);
        }

        public static PushMessagingUnsubscribeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PushMessagingUnsubscribeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PushMessagingUnsubscribeResponseParams decode(Decoder decoder0) {
            PushMessagingUnsubscribeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PushMessagingUnsubscribeResponseParams(elementsOrVersion);
                result.errorType = decoder0.readInt(8);
                PushErrorType.validate(result.errorType);
                result.didUnsubscribe = decoder0.readBoolean(12, 0);
                result.errorMessage = decoder0.readString(16, true);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.errorType, 8);
            encoder0.encode(this.didUnsubscribe, 12, 0);
            encoder0.encode(this.errorMessage, 16, true);
        }
    }

    static class PushMessagingUnsubscribeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PushMessaging.UnsubscribeResponse mCallback;

        PushMessagingUnsubscribeResponseParamsForwardToCallback(PushMessaging.UnsubscribeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                PushMessaging_Internal.PushMessagingUnsubscribeResponseParams response = PushMessaging_Internal.PushMessagingUnsubscribeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.errorType), Boolean.valueOf(response.didUnsubscribe), response.errorMessage);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PushMessagingUnsubscribeResponseParamsProxyToResponder implements PushMessaging.UnsubscribeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PushMessagingUnsubscribeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer errorType, Boolean didUnsubscribe, String errorMessage) {
            PushMessaging_Internal.PushMessagingUnsubscribeResponseParams _response = new PushMessaging_Internal.PushMessagingUnsubscribeResponseParams();
            _response.errorType = errorType.intValue();
            _response.didUnsubscribe = didUnsubscribe.booleanValue();
            _response.errorMessage = errorMessage;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class PushMessagingGetSubscriptionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        private PushMessagingGetSubscriptionParams(int version) {
            super(16, version);
        }

        public PushMessagingGetSubscriptionParams() {
            this(0);
        }

        public static PushMessagingGetSubscriptionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PushMessagingGetSubscriptionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PushMessagingGetSubscriptionParams decode(Decoder decoder0) {
            PushMessagingGetSubscriptionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PushMessagingGetSubscriptionParams(elementsOrVersion);
                result.serviceWorkerRegistrationId = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerRegistrationId, 8);
        }
    }

    static final class PushMessagingGetSubscriptionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public PushSubscription subscription;

        private PushMessagingGetSubscriptionResponseParams(int version) {
            super(24, version);
        }

        public PushMessagingGetSubscriptionResponseParams() {
            this(0);
        }

        public static PushMessagingGetSubscriptionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PushMessagingGetSubscriptionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PushMessagingGetSubscriptionResponseParams decode(Decoder decoder0) {
            PushMessagingGetSubscriptionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PushMessagingGetSubscriptionResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PushGetRegistrationStatus.validate(result.status);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.subscription = PushSubscription.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.subscription, 16, true);
        }
    }

    static class PushMessagingGetSubscriptionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final PushMessaging.GetSubscriptionResponse mCallback;

        PushMessagingGetSubscriptionResponseParamsForwardToCallback(PushMessaging.GetSubscriptionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                PushMessaging_Internal.PushMessagingGetSubscriptionResponseParams response = PushMessaging_Internal.PushMessagingGetSubscriptionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.subscription);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PushMessagingGetSubscriptionResponseParamsProxyToResponder implements PushMessaging.GetSubscriptionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PushMessagingGetSubscriptionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, PushSubscription subscription) {
            PushMessaging_Internal.PushMessagingGetSubscriptionResponseParams _response = new PushMessaging_Internal.PushMessagingGetSubscriptionResponseParams();
            _response.status = status.intValue();
            _response.subscription = subscription;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
