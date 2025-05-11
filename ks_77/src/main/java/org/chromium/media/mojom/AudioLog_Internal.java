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

class AudioLog_Internal {
    public static final Interface.Manager<AudioLog, AudioLog.Proxy> MANAGER = new Interface.Manager<AudioLog, AudioLog.Proxy>() {
        public String getName() {
            return "media.mojom.AudioLog";
        }

        public int getVersion() {
            return 0;
        }

        public AudioLog_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AudioLog_Internal.Proxy(core, messageReceiver);
        }

        public AudioLog_Internal.Stub buildStub(Core core, AudioLog impl) {
            return new AudioLog_Internal.Stub(core, impl);
        }

        public AudioLog[] buildArray(int size) {
            return new AudioLog[size];
        }
    };

    private static final int ON_CREATED_ORDINAL = 0;

    private static final int ON_STARTED_ORDINAL = 1;

    private static final int ON_STOPPED_ORDINAL = 2;

    private static final int ON_CLOSED_ORDINAL = 3;

    private static final int ON_ERROR_ORDINAL = 4;

    private static final int ON_SET_VOLUME_ORDINAL = 5;

    private static final int ON_PROCESSING_STATE_CHANGED_ORDINAL = 6;

    private static final int ON_LOG_MESSAGE_ORDINAL = 7;

    static final class Proxy extends Interface.AbstractProxy implements AudioLog.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onCreated(AudioParameters params, String deviceId) {
            AudioLog_Internal.AudioLogOnCreatedParams _message = new AudioLog_Internal.AudioLogOnCreatedParams();
            _message.params = params;
            _message.deviceId = deviceId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onStarted() {
            AudioLog_Internal.AudioLogOnStartedParams _message = new AudioLog_Internal.AudioLogOnStartedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void onStopped() {
            AudioLog_Internal.AudioLogOnStoppedParams _message = new AudioLog_Internal.AudioLogOnStoppedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void onClosed() {
            AudioLog_Internal.AudioLogOnClosedParams _message = new AudioLog_Internal.AudioLogOnClosedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void onError() {
            AudioLog_Internal.AudioLogOnErrorParams _message = new AudioLog_Internal.AudioLogOnErrorParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }

        public void onSetVolume(double volume) {
            AudioLog_Internal.AudioLogOnSetVolumeParams _message = new AudioLog_Internal.AudioLogOnSetVolumeParams();
            _message.volume = volume;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5)));
        }

        public void onProcessingStateChanged(String message) {
            AudioLog_Internal.AudioLogOnProcessingStateChangedParams _message = new AudioLog_Internal.AudioLogOnProcessingStateChangedParams();
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6)));
        }

        public void onLogMessage(String message) {
            AudioLog_Internal.AudioLogOnLogMessageParams _message = new AudioLog_Internal.AudioLogOnLogMessageParams();
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7)));
        }
    }

    static final class Stub extends Interface.Stub<AudioLog> {
        Stub(Core core, AudioLog impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AudioLog_Internal.AudioLogOnCreatedParams audioLogOnCreatedParams;
                AudioLog_Internal.AudioLogOnSetVolumeParams audioLogOnSetVolumeParams;
                AudioLog_Internal.AudioLogOnProcessingStateChangedParams audioLogOnProcessingStateChangedParams;
                AudioLog_Internal.AudioLogOnLogMessageParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioLog_Internal.MANAGER, messageWithHeader);
                    case 0:
                        audioLogOnCreatedParams = AudioLog_Internal.AudioLogOnCreatedParams.deserialize(messageWithHeader.getPayload());
                        ((AudioLog)getImpl()).onCreated(audioLogOnCreatedParams.params, audioLogOnCreatedParams.deviceId);
                        return true;
                    case 1:
                        AudioLog_Internal.AudioLogOnStartedParams.deserialize(messageWithHeader.getPayload());
                        ((AudioLog)getImpl()).onStarted();
                        return true;
                    case 2:
                        AudioLog_Internal.AudioLogOnStoppedParams.deserialize(messageWithHeader.getPayload());
                        ((AudioLog)getImpl()).onStopped();
                        return true;
                    case 3:
                        AudioLog_Internal.AudioLogOnClosedParams.deserialize(messageWithHeader.getPayload());
                        ((AudioLog)getImpl()).onClosed();
                        return true;
                    case 4:
                        AudioLog_Internal.AudioLogOnErrorParams.deserialize(messageWithHeader.getPayload());
                        ((AudioLog)getImpl()).onError();
                        return true;
                    case 5:
                        audioLogOnSetVolumeParams = AudioLog_Internal.AudioLogOnSetVolumeParams.deserialize(messageWithHeader.getPayload());
                        ((AudioLog)getImpl()).onSetVolume(audioLogOnSetVolumeParams.volume);
                        return true;
                    case 6:
                        audioLogOnProcessingStateChangedParams = AudioLog_Internal.AudioLogOnProcessingStateChangedParams.deserialize(messageWithHeader.getPayload());
                        ((AudioLog)getImpl()).onProcessingStateChanged(audioLogOnProcessingStateChangedParams.message);
                        return true;
                    case 7:
                        data = AudioLog_Internal.AudioLogOnLogMessageParams.deserialize(messageWithHeader.getPayload());
                        ((AudioLog)getImpl()).onLogMessage(data.message);
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
                                getCore(), AudioLog_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AudioLogOnCreatedParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AudioParameters params;

        public String deviceId;

        private AudioLogOnCreatedParams(int version) {
            super(24, version);
        }

        public AudioLogOnCreatedParams() {
            this(0);
        }

        public static AudioLogOnCreatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioLogOnCreatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioLogOnCreatedParams decode(Decoder decoder0) {
            AudioLogOnCreatedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnCreatedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.params = AudioParameters.decode(decoder1);
                result.deviceId = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.params, 8, false);
            encoder0.encode(this.deviceId, 16, false);
        }
    }

    static final class AudioLogOnStartedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioLogOnStartedParams(int version) {
            super(8, version);
        }

        public AudioLogOnStartedParams() {
            this(0);
        }

        public static AudioLogOnStartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioLogOnStartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioLogOnStartedParams decode(Decoder decoder0) {
            AudioLogOnStartedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnStartedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AudioLogOnStoppedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioLogOnStoppedParams(int version) {
            super(8, version);
        }

        public AudioLogOnStoppedParams() {
            this(0);
        }

        public static AudioLogOnStoppedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioLogOnStoppedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioLogOnStoppedParams decode(Decoder decoder0) {
            AudioLogOnStoppedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnStoppedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AudioLogOnClosedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioLogOnClosedParams(int version) {
            super(8, version);
        }

        public AudioLogOnClosedParams() {
            this(0);
        }

        public static AudioLogOnClosedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioLogOnClosedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioLogOnClosedParams decode(Decoder decoder0) {
            AudioLogOnClosedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnClosedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AudioLogOnErrorParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioLogOnErrorParams(int version) {
            super(8, version);
        }

        public AudioLogOnErrorParams() {
            this(0);
        }

        public static AudioLogOnErrorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioLogOnErrorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioLogOnErrorParams decode(Decoder decoder0) {
            AudioLogOnErrorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnErrorParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AudioLogOnSetVolumeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public double volume;

        private AudioLogOnSetVolumeParams(int version) {
            super(16, version);
        }

        public AudioLogOnSetVolumeParams() {
            this(0);
        }

        public static AudioLogOnSetVolumeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioLogOnSetVolumeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioLogOnSetVolumeParams decode(Decoder decoder0) {
            AudioLogOnSetVolumeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnSetVolumeParams(elementsOrVersion);
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

    static final class AudioLogOnProcessingStateChangedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String message;

        private AudioLogOnProcessingStateChangedParams(int version) {
            super(16, version);
        }

        public AudioLogOnProcessingStateChangedParams() {
            this(0);
        }

        public static AudioLogOnProcessingStateChangedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioLogOnProcessingStateChangedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioLogOnProcessingStateChangedParams decode(Decoder decoder0) {
            AudioLogOnProcessingStateChangedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnProcessingStateChangedParams(elementsOrVersion);
                result.message = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.message, 8, false);
        }
    }

    static final class AudioLogOnLogMessageParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String message;

        private AudioLogOnLogMessageParams(int version) {
            super(16, version);
        }

        public AudioLogOnLogMessageParams() {
            this(0);
        }

        public static AudioLogOnLogMessageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioLogOnLogMessageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioLogOnLogMessageParams decode(Decoder decoder0) {
            AudioLogOnLogMessageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnLogMessageParams(elementsOrVersion);
                result.message = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.message, 8, false);
        }
    }
}
