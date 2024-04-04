package org.chromium.blink.mojom;

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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class NativeFileSystemFileHandle_Internal {
    public static final Interface.Manager<NativeFileSystemFileHandle, NativeFileSystemFileHandle.Proxy> MANAGER = new Interface.Manager<NativeFileSystemFileHandle, NativeFileSystemFileHandle.Proxy>() {
        public String getName() {
            return "blink.mojom.NativeFileSystemFileHandle";
        }

        public int getVersion() {
            return 0;
        }

        public NativeFileSystemFileHandle_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new NativeFileSystemFileHandle_Internal.Proxy(core, messageReceiver);
        }

        public NativeFileSystemFileHandle_Internal.Stub buildStub(Core core, NativeFileSystemFileHandle impl) {
            return new NativeFileSystemFileHandle_Internal.Stub(core, impl);
        }

        public NativeFileSystemFileHandle[] buildArray(int size) {
            return new NativeFileSystemFileHandle[size];
        }
    };

    private static final int GET_PERMISSION_STATUS_ORDINAL = 0;

    private static final int REQUEST_PERMISSION_ORDINAL = 1;

    private static final int AS_BLOB_ORDINAL = 2;

    private static final int REMOVE_ORDINAL = 3;

    private static final int CREATE_FILE_WRITER_ORDINAL = 4;

    private static final int TRANSFER_ORDINAL = 5;

    static final class Proxy extends Interface.AbstractProxy implements NativeFileSystemFileHandle.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getPermissionStatus(boolean writable, NativeFileSystemFileHandle.GetPermissionStatusResponse callback) {
            NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleGetPermissionStatusParams _message = new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleGetPermissionStatusParams();
            _message.writable = writable;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleGetPermissionStatusResponseParamsForwardToCallback(callback));
        }

        public void requestPermission(boolean writable, NativeFileSystemFileHandle.RequestPermissionResponse callback) {
            NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRequestPermissionParams _message = new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRequestPermissionParams();
            _message.writable = writable;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRequestPermissionResponseParamsForwardToCallback(callback));
        }

        public void asBlob(NativeFileSystemFileHandle.AsBlobResponse callback) {
            NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleAsBlobParams _message = new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleAsBlobParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleAsBlobResponseParamsForwardToCallback(callback));
        }

        public void remove(NativeFileSystemFileHandle.RemoveResponse callback) {
            NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRemoveParams _message = new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRemoveParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRemoveResponseParamsForwardToCallback(callback));
        }

        public void createFileWriter(NativeFileSystemFileHandle.CreateFileWriterResponse callback) {
            NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleCreateFileWriterParams _message = new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleCreateFileWriterParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleCreateFileWriterResponseParamsForwardToCallback(callback));
        }

        public void transfer(InterfaceRequest<NativeFileSystemTransferToken> token) {
            NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleTransferParams _message = new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleTransferParams();
            _message.token = token;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5)));
        }
    }

    static final class Stub extends Interface.Stub<NativeFileSystemFileHandle> {
        Stub(Core core, NativeFileSystemFileHandle impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleTransferParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NativeFileSystemFileHandle_Internal.MANAGER, messageWithHeader);
                    case 5:
                        data = NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleTransferParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemFileHandle)getImpl()).transfer(data.token);
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
                NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleGetPermissionStatusParams nativeFileSystemFileHandleGetPermissionStatusParams;
                NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRequestPermissionParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), NativeFileSystemFileHandle_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        nativeFileSystemFileHandleGetPermissionStatusParams = NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleGetPermissionStatusParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemFileHandle)getImpl()).getPermissionStatus(nativeFileSystemFileHandleGetPermissionStatusParams.writable, new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleGetPermissionStatusResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        data = NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRequestPermissionParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemFileHandle)getImpl()).requestPermission(data.writable, new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRequestPermissionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleAsBlobParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemFileHandle)getImpl()).asBlob(new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleAsBlobResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRemoveParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemFileHandle)getImpl()).remove(new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRemoveResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleCreateFileWriterParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemFileHandle)getImpl()).createFileWriter(new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleCreateFileWriterResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class NativeFileSystemFileHandleGetPermissionStatusParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean writable;

        private NativeFileSystemFileHandleGetPermissionStatusParams(int version) {
            super(16, version);
        }

        public NativeFileSystemFileHandleGetPermissionStatusParams() {
            this(0);
        }

        public static NativeFileSystemFileHandleGetPermissionStatusParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileHandleGetPermissionStatusParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileHandleGetPermissionStatusParams decode(Decoder decoder0) {
            NativeFileSystemFileHandleGetPermissionStatusParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileHandleGetPermissionStatusParams(elementsOrVersion);
                result.writable = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.writable, 8, 0);
        }
    }

    static final class NativeFileSystemFileHandleGetPermissionStatusResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private NativeFileSystemFileHandleGetPermissionStatusResponseParams(int version) {
            super(16, version);
        }

        public NativeFileSystemFileHandleGetPermissionStatusResponseParams() {
            this(0);
        }

        public static NativeFileSystemFileHandleGetPermissionStatusResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileHandleGetPermissionStatusResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileHandleGetPermissionStatusResponseParams decode(Decoder decoder0) {
            NativeFileSystemFileHandleGetPermissionStatusResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileHandleGetPermissionStatusResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PermissionStatus.validate(result.status);
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

    static class NativeFileSystemFileHandleGetPermissionStatusResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemFileHandle.GetPermissionStatusResponse mCallback;

        NativeFileSystemFileHandleGetPermissionStatusResponseParamsForwardToCallback(NativeFileSystemFileHandle.GetPermissionStatusResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleGetPermissionStatusResponseParams response = NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleGetPermissionStatusResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemFileHandleGetPermissionStatusResponseParamsProxyToResponder implements NativeFileSystemFileHandle.GetPermissionStatusResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemFileHandleGetPermissionStatusResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleGetPermissionStatusResponseParams _response = new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleGetPermissionStatusResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemFileHandleRequestPermissionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean writable;

        private NativeFileSystemFileHandleRequestPermissionParams(int version) {
            super(16, version);
        }

        public NativeFileSystemFileHandleRequestPermissionParams() {
            this(0);
        }

        public static NativeFileSystemFileHandleRequestPermissionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileHandleRequestPermissionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileHandleRequestPermissionParams decode(Decoder decoder0) {
            NativeFileSystemFileHandleRequestPermissionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileHandleRequestPermissionParams(elementsOrVersion);
                result.writable = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.writable, 8, 0);
        }
    }

    static final class NativeFileSystemFileHandleRequestPermissionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private NativeFileSystemFileHandleRequestPermissionResponseParams(int version) {
            super(16, version);
        }

        public NativeFileSystemFileHandleRequestPermissionResponseParams() {
            this(0);
        }

        public static NativeFileSystemFileHandleRequestPermissionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileHandleRequestPermissionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileHandleRequestPermissionResponseParams decode(Decoder decoder0) {
            NativeFileSystemFileHandleRequestPermissionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileHandleRequestPermissionResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                PermissionStatus.validate(result.status);
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

    static class NativeFileSystemFileHandleRequestPermissionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemFileHandle.RequestPermissionResponse mCallback;

        NativeFileSystemFileHandleRequestPermissionResponseParamsForwardToCallback(NativeFileSystemFileHandle.RequestPermissionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRequestPermissionResponseParams response = NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRequestPermissionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemFileHandleRequestPermissionResponseParamsProxyToResponder implements NativeFileSystemFileHandle.RequestPermissionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemFileHandleRequestPermissionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRequestPermissionResponseParams _response = new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRequestPermissionResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemFileHandleAsBlobParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NativeFileSystemFileHandleAsBlobParams(int version) {
            super(8, version);
        }

        public NativeFileSystemFileHandleAsBlobParams() {
            this(0);
        }

        public static NativeFileSystemFileHandleAsBlobParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileHandleAsBlobParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileHandleAsBlobParams decode(Decoder decoder0) {
            NativeFileSystemFileHandleAsBlobParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileHandleAsBlobParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NativeFileSystemFileHandleAsBlobResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        public SerializedBlob blob;

        private NativeFileSystemFileHandleAsBlobResponseParams(int version) {
            super(24, version);
        }

        public NativeFileSystemFileHandleAsBlobResponseParams() {
            this(0);
        }

        public static NativeFileSystemFileHandleAsBlobResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileHandleAsBlobResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileHandleAsBlobResponseParams decode(Decoder decoder0) {
            NativeFileSystemFileHandleAsBlobResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileHandleAsBlobResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = NativeFileSystemError.decode(decoder1);
                decoder1 = decoder0.readPointer(16, true);
                result.blob = SerializedBlob.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            encoder0.encode(this.blob, 16, true);
        }
    }

    static class NativeFileSystemFileHandleAsBlobResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemFileHandle.AsBlobResponse mCallback;

        NativeFileSystemFileHandleAsBlobResponseParamsForwardToCallback(NativeFileSystemFileHandle.AsBlobResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleAsBlobResponseParams response = NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleAsBlobResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, response.blob);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemFileHandleAsBlobResponseParamsProxyToResponder implements NativeFileSystemFileHandle.AsBlobResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemFileHandleAsBlobResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result, SerializedBlob blob) {
            NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleAsBlobResponseParams _response = new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleAsBlobResponseParams();
            _response.result = result;
            _response.blob = blob;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemFileHandleRemoveParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NativeFileSystemFileHandleRemoveParams(int version) {
            super(8, version);
        }

        public NativeFileSystemFileHandleRemoveParams() {
            this(0);
        }

        public static NativeFileSystemFileHandleRemoveParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileHandleRemoveParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileHandleRemoveParams decode(Decoder decoder0) {
            NativeFileSystemFileHandleRemoveParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileHandleRemoveParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NativeFileSystemFileHandleRemoveResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        private NativeFileSystemFileHandleRemoveResponseParams(int version) {
            super(16, version);
        }

        public NativeFileSystemFileHandleRemoveResponseParams() {
            this(0);
        }

        public static NativeFileSystemFileHandleRemoveResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileHandleRemoveResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileHandleRemoveResponseParams decode(Decoder decoder0) {
            NativeFileSystemFileHandleRemoveResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileHandleRemoveResponseParams(elementsOrVersion);
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

    static class NativeFileSystemFileHandleRemoveResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemFileHandle.RemoveResponse mCallback;

        NativeFileSystemFileHandleRemoveResponseParamsForwardToCallback(NativeFileSystemFileHandle.RemoveResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRemoveResponseParams response = NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRemoveResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemFileHandleRemoveResponseParamsProxyToResponder implements NativeFileSystemFileHandle.RemoveResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemFileHandleRemoveResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result) {
            NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRemoveResponseParams _response = new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleRemoveResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemFileHandleCreateFileWriterParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NativeFileSystemFileHandleCreateFileWriterParams(int version) {
            super(8, version);
        }

        public NativeFileSystemFileHandleCreateFileWriterParams() {
            this(0);
        }

        public static NativeFileSystemFileHandleCreateFileWriterParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileHandleCreateFileWriterParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileHandleCreateFileWriterParams decode(Decoder decoder0) {
            NativeFileSystemFileHandleCreateFileWriterParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileHandleCreateFileWriterParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NativeFileSystemFileHandleCreateFileWriterResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        public NativeFileSystemFileWriter writer;

        private NativeFileSystemFileHandleCreateFileWriterResponseParams(int version) {
            super(24, version);
        }

        public NativeFileSystemFileHandleCreateFileWriterResponseParams() {
            this(0);
        }

        public static NativeFileSystemFileHandleCreateFileWriterResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileHandleCreateFileWriterResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileHandleCreateFileWriterResponseParams decode(Decoder decoder0) {
            NativeFileSystemFileHandleCreateFileWriterResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileHandleCreateFileWriterResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = NativeFileSystemError.decode(decoder1);
                result.writer = (NativeFileSystemFileWriter)decoder0.readServiceInterface(16, true, NativeFileSystemFileWriter.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            encoder0.encode(this.writer, 16, true, NativeFileSystemFileWriter.MANAGER);
        }
    }

    static class NativeFileSystemFileHandleCreateFileWriterResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemFileHandle.CreateFileWriterResponse mCallback;

        NativeFileSystemFileHandleCreateFileWriterResponseParamsForwardToCallback(NativeFileSystemFileHandle.CreateFileWriterResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleCreateFileWriterResponseParams response = NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleCreateFileWriterResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, response.writer);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemFileHandleCreateFileWriterResponseParamsProxyToResponder implements NativeFileSystemFileHandle.CreateFileWriterResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemFileHandleCreateFileWriterResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result, NativeFileSystemFileWriter writer) {
            NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleCreateFileWriterResponseParams _response = new NativeFileSystemFileHandle_Internal.NativeFileSystemFileHandleCreateFileWriterResponseParams();
            _response.result = result;
            _response.writer = writer;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemFileHandleTransferParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<NativeFileSystemTransferToken> token;

        private NativeFileSystemFileHandleTransferParams(int version) {
            super(16, version);
        }

        public NativeFileSystemFileHandleTransferParams() {
            this(0);
        }

        public static NativeFileSystemFileHandleTransferParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemFileHandleTransferParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemFileHandleTransferParams decode(Decoder decoder0) {
            NativeFileSystemFileHandleTransferParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemFileHandleTransferParams(elementsOrVersion);
                result.token = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.token, 8, false);
        }
    }
}
