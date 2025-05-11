package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
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

class AnchorElementMetricsHost_Internal {
    public static final Interface.Manager<AnchorElementMetricsHost, AnchorElementMetricsHost.Proxy> MANAGER = new Interface.Manager<AnchorElementMetricsHost, AnchorElementMetricsHost.Proxy>() {
        public String getName() {
            return "blink.mojom.AnchorElementMetricsHost";
        }

        public int getVersion() {
            return 0;
        }

        public AnchorElementMetricsHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AnchorElementMetricsHost_Internal.Proxy(core, messageReceiver);
        }

        public AnchorElementMetricsHost_Internal.Stub buildStub(Core core, AnchorElementMetricsHost impl) {
            return new AnchorElementMetricsHost_Internal.Stub(core, impl);
        }

        public AnchorElementMetricsHost[] buildArray(int size) {
            return new AnchorElementMetricsHost[size];
        }
    };

    private static final int REPORT_ANCHOR_ELEMENT_METRICS_ON_CLICK_ORDINAL = 0;

    private static final int REPORT_ANCHOR_ELEMENT_METRICS_ON_LOAD_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements AnchorElementMetricsHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void reportAnchorElementMetricsOnClick(AnchorElementMetrics metrics) {
            AnchorElementMetricsHost_Internal.AnchorElementMetricsHostReportAnchorElementMetricsOnClickParams _message = new AnchorElementMetricsHost_Internal.AnchorElementMetricsHostReportAnchorElementMetricsOnClickParams();
            _message.metrics = metrics;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void reportAnchorElementMetricsOnLoad(AnchorElementMetrics[] metrics, Size viewportSize) {
            AnchorElementMetricsHost_Internal.AnchorElementMetricsHostReportAnchorElementMetricsOnLoadParams _message = new AnchorElementMetricsHost_Internal.AnchorElementMetricsHostReportAnchorElementMetricsOnLoadParams();
            _message.metrics = metrics;
            _message.viewportSize = viewportSize;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<AnchorElementMetricsHost> {
        Stub(Core core, AnchorElementMetricsHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AnchorElementMetricsHost_Internal.AnchorElementMetricsHostReportAnchorElementMetricsOnClickParams anchorElementMetricsHostReportAnchorElementMetricsOnClickParams;
                AnchorElementMetricsHost_Internal.AnchorElementMetricsHostReportAnchorElementMetricsOnLoadParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AnchorElementMetricsHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        anchorElementMetricsHostReportAnchorElementMetricsOnClickParams = AnchorElementMetricsHost_Internal.AnchorElementMetricsHostReportAnchorElementMetricsOnClickParams.deserialize(messageWithHeader.getPayload());
                        ((AnchorElementMetricsHost)getImpl()).reportAnchorElementMetricsOnClick(anchorElementMetricsHostReportAnchorElementMetricsOnClickParams.metrics);
                        return true;
                    case 1:
                        data = AnchorElementMetricsHost_Internal.AnchorElementMetricsHostReportAnchorElementMetricsOnLoadParams.deserialize(messageWithHeader.getPayload());
                        ((AnchorElementMetricsHost)getImpl()).reportAnchorElementMetricsOnLoad(data.metrics, data.viewportSize);
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
                                getCore(), AnchorElementMetricsHost_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AnchorElementMetricsHostReportAnchorElementMetricsOnClickParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AnchorElementMetrics metrics;

        private AnchorElementMetricsHostReportAnchorElementMetricsOnClickParams(int version) {
            super(16, version);
        }

        public AnchorElementMetricsHostReportAnchorElementMetricsOnClickParams() {
            this(0);
        }

        public static AnchorElementMetricsHostReportAnchorElementMetricsOnClickParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AnchorElementMetricsHostReportAnchorElementMetricsOnClickParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AnchorElementMetricsHostReportAnchorElementMetricsOnClickParams decode(Decoder decoder0) {
            AnchorElementMetricsHostReportAnchorElementMetricsOnClickParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AnchorElementMetricsHostReportAnchorElementMetricsOnClickParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.metrics = AnchorElementMetrics.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.metrics, 8, false);
        }
    }

    static final class AnchorElementMetricsHostReportAnchorElementMetricsOnLoadParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AnchorElementMetrics[] metrics;

        public Size viewportSize;

        private AnchorElementMetricsHostReportAnchorElementMetricsOnLoadParams(int version) {
            super(24, version);
        }

        public AnchorElementMetricsHostReportAnchorElementMetricsOnLoadParams() {
            this(0);
        }

        public static AnchorElementMetricsHostReportAnchorElementMetricsOnLoadParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AnchorElementMetricsHostReportAnchorElementMetricsOnLoadParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AnchorElementMetricsHostReportAnchorElementMetricsOnLoadParams decode(Decoder decoder0) {
            AnchorElementMetricsHostReportAnchorElementMetricsOnLoadParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AnchorElementMetricsHostReportAnchorElementMetricsOnLoadParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.metrics = new AnchorElementMetrics[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.metrics[i1] = AnchorElementMetrics.decode(decoder2);
                }
                decoder1 = decoder0.readPointer(16, false);
                result.viewportSize = Size.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.metrics == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.metrics.length, 8, -1);
                for (int i0 = 0; i0 < this.metrics.length; i0++)
                    encoder1.encode(this.metrics[i0], 8 + 8 * i0, false);
            }
            encoder0.encode((Struct)this.viewportSize, 16, false);
        }
    }
}
