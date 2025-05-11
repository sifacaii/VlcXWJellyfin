package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media_session.mojom.AudioFocusRequestClient;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestClient_Internal.class */
class AudioFocusRequestClient_Internal {
    public static final Interface.Manager<AudioFocusRequestClient, AudioFocusRequestClient.Proxy> MANAGER = new Interface.Manager<AudioFocusRequestClient, AudioFocusRequestClient.Proxy>() { // from class: org.chromium.media_session.mojom.AudioFocusRequestClient_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media_session.mojom.AudioFocusRequestClient";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public AudioFocusRequestClient.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, AudioFocusRequestClient impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public AudioFocusRequestClient[] buildArray(int size) {
            return new AudioFocusRequestClient[size];
        }
    };
    private static final int REQUEST_AUDIO_FOCUS_ORDINAL = 0;
    private static final int ABANDON_AUDIO_FOCUS_ORDINAL = 1;
    private static final int MEDIA_SESSION_INFO_CHANGED_ORDINAL = 2;

    AudioFocusRequestClient_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestClient_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements AudioFocusRequestClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media_session.mojom.AudioFocusRequestClient
        public void requestAudioFocus(MediaSessionInfo sessionInfo, int type, AudioFocusRequestClient.RequestAudioFocusResponse callback) {
            AudioFocusRequestClientRequestAudioFocusParams _message = new AudioFocusRequestClientRequestAudioFocusParams();
            _message.sessionInfo = sessionInfo;
            _message.type = type;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new AudioFocusRequestClientRequestAudioFocusResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.media_session.mojom.AudioFocusRequestClient
        public void abandonAudioFocus() {
            AudioFocusRequestClientAbandonAudioFocusParams _message = new AudioFocusRequestClientAbandonAudioFocusParams();
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }

        @Override // org.chromium.media_session.mojom.AudioFocusRequestClient
        public void mediaSessionInfoChanged(MediaSessionInfo sessionInfo) {
            AudioFocusRequestClientMediaSessionInfoChangedParams _message = new AudioFocusRequestClientMediaSessionInfoChangedParams();
            _message.sessionInfo = sessionInfo;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestClient_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<AudioFocusRequestClient> {
        Stub(Core core, AudioFocusRequestClient impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioFocusRequestClient_Internal.MANAGER, messageWithHeader);
                    case -1:
                    case 0:
                    default:
                        return false;
                    case 1:
                        AudioFocusRequestClientAbandonAudioFocusParams.deserialize(messageWithHeader.getPayload());
                        getImpl().abandonAudioFocus();
                        return true;
                    case 2:
                        AudioFocusRequestClientMediaSessionInfoChangedParams data = AudioFocusRequestClientMediaSessionInfoChangedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().mediaSessionInfoChanged(data.sessionInfo);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), AudioFocusRequestClient_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        AudioFocusRequestClientRequestAudioFocusParams data = AudioFocusRequestClientRequestAudioFocusParams.deserialize(messageWithHeader.getPayload());
                        getImpl().requestAudioFocus(data.sessionInfo, data.type, new AudioFocusRequestClientRequestAudioFocusResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestClient_Internal$AudioFocusRequestClientRequestAudioFocusParams.class */
    static final class AudioFocusRequestClientRequestAudioFocusParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public MediaSessionInfo sessionInfo;
        public int type;

        private AudioFocusRequestClientRequestAudioFocusParams(int version) {
            super(24, version);
        }

        public AudioFocusRequestClientRequestAudioFocusParams() {
            this(0);
        }

        public static AudioFocusRequestClientRequestAudioFocusParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusRequestClientRequestAudioFocusParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusRequestClientRequestAudioFocusParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusRequestClientRequestAudioFocusParams result = new AudioFocusRequestClientRequestAudioFocusParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.sessionInfo = MediaSessionInfo.decode(decoder1);
                result.type = decoder0.readInt(16);
                AudioFocusType.validate(result.type);
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
            encoder0.encode((Struct) this.sessionInfo, 8, false);
            encoder0.encode(this.type, 16);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestClient_Internal$AudioFocusRequestClientRequestAudioFocusResponseParams.class */
    static final class AudioFocusRequestClientRequestAudioFocusResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioFocusRequestClientRequestAudioFocusResponseParams(int version) {
            super(8, version);
        }

        public AudioFocusRequestClientRequestAudioFocusResponseParams() {
            this(0);
        }

        public static AudioFocusRequestClientRequestAudioFocusResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusRequestClientRequestAudioFocusResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusRequestClientRequestAudioFocusResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusRequestClientRequestAudioFocusResponseParams result = new AudioFocusRequestClientRequestAudioFocusResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestClient_Internal$AudioFocusRequestClientRequestAudioFocusResponseParamsForwardToCallback.class */
    static class AudioFocusRequestClientRequestAudioFocusResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AudioFocusRequestClient.RequestAudioFocusResponse mCallback;

        AudioFocusRequestClientRequestAudioFocusResponseParamsForwardToCallback(AudioFocusRequestClient.RequestAudioFocusResponse callback) {
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
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestClient_Internal$AudioFocusRequestClientRequestAudioFocusResponseParamsProxyToResponder.class */
    static class AudioFocusRequestClientRequestAudioFocusResponseParamsProxyToResponder implements AudioFocusRequestClient.RequestAudioFocusResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        AudioFocusRequestClientRequestAudioFocusResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            AudioFocusRequestClientRequestAudioFocusResponseParams _response = new AudioFocusRequestClientRequestAudioFocusResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestClient_Internal$AudioFocusRequestClientAbandonAudioFocusParams.class */
    static final class AudioFocusRequestClientAbandonAudioFocusParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioFocusRequestClientAbandonAudioFocusParams(int version) {
            super(8, version);
        }

        public AudioFocusRequestClientAbandonAudioFocusParams() {
            this(0);
        }

        public static AudioFocusRequestClientAbandonAudioFocusParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusRequestClientAbandonAudioFocusParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusRequestClientAbandonAudioFocusParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusRequestClientAbandonAudioFocusParams result = new AudioFocusRequestClientAbandonAudioFocusParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestClient_Internal$AudioFocusRequestClientMediaSessionInfoChangedParams.class */
    static final class AudioFocusRequestClientMediaSessionInfoChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public MediaSessionInfo sessionInfo;

        private AudioFocusRequestClientMediaSessionInfoChangedParams(int version) {
            super(16, version);
        }

        public AudioFocusRequestClientMediaSessionInfoChangedParams() {
            this(0);
        }

        public static AudioFocusRequestClientMediaSessionInfoChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusRequestClientMediaSessionInfoChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusRequestClientMediaSessionInfoChangedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusRequestClientMediaSessionInfoChangedParams result = new AudioFocusRequestClientMediaSessionInfoChangedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
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
            encoder0.encode((Struct) this.sessionInfo, 8, false);
        }
    }
}
