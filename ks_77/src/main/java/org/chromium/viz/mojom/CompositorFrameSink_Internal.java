package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gpu.mojom.Mailbox;
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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;
import org.chromium.viz.mojom.CompositorFrameSink;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal.class */
class CompositorFrameSink_Internal {
    public static final Interface.Manager<CompositorFrameSink, CompositorFrameSink.Proxy> MANAGER = new Interface.Manager<CompositorFrameSink, CompositorFrameSink.Proxy>() { // from class: org.chromium.viz.mojom.CompositorFrameSink_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "viz.mojom.CompositorFrameSink";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public CompositorFrameSink.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, CompositorFrameSink impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public CompositorFrameSink[] buildArray(int size) {
            return new CompositorFrameSink[size];
        }
    };
    private static final int SET_NEEDS_BEGIN_FRAME_ORDINAL = 0;
    private static final int SET_WANTS_ANIMATE_ONLY_BEGIN_FRAMES_ORDINAL = 1;
    private static final int SUBMIT_COMPOSITOR_FRAME_ORDINAL = 2;
    private static final int SUBMIT_COMPOSITOR_FRAME_SYNC_ORDINAL = 3;
    private static final int DID_NOT_PRODUCE_FRAME_ORDINAL = 4;
    private static final int DID_ALLOCATE_SHARED_BITMAP_ORDINAL = 5;
    private static final int DID_DELETE_SHARED_BITMAP_ORDINAL = 6;

    CompositorFrameSink_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements CompositorFrameSink.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.viz.mojom.CompositorFrameSink
        public void setNeedsBeginFrame(boolean needsBeginFrame) {
            CompositorFrameSinkSetNeedsBeginFrameParams _message = new CompositorFrameSinkSetNeedsBeginFrameParams();
            _message.needsBeginFrame = needsBeginFrame;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.viz.mojom.CompositorFrameSink
        public void setWantsAnimateOnlyBeginFrames() {
            CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams _message = new CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.viz.mojom.CompositorFrameSink
        public void submitCompositorFrame(LocalSurfaceId localSurfaceId, CompositorFrame frame, HitTestRegionList hitTestRegionList, long submitTime) {
            CompositorFrameSinkSubmitCompositorFrameParams _message = new CompositorFrameSinkSubmitCompositorFrameParams();
            _message.localSurfaceId = localSurfaceId;
            _message.frame = frame;
            _message.hitTestRegionList = hitTestRegionList;
            _message.submitTime = submitTime;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.viz.mojom.CompositorFrameSink
        public void submitCompositorFrameSync(LocalSurfaceId localSurfaceId, CompositorFrame frame, HitTestRegionList hitTestRegionList, long submitTime, CompositorFrameSink.SubmitCompositorFrameSyncResponse callback) {
            CompositorFrameSinkSubmitCompositorFrameSyncParams _message = new CompositorFrameSinkSubmitCompositorFrameSyncParams();
            _message.localSurfaceId = localSurfaceId;
            _message.frame = frame;
            _message.hitTestRegionList = hitTestRegionList;
            _message.submitTime = submitTime;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.viz.mojom.CompositorFrameSink
        public void didNotProduceFrame(BeginFrameAck ack) {
            CompositorFrameSinkDidNotProduceFrameParams _message = new CompositorFrameSinkDidNotProduceFrameParams();
            _message.ack = ack;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.viz.mojom.CompositorFrameSink
        public void didAllocateSharedBitmap(ReadOnlySharedMemoryRegion region, Mailbox id) {
            CompositorFrameSinkDidAllocateSharedBitmapParams _message = new CompositorFrameSinkDidAllocateSharedBitmapParams();
            _message.region = region;
            _message.id = id;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.viz.mojom.CompositorFrameSink
        public void didDeleteSharedBitmap(Mailbox id) {
            CompositorFrameSinkDidDeleteSharedBitmapParams _message = new CompositorFrameSinkDidDeleteSharedBitmapParams();
            _message.id = id;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<CompositorFrameSink> {
        Stub(Core core, CompositorFrameSink impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CompositorFrameSink_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 3:
                    default:
                        return false;
                    case 0:
                        CompositorFrameSinkSetNeedsBeginFrameParams data = CompositorFrameSinkSetNeedsBeginFrameParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setNeedsBeginFrame(data.needsBeginFrame);
                        return true;
                    case 1:
                        CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setWantsAnimateOnlyBeginFrames();
                        return true;
                    case 2:
                        CompositorFrameSinkSubmitCompositorFrameParams data2 = CompositorFrameSinkSubmitCompositorFrameParams.deserialize(messageWithHeader.getPayload());
                        getImpl().submitCompositorFrame(data2.localSurfaceId, data2.frame, data2.hitTestRegionList, data2.submitTime);
                        return true;
                    case 4:
                        CompositorFrameSinkDidNotProduceFrameParams data3 = CompositorFrameSinkDidNotProduceFrameParams.deserialize(messageWithHeader.getPayload());
                        getImpl().didNotProduceFrame(data3.ack);
                        return true;
                    case 5:
                        CompositorFrameSinkDidAllocateSharedBitmapParams data4 = CompositorFrameSinkDidAllocateSharedBitmapParams.deserialize(messageWithHeader.getPayload());
                        getImpl().didAllocateSharedBitmap(data4.region, data4.id);
                        return true;
                    case 6:
                        getImpl().didDeleteSharedBitmap(CompositorFrameSinkDidDeleteSharedBitmapParams.deserialize(messageWithHeader.getPayload()).id);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), CompositorFrameSink_Internal.MANAGER, messageWithHeader, receiver);
                    case 3:
                        CompositorFrameSinkSubmitCompositorFrameSyncParams data = CompositorFrameSinkSubmitCompositorFrameSyncParams.deserialize(messageWithHeader.getPayload());
                        getImpl().submitCompositorFrameSync(data.localSurfaceId, data.frame, data.hitTestRegionList, data.submitTime, new CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal$CompositorFrameSinkSetNeedsBeginFrameParams.class */
    static final class CompositorFrameSinkSetNeedsBeginFrameParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean needsBeginFrame;

        private CompositorFrameSinkSetNeedsBeginFrameParams(int version) {
            super(16, version);
        }

        public CompositorFrameSinkSetNeedsBeginFrameParams() {
            this(0);
        }

        public static CompositorFrameSinkSetNeedsBeginFrameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositorFrameSinkSetNeedsBeginFrameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositorFrameSinkSetNeedsBeginFrameParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositorFrameSinkSetNeedsBeginFrameParams result = new CompositorFrameSinkSetNeedsBeginFrameParams(elementsOrVersion);
                result.needsBeginFrame = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.needsBeginFrame, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal$CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams.class */
    static final class CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams(int version) {
            super(8, version);
        }

        public CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams() {
            this(0);
        }

        public static CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams result = new CompositorFrameSinkSetWantsAnimateOnlyBeginFramesParams(elementsOrVersion);
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
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal$CompositorFrameSinkSubmitCompositorFrameParams.class */
    static final class CompositorFrameSinkSubmitCompositorFrameParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public LocalSurfaceId localSurfaceId;
        public CompositorFrame frame;
        public HitTestRegionList hitTestRegionList;
        public long submitTime;

        private CompositorFrameSinkSubmitCompositorFrameParams(int version) {
            super(40, version);
        }

        public CompositorFrameSinkSubmitCompositorFrameParams() {
            this(0);
        }

        public static CompositorFrameSinkSubmitCompositorFrameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositorFrameSinkSubmitCompositorFrameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositorFrameSinkSubmitCompositorFrameParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositorFrameSinkSubmitCompositorFrameParams result = new CompositorFrameSinkSubmitCompositorFrameParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.localSurfaceId = LocalSurfaceId.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.frame = CompositorFrame.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(24, true);
                result.hitTestRegionList = HitTestRegionList.decode(decoder13);
                result.submitTime = decoder0.readLong(32);
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
            encoder0.encode((Struct) this.localSurfaceId, 8, false);
            encoder0.encode((Struct) this.frame, 16, false);
            encoder0.encode((Struct) this.hitTestRegionList, 24, true);
            encoder0.encode(this.submitTime, 32);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal$CompositorFrameSinkSubmitCompositorFrameSyncParams.class */
    static final class CompositorFrameSinkSubmitCompositorFrameSyncParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public LocalSurfaceId localSurfaceId;
        public CompositorFrame frame;
        public HitTestRegionList hitTestRegionList;
        public long submitTime;

        private CompositorFrameSinkSubmitCompositorFrameSyncParams(int version) {
            super(40, version);
        }

        public CompositorFrameSinkSubmitCompositorFrameSyncParams() {
            this(0);
        }

        public static CompositorFrameSinkSubmitCompositorFrameSyncParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositorFrameSinkSubmitCompositorFrameSyncParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositorFrameSinkSubmitCompositorFrameSyncParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositorFrameSinkSubmitCompositorFrameSyncParams result = new CompositorFrameSinkSubmitCompositorFrameSyncParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.localSurfaceId = LocalSurfaceId.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.frame = CompositorFrame.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(24, true);
                result.hitTestRegionList = HitTestRegionList.decode(decoder13);
                result.submitTime = decoder0.readLong(32);
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
            encoder0.encode((Struct) this.localSurfaceId, 8, false);
            encoder0.encode((Struct) this.frame, 16, false);
            encoder0.encode((Struct) this.hitTestRegionList, 24, true);
            encoder0.encode(this.submitTime, 32);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal$CompositorFrameSinkSubmitCompositorFrameSyncResponseParams.class */
    public static final class CompositorFrameSinkSubmitCompositorFrameSyncResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ReturnedResource[] resources;

        private CompositorFrameSinkSubmitCompositorFrameSyncResponseParams(int version) {
            super(16, version);
        }

        public CompositorFrameSinkSubmitCompositorFrameSyncResponseParams() {
            this(0);
        }

        public static CompositorFrameSinkSubmitCompositorFrameSyncResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositorFrameSinkSubmitCompositorFrameSyncResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositorFrameSinkSubmitCompositorFrameSyncResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositorFrameSinkSubmitCompositorFrameSyncResponseParams result = new CompositorFrameSinkSubmitCompositorFrameSyncResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal$CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsForwardToCallback.class */
    static class CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CompositorFrameSink.SubmitCompositorFrameSyncResponse mCallback;

        CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsForwardToCallback(CompositorFrameSink.SubmitCompositorFrameSyncResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2)) {
                    return false;
                }
                CompositorFrameSinkSubmitCompositorFrameSyncResponseParams response = CompositorFrameSinkSubmitCompositorFrameSyncResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.resources);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal$CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsProxyToResponder.class */
    static class CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsProxyToResponder implements CompositorFrameSink.SubmitCompositorFrameSyncResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        CompositorFrameSinkSubmitCompositorFrameSyncResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(ReturnedResource[] resources) {
            CompositorFrameSinkSubmitCompositorFrameSyncResponseParams _response = new CompositorFrameSinkSubmitCompositorFrameSyncResponseParams();
            _response.resources = resources;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal$CompositorFrameSinkDidNotProduceFrameParams.class */
    static final class CompositorFrameSinkDidNotProduceFrameParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public BeginFrameAck ack;

        private CompositorFrameSinkDidNotProduceFrameParams(int version) {
            super(16, version);
        }

        public CompositorFrameSinkDidNotProduceFrameParams() {
            this(0);
        }

        public static CompositorFrameSinkDidNotProduceFrameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositorFrameSinkDidNotProduceFrameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositorFrameSinkDidNotProduceFrameParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositorFrameSinkDidNotProduceFrameParams result = new CompositorFrameSinkDidNotProduceFrameParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.ack = BeginFrameAck.decode(decoder1);
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
            encoder0.encode((Struct) this.ack, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal$CompositorFrameSinkDidAllocateSharedBitmapParams.class */
    static final class CompositorFrameSinkDidAllocateSharedBitmapParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ReadOnlySharedMemoryRegion region;
        public Mailbox id;

        private CompositorFrameSinkDidAllocateSharedBitmapParams(int version) {
            super(24, version);
        }

        public CompositorFrameSinkDidAllocateSharedBitmapParams() {
            this(0);
        }

        public static CompositorFrameSinkDidAllocateSharedBitmapParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositorFrameSinkDidAllocateSharedBitmapParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositorFrameSinkDidAllocateSharedBitmapParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositorFrameSinkDidAllocateSharedBitmapParams result = new CompositorFrameSinkDidAllocateSharedBitmapParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.region = ReadOnlySharedMemoryRegion.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.id = Mailbox.decode(decoder12);
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
            encoder0.encode((Struct) this.region, 8, false);
            encoder0.encode((Struct) this.id, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink_Internal$CompositorFrameSinkDidDeleteSharedBitmapParams.class */
    static final class CompositorFrameSinkDidDeleteSharedBitmapParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Mailbox id;

        private CompositorFrameSinkDidDeleteSharedBitmapParams(int version) {
            super(16, version);
        }

        public CompositorFrameSinkDidDeleteSharedBitmapParams() {
            this(0);
        }

        public static CompositorFrameSinkDidDeleteSharedBitmapParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CompositorFrameSinkDidDeleteSharedBitmapParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CompositorFrameSinkDidDeleteSharedBitmapParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                CompositorFrameSinkDidDeleteSharedBitmapParams result = new CompositorFrameSinkDidDeleteSharedBitmapParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.id = Mailbox.decode(decoder1);
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
            encoder0.encode((Struct) this.id, 8, false);
        }
    }
}
