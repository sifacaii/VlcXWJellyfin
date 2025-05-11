package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media_session.mojom.MediaControllerManager;
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
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerManager_Internal.class */
class MediaControllerManager_Internal {
    public static final Interface.Manager<MediaControllerManager, MediaControllerManager.Proxy> MANAGER = new Interface.Manager<MediaControllerManager, MediaControllerManager.Proxy>() { // from class: org.chromium.media_session.mojom.MediaControllerManager_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media_session.mojom.MediaControllerManager";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public MediaControllerManager.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, MediaControllerManager impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public MediaControllerManager[] buildArray(int size) {
            return new MediaControllerManager[size];
        }
    };
    private static final int CREATE_MEDIA_CONTROLLER_FOR_SESSION_ORDINAL = 0;
    private static final int CREATE_ACTIVE_MEDIA_CONTROLLER_ORDINAL = 1;
    private static final int SUSPEND_ALL_SESSIONS_ORDINAL = 2;

    MediaControllerManager_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerManager_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements MediaControllerManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media_session.mojom.MediaControllerManager
        public void createMediaControllerForSession(InterfaceRequest<MediaController> receiver, UnguessableToken requestId) {
            MediaControllerManagerCreateMediaControllerForSessionParams _message = new MediaControllerManagerCreateMediaControllerForSessionParams();
            _message.receiver = receiver;
            _message.requestId = requestId;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.media_session.mojom.MediaControllerManager
        public void createActiveMediaController(InterfaceRequest<MediaController> receiver) {
            MediaControllerManagerCreateActiveMediaControllerParams _message = new MediaControllerManagerCreateActiveMediaControllerParams();
            _message.receiver = receiver;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.media_session.mojom.MediaControllerManager
        public void suspendAllSessions() {
            MediaControllerManagerSuspendAllSessionsParams _message = new MediaControllerManagerSuspendAllSessionsParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerManager_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<MediaControllerManager> {
        Stub(Core core, MediaControllerManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(MediaControllerManager_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        MediaControllerManagerCreateMediaControllerForSessionParams data = MediaControllerManagerCreateMediaControllerForSessionParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createMediaControllerForSession(data.receiver, data.requestId);
                        return true;
                    case 1:
                        getImpl().createActiveMediaController(MediaControllerManagerCreateActiveMediaControllerParams.deserialize(messageWithHeader.getPayload()).receiver);
                        return true;
                    case 2:
                        MediaControllerManagerSuspendAllSessionsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().suspendAllSessions();
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), MediaControllerManager_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerManager_Internal$MediaControllerManagerCreateMediaControllerForSessionParams.class */
    static final class MediaControllerManagerCreateMediaControllerForSessionParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<MediaController> receiver;
        public UnguessableToken requestId;

        private MediaControllerManagerCreateMediaControllerForSessionParams(int version) {
            super(24, version);
        }

        public MediaControllerManagerCreateMediaControllerForSessionParams() {
            this(0);
        }

        public static MediaControllerManagerCreateMediaControllerForSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaControllerManagerCreateMediaControllerForSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaControllerManagerCreateMediaControllerForSessionParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaControllerManagerCreateMediaControllerForSessionParams result = new MediaControllerManagerCreateMediaControllerForSessionParams(elementsOrVersion);
                result.receiver = decoder0.readInterfaceRequest(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.requestId = UnguessableToken.decode(decoder1);
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
            encoder0.encode((InterfaceRequest) this.receiver, 8, false);
            encoder0.encode((Struct) this.requestId, 16, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerManager_Internal$MediaControllerManagerCreateActiveMediaControllerParams.class */
    static final class MediaControllerManagerCreateActiveMediaControllerParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<MediaController> receiver;

        private MediaControllerManagerCreateActiveMediaControllerParams(int version) {
            super(16, version);
        }

        public MediaControllerManagerCreateActiveMediaControllerParams() {
            this(0);
        }

        public static MediaControllerManagerCreateActiveMediaControllerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaControllerManagerCreateActiveMediaControllerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaControllerManagerCreateActiveMediaControllerParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaControllerManagerCreateActiveMediaControllerParams result = new MediaControllerManagerCreateActiveMediaControllerParams(elementsOrVersion);
                result.receiver = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.receiver, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerManager_Internal$MediaControllerManagerSuspendAllSessionsParams.class */
    static final class MediaControllerManagerSuspendAllSessionsParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaControllerManagerSuspendAllSessionsParams(int version) {
            super(8, version);
        }

        public MediaControllerManagerSuspendAllSessionsParams() {
            this(0);
        }

        public static MediaControllerManagerSuspendAllSessionsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static MediaControllerManagerSuspendAllSessionsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static MediaControllerManagerSuspendAllSessionsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                MediaControllerManagerSuspendAllSessionsParams result = new MediaControllerManagerSuspendAllSessionsParams(elementsOrVersion);
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
}
