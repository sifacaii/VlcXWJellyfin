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
import org.chromium.url.mojom.Origin;

class PortalHost_Internal {
    public static final Interface.Manager<PortalHost, PortalHost.Proxy> MANAGER = new Interface.Manager<PortalHost, PortalHost.Proxy>() {
        public String getName() {
            return "blink.mojom.PortalHost";
        }

        public int getVersion() {
            return 0;
        }

        public PortalHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PortalHost_Internal.Proxy(core, messageReceiver);
        }

        public PortalHost_Internal.Stub buildStub(Core core, PortalHost impl) {
            return new PortalHost_Internal.Stub(core, impl);
        }

        public PortalHost[] buildArray(int size) {
            return new PortalHost[size];
        }
    };

    private static final int POST_MESSAGE_TO_HOST_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements PortalHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void postMessageToHost(TransferableMessage message, Origin targetOrigin) {
            PortalHost_Internal.PortalHostPostMessageToHostParams _message = new PortalHost_Internal.PortalHostPostMessageToHostParams();
            _message.message = message;
            _message.targetOrigin = targetOrigin;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<PortalHost> {
        Stub(Core core, PortalHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PortalHost_Internal.PortalHostPostMessageToHostParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PortalHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = PortalHost_Internal.PortalHostPostMessageToHostParams.deserialize(messageWithHeader.getPayload());
                        ((PortalHost)getImpl()).postMessageToHost(data.message, data.targetOrigin);
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
                                getCore(), PortalHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PortalHostPostMessageToHostParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public TransferableMessage message;

        public Origin targetOrigin;

        private PortalHostPostMessageToHostParams(int version) {
            super(24, version);
        }

        public PortalHostPostMessageToHostParams() {
            this(0);
        }

        public static PortalHostPostMessageToHostParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PortalHostPostMessageToHostParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PortalHostPostMessageToHostParams decode(Decoder decoder0) {
            PortalHostPostMessageToHostParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PortalHostPostMessageToHostParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.message = TransferableMessage.decode(decoder1);
                decoder1 = decoder0.readPointer(16, true);
                result.targetOrigin = Origin.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.message, 8, false);
            encoder0.encode((Struct)this.targetOrigin, 16, true);
        }
    }
}
