package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.VideoDecoderClient;
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
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoderClient_Internal.class */
class VideoDecoderClient_Internal {
    public static final Interface.Manager<VideoDecoderClient, VideoDecoderClient.Proxy> MANAGER = new Interface.Manager<VideoDecoderClient, VideoDecoderClient.Proxy>() { // from class: org.chromium.media.mojom.VideoDecoderClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.VideoDecoderClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public VideoDecoderClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, VideoDecoderClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public VideoDecoderClient[] buildArray(int size) {
            return new VideoDecoderClient[size];
        }
    };
    private static final int ON_VIDEO_FRAME_DECODED_ORDINAL = 0;
    private static final int ON_WAITING_ORDINAL = 1;
    private static final int REQUEST_OVERLAY_INFO_ORDINAL = 2;

    VideoDecoderClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoderClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements VideoDecoderClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.VideoDecoderClient
        public void onVideoFrameDecoded(VideoFrame frame, boolean canReadWithoutStalling, UnguessableToken releaseToken) {
            VideoDecoderClientOnVideoFrameDecodedParams _message = new VideoDecoderClientOnVideoFrameDecodedParams();
            _message.frame = frame;
            _message.canReadWithoutStalling = canReadWithoutStalling;
            _message.releaseToken = releaseToken;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.media.mojom.VideoDecoderClient
        public void onWaiting(int reason) {
            VideoDecoderClientOnWaitingParams _message = new VideoDecoderClientOnWaitingParams();
            _message.reason = reason;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.media.mojom.VideoDecoderClient
        public void requestOverlayInfo(boolean restartForTransitions) {
            VideoDecoderClientRequestOverlayInfoParams _message = new VideoDecoderClientRequestOverlayInfoParams();
            _message.restartForTransitions = restartForTransitions;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoderClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<VideoDecoderClient> {
        Stub(Core core, VideoDecoderClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(VideoDecoderClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        VideoDecoderClientOnVideoFrameDecodedParams data = VideoDecoderClientOnVideoFrameDecodedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onVideoFrameDecoded(data.frame, data.canReadWithoutStalling, data.releaseToken);
                        return true;
                    case 1:
                        VideoDecoderClientOnWaitingParams data2 = VideoDecoderClientOnWaitingParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onWaiting(data2.reason);
                        return true;
                    case 2:
                        VideoDecoderClientRequestOverlayInfoParams data3 = VideoDecoderClientRequestOverlayInfoParams.deserialize(messageWithHeader.getPayload());
                        getImpl().requestOverlayInfo(data3.restartForTransitions);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), VideoDecoderClient_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoderClient_Internal$VideoDecoderClientOnVideoFrameDecodedParams.class */
    static final class VideoDecoderClientOnVideoFrameDecodedParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public VideoFrame frame;
        public boolean canReadWithoutStalling;
        public UnguessableToken releaseToken;

        private VideoDecoderClientOnVideoFrameDecodedParams(int version) {
            super(32, version);
        }

        public VideoDecoderClientOnVideoFrameDecodedParams() {
            this(0);
        }

        public static VideoDecoderClientOnVideoFrameDecodedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderClientOnVideoFrameDecodedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderClientOnVideoFrameDecodedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoDecoderClientOnVideoFrameDecodedParams result = new VideoDecoderClientOnVideoFrameDecodedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.frame = VideoFrame.decode(decoder1);
                result.canReadWithoutStalling = decoder0.readBoolean(16, 0);
                Decoder decoder12 = decoder0.readPointer(24, true);
                result.releaseToken = UnguessableToken.decode(decoder12);
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
            encoder0.encode(this.canReadWithoutStalling, 16, 0);
            encoder0.encode((Struct) this.releaseToken, 24, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoderClient_Internal$VideoDecoderClientOnWaitingParams.class */
    static final class VideoDecoderClientOnWaitingParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int reason;

        private VideoDecoderClientOnWaitingParams(int version) {
            super(16, version);
        }

        public VideoDecoderClientOnWaitingParams() {
            this(0);
        }

        public static VideoDecoderClientOnWaitingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderClientOnWaitingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderClientOnWaitingParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoDecoderClientOnWaitingParams result = new VideoDecoderClientOnWaitingParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoderClient_Internal$VideoDecoderClientRequestOverlayInfoParams.class */
    static final class VideoDecoderClientRequestOverlayInfoParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean restartForTransitions;

        private VideoDecoderClientRequestOverlayInfoParams(int version) {
            super(16, version);
        }

        public VideoDecoderClientRequestOverlayInfoParams() {
            this(0);
        }

        public static VideoDecoderClientRequestOverlayInfoParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoDecoderClientRequestOverlayInfoParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoDecoderClientRequestOverlayInfoParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoDecoderClientRequestOverlayInfoParams result = new VideoDecoderClientRequestOverlayInfoParams(elementsOrVersion);
                result.restartForTransitions = decoder0.readBoolean(8, 0);
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
            encoder0.encode(this.restartForTransitions, 8, 0);
        }
    }
}
