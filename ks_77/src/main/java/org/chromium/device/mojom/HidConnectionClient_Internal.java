package org.chromium.device.mojom;

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

class HidConnectionClient_Internal {
    public static final Interface.Manager<HidConnectionClient, HidConnectionClient.Proxy> MANAGER = new Interface.Manager<HidConnectionClient, HidConnectionClient.Proxy>() {
        public String getName() {
            return "device.mojom.HidConnectionClient";
        }

        public int getVersion() {
            return 0;
        }

        public HidConnectionClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new HidConnectionClient_Internal.Proxy(core, messageReceiver);
        }

        public HidConnectionClient_Internal.Stub buildStub(Core core, HidConnectionClient impl) {
            return new HidConnectionClient_Internal.Stub(core, impl);
        }

        public HidConnectionClient[] buildArray(int size) {
            return new HidConnectionClient[size];
        }
    };

    private static final int ON_INPUT_REPORT_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements HidConnectionClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onInputReport(byte reportId, byte[] buffer) {
            HidConnectionClient_Internal.HidConnectionClientOnInputReportParams _message = new HidConnectionClient_Internal.HidConnectionClientOnInputReportParams();
            _message.reportId = reportId;
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<HidConnectionClient> {
        Stub(Core core, HidConnectionClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                HidConnectionClient_Internal.HidConnectionClientOnInputReportParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(HidConnectionClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = HidConnectionClient_Internal.HidConnectionClientOnInputReportParams.deserialize(messageWithHeader.getPayload());
                        ((HidConnectionClient)getImpl()).onInputReport(data.reportId, data.buffer);
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
                                getCore(), HidConnectionClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class HidConnectionClientOnInputReportParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte reportId;

        public byte[] buffer;

        private HidConnectionClientOnInputReportParams(int version) {
            super(24, version);
        }

        public HidConnectionClientOnInputReportParams() {
            this(0);
        }

        public static HidConnectionClientOnInputReportParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static HidConnectionClientOnInputReportParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static HidConnectionClientOnInputReportParams decode(Decoder decoder0) {
            HidConnectionClientOnInputReportParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new HidConnectionClientOnInputReportParams(elementsOrVersion);
                result.reportId = decoder0.readByte(8);
                result.buffer = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.reportId, 8);
            encoder0.encode(this.buffer, 16, 0, -1);
        }
    }
}
