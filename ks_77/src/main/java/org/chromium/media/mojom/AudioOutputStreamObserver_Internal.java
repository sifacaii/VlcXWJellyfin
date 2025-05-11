package org.chromium.media.mojom;

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

class AudioOutputStreamObserver_Internal {
    public static final Interface.Manager<AudioOutputStreamObserver, AudioOutputStreamObserver.Proxy> MANAGER = new Interface.Manager<AudioOutputStreamObserver, AudioOutputStreamObserver.Proxy>() {
        public String getName() {
            return "media.mojom.AudioOutputStreamObserver";
        }

        public int getVersion() {
            return 0;
        }

        public AudioOutputStreamObserver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AudioOutputStreamObserver_Internal.Proxy(core, messageReceiver);
        }

        public AudioOutputStreamObserver_Internal.Stub buildStub(Core core, AudioOutputStreamObserver impl) {
            return new AudioOutputStreamObserver_Internal.Stub(core, impl);
        }

        public AudioOutputStreamObserver[] buildArray(int size) {
            return new AudioOutputStreamObserver[size];
        }
    };

    private static final int DID_START_PLAYING_ORDINAL = 0;

    private static final int DID_STOP_PLAYING_ORDINAL = 1;

    private static final int DID_CHANGE_AUDIBLE_STATE_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements AudioOutputStreamObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void didStartPlaying() {
            AudioOutputStreamObserver_Internal.AudioOutputStreamObserverDidStartPlayingParams _message = new AudioOutputStreamObserver_Internal.AudioOutputStreamObserverDidStartPlayingParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void didStopPlaying() {
            AudioOutputStreamObserver_Internal.AudioOutputStreamObserverDidStopPlayingParams _message = new AudioOutputStreamObserver_Internal.AudioOutputStreamObserverDidStopPlayingParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void didChangeAudibleState(boolean isAudible) {
            AudioOutputStreamObserver_Internal.AudioOutputStreamObserverDidChangeAudibleStateParams _message = new AudioOutputStreamObserver_Internal.AudioOutputStreamObserverDidChangeAudibleStateParams();
            _message.isAudible = isAudible;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<AudioOutputStreamObserver> {
        Stub(Core core, AudioOutputStreamObserver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AudioOutputStreamObserver_Internal.AudioOutputStreamObserverDidChangeAudibleStateParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioOutputStreamObserver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        AudioOutputStreamObserver_Internal.AudioOutputStreamObserverDidStartPlayingParams.deserialize(messageWithHeader.getPayload());
                        ((AudioOutputStreamObserver)getImpl()).didStartPlaying();
                        return true;
                    case 1:
                        AudioOutputStreamObserver_Internal.AudioOutputStreamObserverDidStopPlayingParams.deserialize(messageWithHeader.getPayload());
                        ((AudioOutputStreamObserver)getImpl()).didStopPlaying();
                        return true;
                    case 2:
                        data = AudioOutputStreamObserver_Internal.AudioOutputStreamObserverDidChangeAudibleStateParams.deserialize(messageWithHeader.getPayload());
                        ((AudioOutputStreamObserver)getImpl()).didChangeAudibleState(data.isAudible);
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
                                getCore(), AudioOutputStreamObserver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AudioOutputStreamObserverDidStartPlayingParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioOutputStreamObserverDidStartPlayingParams(int version) {
            super(8, version);
        }

        public AudioOutputStreamObserverDidStartPlayingParams() {
            this(0);
        }

        public static AudioOutputStreamObserverDidStartPlayingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioOutputStreamObserverDidStartPlayingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioOutputStreamObserverDidStartPlayingParams decode(Decoder decoder0) {
            AudioOutputStreamObserverDidStartPlayingParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioOutputStreamObserverDidStartPlayingParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AudioOutputStreamObserverDidStopPlayingParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioOutputStreamObserverDidStopPlayingParams(int version) {
            super(8, version);
        }

        public AudioOutputStreamObserverDidStopPlayingParams() {
            this(0);
        }

        public static AudioOutputStreamObserverDidStopPlayingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioOutputStreamObserverDidStopPlayingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioOutputStreamObserverDidStopPlayingParams decode(Decoder decoder0) {
            AudioOutputStreamObserverDidStopPlayingParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioOutputStreamObserverDidStopPlayingParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AudioOutputStreamObserverDidChangeAudibleStateParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean isAudible;

        private AudioOutputStreamObserverDidChangeAudibleStateParams(int version) {
            super(16, version);
        }

        public AudioOutputStreamObserverDidChangeAudibleStateParams() {
            this(0);
        }

        public static AudioOutputStreamObserverDidChangeAudibleStateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioOutputStreamObserverDidChangeAudibleStateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioOutputStreamObserverDidChangeAudibleStateParams decode(Decoder decoder0) {
            AudioOutputStreamObserverDidChangeAudibleStateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioOutputStreamObserverDidChangeAudibleStateParams(elementsOrVersion);
                result.isAudible = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.isAudible, 8, 0);
        }
    }
}
