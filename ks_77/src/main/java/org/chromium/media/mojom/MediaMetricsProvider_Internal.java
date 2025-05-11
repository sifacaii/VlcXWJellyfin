package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.MediaMetricsProvider;
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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal.class */
class MediaMetricsProvider_Internal {
    public static final Interface.Manager<MediaMetricsProvider, MediaMetricsProvider.Proxy> MANAGER = new Interface.Manager<MediaMetricsProvider, MediaMetricsProvider.Proxy>() { // from class: org.chromium.media.mojom.MediaMetricsProvider_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.MediaMetricsProvider";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public MediaMetricsProvider.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, MediaMetricsProvider impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public MediaMetricsProvider[] buildArray(int size) {
            return new MediaMetricsProvider[size];
        }
    };
    private static final int INITIALIZE_ORDINAL = 0;
    private static final int ON_ERROR_ORDINAL = 1;
    private static final int SET_HAS_PLAYED_ORDINAL = 2;
    private static final int SET_HAVE_ENOUGH_ORDINAL = 3;
    private static final int SET_IS_AD_MEDIA_ORDINAL = 4;
    private static final int SET_IS_EME_ORDINAL = 5;
    private static final int SET_TIME_TO_METADATA_ORDINAL = 6;
    private static final int SET_TIME_TO_FIRST_FRAME_ORDINAL = 7;
    private static final int SET_TIME_TO_PLAY_READY_ORDINAL = 8;
    private static final int SET_CONTAINER_NAME_ORDINAL = 9;
    private static final int ACQUIRE_WATCH_TIME_RECORDER_ORDINAL = 10;
    private static final int ACQUIRE_VIDEO_DECODE_STATS_RECORDER_ORDINAL = 11;
    private static final int ADD_BYTES_RECEIVED_ORDINAL = 12;
    private static final int SET_HAS_AUDIO_ORDINAL = 13;
    private static final int SET_HAS_VIDEO_ORDINAL = 14;
    private static final int SET_VIDEO_PIPELINE_INFO_ORDINAL = 15;
    private static final int SET_AUDIO_PIPELINE_INFO_ORDINAL = 16;

    MediaMetricsProvider_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements MediaMetricsProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void initialize(boolean isMse, int urlScheme) {
            MediaMetricsProviderInitializeParams _message = new MediaMetricsProviderInitializeParams();
            _message.isMse = isMse;
            _message.urlScheme = urlScheme;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void onError(int status) {
            MediaMetricsProviderOnErrorParams _message = new MediaMetricsProviderOnErrorParams();
            _message.status = status;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void setHasPlayed() {
            MediaMetricsProviderSetHasPlayedParams _message = new MediaMetricsProviderSetHasPlayedParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void setHaveEnough() {
            MediaMetricsProviderSetHaveEnoughParams _message = new MediaMetricsProviderSetHaveEnoughParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void setIsAdMedia() {
            MediaMetricsProviderSetIsAdMediaParams _message = new MediaMetricsProviderSetIsAdMediaParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void setIsEme() {
            MediaMetricsProviderSetIsEmeParams _message = new MediaMetricsProviderSetIsEmeParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void setTimeToMetadata(TimeDelta elapsed) {
            MediaMetricsProviderSetTimeToMetadataParams _message = new MediaMetricsProviderSetTimeToMetadataParams();
            _message.elapsed = elapsed;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void setTimeToFirstFrame(TimeDelta elapsed) {
            MediaMetricsProviderSetTimeToFirstFrameParams _message = new MediaMetricsProviderSetTimeToFirstFrameParams();
            _message.elapsed = elapsed;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void setTimeToPlayReady(TimeDelta elapsed) {
            MediaMetricsProviderSetTimeToPlayReadyParams _message = new MediaMetricsProviderSetTimeToPlayReadyParams();
            _message.elapsed = elapsed;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void setContainerName(int containerName) {
            MediaMetricsProviderSetContainerNameParams _message = new MediaMetricsProviderSetContainerNameParams();
            _message.containerName = containerName;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void acquireWatchTimeRecorder(PlaybackProperties properties, InterfaceRequest<WatchTimeRecorder> recorder) {
            MediaMetricsProviderAcquireWatchTimeRecorderParams _message = new MediaMetricsProviderAcquireWatchTimeRecorderParams();
            _message.properties = properties;
            _message.recorder = recorder;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void acquireVideoDecodeStatsRecorder(InterfaceRequest<VideoDecodeStatsRecorder> recorder) {
            MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams _message = new MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams();
            _message.recorder = recorder;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void addBytesReceived(long bytesReceived) {
            MediaMetricsProviderAddBytesReceivedParams _message = new MediaMetricsProviderAddBytesReceivedParams();
            _message.bytesReceived = bytesReceived;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void setHasAudio(int codec) {
            MediaMetricsProviderSetHasAudioParams _message = new MediaMetricsProviderSetHasAudioParams();
            _message.codec = codec;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void setHasVideo(int codec) {
            MediaMetricsProviderSetHasVideoParams _message = new MediaMetricsProviderSetHasVideoParams();
            _message.codec = codec;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void setVideoPipelineInfo(PipelineDecoderInfo info) {
            MediaMetricsProviderSetVideoPipelineInfoParams _message = new MediaMetricsProviderSetVideoPipelineInfoParams();
            _message.info = info;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(15)));
        }

        @Override // org.chromium.media.mojom.MediaMetricsProvider
        public void setAudioPipelineInfo(PipelineDecoderInfo info) {
            MediaMetricsProviderSetAudioPipelineInfoParams _message = new MediaMetricsProviderSetAudioPipelineInfoParams();
            _message.info = info;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(16)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<MediaMetricsProvider> {
        Stub(Core core, MediaMetricsProvider impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaMetricsProvider_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        MediaMetricsProviderInitializeParams data = MediaMetricsProviderInitializeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().initialize(data.isMse, data.urlScheme);
                        return true;
                    case 1:
                        MediaMetricsProviderOnErrorParams data2 = MediaMetricsProviderOnErrorParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onError(data2.status);
                        return true;
                    case 2:
                        MediaMetricsProviderSetHasPlayedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setHasPlayed();
                        return true;
                    case 3:
                        MediaMetricsProviderSetHaveEnoughParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setHaveEnough();
                        return true;
                    case 4:
                        MediaMetricsProviderSetIsAdMediaParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setIsAdMedia();
                        return true;
                    case 5:
                        MediaMetricsProviderSetIsEmeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setIsEme();
                        return true;
                    case 6:
                        MediaMetricsProviderSetTimeToMetadataParams data3 = MediaMetricsProviderSetTimeToMetadataParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setTimeToMetadata(data3.elapsed);
                        return true;
                    case 7:
                        MediaMetricsProviderSetTimeToFirstFrameParams data4 = MediaMetricsProviderSetTimeToFirstFrameParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setTimeToFirstFrame(data4.elapsed);
                        return true;
                    case 8:
                        MediaMetricsProviderSetTimeToPlayReadyParams data5 = MediaMetricsProviderSetTimeToPlayReadyParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setTimeToPlayReady(data5.elapsed);
                        return true;
                    case 9:
                        MediaMetricsProviderSetContainerNameParams data6 = MediaMetricsProviderSetContainerNameParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setContainerName(data6.containerName);
                        return true;
                    case 10:
                        MediaMetricsProviderAcquireWatchTimeRecorderParams data7 = MediaMetricsProviderAcquireWatchTimeRecorderParams.deserialize(messageWithHeader.getPayload());
                        getImpl().acquireWatchTimeRecorder(data7.properties, data7.recorder);
                        return true;
                    case 11:
                        MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams data8 = MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams.deserialize(messageWithHeader.getPayload());
                        getImpl().acquireVideoDecodeStatsRecorder(data8.recorder);
                        return true;
                    case 12:
                        MediaMetricsProviderAddBytesReceivedParams data9 = MediaMetricsProviderAddBytesReceivedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addBytesReceived(data9.bytesReceived);
                        return true;
                    case 13:
                        MediaMetricsProviderSetHasAudioParams data10 = MediaMetricsProviderSetHasAudioParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setHasAudio(data10.codec);
                        return true;
                    case 14:
                        MediaMetricsProviderSetHasVideoParams data11 = MediaMetricsProviderSetHasVideoParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setHasVideo(data11.codec);
                        return true;
                    case 15:
                        MediaMetricsProviderSetVideoPipelineInfoParams data12 = MediaMetricsProviderSetVideoPipelineInfoParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setVideoPipelineInfo(data12.info);
                        return true;
                    case 16:
                        MediaMetricsProviderSetAudioPipelineInfoParams data13 = MediaMetricsProviderSetAudioPipelineInfoParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setAudioPipelineInfo(data13.info);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), MediaMetricsProvider_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderInitializeParams.class */
    static final class MediaMetricsProviderInitializeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean isMse;
        public int urlScheme;

        private MediaMetricsProviderInitializeParams(int version) {
            super(16, version);
        }

        public MediaMetricsProviderInitializeParams() {
            this(0);
        }

        public static MediaMetricsProviderInitializeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderInitializeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderInitializeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderInitializeParams result = new MediaMetricsProviderInitializeParams(elementsOrVersion);
                result.isMse = decoder0.readBoolean(8, 0);
                result.urlScheme = decoder0.readInt(12);
                MediaUrlScheme.validate(result.urlScheme);
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
            encoder0.encode(this.isMse, 8, 0);
            encoder0.encode(this.urlScheme, 12);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderOnErrorParams.class */
    static final class MediaMetricsProviderOnErrorParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;

        private MediaMetricsProviderOnErrorParams(int version) {
            super(16, version);
        }

        public MediaMetricsProviderOnErrorParams() {
            this(0);
        }

        public static MediaMetricsProviderOnErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderOnErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderOnErrorParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderOnErrorParams result = new MediaMetricsProviderOnErrorParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PipelineStatus.validate(result.status);
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
            encoder0.encode(this.status, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderSetHasPlayedParams.class */
    static final class MediaMetricsProviderSetHasPlayedParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaMetricsProviderSetHasPlayedParams(int version) {
            super(8, version);
        }

        public MediaMetricsProviderSetHasPlayedParams() {
            this(0);
        }

        public static MediaMetricsProviderSetHasPlayedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderSetHasPlayedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderSetHasPlayedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderSetHasPlayedParams result = new MediaMetricsProviderSetHasPlayedParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderSetHaveEnoughParams.class */
    static final class MediaMetricsProviderSetHaveEnoughParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaMetricsProviderSetHaveEnoughParams(int version) {
            super(8, version);
        }

        public MediaMetricsProviderSetHaveEnoughParams() {
            this(0);
        }

        public static MediaMetricsProviderSetHaveEnoughParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderSetHaveEnoughParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderSetHaveEnoughParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderSetHaveEnoughParams result = new MediaMetricsProviderSetHaveEnoughParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderSetIsAdMediaParams.class */
    static final class MediaMetricsProviderSetIsAdMediaParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaMetricsProviderSetIsAdMediaParams(int version) {
            super(8, version);
        }

        public MediaMetricsProviderSetIsAdMediaParams() {
            this(0);
        }

        public static MediaMetricsProviderSetIsAdMediaParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderSetIsAdMediaParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderSetIsAdMediaParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderSetIsAdMediaParams result = new MediaMetricsProviderSetIsAdMediaParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderSetIsEmeParams.class */
    static final class MediaMetricsProviderSetIsEmeParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaMetricsProviderSetIsEmeParams(int version) {
            super(8, version);
        }

        public MediaMetricsProviderSetIsEmeParams() {
            this(0);
        }

        public static MediaMetricsProviderSetIsEmeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderSetIsEmeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderSetIsEmeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderSetIsEmeParams result = new MediaMetricsProviderSetIsEmeParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderSetTimeToMetadataParams.class */
    static final class MediaMetricsProviderSetTimeToMetadataParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public TimeDelta elapsed;

        private MediaMetricsProviderSetTimeToMetadataParams(int version) {
            super(16, version);
        }

        public MediaMetricsProviderSetTimeToMetadataParams() {
            this(0);
        }

        public static MediaMetricsProviderSetTimeToMetadataParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderSetTimeToMetadataParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderSetTimeToMetadataParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderSetTimeToMetadataParams result = new MediaMetricsProviderSetTimeToMetadataParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.elapsed = TimeDelta.decode(decoder1);
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
            encoder0.encode((Struct) this.elapsed, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderSetTimeToFirstFrameParams.class */
    static final class MediaMetricsProviderSetTimeToFirstFrameParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public TimeDelta elapsed;

        private MediaMetricsProviderSetTimeToFirstFrameParams(int version) {
            super(16, version);
        }

        public MediaMetricsProviderSetTimeToFirstFrameParams() {
            this(0);
        }

        public static MediaMetricsProviderSetTimeToFirstFrameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderSetTimeToFirstFrameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderSetTimeToFirstFrameParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderSetTimeToFirstFrameParams result = new MediaMetricsProviderSetTimeToFirstFrameParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.elapsed = TimeDelta.decode(decoder1);
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
            encoder0.encode((Struct) this.elapsed, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderSetTimeToPlayReadyParams.class */
    static final class MediaMetricsProviderSetTimeToPlayReadyParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public TimeDelta elapsed;

        private MediaMetricsProviderSetTimeToPlayReadyParams(int version) {
            super(16, version);
        }

        public MediaMetricsProviderSetTimeToPlayReadyParams() {
            this(0);
        }

        public static MediaMetricsProviderSetTimeToPlayReadyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderSetTimeToPlayReadyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderSetTimeToPlayReadyParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderSetTimeToPlayReadyParams result = new MediaMetricsProviderSetTimeToPlayReadyParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.elapsed = TimeDelta.decode(decoder1);
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
            encoder0.encode((Struct) this.elapsed, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderSetContainerNameParams.class */
    static final class MediaMetricsProviderSetContainerNameParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int containerName;

        private MediaMetricsProviderSetContainerNameParams(int version) {
            super(16, version);
        }

        public MediaMetricsProviderSetContainerNameParams() {
            this(0);
        }

        public static MediaMetricsProviderSetContainerNameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderSetContainerNameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderSetContainerNameParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderSetContainerNameParams result = new MediaMetricsProviderSetContainerNameParams(elementsOrVersion);
                result.containerName = decoder0.readInt(8);
                MediaContainerName.validate(result.containerName);
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
            encoder0.encode(this.containerName, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderAcquireWatchTimeRecorderParams.class */
    static final class MediaMetricsProviderAcquireWatchTimeRecorderParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PlaybackProperties properties;
        public InterfaceRequest<WatchTimeRecorder> recorder;

        private MediaMetricsProviderAcquireWatchTimeRecorderParams(int version) {
            super(24, version);
        }

        public MediaMetricsProviderAcquireWatchTimeRecorderParams() {
            this(0);
        }

        public static MediaMetricsProviderAcquireWatchTimeRecorderParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderAcquireWatchTimeRecorderParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderAcquireWatchTimeRecorderParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderAcquireWatchTimeRecorderParams result = new MediaMetricsProviderAcquireWatchTimeRecorderParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.properties = PlaybackProperties.decode(decoder1);
                result.recorder = decoder0.readInterfaceRequest(16, false);
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
            encoder0.encode((Struct) this.properties, 8, false);
            encoder0.encode((InterfaceRequest) this.recorder, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams.class */
    static final class MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<VideoDecodeStatsRecorder> recorder;

        private MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams(int version) {
            super(16, version);
        }

        public MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams() {
            this(0);
        }

        public static MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams result = new MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams(elementsOrVersion);
                result.recorder = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.recorder, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderAddBytesReceivedParams.class */
    static final class MediaMetricsProviderAddBytesReceivedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public long bytesReceived;

        private MediaMetricsProviderAddBytesReceivedParams(int version) {
            super(16, version);
        }

        public MediaMetricsProviderAddBytesReceivedParams() {
            this(0);
        }

        public static MediaMetricsProviderAddBytesReceivedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderAddBytesReceivedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderAddBytesReceivedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderAddBytesReceivedParams result = new MediaMetricsProviderAddBytesReceivedParams(elementsOrVersion);
                result.bytesReceived = decoder0.readLong(8);
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
            encoder0.encode(this.bytesReceived, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderSetHasAudioParams.class */
    static final class MediaMetricsProviderSetHasAudioParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int codec;

        private MediaMetricsProviderSetHasAudioParams(int version) {
            super(16, version);
        }

        public MediaMetricsProviderSetHasAudioParams() {
            this(0);
        }

        public static MediaMetricsProviderSetHasAudioParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderSetHasAudioParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderSetHasAudioParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderSetHasAudioParams result = new MediaMetricsProviderSetHasAudioParams(elementsOrVersion);
                result.codec = decoder0.readInt(8);
                AudioCodec.validate(result.codec);
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
            encoder0.encode(this.codec, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderSetHasVideoParams.class */
    static final class MediaMetricsProviderSetHasVideoParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int codec;

        private MediaMetricsProviderSetHasVideoParams(int version) {
            super(16, version);
        }

        public MediaMetricsProviderSetHasVideoParams() {
            this(0);
        }

        public static MediaMetricsProviderSetHasVideoParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderSetHasVideoParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderSetHasVideoParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderSetHasVideoParams result = new MediaMetricsProviderSetHasVideoParams(elementsOrVersion);
                result.codec = decoder0.readInt(8);
                VideoCodec.validate(result.codec);
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
            encoder0.encode(this.codec, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderSetVideoPipelineInfoParams.class */
    static final class MediaMetricsProviderSetVideoPipelineInfoParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PipelineDecoderInfo info;

        private MediaMetricsProviderSetVideoPipelineInfoParams(int version) {
            super(16, version);
        }

        public MediaMetricsProviderSetVideoPipelineInfoParams() {
            this(0);
        }

        public static MediaMetricsProviderSetVideoPipelineInfoParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderSetVideoPipelineInfoParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderSetVideoPipelineInfoParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderSetVideoPipelineInfoParams result = new MediaMetricsProviderSetVideoPipelineInfoParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.info = PipelineDecoderInfo.decode(decoder1);
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
            encoder0.encode((Struct) this.info, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider_Internal$MediaMetricsProviderSetAudioPipelineInfoParams.class */
    static final class MediaMetricsProviderSetAudioPipelineInfoParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PipelineDecoderInfo info;

        private MediaMetricsProviderSetAudioPipelineInfoParams(int version) {
            super(16, version);
        }

        public MediaMetricsProviderSetAudioPipelineInfoParams() {
            this(0);
        }

        public static MediaMetricsProviderSetAudioPipelineInfoParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaMetricsProviderSetAudioPipelineInfoParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaMetricsProviderSetAudioPipelineInfoParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaMetricsProviderSetAudioPipelineInfoParams result = new MediaMetricsProviderSetAudioPipelineInfoParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.info = PipelineDecoderInfo.decode(decoder1);
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
            encoder0.encode((Struct) this.info, 8, false);
        }
    }
}
