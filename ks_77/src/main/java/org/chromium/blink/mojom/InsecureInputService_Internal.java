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

class InsecureInputService_Internal {
    public static final Interface.Manager<InsecureInputService, InsecureInputService.Proxy> MANAGER = new Interface.Manager<InsecureInputService, InsecureInputService.Proxy>() {
        public String getName() {
            return "blink.mojom.InsecureInputService";
        }

        public int getVersion() {
            return 0;
        }

        public InsecureInputService_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new InsecureInputService_Internal.Proxy(core, messageReceiver);
        }

        public InsecureInputService_Internal.Stub buildStub(Core core, InsecureInputService impl) {
            return new InsecureInputService_Internal.Stub(core, impl);
        }

        public InsecureInputService[] buildArray(int size) {
            return new InsecureInputService[size];
        }
    };

    private static final int DID_EDIT_FIELD_IN_INSECURE_CONTEXT_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements InsecureInputService.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void didEditFieldInInsecureContext() {
            InsecureInputService_Internal.InsecureInputServiceDidEditFieldInInsecureContextParams _message = new InsecureInputService_Internal.InsecureInputServiceDidEditFieldInInsecureContextParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<InsecureInputService> {
        Stub(Core core, InsecureInputService impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(InsecureInputService_Internal.MANAGER, messageWithHeader);
                    case 0:
                        InsecureInputService_Internal.InsecureInputServiceDidEditFieldInInsecureContextParams.deserialize(messageWithHeader.getPayload());
                        ((InsecureInputService)getImpl()).didEditFieldInInsecureContext();
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
                                getCore(), InsecureInputService_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class InsecureInputServiceDidEditFieldInInsecureContextParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private InsecureInputServiceDidEditFieldInInsecureContextParams(int version) {
            super(8, version);
        }

        public InsecureInputServiceDidEditFieldInInsecureContextParams() {
            this(0);
        }

        public static InsecureInputServiceDidEditFieldInInsecureContextParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static InsecureInputServiceDidEditFieldInInsecureContextParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static InsecureInputServiceDidEditFieldInInsecureContextParams decode(Decoder decoder0) {
            InsecureInputServiceDidEditFieldInInsecureContextParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new InsecureInputServiceDidEditFieldInInsecureContextParams(elementsOrVersion);
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
