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

class CookieStore_Internal {
    public static final Interface.Manager<CookieStore, CookieStore.Proxy> MANAGER = new Interface.Manager<CookieStore, CookieStore.Proxy>() {
        public String getName() {
            return "blink.mojom.CookieStore";
        }

        public int getVersion() {
            return 0;
        }

        public CookieStore_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CookieStore_Internal.Proxy(core, messageReceiver);
        }

        public CookieStore_Internal.Stub buildStub(Core core, CookieStore impl) {
            return new CookieStore_Internal.Stub(core, impl);
        }

        public CookieStore[] buildArray(int size) {
            return new CookieStore[size];
        }
    };

    private static final int APPEND_SUBSCRIPTIONS_ORDINAL = 0;

    private static final int GET_SUBSCRIPTIONS_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements CookieStore.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void appendSubscriptions(long serviceWorkerRegistrationId, CookieChangeSubscription[] subscriptions, CookieStore.AppendSubscriptionsResponse callback) {
            CookieStore_Internal.CookieStoreAppendSubscriptionsParams _message = new CookieStore_Internal.CookieStoreAppendSubscriptionsParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            _message.subscriptions = subscriptions;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new CookieStore_Internal.CookieStoreAppendSubscriptionsResponseParamsForwardToCallback(callback));
        }

        public void getSubscriptions(long serviceWorkerRegistrationId, CookieStore.GetSubscriptionsResponse callback) {
            CookieStore_Internal.CookieStoreGetSubscriptionsParams _message = new CookieStore_Internal.CookieStoreGetSubscriptionsParams();
            _message.serviceWorkerRegistrationId = serviceWorkerRegistrationId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new CookieStore_Internal.CookieStoreGetSubscriptionsResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<CookieStore> {
        Stub(Core core, CookieStore impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CookieStore_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                CookieStore_Internal.CookieStoreAppendSubscriptionsParams cookieStoreAppendSubscriptionsParams;
                CookieStore_Internal.CookieStoreGetSubscriptionsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), CookieStore_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        cookieStoreAppendSubscriptionsParams = CookieStore_Internal.CookieStoreAppendSubscriptionsParams.deserialize(messageWithHeader.getPayload());
                        ((CookieStore)getImpl()).appendSubscriptions(cookieStoreAppendSubscriptionsParams.serviceWorkerRegistrationId, cookieStoreAppendSubscriptionsParams.subscriptions, new CookieStore_Internal.CookieStoreAppendSubscriptionsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        data = CookieStore_Internal.CookieStoreGetSubscriptionsParams.deserialize(messageWithHeader.getPayload());
                        ((CookieStore)getImpl()).getSubscriptions(data.serviceWorkerRegistrationId, new CookieStore_Internal.CookieStoreGetSubscriptionsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CookieStoreAppendSubscriptionsParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        public CookieChangeSubscription[] subscriptions;

        private CookieStoreAppendSubscriptionsParams(int version) {
            super(24, version);
        }

        public CookieStoreAppendSubscriptionsParams() {
            this(0);
        }

        public static CookieStoreAppendSubscriptionsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieStoreAppendSubscriptionsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieStoreAppendSubscriptionsParams decode(Decoder decoder0) {
            CookieStoreAppendSubscriptionsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CookieStoreAppendSubscriptionsParams(elementsOrVersion);
                result.serviceWorkerRegistrationId = decoder0.readLong(8);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.subscriptions = new CookieChangeSubscription[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.subscriptions[i1] = CookieChangeSubscription.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerRegistrationId, 8);
            if (this.subscriptions == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.subscriptions.length, 16, -1);
                for (int i0 = 0; i0 < this.subscriptions.length; i0++)
                    encoder1.encode(this.subscriptions[i0], 8 + 8 * i0, false);
            }
        }
    }

    static final class CookieStoreAppendSubscriptionsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private CookieStoreAppendSubscriptionsResponseParams(int version) {
            super(16, version);
        }

        public CookieStoreAppendSubscriptionsResponseParams() {
            this(0);
        }

        public static CookieStoreAppendSubscriptionsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieStoreAppendSubscriptionsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieStoreAppendSubscriptionsResponseParams decode(Decoder decoder0) {
            CookieStoreAppendSubscriptionsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CookieStoreAppendSubscriptionsResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class CookieStoreAppendSubscriptionsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CookieStore.AppendSubscriptionsResponse mCallback;

        CookieStoreAppendSubscriptionsResponseParamsForwardToCallback(CookieStore.AppendSubscriptionsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                CookieStore_Internal.CookieStoreAppendSubscriptionsResponseParams response = CookieStore_Internal.CookieStoreAppendSubscriptionsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CookieStoreAppendSubscriptionsResponseParamsProxyToResponder implements CookieStore.AppendSubscriptionsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CookieStoreAppendSubscriptionsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            CookieStore_Internal.CookieStoreAppendSubscriptionsResponseParams _response = new CookieStore_Internal.CookieStoreAppendSubscriptionsResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CookieStoreGetSubscriptionsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long serviceWorkerRegistrationId;

        private CookieStoreGetSubscriptionsParams(int version) {
            super(16, version);
        }

        public CookieStoreGetSubscriptionsParams() {
            this(0);
        }

        public static CookieStoreGetSubscriptionsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieStoreGetSubscriptionsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieStoreGetSubscriptionsParams decode(Decoder decoder0) {
            CookieStoreGetSubscriptionsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CookieStoreGetSubscriptionsParams(elementsOrVersion);
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

    static final class CookieStoreGetSubscriptionsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CookieChangeSubscription[] subscriptions;

        public boolean success;

        private CookieStoreGetSubscriptionsResponseParams(int version) {
            super(24, version);
        }

        public CookieStoreGetSubscriptionsResponseParams() {
            this(0);
        }

        public static CookieStoreGetSubscriptionsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CookieStoreGetSubscriptionsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CookieStoreGetSubscriptionsResponseParams decode(Decoder decoder0) {
            CookieStoreGetSubscriptionsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CookieStoreGetSubscriptionsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.subscriptions = new CookieChangeSubscription[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.subscriptions[i1] = CookieChangeSubscription.decode(decoder2);
                }
                result.success = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.subscriptions == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.subscriptions.length, 8, -1);
                for (int i0 = 0; i0 < this.subscriptions.length; i0++)
                    encoder1.encode(this.subscriptions[i0], 8 + 8 * i0, false);
            }
            encoder0.encode(this.success, 16, 0);
        }
    }

    static class CookieStoreGetSubscriptionsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CookieStore.GetSubscriptionsResponse mCallback;

        CookieStoreGetSubscriptionsResponseParamsForwardToCallback(CookieStore.GetSubscriptionsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                CookieStore_Internal.CookieStoreGetSubscriptionsResponseParams response = CookieStore_Internal.CookieStoreGetSubscriptionsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.subscriptions, Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CookieStoreGetSubscriptionsResponseParamsProxyToResponder implements CookieStore.GetSubscriptionsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CookieStoreGetSubscriptionsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(CookieChangeSubscription[] subscriptions, Boolean success) {
            CookieStore_Internal.CookieStoreGetSubscriptionsResponseParams _response = new CookieStore_Internal.CookieStoreGetSubscriptionsResponseParams();
            _response.subscriptions = subscriptions;
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
