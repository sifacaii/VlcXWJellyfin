package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import org.chromium.viz.mojom.CompositorFrameSinkClient;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSinkClient_Internal.class */
class CompositorFrameSinkClient_Internal {
    public static final Interface.Manager<CompositorFrameSinkClient, CompositorFrameSinkClient.Proxy> MANAGER = new Interface.Manager<CompositorFrameSinkClient, CompositorFrameSinkClient.Proxy>() { // from class: org.chromium.viz.mojom.CompositorFrameSinkClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "viz.mojom.CompositorFrameSinkClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public CompositorFrameSinkClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, CompositorFrameSinkClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public CompositorFrameSinkClient[] buildArray(int size) {
            return new CompositorFrameSinkClient[size];
        }
    };
    private static final int DID_RECEIVE_COMPOSITOR_FRAME_ACK_ORDINAL = 0;
    private static final int ON_BEGIN_FRAME_ORDINAL = 1;
    private static final int ON_BEGIN_FRAME_PAUSED_CHANGED_ORDINAL = 2;
    private static final int RECLAIM_RESOURCES_ORDINAL = 3;

    CompositorFrameSinkClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSinkClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements CompositorFrameSinkClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.viz.mojom.CompositorFrameSinkClient
        public void didReceiveCompositorFrameAck(ReturnedResource[] resources) {
            CompositorFrameSinkClientDidReceiveCompositorFrameAckParams _message = new CompositorFrameSinkClientDidReceiveCompositorFrameAckParams();
            _message.resources = resources;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.viz.mojom.CompositorFrameSinkClient
        public void onBeginFrame(BeginFrameArgs args, Map<Integer, FrameTimingDetails> details) {
            CompositorFrameSinkClientOnBeginFrameParams _message = new CompositorFrameSinkClientOnBeginFrameParams();
            _message.args = args;
            _message.details = details;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.viz.mojom.CompositorFrameSinkClient
        public void onBeginFramePausedChanged(boolean paused) {
            CompositorFrameSinkClientOnBeginFramePausedChangedParams _message = new CompositorFrameSinkClientOnBeginFramePausedChangedParams();
            _message.paused = paused;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.viz.mojom.CompositorFrameSinkClient
        public void reclaimResources(ReturnedResource[] resources) {
            CompositorFrameSinkClientReclaimResourcesParams _message = new CompositorFrameSinkClientReclaimResourcesParams();
            _message.resources = resources;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSinkClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<CompositorFrameSinkClient> {
        Stub(Core core, CompositorFrameSinkClient impl) {
            super(core, impl);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                }
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CompositorFrameSinkClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        CompositorFrameSinkClientDidReceiveCompositorFrameAckParams data = CompositorFrameSinkClientDidReceiveCompositorFrameAckParams.deserialize(messageWithHeader.getPayload());
                        getImpl().didReceiveCompositorFrameAck(data.resources);
                        return true;
                    case 1:
                        CompositorFrameSinkClientOnBeginFrameParams data2 = CompositorFrameSinkClientOnBeginFrameParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onBeginFrame(data2.args, data2.details);
                        return true;
                    case 2:
                        CompositorFrameSinkClientOnBeginFramePausedChangedParams data3 = CompositorFrameSinkClientOnBeginFramePausedChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onBeginFramePausedChanged(data3.paused);
                        return true;
                    case 3:
                        CompositorFrameSinkClientReclaimResourcesParams data4 = CompositorFrameSinkClientReclaimResourcesParams.deserialize(messageWithHeader.getPayload());
                        getImpl().reclaimResources(data4.resources);
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                }
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(getCore(), CompositorFrameSinkClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSinkClient_Internal$CompositorFrameSinkClientDidReceiveCompositorFrameAckParams.class */
    static final class CompositorFrameSinkClientDidReceiveCompositorFrameAckParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ReturnedResource[] resources;

        private CompositorFrameSinkClientDidReceiveCompositorFrameAckParams(int version) {
            super(16, version);
        }

        public CompositorFrameSinkClientDidReceiveCompositorFrameAckParams() {
            this(0);
        }

        public static CompositorFrameSinkClientDidReceiveCompositorFrameAckParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositorFrameSinkClientDidReceiveCompositorFrameAckParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositorFrameSinkClientDidReceiveCompositorFrameAckParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositorFrameSinkClientDidReceiveCompositorFrameAckParams result = new CompositorFrameSinkClientDidReceiveCompositorFrameAckParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.resources = new ReturnedResource[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.resources[i1] = ReturnedResource.decode(decoder2);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.resources == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.resources.length, 8, -1);
            for (int i0 = 0; i0 < this.resources.length; i0++) {
                encoder1.encode((Struct) this.resources[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSinkClient_Internal$CompositorFrameSinkClientOnBeginFrameParams.class */
    static final class CompositorFrameSinkClientOnBeginFrameParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public BeginFrameArgs args;
        public Map<Integer, FrameTimingDetails> details;

        private CompositorFrameSinkClientOnBeginFrameParams(int version) {
            super(24, version);
        }

        public CompositorFrameSinkClientOnBeginFrameParams() {
            this(0);
        }

        public static CompositorFrameSinkClientOnBeginFrameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositorFrameSinkClientOnBeginFrameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositorFrameSinkClientOnBeginFrameParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositorFrameSinkClientOnBeginFrameParams result = new CompositorFrameSinkClientOnBeginFrameParams(elementsOrVersion);
                result.args = BeginFrameArgs.decode(decoder0.readPointer(8, false));
                Decoder decoder1 = decoder0.readPointer(16, false);
                decoder1.readDataHeaderForMap();
                int[] keys0 = decoder1.readInts(8, 0, -1);
                Decoder decoder2 = decoder1.readPointer(16, false);
                DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
                FrameTimingDetails[] values0 = new FrameTimingDetails[si2.elementsOrVersion];
                for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                    Decoder decoder3 = decoder2.readPointer(8 + (8 * i2), false);
                    values0[i2] = FrameTimingDetails.decode(decoder3);
                }
                result.details = new HashMap();
                for (int index0 = 0; index0 < keys0.length; index0++) {
                    result.details.put(Integer.valueOf(keys0[index0]), values0[index0]);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct) this.args, 8, false);
            if (this.details == null) {
                encoder0.encodeNullPointer(16, false);
                return;
            }
            Encoder encoder1 = encoder0.encoderForMap(16);
            int size0 = this.details.size();
            int[] keys0 = new int[size0];
            FrameTimingDetails[] values0 = new FrameTimingDetails[size0];
            int index0 = 0;
            for (Map.Entry<Integer, FrameTimingDetails> entry0 : this.details.entrySet()) {
                keys0[index0] = entry0.getKey().intValue();
                values0[index0] = entry0.getValue();
                index0++;
            }
            encoder1.encode(keys0, 8, 0, -1);
            Encoder encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
            for (int i1 = 0; i1 < values0.length; i1++) {
                encoder2.encode((Struct) values0[i1], 8 + (8 * i1), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSinkClient_Internal$CompositorFrameSinkClientOnBeginFramePausedChangedParams.class */
    static final class CompositorFrameSinkClientOnBeginFramePausedChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean paused;

        private CompositorFrameSinkClientOnBeginFramePausedChangedParams(int version) {
            super(16, version);
        }

        public CompositorFrameSinkClientOnBeginFramePausedChangedParams() {
            this(0);
        }

        public static CompositorFrameSinkClientOnBeginFramePausedChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositorFrameSinkClientOnBeginFramePausedChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositorFrameSinkClientOnBeginFramePausedChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositorFrameSinkClientOnBeginFramePausedChangedParams result = new CompositorFrameSinkClientOnBeginFramePausedChangedParams(elementsOrVersion);
                result.paused = decoder0.readBoolean(8, 0);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.paused, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSinkClient_Internal$CompositorFrameSinkClientReclaimResourcesParams.class */
    static final class CompositorFrameSinkClientReclaimResourcesParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ReturnedResource[] resources;

        private CompositorFrameSinkClientReclaimResourcesParams(int version) {
            super(16, version);
        }

        public CompositorFrameSinkClientReclaimResourcesParams() {
            this(0);
        }

        public static CompositorFrameSinkClientReclaimResourcesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositorFrameSinkClientReclaimResourcesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositorFrameSinkClientReclaimResourcesParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositorFrameSinkClientReclaimResourcesParams result = new CompositorFrameSinkClientReclaimResourcesParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.resources = new ReturnedResource[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.resources[i1] = ReturnedResource.decode(decoder2);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.resources == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.resources.length, 8, -1);
            for (int i0 = 0; i0 < this.resources.length; i0++) {
                encoder1.encode((Struct) this.resources[i0], 8 + (8 * i0), false);
            }
        }
    }
}
