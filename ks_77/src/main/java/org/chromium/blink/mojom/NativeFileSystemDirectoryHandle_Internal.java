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

class NativeFileSystemDirectoryHandle_Internal {
    public static final Interface.Manager<NativeFileSystemDirectoryHandle, NativeFileSystemDirectoryHandle.Proxy> MANAGER = new Interface.Manager<NativeFileSystemDirectoryHandle, NativeFileSystemDirectoryHandle.Proxy>() {
        public String getName() {
            return "blink.mojom.NativeFileSystemDirectoryHandle";
        }

        public int getVersion() {
            return 0;
        }

        public NativeFileSystemDirectoryHandle_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new NativeFileSystemDirectoryHandle_Internal.Proxy(core, messageReceiver);
        }

        public NativeFileSystemDirectoryHandle_Internal.Stub buildStub(Core core, NativeFileSystemDirectoryHandle impl) {
            return new NativeFileSystemDirectoryHandle_Internal.Stub(core, impl);
        }

        public NativeFileSystemDirectoryHandle[] buildArray(int size) {
            return new NativeFileSystemDirectoryHandle[size];
        }
    };

    private static final int GET_PERMISSION_STATUS_ORDINAL = 0;

    private static final int REQUEST_PERMISSION_ORDINAL = 1;

    private static final int GET_FILE_ORDINAL = 2;

    private static final int GET_DIRECTORY_ORDINAL = 3;

    private static final int GET_ENTRIES_ORDINAL = 4;

    private static final int REMOVE_ENTRY_ORDINAL = 5;

    private static final int TRANSFER_ORDINAL = 6;

    static final class Proxy extends Interface.AbstractProxy implements NativeFileSystemDirectoryHandle.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getPermissionStatus(boolean writable, NativeFileSystemDirectoryHandle.GetPermissionStatusResponse callback) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetPermissionStatusParams _message = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetPermissionStatusParams();
            _message.writable = writable;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetPermissionStatusResponseParamsForwardToCallback(callback));
        }

        public void requestPermission(boolean writable, NativeFileSystemDirectoryHandle.RequestPermissionResponse callback) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRequestPermissionParams _message = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRequestPermissionParams();
            _message.writable = writable;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRequestPermissionResponseParamsForwardToCallback(callback));
        }

        public void getFile(String basename, boolean create, NativeFileSystemDirectoryHandle.GetFileResponse callback) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetFileParams _message = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetFileParams();
            _message.basename = basename;
            _message.create = create;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetFileResponseParamsForwardToCallback(callback));
        }

        public void getDirectory(String basename, boolean create, NativeFileSystemDirectoryHandle.GetDirectoryResponse callback) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetDirectoryParams _message = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetDirectoryParams();
            _message.basename = basename;
            _message.create = create;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetDirectoryResponseParamsForwardToCallback(callback));
        }

        public void getEntries(NativeFileSystemDirectoryHandle.GetEntriesResponse callback) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetEntriesParams _message = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetEntriesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetEntriesResponseParamsForwardToCallback(callback));
        }

        public void removeEntry(String basename, boolean recurse, NativeFileSystemDirectoryHandle.RemoveEntryResponse callback) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRemoveEntryParams _message = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRemoveEntryParams();
            _message.basename = basename;
            _message.recurse = recurse;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRemoveEntryResponseParamsForwardToCallback(callback));
        }

        public void transfer(InterfaceRequest<NativeFileSystemTransferToken> token) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleTransferParams _message = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleTransferParams();
            _message.token = token;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6)));
        }
    }

    static final class Stub extends Interface.Stub<NativeFileSystemDirectoryHandle> {
        Stub(Core core, NativeFileSystemDirectoryHandle impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleTransferParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NativeFileSystemDirectoryHandle_Internal.MANAGER, messageWithHeader);
                    case 6:
                        data = NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleTransferParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemDirectoryHandle)getImpl()).transfer(data.token);
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
                NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetPermissionStatusParams nativeFileSystemDirectoryHandleGetPermissionStatusParams;
                NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRequestPermissionParams nativeFileSystemDirectoryHandleRequestPermissionParams;
                NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetFileParams nativeFileSystemDirectoryHandleGetFileParams;
                NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetDirectoryParams nativeFileSystemDirectoryHandleGetDirectoryParams;
                NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRemoveEntryParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), NativeFileSystemDirectoryHandle_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        nativeFileSystemDirectoryHandleGetPermissionStatusParams = NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetPermissionStatusParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemDirectoryHandle)getImpl()).getPermissionStatus(nativeFileSystemDirectoryHandleGetPermissionStatusParams.writable, new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetPermissionStatusResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        nativeFileSystemDirectoryHandleRequestPermissionParams = NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRequestPermissionParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemDirectoryHandle)getImpl()).requestPermission(nativeFileSystemDirectoryHandleRequestPermissionParams.writable, new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRequestPermissionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        nativeFileSystemDirectoryHandleGetFileParams = NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetFileParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemDirectoryHandle)getImpl()).getFile(nativeFileSystemDirectoryHandleGetFileParams.basename, nativeFileSystemDirectoryHandleGetFileParams.create, new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetFileResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        nativeFileSystemDirectoryHandleGetDirectoryParams = NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetDirectoryParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemDirectoryHandle)getImpl()).getDirectory(nativeFileSystemDirectoryHandleGetDirectoryParams.basename, nativeFileSystemDirectoryHandleGetDirectoryParams.create, new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetDirectoryResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetEntriesParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemDirectoryHandle)getImpl()).getEntries(new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetEntriesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        data = NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRemoveEntryParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemDirectoryHandle)getImpl()).removeEntry(data.basename, data.recurse, new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRemoveEntryResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class NativeFileSystemDirectoryHandleGetPermissionStatusParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean writable;

        private NativeFileSystemDirectoryHandleGetPermissionStatusParams(int version) {
            super(16, version);
        }

        public NativeFileSystemDirectoryHandleGetPermissionStatusParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleGetPermissionStatusParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleGetPermissionStatusParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleGetPermissionStatusParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleGetPermissionStatusParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleGetPermissionStatusParams(elementsOrVersion);
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

    static final class NativeFileSystemDirectoryHandleGetPermissionStatusResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private NativeFileSystemDirectoryHandleGetPermissionStatusResponseParams(int version) {
            super(16, version);
        }

        public NativeFileSystemDirectoryHandleGetPermissionStatusResponseParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleGetPermissionStatusResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleGetPermissionStatusResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleGetPermissionStatusResponseParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleGetPermissionStatusResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleGetPermissionStatusResponseParams(elementsOrVersion);
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

    static class NativeFileSystemDirectoryHandleGetPermissionStatusResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemDirectoryHandle.GetPermissionStatusResponse mCallback;

        NativeFileSystemDirectoryHandleGetPermissionStatusResponseParamsForwardToCallback(NativeFileSystemDirectoryHandle.GetPermissionStatusResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetPermissionStatusResponseParams response = NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetPermissionStatusResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemDirectoryHandleGetPermissionStatusResponseParamsProxyToResponder implements NativeFileSystemDirectoryHandle.GetPermissionStatusResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemDirectoryHandleGetPermissionStatusResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetPermissionStatusResponseParams _response = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetPermissionStatusResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemDirectoryHandleRequestPermissionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean writable;

        private NativeFileSystemDirectoryHandleRequestPermissionParams(int version) {
            super(16, version);
        }

        public NativeFileSystemDirectoryHandleRequestPermissionParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleRequestPermissionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleRequestPermissionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleRequestPermissionParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleRequestPermissionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleRequestPermissionParams(elementsOrVersion);
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

    static final class NativeFileSystemDirectoryHandleRequestPermissionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private NativeFileSystemDirectoryHandleRequestPermissionResponseParams(int version) {
            super(16, version);
        }

        public NativeFileSystemDirectoryHandleRequestPermissionResponseParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleRequestPermissionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleRequestPermissionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleRequestPermissionResponseParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleRequestPermissionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleRequestPermissionResponseParams(elementsOrVersion);
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

    static class NativeFileSystemDirectoryHandleRequestPermissionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemDirectoryHandle.RequestPermissionResponse mCallback;

        NativeFileSystemDirectoryHandleRequestPermissionResponseParamsForwardToCallback(NativeFileSystemDirectoryHandle.RequestPermissionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRequestPermissionResponseParams response = NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRequestPermissionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemDirectoryHandleRequestPermissionResponseParamsProxyToResponder implements NativeFileSystemDirectoryHandle.RequestPermissionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemDirectoryHandleRequestPermissionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRequestPermissionResponseParams _response = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRequestPermissionResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemDirectoryHandleGetFileParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String basename;

        public boolean create;

        private NativeFileSystemDirectoryHandleGetFileParams(int version) {
            super(24, version);
        }

        public NativeFileSystemDirectoryHandleGetFileParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleGetFileParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleGetFileParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleGetFileParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleGetFileParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleGetFileParams(elementsOrVersion);
                result.basename = decoder0.readString(8, false);
                result.create = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.basename, 8, false);
            encoder0.encode(this.create, 16, 0);
        }
    }

    static final class NativeFileSystemDirectoryHandleGetFileResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        public NativeFileSystemFileHandle file;

        private NativeFileSystemDirectoryHandleGetFileResponseParams(int version) {
            super(24, version);
        }

        public NativeFileSystemDirectoryHandleGetFileResponseParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleGetFileResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleGetFileResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleGetFileResponseParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleGetFileResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleGetFileResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = NativeFileSystemError.decode(decoder1);
                result.file = (NativeFileSystemFileHandle)decoder0.readServiceInterface(16, true, NativeFileSystemFileHandle.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            encoder0.encode(this.file, 16, true, NativeFileSystemFileHandle.MANAGER);
        }
    }

    static class NativeFileSystemDirectoryHandleGetFileResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemDirectoryHandle.GetFileResponse mCallback;

        NativeFileSystemDirectoryHandleGetFileResponseParamsForwardToCallback(NativeFileSystemDirectoryHandle.GetFileResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetFileResponseParams response = NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetFileResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, response.file);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemDirectoryHandleGetFileResponseParamsProxyToResponder implements NativeFileSystemDirectoryHandle.GetFileResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemDirectoryHandleGetFileResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result, NativeFileSystemFileHandle file) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetFileResponseParams _response = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetFileResponseParams();
            _response.result = result;
            _response.file = file;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemDirectoryHandleGetDirectoryParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String basename;

        public boolean create;

        private NativeFileSystemDirectoryHandleGetDirectoryParams(int version) {
            super(24, version);
        }

        public NativeFileSystemDirectoryHandleGetDirectoryParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleGetDirectoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleGetDirectoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleGetDirectoryParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleGetDirectoryParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleGetDirectoryParams(elementsOrVersion);
                result.basename = decoder0.readString(8, false);
                result.create = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.basename, 8, false);
            encoder0.encode(this.create, 16, 0);
        }
    }

    static final class NativeFileSystemDirectoryHandleGetDirectoryResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        public NativeFileSystemDirectoryHandle directory;

        private NativeFileSystemDirectoryHandleGetDirectoryResponseParams(int version) {
            super(24, version);
        }

        public NativeFileSystemDirectoryHandleGetDirectoryResponseParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleGetDirectoryResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleGetDirectoryResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleGetDirectoryResponseParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleGetDirectoryResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleGetDirectoryResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = NativeFileSystemError.decode(decoder1);
                result.directory = (NativeFileSystemDirectoryHandle)decoder0.readServiceInterface(16, true, NativeFileSystemDirectoryHandle.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            encoder0.encode(this.directory, 16, true, NativeFileSystemDirectoryHandle.MANAGER);
        }
    }

    static class NativeFileSystemDirectoryHandleGetDirectoryResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemDirectoryHandle.GetDirectoryResponse mCallback;

        NativeFileSystemDirectoryHandleGetDirectoryResponseParamsForwardToCallback(NativeFileSystemDirectoryHandle.GetDirectoryResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetDirectoryResponseParams response = NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetDirectoryResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, response.directory);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemDirectoryHandleGetDirectoryResponseParamsProxyToResponder implements NativeFileSystemDirectoryHandle.GetDirectoryResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemDirectoryHandleGetDirectoryResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result, NativeFileSystemDirectoryHandle directory) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetDirectoryResponseParams _response = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetDirectoryResponseParams();
            _response.result = result;
            _response.directory = directory;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemDirectoryHandleGetEntriesParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NativeFileSystemDirectoryHandleGetEntriesParams(int version) {
            super(8, version);
        }

        public NativeFileSystemDirectoryHandleGetEntriesParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleGetEntriesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleGetEntriesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleGetEntriesParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleGetEntriesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleGetEntriesParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NativeFileSystemDirectoryHandleGetEntriesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        public NativeFileSystemEntry[] entries;

        private NativeFileSystemDirectoryHandleGetEntriesResponseParams(int version) {
            super(24, version);
        }

        public NativeFileSystemDirectoryHandleGetEntriesResponseParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleGetEntriesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleGetEntriesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleGetEntriesResponseParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleGetEntriesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleGetEntriesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = NativeFileSystemError.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.entries = new NativeFileSystemEntry[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.entries[i1] = NativeFileSystemEntry.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            if (this.entries == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.entries.length, 16, -1);
                for (int i0 = 0; i0 < this.entries.length; i0++)
                    encoder1.encode(this.entries[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class NativeFileSystemDirectoryHandleGetEntriesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemDirectoryHandle.GetEntriesResponse mCallback;

        NativeFileSystemDirectoryHandleGetEntriesResponseParamsForwardToCallback(NativeFileSystemDirectoryHandle.GetEntriesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetEntriesResponseParams response = NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetEntriesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, response.entries);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemDirectoryHandleGetEntriesResponseParamsProxyToResponder implements NativeFileSystemDirectoryHandle.GetEntriesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemDirectoryHandleGetEntriesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result, NativeFileSystemEntry[] entries) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetEntriesResponseParams _response = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleGetEntriesResponseParams();
            _response.result = result;
            _response.entries = entries;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemDirectoryHandleRemoveEntryParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String basename;

        public boolean recurse;

        private NativeFileSystemDirectoryHandleRemoveEntryParams(int version) {
            super(24, version);
        }

        public NativeFileSystemDirectoryHandleRemoveEntryParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleRemoveEntryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleRemoveEntryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleRemoveEntryParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleRemoveEntryParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleRemoveEntryParams(elementsOrVersion);
                result.basename = decoder0.readString(8, false);
                result.recurse = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.basename, 8, false);
            encoder0.encode(this.recurse, 16, 0);
        }
    }

    static final class NativeFileSystemDirectoryHandleRemoveEntryResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public NativeFileSystemError result;

        private NativeFileSystemDirectoryHandleRemoveEntryResponseParams(int version) {
            super(16, version);
        }

        public NativeFileSystemDirectoryHandleRemoveEntryResponseParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleRemoveEntryResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleRemoveEntryResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleRemoveEntryResponseParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleRemoveEntryResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleRemoveEntryResponseParams(elementsOrVersion);
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

    static class NativeFileSystemDirectoryHandleRemoveEntryResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemDirectoryHandle.RemoveEntryResponse mCallback;

        NativeFileSystemDirectoryHandleRemoveEntryResponseParamsForwardToCallback(NativeFileSystemDirectoryHandle.RemoveEntryResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRemoveEntryResponseParams response = NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRemoveEntryResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemDirectoryHandleRemoveEntryResponseParamsProxyToResponder implements NativeFileSystemDirectoryHandle.RemoveEntryResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemDirectoryHandleRemoveEntryResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(NativeFileSystemError result) {
            NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRemoveEntryResponseParams _response = new NativeFileSystemDirectoryHandle_Internal.NativeFileSystemDirectoryHandleRemoveEntryResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class NativeFileSystemDirectoryHandleTransferParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<NativeFileSystemTransferToken> token;

        private NativeFileSystemDirectoryHandleTransferParams(int version) {
            super(16, version);
        }

        public NativeFileSystemDirectoryHandleTransferParams() {
            this(0);
        }

        public static NativeFileSystemDirectoryHandleTransferParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemDirectoryHandleTransferParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemDirectoryHandleTransferParams decode(Decoder decoder0) {
            NativeFileSystemDirectoryHandleTransferParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemDirectoryHandleTransferParams(elementsOrVersion);
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
