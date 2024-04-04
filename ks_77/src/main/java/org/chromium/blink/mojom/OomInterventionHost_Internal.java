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

class OomInterventionHost_Internal {
    public static final Interface.Manager<OomInterventionHost, OomInterventionHost.Proxy> MANAGER = new Interface.Manager<OomInterventionHost, OomInterventionHost.Proxy>() {
        public String getName() {
            return "blink.mojom.OomInterventionHost";
        }

        public int getVersion() {
            return 0;
        }

        public OomInterventionHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new OomInterventionHost_Internal.Proxy(core, messageReceiver);
        }

        public OomInterventionHost_Internal.Stub buildStub(Core core, OomInterventionHost impl) {
            return new OomInterventionHost_Internal.Stub(core, impl);
        }

        public OomInterventionHost[] buildArray(int size) {
            return new OomInterventionHost[size];
        }
    };

    private static final int ON_HIGH_MEMORY_USAGE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements OomInterventionHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onHighMemoryUsage() {
            OomInterventionHost_Internal.OomInterventionHostOnHighMemoryUsageParams _message = new OomInterventionHost_Internal.OomInterventionHostOnHighMemoryUsageParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<OomInterventionHost> {
        Stub(Core core, OomInterventionHost impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(OomInterventionHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        OomInterventionHost_Internal.OomInterventionHostOnHighMemoryUsageParams.deserialize(messageWithHeader.getPayload());
                        ((OomInterventionHost)getImpl()).onHighMemoryUsage();
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
                                getCore(), OomInterventionHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class OomInterventionHostOnHighMemoryUsageParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private OomInterventionHostOnHighMemoryUsageParams(int version) {
            super(8, version);
        }

        public OomInterventionHostOnHighMemoryUsageParams() {
            this(0);
        }

        public static OomInterventionHostOnHighMemoryUsageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static OomInterventionHostOnHighMemoryUsageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static OomInterventionHostOnHighMemoryUsageParams decode(Decoder decoder0) {
            OomInterventionHostOnHighMemoryUsageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new OomInterventionHostOnHighMemoryUsageParams(elementsOrVersion);
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
