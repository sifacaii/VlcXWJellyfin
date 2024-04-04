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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class ServiceWorkerFetchResponseCallback_Internal {
    public static final Interface.Manager<ServiceWorkerFetchResponseCallback, ServiceWorkerFetchResponseCallback.Proxy> MANAGER = new Interface.Manager<ServiceWorkerFetchResponseCallback, ServiceWorkerFetchResponseCallback.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerFetchResponseCallback";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerFetchResponseCallback_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerFetchResponseCallback_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerFetchResponseCallback_Internal.Stub buildStub(Core core, ServiceWorkerFetchResponseCallback impl) {
            return new ServiceWorkerFetchResponseCallback_Internal.Stub(core, impl);
        }

        public ServiceWorkerFetchResponseCallback[] buildArray(int size) {
            return new ServiceWorkerFetchResponseCallback[size];
        }
    };

    private static final int ON_RESPONSE_ORDINAL = 0;

    private static final int ON_RESPONSE_STREAM_ORDINAL = 1;

    private static final int ON_FALLBACK_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerFetchResponseCallback.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onResponse(FetchApiResponse response, ServiceWorkerFetchEventTiming timing) {
            ServiceWorkerFetchResponseCallback_Internal.ServiceWorkerFetchResponseCallbackOnResponseParams _message = new ServiceWorkerFetchResponseCallback_Internal.ServiceWorkerFetchResponseCallbackOnResponseParams();
            _message.response = response;
            _message.timing = timing;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onResponseStream(FetchApiResponse response, ServiceWorkerStreamHandle bodyAsStream, ServiceWorkerFetchEventTiming timing) {
            ServiceWorkerFetchResponseCallback_Internal.ServiceWorkerFetchResponseCallbackOnResponseStreamParams _message = new ServiceWorkerFetchResponseCallback_Internal.ServiceWorkerFetchResponseCallbackOnResponseStreamParams();
            _message.response = response;
            _message.bodyAsStream = bodyAsStream;
            _message.timing = timing;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void onFallback(ServiceWorkerFetchEventTiming timing) {
            ServiceWorkerFetchResponseCallback_Internal.ServiceWorkerFetchResponseCallbackOnFallbackParams _message = new ServiceWorkerFetchResponseCallback_Internal.ServiceWorkerFetchResponseCallbackOnFallbackParams();
            _message.timing = timing;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerFetchResponseCallback> {
        Stub(Core core, ServiceWorkerFetchResponseCallback impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorkerFetchResponseCallback_Internal.ServiceWorkerFetchResponseCallbackOnResponseParams serviceWorkerFetchResponseCallbackOnResponseParams;
                ServiceWorkerFetchResponseCallback_Internal.ServiceWorkerFetchResponseCallbackOnResponseStreamParams serviceWorkerFetchResponseCallbackOnResponseStreamParams;
                ServiceWorkerFetchResponseCallback_Internal.ServiceWorkerFetchResponseCallbackOnFallbackParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerFetchResponseCallback_Internal.MANAGER, messageWithHeader);
                    case 0:
                        serviceWorkerFetchResponseCallbackOnResponseParams = ServiceWorkerFetchResponseCallback_Internal.ServiceWorkerFetchResponseCallbackOnResponseParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerFetchResponseCallback)getImpl()).onResponse(serviceWorkerFetchResponseCallbackOnResponseParams.response, serviceWorkerFetchResponseCallbackOnResponseParams.timing);
                        return true;
                    case 1:
                        serviceWorkerFetchResponseCallbackOnResponseStreamParams = ServiceWorkerFetchResponseCallback_Internal.ServiceWorkerFetchResponseCallbackOnResponseStreamParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerFetchResponseCallback)getImpl()).onResponseStream(serviceWorkerFetchResponseCallbackOnResponseStreamParams.response, serviceWorkerFetchResponseCallbackOnResponseStreamParams.bodyAsStream, serviceWorkerFetchResponseCallbackOnResponseStreamParams.timing);
                        return true;
                    case 2:
                        data = ServiceWorkerFetchResponseCallback_Internal.ServiceWorkerFetchResponseCallbackOnFallbackParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerFetchResponseCallback)getImpl()).onFallback(data.timing);
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
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), ServiceWorkerFetchResponseCallback_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerFetchResponseCallbackOnResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FetchApiResponse response;

        public ServiceWorkerFetchEventTiming timing;

        private ServiceWorkerFetchResponseCallbackOnResponseParams(int version) {
            super(24, version);
        }

        public ServiceWorkerFetchResponseCallbackOnResponseParams() {
            this(0);
        }

        public static ServiceWorkerFetchResponseCallbackOnResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerFetchResponseCallbackOnResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerFetchResponseCallbackOnResponseParams decode(Decoder decoder0) {
            ServiceWorkerFetchResponseCallbackOnResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerFetchResponseCallbackOnResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.response = FetchApiResponse.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.timing = ServiceWorkerFetchEventTiming.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.response, 8, false);
            encoder0.encode(this.timing, 16, false);
        }
    }

    static final class ServiceWorkerFetchResponseCallbackOnResponseStreamParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FetchApiResponse response;

        public ServiceWorkerStreamHandle bodyAsStream;

        public ServiceWorkerFetchEventTiming timing;

        private ServiceWorkerFetchResponseCallbackOnResponseStreamParams(int version) {
            super(32, version);
        }

        public ServiceWorkerFetchResponseCallbackOnResponseStreamParams() {
            this(0);
        }

        public static ServiceWorkerFetchResponseCallbackOnResponseStreamParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerFetchResponseCallbackOnResponseStreamParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerFetchResponseCallbackOnResponseStreamParams decode(Decoder decoder0) {
            ServiceWorkerFetchResponseCallbackOnResponseStreamParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerFetchResponseCallbackOnResponseStreamParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.response = FetchApiResponse.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.bodyAsStream = ServiceWorkerStreamHandle.decode(decoder1);
                decoder1 = decoder0.readPointer(24, false);
                result.timing = ServiceWorkerFetchEventTiming.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.response, 8, false);
            encoder0.encode(this.bodyAsStream, 16, false);
            encoder0.encode(this.timing, 24, false);
        }
    }

    static final class ServiceWorkerFetchResponseCallbackOnFallbackParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ServiceWorkerFetchEventTiming timing;

        private ServiceWorkerFetchResponseCallbackOnFallbackParams(int version) {
            super(16, version);
        }

        public ServiceWorkerFetchResponseCallbackOnFallbackParams() {
            this(0);
        }

        public static ServiceWorkerFetchResponseCallbackOnFallbackParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerFetchResponseCallbackOnFallbackParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerFetchResponseCallbackOnFallbackParams decode(Decoder decoder0) {
            ServiceWorkerFetchResponseCallbackOnFallbackParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerFetchResponseCallbackOnFallbackParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.timing = ServiceWorkerFetchEventTiming.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.timing, 8, false);
        }
    }
}
