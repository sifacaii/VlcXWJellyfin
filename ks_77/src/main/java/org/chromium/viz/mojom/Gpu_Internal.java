package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gpu.mojom.GpuFeatureInfo;
import org.chromium.gpu.mojom.GpuInfo;
import org.chromium.media.mojom.VideoEncodeAcceleratorProvider;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.viz.mojom.Gpu;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/Gpu_Internal.class */
class Gpu_Internal {
    public static final Interface.Manager<Gpu, Gpu.Proxy> MANAGER = new Interface.Manager<Gpu, Gpu.Proxy>() { // from class: org.chromium.viz.mojom.Gpu_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "viz.mojom.Gpu";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public Gpu.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, Gpu impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Gpu[] buildArray(int size) {
            return new Gpu[size];
        }
    };
    private static final int CREATE_GPU_MEMORY_BUFFER_FACTORY_ORDINAL = 0;
    private static final int ESTABLISH_GPU_CHANNEL_ORDINAL = 1;
    private static final int CREATE_VIDEO_ENCODE_ACCELERATOR_PROVIDER_ORDINAL = 2;

    Gpu_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/Gpu_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements Gpu.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.viz.mojom.Gpu
        public void createGpuMemoryBufferFactory(InterfaceRequest<GpuMemoryBufferFactory> request) {
            GpuCreateGpuMemoryBufferFactoryParams _message = new GpuCreateGpuMemoryBufferFactoryParams();
            _message.request = request;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.viz.mojom.Gpu
        public void establishGpuChannel(Gpu.EstablishGpuChannelResponse callback) {
            GpuEstablishGpuChannelParams _message = new GpuEstablishGpuChannelParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new GpuEstablishGpuChannelResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.viz.mojom.Gpu
        public void createVideoEncodeAcceleratorProvider(InterfaceRequest<VideoEncodeAcceleratorProvider> veaProvider) {
            GpuCreateVideoEncodeAcceleratorProviderParams _message = new GpuCreateVideoEncodeAcceleratorProviderParams();
            _message.veaProvider = veaProvider;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/Gpu_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<Gpu> {
        Stub(Core core, Gpu impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Gpu_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 1:
                    default:
                        return false;
                    case 0:
                        GpuCreateGpuMemoryBufferFactoryParams data = GpuCreateGpuMemoryBufferFactoryParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createGpuMemoryBufferFactory(data.request);
                        return true;
                    case 2:
                        GpuCreateVideoEncodeAcceleratorProviderParams data2 = GpuCreateVideoEncodeAcceleratorProviderParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createVideoEncodeAcceleratorProvider(data2.veaProvider);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), Gpu_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        GpuEstablishGpuChannelParams.deserialize(messageWithHeader.getPayload());
                        getImpl().establishGpuChannel(new GpuEstablishGpuChannelResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/Gpu_Internal$GpuCreateGpuMemoryBufferFactoryParams.class */
    static final class GpuCreateGpuMemoryBufferFactoryParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<GpuMemoryBufferFactory> request;

        private GpuCreateGpuMemoryBufferFactoryParams(int version) {
            super(16, version);
        }

        public GpuCreateGpuMemoryBufferFactoryParams() {
            this(0);
        }

        public static GpuCreateGpuMemoryBufferFactoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GpuCreateGpuMemoryBufferFactoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GpuCreateGpuMemoryBufferFactoryParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                GpuCreateGpuMemoryBufferFactoryParams result = new GpuCreateGpuMemoryBufferFactoryParams(elementsOrVersion);
                result.request = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.request, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/Gpu_Internal$GpuEstablishGpuChannelParams.class */
    static final class GpuEstablishGpuChannelParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private GpuEstablishGpuChannelParams(int version) {
            super(8, version);
        }

        public GpuEstablishGpuChannelParams() {
            this(0);
        }

        public static GpuEstablishGpuChannelParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GpuEstablishGpuChannelParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GpuEstablishGpuChannelParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                GpuEstablishGpuChannelParams result = new GpuEstablishGpuChannelParams(elementsOrVersion);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/Gpu_Internal$GpuEstablishGpuChannelResponseParams.class */
    public static final class GpuEstablishGpuChannelResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int clientId;
        public MessagePipeHandle channelHandle;
        public GpuInfo gpuInfo;
        public GpuFeatureInfo gpuFeatureInfo;

        private GpuEstablishGpuChannelResponseParams(int version) {
            super(32, version);
            this.channelHandle = InvalidHandle.INSTANCE;
        }

        public GpuEstablishGpuChannelResponseParams() {
            this(0);
        }

        public static GpuEstablishGpuChannelResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GpuEstablishGpuChannelResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GpuEstablishGpuChannelResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                GpuEstablishGpuChannelResponseParams result = new GpuEstablishGpuChannelResponseParams(elementsOrVersion);
                result.clientId = decoder0.readInt(8);
                result.channelHandle = decoder0.readMessagePipeHandle(12, true);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.gpuInfo = GpuInfo.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(24, false);
                result.gpuFeatureInfo = GpuFeatureInfo.decode(decoder12);
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
            encoder0.encode(this.clientId, 8);
            encoder0.encode((Handle) this.channelHandle, 12, true);
            encoder0.encode((Struct) this.gpuInfo, 16, false);
            encoder0.encode((Struct) this.gpuFeatureInfo, 24, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/Gpu_Internal$GpuEstablishGpuChannelResponseParamsForwardToCallback.class */
    static class GpuEstablishGpuChannelResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Gpu.EstablishGpuChannelResponse mCallback;

        GpuEstablishGpuChannelResponseParamsForwardToCallback(Gpu.EstablishGpuChannelResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2)) {
                    return false;
                }
                GpuEstablishGpuChannelResponseParams response = GpuEstablishGpuChannelResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.clientId), response.channelHandle, response.gpuInfo, response.gpuFeatureInfo);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/Gpu_Internal$GpuEstablishGpuChannelResponseParamsProxyToResponder.class */
    static class GpuEstablishGpuChannelResponseParamsProxyToResponder implements Gpu.EstablishGpuChannelResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        GpuEstablishGpuChannelResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback4
        public void call(Integer clientId, MessagePipeHandle channelHandle, GpuInfo gpuInfo, GpuFeatureInfo gpuFeatureInfo) {
            GpuEstablishGpuChannelResponseParams _response = new GpuEstablishGpuChannelResponseParams();
            _response.clientId = clientId.intValue();
            _response.channelHandle = channelHandle;
            _response.gpuInfo = gpuInfo;
            _response.gpuFeatureInfo = gpuFeatureInfo;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/Gpu_Internal$GpuCreateVideoEncodeAcceleratorProviderParams.class */
    static final class GpuCreateVideoEncodeAcceleratorProviderParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<VideoEncodeAcceleratorProvider> veaProvider;

        private GpuCreateVideoEncodeAcceleratorProviderParams(int version) {
            super(16, version);
        }

        public GpuCreateVideoEncodeAcceleratorProviderParams() {
            this(0);
        }

        public static GpuCreateVideoEncodeAcceleratorProviderParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static GpuCreateVideoEncodeAcceleratorProviderParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static GpuCreateVideoEncodeAcceleratorProviderParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                GpuCreateVideoEncodeAcceleratorProviderParams result = new GpuCreateVideoEncodeAcceleratorProviderParams(elementsOrVersion);
                result.veaProvider = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.veaProvider, 8, false);
        }
    }
}
