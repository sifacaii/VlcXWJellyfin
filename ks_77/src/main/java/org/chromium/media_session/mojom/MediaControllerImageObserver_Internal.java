package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media_session.mojom.MediaControllerImageObserver;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerImageObserver_Internal.class */
class MediaControllerImageObserver_Internal {
    public static final Interface.Manager<MediaControllerImageObserver, MediaControllerImageObserver.Proxy> MANAGER = new Interface.Manager<MediaControllerImageObserver, MediaControllerImageObserver.Proxy>() { // from class: org.chromium.media_session.mojom.MediaControllerImageObserver_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media_session.mojom.MediaControllerImageObserver";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public MediaControllerImageObserver.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, MediaControllerImageObserver impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public MediaControllerImageObserver[] buildArray(int size) {
            return new MediaControllerImageObserver[size];
        }
    };
    private static final int MEDIA_CONTROLLER_IMAGE_CHANGED_ORDINAL = 0;

    MediaControllerImageObserver_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerImageObserver_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements MediaControllerImageObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media_session.mojom.MediaControllerImageObserver
        public void mediaControllerImageChanged(int type, MediaImageBitmap bitmap) {
            MediaControllerImageObserverMediaControllerImageChangedParams _message = new MediaControllerImageObserverMediaControllerImageChangedParams();
            _message.type = type;
            _message.bitmap = bitmap;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerImageObserver_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<MediaControllerImageObserver> {
        Stub(Core core, MediaControllerImageObserver impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaControllerImageObserver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        MediaControllerImageObserverMediaControllerImageChangedParams data = MediaControllerImageObserverMediaControllerImageChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().mediaControllerImageChanged(data.type, data.bitmap);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), MediaControllerImageObserver_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerImageObserver_Internal$MediaControllerImageObserverMediaControllerImageChangedParams.class */
    static final class MediaControllerImageObserverMediaControllerImageChangedParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;
        public MediaImageBitmap bitmap;

        private MediaControllerImageObserverMediaControllerImageChangedParams(int version) {
            super(24, version);
        }

        public MediaControllerImageObserverMediaControllerImageChangedParams() {
            this(0);
        }

        public static MediaControllerImageObserverMediaControllerImageChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaControllerImageObserverMediaControllerImageChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaControllerImageObserverMediaControllerImageChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaControllerImageObserverMediaControllerImageChangedParams result = new MediaControllerImageObserverMediaControllerImageChangedParams(elementsOrVersion);
                result.type = decoder0.readInt(8);
                MediaSessionImageType.validate(result.type);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.bitmap = MediaImageBitmap.decode(decoder1);
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
            encoder0.encode(this.type, 8);
            encoder0.encode((Struct) this.bitmap, 16, true);
        }
    }
}
