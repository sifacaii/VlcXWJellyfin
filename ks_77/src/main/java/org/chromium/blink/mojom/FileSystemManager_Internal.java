package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.filesystem.mojom.DirectoryEntry;
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
import org.chromium.mojo_base.mojom.FileError;
import org.chromium.mojo_base.mojom.FileInfo;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

class FileSystemManager_Internal {
    public static final Interface.Manager<FileSystemManager, FileSystemManager.Proxy> MANAGER = new Interface.Manager<FileSystemManager, FileSystemManager.Proxy>() {
        public String getName() {
            return "blink.mojom.FileSystemManager";
        }

        public int getVersion() {
            return 0;
        }

        public FileSystemManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new FileSystemManager_Internal.Proxy(core, messageReceiver);
        }

        public FileSystemManager_Internal.Stub buildStub(Core core, FileSystemManager impl) {
            return new FileSystemManager_Internal.Stub(core, impl);
        }

        public FileSystemManager[] buildArray(int size) {
            return new FileSystemManager[size];
        }
    };

    private static final int OPEN_ORDINAL = 0;

    private static final int RESOLVE_URL_ORDINAL = 1;

    private static final int MOVE_ORDINAL = 2;

    private static final int COPY_ORDINAL = 3;

    private static final int REMOVE_ORDINAL = 4;

    private static final int READ_METADATA_ORDINAL = 5;

    private static final int CREATE_ORDINAL = 6;

    private static final int EXISTS_ORDINAL = 7;

    private static final int READ_DIRECTORY_ORDINAL = 8;

    private static final int READ_DIRECTORY_SYNC_ORDINAL = 9;

    private static final int WRITE_ORDINAL = 10;

    private static final int WRITE_SYNC_ORDINAL = 11;

    private static final int TRUNCATE_ORDINAL = 12;

    private static final int TRUNCATE_SYNC_ORDINAL = 13;

    private static final int TOUCH_FILE_ORDINAL = 14;

    private static final int CREATE_SNAPSHOT_FILE_ORDINAL = 15;

    private static final int GET_PLATFORM_PATH_ORDINAL = 16;

    static final class Proxy extends Interface.AbstractProxy implements FileSystemManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void open(Origin origin, int fileSystemType, FileSystemManager.OpenResponse callback) {
            FileSystemManager_Internal.FileSystemManagerOpenParams _message = new FileSystemManager_Internal.FileSystemManagerOpenParams();
            _message.origin = origin;
            _message.fileSystemType = fileSystemType;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerOpenResponseParamsForwardToCallback(callback));
        }

        public void resolveUrl(Url filesystemUrl, FileSystemManager.ResolveUrlResponse callback) {
            FileSystemManager_Internal.FileSystemManagerResolveUrlParams _message = new FileSystemManager_Internal.FileSystemManagerResolveUrlParams();
            _message.filesystemUrl = filesystemUrl;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerResolveUrlResponseParamsForwardToCallback(callback));
        }

        public void move(Url srcPath, Url destPath, FileSystemManager.MoveResponse callback) {
            FileSystemManager_Internal.FileSystemManagerMoveParams _message = new FileSystemManager_Internal.FileSystemManagerMoveParams();
            _message.srcPath = srcPath;
            _message.destPath = destPath;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerMoveResponseParamsForwardToCallback(callback));
        }

        public void copy(Url srcPath, Url destPath, FileSystemManager.CopyResponse callback) {
            FileSystemManager_Internal.FileSystemManagerCopyParams _message = new FileSystemManager_Internal.FileSystemManagerCopyParams();
            _message.srcPath = srcPath;
            _message.destPath = destPath;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerCopyResponseParamsForwardToCallback(callback));
        }

        public void remove(Url path, boolean recursive, FileSystemManager.RemoveResponse callback) {
            FileSystemManager_Internal.FileSystemManagerRemoveParams _message = new FileSystemManager_Internal.FileSystemManagerRemoveParams();
            _message.path = path;
            _message.recursive = recursive;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerRemoveResponseParamsForwardToCallback(callback));
        }

        public void readMetadata(Url path, FileSystemManager.ReadMetadataResponse callback) {
            FileSystemManager_Internal.FileSystemManagerReadMetadataParams _message = new FileSystemManager_Internal.FileSystemManagerReadMetadataParams();
            _message.path = path;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerReadMetadataResponseParamsForwardToCallback(callback));
        }

        public void create(Url path, boolean exclusive, boolean isDirectory, boolean recursive, FileSystemManager.CreateResponse callback) {
            FileSystemManager_Internal.FileSystemManagerCreateParams _message = new FileSystemManager_Internal.FileSystemManagerCreateParams();
            _message.path = path;
            _message.exclusive = exclusive;
            _message.isDirectory = isDirectory;
            _message.recursive = recursive;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerCreateResponseParamsForwardToCallback(callback));
        }

        public void exists(Url path, boolean isDirectory, FileSystemManager.ExistsResponse callback) {
            FileSystemManager_Internal.FileSystemManagerExistsParams _message = new FileSystemManager_Internal.FileSystemManagerExistsParams();
            _message.path = path;
            _message.isDirectory = isDirectory;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerExistsResponseParamsForwardToCallback(callback));
        }

        public void readDirectory(Url path, FileSystemOperationListener listener) {
            FileSystemManager_Internal.FileSystemManagerReadDirectoryParams _message = new FileSystemManager_Internal.FileSystemManagerReadDirectoryParams();
            _message.path = path;
            _message.listener = listener;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8)));
        }

        public void readDirectorySync(Url path, FileSystemManager.ReadDirectorySyncResponse callback) {
            FileSystemManager_Internal.FileSystemManagerReadDirectorySyncParams _message = new FileSystemManager_Internal.FileSystemManagerReadDirectorySyncParams();
            _message.path = path;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerReadDirectorySyncResponseParamsForwardToCallback(callback));
        }

        public void write(Url filePath, String blobUuid, long position, InterfaceRequest<FileSystemCancellableOperation> opRequest, FileSystemOperationListener listener) {
            FileSystemManager_Internal.FileSystemManagerWriteParams _message = new FileSystemManager_Internal.FileSystemManagerWriteParams();
            _message.filePath = filePath;
            _message.blobUuid = blobUuid;
            _message.position = position;
            _message.opRequest = opRequest;
            _message.listener = listener;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(10)));
        }

        public void writeSync(Url filePath, String blobUuid, long position, FileSystemManager.WriteSyncResponse callback) {
            FileSystemManager_Internal.FileSystemManagerWriteSyncParams _message = new FileSystemManager_Internal.FileSystemManagerWriteSyncParams();
            _message.filePath = filePath;
            _message.blobUuid = blobUuid;
            _message.position = position;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerWriteSyncResponseParamsForwardToCallback(callback));
        }

        public void truncate(Url filePath, long length, InterfaceRequest<FileSystemCancellableOperation> opRequest, FileSystemManager.TruncateResponse callback) {
            FileSystemManager_Internal.FileSystemManagerTruncateParams _message = new FileSystemManager_Internal.FileSystemManagerTruncateParams();
            _message.filePath = filePath;
            _message.length = length;
            _message.opRequest = opRequest;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(12, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerTruncateResponseParamsForwardToCallback(callback));
        }

        public void truncateSync(Url filePath, long length, FileSystemManager.TruncateSyncResponse callback) {
            FileSystemManager_Internal.FileSystemManagerTruncateSyncParams _message = new FileSystemManager_Internal.FileSystemManagerTruncateSyncParams();
            _message.filePath = filePath;
            _message.length = length;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(13, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerTruncateSyncResponseParamsForwardToCallback(callback));
        }

        public void touchFile(Url path, Time lastAccessTime, Time lastModifiedTime, FileSystemManager.TouchFileResponse callback) {
            FileSystemManager_Internal.FileSystemManagerTouchFileParams _message = new FileSystemManager_Internal.FileSystemManagerTouchFileParams();
            _message.path = path;
            _message.lastAccessTime = lastAccessTime;
            _message.lastModifiedTime = lastModifiedTime;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(14, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerTouchFileResponseParamsForwardToCallback(callback));
        }

        public void createSnapshotFile(Url filePath, FileSystemManager.CreateSnapshotFileResponse callback) {
            FileSystemManager_Internal.FileSystemManagerCreateSnapshotFileParams _message = new FileSystemManager_Internal.FileSystemManagerCreateSnapshotFileParams();
            _message.filePath = filePath;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(15, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerCreateSnapshotFileResponseParamsForwardToCallback(callback));
        }

        public void getPlatformPath(Url filePath, FileSystemManager.GetPlatformPathResponse callback) {
            FileSystemManager_Internal.FileSystemManagerGetPlatformPathParams _message = new FileSystemManager_Internal.FileSystemManagerGetPlatformPathParams();
            _message.filePath = filePath;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(16, 1, 0L)), new FileSystemManager_Internal.FileSystemManagerGetPlatformPathResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<FileSystemManager> {
        Stub(Core core, FileSystemManager impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                FileSystemManager_Internal.FileSystemManagerReadDirectoryParams fileSystemManagerReadDirectoryParams;
                FileSystemManager_Internal.FileSystemManagerWriteParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FileSystemManager_Internal.MANAGER, messageWithHeader);
                    case 8:
                        fileSystemManagerReadDirectoryParams = FileSystemManager_Internal.FileSystemManagerReadDirectoryParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).readDirectory(fileSystemManagerReadDirectoryParams.path, fileSystemManagerReadDirectoryParams.listener);
                        return true;
                    case 10:
                        data = FileSystemManager_Internal.FileSystemManagerWriteParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).write(data.filePath, data.blobUuid, data.position, data.opRequest, data.listener);
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
                FileSystemManager_Internal.FileSystemManagerOpenParams fileSystemManagerOpenParams;
                FileSystemManager_Internal.FileSystemManagerResolveUrlParams fileSystemManagerResolveUrlParams;
                FileSystemManager_Internal.FileSystemManagerMoveParams fileSystemManagerMoveParams;
                FileSystemManager_Internal.FileSystemManagerCopyParams fileSystemManagerCopyParams;
                FileSystemManager_Internal.FileSystemManagerRemoveParams fileSystemManagerRemoveParams;
                FileSystemManager_Internal.FileSystemManagerReadMetadataParams fileSystemManagerReadMetadataParams;
                FileSystemManager_Internal.FileSystemManagerCreateParams fileSystemManagerCreateParams;
                FileSystemManager_Internal.FileSystemManagerExistsParams fileSystemManagerExistsParams;
                FileSystemManager_Internal.FileSystemManagerReadDirectorySyncParams fileSystemManagerReadDirectorySyncParams;
                FileSystemManager_Internal.FileSystemManagerWriteSyncParams fileSystemManagerWriteSyncParams;
                FileSystemManager_Internal.FileSystemManagerTruncateParams fileSystemManagerTruncateParams;
                FileSystemManager_Internal.FileSystemManagerTruncateSyncParams fileSystemManagerTruncateSyncParams;
                FileSystemManager_Internal.FileSystemManagerTouchFileParams fileSystemManagerTouchFileParams;
                FileSystemManager_Internal.FileSystemManagerCreateSnapshotFileParams fileSystemManagerCreateSnapshotFileParams;
                FileSystemManager_Internal.FileSystemManagerGetPlatformPathParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), FileSystemManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        fileSystemManagerOpenParams = FileSystemManager_Internal.FileSystemManagerOpenParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).open(fileSystemManagerOpenParams.origin, fileSystemManagerOpenParams.fileSystemType, new FileSystemManager_Internal.FileSystemManagerOpenResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        fileSystemManagerResolveUrlParams = FileSystemManager_Internal.FileSystemManagerResolveUrlParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).resolveUrl(fileSystemManagerResolveUrlParams.filesystemUrl, new FileSystemManager_Internal.FileSystemManagerResolveUrlResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        fileSystemManagerMoveParams = FileSystemManager_Internal.FileSystemManagerMoveParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).move(fileSystemManagerMoveParams.srcPath, fileSystemManagerMoveParams.destPath, new FileSystemManager_Internal.FileSystemManagerMoveResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        fileSystemManagerCopyParams = FileSystemManager_Internal.FileSystemManagerCopyParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).copy(fileSystemManagerCopyParams.srcPath, fileSystemManagerCopyParams.destPath, new FileSystemManager_Internal.FileSystemManagerCopyResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        fileSystemManagerRemoveParams = FileSystemManager_Internal.FileSystemManagerRemoveParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).remove(fileSystemManagerRemoveParams.path, fileSystemManagerRemoveParams.recursive, new FileSystemManager_Internal.FileSystemManagerRemoveResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        fileSystemManagerReadMetadataParams = FileSystemManager_Internal.FileSystemManagerReadMetadataParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).readMetadata(fileSystemManagerReadMetadataParams.path, new FileSystemManager_Internal.FileSystemManagerReadMetadataResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        fileSystemManagerCreateParams = FileSystemManager_Internal.FileSystemManagerCreateParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).create(fileSystemManagerCreateParams.path, fileSystemManagerCreateParams.exclusive, fileSystemManagerCreateParams.isDirectory, fileSystemManagerCreateParams.recursive, new FileSystemManager_Internal.FileSystemManagerCreateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        fileSystemManagerExistsParams = FileSystemManager_Internal.FileSystemManagerExistsParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).exists(fileSystemManagerExistsParams.path, fileSystemManagerExistsParams.isDirectory, new FileSystemManager_Internal.FileSystemManagerExistsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 9:
                        fileSystemManagerReadDirectorySyncParams = FileSystemManager_Internal.FileSystemManagerReadDirectorySyncParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).readDirectorySync(fileSystemManagerReadDirectorySyncParams.path, new FileSystemManager_Internal.FileSystemManagerReadDirectorySyncResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 11:
                        fileSystemManagerWriteSyncParams = FileSystemManager_Internal.FileSystemManagerWriteSyncParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).writeSync(fileSystemManagerWriteSyncParams.filePath, fileSystemManagerWriteSyncParams.blobUuid, fileSystemManagerWriteSyncParams.position, new FileSystemManager_Internal.FileSystemManagerWriteSyncResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 12:
                        fileSystemManagerTruncateParams = FileSystemManager_Internal.FileSystemManagerTruncateParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).truncate(fileSystemManagerTruncateParams.filePath, fileSystemManagerTruncateParams.length, fileSystemManagerTruncateParams.opRequest, new FileSystemManager_Internal.FileSystemManagerTruncateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 13:
                        fileSystemManagerTruncateSyncParams = FileSystemManager_Internal.FileSystemManagerTruncateSyncParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).truncateSync(fileSystemManagerTruncateSyncParams.filePath, fileSystemManagerTruncateSyncParams.length, new FileSystemManager_Internal.FileSystemManagerTruncateSyncResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 14:
                        fileSystemManagerTouchFileParams = FileSystemManager_Internal.FileSystemManagerTouchFileParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).touchFile(fileSystemManagerTouchFileParams.path, fileSystemManagerTouchFileParams.lastAccessTime, fileSystemManagerTouchFileParams.lastModifiedTime, new FileSystemManager_Internal.FileSystemManagerTouchFileResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 15:
                        fileSystemManagerCreateSnapshotFileParams = FileSystemManager_Internal.FileSystemManagerCreateSnapshotFileParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).createSnapshotFile(fileSystemManagerCreateSnapshotFileParams.filePath, new FileSystemManager_Internal.FileSystemManagerCreateSnapshotFileResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 16:
                        data = FileSystemManager_Internal.FileSystemManagerGetPlatformPathParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemManager)getImpl()).getPlatformPath(data.filePath, new FileSystemManager_Internal.FileSystemManagerGetPlatformPathResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class FileSystemManagerOpenParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Origin origin;

        public int fileSystemType;

        private FileSystemManagerOpenParams(int version) {
            super(24, version);
        }

        public FileSystemManagerOpenParams() {
            this(0);
        }

        public static FileSystemManagerOpenParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerOpenParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerOpenParams decode(Decoder decoder0) {
            FileSystemManagerOpenParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerOpenParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.origin = Origin.decode(decoder1);
                result.fileSystemType = decoder0.readInt(16);
                FileSystemType.validate(result.fileSystemType);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.origin, 8, false);
            encoder0.encode(this.fileSystemType, 16);
        }
    }

    static final class FileSystemManagerOpenResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String name;

        public Url rootUrl;

        public int errorCode;

        private FileSystemManagerOpenResponseParams(int version) {
            super(32, version);
        }

        public FileSystemManagerOpenResponseParams() {
            this(0);
        }

        public static FileSystemManagerOpenResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerOpenResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerOpenResponseParams decode(Decoder decoder0) {
            FileSystemManagerOpenResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerOpenResponseParams(elementsOrVersion);
                result.name = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.rootUrl = Url.decode(decoder1);
                result.errorCode = decoder0.readInt(24);
                FileError.validate(result.errorCode);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.name, 8, false);
            encoder0.encode((Struct)this.rootUrl, 16, false);
            encoder0.encode(this.errorCode, 24);
        }
    }

    static class FileSystemManagerOpenResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.OpenResponse mCallback;

        FileSystemManagerOpenResponseParamsForwardToCallback(FileSystemManager.OpenResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerOpenResponseParams response = FileSystemManager_Internal.FileSystemManagerOpenResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.name, response.rootUrl, Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerOpenResponseParamsProxyToResponder implements FileSystemManager.OpenResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerOpenResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(String name, Url rootUrl, Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerOpenResponseParams _response = new FileSystemManager_Internal.FileSystemManagerOpenResponseParams();
            _response.name = name;
            _response.rootUrl = rootUrl;
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerResolveUrlParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url filesystemUrl;

        private FileSystemManagerResolveUrlParams(int version) {
            super(16, version);
        }

        public FileSystemManagerResolveUrlParams() {
            this(0);
        }

        public static FileSystemManagerResolveUrlParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerResolveUrlParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerResolveUrlParams decode(Decoder decoder0) {
            FileSystemManagerResolveUrlParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerResolveUrlParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.filesystemUrl = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.filesystemUrl, 8, false);
        }
    }

    static final class FileSystemManagerResolveUrlResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FileSystemInfo info;

        public FilePath filePath;

        public boolean isDirectory;

        public int errorCode;

        private FileSystemManagerResolveUrlResponseParams(int version) {
            super(32, version);
        }

        public FileSystemManagerResolveUrlResponseParams() {
            this(0);
        }

        public static FileSystemManagerResolveUrlResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerResolveUrlResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerResolveUrlResponseParams decode(Decoder decoder0) {
            FileSystemManagerResolveUrlResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerResolveUrlResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.info = FileSystemInfo.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.filePath = FilePath.decode(decoder1);
                result.isDirectory = decoder0.readBoolean(24, 0);
                result.errorCode = decoder0.readInt(28);
                FileError.validate(result.errorCode);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.info, 8, false);
            encoder0.encode((Struct)this.filePath, 16, false);
            encoder0.encode(this.isDirectory, 24, 0);
            encoder0.encode(this.errorCode, 28);
        }
    }

    static class FileSystemManagerResolveUrlResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.ResolveUrlResponse mCallback;

        FileSystemManagerResolveUrlResponseParamsForwardToCallback(FileSystemManager.ResolveUrlResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerResolveUrlResponseParams response = FileSystemManager_Internal.FileSystemManagerResolveUrlResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.info, response.filePath, Boolean.valueOf(response.isDirectory), Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerResolveUrlResponseParamsProxyToResponder implements FileSystemManager.ResolveUrlResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerResolveUrlResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(FileSystemInfo info, FilePath filePath, Boolean isDirectory, Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerResolveUrlResponseParams _response = new FileSystemManager_Internal.FileSystemManagerResolveUrlResponseParams();
            _response.info = info;
            _response.filePath = filePath;
            _response.isDirectory = isDirectory.booleanValue();
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerMoveParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url srcPath;

        public Url destPath;

        private FileSystemManagerMoveParams(int version) {
            super(24, version);
        }

        public FileSystemManagerMoveParams() {
            this(0);
        }

        public static FileSystemManagerMoveParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerMoveParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerMoveParams decode(Decoder decoder0) {
            FileSystemManagerMoveParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerMoveParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.srcPath = Url.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.destPath = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.srcPath, 8, false);
            encoder0.encode((Struct)this.destPath, 16, false);
        }
    }

    static final class FileSystemManagerMoveResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int errorCode;

        private FileSystemManagerMoveResponseParams(int version) {
            super(16, version);
        }

        public FileSystemManagerMoveResponseParams() {
            this(0);
        }

        public static FileSystemManagerMoveResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerMoveResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerMoveResponseParams decode(Decoder decoder0) {
            FileSystemManagerMoveResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerMoveResponseParams(elementsOrVersion);
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

    static class FileSystemManagerMoveResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.MoveResponse mCallback;

        FileSystemManagerMoveResponseParamsForwardToCallback(FileSystemManager.MoveResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerMoveResponseParams response = FileSystemManager_Internal.FileSystemManagerMoveResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerMoveResponseParamsProxyToResponder implements FileSystemManager.MoveResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerMoveResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerMoveResponseParams _response = new FileSystemManager_Internal.FileSystemManagerMoveResponseParams();
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerCopyParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url srcPath;

        public Url destPath;

        private FileSystemManagerCopyParams(int version) {
            super(24, version);
        }

        public FileSystemManagerCopyParams() {
            this(0);
        }

        public static FileSystemManagerCopyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerCopyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerCopyParams decode(Decoder decoder0) {
            FileSystemManagerCopyParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerCopyParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.srcPath = Url.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.destPath = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.srcPath, 8, false);
            encoder0.encode((Struct)this.destPath, 16, false);
        }
    }

    static final class FileSystemManagerCopyResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int errorCode;

        private FileSystemManagerCopyResponseParams(int version) {
            super(16, version);
        }

        public FileSystemManagerCopyResponseParams() {
            this(0);
        }

        public static FileSystemManagerCopyResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerCopyResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerCopyResponseParams decode(Decoder decoder0) {
            FileSystemManagerCopyResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerCopyResponseParams(elementsOrVersion);
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

    static class FileSystemManagerCopyResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.CopyResponse mCallback;

        FileSystemManagerCopyResponseParamsForwardToCallback(FileSystemManager.CopyResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerCopyResponseParams response = FileSystemManager_Internal.FileSystemManagerCopyResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerCopyResponseParamsProxyToResponder implements FileSystemManager.CopyResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerCopyResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerCopyResponseParams _response = new FileSystemManager_Internal.FileSystemManagerCopyResponseParams();
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerRemoveParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url path;

        public boolean recursive;

        private FileSystemManagerRemoveParams(int version) {
            super(24, version);
        }

        public FileSystemManagerRemoveParams() {
            this(0);
        }

        public static FileSystemManagerRemoveParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerRemoveParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerRemoveParams decode(Decoder decoder0) {
            FileSystemManagerRemoveParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerRemoveParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.path = Url.decode(decoder1);
                result.recursive = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.path, 8, false);
            encoder0.encode(this.recursive, 16, 0);
        }
    }

    static final class FileSystemManagerRemoveResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int errorCode;

        private FileSystemManagerRemoveResponseParams(int version) {
            super(16, version);
        }

        public FileSystemManagerRemoveResponseParams() {
            this(0);
        }

        public static FileSystemManagerRemoveResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerRemoveResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerRemoveResponseParams decode(Decoder decoder0) {
            FileSystemManagerRemoveResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerRemoveResponseParams(elementsOrVersion);
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

    static class FileSystemManagerRemoveResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.RemoveResponse mCallback;

        FileSystemManagerRemoveResponseParamsForwardToCallback(FileSystemManager.RemoveResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerRemoveResponseParams response = FileSystemManager_Internal.FileSystemManagerRemoveResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerRemoveResponseParamsProxyToResponder implements FileSystemManager.RemoveResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerRemoveResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerRemoveResponseParams _response = new FileSystemManager_Internal.FileSystemManagerRemoveResponseParams();
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerReadMetadataParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url path;

        private FileSystemManagerReadMetadataParams(int version) {
            super(16, version);
        }

        public FileSystemManagerReadMetadataParams() {
            this(0);
        }

        public static FileSystemManagerReadMetadataParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerReadMetadataParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerReadMetadataParams decode(Decoder decoder0) {
            FileSystemManagerReadMetadataParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerReadMetadataParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.path = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.path, 8, false);
        }
    }

    static final class FileSystemManagerReadMetadataResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FileInfo fileInfo;

        public int errorCode;

        private FileSystemManagerReadMetadataResponseParams(int version) {
            super(24, version);
        }

        public FileSystemManagerReadMetadataResponseParams() {
            this(0);
        }

        public static FileSystemManagerReadMetadataResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerReadMetadataResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerReadMetadataResponseParams decode(Decoder decoder0) {
            FileSystemManagerReadMetadataResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerReadMetadataResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.fileInfo = FileInfo.decode(decoder1);
                result.errorCode = decoder0.readInt(16);
                FileError.validate(result.errorCode);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.fileInfo, 8, false);
            encoder0.encode(this.errorCode, 16);
        }
    }

    static class FileSystemManagerReadMetadataResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.ReadMetadataResponse mCallback;

        FileSystemManagerReadMetadataResponseParamsForwardToCallback(FileSystemManager.ReadMetadataResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerReadMetadataResponseParams response = FileSystemManager_Internal.FileSystemManagerReadMetadataResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.fileInfo, Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerReadMetadataResponseParamsProxyToResponder implements FileSystemManager.ReadMetadataResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerReadMetadataResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(FileInfo fileInfo, Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerReadMetadataResponseParams _response = new FileSystemManager_Internal.FileSystemManagerReadMetadataResponseParams();
            _response.fileInfo = fileInfo;
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerCreateParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url path;

        public boolean exclusive;

        public boolean isDirectory;

        public boolean recursive;

        private FileSystemManagerCreateParams(int version) {
            super(24, version);
        }

        public FileSystemManagerCreateParams() {
            this(0);
        }

        public static FileSystemManagerCreateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerCreateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerCreateParams decode(Decoder decoder0) {
            FileSystemManagerCreateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerCreateParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.path = Url.decode(decoder1);
                result.exclusive = decoder0.readBoolean(16, 0);
                result.isDirectory = decoder0.readBoolean(16, 1);
                result.recursive = decoder0.readBoolean(16, 2);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.path, 8, false);
            encoder0.encode(this.exclusive, 16, 0);
            encoder0.encode(this.isDirectory, 16, 1);
            encoder0.encode(this.recursive, 16, 2);
        }
    }

    static final class FileSystemManagerCreateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int errorCode;

        private FileSystemManagerCreateResponseParams(int version) {
            super(16, version);
        }

        public FileSystemManagerCreateResponseParams() {
            this(0);
        }

        public static FileSystemManagerCreateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerCreateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerCreateResponseParams decode(Decoder decoder0) {
            FileSystemManagerCreateResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerCreateResponseParams(elementsOrVersion);
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

    static class FileSystemManagerCreateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.CreateResponse mCallback;

        FileSystemManagerCreateResponseParamsForwardToCallback(FileSystemManager.CreateResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerCreateResponseParams response = FileSystemManager_Internal.FileSystemManagerCreateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerCreateResponseParamsProxyToResponder implements FileSystemManager.CreateResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerCreateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerCreateResponseParams _response = new FileSystemManager_Internal.FileSystemManagerCreateResponseParams();
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerExistsParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url path;

        public boolean isDirectory;

        private FileSystemManagerExistsParams(int version) {
            super(24, version);
        }

        public FileSystemManagerExistsParams() {
            this(0);
        }

        public static FileSystemManagerExistsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerExistsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerExistsParams decode(Decoder decoder0) {
            FileSystemManagerExistsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerExistsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.path = Url.decode(decoder1);
                result.isDirectory = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.path, 8, false);
            encoder0.encode(this.isDirectory, 16, 0);
        }
    }

    static final class FileSystemManagerExistsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int errorCode;

        private FileSystemManagerExistsResponseParams(int version) {
            super(16, version);
        }

        public FileSystemManagerExistsResponseParams() {
            this(0);
        }

        public static FileSystemManagerExistsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerExistsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerExistsResponseParams decode(Decoder decoder0) {
            FileSystemManagerExistsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerExistsResponseParams(elementsOrVersion);
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

    static class FileSystemManagerExistsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.ExistsResponse mCallback;

        FileSystemManagerExistsResponseParamsForwardToCallback(FileSystemManager.ExistsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(7, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerExistsResponseParams response = FileSystemManager_Internal.FileSystemManagerExistsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerExistsResponseParamsProxyToResponder implements FileSystemManager.ExistsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerExistsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerExistsResponseParams _response = new FileSystemManager_Internal.FileSystemManagerExistsResponseParams();
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerReadDirectoryParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url path;

        public FileSystemOperationListener listener;

        private FileSystemManagerReadDirectoryParams(int version) {
            super(24, version);
        }

        public FileSystemManagerReadDirectoryParams() {
            this(0);
        }

        public static FileSystemManagerReadDirectoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerReadDirectoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerReadDirectoryParams decode(Decoder decoder0) {
            FileSystemManagerReadDirectoryParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerReadDirectoryParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.path = Url.decode(decoder1);
                result.listener = (FileSystemOperationListener)decoder0.readServiceInterface(16, false, FileSystemOperationListener.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.path, 8, false);
            encoder0.encode(this.listener, 16, false, FileSystemOperationListener.MANAGER);
        }
    }

    static final class FileSystemManagerReadDirectorySyncParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url path;

        private FileSystemManagerReadDirectorySyncParams(int version) {
            super(16, version);
        }

        public FileSystemManagerReadDirectorySyncParams() {
            this(0);
        }

        public static FileSystemManagerReadDirectorySyncParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerReadDirectorySyncParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerReadDirectorySyncParams decode(Decoder decoder0) {
            FileSystemManagerReadDirectorySyncParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerReadDirectorySyncParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.path = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.path, 8, false);
        }
    }

    static final class FileSystemManagerReadDirectorySyncResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DirectoryEntry[] entries;

        public int errorCode;

        private FileSystemManagerReadDirectorySyncResponseParams(int version) {
            super(24, version);
        }

        public FileSystemManagerReadDirectorySyncResponseParams() {
            this(0);
        }

        public static FileSystemManagerReadDirectorySyncResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerReadDirectorySyncResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerReadDirectorySyncResponseParams decode(Decoder decoder0) {
            FileSystemManagerReadDirectorySyncResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerReadDirectorySyncResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.entries = new DirectoryEntry[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.entries[i1] = DirectoryEntry.decode(decoder2);
                }
                result.errorCode = decoder0.readInt(16);
                FileError.validate(result.errorCode);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.entries == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.entries.length, 8, -1);
                for (int i0 = 0; i0 < this.entries.length; i0++)
                    encoder1.encode((Struct)this.entries[i0], 8 + 8 * i0, false);
            }
            encoder0.encode(this.errorCode, 16);
        }
    }

    static class FileSystemManagerReadDirectorySyncResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.ReadDirectorySyncResponse mCallback;

        FileSystemManagerReadDirectorySyncResponseParamsForwardToCallback(FileSystemManager.ReadDirectorySyncResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(9, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerReadDirectorySyncResponseParams response = FileSystemManager_Internal.FileSystemManagerReadDirectorySyncResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.entries, Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerReadDirectorySyncResponseParamsProxyToResponder implements FileSystemManager.ReadDirectorySyncResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerReadDirectorySyncResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(DirectoryEntry[] entries, Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerReadDirectorySyncResponseParams _response = new FileSystemManager_Internal.FileSystemManagerReadDirectorySyncResponseParams();
            _response.entries = entries;
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerWriteParams extends Struct {
        private static final int STRUCT_SIZE = 48;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(48, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url filePath;

        public String blobUuid;

        public long position;

        public InterfaceRequest<FileSystemCancellableOperation> opRequest;

        public FileSystemOperationListener listener;

        private FileSystemManagerWriteParams(int version) {
            super(48, version);
        }

        public FileSystemManagerWriteParams() {
            this(0);
        }

        public static FileSystemManagerWriteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerWriteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerWriteParams decode(Decoder decoder0) {
            FileSystemManagerWriteParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerWriteParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.filePath = Url.decode(decoder1);
                result.blobUuid = decoder0.readString(16, false);
                result.position = decoder0.readLong(24);
                result.opRequest = decoder0.readInterfaceRequest(32, false);
                result.listener = (FileSystemOperationListener)decoder0.readServiceInterface(36, false, FileSystemOperationListener.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.filePath, 8, false);
            encoder0.encode(this.blobUuid, 16, false);
            encoder0.encode(this.position, 24);
            encoder0.encode(this.opRequest, 32, false);
            encoder0.encode(this.listener, 36, false, FileSystemOperationListener.MANAGER);
        }
    }

    static final class FileSystemManagerWriteSyncParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url filePath;

        public String blobUuid;

        public long position;

        private FileSystemManagerWriteSyncParams(int version) {
            super(32, version);
        }

        public FileSystemManagerWriteSyncParams() {
            this(0);
        }

        public static FileSystemManagerWriteSyncParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerWriteSyncParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerWriteSyncParams decode(Decoder decoder0) {
            FileSystemManagerWriteSyncParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerWriteSyncParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.filePath = Url.decode(decoder1);
                result.blobUuid = decoder0.readString(16, false);
                result.position = decoder0.readLong(24);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.filePath, 8, false);
            encoder0.encode(this.blobUuid, 16, false);
            encoder0.encode(this.position, 24);
        }
    }

    static final class FileSystemManagerWriteSyncResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long byteCount;

        public int errorCode;

        private FileSystemManagerWriteSyncResponseParams(int version) {
            super(24, version);
        }

        public FileSystemManagerWriteSyncResponseParams() {
            this(0);
        }

        public static FileSystemManagerWriteSyncResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerWriteSyncResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerWriteSyncResponseParams decode(Decoder decoder0) {
            FileSystemManagerWriteSyncResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerWriteSyncResponseParams(elementsOrVersion);
                result.byteCount = decoder0.readLong(8);
                result.errorCode = decoder0.readInt(16);
                FileError.validate(result.errorCode);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.byteCount, 8);
            encoder0.encode(this.errorCode, 16);
        }
    }

    static class FileSystemManagerWriteSyncResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.WriteSyncResponse mCallback;

        FileSystemManagerWriteSyncResponseParamsForwardToCallback(FileSystemManager.WriteSyncResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(11, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerWriteSyncResponseParams response = FileSystemManager_Internal.FileSystemManagerWriteSyncResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Long.valueOf(response.byteCount), Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerWriteSyncResponseParamsProxyToResponder implements FileSystemManager.WriteSyncResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerWriteSyncResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Long byteCount, Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerWriteSyncResponseParams _response = new FileSystemManager_Internal.FileSystemManagerWriteSyncResponseParams();
            _response.byteCount = byteCount.longValue();
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerTruncateParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url filePath;

        public long length;

        public InterfaceRequest<FileSystemCancellableOperation> opRequest;

        private FileSystemManagerTruncateParams(int version) {
            super(32, version);
        }

        public FileSystemManagerTruncateParams() {
            this(0);
        }

        public static FileSystemManagerTruncateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerTruncateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerTruncateParams decode(Decoder decoder0) {
            FileSystemManagerTruncateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerTruncateParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.filePath = Url.decode(decoder1);
                result.length = decoder0.readLong(16);
                result.opRequest = decoder0.readInterfaceRequest(24, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.filePath, 8, false);
            encoder0.encode(this.length, 16);
            encoder0.encode(this.opRequest, 24, false);
        }
    }

    static final class FileSystemManagerTruncateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int errorCode;

        private FileSystemManagerTruncateResponseParams(int version) {
            super(16, version);
        }

        public FileSystemManagerTruncateResponseParams() {
            this(0);
        }

        public static FileSystemManagerTruncateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerTruncateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerTruncateResponseParams decode(Decoder decoder0) {
            FileSystemManagerTruncateResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerTruncateResponseParams(elementsOrVersion);
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

    static class FileSystemManagerTruncateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.TruncateResponse mCallback;

        FileSystemManagerTruncateResponseParamsForwardToCallback(FileSystemManager.TruncateResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(12, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerTruncateResponseParams response = FileSystemManager_Internal.FileSystemManagerTruncateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerTruncateResponseParamsProxyToResponder implements FileSystemManager.TruncateResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerTruncateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerTruncateResponseParams _response = new FileSystemManager_Internal.FileSystemManagerTruncateResponseParams();
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(12, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerTruncateSyncParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url filePath;

        public long length;

        private FileSystemManagerTruncateSyncParams(int version) {
            super(24, version);
        }

        public FileSystemManagerTruncateSyncParams() {
            this(0);
        }

        public static FileSystemManagerTruncateSyncParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerTruncateSyncParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerTruncateSyncParams decode(Decoder decoder0) {
            FileSystemManagerTruncateSyncParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerTruncateSyncParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.filePath = Url.decode(decoder1);
                result.length = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.filePath, 8, false);
            encoder0.encode(this.length, 16);
        }
    }

    static final class FileSystemManagerTruncateSyncResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int errorCode;

        private FileSystemManagerTruncateSyncResponseParams(int version) {
            super(16, version);
        }

        public FileSystemManagerTruncateSyncResponseParams() {
            this(0);
        }

        public static FileSystemManagerTruncateSyncResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerTruncateSyncResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerTruncateSyncResponseParams decode(Decoder decoder0) {
            FileSystemManagerTruncateSyncResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerTruncateSyncResponseParams(elementsOrVersion);
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

    static class FileSystemManagerTruncateSyncResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.TruncateSyncResponse mCallback;

        FileSystemManagerTruncateSyncResponseParamsForwardToCallback(FileSystemManager.TruncateSyncResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(13, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerTruncateSyncResponseParams response = FileSystemManager_Internal.FileSystemManagerTruncateSyncResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerTruncateSyncResponseParamsProxyToResponder implements FileSystemManager.TruncateSyncResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerTruncateSyncResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerTruncateSyncResponseParams _response = new FileSystemManager_Internal.FileSystemManagerTruncateSyncResponseParams();
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(13, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerTouchFileParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url path;

        public Time lastAccessTime;

        public Time lastModifiedTime;

        private FileSystemManagerTouchFileParams(int version) {
            super(32, version);
        }

        public FileSystemManagerTouchFileParams() {
            this(0);
        }

        public static FileSystemManagerTouchFileParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerTouchFileParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerTouchFileParams decode(Decoder decoder0) {
            FileSystemManagerTouchFileParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerTouchFileParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.path = Url.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.lastAccessTime = Time.decode(decoder1);
                decoder1 = decoder0.readPointer(24, false);
                result.lastModifiedTime = Time.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.path, 8, false);
            encoder0.encode((Struct)this.lastAccessTime, 16, false);
            encoder0.encode((Struct)this.lastModifiedTime, 24, false);
        }
    }

    static final class FileSystemManagerTouchFileResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int errorCode;

        private FileSystemManagerTouchFileResponseParams(int version) {
            super(16, version);
        }

        public FileSystemManagerTouchFileResponseParams() {
            this(0);
        }

        public static FileSystemManagerTouchFileResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerTouchFileResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerTouchFileResponseParams decode(Decoder decoder0) {
            FileSystemManagerTouchFileResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerTouchFileResponseParams(elementsOrVersion);
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

    static class FileSystemManagerTouchFileResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.TouchFileResponse mCallback;

        FileSystemManagerTouchFileResponseParamsForwardToCallback(FileSystemManager.TouchFileResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(14, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerTouchFileResponseParams response = FileSystemManager_Internal.FileSystemManagerTouchFileResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.errorCode));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerTouchFileResponseParamsProxyToResponder implements FileSystemManager.TouchFileResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerTouchFileResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer errorCode) {
            FileSystemManager_Internal.FileSystemManagerTouchFileResponseParams _response = new FileSystemManager_Internal.FileSystemManagerTouchFileResponseParams();
            _response.errorCode = errorCode.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(14, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerCreateSnapshotFileParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url filePath;

        private FileSystemManagerCreateSnapshotFileParams(int version) {
            super(16, version);
        }

        public FileSystemManagerCreateSnapshotFileParams() {
            this(0);
        }

        public static FileSystemManagerCreateSnapshotFileParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerCreateSnapshotFileParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerCreateSnapshotFileParams decode(Decoder decoder0) {
            FileSystemManagerCreateSnapshotFileParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerCreateSnapshotFileParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.filePath = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.filePath, 8, false);
        }
    }

    static final class FileSystemManagerCreateSnapshotFileResponseParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FileInfo fileInfo;

        public FilePath platformPath;

        public int errorCode;

        public ReceivedSnapshotListener snapshotListener;

        private FileSystemManagerCreateSnapshotFileResponseParams(int version) {
            super(40, version);
        }

        public FileSystemManagerCreateSnapshotFileResponseParams() {
            this(0);
        }

        public static FileSystemManagerCreateSnapshotFileResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerCreateSnapshotFileResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerCreateSnapshotFileResponseParams decode(Decoder decoder0) {
            FileSystemManagerCreateSnapshotFileResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerCreateSnapshotFileResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.fileInfo = FileInfo.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.platformPath = FilePath.decode(decoder1);
                result.errorCode = decoder0.readInt(24);
                FileError.validate(result.errorCode);
                result.snapshotListener = (ReceivedSnapshotListener)decoder0.readServiceInterface(28, true, ReceivedSnapshotListener.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.fileInfo, 8, false);
            encoder0.encode((Struct)this.platformPath, 16, false);
            encoder0.encode(this.errorCode, 24);
            encoder0.encode(this.snapshotListener, 28, true, ReceivedSnapshotListener.MANAGER);
        }
    }

    static class FileSystemManagerCreateSnapshotFileResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.CreateSnapshotFileResponse mCallback;

        FileSystemManagerCreateSnapshotFileResponseParamsForwardToCallback(FileSystemManager.CreateSnapshotFileResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(15, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerCreateSnapshotFileResponseParams response = FileSystemManager_Internal.FileSystemManagerCreateSnapshotFileResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.fileInfo, response.platformPath, Integer.valueOf(response.errorCode), response.snapshotListener);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerCreateSnapshotFileResponseParamsProxyToResponder implements FileSystemManager.CreateSnapshotFileResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerCreateSnapshotFileResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(FileInfo fileInfo, FilePath platformPath, Integer errorCode, ReceivedSnapshotListener snapshotListener) {
            FileSystemManager_Internal.FileSystemManagerCreateSnapshotFileResponseParams _response = new FileSystemManager_Internal.FileSystemManagerCreateSnapshotFileResponseParams();
            _response.fileInfo = fileInfo;
            _response.platformPath = platformPath;
            _response.errorCode = errorCode.intValue();
            _response.snapshotListener = snapshotListener;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(15, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileSystemManagerGetPlatformPathParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url filePath;

        private FileSystemManagerGetPlatformPathParams(int version) {
            super(16, version);
        }

        public FileSystemManagerGetPlatformPathParams() {
            this(0);
        }

        public static FileSystemManagerGetPlatformPathParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerGetPlatformPathParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerGetPlatformPathParams decode(Decoder decoder0) {
            FileSystemManagerGetPlatformPathParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerGetPlatformPathParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.filePath = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.filePath, 8, false);
        }
    }

    static final class FileSystemManagerGetPlatformPathResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FilePath platformPath;

        private FileSystemManagerGetPlatformPathResponseParams(int version) {
            super(16, version);
        }

        public FileSystemManagerGetPlatformPathResponseParams() {
            this(0);
        }

        public static FileSystemManagerGetPlatformPathResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemManagerGetPlatformPathResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemManagerGetPlatformPathResponseParams decode(Decoder decoder0) {
            FileSystemManagerGetPlatformPathResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemManagerGetPlatformPathResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.platformPath = FilePath.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.platformPath, 8, false);
        }
    }

    static class FileSystemManagerGetPlatformPathResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystemManager.GetPlatformPathResponse mCallback;

        FileSystemManagerGetPlatformPathResponseParamsForwardToCallback(FileSystemManager.GetPlatformPathResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(16, 2))
                    return false;
                FileSystemManager_Internal.FileSystemManagerGetPlatformPathResponseParams response = FileSystemManager_Internal.FileSystemManagerGetPlatformPathResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.platformPath);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileSystemManagerGetPlatformPathResponseParamsProxyToResponder implements FileSystemManager.GetPlatformPathResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileSystemManagerGetPlatformPathResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(FilePath platformPath) {
            FileSystemManager_Internal.FileSystemManagerGetPlatformPathResponseParams _response = new FileSystemManager_Internal.FileSystemManagerGetPlatformPathResponseParams();
            _response.platformPath = platformPath;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(16, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
