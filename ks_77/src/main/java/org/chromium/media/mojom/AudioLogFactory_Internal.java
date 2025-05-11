package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class AudioLogFactory_Internal {
    public static final Interface.Manager<AudioLogFactory, AudioLogFactory.Proxy> MANAGER = new Interface.Manager<AudioLogFactory, AudioLogFactory.Proxy>() {
        public String getName() {
            return "media.mojom.AudioLogFactory";
        }

        public int getVersion() {
            return 0;
        }

        public AudioLogFactory_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AudioLogFactory_Internal.Proxy(core, messageReceiver);
        }

        public AudioLogFactory_Internal.Stub buildStub(Core core, AudioLogFactory impl) {
            return new AudioLogFactory_Internal.Stub(core, impl);
        }

        public AudioLogFactory[] buildArray(int size) {
            return new AudioLogFactory[size];
        }
    };

    private static final int CREATE_AUDIO_LOG_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements AudioLogFactory.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void createAudioLog(int component, int componentId, InterfaceRequest<AudioLog> audioLogRequest) {
            AudioLogFactory_Internal.AudioLogFactoryCreateAudioLogParams _message = new AudioLogFactory_Internal.AudioLogFactoryCreateAudioLogParams();
            _message.component = component;
            _message.componentId = componentId;
            _message.audioLogRequest = audioLogRequest;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<AudioLogFactory> {
        Stub(Core core, AudioLogFactory impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AudioLogFactory_Internal.AudioLogFactoryCreateAudioLogParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioLogFactory_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = AudioLogFactory_Internal.AudioLogFactoryCreateAudioLogParams.deserialize(messageWithHeader.getPayload());
                        ((AudioLogFactory)getImpl()).createAudioLog(data.component, data.componentId, data.audioLogRequest);
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
                                getCore(), AudioLogFactory_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AudioLogFactoryCreateAudioLogParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int component;

        public int componentId;

        public InterfaceRequest<AudioLog> audioLogRequest;

        private AudioLogFactoryCreateAudioLogParams(int version) {
            super(24, version);
        }

        public AudioLogFactoryCreateAudioLogParams() {
            this(0);
        }

        public static AudioLogFactoryCreateAudioLogParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioLogFactoryCreateAudioLogParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioLogFactoryCreateAudioLogParams decode(Decoder decoder0) {
            AudioLogFactoryCreateAudioLogParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogFactoryCreateAudioLogParams(elementsOrVersion);
                result.component = decoder0.readInt(8);
                AudioLogComponent.validate(result.component);
                result.componentId = decoder0.readInt(12);
                result.audioLogRequest = decoder0.readInterfaceRequest(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.component, 8);
            encoder0.encode(this.componentId, 12);
            encoder0.encode(this.audioLogRequest, 16, false);
        }
    }
}
