package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.media.mojom.RendererClient;
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
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.TimeTicks;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal.class */
class RendererClient_Internal {
    public static final Interface.Manager<RendererClient, RendererClient.Proxy> MANAGER = new Interface.Manager<RendererClient, RendererClient.Proxy>() { // from class: org.chromium.media.mojom.RendererClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.RendererClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public RendererClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, RendererClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public RendererClient[] buildArray(int size) {
            return new RendererClient[size];
        }
    };
    private static final int ON_TIME_UPDATE_ORDINAL = 0;
    private static final int ON_BUFFERING_STATE_CHANGE_ORDINAL = 1;
    private static final int ON_ENDED_ORDINAL = 2;
    private static final int ON_ERROR_ORDINAL = 3;
    private static final int ON_AUDIO_CONFIG_CHANGE_ORDINAL = 4;
    private static final int ON_VIDEO_CONFIG_CHANGE_ORDINAL = 5;
    private static final int ON_VIDEO_NATURAL_SIZE_CHANGE_ORDINAL = 6;
    private static final int ON_VIDEO_OPACITY_CHANGE_ORDINAL = 7;
    private static final int ON_STATISTICS_UPDATE_ORDINAL = 8;
    private static final int ON_WAITING_ORDINAL = 9;

    RendererClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements RendererClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.RendererClient
        public void onTimeUpdate(TimeDelta time, TimeDelta maxTime, TimeTicks captureTime) {
            RendererClientOnTimeUpdateParams _message = new RendererClientOnTimeUpdateParams();
            _message.time = time;
            _message.maxTime = maxTime;
            _message.captureTime = captureTime;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.media.mojom.RendererClient
        public void onBufferingStateChange(int state, int reason) {
            RendererClientOnBufferingStateChangeParams _message = new RendererClientOnBufferingStateChangeParams();
            _message.state = state;
            _message.reason = reason;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.media.mojom.RendererClient
        public void onEnded() {
            RendererClientOnEndedParams _message = new RendererClientOnEndedParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.media.mojom.RendererClient
        public void onError() {
            RendererClientOnErrorParams _message = new RendererClientOnErrorParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.media.mojom.RendererClient
        public void onAudioConfigChange(AudioDecoderConfig config) {
            RendererClientOnAudioConfigChangeParams _message = new RendererClientOnAudioConfigChangeParams();
            _message.config = config;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.media.mojom.RendererClient
        public void onVideoConfigChange(VideoDecoderConfig config) {
            RendererClientOnVideoConfigChangeParams _message = new RendererClientOnVideoConfigChangeParams();
            _message.config = config;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }

        @Override // org.chromium.media.mojom.RendererClient
        public void onVideoNaturalSizeChange(Size size) {
            RendererClientOnVideoNaturalSizeChangeParams _message = new RendererClientOnVideoNaturalSizeChangeParams();
            _message.size = size;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
        }

        @Override // org.chromium.media.mojom.RendererClient
        public void onVideoOpacityChange(boolean opaque) {
            RendererClientOnVideoOpacityChangeParams _message = new RendererClientOnVideoOpacityChangeParams();
            _message.opaque = opaque;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
        }

        @Override // org.chromium.media.mojom.RendererClient
        public void onStatisticsUpdate(PipelineStatistics stats) {
            RendererClientOnStatisticsUpdateParams _message = new RendererClientOnStatisticsUpdateParams();
            _message.stats = stats;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
        }

        @Override // org.chromium.media.mojom.RendererClient
        public void onWaiting(int reason) {
            RendererClientOnWaitingParams _message = new RendererClientOnWaitingParams();
            _message.reason = reason;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<RendererClient> {
        Stub(Core core, RendererClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(RendererClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        RendererClientOnTimeUpdateParams data = RendererClientOnTimeUpdateParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onTimeUpdate(data.time, data.maxTime, data.captureTime);
                        return true;
                    case 1:
                        RendererClientOnBufferingStateChangeParams data2 = RendererClientOnBufferingStateChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onBufferingStateChange(data2.state, data2.reason);
                        return true;
                    case 2:
                        RendererClientOnEndedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onEnded();
                        return true;
                    case 3:
                        RendererClientOnErrorParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onError();
                        return true;
                    case 4:
                        RendererClientOnAudioConfigChangeParams data3 = RendererClientOnAudioConfigChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onAudioConfigChange(data3.config);
                        return true;
                    case 5:
                        RendererClientOnVideoConfigChangeParams data4 = RendererClientOnVideoConfigChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onVideoConfigChange(data4.config);
                        return true;
                    case 6:
                        RendererClientOnVideoNaturalSizeChangeParams data5 = RendererClientOnVideoNaturalSizeChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onVideoNaturalSizeChange(data5.size);
                        return true;
                    case 7:
                        RendererClientOnVideoOpacityChangeParams data6 = RendererClientOnVideoOpacityChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onVideoOpacityChange(data6.opaque);
                        return true;
                    case 8:
                        RendererClientOnStatisticsUpdateParams data7 = RendererClientOnStatisticsUpdateParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onStatisticsUpdate(data7.stats);
                        return true;
                    case 9:
                        RendererClientOnWaitingParams data8 = RendererClientOnWaitingParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onWaiting(data8.reason);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), RendererClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal$RendererClientOnTimeUpdateParams.class */
    static final class RendererClientOnTimeUpdateParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public TimeDelta time;
        public TimeDelta maxTime;
        public TimeTicks captureTime;

        private RendererClientOnTimeUpdateParams(int version) {
            super(32, version);
        }

        public RendererClientOnTimeUpdateParams() {
            this(0);
        }

        public static RendererClientOnTimeUpdateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererClientOnTimeUpdateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererClientOnTimeUpdateParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererClientOnTimeUpdateParams result = new RendererClientOnTimeUpdateParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.time = TimeDelta.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.maxTime = TimeDelta.decode(decoder12);
                Decoder decoder13 = decoder0.readPointer(24, false);
                result.captureTime = TimeTicks.decode(decoder13);
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
            encoder0.encode((Struct) this.time, 8, false);
            encoder0.encode((Struct) this.maxTime, 16, false);
            encoder0.encode((Struct) this.captureTime, 24, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal$RendererClientOnBufferingStateChangeParams.class */
    static final class RendererClientOnBufferingStateChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int state;
        public int reason;

        private RendererClientOnBufferingStateChangeParams(int version) {
            super(16, version);
        }

        public RendererClientOnBufferingStateChangeParams() {
            this(0);
        }

        public static RendererClientOnBufferingStateChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererClientOnBufferingStateChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererClientOnBufferingStateChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererClientOnBufferingStateChangeParams result = new RendererClientOnBufferingStateChangeParams(elementsOrVersion);
                result.state = decoder0.readInt(8);
                BufferingState.validate(result.state);
                result.reason = decoder0.readInt(12);
                BufferingStateChangeReason.validate(result.reason);
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
            encoder0.encode(this.state, 8);
            encoder0.encode(this.reason, 12);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal$RendererClientOnEndedParams.class */
    static final class RendererClientOnEndedParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private RendererClientOnEndedParams(int version) {
            super(8, version);
        }

        public RendererClientOnEndedParams() {
            this(0);
        }

        public static RendererClientOnEndedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererClientOnEndedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererClientOnEndedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererClientOnEndedParams result = new RendererClientOnEndedParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal$RendererClientOnErrorParams.class */
    static final class RendererClientOnErrorParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private RendererClientOnErrorParams(int version) {
            super(8, version);
        }

        public RendererClientOnErrorParams() {
            this(0);
        }

        public static RendererClientOnErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererClientOnErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererClientOnErrorParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererClientOnErrorParams result = new RendererClientOnErrorParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal$RendererClientOnAudioConfigChangeParams.class */
    static final class RendererClientOnAudioConfigChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AudioDecoderConfig config;

        private RendererClientOnAudioConfigChangeParams(int version) {
            super(16, version);
        }

        public RendererClientOnAudioConfigChangeParams() {
            this(0);
        }

        public static RendererClientOnAudioConfigChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererClientOnAudioConfigChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererClientOnAudioConfigChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererClientOnAudioConfigChangeParams result = new RendererClientOnAudioConfigChangeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.config = AudioDecoderConfig.decode(decoder1);
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
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal$RendererClientOnVideoConfigChangeParams.class */
    static final class RendererClientOnVideoConfigChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public VideoDecoderConfig config;

        private RendererClientOnVideoConfigChangeParams(int version) {
            super(16, version);
        }

        public RendererClientOnVideoConfigChangeParams() {
            this(0);
        }

        public static RendererClientOnVideoConfigChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererClientOnVideoConfigChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererClientOnVideoConfigChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererClientOnVideoConfigChangeParams result = new RendererClientOnVideoConfigChangeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.config = VideoDecoderConfig.decode(decoder1);
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
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal$RendererClientOnVideoNaturalSizeChangeParams.class */
    static final class RendererClientOnVideoNaturalSizeChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Size size;

        private RendererClientOnVideoNaturalSizeChangeParams(int version) {
            super(16, version);
        }

        public RendererClientOnVideoNaturalSizeChangeParams() {
            this(0);
        }

        public static RendererClientOnVideoNaturalSizeChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererClientOnVideoNaturalSizeChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererClientOnVideoNaturalSizeChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererClientOnVideoNaturalSizeChangeParams result = new RendererClientOnVideoNaturalSizeChangeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.size = Size.decode(decoder1);
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
            encoder0.encode((Struct) this.size, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal$RendererClientOnVideoOpacityChangeParams.class */
    static final class RendererClientOnVideoOpacityChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean opaque;

        private RendererClientOnVideoOpacityChangeParams(int version) {
            super(16, version);
        }

        public RendererClientOnVideoOpacityChangeParams() {
            this(0);
        }

        public static RendererClientOnVideoOpacityChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererClientOnVideoOpacityChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererClientOnVideoOpacityChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererClientOnVideoOpacityChangeParams result = new RendererClientOnVideoOpacityChangeParams(elementsOrVersion);
                result.opaque = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.opaque, 8, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal$RendererClientOnStatisticsUpdateParams.class */
    static final class RendererClientOnStatisticsUpdateParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PipelineStatistics stats;

        private RendererClientOnStatisticsUpdateParams(int version) {
            super(16, version);
        }

        public RendererClientOnStatisticsUpdateParams() {
            this(0);
        }

        public static RendererClientOnStatisticsUpdateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererClientOnStatisticsUpdateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererClientOnStatisticsUpdateParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererClientOnStatisticsUpdateParams result = new RendererClientOnStatisticsUpdateParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.stats = PipelineStatistics.decode(decoder1);
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
            encoder0.encode((Struct) this.stats, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient_Internal$RendererClientOnWaitingParams.class */
    static final class RendererClientOnWaitingParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int reason;

        private RendererClientOnWaitingParams(int version) {
            super(16, version);
        }

        public RendererClientOnWaitingParams() {
            this(0);
        }

        public static RendererClientOnWaitingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static RendererClientOnWaitingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static RendererClientOnWaitingParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                RendererClientOnWaitingParams result = new RendererClientOnWaitingParams(elementsOrVersion);
                result.reason = decoder0.readInt(8);
                WaitingReason.validate(result.reason);
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
            encoder0.encode(this.reason, 8);
        }
    }
}
