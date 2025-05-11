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
import org.chromium.mojo_base.mojom.FileError;

class FileSystemCancellableOperation_Internal {
    public static final Interface.Manager<FileSystemCancellableOperation, FileSystemCancellableOperation.Proxy> MANAGER = new Interface.Manager<FileSystemCancellableOperation, FileSystemCancellableOperation.Proxy>() {
        public String getName() {
            return "blink.mojom.FileSystemCancellableOperation";
        }

        public int getVersion() {
            return 0;
        }

        public FileSystemCancellableOperation_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new FileSystemCancellableOperation_Internal.Proxy(core, messageReceiver);
        }

        public FileSystemCancellableOperation_Internal.Stub buildStub(Core core, FileSystemCancellableOperation impl) {
            return new FileSystemCancellableOperation_Internal.Stub(core, impl);
        }

        public FileSystemCancellableOperation[] buildArray(int size) {
            return new FileSystemCancellableOperation[size];
        }
    };

    private static final int CANCEL_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements FileSystemCancellableOperation.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void cancel(FileSystemCancellableOperation.CancelResponse callback) {
            FileSystemCancellableOperation_Internal.FileSystemCancellableOperationCancelParams _message = new FileSystemCancellableOperation_Internal.FileSystemCancellableOperationCancelParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new FileSystemCancellableOperation_Internal.FileSystemCancellableOperationCancelResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<FileSystemCancellableOperation> {
        Stub(Core core, FileSystemCancellableOperation impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FileSystemCancellableOperation_Internal.MANAGER, messageWithHeader);
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
                                getCore(), FileSystemCancellableOperation_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        FileSystemCancellableOperation_Internal.FileSystemCancellableOperationCancelParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemCancellableOperation)getImpl()).cancel(new FileSystemCancellableOperation_Internal.FileSystemCancellableOperationCancelResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class FileSystemCancellableOperationCancelParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private FileSystemCancellableOperationCancelParams(int version) {
            super(8, version);
        }

        public FileSystemCancellableOperationCancelParams() {
            this(0);
        }

        public static FileSystemCancellableOperationCancelParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemCancellableOperationCancelParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemCancellableOperationCancelParams decode(Decoder decoder0) {
            FileSystemCancellableOperationCancelParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemCancellableOperationCancelParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class FileSystemCancellableOperationCancelResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int errorCode;

        private FileSystemCancellableOperationCancelResponseParams(int version) {
            super(16, version);
        }

        public FileSystemCancellableOperationCancelResponseParams() {
            this(0);
        }

        public static FileSystemCancellableOperationCancelResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemCancellableOperationCancelResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemCancellableOperationCancelResponseParams decode(Decoder decoder0) {
            FileSystemCancellableOperationCancelResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemCancellableOperationCancelResponseParams(elementsOrVersion);
                result.errorCode = decoder0.readInt(8);
                FileError.validate(result.errorCode);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.errorCode, 8);
        }
    }

    static class FileSystemCancellableOperationCancelResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemCancellableOperation.CancelResponse mCallback;

        FileSystemCancellableOperationCancelResponseParamsForwardToCallback(FileSystemCancellableOperation.CancelResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                FileSystemCancellableOperation_Internal.FileSystemCancellableOperationCancelResponseParams response = FileSystemCancellableOperation_Internal.FileSystemCancellableOperationCancelResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemCancellableOperationCancelResponseParamsProxyToResponder implements FileSystemCancellableOperation.CancelResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemCancellableOperationCancelResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer errorCode) {
            FileSystemCancellableOperation_Internal.FileSystemCancellableOperationCancelResponseParams _response = new FileSystemCancellableOperation_Internal.FileSystemCancellableOperationCancelResponseParams();
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
