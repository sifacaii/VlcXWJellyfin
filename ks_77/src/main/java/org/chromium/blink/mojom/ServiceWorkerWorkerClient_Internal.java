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

class ServiceWorkerWorkerClient_Internal {
    public static final Interface.Manager<ServiceWorkerWorkerClient, ServiceWorkerWorkerClient.Proxy> MANAGER = new Interface.Manager<ServiceWorkerWorkerClient, ServiceWorkerWorkerClient.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerWorkerClient";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerWorkerClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerWorkerClient_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerWorkerClient_Internal.Stub buildStub(Core core, ServiceWorkerWorkerClient impl) {
            return new ServiceWorkerWorkerClient_Internal.Stub(core, impl);
        }

        public ServiceWorkerWorkerClient[] buildArray(int size) {
            return new ServiceWorkerWorkerClient[size];
        }
    };

    private static final int ON_CONTROLLER_CHANGED_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerWorkerClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onControllerChanged(int mode) {
            ServiceWorkerWorkerClient_Internal.ServiceWorkerWorkerClientOnControllerChangedParams _message = new ServiceWorkerWorkerClient_Internal.ServiceWorkerWorkerClientOnControllerChangedParams();
            _message.mode = mode;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerWorkerClient> {
        Stub(Core core, ServiceWorkerWorkerClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorkerWorkerClient_Internal.ServiceWorkerWorkerClientOnControllerChangedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerWorkerClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ServiceWorkerWorkerClient_Internal.ServiceWorkerWorkerClientOnControllerChangedParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerWorkerClient)getImpl()).onControllerChanged(data.mode);
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
                                getCore(), ServiceWorkerWorkerClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerWorkerClientOnControllerChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int mode;

        private ServiceWorkerWorkerClientOnControllerChangedParams(int version) {
            super(16, version);
        }

        public ServiceWorkerWorkerClientOnControllerChangedParams() {
            this(0);
        }

        public static ServiceWorkerWorkerClientOnControllerChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerWorkerClientOnControllerChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerWorkerClientOnControllerChangedParams decode(Decoder decoder0) {
            ServiceWorkerWorkerClientOnControllerChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerWorkerClientOnControllerChangedParams(elementsOrVersion);
                result.mode = decoder0.readInt(8);
                ControllerServiceWorkerMode.validate(result.mode);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.mode, 8);
        }
    }
}
