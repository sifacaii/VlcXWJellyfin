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

class ServiceWorkerObjectHost_Internal {
    public static final Interface.Manager<ServiceWorkerObjectHost, ServiceWorkerObjectHost.Proxy> MANAGER = new Interface.Manager<ServiceWorkerObjectHost, ServiceWorkerObjectHost.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerObjectHost";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerObjectHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerObjectHost_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerObjectHost_Internal.Stub buildStub(Core core, ServiceWorkerObjectHost impl) {
            return new ServiceWorkerObjectHost_Internal.Stub(core, impl);
        }

        public ServiceWorkerObjectHost[] buildArray(int size) {
            return new ServiceWorkerObjectHost[size];
        }
    };

    private static final int POST_MESSAGE_TO_SERVICE_WORKER_ORDINAL = 0;

    private static final int TERMINATE_FOR_TESTING_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerObjectHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void postMessageToServiceWorker(TransferableMessage message) {
            ServiceWorkerObjectHost_Internal.ServiceWorkerObjectHostPostMessageToServiceWorkerParams _message = new ServiceWorkerObjectHost_Internal.ServiceWorkerObjectHostPostMessageToServiceWorkerParams();
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void terminateForTesting(ServiceWorkerObjectHost.TerminateForTestingResponse callback) {
            ServiceWorkerObjectHost_Internal.ServiceWorkerObjectHostTerminateForTestingParams _message = new ServiceWorkerObjectHost_Internal.ServiceWorkerObjectHostTerminateForTestingParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new ServiceWorkerObjectHost_Internal.ServiceWorkerObjectHostTerminateForTestingResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerObjectHost> {
        Stub(Core core, ServiceWorkerObjectHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorkerObjectHost_Internal.ServiceWorkerObjectHostPostMessageToServiceWorkerParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerObjectHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ServiceWorkerObjectHost_Internal.ServiceWorkerObjectHostPostMessageToServiceWorkerParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerObjectHost)getImpl()).postMessageToServiceWorker(data.message);
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
                                getCore(), ServiceWorkerObjectHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        ServiceWorkerObjectHost_Internal.ServiceWorkerObjectHostTerminateForTestingParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerObjectHost)getImpl()).terminateForTesting(new ServiceWorkerObjectHost_Internal.ServiceWorkerObjectHostTerminateForTestingResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerObjectHostPostMessageToServiceWorkerParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public TransferableMessage message;

        private ServiceWorkerObjectHostPostMessageToServiceWorkerParams(int version) {
            super(16, version);
        }

        public ServiceWorkerObjectHostPostMessageToServiceWorkerParams() {
            this(0);
        }

        public static ServiceWorkerObjectHostPostMessageToServiceWorkerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerObjectHostPostMessageToServiceWorkerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerObjectHostPostMessageToServiceWorkerParams decode(Decoder decoder0) {
            ServiceWorkerObjectHostPostMessageToServiceWorkerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerObjectHostPostMessageToServiceWorkerParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.message = TransferableMessage.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.message, 8, false);
        }
    }

    static final class ServiceWorkerObjectHostTerminateForTestingParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerObjectHostTerminateForTestingParams(int version) {
            super(8, version);
        }

        public ServiceWorkerObjectHostTerminateForTestingParams() {
            this(0);
        }

        public static ServiceWorkerObjectHostTerminateForTestingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerObjectHostTerminateForTestingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerObjectHostTerminateForTestingParams decode(Decoder decoder0) {
            ServiceWorkerObjectHostTerminateForTestingParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerObjectHostTerminateForTestingParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerObjectHostTerminateForTestingResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerObjectHostTerminateForTestingResponseParams(int version) {
            super(8, version);
        }

        public ServiceWorkerObjectHostTerminateForTestingResponseParams() {
            this(0);
        }

        public static ServiceWorkerObjectHostTerminateForTestingResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerObjectHostTerminateForTestingResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerObjectHostTerminateForTestingResponseParams decode(Decoder decoder0) {
            ServiceWorkerObjectHostTerminateForTestingResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerObjectHostTerminateForTestingResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class ServiceWorkerObjectHostTerminateForTestingResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerObjectHost.TerminateForTestingResponse mCallback;

        ServiceWorkerObjectHostTerminateForTestingResponseParamsForwardToCallback(ServiceWorkerObjectHost.TerminateForTestingResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerObjectHostTerminateForTestingResponseParamsProxyToResponder implements ServiceWorkerObjectHost.TerminateForTestingResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerObjectHostTerminateForTestingResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            ServiceWorkerObjectHost_Internal.ServiceWorkerObjectHostTerminateForTestingResponseParams _response = new ServiceWorkerObjectHost_Internal.ServiceWorkerObjectHostTerminateForTestingResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
