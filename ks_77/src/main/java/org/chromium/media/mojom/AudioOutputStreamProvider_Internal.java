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
import org.chromium.mojo_base.mojom.UnguessableToken;

class AudioOutputStreamProvider_Internal {
    public static final Interface.Manager<AudioOutputStreamProvider, AudioOutputStreamProvider.Proxy> MANAGER = new Interface.Manager<AudioOutputStreamProvider, AudioOutputStreamProvider.Proxy>() {
        public String getName() {
            return "media.mojom.AudioOutputStreamProvider";
        }

        public int getVersion() {
            return 0;
        }

        public AudioOutputStreamProvider_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AudioOutputStreamProvider_Internal.Proxy(core, messageReceiver);
        }

        public AudioOutputStreamProvider_Internal.Stub buildStub(Core core, AudioOutputStreamProvider impl) {
            return new AudioOutputStreamProvider_Internal.Stub(core, impl);
        }

        public AudioOutputStreamProvider[] buildArray(int size) {
            return new AudioOutputStreamProvider[size];
        }
    };

    private static final int ACQUIRE_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements AudioOutputStreamProvider.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void acquire(AudioParameters params, AudioOutputStreamProviderClient client, UnguessableToken processingId) {
            AudioOutputStreamProvider_Internal.AudioOutputStreamProviderAcquireParams _message = new AudioOutputStreamProvider_Internal.AudioOutputStreamProviderAcquireParams();
            _message.params = params;
            _message.client = client;
            _message.processingId = processingId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<AudioOutputStreamProvider> {
        Stub(Core core, AudioOutputStreamProvider impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AudioOutputStreamProvider_Internal.AudioOutputStreamProviderAcquireParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioOutputStreamProvider_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = AudioOutputStreamProvider_Internal.AudioOutputStreamProviderAcquireParams.deserialize(messageWithHeader.getPayload());
                        ((AudioOutputStreamProvider)getImpl()).acquire(data.params, data.client, data.processingId);
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
                                getCore(), AudioOutputStreamProvider_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AudioOutputStreamProviderAcquireParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AudioParameters params;

        public AudioOutputStreamProviderClient client;

        public UnguessableToken processingId;

        private AudioOutputStreamProviderAcquireParams(int version) {
            super(32, version);
        }

        public AudioOutputStreamProviderAcquireParams() {
            this(0);
        }

        public static AudioOutputStreamProviderAcquireParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioOutputStreamProviderAcquireParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioOutputStreamProviderAcquireParams decode(Decoder decoder0) {
            AudioOutputStreamProviderAcquireParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioOutputStreamProviderAcquireParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.params = AudioParameters.decode(decoder1);
                result.client = (AudioOutputStreamProviderClient)decoder0.readServiceInterface(16, false, AudioOutputStreamProviderClient.MANAGER);
                decoder1 = decoder0.readPointer(24, true);
                result.processingId = UnguessableToken.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.params, 8, false);
            encoder0.encode(this.client, 16, false, AudioOutputStreamProviderClient.MANAGER);
            encoder0.encode((Struct)this.processingId, 24, true);
        }
    }
}
