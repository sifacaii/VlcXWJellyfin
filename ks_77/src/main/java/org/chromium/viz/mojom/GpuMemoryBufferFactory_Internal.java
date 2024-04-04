package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.BufferFormat;
import org.chromium.gfx.mojom.BufferUsage;
import org.chromium.gfx.mojom.GpuMemoryBufferHandle;
import org.chromium.gfx.mojom.GpuMemoryBufferId;
import org.chromium.gfx.mojom.Size;
import org.chromium.gpu.mojom.SyncToken;
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
import org.chromium.viz.mojom.GpuMemoryBufferFactory;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/GpuMemoryBufferFactory_Internal.class */
class GpuMemoryBufferFactory_Internal {
    public static final Interface.Manager<GpuMemoryBufferFactory, GpuMemoryBufferFactory.Proxy> MANAGER = new Interface.Manager<GpuMemoryBufferFactory, GpuMemoryBufferFactory.Proxy>() { // from class: org.chromium.viz.mojom.GpuMemoryBufferFactory_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "viz.mojom.GpuMemoryBufferFactory";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public GpuMemoryBufferFactory.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, GpuMemoryBufferFactory impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public GpuMemoryBufferFactory[] buildArray(int size) {
            return new GpuMemoryBufferFactory[size];
        }
    };
    private static final int CREATE_GPU_MEMORY_BUFFER_ORDINAL = 0;
    private static final int DESTROY_GPU_MEMORY_BUFFER_ORDINAL = 1;

    GpuMemoryBufferFactory_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/GpuMemoryBufferFactory_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements GpuMemoryBufferFactory.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.viz.mojom.GpuMemoryBufferFactory
        public void createGpuMemoryBuffer(GpuMemoryBufferId id, Size size, int format, int usage, GpuMemoryBufferFactory.CreateGpuMemoryBufferResponse callback) {
            GpuMemoryBufferFactoryCreateGpuMemoryBufferParams _message = new GpuMemoryBufferFactoryCreateGpuMemoryBufferParams();
            _message.id = id;
            _message.size = size;
            _message.format = format;
            _message.usage = usage;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.viz.mojom.GpuMemoryBufferFactory
        public void destroyGpuMemoryBuffer(GpuMemoryBufferId id, SyncToken syncToken) {
            GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams _message = new GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams();
            _message.id = id;
            _message.syncToken = syncToken;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/GpuMemoryBufferFactory_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<GpuMemoryBufferFactory> {
        Stub(Core core, GpuMemoryBufferFactory impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(GpuMemoryBufferFactory_Internal.MANAGER, messageWithHeader);
                    case 1:
                        GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams data = GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams.deserialize(messageWithHeader.getPayload());
                        getImpl().destroyGpuMemoryBuffer(data.id, data.syncToken);
                        return true;
                    default:
                        return false;
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), GpuMemoryBufferFactory_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        GpuMemoryBufferFactoryCreateGpuMemoryBufferParams data = GpuMemoryBufferFactoryCreateGpuMemoryBufferParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createGpuMemoryBuffer(data.id, data.size, data.format, data.usage, new GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/GpuMemoryBufferFactory_Internal$GpuMemoryBufferFactoryCreateGpuMemoryBufferParams.class */
    static final class GpuMemoryBufferFactoryCreateGpuMemoryBufferParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public GpuMemoryBufferId id;
        public Size size;
        public int format;
        public int usage;

        private GpuMemoryBufferFactoryCreateGpuMemoryBufferParams(int version) {
            super(32, version);
        }

        public GpuMemoryBufferFactoryCreateGpuMemoryBufferParams() {
            this(0);
        }

        public static GpuMemoryBufferFactoryCreateGpuMemoryBufferParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GpuMemoryBufferFactoryCreateGpuMemoryBufferParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GpuMemoryBufferFactoryCreateGpuMemoryBufferParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                GpuMemoryBufferFactoryCreateGpuMemoryBufferParams result = new GpuMemoryBufferFactoryCreateGpuMemoryBufferParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.id = GpuMemoryBufferId.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.size = Size.decode(decoder12);
                result.format = decoder0.readInt(24);
                BufferFormat.validate(result.format);
                result.usage = decoder0.readInt(28);
                BufferUsage.validate(result.usage);
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
            encoder0.encode((Struct) this.size, 16, false);
            encoder0.encode(this.format, 24);
            encoder0.encode(this.usage, 28);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/GpuMemoryBufferFactory_Internal$GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams.class */
    public static final class GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public GpuMemoryBufferHandle bufferHandle;

        private GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams(int version) {
            super(16, version);
        }

        public GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams() {
            this(0);
        }

        public static GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams result = new GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.bufferHandle = GpuMemoryBufferHandle.decode(decoder1);
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
            encoder0.encode((Struct) this.bufferHandle, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/GpuMemoryBufferFactory_Internal$GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsForwardToCallback.class */
    static class GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final GpuMemoryBufferFactory.CreateGpuMemoryBufferResponse mCallback;

        GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsForwardToCallback(GpuMemoryBufferFactory.CreateGpuMemoryBufferResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2)) {
                    return false;
                }
                GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams response = GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.bufferHandle);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/GpuMemoryBufferFactory_Internal$GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsProxyToResponder.class */
    static class GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsProxyToResponder implements GpuMemoryBufferFactory.CreateGpuMemoryBufferResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(GpuMemoryBufferHandle bufferHandle) {
            GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams _response = new GpuMemoryBufferFactoryCreateGpuMemoryBufferResponseParams();
            _response.bufferHandle = bufferHandle;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/GpuMemoryBufferFactory_Internal$GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams.class */
    static final class GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public GpuMemoryBufferId id;
        public SyncToken syncToken;

        private GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams(int version) {
            super(24, version);
        }

        public GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams() {
            this(0);
        }

        public static GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams result = new GpuMemoryBufferFactoryDestroyGpuMemoryBufferParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.id = GpuMemoryBufferId.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.syncToken = SyncToken.decode(decoder12);
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
            encoder0.encode((Struct) this.syncToken, 16, false);
        }
    }
}
