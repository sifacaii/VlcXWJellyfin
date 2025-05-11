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

class ProgressClient_Internal {
    public static final Interface.Manager<ProgressClient, ProgressClient.Proxy> MANAGER = new Interface.Manager<ProgressClient, ProgressClient.Proxy>() {
        public String getName() {
            return "blink.mojom.ProgressClient";
        }

        public int getVersion() {
            return 0;
        }

        public ProgressClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ProgressClient_Internal.Proxy(core, messageReceiver);
        }

        public ProgressClient_Internal.Stub buildStub(Core core, ProgressClient impl) {
            return new ProgressClient_Internal.Stub(core, impl);
        }

        public ProgressClient[] buildArray(int size) {
            return new ProgressClient[size];
        }
    };

    private static final int ON_PROGRESS_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements ProgressClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onProgress(long delta) {
            ProgressClient_Internal.ProgressClientOnProgressParams _message = new ProgressClient_Internal.ProgressClientOnProgressParams();
            _message.delta = delta;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<ProgressClient> {
        Stub(Core core, ProgressClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ProgressClient_Internal.ProgressClientOnProgressParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ProgressClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ProgressClient_Internal.ProgressClientOnProgressParams.deserialize(messageWithHeader.getPayload());
                        ((ProgressClient)getImpl()).onProgress(data.delta);
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
                                getCore(), ProgressClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ProgressClientOnProgressParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long delta;

        private ProgressClientOnProgressParams(int version) {
            super(16, version);
        }

        public ProgressClientOnProgressParams() {
            this(0);
        }

        public static ProgressClientOnProgressParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ProgressClientOnProgressParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ProgressClientOnProgressParams decode(Decoder decoder0) {
            ProgressClientOnProgressParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ProgressClientOnProgressParams(elementsOrVersion);
                result.delta = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.delta, 8);
        }
    }
}
