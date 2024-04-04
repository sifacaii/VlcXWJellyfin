package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media_session.mojom.AudioFocusManager;
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
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal.class */
class AudioFocusManager_Internal {
    public static final Interface.Manager<AudioFocusManager, AudioFocusManager.Proxy> MANAGER = new Interface.Manager<AudioFocusManager, AudioFocusManager.Proxy>() { // from class: org.chromium.media_session.mojom.AudioFocusManager_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media_session.mojom.AudioFocusManager";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 5;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public AudioFocusManager.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, AudioFocusManager impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public AudioFocusManager[] buildArray(int size) {
            return new AudioFocusManager[size];
        }
    };
    private static final int REQUEST_AUDIO_FOCUS_ORDINAL = 0;
    private static final int REQUEST_GROUPED_AUDIO_FOCUS_ORDINAL = 4;
    private static final int GET_FOCUS_REQUESTS_ORDINAL = 1;
    private static final int ADD_OBSERVER_ORDINAL = 2;
    private static final int SET_SOURCE_NAME_ORDINAL = 3;
    private static final int SET_ENFORCEMENT_MODE_ORDINAL = 5;

    AudioFocusManager_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements AudioFocusManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media_session.mojom.AudioFocusManager
        public void requestAudioFocus(InterfaceRequest<AudioFocusRequestClient> client, MediaSession mediaSession, MediaSessionInfo sessionInfo, int type, AudioFocusManager.RequestAudioFocusResponse callback) {
            AudioFocusManagerRequestAudioFocusParams _message = new AudioFocusManagerRequestAudioFocusParams();
            _message.client = client;
            _message.mediaSession = mediaSession;
            _message.sessionInfo = sessionInfo;
            _message.type = type;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new AudioFocusManagerRequestAudioFocusResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media_session.mojom.AudioFocusManager
        public void requestGroupedAudioFocus(InterfaceRequest<AudioFocusRequestClient> client, MediaSession mediaSession, MediaSessionInfo sessionInfo, int type, UnguessableToken groupId, AudioFocusManager.RequestGroupedAudioFocusResponse callback) {
            AudioFocusManagerRequestGroupedAudioFocusParams _message = new AudioFocusManagerRequestGroupedAudioFocusParams();
            _message.client = client;
            _message.mediaSession = mediaSession;
            _message.sessionInfo = sessionInfo;
            _message.type = type;
            _message.groupId = groupId;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new AudioFocusManagerRequestGroupedAudioFocusResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media_session.mojom.AudioFocusManager
        public void getFocusRequests(AudioFocusManager.GetFocusRequestsResponse callback) {
            AudioFocusManagerGetFocusRequestsParams _message = new AudioFocusManagerGetFocusRequestsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new AudioFocusManagerGetFocusRequestsResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media_session.mojom.AudioFocusManager
        public void addObserver(AudioFocusObserver observer) {
            AudioFocusManagerAddObserverParams _message = new AudioFocusManagerAddObserverParams();
            _message.observer = observer;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }

        @Override // org.chromium.media_session.mojom.AudioFocusManager
        public void setSourceName(String name) {
            AudioFocusManagerSetSourceNameParams _message = new AudioFocusManagerSetSourceNameParams();
            _message.name = name;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
        }

        @Override // org.chromium.media_session.mojom.AudioFocusManager
        public void setEnforcementMode(int mode) {
            AudioFocusManagerSetEnforcementModeParams _message = new AudioFocusManagerSetEnforcementModeParams();
            _message.mode = mode;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<AudioFocusManager> {
        Stub(Core core, AudioFocusManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioFocusManager_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 0:
                    case 1:
                    case 4:
                    default:
                        return false;
                    case 2:
                        AudioFocusManagerAddObserverParams data = AudioFocusManagerAddObserverParams.deserialize(messageWithHeader.getPayload());
                        getImpl().addObserver(data.observer);
                        return true;
                    case 3:
                        AudioFocusManagerSetSourceNameParams data2 = AudioFocusManagerSetSourceNameParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setSourceName(data2.name);
                        return true;
                    case 5:
                        AudioFocusManagerSetEnforcementModeParams data3 = AudioFocusManagerSetEnforcementModeParams.deserialize(messageWithHeader.getPayload());
                        getImpl().setEnforcementMode(data3.mode);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), AudioFocusManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        AudioFocusManagerRequestAudioFocusParams data = AudioFocusManagerRequestAudioFocusParams.deserialize(messageWithHeader.getPayload());
                        getImpl().requestAudioFocus(data.client, data.mediaSession, data.sessionInfo, data.type, new AudioFocusManagerRequestAudioFocusResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        AudioFocusManagerGetFocusRequestsParams.deserialize(messageWithHeader.getPayload());
                        getImpl().getFocusRequests(new AudioFocusManagerGetFocusRequestsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                    case 3:
                    default:
                        return false;
                    case 4:
                        AudioFocusManagerRequestGroupedAudioFocusParams data2 = AudioFocusManagerRequestGroupedAudioFocusParams.deserialize(messageWithHeader.getPayload());
                        getImpl().requestGroupedAudioFocus(data2.client, data2.mediaSession, data2.sessionInfo, data2.type, data2.groupId, new AudioFocusManagerRequestGroupedAudioFocusResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerRequestAudioFocusParams.class */
    static final class AudioFocusManagerRequestAudioFocusParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<AudioFocusRequestClient> client;
        public MediaSession mediaSession;
        public MediaSessionInfo sessionInfo;
        public int type;

        private AudioFocusManagerRequestAudioFocusParams(int version) {
            super(32, version);
        }

        public AudioFocusManagerRequestAudioFocusParams() {
            this(0);
        }

        public static AudioFocusManagerRequestAudioFocusParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusManagerRequestAudioFocusParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusManagerRequestAudioFocusParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusManagerRequestAudioFocusParams result = new AudioFocusManagerRequestAudioFocusParams(elementsOrVersion);
                result.client = decoder0.readInterfaceRequest(8, false);
                result.mediaSession = (MediaSession) decoder0.readServiceInterface(12, false, MediaSession.MANAGER);
                result.type = decoder0.readInt(20);
                AudioFocusType.validate(result.type);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.sessionInfo = MediaSessionInfo.decode(decoder1);
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
            encoder0.encode((InterfaceRequest) this.client, 8, false);
            encoder0.encode( this.mediaSession, 12, false, MediaSession.MANAGER);
            encoder0.encode(this.type, 20);
            encoder0.encode((Struct) this.sessionInfo, 24, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerRequestAudioFocusResponseParams.class */
    public static final class AudioFocusManagerRequestAudioFocusResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public UnguessableToken requestId;

        private AudioFocusManagerRequestAudioFocusResponseParams(int version) {
            super(16, version);
        }

        public AudioFocusManagerRequestAudioFocusResponseParams() {
            this(0);
        }

        public static AudioFocusManagerRequestAudioFocusResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusManagerRequestAudioFocusResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusManagerRequestAudioFocusResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusManagerRequestAudioFocusResponseParams result = new AudioFocusManagerRequestAudioFocusResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
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
            encoder0.encode((Struct) this.requestId, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerRequestAudioFocusResponseParamsForwardToCallback.class */
    static class AudioFocusManagerRequestAudioFocusResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AudioFocusManager.RequestAudioFocusResponse mCallback;

        AudioFocusManagerRequestAudioFocusResponseParamsForwardToCallback(AudioFocusManager.RequestAudioFocusResponse callback) {
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
                AudioFocusManagerRequestAudioFocusResponseParams response = AudioFocusManagerRequestAudioFocusResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.requestId);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerRequestAudioFocusResponseParamsProxyToResponder.class */
    static class AudioFocusManagerRequestAudioFocusResponseParamsProxyToResponder implements AudioFocusManager.RequestAudioFocusResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        AudioFocusManagerRequestAudioFocusResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(UnguessableToken requestId) {
            AudioFocusManagerRequestAudioFocusResponseParams _response = new AudioFocusManagerRequestAudioFocusResponseParams();
            _response.requestId = requestId;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerRequestGroupedAudioFocusParams.class */
    static final class AudioFocusManagerRequestGroupedAudioFocusParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<AudioFocusRequestClient> client;
        public MediaSession mediaSession;
        public MediaSessionInfo sessionInfo;
        public int type;
        public UnguessableToken groupId;

        private AudioFocusManagerRequestGroupedAudioFocusParams(int version) {
            super(40, version);
        }

        public AudioFocusManagerRequestGroupedAudioFocusParams() {
            this(0);
        }

        public static AudioFocusManagerRequestGroupedAudioFocusParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusManagerRequestGroupedAudioFocusParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusManagerRequestGroupedAudioFocusParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusManagerRequestGroupedAudioFocusParams result = new AudioFocusManagerRequestGroupedAudioFocusParams(elementsOrVersion);
                result.client = decoder0.readInterfaceRequest(8, false);
                result.mediaSession = (MediaSession) decoder0.readServiceInterface(12, false, MediaSession.MANAGER);
                result.type = decoder0.readInt(20);
                AudioFocusType.validate(result.type);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.sessionInfo = MediaSessionInfo.decode(decoder1);
                Decoder decoder12 = decoder0.readPointer(32, false);
                result.groupId = UnguessableToken.decode(decoder12);
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
            encoder0.encode((InterfaceRequest) this.client, 8, false);
            encoder0.encode( this.mediaSession, 12, false, MediaSession.MANAGER);
            encoder0.encode(this.type, 20);
            encoder0.encode((Struct) this.sessionInfo, 24, false);
            encoder0.encode((Struct) this.groupId, 32, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerRequestGroupedAudioFocusResponseParams.class */
    public static final class AudioFocusManagerRequestGroupedAudioFocusResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public UnguessableToken requestId;

        private AudioFocusManagerRequestGroupedAudioFocusResponseParams(int version) {
            super(16, version);
        }

        public AudioFocusManagerRequestGroupedAudioFocusResponseParams() {
            this(0);
        }

        public static AudioFocusManagerRequestGroupedAudioFocusResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusManagerRequestGroupedAudioFocusResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusManagerRequestGroupedAudioFocusResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusManagerRequestGroupedAudioFocusResponseParams result = new AudioFocusManagerRequestGroupedAudioFocusResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
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
            encoder0.encode((Struct) this.requestId, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerRequestGroupedAudioFocusResponseParamsForwardToCallback.class */
    static class AudioFocusManagerRequestGroupedAudioFocusResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AudioFocusManager.RequestGroupedAudioFocusResponse mCallback;

        AudioFocusManagerRequestGroupedAudioFocusResponseParamsForwardToCallback(AudioFocusManager.RequestGroupedAudioFocusResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2)) {
                    return false;
                }
                AudioFocusManagerRequestGroupedAudioFocusResponseParams response = AudioFocusManagerRequestGroupedAudioFocusResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.requestId);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerRequestGroupedAudioFocusResponseParamsProxyToResponder.class */
    static class AudioFocusManagerRequestGroupedAudioFocusResponseParamsProxyToResponder implements AudioFocusManager.RequestGroupedAudioFocusResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        AudioFocusManagerRequestGroupedAudioFocusResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(UnguessableToken requestId) {
            AudioFocusManagerRequestGroupedAudioFocusResponseParams _response = new AudioFocusManagerRequestGroupedAudioFocusResponseParams();
            _response.requestId = requestId;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerGetFocusRequestsParams.class */
    static final class AudioFocusManagerGetFocusRequestsParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioFocusManagerGetFocusRequestsParams(int version) {
            super(8, version);
        }

        public AudioFocusManagerGetFocusRequestsParams() {
            this(0);
        }

        public static AudioFocusManagerGetFocusRequestsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusManagerGetFocusRequestsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusManagerGetFocusRequestsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusManagerGetFocusRequestsParams result = new AudioFocusManagerGetFocusRequestsParams(elementsOrVersion);
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
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerGetFocusRequestsResponseParams.class */
    public static final class AudioFocusManagerGetFocusRequestsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AudioFocusRequestState[] requests;

        private AudioFocusManagerGetFocusRequestsResponseParams(int version) {
            super(16, version);
        }

        public AudioFocusManagerGetFocusRequestsResponseParams() {
            this(0);
        }

        public static AudioFocusManagerGetFocusRequestsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusManagerGetFocusRequestsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusManagerGetFocusRequestsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusManagerGetFocusRequestsResponseParams result = new AudioFocusManagerGetFocusRequestsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.requests = new AudioFocusRequestState[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.requests[i1] = AudioFocusRequestState.decode(decoder2);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.requests == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.requests.length, 8, -1);
            for (int i0 = 0; i0 < this.requests.length; i0++) {
                encoder1.encode((Struct) this.requests[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerGetFocusRequestsResponseParamsForwardToCallback.class */
    static class AudioFocusManagerGetFocusRequestsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AudioFocusManager.GetFocusRequestsResponse mCallback;

        AudioFocusManagerGetFocusRequestsResponseParamsForwardToCallback(AudioFocusManager.GetFocusRequestsResponse callback) {
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
                AudioFocusManagerGetFocusRequestsResponseParams response = AudioFocusManagerGetFocusRequestsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.requests);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerGetFocusRequestsResponseParamsProxyToResponder.class */
    static class AudioFocusManagerGetFocusRequestsResponseParamsProxyToResponder implements AudioFocusManager.GetFocusRequestsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        AudioFocusManagerGetFocusRequestsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(AudioFocusRequestState[] requests) {
            AudioFocusManagerGetFocusRequestsResponseParams _response = new AudioFocusManagerGetFocusRequestsResponseParams();
            _response.requests = requests;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerAddObserverParams.class */
    static final class AudioFocusManagerAddObserverParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AudioFocusObserver observer;

        private AudioFocusManagerAddObserverParams(int version) {
            super(16, version);
        }

        public AudioFocusManagerAddObserverParams() {
            this(0);
        }

        public static AudioFocusManagerAddObserverParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusManagerAddObserverParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusManagerAddObserverParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusManagerAddObserverParams result = new AudioFocusManagerAddObserverParams(elementsOrVersion);
                result.observer = (AudioFocusObserver) decoder0.readServiceInterface(8, false, AudioFocusObserver.MANAGER);
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
            encoder0.encode( this.observer, 8, false,  AudioFocusObserver.MANAGER);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerSetSourceNameParams.class */
    static final class AudioFocusManagerSetSourceNameParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String name;

        private AudioFocusManagerSetSourceNameParams(int version) {
            super(16, version);
        }

        public AudioFocusManagerSetSourceNameParams() {
            this(0);
        }

        public static AudioFocusManagerSetSourceNameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusManagerSetSourceNameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusManagerSetSourceNameParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusManagerSetSourceNameParams result = new AudioFocusManagerSetSourceNameParams(elementsOrVersion);
                result.name = decoder0.readString(8, false);
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
            encoder0.encode(this.name, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager_Internal$AudioFocusManagerSetEnforcementModeParams.class */
    static final class AudioFocusManagerSetEnforcementModeParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int mode;

        private AudioFocusManagerSetEnforcementModeParams(int version) {
            super(16, version);
        }

        public AudioFocusManagerSetEnforcementModeParams() {
            this(0);
        }

        public static AudioFocusManagerSetEnforcementModeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusManagerSetEnforcementModeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusManagerSetEnforcementModeParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusManagerSetEnforcementModeParams result = new AudioFocusManagerSetEnforcementModeParams(elementsOrVersion);
                result.mode = decoder0.readInt(8);
                EnforcementMode.validate(result.mode);
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
            encoder0.encode(this.mode, 8);
        }
    }
}
