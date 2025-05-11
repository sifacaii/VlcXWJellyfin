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

class SpeechRecognizer_Internal {
    public static final Interface.Manager<SpeechRecognizer, SpeechRecognizer.Proxy> MANAGER = new Interface.Manager<SpeechRecognizer, SpeechRecognizer.Proxy>() {
        public String getName() {
            return "blink.mojom.SpeechRecognizer";
        }

        public int getVersion() {
            return 0;
        }

        public SpeechRecognizer_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SpeechRecognizer_Internal.Proxy(core, messageReceiver);
        }

        public SpeechRecognizer_Internal.Stub buildStub(Core core, SpeechRecognizer impl) {
            return new SpeechRecognizer_Internal.Stub(core, impl);
        }

        public SpeechRecognizer[] buildArray(int size) {
            return new SpeechRecognizer[size];
        }
    };

    private static final int START_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements SpeechRecognizer.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void start(StartSpeechRecognitionRequestParams params) {
            SpeechRecognizer_Internal.SpeechRecognizerStartParams _message = new SpeechRecognizer_Internal.SpeechRecognizerStartParams();
            _message.params = params;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<SpeechRecognizer> {
        Stub(Core core, SpeechRecognizer impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                SpeechRecognizer_Internal.SpeechRecognizerStartParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SpeechRecognizer_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = SpeechRecognizer_Internal.SpeechRecognizerStartParams.deserialize(messageWithHeader.getPayload());
                        ((SpeechRecognizer)getImpl()).start(data.params);
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
                                getCore(), SpeechRecognizer_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SpeechRecognizerStartParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public StartSpeechRecognitionRequestParams params;

        private SpeechRecognizerStartParams(int version) {
            super(16, version);
        }

        public SpeechRecognizerStartParams() {
            this(0);
        }

        public static SpeechRecognizerStartParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SpeechRecognizerStartParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SpeechRecognizerStartParams decode(Decoder decoder0) {
            SpeechRecognizerStartParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechRecognizerStartParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.params = StartSpeechRecognitionRequestParams.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.params, 8, false);
        }
    }
}
