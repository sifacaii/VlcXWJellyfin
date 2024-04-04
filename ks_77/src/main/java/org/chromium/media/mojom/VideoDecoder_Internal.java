package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

class VideoDecoder_Internal {
    public static final Interface.Manager<VideoDecoder, VideoDecoder.Proxy> MANAGER = new Interface.Manager<VideoDecoder, VideoDecoder.Proxy>() {
        public String getName() {
            return "media.mojom.VideoDecoder";
        }

        public int getVersion() {
            return 0;
        }

        public VideoDecoder_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new VideoDecoder_Internal.Proxy(core, messageReceiver);
        }

        public VideoDecoder_Internal.Stub buildStub(Core core, VideoDecoder impl) {
            return new VideoDecoder_Internal.Stub(core, impl);
        }

        public VideoDecoder[] buildArray(int size) {
            return new VideoDecoder[size];
        }
    };

    private static final int GET_SUPPORTED_CONFIGS_ORDINAL = 0;

    private static final int CONSTRUCT_ORDINAL = 1;

    private static final int INITIALIZE_ORDINAL = 2;

    private static final int DECODE_ORDINAL = 3;

    private static final int RESET_ORDINAL = 4;

    private static final int ON_OVERLAY_INFO_CHANGED_ORDINAL = 5;

    static final class Proxy extends Interface.AbstractProxy implements VideoDecoder.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getSupportedConfigs(VideoDecoder.GetSupportedConfigsResponse callback) {
            VideoDecoder_Internal.VideoDecoderGetSupportedConfigsParams _message = new VideoDecoder_Internal.VideoDecoderGetSupportedConfigsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new VideoDecoder_Internal.VideoDecoderGetSupportedConfigsResponseParamsForwardToCallback(callback));
        }

        public void construct(AssociatedInterfaceNotSupported client, AssociatedInterfaceNotSupported mediaLog, InterfaceRequest<VideoFrameHandleReleaser> videoFrameHandleReleaser, DataPipe.ConsumerHandle decoderBufferPipe, CommandBufferId commandBufferId, int implementation, ColorSpace targetColorSpace) {
            VideoDecoder_Internal.VideoDecoderConstructParams _message = new VideoDecoder_Internal.VideoDecoderConstructParams();
            _message.client = client;
            _message.mediaLog = mediaLog;
            _message.videoFrameHandleReleaser = videoFrameHandleReleaser;
            _message.decoderBufferPipe = decoderBufferPipe;
            _message.commandBufferId = commandBufferId;
            _message.implementation = implementation;
            _message.targetColorSpace = targetColorSpace;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void initialize(VideoDecoderConfig config, boolean lowDelay, int cdmId, VideoDecoder.InitializeResponse callback) {
            VideoDecoder_Internal.VideoDecoderInitializeParams _message = new VideoDecoder_Internal.VideoDecoderInitializeParams();
            _message.config = config;
            _message.lowDelay = lowDelay;
            _message.cdmId = cdmId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new VideoDecoder_Internal.VideoDecoderInitializeResponseParamsForwardToCallback(callback));
        }

        public void decode(DecoderBuffer buffer, VideoDecoder.DecodeResponse callback) {
            VideoDecoder_Internal.VideoDecoderDecodeParams _message = new VideoDecoder_Internal.VideoDecoderDecodeParams();
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new VideoDecoder_Internal.VideoDecoderDecodeResponseParamsForwardToCallback(callback));
        }

        public void reset(VideoDecoder.ResetResponse callback) {
            VideoDecoder_Internal.VideoDecoderResetParams _message = new VideoDecoder_Internal.VideoDecoderResetParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new VideoDecoder_Internal.VideoDecoderResetResponseParamsForwardToCallback(callback));
        }

        public void onOverlayInfoChanged(OverlayInfo overlayInfo) {
            VideoDecoder_Internal.VideoDecoderOnOverlayInfoChangedParams _message = new VideoDecoder_Internal.VideoDecoderOnOverlayInfoChangedParams();
            _message.overlayInfo = overlayInfo;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5)));
        }
    }

    static final class Stub extends Interface.Stub<VideoDecoder> {
        Stub(Core core, VideoDecoder impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                VideoDecoder_Internal.VideoDecoderConstructParams videoDecoderConstructParams;
                VideoDecoder_Internal.VideoDecoderOnOverlayInfoChangedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(VideoDecoder_Internal.MANAGER, messageWithHeader);
                    case 1:
                        videoDecoderConstructParams = VideoDecoder_Internal.VideoDecoderConstructParams.deserialize(messageWithHeader.getPayload());
                        ((VideoDecoder)getImpl()).construct(videoDecoderConstructParams.client, videoDecoderConstructParams.mediaLog, videoDecoderConstructParams.videoFrameHandleReleaser, videoDecoderConstructParams.decoderBufferPipe, videoDecoderConstructParams.commandBufferId, videoDecoderConstructParams.implementation, videoDecoderConstructParams.targetColorSpace);
                        return true;
                    case 5:
                        data = VideoDecoder_Internal.VideoDecoderOnOverlayInfoChangedParams.deserialize(messageWithHeader.getPayload());
                        ((VideoDecoder)getImpl()).onOverlayInfoChanged(data.overlayInfo);
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
                VideoDecoder_Internal.VideoDecoderInitializeParams videoDecoderInitializeParams;
                VideoDecoder_Internal.VideoDecoderDecodeParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), VideoDecoder_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        VideoDecoder_Internal.VideoDecoderGetSupportedConfigsParams.deserialize(messageWithHeader.getPayload());
                        ((VideoDecoder)getImpl()).getSupportedConfigs(new VideoDecoder_Internal.VideoDecoderGetSupportedConfigsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        videoDecoderInitializeParams = VideoDecoder_Internal.VideoDecoderInitializeParams.deserialize(messageWithHeader.getPayload());
                        ((VideoDecoder)getImpl()).initialize(videoDecoderInitializeParams.config, videoDecoderInitializeParams.lowDelay, videoDecoderInitializeParams.cdmId, new VideoDecoder_Internal.VideoDecoderInitializeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        data = VideoDecoder_Internal.VideoDecoderDecodeParams.deserialize(messageWithHeader.getPayload());
                        ((VideoDecoder)getImpl()).decode(data.buffer, new VideoDecoder_Internal.VideoDecoderDecodeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        VideoDecoder_Internal.VideoDecoderResetParams.deserialize(messageWithHeader.getPayload());
                        ((VideoDecoder)getImpl()).reset(new VideoDecoder_Internal.VideoDecoderResetResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class VideoDecoderGetSupportedConfigsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VideoDecoderGetSupportedConfigsParams(int version) {
            super(8, version);
        }

        public VideoDecoderGetSupportedConfigsParams() {
            this(0);
        }

        public static VideoDecoderGetSupportedConfigsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderGetSupportedConfigsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderGetSupportedConfigsParams decode(Decoder decoder0) {
            VideoDecoderGetSupportedConfigsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VideoDecoderGetSupportedConfigsParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class VideoDecoderGetSupportedConfigsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Map<Integer, SupportedVideoDecoderConfig[]> supportedConfigs;

        private VideoDecoderGetSupportedConfigsResponseParams(int version) {
            super(16, version);
        }

        public VideoDecoderGetSupportedConfigsResponseParams() {
            this(0);
        }

        public static VideoDecoderGetSupportedConfigsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderGetSupportedConfigsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderGetSupportedConfigsResponseParams decode(Decoder decoder0) {
            VideoDecoderGetSupportedConfigsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VideoDecoderGetSupportedConfigsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                decoder1.readDataHeaderForMap();
                int[] keys0 = decoder1.readInts(8, 0, -1);
                for (int i1 = 0; i1 < keys0.length; i1++)
                    VideoDecoderImplementation.validate(keys0[i1]);
                Decoder decoder2 = decoder1.readPointer(16, false);
                DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
                SupportedVideoDecoderConfig[][] values0 = new SupportedVideoDecoderConfig[si2.elementsOrVersion][];
                for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                    Decoder decoder3 = decoder2.readPointer(8 + 8 * i2, false);
                    DataHeader si3 = decoder3.readDataHeaderForPointerArray(-1);
                    values0[i2] = new SupportedVideoDecoderConfig[si3.elementsOrVersion];
                    for (int i3 = 0; i3 < si3.elementsOrVersion; i3++) {
                        Decoder decoder4 = decoder3.readPointer(8 + 8 * i3, false);
                        values0[i2][i3] = SupportedVideoDecoderConfig.decode(decoder4);
                    }
                }
                result.supportedConfigs = (Map)new HashMap<>();
                for (int index0 = 0; index0 < keys0.length; index0++)
                    result.supportedConfigs.put(Integer.valueOf(keys0[index0]), values0[index0]);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.supportedConfigs == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encoderForMap(8);
                int size0 = this.supportedConfigs.size();
                int[] keys0 = new int[size0];
                SupportedVideoDecoderConfig[][] values0 = new SupportedVideoDecoderConfig[size0][];
                int index0 = 0;
                for (Map.Entry<Integer, SupportedVideoDecoderConfig[]> entry0 : this.supportedConfigs.entrySet()) {
                    keys0[index0] = ((Integer)entry0.getKey()).intValue();
                    values0[index0] = entry0.getValue();
                    index0++;
                }
                encoder1.encode(keys0, 8, 0, -1);
                Encoder encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
                for (int i1 = 0; i1 < values0.length; i1++) {
                    if (values0[i1] == null) {
                        encoder2.encodeNullPointer(8 + 8 * i1, false);
                    } else {
                        Encoder encoder3 = encoder2.encodePointerArray((values0[i1]).length, 8 + 8 * i1, -1);
                        for (int i2 = 0; i2 < (values0[i1]).length; i2++)
                            encoder3.encode(values0[i1][i2], 8 + 8 * i2, false);
                    }
                }
            }
        }
    }

    static class VideoDecoderGetSupportedConfigsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VideoDecoder.GetSupportedConfigsResponse mCallback;

        VideoDecoderGetSupportedConfigsResponseParamsForwardToCallback(VideoDecoder.GetSupportedConfigsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                VideoDecoder_Internal.VideoDecoderGetSupportedConfigsResponseParams response = VideoDecoder_Internal.VideoDecoderGetSupportedConfigsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.supportedConfigs);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VideoDecoderGetSupportedConfigsResponseParamsProxyToResponder implements VideoDecoder.GetSupportedConfigsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VideoDecoderGetSupportedConfigsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Map<Integer, SupportedVideoDecoderConfig[]> supportedConfigs) {
            VideoDecoder_Internal.VideoDecoderGetSupportedConfigsResponseParams _response = new VideoDecoder_Internal.VideoDecoderGetSupportedConfigsResponseParams();
            _response.supportedConfigs = supportedConfigs;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VideoDecoderConstructParams extends Struct {
        private static final int STRUCT_SIZE = 56;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(56, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported client;

        public AssociatedInterfaceNotSupported mediaLog;

        public InterfaceRequest<VideoFrameHandleReleaser> videoFrameHandleReleaser;

        public DataPipe.ConsumerHandle decoderBufferPipe;

        public CommandBufferId commandBufferId;

        public int implementation;

        public ColorSpace targetColorSpace;

        private VideoDecoderConstructParams(int version) {
            super(56, version);
            this.decoderBufferPipe = (DataPipe.ConsumerHandle)InvalidHandle.INSTANCE;
        }

        public VideoDecoderConstructParams() {
            this(0);
        }

        public static VideoDecoderConstructParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderConstructParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderConstructParams decode(Decoder decoder0) {
            VideoDecoderConstructParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VideoDecoderConstructParams(elementsOrVersion);
                result.client = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
                result.mediaLog = decoder0.readAssociatedServiceInterfaceNotSupported(16, false);
                result.videoFrameHandleReleaser = decoder0.readInterfaceRequest(24, false);
                result.decoderBufferPipe = decoder0.readConsumerHandle(28, false);
                Decoder decoder1 = decoder0.readPointer(32, true);
                result.commandBufferId = CommandBufferId.decode(decoder1);
                result.implementation = decoder0.readInt(40);
                VideoDecoderImplementation.validate(result.implementation);
                decoder1 = decoder0.readPointer(48, false);
                result.targetColorSpace = ColorSpace.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.client, 8, false);
            encoder0.encode(this.mediaLog, 16, false);
            encoder0.encode(this.videoFrameHandleReleaser, 24, false);
            encoder0.encode((Handle)this.decoderBufferPipe, 28, false);
            encoder0.encode(this.commandBufferId, 32, true);
            encoder0.encode(this.implementation, 40);
            encoder0.encode((Struct)this.targetColorSpace, 48, false);
        }
    }

    static final class VideoDecoderInitializeParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public VideoDecoderConfig config;

        public boolean lowDelay;

        public int cdmId;

        private VideoDecoderInitializeParams(int version) {
            super(24, version);
        }

        public VideoDecoderInitializeParams() {
            this(0);
        }

        public static VideoDecoderInitializeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderInitializeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderInitializeParams decode(Decoder decoder0) {
            VideoDecoderInitializeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VideoDecoderInitializeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.config = VideoDecoderConfig.decode(decoder1);
                result.lowDelay = decoder0.readBoolean(16, 0);
                result.cdmId = decoder0.readInt(20);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.config, 8, false);
            encoder0.encode(this.lowDelay, 16, 0);
            encoder0.encode(this.cdmId, 20);
        }
    }

    static final class VideoDecoderInitializeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        public boolean needsBitstreamConversion;

        public int maxDecodeRequests;

        private VideoDecoderInitializeResponseParams(int version) {
            super(16, version);
        }

        public VideoDecoderInitializeResponseParams() {
            this(0);
        }

        public static VideoDecoderInitializeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderInitializeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderInitializeResponseParams decode(Decoder decoder0) {
            VideoDecoderInitializeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VideoDecoderInitializeResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                result.needsBitstreamConversion = decoder0.readBoolean(8, 1);
                result.maxDecodeRequests = decoder0.readInt(12);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
            encoder0.encode(this.needsBitstreamConversion, 8, 1);
            encoder0.encode(this.maxDecodeRequests, 12);
        }
    }

    static class VideoDecoderInitializeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VideoDecoder.InitializeResponse mCallback;

        VideoDecoderInitializeResponseParamsForwardToCallback(VideoDecoder.InitializeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                VideoDecoder_Internal.VideoDecoderInitializeResponseParams response = VideoDecoder_Internal.VideoDecoderInitializeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), Boolean.valueOf(response.needsBitstreamConversion), Integer.valueOf(response.maxDecodeRequests));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VideoDecoderInitializeResponseParamsProxyToResponder implements VideoDecoder.InitializeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VideoDecoderInitializeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success, Boolean needsBitstreamConversion, Integer maxDecodeRequests) {
            VideoDecoder_Internal.VideoDecoderInitializeResponseParams _response = new VideoDecoder_Internal.VideoDecoderInitializeResponseParams();
            _response.success = success.booleanValue();
            _response.needsBitstreamConversion = needsBitstreamConversion.booleanValue();
            _response.maxDecodeRequests = maxDecodeRequests.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VideoDecoderDecodeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DecoderBuffer buffer;

        private VideoDecoderDecodeParams(int version) {
            super(16, version);
        }

        public VideoDecoderDecodeParams() {
            this(0);
        }

        public static VideoDecoderDecodeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderDecodeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderDecodeParams decode(Decoder decoder0) {
            VideoDecoderDecodeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VideoDecoderDecodeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.buffer = DecoderBuffer.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.buffer, 8, false);
        }
    }

    static final class VideoDecoderDecodeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private VideoDecoderDecodeResponseParams(int version) {
            super(16, version);
        }

        public VideoDecoderDecodeResponseParams() {
            this(0);
        }

        public static VideoDecoderDecodeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderDecodeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderDecodeResponseParams decode(Decoder decoder0) {
            VideoDecoderDecodeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VideoDecoderDecodeResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                DecodeStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class VideoDecoderDecodeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VideoDecoder.DecodeResponse mCallback;

        VideoDecoderDecodeResponseParamsForwardToCallback(VideoDecoder.DecodeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                VideoDecoder_Internal.VideoDecoderDecodeResponseParams response = VideoDecoder_Internal.VideoDecoderDecodeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VideoDecoderDecodeResponseParamsProxyToResponder implements VideoDecoder.DecodeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VideoDecoderDecodeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            VideoDecoder_Internal.VideoDecoderDecodeResponseParams _response = new VideoDecoder_Internal.VideoDecoderDecodeResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VideoDecoderResetParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VideoDecoderResetParams(int version) {
            super(8, version);
        }

        public VideoDecoderResetParams() {
            this(0);
        }

        public static VideoDecoderResetParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderResetParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderResetParams decode(Decoder decoder0) {
            VideoDecoderResetParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VideoDecoderResetParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class VideoDecoderResetResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private VideoDecoderResetResponseParams(int version) {
            super(8, version);
        }

        public VideoDecoderResetResponseParams() {
            this(0);
        }

        public static VideoDecoderResetResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderResetResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderResetResponseParams decode(Decoder decoder0) {
            VideoDecoderResetResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VideoDecoderResetResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class VideoDecoderResetResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final VideoDecoder.ResetResponse mCallback;

        VideoDecoderResetResponseParamsForwardToCallback(VideoDecoder.ResetResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class VideoDecoderResetResponseParamsProxyToResponder implements VideoDecoder.ResetResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        VideoDecoderResetResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            VideoDecoder_Internal.VideoDecoderResetResponseParams _response = new VideoDecoder_Internal.VideoDecoderResetResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class VideoDecoderOnOverlayInfoChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public OverlayInfo overlayInfo;

        private VideoDecoderOnOverlayInfoChangedParams(int version) {
            super(16, version);
        }

        public VideoDecoderOnOverlayInfoChangedParams() {
            this(0);
        }

        public static VideoDecoderOnOverlayInfoChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderOnOverlayInfoChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderOnOverlayInfoChangedParams decode(Decoder decoder0) {
            VideoDecoderOnOverlayInfoChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new VideoDecoderOnOverlayInfoChangedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.overlayInfo = OverlayInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.overlayInfo, 8, false);
        }
    }
}
