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

class DevToolsSessionHost_Internal {
    public static final Interface.Manager<DevToolsSessionHost, DevToolsSessionHost.Proxy> MANAGER = new Interface.Manager<DevToolsSessionHost, DevToolsSessionHost.Proxy>() {
        public String getName() {
            return "blink.mojom.DevToolsSessionHost";
        }

        public int getVersion() {
            return 0;
        }

        public DevToolsSessionHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new DevToolsSessionHost_Internal.Proxy(core, messageReceiver);
        }

        public DevToolsSessionHost_Internal.Stub buildStub(Core core, DevToolsSessionHost impl) {
            return new DevToolsSessionHost_Internal.Stub(core, impl);
        }

        public DevToolsSessionHost[] buildArray(int size) {
            return new DevToolsSessionHost[size];
        }
    };

    private static final int DISPATCH_PROTOCOL_RESPONSE_ORDINAL = 0;

    private static final int DISPATCH_PROTOCOL_NOTIFICATION_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements DevToolsSessionHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void dispatchProtocolResponse(DevToolsMessage message, int callId, DevToolsSessionState updates) {
            DevToolsSessionHost_Internal.DevToolsSessionHostDispatchProtocolResponseParams _message = new DevToolsSessionHost_Internal.DevToolsSessionHostDispatchProtocolResponseParams();
            _message.message = message;
            _message.callId = callId;
            _message.updates = updates;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void dispatchProtocolNotification(DevToolsMessage message, DevToolsSessionState updates) {
            DevToolsSessionHost_Internal.DevToolsSessionHostDispatchProtocolNotificationParams _message = new DevToolsSessionHost_Internal.DevToolsSessionHostDispatchProtocolNotificationParams();
            _message.message = message;
            _message.updates = updates;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<DevToolsSessionHost> {
        Stub(Core core, DevToolsSessionHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                DevToolsSessionHost_Internal.DevToolsSessionHostDispatchProtocolResponseParams devToolsSessionHostDispatchProtocolResponseParams;
                DevToolsSessionHost_Internal.DevToolsSessionHostDispatchProtocolNotificationParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DevToolsSessionHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        devToolsSessionHostDispatchProtocolResponseParams = DevToolsSessionHost_Internal.DevToolsSessionHostDispatchProtocolResponseParams.deserialize(messageWithHeader.getPayload());
                        ((DevToolsSessionHost)getImpl()).dispatchProtocolResponse(devToolsSessionHostDispatchProtocolResponseParams.message, devToolsSessionHostDispatchProtocolResponseParams.callId, devToolsSessionHostDispatchProtocolResponseParams.updates);
                        return true;
                    case 1:
                        data = DevToolsSessionHost_Internal.DevToolsSessionHostDispatchProtocolNotificationParams.deserialize(messageWithHeader.getPayload());
                        ((DevToolsSessionHost)getImpl()).dispatchProtocolNotification(data.message, data.updates);
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
                                getCore(), DevToolsSessionHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class DevToolsSessionHostDispatchProtocolResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DevToolsMessage message;

        public int callId;

        public DevToolsSessionState updates;

        private DevToolsSessionHostDispatchProtocolResponseParams(int version) {
            super(32, version);
        }

        public DevToolsSessionHostDispatchProtocolResponseParams() {
            this(0);
        }

        public static DevToolsSessionHostDispatchProtocolResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DevToolsSessionHostDispatchProtocolResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DevToolsSessionHostDispatchProtocolResponseParams decode(Decoder decoder0) {
            DevToolsSessionHostDispatchProtocolResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DevToolsSessionHostDispatchProtocolResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.message = DevToolsMessage.decode(decoder1);
                result.callId = decoder0.readInt(16);
                decoder1 = decoder0.readPointer(24, true);
                result.updates = DevToolsSessionState.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.message, 8, false);
            encoder0.encode(this.callId, 16);
            encoder0.encode(this.updates, 24, true);
        }
    }

    static final class DevToolsSessionHostDispatchProtocolNotificationParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DevToolsMessage message;

        public DevToolsSessionState updates;

        private DevToolsSessionHostDispatchProtocolNotificationParams(int version) {
            super(24, version);
        }

        public DevToolsSessionHostDispatchProtocolNotificationParams() {
            this(0);
        }

        public static DevToolsSessionHostDispatchProtocolNotificationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DevToolsSessionHostDispatchProtocolNotificationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DevToolsSessionHostDispatchProtocolNotificationParams decode(Decoder decoder0) {
            DevToolsSessionHostDispatchProtocolNotificationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DevToolsSessionHostDispatchProtocolNotificationParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.message = DevToolsMessage.decode(decoder1);
                decoder1 = decoder0.readPointer(16, true);
                result.updates = DevToolsSessionState.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.message, 8, false);
            encoder0.encode(this.updates, 16, true);
        }
    }
}
