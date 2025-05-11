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

class PortalClient_Internal {
    public static final Interface.Manager<PortalClient, PortalClient.Proxy> MANAGER = new Interface.Manager<PortalClient, PortalClient.Proxy>() {
        public String getName() {
            return "blink.mojom.PortalClient";
        }

        public int getVersion() {
            return 0;
        }

        public PortalClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PortalClient_Internal.Proxy(core, messageReceiver);
        }

        public PortalClient_Internal.Stub buildStub(Core core, PortalClient impl) {
            return new PortalClient_Internal.Stub(core, impl);
        }

        public PortalClient[] buildArray(int size) {
            return new PortalClient[size];
        }
    };

    private static final int FORWARD_MESSAGE_FROM_GUEST_ORDINAL = 0;

    private static final int DISPATCH_LOAD_EVENT_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements PortalClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void forwardMessageFromGuest(TransferableMessage message, Origin sourceOrigin, Origin targetOrigin) {
            PortalClient_Internal.PortalClientForwardMessageFromGuestParams _message = new PortalClient_Internal.PortalClientForwardMessageFromGuestParams();
            _message.message = message;
            _message.sourceOrigin = sourceOrigin;
            _message.targetOrigin = targetOrigin;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void dispatchLoadEvent() {
            PortalClient_Internal.PortalClientDispatchLoadEventParams _message = new PortalClient_Internal.PortalClientDispatchLoadEventParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<PortalClient> {
        Stub(Core core, PortalClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PortalClient_Internal.PortalClientForwardMessageFromGuestParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PortalClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = PortalClient_Internal.PortalClientForwardMessageFromGuestParams.deserialize(messageWithHeader.getPayload());
                        ((PortalClient)getImpl()).forwardMessageFromGuest(data.message, data.sourceOrigin, data.targetOrigin);
                        return true;
                    case 1:
                        PortalClient_Internal.PortalClientDispatchLoadEventParams.deserialize(messageWithHeader.getPayload());
                        ((PortalClient)getImpl()).dispatchLoadEvent();
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
                                getCore(), PortalClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PortalClientForwardMessageFromGuestParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public TransferableMessage message;

        public Origin sourceOrigin;

        public Origin targetOrigin;

        private PortalClientForwardMessageFromGuestParams(int version) {
            super(32, version);
        }

        public PortalClientForwardMessageFromGuestParams() {
            this(0);
        }

        public static PortalClientForwardMessageFromGuestParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PortalClientForwardMessageFromGuestParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PortalClientForwardMessageFromGuestParams decode(Decoder decoder0) {
            PortalClientForwardMessageFromGuestParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PortalClientForwardMessageFromGuestParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.message = TransferableMessage.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.sourceOrigin = Origin.decode(decoder1);
                decoder1 = decoder0.readPointer(24, true);
                result.targetOrigin = Origin.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.message, 8, false);
            encoder0.encode((Struct)this.sourceOrigin, 16, false);
            encoder0.encode((Struct)this.targetOrigin, 24, true);
        }
    }

    static final class PortalClientDispatchLoadEventParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private PortalClientDispatchLoadEventParams(int version) {
            super(8, version);
        }

        public PortalClientDispatchLoadEventParams() {
            this(0);
        }

        public static PortalClientDispatchLoadEventParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PortalClientDispatchLoadEventParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PortalClientDispatchLoadEventParams decode(Decoder decoder0) {
            PortalClientDispatchLoadEventParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PortalClientDispatchLoadEventParams(elementsOrVersion);
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
