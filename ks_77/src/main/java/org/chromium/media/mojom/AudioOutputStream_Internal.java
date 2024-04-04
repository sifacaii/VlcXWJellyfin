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

class AudioOutputStream_Internal {
    public static final Interface.Manager<AudioOutputStream, AudioOutputStream.Proxy> MANAGER = new Interface.Manager<AudioOutputStream, AudioOutputStream.Proxy>() {
        public String getName() {
            return "media.mojom.AudioOutputStream";
        }

        public int getVersion() {
            return 0;
        }

        public AudioOutputStream_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AudioOutputStream_Internal.Proxy(core, messageReceiver);
        }

        public AudioOutputStream_Internal.Stub buildStub(Core core, AudioOutputStream impl) {
            return new AudioOutputStream_Internal.Stub(core, impl);
        }

        public AudioOutputStream[] buildArray(int size) {
            return new AudioOutputStream[size];
        }
    };

    private static final int PLAY_ORDINAL = 0;

    private static final int PAUSE_ORDINAL = 1;

    private static final int FLUSH_ORDINAL = 2;

    private static final int SET_VOLUME_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements AudioOutputStream.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void play() {
            AudioOutputStream_Internal.AudioOutputStreamPlayParams _message = new AudioOutputStream_Internal.AudioOutputStreamPlayParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void pause() {
            AudioOutputStream_Internal.AudioOutputStreamPauseParams _message = new AudioOutputStream_Internal.AudioOutputStreamPauseParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void flush() {
            AudioOutputStream_Internal.AudioOutputStreamFlushParams _message = new AudioOutputStream_Internal.AudioOutputStreamFlushParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void setVolume(double volume) {
            AudioOutputStream_Internal.AudioOutputStreamSetVolumeParams _message = new AudioOutputStream_Internal.AudioOutputStreamSetVolumeParams();
            _message.volume = volume;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    static final class Stub extends Interface.Stub<AudioOutputStream> {
        Stub(Core core, AudioOutputStream impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AudioOutputStream_Internal.AudioOutputStreamSetVolumeParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioOutputStream_Internal.MANAGER, messageWithHeader);
                    case 0:
                        AudioOutputStream_Internal.AudioOutputStreamPlayParams.deserialize(messageWithHeader.getPayload());
                        ((AudioOutputStream)getImpl()).play();
                        return true;
                    case 1:
                        AudioOutputStream_Internal.AudioOutputStreamPauseParams.deserialize(messageWithHeader.getPayload());
                        ((AudioOutputStream)getImpl()).pause();
                        return true;
                    case 2:
                        AudioOutputStream_Internal.AudioOutputStreamFlushParams.deserialize(messageWithHeader.getPayload());
                        ((AudioOutputStream)getImpl()).flush();
                        return true;
                    case 3:
                        data = AudioOutputStream_Internal.AudioOutputStreamSetVolumeParams.deserialize(messageWithHeader.getPayload());
                        ((AudioOutputStream)getImpl()).setVolume(data.volume);
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
                                getCore(), AudioOutputStream_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AudioOutputStreamPlayParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioOutputStreamPlayParams(int version) {
            super(8, version);
        }

        public AudioOutputStreamPlayParams() {
            this(0);
        }

        public static AudioOutputStreamPlayParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioOutputStreamPlayParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioOutputStreamPlayParams decode(Decoder decoder0) {
            AudioOutputStreamPlayParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioOutputStreamPlayParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AudioOutputStreamPauseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioOutputStreamPauseParams(int version) {
            super(8, version);
        }

        public AudioOutputStreamPauseParams() {
            this(0);
        }

        public static AudioOutputStreamPauseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioOutputStreamPauseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioOutputStreamPauseParams decode(Decoder decoder0) {
            AudioOutputStreamPauseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioOutputStreamPauseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AudioOutputStreamFlushParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioOutputStreamFlushParams(int version) {
            super(8, version);
        }

        public AudioOutputStreamFlushParams() {
            this(0);
        }

        public static AudioOutputStreamFlushParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioOutputStreamFlushParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioOutputStreamFlushParams decode(Decoder decoder0) {
            AudioOutputStreamFlushParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioOutputStreamFlushParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AudioOutputStreamSetVolumeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public double volume;

        private AudioOutputStreamSetVolumeParams(int version) {
            super(16, version);
        }

        public AudioOutputStreamSetVolumeParams() {
            this(0);
        }

        public static AudioOutputStreamSetVolumeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioOutputStreamSetVolumeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioOutputStreamSetVolumeParams decode(Decoder decoder0) {
            AudioOutputStreamSetVolumeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioOutputStreamSetVolumeParams(elementsOrVersion);
                result.volume = decoder0.readDouble(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.volume, 8);
        }
    }
}
