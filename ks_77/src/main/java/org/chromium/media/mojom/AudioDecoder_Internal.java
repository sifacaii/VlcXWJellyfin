package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

class AudioDecoder_Internal {
    public static final Interface.Manager<AudioDecoder, AudioDecoder.Proxy> MANAGER = new Interface.Manager<AudioDecoder, AudioDecoder.Proxy>() {
        public String getName() {
            return "media.mojom.AudioDecoder";
        }

        public int getVersion() {
            return 0;
        }

        public AudioDecoder_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new AudioDecoder_Internal.Proxy(core, messageReceiver);
        }

        public AudioDecoder_Internal.Stub buildStub(Core core, AudioDecoder impl) {
            return new AudioDecoder_Internal.Stub(core, impl);
        }

        public AudioDecoder[] buildArray(int size) {
            return new AudioDecoder[size];
        }
    };

    private static final int CONSTRUCT_ORDINAL = 0;

    private static final int INITIALIZE_ORDINAL = 1;

    private static final int SET_DATA_SOURCE_ORDINAL = 2;

    private static final int DECODE_ORDINAL = 3;

    private static final int RESET_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements AudioDecoder.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void construct(AssociatedInterfaceNotSupported client) {
            AudioDecoder_Internal.AudioDecoderConstructParams _message = new AudioDecoder_Internal.AudioDecoderConstructParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void initialize(AudioDecoderConfig config, int cdmId, AudioDecoder.InitializeResponse callback) {
            AudioDecoder_Internal.AudioDecoderInitializeParams _message = new AudioDecoder_Internal.AudioDecoderInitializeParams();
            _message.config = config;
            _message.cdmId = cdmId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new AudioDecoder_Internal.AudioDecoderInitializeResponseParamsForwardToCallback(callback));
        }

        public void setDataSource(DataPipe.ConsumerHandle receivePipe) {
            AudioDecoder_Internal.AudioDecoderSetDataSourceParams _message = new AudioDecoder_Internal.AudioDecoderSetDataSourceParams();
            _message.receivePipe = receivePipe;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void decode(DecoderBuffer buffer, AudioDecoder.DecodeResponse callback) {
            AudioDecoder_Internal.AudioDecoderDecodeParams _message = new AudioDecoder_Internal.AudioDecoderDecodeParams();
            _message.buffer = buffer;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new AudioDecoder_Internal.AudioDecoderDecodeResponseParamsForwardToCallback(callback));
        }

        public void reset(AudioDecoder.ResetResponse callback) {
            AudioDecoder_Internal.AudioDecoderResetParams _message = new AudioDecoder_Internal.AudioDecoderResetParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new AudioDecoder_Internal.AudioDecoderResetResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<AudioDecoder> {
        Stub(Core core, AudioDecoder impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                AudioDecoder_Internal.AudioDecoderConstructParams audioDecoderConstructParams;
                AudioDecoder_Internal.AudioDecoderSetDataSourceParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(AudioDecoder_Internal.MANAGER, messageWithHeader);
                    case 0:
                        audioDecoderConstructParams = AudioDecoder_Internal.AudioDecoderConstructParams.deserialize(messageWithHeader.getPayload());
                        ((AudioDecoder)getImpl()).construct(audioDecoderConstructParams.client);
                        return true;
                    case 2:
                        data = AudioDecoder_Internal.AudioDecoderSetDataSourceParams.deserialize(messageWithHeader.getPayload());
                        ((AudioDecoder)getImpl()).setDataSource(data.receivePipe);
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
                AudioDecoder_Internal.AudioDecoderInitializeParams audioDecoderInitializeParams;
                AudioDecoder_Internal.AudioDecoderDecodeParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), AudioDecoder_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        audioDecoderInitializeParams = AudioDecoder_Internal.AudioDecoderInitializeParams.deserialize(messageWithHeader.getPayload());
                        ((AudioDecoder)getImpl()).initialize(audioDecoderInitializeParams.config, audioDecoderInitializeParams.cdmId, new AudioDecoder_Internal.AudioDecoderInitializeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        data = AudioDecoder_Internal.AudioDecoderDecodeParams.deserialize(messageWithHeader.getPayload());
                        ((AudioDecoder)getImpl()).decode(data.buffer, new AudioDecoder_Internal.AudioDecoderDecodeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        AudioDecoder_Internal.AudioDecoderResetParams.deserialize(messageWithHeader.getPayload());
                        ((AudioDecoder)getImpl()).reset(new AudioDecoder_Internal.AudioDecoderResetResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class AudioDecoderConstructParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported client;

        private AudioDecoderConstructParams(int version) {
            super(16, version);
        }

        public AudioDecoderConstructParams() {
            this(0);
        }

        public static AudioDecoderConstructParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioDecoderConstructParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioDecoderConstructParams decode(Decoder decoder0) {
            AudioDecoderConstructParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioDecoderConstructParams(elementsOrVersion);
                result.client = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.client, 8, false);
        }
    }

    static final class AudioDecoderInitializeParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AudioDecoderConfig config;

        public int cdmId;

        private AudioDecoderInitializeParams(int version) {
            super(24, version);
        }

        public AudioDecoderInitializeParams() {
            this(0);
        }

        public static AudioDecoderInitializeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioDecoderInitializeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioDecoderInitializeParams decode(Decoder decoder0) {
            AudioDecoderInitializeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioDecoderInitializeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.config = AudioDecoderConfig.decode(decoder1);
                result.cdmId = decoder0.readInt(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.config, 8, false);
            encoder0.encode(this.cdmId, 16);
        }
    }

    static final class AudioDecoderInitializeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        public boolean needsBitstreamConversion;

        private AudioDecoderInitializeResponseParams(int version) {
            super(16, version);
        }

        public AudioDecoderInitializeResponseParams() {
            this(0);
        }

        public static AudioDecoderInitializeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioDecoderInitializeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioDecoderInitializeResponseParams decode(Decoder decoder0) {
            AudioDecoderInitializeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioDecoderInitializeResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                result.needsBitstreamConversion = decoder0.readBoolean(8, 1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
            encoder0.encode(this.needsBitstreamConversion, 8, 1);
        }
    }

    static class AudioDecoderInitializeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AudioDecoder.InitializeResponse mCallback;

        AudioDecoderInitializeResponseParamsForwardToCallback(AudioDecoder.InitializeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                AudioDecoder_Internal.AudioDecoderInitializeResponseParams response = AudioDecoder_Internal.AudioDecoderInitializeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), Boolean.valueOf(response.needsBitstreamConversion));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class AudioDecoderInitializeResponseParamsProxyToResponder implements AudioDecoder.InitializeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        AudioDecoderInitializeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success, Boolean needsBitstreamConversion) {
            AudioDecoder_Internal.AudioDecoderInitializeResponseParams _response = new AudioDecoder_Internal.AudioDecoderInitializeResponseParams();
            _response.success = success.booleanValue();
            _response.needsBitstreamConversion = needsBitstreamConversion.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class AudioDecoderSetDataSourceParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DataPipe.ConsumerHandle receivePipe;

        private AudioDecoderSetDataSourceParams(int version) {
            super(16, version);
            this.receivePipe = (DataPipe.ConsumerHandle)InvalidHandle.INSTANCE;
        }

        public AudioDecoderSetDataSourceParams() {
            this(0);
        }

        public static AudioDecoderSetDataSourceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioDecoderSetDataSourceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioDecoderSetDataSourceParams decode(Decoder decoder0) {
            AudioDecoderSetDataSourceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioDecoderSetDataSourceParams(elementsOrVersion);
                result.receivePipe = decoder0.readConsumerHandle(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Handle)this.receivePipe, 8, false);
        }
    }

    static final class AudioDecoderDecodeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DecoderBuffer buffer;

        private AudioDecoderDecodeParams(int version) {
            super(16, version);
        }

        public AudioDecoderDecodeParams() {
            this(0);
        }

        public static AudioDecoderDecodeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioDecoderDecodeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioDecoderDecodeParams decode(Decoder decoder0) {
            AudioDecoderDecodeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioDecoderDecodeParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.buffer = DecoderBuffer.decode(decoder1);
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

    static final class AudioDecoderDecodeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private AudioDecoderDecodeResponseParams(int version) {
            super(16, version);
        }

        public AudioDecoderDecodeResponseParams() {
            this(0);
        }

        public static AudioDecoderDecodeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioDecoderDecodeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioDecoderDecodeResponseParams decode(Decoder decoder0) {
            AudioDecoderDecodeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioDecoderDecodeResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                DecodeStatus.validate(result.status);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
        }
    }

    static class AudioDecoderDecodeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AudioDecoder.DecodeResponse mCallback;

        AudioDecoderDecodeResponseParamsForwardToCallback(AudioDecoder.DecodeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                AudioDecoder_Internal.AudioDecoderDecodeResponseParams response = AudioDecoder_Internal.AudioDecoderDecodeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class AudioDecoderDecodeResponseParamsProxyToResponder implements AudioDecoder.DecodeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        AudioDecoderDecodeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            AudioDecoder_Internal.AudioDecoderDecodeResponseParams _response = new AudioDecoder_Internal.AudioDecoderDecodeResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class AudioDecoderResetParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioDecoderResetParams(int version) {
            super(8, version);
        }

        public AudioDecoderResetParams() {
            this(0);
        }

        public static AudioDecoderResetParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioDecoderResetParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioDecoderResetParams decode(Decoder decoder0) {
            AudioDecoderResetParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioDecoderResetParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class AudioDecoderResetResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioDecoderResetResponseParams(int version) {
            super(8, version);
        }

        public AudioDecoderResetResponseParams() {
            this(0);
        }

        public static AudioDecoderResetResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static AudioDecoderResetResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static AudioDecoderResetResponseParams decode(Decoder decoder0) {
            AudioDecoderResetResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioDecoderResetResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class AudioDecoderResetResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final AudioDecoder.ResetResponse mCallback;

        AudioDecoderResetResponseParamsForwardToCallback(AudioDecoder.ResetResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class AudioDecoderResetResponseParamsProxyToResponder implements AudioDecoder.ResetResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        AudioDecoderResetResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            AudioDecoder_Internal.AudioDecoderResetResponseParams _response = new AudioDecoder_Internal.AudioDecoderResetResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
