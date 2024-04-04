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

class AudioDecoderClient_Internal {
    public static final Interface.Manager<AudioDecoderClient, AudioDecoderClient.Proxy> MANAGER = new Interface.Manager<AudioDecoderClient, AudioDecoderClient.Proxy>() {
        public String getName() {
            return "media.mojom.AudioDecoderClient";
        }

        public int getVersion() {
            return 0;
        }

        public AudioDecoderClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AudioDecoderClient_Internal.Proxy(core, messageReceiver);
        }

        public AudioDecoderClient_Internal.Stub buildStub(Core core, AudioDecoderClient impl) {
            return new AudioDecoderClient_Internal.Stub(core, impl);
        }

        public AudioDecoderClient[] buildArray(int size) {
            return new AudioDecoderClient[size];
        }
    };

    private static final int ON_BUFFER_DECODED_ORDINAL = 0;

    private static final int ON_WAITING_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements AudioDecoderClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onBufferDecoded(AudioBuffer buffer) {
            AudioDecoderClient_Internal.AudioDecoderClientOnBufferDecodedParams _message = new AudioDecoderClient_Internal.AudioDecoderClientOnBufferDecodedParams();
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onWaiting(int reason) {
            AudioDecoderClient_Internal.AudioDecoderClientOnWaitingParams _message = new AudioDecoderClient_Internal.AudioDecoderClientOnWaitingParams();
            _message.reason = reason;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<AudioDecoderClient> {
        Stub(Core core, AudioDecoderClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AudioDecoderClient_Internal.AudioDecoderClientOnBufferDecodedParams audioDecoderClientOnBufferDecodedParams;
                AudioDecoderClient_Internal.AudioDecoderClientOnWaitingParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioDecoderClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        audioDecoderClientOnBufferDecodedParams = AudioDecoderClient_Internal.AudioDecoderClientOnBufferDecodedParams.deserialize(messageWithHeader.getPayload());
                        ((AudioDecoderClient)getImpl()).onBufferDecoded(audioDecoderClientOnBufferDecodedParams.buffer);
                        return true;
                    case 1:
                        data = AudioDecoderClient_Internal.AudioDecoderClientOnWaitingParams.deserialize(messageWithHeader.getPayload());
                        ((AudioDecoderClient)getImpl()).onWaiting(data.reason);
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
                                getCore(), AudioDecoderClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AudioDecoderClientOnBufferDecodedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AudioBuffer buffer;

        private AudioDecoderClientOnBufferDecodedParams(int version) {
            super(16, version);
        }

        public AudioDecoderClientOnBufferDecodedParams() {
            this(0);
        }

        public static AudioDecoderClientOnBufferDecodedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioDecoderClientOnBufferDecodedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioDecoderClientOnBufferDecodedParams decode(Decoder decoder0) {
            AudioDecoderClientOnBufferDecodedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioDecoderClientOnBufferDecodedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.buffer = AudioBuffer.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.buffer, 8, false);
        }
    }

    static final class AudioDecoderClientOnWaitingParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int reason;

        private AudioDecoderClientOnWaitingParams(int version) {
            super(16, version);
        }

        public AudioDecoderClientOnWaitingParams() {
            this(0);
        }

        public static AudioDecoderClientOnWaitingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioDecoderClientOnWaitingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioDecoderClientOnWaitingParams decode(Decoder decoder0) {
            AudioDecoderClientOnWaitingParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioDecoderClientOnWaitingParams(elementsOrVersion);
                result.reason = decoder0.readInt(8);
                WaitingReason.validate(result.reason);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.reason, 8);
        }
    }
}
