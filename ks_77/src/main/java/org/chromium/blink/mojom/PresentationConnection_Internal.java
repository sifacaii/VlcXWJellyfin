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

class PresentationConnection_Internal {
    public static final Interface.Manager<PresentationConnection, PresentationConnection.Proxy> MANAGER = new Interface.Manager<PresentationConnection, PresentationConnection.Proxy>() {
        public String getName() {
            return "blink.mojom.PresentationConnection";
        }

        public int getVersion() {
            return 0;
        }

        public PresentationConnection_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new PresentationConnection_Internal.Proxy(core, messageReceiver);
        }

        public PresentationConnection_Internal.Stub buildStub(Core core, PresentationConnection impl) {
            return new PresentationConnection_Internal.Stub(core, impl);
        }

        public PresentationConnection[] buildArray(int size) {
            return new PresentationConnection[size];
        }
    };

    private static final int ON_MESSAGE_ORDINAL = 0;

    private static final int DID_CHANGE_STATE_ORDINAL = 1;

    private static final int DID_CLOSE_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements PresentationConnection.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onMessage(PresentationConnectionMessage message) {
            PresentationConnection_Internal.PresentationConnectionOnMessageParams _message = new PresentationConnection_Internal.PresentationConnectionOnMessageParams();
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void didChangeState(int state) {
            PresentationConnection_Internal.PresentationConnectionDidChangeStateParams _message = new PresentationConnection_Internal.PresentationConnectionDidChangeStateParams();
            _message.state = state;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void didClose(int reason) {
            PresentationConnection_Internal.PresentationConnectionDidCloseParams _message = new PresentationConnection_Internal.PresentationConnectionDidCloseParams();
            _message.reason = reason;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<PresentationConnection> {
        Stub(Core core, PresentationConnection impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                PresentationConnection_Internal.PresentationConnectionOnMessageParams presentationConnectionOnMessageParams;
                PresentationConnection_Internal.PresentationConnectionDidChangeStateParams presentationConnectionDidChangeStateParams;
                PresentationConnection_Internal.PresentationConnectionDidCloseParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(PresentationConnection_Internal.MANAGER, messageWithHeader);
                    case 0:
                        presentationConnectionOnMessageParams = PresentationConnection_Internal.PresentationConnectionOnMessageParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationConnection)getImpl()).onMessage(presentationConnectionOnMessageParams.message);
                        return true;
                    case 1:
                        presentationConnectionDidChangeStateParams = PresentationConnection_Internal.PresentationConnectionDidChangeStateParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationConnection)getImpl()).didChangeState(presentationConnectionDidChangeStateParams.state);
                        return true;
                    case 2:
                        data = PresentationConnection_Internal.PresentationConnectionDidCloseParams.deserialize(messageWithHeader.getPayload());
                        ((PresentationConnection)getImpl()).didClose(data.reason);
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
                                getCore(), PresentationConnection_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PresentationConnectionOnMessageParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public PresentationConnectionMessage message;

        private PresentationConnectionOnMessageParams(int version) {
            super(24, version);
        }

        public PresentationConnectionOnMessageParams() {
            this(0);
        }

        public static PresentationConnectionOnMessageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationConnectionOnMessageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationConnectionOnMessageParams decode(Decoder decoder0) {
            PresentationConnectionOnMessageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationConnectionOnMessageParams(elementsOrVersion);
                result.message = PresentationConnectionMessage.decode(decoder0, 8);
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

    static final class PresentationConnectionDidChangeStateParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int state;

        private PresentationConnectionDidChangeStateParams(int version) {
            super(16, version);
        }

        public PresentationConnectionDidChangeStateParams() {
            this(0);
        }

        public static PresentationConnectionDidChangeStateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationConnectionDidChangeStateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationConnectionDidChangeStateParams decode(Decoder decoder0) {
            PresentationConnectionDidChangeStateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationConnectionDidChangeStateParams(elementsOrVersion);
                result.state = decoder0.readInt(8);
                PresentationConnectionState.validate(result.state);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.state, 8);
        }
    }

    static final class PresentationConnectionDidCloseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int reason;

        private PresentationConnectionDidCloseParams(int version) {
            super(16, version);
        }

        public PresentationConnectionDidCloseParams() {
            this(0);
        }

        public static PresentationConnectionDidCloseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PresentationConnectionDidCloseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PresentationConnectionDidCloseParams decode(Decoder decoder0) {
            PresentationConnectionDidCloseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PresentationConnectionDidCloseParams(elementsOrVersion);
                result.reason = decoder0.readInt(8);
                PresentationConnectionCloseReason.validate(result.reason);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.reason, 8);
        }
    }
}
