package org.chromium.media.mojom;

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

class CdmProxyClient_Internal {
    public static final Interface.Manager<CdmProxyClient, CdmProxyClient.Proxy> MANAGER = new Interface.Manager<CdmProxyClient, CdmProxyClient.Proxy>() {
        public String getName() {
            return "media.mojom.CdmProxyClient";
        }

        public int getVersion() {
            return 0;
        }

        public CdmProxyClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CdmProxyClient_Internal.Proxy(core, messageReceiver);
        }

        public CdmProxyClient_Internal.Stub buildStub(Core core, CdmProxyClient impl) {
            return new CdmProxyClient_Internal.Stub(core, impl);
        }

        public CdmProxyClient[] buildArray(int size) {
            return new CdmProxyClient[size];
        }
    };

    private static final int NOTIFY_HARDWARE_RESET_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements CdmProxyClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void notifyHardwareReset() {
            CdmProxyClient_Internal.CdmProxyClientNotifyHardwareResetParams _message = new CdmProxyClient_Internal.CdmProxyClientNotifyHardwareResetParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<CdmProxyClient> {
        Stub(Core core, CdmProxyClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CdmProxyClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        CdmProxyClient_Internal.CdmProxyClientNotifyHardwareResetParams.deserialize(messageWithHeader.getPayload());
                        ((CdmProxyClient)getImpl()).notifyHardwareReset();
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
                                getCore(), CdmProxyClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CdmProxyClientNotifyHardwareResetParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private CdmProxyClientNotifyHardwareResetParams(int version) {
            super(8, version);
        }

        public CdmProxyClientNotifyHardwareResetParams() {
            this(0);
        }

        public static CdmProxyClientNotifyHardwareResetParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmProxyClientNotifyHardwareResetParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmProxyClientNotifyHardwareResetParams decode(Decoder decoder0) {
            CdmProxyClientNotifyHardwareResetParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmProxyClientNotifyHardwareResetParams(elementsOrVersion);
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
