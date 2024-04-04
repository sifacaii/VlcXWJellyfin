package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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

class AudioContextManager_Internal {
    public static final Interface.Manager<AudioContextManager, AudioContextManager.Proxy> MANAGER = new Interface.Manager<AudioContextManager, AudioContextManager.Proxy>() {
        public String getName() {
            return "blink.mojom.AudioContextManager";
        }

        public int getVersion() {
            return 0;
        }

        public AudioContextManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AudioContextManager_Internal.Proxy(core, messageReceiver);
        }

        public AudioContextManager_Internal.Stub buildStub(Core core, AudioContextManager impl) {
            return new AudioContextManager_Internal.Stub(core, impl);
        }

        public AudioContextManager[] buildArray(int size) {
            return new AudioContextManager[size];
        }
    };

    private static final int AUDIO_CONTEXT_AUDIBLE_PLAYBACK_STARTED_ORDINAL = 0;

    private static final int AUDIO_CONTEXT_AUDIBLE_PLAYBACK_STOPPED_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements AudioContextManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void audioContextAudiblePlaybackStarted(int id) {
            AudioContextManager_Internal.AudioContextManagerAudioContextAudiblePlaybackStartedParams _message = new AudioContextManager_Internal.AudioContextManagerAudioContextAudiblePlaybackStartedParams();
            _message.id = id;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void audioContextAudiblePlaybackStopped(int id) {
            AudioContextManager_Internal.AudioContextManagerAudioContextAudiblePlaybackStoppedParams _message = new AudioContextManager_Internal.AudioContextManagerAudioContextAudiblePlaybackStoppedParams();
            _message.id = id;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<AudioContextManager> {
        Stub(Core core, AudioContextManager impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AudioContextManager_Internal.AudioContextManagerAudioContextAudiblePlaybackStartedParams audioContextManagerAudioContextAudiblePlaybackStartedParams;
                AudioContextManager_Internal.AudioContextManagerAudioContextAudiblePlaybackStoppedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioContextManager_Internal.MANAGER, messageWithHeader);
                    case 0:
                        audioContextManagerAudioContextAudiblePlaybackStartedParams = AudioContextManager_Internal.AudioContextManagerAudioContextAudiblePlaybackStartedParams.deserialize(messageWithHeader.getPayload());
                        ((AudioContextManager)getImpl()).audioContextAudiblePlaybackStarted(audioContextManagerAudioContextAudiblePlaybackStartedParams.id);
                        return true;
                    case 1:
                        data = AudioContextManager_Internal.AudioContextManagerAudioContextAudiblePlaybackStoppedParams.deserialize(messageWithHeader.getPayload());
                        ((AudioContextManager)getImpl()).audioContextAudiblePlaybackStopped(data.id);
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), AudioContextManager_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AudioContextManagerAudioContextAudiblePlaybackStartedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int id;

        private AudioContextManagerAudioContextAudiblePlaybackStartedParams(int version) {
            super(16, version);
        }

        public AudioContextManagerAudioContextAudiblePlaybackStartedParams() {
            this(0);
        }

        public static AudioContextManagerAudioContextAudiblePlaybackStartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioContextManagerAudioContextAudiblePlaybackStartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioContextManagerAudioContextAudiblePlaybackStartedParams decode(Decoder decoder0) {
            AudioContextManagerAudioContextAudiblePlaybackStartedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioContextManagerAudioContextAudiblePlaybackStartedParams(elementsOrVersion);
                result.id = decoder0.readInt(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.id, 8);
        }
    }

    static final class AudioContextManagerAudioContextAudiblePlaybackStoppedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int id;

        private AudioContextManagerAudioContextAudiblePlaybackStoppedParams(int version) {
            super(16, version);
        }

        public AudioContextManagerAudioContextAudiblePlaybackStoppedParams() {
            this(0);
        }

        public static AudioContextManagerAudioContextAudiblePlaybackStoppedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioContextManagerAudioContextAudiblePlaybackStoppedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioContextManagerAudioContextAudiblePlaybackStoppedParams decode(Decoder decoder0) {
            AudioContextManagerAudioContextAudiblePlaybackStoppedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioContextManagerAudioContextAudiblePlaybackStoppedParams(elementsOrVersion);
                result.id = decoder0.readInt(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.id, 8);
        }
    }
}
