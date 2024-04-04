package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class PresentationReceiver_Internal {
    public static final Interface.Manager<PresentationReceiver, PresentationReceiver.Proxy> MANAGER = new Interface.Manager<PresentationReceiver, PresentationReceiver.Proxy>() {
        public String getName() {
            return "blink.mojom.PresentationReceiver";
        }

        public int getVersion() {
            return 0;
        }

        public PresentationReceiver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PresentationReceiver_Internal.Proxy(core, messageReceiver);
        }

        public PresentationReceiver_Internal.Stub buildStub(Core core, PresentationReceiver impl) {
            return new PresentationReceiver_Internal.Stub(core, impl);
        }

        public PresentationReceiver[] buildArray(int size) {
            return new PresentationReceiver[size];
        }
    };

    private static final int ON_RECEIVER_CONNECTION_AVAILABLE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements PresentationReceiver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onReceiverConnectionAvailable(PresentationInfo info, PresentationConnection controllerConnection, InterfaceRequest<PresentationConnection> receiverConnectionRequest) {
            PresentationReceiver_Internal.PresentationReceiverOnReceiverConnectionAvailableParams _message = new PresentationReceiver_Internal.PresentationReceiverOnReceiverConnectionAvailableParams();
            _message.info = info;
            _message.controllerConnection = controllerConnection;
            _message.receiverConnectionRequest = receiverConnectionRequest;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<PresentationReceiver> {
        Stub(Core core, PresentationReceiver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PresentationReceiver_Internal.PresentationReceiverOnReceiverConnectionAvailableParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PresentationReceiver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = PresentationReceiver_Internal.PresentationReceiverOnReceiverConnectionAvailableParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationReceiver)getImpl()).onReceiverConnectionAvailable(data.info, data.controllerConnection, data.receiverConnectionRequest);
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
                                getCore(), PresentationReceiver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PresentationReceiverOnReceiverConnectionAvailableParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PresentationInfo info;

        public PresentationConnection controllerConnection;

        public InterfaceRequest<PresentationConnection> receiverConnectionRequest;

        private PresentationReceiverOnReceiverConnectionAvailableParams(int version) {
            super(32, version);
        }

        public PresentationReceiverOnReceiverConnectionAvailableParams() {
            this(0);
        }

        public static PresentationReceiverOnReceiverConnectionAvailableParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationReceiverOnReceiverConnectionAvailableParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationReceiverOnReceiverConnectionAvailableParams decode(Decoder decoder0) {
            PresentationReceiverOnReceiverConnectionAvailableParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationReceiverOnReceiverConnectionAvailableParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.info = PresentationInfo.decode(decoder1);
                result.controllerConnection = (PresentationConnection)decoder0.readServiceInterface(16, false, PresentationConnection.MANAGER);
                result.receiverConnectionRequest = decoder0.readInterfaceRequest(24, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.info, 8, false);
            encoder0.encode(this.controllerConnection, 16, false, PresentationConnection.MANAGER);
            encoder0.encode(this.receiverConnectionRequest, 24, false);
        }
    }
}
