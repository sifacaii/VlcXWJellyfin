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

class AudioInputStreamClient_Internal {
    public static final Interface.Manager<AudioInputStreamClient, AudioInputStreamClient.Proxy> MANAGER = new Interface.Manager<AudioInputStreamClient, AudioInputStreamClient.Proxy>() {
        public String getName() {
            return "media.mojom.AudioInputStreamClient";
        }

        public int getVersion() {
            return 0;
        }

        public AudioInputStreamClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AudioInputStreamClient_Internal.Proxy(core, messageReceiver);
        }

        public AudioInputStreamClient_Internal.Stub buildStub(Core core, AudioInputStreamClient impl) {
            return new AudioInputStreamClient_Internal.Stub(core, impl);
        }

        public AudioInputStreamClient[] buildArray(int size) {
            return new AudioInputStreamClient[size];
        }
    };

    private static final int ON_ERROR_ORDINAL = 0;

    private static final int ON_MUTED_STATE_CHANGED_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements AudioInputStreamClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onError() {
            AudioInputStreamClient_Internal.AudioInputStreamClientOnErrorParams _message = new AudioInputStreamClient_Internal.AudioInputStreamClientOnErrorParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onMutedStateChanged(boolean isMuted) {
            AudioInputStreamClient_Internal.AudioInputStreamClientOnMutedStateChangedParams _message = new AudioInputStreamClient_Internal.AudioInputStreamClientOnMutedStateChangedParams();
            _message.isMuted = isMuted;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<AudioInputStreamClient> {
        Stub(Core core, AudioInputStreamClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AudioInputStreamClient_Internal.AudioInputStreamClientOnMutedStateChangedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioInputStreamClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        AudioInputStreamClient_Internal.AudioInputStreamClientOnErrorParams.deserialize(messageWithHeader.getPayload());
                        ((AudioInputStreamClient)getImpl()).onError();
                        return true;
                    case 1:
                        data = AudioInputStreamClient_Internal.AudioInputStreamClientOnMutedStateChangedParams.deserialize(messageWithHeader.getPayload());
                        ((AudioInputStreamClient)getImpl()).onMutedStateChanged(data.isMuted);
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
                                getCore(), AudioInputStreamClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AudioInputStreamClientOnErrorParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioInputStreamClientOnErrorParams(int version) {
            super(8, version);
        }

        public AudioInputStreamClientOnErrorParams() {
            this(0);
        }

        public static AudioInputStreamClientOnErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioInputStreamClientOnErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioInputStreamClientOnErrorParams decode(Decoder decoder0) {
            AudioInputStreamClientOnErrorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioInputStreamClientOnErrorParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AudioInputStreamClientOnMutedStateChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean isMuted;

        private AudioInputStreamClientOnMutedStateChangedParams(int version) {
            super(16, version);
        }

        public AudioInputStreamClientOnMutedStateChangedParams() {
            this(0);
        }

        public static AudioInputStreamClientOnMutedStateChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioInputStreamClientOnMutedStateChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioInputStreamClientOnMutedStateChangedParams decode(Decoder decoder0) {
            AudioInputStreamClientOnMutedStateChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioInputStreamClientOnMutedStateChangedParams(elementsOrVersion);
                result.isMuted = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.isMuted, 8, 0);
        }
    }
}
