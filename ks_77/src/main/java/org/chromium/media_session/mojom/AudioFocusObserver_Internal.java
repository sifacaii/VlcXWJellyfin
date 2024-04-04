package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media_session.mojom.AudioFocusObserver;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusObserver_Internal.class */
class AudioFocusObserver_Internal {
    public static final Interface.Manager<AudioFocusObserver, AudioFocusObserver.Proxy> MANAGER = new Interface.Manager<AudioFocusObserver, AudioFocusObserver.Proxy>() { // from class: org.chromium.media_session.mojom.AudioFocusObserver_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "media_session.mojom.AudioFocusObserver";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public AudioFocusObserver.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, AudioFocusObserver impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public AudioFocusObserver[] buildArray(int size) {
            return new AudioFocusObserver[size];
        }
    };
    private static final int ON_FOCUS_GAINED_ORDINAL = 0;
    private static final int ON_FOCUS_LOST_ORDINAL = 1;

    AudioFocusObserver_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusObserver_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements AudioFocusObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.media_session.mojom.AudioFocusObserver
        public void onFocusGained(AudioFocusRequestState state) {
            AudioFocusObserverOnFocusGainedParams _message = new AudioFocusObserverOnFocusGainedParams();
            _message.state = state;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
        }

        @Override // org.chromium.media_session.mojom.AudioFocusObserver
        public void onFocusLost(AudioFocusRequestState state) {
            AudioFocusObserverOnFocusLostParams _message = new AudioFocusObserverOnFocusLostParams();
            _message.state = state;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusObserver_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<AudioFocusObserver> {
        Stub(Core core, AudioFocusObserver impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioFocusObserver_Internal.MANAGER, messageWithHeader);
                    case -1:
                    default:
                        return false;
                    case 0:
                        AudioFocusObserverOnFocusGainedParams data = AudioFocusObserverOnFocusGainedParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onFocusGained(data.state);
                        return true;
                    case 1:
                        AudioFocusObserverOnFocusLostParams data2 = AudioFocusObserverOnFocusLostParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onFocusLost(data2.state);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), AudioFocusObserver_Internal.MANAGER, messageWithHeader, receiver);
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusObserver_Internal$AudioFocusObserverOnFocusGainedParams.class */
    static final class AudioFocusObserverOnFocusGainedParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AudioFocusRequestState state;

        private AudioFocusObserverOnFocusGainedParams(int version) {
            super(16, version);
        }

        public AudioFocusObserverOnFocusGainedParams() {
            this(0);
        }

        public static AudioFocusObserverOnFocusGainedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusObserverOnFocusGainedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusObserverOnFocusGainedParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusObserverOnFocusGainedParams result = new AudioFocusObserverOnFocusGainedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.state = AudioFocusRequestState.decode(decoder1);
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
            encoder0.encode((Struct) this.state, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusObserver_Internal$AudioFocusObserverOnFocusLostParams.class */
    static final class AudioFocusObserverOnFocusLostParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AudioFocusRequestState state;

        private AudioFocusObserverOnFocusLostParams(int version) {
            super(16, version);
        }

        public AudioFocusObserverOnFocusLostParams() {
            this(0);
        }

        public static AudioFocusObserverOnFocusLostParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioFocusObserverOnFocusLostParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioFocusObserverOnFocusLostParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                AudioFocusObserverOnFocusLostParams result = new AudioFocusObserverOnFocusLostParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.state = AudioFocusRequestState.decode(decoder1);
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
            encoder0.encode((Struct) this.state, 8, false);
        }
    }
}
