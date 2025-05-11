package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.media.mojom.MediaPlayerRendererClientExtension;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererClientExtension_Internal.class */
class MediaPlayerRendererClientExtension_Internal {
    public static final Interface.Manager<MediaPlayerRendererClientExtension, MediaPlayerRendererClientExtension.Proxy> MANAGER = new Interface.Manager<MediaPlayerRendererClientExtension, MediaPlayerRendererClientExtension.Proxy>() { // from class: org.chromium.media.mojom.MediaPlayerRendererClientExtension_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media.mojom.MediaPlayerRendererClientExtension";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public MediaPlayerRendererClientExtension.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, MediaPlayerRendererClientExtension impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public MediaPlayerRendererClientExtension[] buildArray(int size) {
            return new MediaPlayerRendererClientExtension[size];
        }
    };
    private static final int ON_VIDEO_SIZE_CHANGE_ORDINAL = 0;
    private static final int ON_DURATION_CHANGE_ORDINAL = 1;

    MediaPlayerRendererClientExtension_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererClientExtension_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements MediaPlayerRendererClientExtension.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media.mojom.MediaPlayerRendererClientExtension
        public void onVideoSizeChange(Size size) {
            MediaPlayerRendererClientExtensionOnVideoSizeChangeParams _message = new MediaPlayerRendererClientExtensionOnVideoSizeChangeParams();
            _message.size = size;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.media.mojom.MediaPlayerRendererClientExtension
        public void onDurationChange(TimeDelta duration) {
            MediaPlayerRendererClientExtensionOnDurationChangeParams _message = new MediaPlayerRendererClientExtensionOnDurationChangeParams();
            _message.duration = duration;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererClientExtension_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<MediaPlayerRendererClientExtension> {
        Stub(Core core, MediaPlayerRendererClientExtension impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaPlayerRendererClientExtension_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        MediaPlayerRendererClientExtensionOnVideoSizeChangeParams data = MediaPlayerRendererClientExtensionOnVideoSizeChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onVideoSizeChange(data.size);
                        return true;
                    case 1:
                        MediaPlayerRendererClientExtensionOnDurationChangeParams data2 = MediaPlayerRendererClientExtensionOnDurationChangeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onDurationChange(data2.duration);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), MediaPlayerRendererClientExtension_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererClientExtension_Internal$MediaPlayerRendererClientExtensionOnVideoSizeChangeParams.class */
    static final class MediaPlayerRendererClientExtensionOnVideoSizeChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Size size;

        private MediaPlayerRendererClientExtensionOnVideoSizeChangeParams(int version) {
            super(16, version);
        }

        public MediaPlayerRendererClientExtensionOnVideoSizeChangeParams() {
            this(0);
        }

        public static MediaPlayerRendererClientExtensionOnVideoSizeChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaPlayerRendererClientExtensionOnVideoSizeChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaPlayerRendererClientExtensionOnVideoSizeChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaPlayerRendererClientExtensionOnVideoSizeChangeParams result = new MediaPlayerRendererClientExtensionOnVideoSizeChangeParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererClientExtension_Internal$MediaPlayerRendererClientExtensionOnDurationChangeParams.class */
    static final class MediaPlayerRendererClientExtensionOnDurationChangeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public TimeDelta duration;

        private MediaPlayerRendererClientExtensionOnDurationChangeParams(int version) {
            super(16, version);
        }

        public MediaPlayerRendererClientExtensionOnDurationChangeParams() {
            this(0);
        }

        public static MediaPlayerRendererClientExtensionOnDurationChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaPlayerRendererClientExtensionOnDurationChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaPlayerRendererClientExtensionOnDurationChangeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaPlayerRendererClientExtensionOnDurationChangeParams result = new MediaPlayerRendererClientExtensionOnDurationChangeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.duration = TimeDelta.decode(decoder1);
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
            encoder0.encode((Struct) this.duration, 8, false);
        }
    }
}
