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

class ServiceWorkerStreamCallback_Internal {
    public static final Interface.Manager<ServiceWorkerStreamCallback, ServiceWorkerStreamCallback.Proxy> MANAGER = new Interface.Manager<ServiceWorkerStreamCallback, ServiceWorkerStreamCallback.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerStreamCallback";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerStreamCallback_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerStreamCallback_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerStreamCallback_Internal.Stub buildStub(Core core, ServiceWorkerStreamCallback impl) {
            return new ServiceWorkerStreamCallback_Internal.Stub(core, impl);
        }

        public ServiceWorkerStreamCallback[] buildArray(int size) {
            return new ServiceWorkerStreamCallback[size];
        }
    };

    private static final int ON_COMPLETED_ORDINAL = 0;

    private static final int ON_ABORTED_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerStreamCallback.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onCompleted() {
            ServiceWorkerStreamCallback_Internal.ServiceWorkerStreamCallbackOnCompletedParams _message = new ServiceWorkerStreamCallback_Internal.ServiceWorkerStreamCallbackOnCompletedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onAborted() {
            ServiceWorkerStreamCallback_Internal.ServiceWorkerStreamCallbackOnAbortedParams _message = new ServiceWorkerStreamCallback_Internal.ServiceWorkerStreamCallbackOnAbortedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerStreamCallback> {
        Stub(Core core, ServiceWorkerStreamCallback impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerStreamCallback_Internal.MANAGER, messageWithHeader);
                    case 0:
                        ServiceWorkerStreamCallback_Internal.ServiceWorkerStreamCallbackOnCompletedParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerStreamCallback)getImpl()).onCompleted();
                        return true;
                    case 1:
                        ServiceWorkerStreamCallback_Internal.ServiceWorkerStreamCallbackOnAbortedParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerStreamCallback)getImpl()).onAborted();
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
                                getCore(), ServiceWorkerStreamCallback_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerStreamCallbackOnCompletedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerStreamCallbackOnCompletedParams(int version) {
            super(8, version);
        }

        public ServiceWorkerStreamCallbackOnCompletedParams() {
            this(0);
        }

        public static ServiceWorkerStreamCallbackOnCompletedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerStreamCallbackOnCompletedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerStreamCallbackOnCompletedParams decode(Decoder decoder0) {
            ServiceWorkerStreamCallbackOnCompletedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerStreamCallbackOnCompletedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerStreamCallbackOnAbortedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerStreamCallbackOnAbortedParams(int version) {
            super(8, version);
        }

        public ServiceWorkerStreamCallbackOnAbortedParams() {
            this(0);
        }

        public static ServiceWorkerStreamCallbackOnAbortedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerStreamCallbackOnAbortedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerStreamCallbackOnAbortedParams decode(Decoder decoder0) {
            ServiceWorkerStreamCallbackOnAbortedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerStreamCallbackOnAbortedParams(elementsOrVersion);
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
