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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;

class NativeFileSystemFileWriter_Internal {
    public static final Interface.Manager<NativeFileSystemFileWriter, NativeFileSystemFileWriter.Proxy> MANAGER = new Interface.Manager<NativeFileSystemFileWriter, NativeFileSystemFileWriter.Proxy>() {
        public String getName() {
            return "blink.mojom.NativeFileSystemFileWriter";
        }

        public int getVersion() {
            return 0;
        }

        public NativeFileSystemFileWriter_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new NativeFileSystemFileWriter_Internal.Proxy(core, messageReceiver);
        }

        public NativeFileSystemFileWriter_Internal.Stub buildStub(Core core, NativeFileSystemFileWriter impl) {
            return new NativeFileSystemFileWriter_Internal.Stub(core, impl);
        }

        public NativeFileSystemFileWriter[] buildArray(int size) {
            return new NativeFileSystemFileWriter[size];
        }
    };

    private static final int WRITE_ORDINAL = 0;

    private static final int WRITE_STREAM_ORDINAL = 1;

    private static final int TRUNCATE_ORDINAL = 2;

    private static final int CLOSE_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements NativeFileSystemFileWriter.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void write(long offset, Blob data, NativeFileSystemFileWriter.WriteResponse callback) {
            NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteParams _message = new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteParams();
            _message.offset = offset;
            _message.data = data;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteResponseParamsForwardToCallback(callback));
        }

        public void writeStream(long offset, DataPipe.ConsumerHandle stream, NativeFileSystemFileWriter.WriteStreamResponse callback) {
            NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteStreamParams _message = new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteStreamParams();
            _message.offset = offset;
            _message.stream = stream;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteStreamResponseParamsForwardToCallback(callback));
        }

        public void truncate(long length, NativeFileSystemFileWriter.TruncateResponse callback) {
            NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterTruncateParams _message = new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterTruncateParams();
            _message.length = length;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterTruncateResponseParamsForwardToCallback(callback));
        }

        public void close(NativeFileSystemFileWriter.CloseResponse callback) {
            NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterCloseParams _message = new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterCloseParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterCloseResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<NativeFileSystemFileWriter> {
        Stub(Core core, NativeFileSystemFileWriter impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NativeFileSystemFileWriter_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteParams nativeFileSystemFileWriterWriteParams;
                NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteStreamParams nativeFileSystemFileWriterWriteStreamParams;
                NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterTruncateParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), NativeFileSystemFileWriter_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        nativeFileSystemFileWriterWriteParams = NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemFileWriter)getImpl()).write(nativeFileSystemFileWriterWriteParams.offset, nativeFileSystemFileWriterWriteParams.data, new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        nativeFileSystemFileWriterWriteStreamParams = NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteStreamParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemFileWriter)getImpl()).writeStream(nativeFileSystemFileWriterWriteStreamParams.offset, nativeFileSystemFileWriterWriteStreamParams.stream, new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteStreamResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterTruncateParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemFileWriter)getImpl()).truncate(data.length, new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterTruncateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterCloseParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemFileWriter)getImpl()).close(new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterCloseResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class NativeFileSystemFileWriterWriteParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long offset;

        public Blob data;

        private NativeFileSystemFileWriterWriteParams(int version) {
            super(24, version);
        }

        public NativeFileSystemFileWriterWriteParams() {
            this(0);
        }

        public static NativeFileSystemFileWriterWriteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileWriterWriteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileWriterWriteParams decode(Decoder decoder0) {
            NativeFileSystemFileWriterWriteParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileWriterWriteParams(elementsOrVersion);
                result.offset = decoder0.readLong(8);
                result.data = (Blob)decoder0.readServiceInterface(16, false, Blob.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.offset, 8);
            encoder0.encode(this.data, 16, false, Blob.MANAGER);
        }
    }

    static final class NativeFileSystemFileWriterWriteResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        public long bytesWritten;

        private NativeFileSystemFileWriterWriteResponseParams(int version) {
            super(24, version);
        }

        public NativeFileSystemFileWriterWriteResponseParams() {
            this(0);
        }

        public static NativeFileSystemFileWriterWriteResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileWriterWriteResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileWriterWriteResponseParams decode(Decoder decoder0) {
            NativeFileSystemFileWriterWriteResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileWriterWriteResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = NativeFileSystemError.decode(decoder1);
                result.bytesWritten = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            encoder0.encode(this.bytesWritten, 16);
        }
    }

    static class NativeFileSystemFileWriterWriteResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemFileWriter.WriteResponse mCallback;

        NativeFileSystemFileWriterWriteResponseParamsForwardToCallback(NativeFileSystemFileWriter.WriteResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteResponseParams response = NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, Long.valueOf(response.bytesWritten));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemFileWriterWriteResponseParamsProxyToResponder implements NativeFileSystemFileWriter.WriteResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemFileWriterWriteResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result, Long bytesWritten) {
            NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteResponseParams _response = new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteResponseParams();
            _response.result = result;
            _response.bytesWritten = bytesWritten.longValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemFileWriterWriteStreamParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long offset;

        public DataPipe.ConsumerHandle stream;

        private NativeFileSystemFileWriterWriteStreamParams(int version) {
            super(24, version);
            this.stream = (DataPipe.ConsumerHandle)InvalidHandle.INSTANCE;
        }

        public NativeFileSystemFileWriterWriteStreamParams() {
            this(0);
        }

        public static NativeFileSystemFileWriterWriteStreamParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileWriterWriteStreamParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileWriterWriteStreamParams decode(Decoder decoder0) {
            NativeFileSystemFileWriterWriteStreamParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileWriterWriteStreamParams(elementsOrVersion);
                result.offset = decoder0.readLong(8);
                result.stream = decoder0.readConsumerHandle(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.offset, 8);
            encoder0.encode((Handle)this.stream, 16, false);
        }
    }

    static final class NativeFileSystemFileWriterWriteStreamResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        public long bytesWritten;

        private NativeFileSystemFileWriterWriteStreamResponseParams(int version) {
            super(24, version);
        }

        public NativeFileSystemFileWriterWriteStreamResponseParams() {
            this(0);
        }

        public static NativeFileSystemFileWriterWriteStreamResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileWriterWriteStreamResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileWriterWriteStreamResponseParams decode(Decoder decoder0) {
            NativeFileSystemFileWriterWriteStreamResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileWriterWriteStreamResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = NativeFileSystemError.decode(decoder1);
                result.bytesWritten = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            encoder0.encode(this.bytesWritten, 16);
        }
    }

    static class NativeFileSystemFileWriterWriteStreamResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemFileWriter.WriteStreamResponse mCallback;

        NativeFileSystemFileWriterWriteStreamResponseParamsForwardToCallback(NativeFileSystemFileWriter.WriteStreamResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteStreamResponseParams response = NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteStreamResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, Long.valueOf(response.bytesWritten));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemFileWriterWriteStreamResponseParamsProxyToResponder implements NativeFileSystemFileWriter.WriteStreamResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemFileWriterWriteStreamResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result, Long bytesWritten) {
            NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteStreamResponseParams _response = new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterWriteStreamResponseParams();
            _response.result = result;
            _response.bytesWritten = bytesWritten.longValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemFileWriterTruncateParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long length;

        private NativeFileSystemFileWriterTruncateParams(int version) {
            super(16, version);
        }

        public NativeFileSystemFileWriterTruncateParams() {
            this(0);
        }

        public static NativeFileSystemFileWriterTruncateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileWriterTruncateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileWriterTruncateParams decode(Decoder decoder0) {
            NativeFileSystemFileWriterTruncateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileWriterTruncateParams(elementsOrVersion);
                result.length = decoder0.readLong(8);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.length, 8);
        }
    }

    static final class NativeFileSystemFileWriterTruncateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        private NativeFileSystemFileWriterTruncateResponseParams(int version) {
            super(16, version);
        }

        public NativeFileSystemFileWriterTruncateResponseParams() {
            this(0);
        }

        public static NativeFileSystemFileWriterTruncateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileWriterTruncateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileWriterTruncateResponseParams decode(Decoder decoder0) {
            NativeFileSystemFileWriterTruncateResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileWriterTruncateResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = NativeFileSystemError.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class NativeFileSystemFileWriterTruncateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemFileWriter.TruncateResponse mCallback;

        NativeFileSystemFileWriterTruncateResponseParamsForwardToCallback(NativeFileSystemFileWriter.TruncateResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterTruncateResponseParams response = NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterTruncateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemFileWriterTruncateResponseParamsProxyToResponder implements NativeFileSystemFileWriter.TruncateResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemFileWriterTruncateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result) {
            NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterTruncateResponseParams _response = new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterTruncateResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemFileWriterCloseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NativeFileSystemFileWriterCloseParams(int version) {
            super(8, version);
        }

        public NativeFileSystemFileWriterCloseParams() {
            this(0);
        }

        public static NativeFileSystemFileWriterCloseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileWriterCloseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileWriterCloseParams decode(Decoder decoder0) {
            NativeFileSystemFileWriterCloseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileWriterCloseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NativeFileSystemFileWriterCloseResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        private NativeFileSystemFileWriterCloseResponseParams(int version) {
            super(16, version);
        }

        public NativeFileSystemFileWriterCloseResponseParams() {
            this(0);
        }

        public static NativeFileSystemFileWriterCloseResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileWriterCloseResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileWriterCloseResponseParams decode(Decoder decoder0) {
            NativeFileSystemFileWriterCloseResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileWriterCloseResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = NativeFileSystemError.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class NativeFileSystemFileWriterCloseResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemFileWriter.CloseResponse mCallback;

        NativeFileSystemFileWriterCloseResponseParamsForwardToCallback(NativeFileSystemFileWriter.CloseResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterCloseResponseParams response = NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterCloseResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemFileWriterCloseResponseParamsProxyToResponder implements NativeFileSystemFileWriter.CloseResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemFileWriterCloseResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result) {
            NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterCloseResponseParams _response = new NativeFileSystemFileWriter_Internal.NativeFileSystemFileWriterCloseResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
