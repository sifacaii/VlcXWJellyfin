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

class AudioInputStreamObserver_Internal {
    public static final Interface.Manager<AudioInputStreamObserver, AudioInputStreamObserver.Proxy> MANAGER = new Interface.Manager<AudioInputStreamObserver, AudioInputStreamObserver.Proxy>() {
        public String getName() {
            return "media.mojom.AudioInputStreamObserver";
        }

        public int getVersion() {
            return 0;
        }

        public AudioInputStreamObserver_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AudioInputStreamObserver_Internal.Proxy(core, messageReceiver);
        }

        public AudioInputStreamObserver_Internal.Stub buildStub(Core core, AudioInputStreamObserver impl) {
            return new AudioInputStreamObserver_Internal.Stub(core, impl);
        }

        public AudioInputStreamObserver[] buildArray(int size) {
            return new AudioInputStreamObserver[size];
        }
    };

    private static final int DID_START_RECORDING_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements AudioInputStreamObserver.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void didStartRecording() {
            AudioInputStreamObserver_Internal.AudioInputStreamObserverDidStartRecordingParams _message = new AudioInputStreamObserver_Internal.AudioInputStreamObserverDidStartRecordingParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<AudioInputStreamObserver> {
        Stub(Core core, AudioInputStreamObserver impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioInputStreamObserver_Internal.MANAGER, messageWithHeader);
                    case 0:
                        AudioInputStreamObserver_Internal.AudioInputStreamObserverDidStartRecordingParams.deserialize(messageWithHeader.getPayload());
                        ((AudioInputStreamObserver)getImpl()).didStartRecording();
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
                                getCore(), AudioInputStreamObserver_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AudioInputStreamObserverDidStartRecordingParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioInputStreamObserverDidStartRecordingParams(int version) {
            super(8, version);
        }

        public AudioInputStreamObserverDidStartRecordingParams() {
            this(0);
        }

        public static AudioInputStreamObserverDidStartRecordingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioInputStreamObserverDidStartRecordingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioInputStreamObserverDidStartRecordingParams decode(Decoder decoder0) {
            AudioInputStreamObserverDidStartRecordingParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioInputStreamObserverDidStartRecordingParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
