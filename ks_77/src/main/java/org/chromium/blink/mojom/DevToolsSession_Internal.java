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

class DevToolsSession_Internal {
    public static final Interface.Manager<DevToolsSession, DevToolsSession.Proxy> MANAGER = new Interface.Manager<DevToolsSession, DevToolsSession.Proxy>() {
        public String getName() {
            return "blink.mojom.DevToolsSession";
        }

        public int getVersion() {
            return 0;
        }

        public DevToolsSession_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new DevToolsSession_Internal.Proxy(core, messageReceiver);
        }

        public DevToolsSession_Internal.Stub buildStub(Core core, DevToolsSession impl) {
            return new DevToolsSession_Internal.Stub(core, impl);
        }

        public DevToolsSession[] buildArray(int size) {
            return new DevToolsSession[size];
        }
    };

    private static final int DISPATCH_PROTOCOL_COMMAND_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements DevToolsSession.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void dispatchProtocolCommand(int callId, String method, DevToolsMessage message) {
            DevToolsSession_Internal.DevToolsSessionDispatchProtocolCommandParams _message = new DevToolsSession_Internal.DevToolsSessionDispatchProtocolCommandParams();
            _message.callId = callId;
            _message.method = method;
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<DevToolsSession> {
        Stub(Core core, DevToolsSession impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                DevToolsSession_Internal.DevToolsSessionDispatchProtocolCommandParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DevToolsSession_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = DevToolsSession_Internal.DevToolsSessionDispatchProtocolCommandParams.deserialize(messageWithHeader.getPayload());
                        ((DevToolsSession)getImpl()).dispatchProtocolCommand(data.callId, data.method, data.message);
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
                                getCore(), DevToolsSession_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class DevToolsSessionDispatchProtocolCommandParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int callId;

        public String method;

        public DevToolsMessage message;

        private DevToolsSessionDispatchProtocolCommandParams(int version) {
            super(32, version);
        }

        public DevToolsSessionDispatchProtocolCommandParams() {
            this(0);
        }

        public static DevToolsSessionDispatchProtocolCommandParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DevToolsSessionDispatchProtocolCommandParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DevToolsSessionDispatchProtocolCommandParams decode(Decoder decoder0) {
            DevToolsSessionDispatchProtocolCommandParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DevToolsSessionDispatchProtocolCommandParams(elementsOrVersion);
                result.callId = decoder0.readInt(8);
                result.method = decoder0.readString(16, false);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.message = DevToolsMessage.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.callId, 8);
            encoder0.encode(this.method, 16, false);
            encoder0.encode(this.message, 24, false);
        }
    }
}
