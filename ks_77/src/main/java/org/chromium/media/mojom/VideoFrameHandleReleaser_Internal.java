package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gpu.mojom.SyncToken;
import org.chromium.media.mojom.VideoFrameHandleReleaser;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoFrameHandleReleaser_Internal.class */
class VideoFrameHandleReleaser_Internal {
    public static final Interface.Manager<VideoFrameHandleReleaser, VideoFrameHandleReleaser.Proxy> MANAGER = new Interface.Manager<VideoFrameHandleReleaser, VideoFrameHandleReleaser.Proxy>() { // from class: org.chromium.media.mojom.VideoFrameHandleReleaser_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.VideoFrameHandleReleaser";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public VideoFrameHandleReleaser.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, VideoFrameHandleReleaser impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public VideoFrameHandleReleaser[] buildArray(int size) {
            return new VideoFrameHandleReleaser[size];
        }
    };
    private static final int RELEASE_VIDEO_FRAME_ORDINAL = 0;

    VideoFrameHandleReleaser_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoFrameHandleReleaser_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements VideoFrameHandleReleaser.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.VideoFrameHandleReleaser
        public void releaseVideoFrame(UnguessableToken releaseToken, SyncToken releaseSyncToken) {
            VideoFrameHandleReleaserReleaseVideoFrameParams _message = new VideoFrameHandleReleaserReleaseVideoFrameParams();
            _message.releaseToken = releaseToken;
            _message.releaseSyncToken = releaseSyncToken;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoFrameHandleReleaser_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<VideoFrameHandleReleaser> {
        Stub(Core core, VideoFrameHandleReleaser impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(VideoFrameHandleReleaser_Internal.MANAGER, messageWithHeader);
                    case 0:
                        VideoFrameHandleReleaserReleaseVideoFrameParams data = VideoFrameHandleReleaserReleaseVideoFrameParams.deserialize(messageWithHeader.getPayload());
                        getImpl().releaseVideoFrame(data.releaseToken, data.releaseSyncToken);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), VideoFrameHandleReleaser_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoFrameHandleReleaser_Internal$VideoFrameHandleReleaserReleaseVideoFrameParams.class */
    static final class VideoFrameHandleReleaserReleaseVideoFrameParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public UnguessableToken releaseToken;
        public SyncToken releaseSyncToken;

        private VideoFrameHandleReleaserReleaseVideoFrameParams(int version) {
            super(24, version);
        }

        public VideoFrameHandleReleaserReleaseVideoFrameParams() {
            this(0);
        }

        public static VideoFrameHandleReleaserReleaseVideoFrameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static VideoFrameHandleReleaserReleaseVideoFrameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static VideoFrameHandleReleaserReleaseVideoFrameParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                VideoFrameHandleReleaserReleaseVideoFrameParams result = new VideoFrameHandleReleaserReleaseVideoFrameParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.releaseToken = UnguessableToken.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(16, false);
                result.releaseSyncToken = SyncToken.decode(decoder12);
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
            encoder0.encode((Struct) this.releaseToken, 8, false);
            encoder0.encode((Struct) this.releaseSyncToken, 16, false);
        }
    }
}
