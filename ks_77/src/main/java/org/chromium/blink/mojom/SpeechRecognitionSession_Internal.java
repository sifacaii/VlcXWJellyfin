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

class SpeechRecognitionSession_Internal {
    public static final Interface.Manager<SpeechRecognitionSession, SpeechRecognitionSession.Proxy> MANAGER = new Interface.Manager<SpeechRecognitionSession, SpeechRecognitionSession.Proxy>() {
        public String getName() {
            return "blink.mojom.SpeechRecognitionSession";
        }

        public int getVersion() {
            return 0;
        }

        public SpeechRecognitionSession_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SpeechRecognitionSession_Internal.Proxy(core, messageReceiver);
        }

        public SpeechRecognitionSession_Internal.Stub buildStub(Core core, SpeechRecognitionSession impl) {
            return new SpeechRecognitionSession_Internal.Stub(core, impl);
        }

        public SpeechRecognitionSession[] buildArray(int size) {
            return new SpeechRecognitionSession[size];
        }
    };

    private static final int ABORT_ORDINAL = 0;

    private static final int STOP_CAPTURE_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements SpeechRecognitionSession.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void abort() {
            SpeechRecognitionSession_Internal.SpeechRecognitionSessionAbortParams _message = new SpeechRecognitionSession_Internal.SpeechRecognitionSessionAbortParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void stopCapture() {
            SpeechRecognitionSession_Internal.SpeechRecognitionSessionStopCaptureParams _message = new SpeechRecognitionSession_Internal.SpeechRecognitionSessionStopCaptureParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<SpeechRecognitionSession> {
        Stub(Core core, SpeechRecognitionSession impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SpeechRecognitionSession_Internal.MANAGER, messageWithHeader);
                    case 0:
                        SpeechRecognitionSession_Internal.SpeechRecognitionSessionAbortParams.deserialize(messageWithHeader.getPayload());
                        ((SpeechRecognitionSession)getImpl()).abort();
                        return true;
                    case 1:
                        SpeechRecognitionSession_Internal.SpeechRecognitionSessionStopCaptureParams.deserialize(messageWithHeader.getPayload());
                        ((SpeechRecognitionSession)getImpl()).stopCapture();
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
                                getCore(), SpeechRecognitionSession_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SpeechRecognitionSessionAbortParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SpeechRecognitionSessionAbortParams(int version) {
            super(8, version);
        }

        public SpeechRecognitionSessionAbortParams() {
            this(0);
        }

        public static SpeechRecognitionSessionAbortParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SpeechRecognitionSessionAbortParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SpeechRecognitionSessionAbortParams decode(Decoder decoder0) {
            SpeechRecognitionSessionAbortParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechRecognitionSessionAbortParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SpeechRecognitionSessionStopCaptureParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SpeechRecognitionSessionStopCaptureParams(int version) {
            super(8, version);
        }

        public SpeechRecognitionSessionStopCaptureParams() {
            this(0);
        }

        public static SpeechRecognitionSessionStopCaptureParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SpeechRecognitionSessionStopCaptureParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SpeechRecognitionSessionStopCaptureParams decode(Decoder decoder0) {
            SpeechRecognitionSessionStopCaptureParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechRecognitionSessionStopCaptureParams(elementsOrVersion);
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
