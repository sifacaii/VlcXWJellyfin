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

class UkmSourceIdFrameHost_Internal {
    public static final Interface.Manager<UkmSourceIdFrameHost, UkmSourceIdFrameHost.Proxy> MANAGER = new Interface.Manager<UkmSourceIdFrameHost, UkmSourceIdFrameHost.Proxy>() {
        public String getName() {
            return "blink.mojom.UkmSourceIdFrameHost";
        }

        public int getVersion() {
            return 0;
        }

        public UkmSourceIdFrameHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new UkmSourceIdFrameHost_Internal.Proxy(core, messageReceiver);
        }

        public UkmSourceIdFrameHost_Internal.Stub buildStub(Core core, UkmSourceIdFrameHost impl) {
            return new UkmSourceIdFrameHost_Internal.Stub(core, impl);
        }

        public UkmSourceIdFrameHost[] buildArray(int size) {
            return new UkmSourceIdFrameHost[size];
        }
    };

    private static final int SET_DOCUMENT_SOURCE_ID_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements UkmSourceIdFrameHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setDocumentSourceId(long sourceId) {
            UkmSourceIdFrameHost_Internal.UkmSourceIdFrameHostSetDocumentSourceIdParams _message = new UkmSourceIdFrameHost_Internal.UkmSourceIdFrameHostSetDocumentSourceIdParams();
            _message.sourceId = sourceId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<UkmSourceIdFrameHost> {
        Stub(Core core, UkmSourceIdFrameHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                UkmSourceIdFrameHost_Internal.UkmSourceIdFrameHostSetDocumentSourceIdParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(UkmSourceIdFrameHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = UkmSourceIdFrameHost_Internal.UkmSourceIdFrameHostSetDocumentSourceIdParams.deserialize(messageWithHeader.getPayload());
                        ((UkmSourceIdFrameHost)getImpl()).setDocumentSourceId(data.sourceId);
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
                                getCore(), UkmSourceIdFrameHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class UkmSourceIdFrameHostSetDocumentSourceIdParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long sourceId;

        private UkmSourceIdFrameHostSetDocumentSourceIdParams(int version) {
            super(16, version);
        }

        public UkmSourceIdFrameHostSetDocumentSourceIdParams() {
            this(0);
        }

        public static UkmSourceIdFrameHostSetDocumentSourceIdParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static UkmSourceIdFrameHostSetDocumentSourceIdParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static UkmSourceIdFrameHostSetDocumentSourceIdParams decode(Decoder decoder0) {
            UkmSourceIdFrameHostSetDocumentSourceIdParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UkmSourceIdFrameHostSetDocumentSourceIdParams(elementsOrVersion);
                result.sourceId = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.sourceId, 8);
        }
    }
}
