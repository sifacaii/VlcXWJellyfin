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

class ControllerServiceWorkerConnector_Internal {
    public static final Interface.Manager<ControllerServiceWorkerConnector, ControllerServiceWorkerConnector.Proxy> MANAGER = new Interface.Manager<ControllerServiceWorkerConnector, ControllerServiceWorkerConnector.Proxy>() {
        public String getName() {
            return "blink.mojom.ControllerServiceWorkerConnector";
        }

        public int getVersion() {
            return 0;
        }

        public ControllerServiceWorkerConnector_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ControllerServiceWorkerConnector_Internal.Proxy(core, messageReceiver);
        }

        public ControllerServiceWorkerConnector_Internal.Stub buildStub(Core core, ControllerServiceWorkerConnector impl) {
            return new ControllerServiceWorkerConnector_Internal.Stub(core, impl);
        }

        public ControllerServiceWorkerConnector[] buildArray(int size) {
            return new ControllerServiceWorkerConnector[size];
        }
    };

    private static final int UPDATE_CONTROLLER_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ControllerServiceWorkerConnector.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void updateController(ControllerServiceWorker controller) {
            ControllerServiceWorkerConnector_Internal.ControllerServiceWorkerConnectorUpdateControllerParams _message = new ControllerServiceWorkerConnector_Internal.ControllerServiceWorkerConnectorUpdateControllerParams();
            _message.controller = controller;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<ControllerServiceWorkerConnector> {
        Stub(Core core, ControllerServiceWorkerConnector impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ControllerServiceWorkerConnector_Internal.ControllerServiceWorkerConnectorUpdateControllerParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ControllerServiceWorkerConnector_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ControllerServiceWorkerConnector_Internal.ControllerServiceWorkerConnectorUpdateControllerParams.deserialize(messageWithHeader.getPayload());
                        ((ControllerServiceWorkerConnector)getImpl()).updateController(data.controller);
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
                                getCore(), ControllerServiceWorkerConnector_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ControllerServiceWorkerConnectorUpdateControllerParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ControllerServiceWorker controller;

        private ControllerServiceWorkerConnectorUpdateControllerParams(int version) {
            super(16, version);
        }

        public ControllerServiceWorkerConnectorUpdateControllerParams() {
            this(0);
        }

        public static ControllerServiceWorkerConnectorUpdateControllerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ControllerServiceWorkerConnectorUpdateControllerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ControllerServiceWorkerConnectorUpdateControllerParams decode(Decoder decoder0) {
            ControllerServiceWorkerConnectorUpdateControllerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ControllerServiceWorkerConnectorUpdateControllerParams(elementsOrVersion);
                result.controller = (ControllerServiceWorker)decoder0.readServiceInterface(8, true, ControllerServiceWorker.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.controller, 8, true, ControllerServiceWorker.MANAGER);
        }
    }
}
