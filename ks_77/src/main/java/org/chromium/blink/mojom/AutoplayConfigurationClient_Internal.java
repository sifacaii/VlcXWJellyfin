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

class AutoplayConfigurationClient_Internal {
    public static final Interface.Manager<AutoplayConfigurationClient, AutoplayConfigurationClient.Proxy> MANAGER = new Interface.Manager<AutoplayConfigurationClient, AutoplayConfigurationClient.Proxy>() {
        public String getName() {
            return "blink.mojom.AutoplayConfigurationClient";
        }

        public int getVersion() {
            return 0;
        }

        public AutoplayConfigurationClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AutoplayConfigurationClient_Internal.Proxy(core, messageReceiver);
        }

        public AutoplayConfigurationClient_Internal.Stub buildStub(Core core, AutoplayConfigurationClient impl) {
            return new AutoplayConfigurationClient_Internal.Stub(core, impl);
        }

        public AutoplayConfigurationClient[] buildArray(int size) {
            return new AutoplayConfigurationClient[size];
        }
    };

    private static final int ADD_AUTOPLAY_FLAGS_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements AutoplayConfigurationClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void addAutoplayFlags(Origin origin, int flags) {
            AutoplayConfigurationClient_Internal.AutoplayConfigurationClientAddAutoplayFlagsParams _message = new AutoplayConfigurationClient_Internal.AutoplayConfigurationClientAddAutoplayFlagsParams();
            _message.origin = origin;
            _message.flags = flags;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<AutoplayConfigurationClient> {
        Stub(Core core, AutoplayConfigurationClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AutoplayConfigurationClient_Internal.AutoplayConfigurationClientAddAutoplayFlagsParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AutoplayConfigurationClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = AutoplayConfigurationClient_Internal.AutoplayConfigurationClientAddAutoplayFlagsParams.deserialize(messageWithHeader.getPayload());
                        ((AutoplayConfigurationClient)getImpl()).addAutoplayFlags(data.origin, data.flags);
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
                                getCore(), AutoplayConfigurationClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AutoplayConfigurationClientAddAutoplayFlagsParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public int flags;

        private AutoplayConfigurationClientAddAutoplayFlagsParams(int version) {
            super(24, version);
        }

        public AutoplayConfigurationClientAddAutoplayFlagsParams() {
            this(0);
        }

        public static AutoplayConfigurationClientAddAutoplayFlagsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AutoplayConfigurationClientAddAutoplayFlagsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AutoplayConfigurationClientAddAutoplayFlagsParams decode(Decoder decoder0) {
            AutoplayConfigurationClientAddAutoplayFlagsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AutoplayConfigurationClientAddAutoplayFlagsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                result.flags = decoder0.readInt(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode(this.flags, 16);
        }
    }
}
