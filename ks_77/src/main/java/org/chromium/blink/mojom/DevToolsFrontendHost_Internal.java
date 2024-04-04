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

class DevToolsFrontendHost_Internal {
    public static final Interface.Manager<DevToolsFrontendHost, DevToolsFrontendHost.Proxy> MANAGER = new Interface.Manager<DevToolsFrontendHost, DevToolsFrontendHost.Proxy>() {
        public String getName() {
            return "blink.mojom.DevToolsFrontendHost";
        }

        public int getVersion() {
            return 0;
        }

        public DevToolsFrontendHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new DevToolsFrontendHost_Internal.Proxy(core, messageReceiver);
        }

        public DevToolsFrontendHost_Internal.Stub buildStub(Core core, DevToolsFrontendHost impl) {
            return new DevToolsFrontendHost_Internal.Stub(core, impl);
        }

        public DevToolsFrontendHost[] buildArray(int size) {
            return new DevToolsFrontendHost[size];
        }
    };

    private static final int DISPATCH_EMBEDDER_MESSAGE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements DevToolsFrontendHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void dispatchEmbedderMessage(String message) {
            DevToolsFrontendHost_Internal.DevToolsFrontendHostDispatchEmbedderMessageParams _message = new DevToolsFrontendHost_Internal.DevToolsFrontendHostDispatchEmbedderMessageParams();
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<DevToolsFrontendHost> {
        Stub(Core core, DevToolsFrontendHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                DevToolsFrontendHost_Internal.DevToolsFrontendHostDispatchEmbedderMessageParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DevToolsFrontendHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = DevToolsFrontendHost_Internal.DevToolsFrontendHostDispatchEmbedderMessageParams.deserialize(messageWithHeader.getPayload());
                        ((DevToolsFrontendHost)getImpl()).dispatchEmbedderMessage(data.message);
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
                                getCore(), DevToolsFrontendHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class DevToolsFrontendHostDispatchEmbedderMessageParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String message;

        private DevToolsFrontendHostDispatchEmbedderMessageParams(int version) {
            super(16, version);
        }

        public DevToolsFrontendHostDispatchEmbedderMessageParams() {
            this(0);
        }

        public static DevToolsFrontendHostDispatchEmbedderMessageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DevToolsFrontendHostDispatchEmbedderMessageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DevToolsFrontendHostDispatchEmbedderMessageParams decode(Decoder decoder0) {
            DevToolsFrontendHostDispatchEmbedderMessageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DevToolsFrontendHostDispatchEmbedderMessageParams(elementsOrVersion);
                result.message = decoder0.readString(8, false);
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
}
