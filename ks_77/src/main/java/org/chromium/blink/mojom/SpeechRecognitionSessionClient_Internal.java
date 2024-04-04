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

class SpeechRecognitionSessionClient_Internal {
    public static final Interface.Manager<SpeechRecognitionSessionClient, SpeechRecognitionSessionClient.Proxy> MANAGER = new Interface.Manager<SpeechRecognitionSessionClient, SpeechRecognitionSessionClient.Proxy>() {
        public String getName() {
            return "blink.mojom.SpeechRecognitionSessionClient";
        }

        public int getVersion() {
            return 0;
        }

        public SpeechRecognitionSessionClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SpeechRecognitionSessionClient_Internal.Proxy(core, messageReceiver);
        }

        public SpeechRecognitionSessionClient_Internal.Stub buildStub(Core core, SpeechRecognitionSessionClient impl) {
            return new SpeechRecognitionSessionClient_Internal.Stub(core, impl);
        }

        public SpeechRecognitionSessionClient[] buildArray(int size) {
            return new SpeechRecognitionSessionClient[size];
        }
    };

    private static final int RESULT_RETRIEVED_ORDINAL = 0;

    private static final int ERROR_OCCURRED_ORDINAL = 1;

    private static final int STARTED_ORDINAL = 2;

    private static final int AUDIO_STARTED_ORDINAL = 3;

    private static final int SOUND_STARTED_ORDINAL = 4;

    private static final int SOUND_ENDED_ORDINAL = 5;

    private static final int AUDIO_ENDED_ORDINAL = 6;

    private static final int ENDED_ORDINAL = 7;

    static final class Proxy extends Interface.AbstractProxy implements SpeechRecognitionSessionClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void resultRetrieved(SpeechRecognitionResult[] results) {
            SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientResultRetrievedParams _message = new SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientResultRetrievedParams();
            _message.results = results;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void errorOccurred(SpeechRecognitionError error) {
            SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientErrorOccurredParams _message = new SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientErrorOccurredParams();
            _message.error = error;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void started() {
            SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientStartedParams _message = new SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientStartedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void audioStarted() {
            SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientAudioStartedParams _message = new SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientAudioStartedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void soundStarted() {
            SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientSoundStartedParams _message = new SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientSoundStartedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }

        public void soundEnded() {
            SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientSoundEndedParams _message = new SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientSoundEndedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5)));
        }

        public void audioEnded() {
            SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientAudioEndedParams _message = new SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientAudioEndedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6)));
        }

        public void ended() {
            SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientEndedParams _message = new SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientEndedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7)));
        }
    }

    static final class Stub extends Interface.Stub<SpeechRecognitionSessionClient> {
        Stub(Core core, SpeechRecognitionSessionClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientResultRetrievedParams speechRecognitionSessionClientResultRetrievedParams;
                SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientErrorOccurredParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SpeechRecognitionSessionClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        speechRecognitionSessionClientResultRetrievedParams = SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientResultRetrievedParams.deserialize(messageWithHeader.getPayload());
                        ((SpeechRecognitionSessionClient)getImpl()).resultRetrieved(speechRecognitionSessionClientResultRetrievedParams.results);
                        return true;
                    case 1:
                        data = SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientErrorOccurredParams.deserialize(messageWithHeader.getPayload());
                        ((SpeechRecognitionSessionClient)getImpl()).errorOccurred(data.error);
                        return true;
                    case 2:
                        SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientStartedParams.deserialize(messageWithHeader.getPayload());
                        ((SpeechRecognitionSessionClient)getImpl()).started();
                        return true;
                    case 3:
                        SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientAudioStartedParams.deserialize(messageWithHeader.getPayload());
                        ((SpeechRecognitionSessionClient)getImpl()).audioStarted();
                        return true;
                    case 4:
                        SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientSoundStartedParams.deserialize(messageWithHeader.getPayload());
                        ((SpeechRecognitionSessionClient)getImpl()).soundStarted();
                        return true;
                    case 5:
                        SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientSoundEndedParams.deserialize(messageWithHeader.getPayload());
                        ((SpeechRecognitionSessionClient)getImpl()).soundEnded();
                        return true;
                    case 6:
                        SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientAudioEndedParams.deserialize(messageWithHeader.getPayload());
                        ((SpeechRecognitionSessionClient)getImpl()).audioEnded();
                        return true;
                    case 7:
                        SpeechRecognitionSessionClient_Internal.SpeechRecognitionSessionClientEndedParams.deserialize(messageWithHeader.getPayload());
                        ((SpeechRecognitionSessionClient)getImpl()).ended();
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
                                getCore(), SpeechRecognitionSessionClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SpeechRecognitionSessionClientResultRetrievedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SpeechRecognitionResult[] results;

        private SpeechRecognitionSessionClientResultRetrievedParams(int version) {
            super(16, version);
        }

        public SpeechRecognitionSessionClientResultRetrievedParams() {
            this(0);
        }

        public static SpeechRecognitionSessionClientResultRetrievedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SpeechRecognitionSessionClientResultRetrievedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SpeechRecognitionSessionClientResultRetrievedParams decode(Decoder decoder0) {
            SpeechRecognitionSessionClientResultRetrievedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechRecognitionSessionClientResultRetrievedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.results = new SpeechRecognitionResult[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.results[i1] = SpeechRecognitionResult.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.results == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.results.length, 8, -1);
                for (int i0 = 0; i0 < this.results.length; i0++)
                    encoder1.encode(this.results[i0], 8 + 8 * i0, false);
            }
        }
    }

    static final class SpeechRecognitionSessionClientErrorOccurredParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SpeechRecognitionError error;

        private SpeechRecognitionSessionClientErrorOccurredParams(int version) {
            super(16, version);
        }

        public SpeechRecognitionSessionClientErrorOccurredParams() {
            this(0);
        }

        public static SpeechRecognitionSessionClientErrorOccurredParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SpeechRecognitionSessionClientErrorOccurredParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SpeechRecognitionSessionClientErrorOccurredParams decode(Decoder decoder0) {
            SpeechRecognitionSessionClientErrorOccurredParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechRecognitionSessionClientErrorOccurredParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.error = SpeechRecognitionError.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8, false);
        }
    }

    static final class SpeechRecognitionSessionClientStartedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SpeechRecognitionSessionClientStartedParams(int version) {
            super(8, version);
        }

        public SpeechRecognitionSessionClientStartedParams() {
            this(0);
        }

        public static SpeechRecognitionSessionClientStartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SpeechRecognitionSessionClientStartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SpeechRecognitionSessionClientStartedParams decode(Decoder decoder0) {
            SpeechRecognitionSessionClientStartedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechRecognitionSessionClientStartedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SpeechRecognitionSessionClientAudioStartedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SpeechRecognitionSessionClientAudioStartedParams(int version) {
            super(8, version);
        }

        public SpeechRecognitionSessionClientAudioStartedParams() {
            this(0);
        }

        public static SpeechRecognitionSessionClientAudioStartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SpeechRecognitionSessionClientAudioStartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SpeechRecognitionSessionClientAudioStartedParams decode(Decoder decoder0) {
            SpeechRecognitionSessionClientAudioStartedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechRecognitionSessionClientAudioStartedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SpeechRecognitionSessionClientSoundStartedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SpeechRecognitionSessionClientSoundStartedParams(int version) {
            super(8, version);
        }

        public SpeechRecognitionSessionClientSoundStartedParams() {
            this(0);
        }

        public static SpeechRecognitionSessionClientSoundStartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SpeechRecognitionSessionClientSoundStartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SpeechRecognitionSessionClientSoundStartedParams decode(Decoder decoder0) {
            SpeechRecognitionSessionClientSoundStartedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechRecognitionSessionClientSoundStartedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SpeechRecognitionSessionClientSoundEndedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SpeechRecognitionSessionClientSoundEndedParams(int version) {
            super(8, version);
        }

        public SpeechRecognitionSessionClientSoundEndedParams() {
            this(0);
        }

        public static SpeechRecognitionSessionClientSoundEndedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SpeechRecognitionSessionClientSoundEndedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SpeechRecognitionSessionClientSoundEndedParams decode(Decoder decoder0) {
            SpeechRecognitionSessionClientSoundEndedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechRecognitionSessionClientSoundEndedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SpeechRecognitionSessionClientAudioEndedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SpeechRecognitionSessionClientAudioEndedParams(int version) {
            super(8, version);
        }

        public SpeechRecognitionSessionClientAudioEndedParams() {
            this(0);
        }

        public static SpeechRecognitionSessionClientAudioEndedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SpeechRecognitionSessionClientAudioEndedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SpeechRecognitionSessionClientAudioEndedParams decode(Decoder decoder0) {
            SpeechRecognitionSessionClientAudioEndedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechRecognitionSessionClientAudioEndedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class SpeechRecognitionSessionClientEndedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private SpeechRecognitionSessionClientEndedParams(int version) {
            super(8, version);
        }

        public SpeechRecognitionSessionClientEndedParams() {
            this(0);
        }

        public static SpeechRecognitionSessionClientEndedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SpeechRecognitionSessionClientEndedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SpeechRecognitionSessionClientEndedParams decode(Decoder decoder0) {
            SpeechRecognitionSessionClientEndedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SpeechRecognitionSessionClientEndedParams(elementsOrVersion);
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
