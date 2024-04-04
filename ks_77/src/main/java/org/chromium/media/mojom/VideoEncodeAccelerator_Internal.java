package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.VideoEncodeAccelerator;
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
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.SharedBufferHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal.class */
class VideoEncodeAccelerator_Internal {
    public static final Interface.Manager<VideoEncodeAccelerator, VideoEncodeAccelerator.Proxy> MANAGER = new Interface.Manager<VideoEncodeAccelerator, VideoEncodeAccelerator.Proxy>() { // from class: org.chromium.media.mojom.VideoEncodeAccelerator_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.VideoEncodeAccelerator";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public VideoEncodeAccelerator.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, VideoEncodeAccelerator impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public VideoEncodeAccelerator[] buildArray(int size) {
            return new VideoEncodeAccelerator[size];
        }
    };
    private static final int INITIALIZE_ORDINAL = 0;
    private static final int ENCODE_ORDINAL = 1;
    private static final int USE_OUTPUT_BITSTREAM_BUFFER_ORDINAL = 2;
    private static final int REQUEST_ENCODING_PARAMETERS_CHANGE_ORDINAL = 3;

    VideoEncodeAccelerator_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements VideoEncodeAccelerator.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.VideoEncodeAccelerator
        public void initialize(VideoEncodeAcceleratorConfig config, VideoEncodeAcceleratorClient client, VideoEncodeAccelerator.InitializeResponse callback) {
            VideoEncodeAcceleratorInitializeParams _message = new VideoEncodeAcceleratorInitializeParams();
            _message.config = config;
            _message.client = client;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new VideoEncodeAcceleratorInitializeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.VideoEncodeAccelerator
        public void encode(VideoFrame frame, boolean forceKeyframe, VideoEncodeAccelerator.EncodeResponse callback) {
            VideoEncodeAcceleratorEncodeParams _message = new VideoEncodeAcceleratorEncodeParams();
            _message.frame = frame;
            _message.forceKeyframe = forceKeyframe;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new VideoEncodeAcceleratorEncodeResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media.mojom.VideoEncodeAccelerator
        public void useOutputBitstreamBuffer(int bitstreamBufferId, SharedBufferHandle buffer) {
            VideoEncodeAcceleratorUseOutputBitstreamBufferParams _message = new VideoEncodeAcceleratorUseOutputBitstreamBufferParams();
            _message.bitstreamBufferId = bitstreamBufferId;
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.media.mojom.VideoEncodeAccelerator
        public void requestEncodingParametersChange(VideoBitrateAllocation bitrateAllocation, int framerate) {
            VideoEncodeAcceleratorRequestEncodingParametersChangeParams _message = new VideoEncodeAcceleratorRequestEncodingParametersChangeParams();
            _message.bitrateAllocation = bitrateAllocation;
            _message.framerate = framerate;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<VideoEncodeAccelerator> {
        Stub(Core core, VideoEncodeAccelerator impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(VideoEncodeAccelerator_Internal.MANAGER, messageWithHeader);
                    case 2:
                        VideoEncodeAcceleratorUseOutputBitstreamBufferParams data = VideoEncodeAcceleratorUseOutputBitstreamBufferParams.deserialize(messageWithHeader.getPayload());
                        getImpl().useOutputBitstreamBuffer(data.bitstreamBufferId, data.buffer);
                        return true;
                    case 3:
                        VideoEncodeAcceleratorRequestEncodingParametersChangeParams data2 = VideoEncodeAcceleratorRequestEncodingParametersChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().requestEncodingParametersChange(data2.bitrateAllocation, data2.framerate);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), VideoEncodeAccelerator_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        VideoEncodeAcceleratorInitializeParams data = VideoEncodeAcceleratorInitializeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().initialize(data.config, data.client, new VideoEncodeAcceleratorInitializeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        VideoEncodeAcceleratorEncodeParams data2 = VideoEncodeAcceleratorEncodeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().encode(data2.frame, data2.forceKeyframe, new VideoEncodeAcceleratorEncodeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal$VideoEncodeAcceleratorInitializeParams.class */
    static final class VideoEncodeAcceleratorInitializeParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public VideoEncodeAcceleratorConfig config;
        public VideoEncodeAcceleratorClient client;

        private VideoEncodeAcceleratorInitializeParams(int version) {
            super(24, version);
        }

        public VideoEncodeAcceleratorInitializeParams() {
            this(0);
        }

        public static VideoEncodeAcceleratorInitializeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoEncodeAcceleratorInitializeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoEncodeAcceleratorInitializeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoEncodeAcceleratorInitializeParams result = new VideoEncodeAcceleratorInitializeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.config = VideoEncodeAcceleratorConfig.decode(decoder1);
                result.client = (VideoEncodeAcceleratorClient) decoder0.readServiceInterface(16, false, VideoEncodeAcceleratorClient.MANAGER);
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
            encoder0.encode((Struct) this.config, 8, false);
            encoder0.encode( this.client, 16, false,VideoEncodeAcceleratorClient.MANAGER);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal$VideoEncodeAcceleratorInitializeResponseParams.class */
    public static final class VideoEncodeAcceleratorInitializeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean result;

        private VideoEncodeAcceleratorInitializeResponseParams(int version) {
            super(16, version);
        }

        public VideoEncodeAcceleratorInitializeResponseParams() {
            this(0);
        }

        public static VideoEncodeAcceleratorInitializeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoEncodeAcceleratorInitializeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoEncodeAcceleratorInitializeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoEncodeAcceleratorInitializeResponseParams result = new VideoEncodeAcceleratorInitializeResponseParams(elementsOrVersion);
                result.result = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.result, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal$VideoEncodeAcceleratorInitializeResponseParamsForwardToCallback.class */
    static class VideoEncodeAcceleratorInitializeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VideoEncodeAccelerator.InitializeResponse mCallback;

        VideoEncodeAcceleratorInitializeResponseParamsForwardToCallback(VideoEncodeAccelerator.InitializeResponse callback) {
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
                VideoEncodeAcceleratorInitializeResponseParams response = VideoEncodeAcceleratorInitializeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal$VideoEncodeAcceleratorInitializeResponseParamsProxyToResponder.class */
    static class VideoEncodeAcceleratorInitializeResponseParamsProxyToResponder implements VideoEncodeAccelerator.InitializeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        VideoEncodeAcceleratorInitializeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Boolean result) {
            VideoEncodeAcceleratorInitializeResponseParams _response = new VideoEncodeAcceleratorInitializeResponseParams();
            _response.result = result.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal$VideoEncodeAcceleratorEncodeParams.class */
    static final class VideoEncodeAcceleratorEncodeParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public VideoFrame frame;
        public boolean forceKeyframe;

        private VideoEncodeAcceleratorEncodeParams(int version) {
            super(24, version);
        }

        public VideoEncodeAcceleratorEncodeParams() {
            this(0);
        }

        public static VideoEncodeAcceleratorEncodeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoEncodeAcceleratorEncodeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoEncodeAcceleratorEncodeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoEncodeAcceleratorEncodeParams result = new VideoEncodeAcceleratorEncodeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.frame = VideoFrame.decode(decoder1);
                result.forceKeyframe = decoder0.readBoolean(16, 0);
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
            encoder0.encode((Struct) this.frame, 8, false);
            encoder0.encode(this.forceKeyframe, 16, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal$VideoEncodeAcceleratorEncodeResponseParams.class */
    static final class VideoEncodeAcceleratorEncodeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VideoEncodeAcceleratorEncodeResponseParams(int version) {
            super(8, version);
        }

        public VideoEncodeAcceleratorEncodeResponseParams() {
            this(0);
        }

        public static VideoEncodeAcceleratorEncodeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoEncodeAcceleratorEncodeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoEncodeAcceleratorEncodeResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoEncodeAcceleratorEncodeResponseParams result = new VideoEncodeAcceleratorEncodeResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal$VideoEncodeAcceleratorEncodeResponseParamsForwardToCallback.class */
    static class VideoEncodeAcceleratorEncodeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VideoEncodeAccelerator.EncodeResponse mCallback;

        VideoEncodeAcceleratorEncodeResponseParamsForwardToCallback(VideoEncodeAccelerator.EncodeResponse callback) {
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
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal$VideoEncodeAcceleratorEncodeResponseParamsProxyToResponder.class */
    static class VideoEncodeAcceleratorEncodeResponseParamsProxyToResponder implements VideoEncodeAccelerator.EncodeResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        VideoEncodeAcceleratorEncodeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            VideoEncodeAcceleratorEncodeResponseParams _response = new VideoEncodeAcceleratorEncodeResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal$VideoEncodeAcceleratorUseOutputBitstreamBufferParams.class */
    static final class VideoEncodeAcceleratorUseOutputBitstreamBufferParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int bitstreamBufferId;
        public SharedBufferHandle buffer;

        private VideoEncodeAcceleratorUseOutputBitstreamBufferParams(int version) {
            super(16, version);
            this.buffer = InvalidHandle.INSTANCE;
        }

        public VideoEncodeAcceleratorUseOutputBitstreamBufferParams() {
            this(0);
        }

        public static VideoEncodeAcceleratorUseOutputBitstreamBufferParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoEncodeAcceleratorUseOutputBitstreamBufferParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoEncodeAcceleratorUseOutputBitstreamBufferParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoEncodeAcceleratorUseOutputBitstreamBufferParams result = new VideoEncodeAcceleratorUseOutputBitstreamBufferParams(elementsOrVersion);
                result.bitstreamBufferId = decoder0.readInt(8);
                result.buffer = decoder0.readSharedBufferHandle(12, false);
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
            encoder0.encode(this.bitstreamBufferId, 8);
            encoder0.encode((Handle) this.buffer, 12, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAccelerator_Internal$VideoEncodeAcceleratorRequestEncodingParametersChangeParams.class */
    static final class VideoEncodeAcceleratorRequestEncodingParametersChangeParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public VideoBitrateAllocation bitrateAllocation;
        public int framerate;

        private VideoEncodeAcceleratorRequestEncodingParametersChangeParams(int version) {
            super(24, version);
        }

        public VideoEncodeAcceleratorRequestEncodingParametersChangeParams() {
            this(0);
        }

        public static VideoEncodeAcceleratorRequestEncodingParametersChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoEncodeAcceleratorRequestEncodingParametersChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoEncodeAcceleratorRequestEncodingParametersChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoEncodeAcceleratorRequestEncodingParametersChangeParams result = new VideoEncodeAcceleratorRequestEncodingParametersChangeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.bitrateAllocation = VideoBitrateAllocation.decode(decoder1);
                result.framerate = decoder0.readInt(16);
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
            encoder0.encode((Struct) this.bitrateAllocation, 8, false);
            encoder0.encode(this.framerate, 16);
        }
    }
}
