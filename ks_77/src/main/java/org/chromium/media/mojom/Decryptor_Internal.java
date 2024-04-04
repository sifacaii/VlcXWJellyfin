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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

class Decryptor_Internal {
    public static final Interface.Manager<Decryptor, Decryptor.Proxy> MANAGER = new Interface.Manager<Decryptor, Decryptor.Proxy>() {
        public String getName() {
            return "media.mojom.Decryptor";
        }

        public int getVersion() {
            return 0;
        }

        public Decryptor_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Decryptor_Internal.Proxy(core, messageReceiver);
        }

        public Decryptor_Internal.Stub buildStub(Core core, Decryptor impl) {
            return new Decryptor_Internal.Stub(core, impl);
        }

        public Decryptor[] buildArray(int size) {
            return new Decryptor[size];
        }
    };

    private static final int INITIALIZE_ORDINAL = 0;

    private static final int DECRYPT_ORDINAL = 1;

    private static final int CANCEL_DECRYPT_ORDINAL = 2;

    private static final int INITIALIZE_AUDIO_DECODER_ORDINAL = 3;

    private static final int INITIALIZE_VIDEO_DECODER_ORDINAL = 4;

    private static final int DECRYPT_AND_DECODE_AUDIO_ORDINAL = 5;

    private static final int DECRYPT_AND_DECODE_VIDEO_ORDINAL = 6;

    private static final int RESET_DECODER_ORDINAL = 7;

    private static final int DEINITIALIZE_DECODER_ORDINAL = 8;

    static final class Proxy extends Interface.AbstractProxy implements Decryptor.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void initialize(DataPipe.ConsumerHandle audioPipe, DataPipe.ConsumerHandle videoPipe, DataPipe.ConsumerHandle decryptPipe, DataPipe.ProducerHandle decryptedPipe) {
            Decryptor_Internal.DecryptorInitializeParams _message = new Decryptor_Internal.DecryptorInitializeParams();
            _message.audioPipe = audioPipe;
            _message.videoPipe = videoPipe;
            _message.decryptPipe = decryptPipe;
            _message.decryptedPipe = decryptedPipe;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void decrypt(int streamType, DecoderBuffer encrypted, Decryptor.DecryptResponse callback) {
            Decryptor_Internal.DecryptorDecryptParams _message = new Decryptor_Internal.DecryptorDecryptParams();
            _message.streamType = streamType;
            _message.encrypted = encrypted;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new Decryptor_Internal.DecryptorDecryptResponseParamsForwardToCallback(callback));
        }

        public void cancelDecrypt(int streamType) {
            Decryptor_Internal.DecryptorCancelDecryptParams _message = new Decryptor_Internal.DecryptorCancelDecryptParams();
            _message.streamType = streamType;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void initializeAudioDecoder(AudioDecoderConfig config, Decryptor.InitializeAudioDecoderResponse callback) {
            Decryptor_Internal.DecryptorInitializeAudioDecoderParams _message = new Decryptor_Internal.DecryptorInitializeAudioDecoderParams();
            _message.config = config;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new Decryptor_Internal.DecryptorInitializeAudioDecoderResponseParamsForwardToCallback(callback));
        }

        public void initializeVideoDecoder(VideoDecoderConfig config, Decryptor.InitializeVideoDecoderResponse callback) {
            Decryptor_Internal.DecryptorInitializeVideoDecoderParams _message = new Decryptor_Internal.DecryptorInitializeVideoDecoderParams();
            _message.config = config;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new Decryptor_Internal.DecryptorInitializeVideoDecoderResponseParamsForwardToCallback(callback));
        }

        public void decryptAndDecodeAudio(DecoderBuffer encrypted, Decryptor.DecryptAndDecodeAudioResponse callback) {
            Decryptor_Internal.DecryptorDecryptAndDecodeAudioParams _message = new Decryptor_Internal.DecryptorDecryptAndDecodeAudioParams();
            _message.encrypted = encrypted;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new Decryptor_Internal.DecryptorDecryptAndDecodeAudioResponseParamsForwardToCallback(callback));
        }

        public void decryptAndDecodeVideo(DecoderBuffer encrypted, Decryptor.DecryptAndDecodeVideoResponse callback) {
            Decryptor_Internal.DecryptorDecryptAndDecodeVideoParams _message = new Decryptor_Internal.DecryptorDecryptAndDecodeVideoParams();
            _message.encrypted = encrypted;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new Decryptor_Internal.DecryptorDecryptAndDecodeVideoResponseParamsForwardToCallback(callback));
        }

        public void resetDecoder(int streamType) {
            Decryptor_Internal.DecryptorResetDecoderParams _message = new Decryptor_Internal.DecryptorResetDecoderParams();
            _message.streamType = streamType;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7)));
        }

        public void deinitializeDecoder(int streamType) {
            Decryptor_Internal.DecryptorDeinitializeDecoderParams _message = new Decryptor_Internal.DecryptorDeinitializeDecoderParams();
            _message.streamType = streamType;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8)));
        }
    }

    static final class Stub extends Interface.Stub<Decryptor> {
        Stub(Core core, Decryptor impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                Decryptor_Internal.DecryptorInitializeParams decryptorInitializeParams;
                Decryptor_Internal.DecryptorCancelDecryptParams decryptorCancelDecryptParams;
                Decryptor_Internal.DecryptorResetDecoderParams decryptorResetDecoderParams;
                Decryptor_Internal.DecryptorDeinitializeDecoderParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Decryptor_Internal.MANAGER, messageWithHeader);
                    case 0:
                        decryptorInitializeParams = Decryptor_Internal.DecryptorInitializeParams.deserialize(messageWithHeader.getPayload());
                        ((Decryptor)getImpl()).initialize(decryptorInitializeParams.audioPipe, decryptorInitializeParams.videoPipe, decryptorInitializeParams.decryptPipe, decryptorInitializeParams.decryptedPipe);
                        return true;
                    case 2:
                        decryptorCancelDecryptParams = Decryptor_Internal.DecryptorCancelDecryptParams.deserialize(messageWithHeader.getPayload());
                        ((Decryptor)getImpl()).cancelDecrypt(decryptorCancelDecryptParams.streamType);
                        return true;
                    case 7:
                        decryptorResetDecoderParams = Decryptor_Internal.DecryptorResetDecoderParams.deserialize(messageWithHeader.getPayload());
                        ((Decryptor)getImpl()).resetDecoder(decryptorResetDecoderParams.streamType);
                        return true;
                    case 8:
                        data = Decryptor_Internal.DecryptorDeinitializeDecoderParams.deserialize(messageWithHeader.getPayload());
                        ((Decryptor)getImpl()).deinitializeDecoder(data.streamType);
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
                Decryptor_Internal.DecryptorDecryptParams decryptorDecryptParams;
                Decryptor_Internal.DecryptorInitializeAudioDecoderParams decryptorInitializeAudioDecoderParams;
                Decryptor_Internal.DecryptorInitializeVideoDecoderParams decryptorInitializeVideoDecoderParams;
                Decryptor_Internal.DecryptorDecryptAndDecodeAudioParams decryptorDecryptAndDecodeAudioParams;
                Decryptor_Internal.DecryptorDecryptAndDecodeVideoParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), Decryptor_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        decryptorDecryptParams = Decryptor_Internal.DecryptorDecryptParams.deserialize(messageWithHeader.getPayload());
                        ((Decryptor)getImpl()).decrypt(decryptorDecryptParams.streamType, decryptorDecryptParams.encrypted, new Decryptor_Internal.DecryptorDecryptResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        decryptorInitializeAudioDecoderParams = Decryptor_Internal.DecryptorInitializeAudioDecoderParams.deserialize(messageWithHeader.getPayload());
                        ((Decryptor)getImpl()).initializeAudioDecoder(decryptorInitializeAudioDecoderParams.config, new Decryptor_Internal.DecryptorInitializeAudioDecoderResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        decryptorInitializeVideoDecoderParams = Decryptor_Internal.DecryptorInitializeVideoDecoderParams.deserialize(messageWithHeader.getPayload());
                        ((Decryptor)getImpl()).initializeVideoDecoder(decryptorInitializeVideoDecoderParams.config, new Decryptor_Internal.DecryptorInitializeVideoDecoderResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        decryptorDecryptAndDecodeAudioParams = Decryptor_Internal.DecryptorDecryptAndDecodeAudioParams.deserialize(messageWithHeader.getPayload());
                        ((Decryptor)getImpl()).decryptAndDecodeAudio(decryptorDecryptAndDecodeAudioParams.encrypted, new Decryptor_Internal.DecryptorDecryptAndDecodeAudioResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        data = Decryptor_Internal.DecryptorDecryptAndDecodeVideoParams.deserialize(messageWithHeader.getPayload());
                        ((Decryptor)getImpl()).decryptAndDecodeVideo(data.encrypted, new Decryptor_Internal.DecryptorDecryptAndDecodeVideoResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class DecryptorInitializeParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DataPipe.ConsumerHandle audioPipe;

        public DataPipe.ConsumerHandle videoPipe;

        public DataPipe.ConsumerHandle decryptPipe;

        public DataPipe.ProducerHandle decryptedPipe;

        private DecryptorInitializeParams(int version) {
            super(24, version);
            this.audioPipe = (DataPipe.ConsumerHandle)InvalidHandle.INSTANCE;
            this.videoPipe = (DataPipe.ConsumerHandle)InvalidHandle.INSTANCE;
            this.decryptPipe = (DataPipe.ConsumerHandle)InvalidHandle.INSTANCE;
            this.decryptedPipe = (DataPipe.ProducerHandle)InvalidHandle.INSTANCE;
        }

        public DecryptorInitializeParams() {
            this(0);
        }

        public static DecryptorInitializeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorInitializeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorInitializeParams decode(Decoder decoder0) {
            DecryptorInitializeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorInitializeParams(elementsOrVersion);
                result.audioPipe = decoder0.readConsumerHandle(8, false);
                result.videoPipe = decoder0.readConsumerHandle(12, false);
                result.decryptPipe = decoder0.readConsumerHandle(16, false);
                result.decryptedPipe = decoder0.readProducerHandle(20, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Handle)this.audioPipe, 8, false);
            encoder0.encode((Handle)this.videoPipe, 12, false);
            encoder0.encode((Handle)this.decryptPipe, 16, false);
            encoder0.encode((Handle)this.decryptedPipe, 20, false);
        }
    }

    static final class DecryptorDecryptParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int streamType;

        public DecoderBuffer encrypted;

        private DecryptorDecryptParams(int version) {
            super(24, version);
        }

        public DecryptorDecryptParams() {
            this(0);
        }

        public static DecryptorDecryptParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorDecryptParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorDecryptParams decode(Decoder decoder0) {
            DecryptorDecryptParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorDecryptParams(elementsOrVersion);
                result.streamType = decoder0.readInt(8);
                Decryptor.StreamType.validate(result.streamType);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.encrypted = DecoderBuffer.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.streamType, 8);
            encoder0.encode(this.encrypted, 16, false);
        }
    }

    static final class DecryptorDecryptResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public DecoderBuffer buffer;

        private DecryptorDecryptResponseParams(int version) {
            super(24, version);
        }

        public DecryptorDecryptResponseParams() {
            this(0);
        }

        public static DecryptorDecryptResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorDecryptResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorDecryptResponseParams decode(Decoder decoder0) {
            DecryptorDecryptResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorDecryptResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                Decryptor.Status.validate(result.status);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.buffer = DecoderBuffer.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.buffer, 16, true);
        }
    }

    static class DecryptorDecryptResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Decryptor.DecryptResponse mCallback;

        DecryptorDecryptResponseParamsForwardToCallback(Decryptor.DecryptResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                Decryptor_Internal.DecryptorDecryptResponseParams response = Decryptor_Internal.DecryptorDecryptResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.buffer);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class DecryptorDecryptResponseParamsProxyToResponder implements Decryptor.DecryptResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        DecryptorDecryptResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, DecoderBuffer buffer) {
            Decryptor_Internal.DecryptorDecryptResponseParams _response = new Decryptor_Internal.DecryptorDecryptResponseParams();
            _response.status = status.intValue();
            _response.buffer = buffer;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class DecryptorCancelDecryptParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int streamType;

        private DecryptorCancelDecryptParams(int version) {
            super(16, version);
        }

        public DecryptorCancelDecryptParams() {
            this(0);
        }

        public static DecryptorCancelDecryptParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorCancelDecryptParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorCancelDecryptParams decode(Decoder decoder0) {
            DecryptorCancelDecryptParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorCancelDecryptParams(elementsOrVersion);
                result.streamType = decoder0.readInt(8);
                Decryptor.StreamType.validate(result.streamType);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.streamType, 8);
        }
    }

    static final class DecryptorInitializeAudioDecoderParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AudioDecoderConfig config;

        private DecryptorInitializeAudioDecoderParams(int version) {
            super(16, version);
        }

        public DecryptorInitializeAudioDecoderParams() {
            this(0);
        }

        public static DecryptorInitializeAudioDecoderParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorInitializeAudioDecoderParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorInitializeAudioDecoderParams decode(Decoder decoder0) {
            DecryptorInitializeAudioDecoderParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorInitializeAudioDecoderParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.config = AudioDecoderConfig.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.config, 8, false);
        }
    }

    static final class DecryptorInitializeAudioDecoderResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private DecryptorInitializeAudioDecoderResponseParams(int version) {
            super(16, version);
        }

        public DecryptorInitializeAudioDecoderResponseParams() {
            this(0);
        }

        public static DecryptorInitializeAudioDecoderResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorInitializeAudioDecoderResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorInitializeAudioDecoderResponseParams decode(Decoder decoder0) {
            DecryptorInitializeAudioDecoderResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorInitializeAudioDecoderResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class DecryptorInitializeAudioDecoderResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Decryptor.InitializeAudioDecoderResponse mCallback;

        DecryptorInitializeAudioDecoderResponseParamsForwardToCallback(Decryptor.InitializeAudioDecoderResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                Decryptor_Internal.DecryptorInitializeAudioDecoderResponseParams response = Decryptor_Internal.DecryptorInitializeAudioDecoderResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class DecryptorInitializeAudioDecoderResponseParamsProxyToResponder implements Decryptor.InitializeAudioDecoderResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        DecryptorInitializeAudioDecoderResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            Decryptor_Internal.DecryptorInitializeAudioDecoderResponseParams _response = new Decryptor_Internal.DecryptorInitializeAudioDecoderResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class DecryptorInitializeVideoDecoderParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public VideoDecoderConfig config;

        private DecryptorInitializeVideoDecoderParams(int version) {
            super(16, version);
        }

        public DecryptorInitializeVideoDecoderParams() {
            this(0);
        }

        public static DecryptorInitializeVideoDecoderParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorInitializeVideoDecoderParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorInitializeVideoDecoderParams decode(Decoder decoder0) {
            DecryptorInitializeVideoDecoderParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorInitializeVideoDecoderParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.config = VideoDecoderConfig.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.config, 8, false);
        }
    }

    static final class DecryptorInitializeVideoDecoderResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private DecryptorInitializeVideoDecoderResponseParams(int version) {
            super(16, version);
        }

        public DecryptorInitializeVideoDecoderResponseParams() {
            this(0);
        }

        public static DecryptorInitializeVideoDecoderResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorInitializeVideoDecoderResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorInitializeVideoDecoderResponseParams decode(Decoder decoder0) {
            DecryptorInitializeVideoDecoderResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorInitializeVideoDecoderResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class DecryptorInitializeVideoDecoderResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Decryptor.InitializeVideoDecoderResponse mCallback;

        DecryptorInitializeVideoDecoderResponseParamsForwardToCallback(Decryptor.InitializeVideoDecoderResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                Decryptor_Internal.DecryptorInitializeVideoDecoderResponseParams response = Decryptor_Internal.DecryptorInitializeVideoDecoderResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class DecryptorInitializeVideoDecoderResponseParamsProxyToResponder implements Decryptor.InitializeVideoDecoderResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        DecryptorInitializeVideoDecoderResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            Decryptor_Internal.DecryptorInitializeVideoDecoderResponseParams _response = new Decryptor_Internal.DecryptorInitializeVideoDecoderResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class DecryptorDecryptAndDecodeAudioParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DecoderBuffer encrypted;

        private DecryptorDecryptAndDecodeAudioParams(int version) {
            super(16, version);
        }

        public DecryptorDecryptAndDecodeAudioParams() {
            this(0);
        }

        public static DecryptorDecryptAndDecodeAudioParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorDecryptAndDecodeAudioParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorDecryptAndDecodeAudioParams decode(Decoder decoder0) {
            DecryptorDecryptAndDecodeAudioParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorDecryptAndDecodeAudioParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.encrypted = DecoderBuffer.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.encrypted, 8, false);
        }
    }

    static final class DecryptorDecryptAndDecodeAudioResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public AudioBuffer[] audioBuffers;

        private DecryptorDecryptAndDecodeAudioResponseParams(int version) {
            super(24, version);
        }

        public DecryptorDecryptAndDecodeAudioResponseParams() {
            this(0);
        }

        public static DecryptorDecryptAndDecodeAudioResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorDecryptAndDecodeAudioResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorDecryptAndDecodeAudioResponseParams decode(Decoder decoder0) {
            DecryptorDecryptAndDecodeAudioResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorDecryptAndDecodeAudioResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                Decryptor.Status.validate(result.status);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.audioBuffers = new AudioBuffer[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.audioBuffers[i1] = AudioBuffer.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            if (this.audioBuffers == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.audioBuffers.length, 16, -1);
                for (int i0 = 0; i0 < this.audioBuffers.length; i0++)
                    encoder1.encode(this.audioBuffers[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class DecryptorDecryptAndDecodeAudioResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Decryptor.DecryptAndDecodeAudioResponse mCallback;

        DecryptorDecryptAndDecodeAudioResponseParamsForwardToCallback(Decryptor.DecryptAndDecodeAudioResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                Decryptor_Internal.DecryptorDecryptAndDecodeAudioResponseParams response = Decryptor_Internal.DecryptorDecryptAndDecodeAudioResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.audioBuffers);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class DecryptorDecryptAndDecodeAudioResponseParamsProxyToResponder implements Decryptor.DecryptAndDecodeAudioResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        DecryptorDecryptAndDecodeAudioResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, AudioBuffer[] audioBuffers) {
            Decryptor_Internal.DecryptorDecryptAndDecodeAudioResponseParams _response = new Decryptor_Internal.DecryptorDecryptAndDecodeAudioResponseParams();
            _response.status = status.intValue();
            _response.audioBuffers = audioBuffers;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class DecryptorDecryptAndDecodeVideoParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DecoderBuffer encrypted;

        private DecryptorDecryptAndDecodeVideoParams(int version) {
            super(16, version);
        }

        public DecryptorDecryptAndDecodeVideoParams() {
            this(0);
        }

        public static DecryptorDecryptAndDecodeVideoParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorDecryptAndDecodeVideoParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorDecryptAndDecodeVideoParams decode(Decoder decoder0) {
            DecryptorDecryptAndDecodeVideoParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorDecryptAndDecodeVideoParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.encrypted = DecoderBuffer.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.encrypted, 8, false);
        }
    }

    static final class DecryptorDecryptAndDecodeVideoResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public VideoFrame videoFrame;

        public FrameResourceReleaser releaser;

        private DecryptorDecryptAndDecodeVideoResponseParams(int version) {
            super(32, version);
        }

        public DecryptorDecryptAndDecodeVideoResponseParams() {
            this(0);
        }

        public static DecryptorDecryptAndDecodeVideoResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorDecryptAndDecodeVideoResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorDecryptAndDecodeVideoResponseParams decode(Decoder decoder0) {
            DecryptorDecryptAndDecodeVideoResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorDecryptAndDecodeVideoResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                Decryptor.Status.validate(result.status);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.videoFrame = VideoFrame.decode(decoder1);
                result.releaser = (FrameResourceReleaser)decoder0.readServiceInterface(24, true, FrameResourceReleaser.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.videoFrame, 16, true);
            encoder0.encode(this.releaser, 24, true, FrameResourceReleaser.MANAGER);
        }
    }

    static class DecryptorDecryptAndDecodeVideoResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Decryptor.DecryptAndDecodeVideoResponse mCallback;

        DecryptorDecryptAndDecodeVideoResponseParamsForwardToCallback(Decryptor.DecryptAndDecodeVideoResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2))
                    return false;
                Decryptor_Internal.DecryptorDecryptAndDecodeVideoResponseParams response = Decryptor_Internal.DecryptorDecryptAndDecodeVideoResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.videoFrame, response.releaser);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class DecryptorDecryptAndDecodeVideoResponseParamsProxyToResponder implements Decryptor.DecryptAndDecodeVideoResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        DecryptorDecryptAndDecodeVideoResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, VideoFrame videoFrame, FrameResourceReleaser releaser) {
            Decryptor_Internal.DecryptorDecryptAndDecodeVideoResponseParams _response = new Decryptor_Internal.DecryptorDecryptAndDecodeVideoResponseParams();
            _response.status = status.intValue();
            _response.videoFrame = videoFrame;
            _response.releaser = releaser;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class DecryptorResetDecoderParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int streamType;

        private DecryptorResetDecoderParams(int version) {
            super(16, version);
        }

        public DecryptorResetDecoderParams() {
            this(0);
        }

        public static DecryptorResetDecoderParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorResetDecoderParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorResetDecoderParams decode(Decoder decoder0) {
            DecryptorResetDecoderParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorResetDecoderParams(elementsOrVersion);
                result.streamType = decoder0.readInt(8);
                Decryptor.StreamType.validate(result.streamType);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.streamType, 8);
        }
    }

    static final class DecryptorDeinitializeDecoderParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int streamType;

        private DecryptorDeinitializeDecoderParams(int version) {
            super(16, version);
        }

        public DecryptorDeinitializeDecoderParams() {
            this(0);
        }

        public static DecryptorDeinitializeDecoderParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DecryptorDeinitializeDecoderParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DecryptorDeinitializeDecoderParams decode(Decoder decoder0) {
            DecryptorDeinitializeDecoderParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DecryptorDeinitializeDecoderParams(elementsOrVersion);
                result.streamType = decoder0.readInt(8);
                Decryptor.StreamType.validate(result.streamType);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.streamType, 8);
        }
    }
}
