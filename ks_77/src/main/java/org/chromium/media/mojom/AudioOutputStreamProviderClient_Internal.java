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

class AudioOutputStreamProviderClient_Internal {
    public static final Interface.Manager<AudioOutputStreamProviderClient, AudioOutputStreamProviderClient.Proxy> MANAGER = new Interface.Manager<AudioOutputStreamProviderClient, AudioOutputStreamProviderClient.Proxy>() {
        public String getName() {
            return "media.mojom.AudioOutputStreamProviderClient";
        }

        public int getVersion() {
            return 0;
        }

        public AudioOutputStreamProviderClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AudioOutputStreamProviderClient_Internal.Proxy(core, messageReceiver);
        }

        public AudioOutputStreamProviderClient_Internal.Stub buildStub(Core core, AudioOutputStreamProviderClient impl) {
            return new AudioOutputStreamProviderClient_Internal.Stub(core, impl);
        }

        public AudioOutputStreamProviderClient[] buildArray(int size) {
            return new AudioOutputStreamProviderClient[size];
        }
    };

    private static final int CREATED_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements AudioOutputStreamProviderClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void created(AudioOutputStream stream, ReadWriteAudioDataPipe dataPipe) {
            AudioOutputStreamProviderClient_Internal.AudioOutputStreamProviderClientCreatedParams _message = new AudioOutputStreamProviderClient_Internal.AudioOutputStreamProviderClientCreatedParams();
            _message.stream = stream;
            _message.dataPipe = dataPipe;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<AudioOutputStreamProviderClient> {
        Stub(Core core, AudioOutputStreamProviderClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AudioOutputStreamProviderClient_Internal.AudioOutputStreamProviderClientCreatedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioOutputStreamProviderClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = AudioOutputStreamProviderClient_Internal.AudioOutputStreamProviderClientCreatedParams.deserialize(messageWithHeader.getPayload());
                        ((AudioOutputStreamProviderClient)getImpl()).created(data.stream, data.dataPipe);
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
                                getCore(), AudioOutputStreamProviderClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AudioOutputStreamProviderClientCreatedParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AudioOutputStream stream;

        public ReadWriteAudioDataPipe dataPipe;

        private AudioOutputStreamProviderClientCreatedParams(int version) {
            super(24, version);
        }

        public AudioOutputStreamProviderClientCreatedParams() {
            this(0);
        }

        public static AudioOutputStreamProviderClientCreatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioOutputStreamProviderClientCreatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioOutputStreamProviderClientCreatedParams decode(Decoder decoder0) {
            AudioOutputStreamProviderClientCreatedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioOutputStreamProviderClientCreatedParams(elementsOrVersion);
                result.stream = (AudioOutputStream)decoder0.readServiceInterface(8, false, AudioOutputStream.MANAGER);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.dataPipe = ReadWriteAudioDataPipe.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.stream, 8, false, AudioOutputStream.MANAGER);
            encoder0.encode(this.dataPipe, 16, false);
        }
    }
}
