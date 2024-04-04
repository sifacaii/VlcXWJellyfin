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

class AudioInputStream_Internal {
    public static final Interface.Manager<AudioInputStream, AudioInputStream.Proxy> MANAGER = new Interface.Manager<AudioInputStream, AudioInputStream.Proxy>() {
        public String getName() {
            return "media.mojom.AudioInputStream";
        }

        public int getVersion() {
            return 0;
        }

        public AudioInputStream_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AudioInputStream_Internal.Proxy(core, messageReceiver);
        }

        public AudioInputStream_Internal.Stub buildStub(Core core, AudioInputStream impl) {
            return new AudioInputStream_Internal.Stub(core, impl);
        }

        public AudioInputStream[] buildArray(int size) {
            return new AudioInputStream[size];
        }
    };

    private static final int RECORD_ORDINAL = 0;

    private static final int SET_VOLUME_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements AudioInputStream.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void record() {
            AudioInputStream_Internal.AudioInputStreamRecordParams _message = new AudioInputStream_Internal.AudioInputStreamRecordParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void setVolume(double volume) {
            AudioInputStream_Internal.AudioInputStreamSetVolumeParams _message = new AudioInputStream_Internal.AudioInputStreamSetVolumeParams();
            _message.volume = volume;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<AudioInputStream> {
        Stub(Core core, AudioInputStream impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AudioInputStream_Internal.AudioInputStreamSetVolumeParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioInputStream_Internal.MANAGER, messageWithHeader);
                    case 0:
                        AudioInputStream_Internal.AudioInputStreamRecordParams.deserialize(messageWithHeader.getPayload());
                        ((AudioInputStream)getImpl()).record();
                        return true;
                    case 1:
                        data = AudioInputStream_Internal.AudioInputStreamSetVolumeParams.deserialize(messageWithHeader.getPayload());
                        ((AudioInputStream)getImpl()).setVolume(data.volume);
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
                                getCore(), AudioInputStream_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AudioInputStreamRecordParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioInputStreamRecordParams(int version) {
            super(8, version);
        }

        public AudioInputStreamRecordParams() {
            this(0);
        }

        public static AudioInputStreamRecordParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioInputStreamRecordParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioInputStreamRecordParams decode(Decoder decoder0) {
            AudioInputStreamRecordParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioInputStreamRecordParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AudioInputStreamSetVolumeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public double volume;

        private AudioInputStreamSetVolumeParams(int version) {
            super(16, version);
        }

        public AudioInputStreamSetVolumeParams() {
            this(0);
        }

        public static AudioInputStreamSetVolumeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioInputStreamSetVolumeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioInputStreamSetVolumeParams decode(Decoder decoder0) {
            AudioInputStreamSetVolumeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioInputStreamSetVolumeParams(elementsOrVersion);
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
