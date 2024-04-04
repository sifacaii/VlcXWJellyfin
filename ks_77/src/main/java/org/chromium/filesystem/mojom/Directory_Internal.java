package org.chromium.filesystem.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.filesystem.mojom.Directory;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal.class */
class Directory_Internal {
    public static final Interface.Manager<Directory, Directory.Proxy> MANAGER = new Interface.Manager<Directory, Directory.Proxy>() { // from class: org.chromium.filesystem.mojom.Directory_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "filesystem.mojom.Directory";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public Directory.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, Directory impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Directory[] buildArray(int size) {
            return new Directory[size];
        }
    };
    private static final int READ_ORDINAL = 0;
    private static final int OPEN_FILE_ORDINAL = 1;
    private static final int OPEN_FILE_HANDLE_ORDINAL = 2;
    private static final int OPEN_FILE_HANDLES_ORDINAL = 3;
    private static final int OPEN_DIRECTORY_ORDINAL = 4;
    private static final int RENAME_ORDINAL = 5;
    private static final int REPLACE_ORDINAL = 6;
    private static final int DELETE_ORDINAL = 7;
    private static final int EXISTS_ORDINAL = 8;
    private static final int IS_WRITABLE_ORDINAL = 9;
    private static final int FLUSH_ORDINAL = 10;
    private static final int STAT_FILE_ORDINAL = 11;
    private static final int CLONE_ORDINAL = 12;
    private static final int READ_ENTIRE_FILE_ORDINAL = 13;
    private static final int WRITE_FILE_ORDINAL = 14;

    Directory_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements Directory.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void read(Directory.ReadResponse callback) {
            DirectoryReadParams _message = new DirectoryReadParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new DirectoryReadResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void openFile(String path, InterfaceRequest<File> file, int openFlags, Directory.OpenFileResponse callback) {
            DirectoryOpenFileParams _message = new DirectoryOpenFileParams();
            _message.path = path;
            _message.file = file;
            _message.openFlags = openFlags;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new DirectoryOpenFileResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void openFileHandle(String path, int openFlags, Directory.OpenFileHandleResponse callback) {
            DirectoryOpenFileHandleParams _message = new DirectoryOpenFileHandleParams();
            _message.path = path;
            _message.openFlags = openFlags;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new DirectoryOpenFileHandleResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void openFileHandles(FileOpenDetails[] files, Directory.OpenFileHandlesResponse callback) {
            DirectoryOpenFileHandlesParams _message = new DirectoryOpenFileHandlesParams();
            _message.files = files;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new DirectoryOpenFileHandlesResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void openDirectory(String path, InterfaceRequest<Directory> directory, int openFlags, Directory.OpenDirectoryResponse callback) {
            DirectoryOpenDirectoryParams _message = new DirectoryOpenDirectoryParams();
            _message.path = path;
            _message.directory = directory;
            _message.openFlags = openFlags;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new DirectoryOpenDirectoryResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void rename(String path, String newPath, Directory.RenameResponse callback) {
            DirectoryRenameParams _message = new DirectoryRenameParams();
            _message.path = path;
            _message.newPath = newPath;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new DirectoryRenameResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void replace(String path, String newPath, Directory.ReplaceResponse callback) {
            DirectoryReplaceParams _message = new DirectoryReplaceParams();
            _message.path = path;
            _message.newPath = newPath;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new DirectoryReplaceResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void delete(String path, int deleteFlags, Directory.DeleteResponse callback) {
            DirectoryDeleteParams _message = new DirectoryDeleteParams();
            _message.path = path;
            _message.deleteFlags = deleteFlags;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new DirectoryDeleteResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void exists(String path, Directory.ExistsResponse callback) {
            DirectoryExistsParams _message = new DirectoryExistsParams();
            _message.path = path;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)), new DirectoryExistsResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void isWritable(String path, Directory.IsWritableResponse callback) {
            DirectoryIsWritableParams _message = new DirectoryIsWritableParams();
            _message.path = path;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)), new DirectoryIsWritableResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void flush(Directory.FlushResponse callback) {
            DirectoryFlushParams _message = new DirectoryFlushParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)), new DirectoryFlushResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void statFile(String path, Directory.StatFileResponse callback) {
            DirectoryStatFileParams _message = new DirectoryStatFileParams();
            _message.path = path;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)), new DirectoryStatFileResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void clone(InterfaceRequest<Directory> directory) {
            DirectoryCloneParams _message = new DirectoryCloneParams();
            _message.directory = directory;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void readEntireFile(String path, Directory.ReadEntireFileResponse callback) {
            DirectoryReadEntireFileParams _message = new DirectoryReadEntireFileParams();
            _message.path = path;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13, 1, 0L)), new DirectoryReadEntireFileResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.Directory
        public void writeFile(String path, byte[] data, Directory.WriteFileResponse callback) {
            DirectoryWriteFileParams _message = new DirectoryWriteFileParams();
            _message.path = path;
            _message.data = data;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14, 1, 0L)), new DirectoryWriteFileResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<Directory> {
        Stub(Core core, Directory impl) {
            super(core, impl);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                }
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Directory_Internal.MANAGER, messageWithHeader);
                    case 12:
                        DirectoryCloneParams data = DirectoryCloneParams.deserialize(messageWithHeader.getPayload());
                        getImpl().clone(data.directory);
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                }
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(getCore(), Directory_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        DirectoryReadParams.deserialize(messageWithHeader.getPayload());
                        getImpl().read(new DirectoryReadResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        DirectoryOpenFileParams data = DirectoryOpenFileParams.deserialize(messageWithHeader.getPayload());
                        getImpl().openFile(data.path, data.file, data.openFlags, new DirectoryOpenFileResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        DirectoryOpenFileHandleParams data2 = DirectoryOpenFileHandleParams.deserialize(messageWithHeader.getPayload());
                        getImpl().openFileHandle(data2.path, data2.openFlags, new DirectoryOpenFileHandleResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        getImpl().openFileHandles(DirectoryOpenFileHandlesParams.deserialize(messageWithHeader.getPayload()).files, new DirectoryOpenFileHandlesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        DirectoryOpenDirectoryParams data3 = DirectoryOpenDirectoryParams.deserialize(messageWithHeader.getPayload());
                        getImpl().openDirectory(data3.path, data3.directory, data3.openFlags, new DirectoryOpenDirectoryResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        DirectoryRenameParams data4 = DirectoryRenameParams.deserialize(messageWithHeader.getPayload());
                        getImpl().rename(data4.path, data4.newPath, new DirectoryRenameResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        DirectoryReplaceParams data5 = DirectoryReplaceParams.deserialize(messageWithHeader.getPayload());
                        getImpl().replace(data5.path, data5.newPath, new DirectoryReplaceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        DirectoryDeleteParams data6 = DirectoryDeleteParams.deserialize(messageWithHeader.getPayload());
                        getImpl().delete(data6.path, data6.deleteFlags, new DirectoryDeleteResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 8:
                        getImpl().exists(DirectoryExistsParams.deserialize(messageWithHeader.getPayload()).path, new DirectoryExistsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 9:
                        getImpl().isWritable(DirectoryIsWritableParams.deserialize(messageWithHeader.getPayload()).path, new DirectoryIsWritableResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 10:
                        DirectoryFlushParams.deserialize(messageWithHeader.getPayload());
                        getImpl().flush(new DirectoryFlushResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 11:
                        getImpl().statFile(DirectoryStatFileParams.deserialize(messageWithHeader.getPayload()).path, new DirectoryStatFileResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 12:
                    default:
                        return false;
                    case 13:
                        getImpl().readEntireFile(DirectoryReadEntireFileParams.deserialize(messageWithHeader.getPayload()).path, new DirectoryReadEntireFileResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 14:
                        DirectoryWriteFileParams data7 = DirectoryWriteFileParams.deserialize(messageWithHeader.getPayload());
                        getImpl().writeFile(data7.path, data7.data, new DirectoryWriteFileResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryReadParams.class */
    static final class DirectoryReadParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private DirectoryReadParams(int version) {
            super(8, version);
        }

        public DirectoryReadParams() {
            this(0);
        }

        public static DirectoryReadParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryReadParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryReadParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryReadParams result = new DirectoryReadParams(elementsOrVersion);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryReadResponseParams.class */
    public static final class DirectoryReadResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;
        public DirectoryEntry[] directoryContents;

        private DirectoryReadResponseParams(int version) {
            super(24, version);
        }

        public DirectoryReadResponseParams() {
            this(0);
        }

        public static DirectoryReadResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryReadResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryReadResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryReadResponseParams result = new DirectoryReadResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                Decoder decoder1 = decoder0.readPointer(16, true);
                if (decoder1 == null) {
                    result.directoryContents = null;
                } else {
                    DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                    result.directoryContents = new DirectoryEntry[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                        Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                        result.directoryContents[i1] = DirectoryEntry.decode(decoder2);
                    }
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            if (this.directoryContents == null) {
                encoder0.encodeNullPointer(16, true);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.directoryContents.length, 16, -1);
            for (int i0 = 0; i0 < this.directoryContents.length; i0++) {
                encoder1.encode((Struct) this.directoryContents[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryReadResponseParamsForwardToCallback.class */
    static class DirectoryReadResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.ReadResponse mCallback;

        DirectoryReadResponseParamsForwardToCallback(Directory.ReadResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2)) {
                    return false;
                }
                DirectoryReadResponseParams response = DirectoryReadResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.directoryContents);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryReadResponseParamsProxyToResponder.class */
    static class DirectoryReadResponseParamsProxyToResponder implements Directory.ReadResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryReadResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer error, DirectoryEntry[] directoryContents) {
            DirectoryReadResponseParams _response = new DirectoryReadResponseParams();
            _response.error = error.intValue();
            _response.directoryContents = directoryContents;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenFileParams.class */
    static final class DirectoryOpenFileParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String path;
        public InterfaceRequest<File> file;
        public int openFlags;

        private DirectoryOpenFileParams(int version) {
            super(24, version);
        }

        public DirectoryOpenFileParams() {
            this(0);
        }

        public static DirectoryOpenFileParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryOpenFileParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryOpenFileParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryOpenFileParams result = new DirectoryOpenFileParams(elementsOrVersion);
                result.path = decoder0.readString(8, false);
                result.file = decoder0.readInterfaceRequest(16, true);
                result.openFlags = decoder0.readInt(20);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.path, 8, false);
            encoder0.encode((InterfaceRequest) this.file, 16, true);
            encoder0.encode(this.openFlags, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenFileResponseParams.class */
    public static final class DirectoryOpenFileResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;

        private DirectoryOpenFileResponseParams(int version) {
            super(16, version);
        }

        public DirectoryOpenFileResponseParams() {
            this(0);
        }

        public static DirectoryOpenFileResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryOpenFileResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryOpenFileResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryOpenFileResponseParams result = new DirectoryOpenFileResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenFileResponseParamsForwardToCallback.class */
    static class DirectoryOpenFileResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.OpenFileResponse mCallback;

        DirectoryOpenFileResponseParamsForwardToCallback(Directory.OpenFileResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2)) {
                    return false;
                }
                DirectoryOpenFileResponseParams response = DirectoryOpenFileResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenFileResponseParamsProxyToResponder.class */
    static class DirectoryOpenFileResponseParamsProxyToResponder implements Directory.OpenFileResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryOpenFileResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer error) {
            DirectoryOpenFileResponseParams _response = new DirectoryOpenFileResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenFileHandleParams.class */
    static final class DirectoryOpenFileHandleParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String path;
        public int openFlags;

        private DirectoryOpenFileHandleParams(int version) {
            super(24, version);
        }

        public DirectoryOpenFileHandleParams() {
            this(0);
        }

        public static DirectoryOpenFileHandleParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryOpenFileHandleParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryOpenFileHandleParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryOpenFileHandleParams result = new DirectoryOpenFileHandleParams(elementsOrVersion);
                result.path = decoder0.readString(8, false);
                result.openFlags = decoder0.readInt(16);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.path, 8, false);
            encoder0.encode(this.openFlags, 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenFileHandleResponseParams.class */
    public static final class DirectoryOpenFileHandleResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;
        public org.chromium.mojo_base.mojom.File fileHandle;

        private DirectoryOpenFileHandleResponseParams(int version) {
            super(24, version);
        }

        public DirectoryOpenFileHandleResponseParams() {
            this(0);
        }

        public static DirectoryOpenFileHandleResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryOpenFileHandleResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryOpenFileHandleResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryOpenFileHandleResponseParams result = new DirectoryOpenFileHandleResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.fileHandle = org.chromium.mojo_base.mojom.File.decode(decoder1);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode((Struct) this.fileHandle, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenFileHandleResponseParamsForwardToCallback.class */
    static class DirectoryOpenFileHandleResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.OpenFileHandleResponse mCallback;

        DirectoryOpenFileHandleResponseParamsForwardToCallback(Directory.OpenFileHandleResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2)) {
                    return false;
                }
                DirectoryOpenFileHandleResponseParams response = DirectoryOpenFileHandleResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.fileHandle);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenFileHandleResponseParamsProxyToResponder.class */
    static class DirectoryOpenFileHandleResponseParamsProxyToResponder implements Directory.OpenFileHandleResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryOpenFileHandleResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer error, org.chromium.mojo_base.mojom.File fileHandle) {
            DirectoryOpenFileHandleResponseParams _response = new DirectoryOpenFileHandleResponseParams();
            _response.error = error.intValue();
            _response.fileHandle = fileHandle;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenFileHandlesParams.class */
    static final class DirectoryOpenFileHandlesParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public FileOpenDetails[] files;

        private DirectoryOpenFileHandlesParams(int version) {
            super(16, version);
        }

        public DirectoryOpenFileHandlesParams() {
            this(0);
        }

        public static DirectoryOpenFileHandlesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryOpenFileHandlesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryOpenFileHandlesParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryOpenFileHandlesParams result = new DirectoryOpenFileHandlesParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.files = new FileOpenDetails[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.files[i1] = FileOpenDetails.decode(decoder2);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.files == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.files.length, 8, -1);
            for (int i0 = 0; i0 < this.files.length; i0++) {
                encoder1.encode((Struct) this.files[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenFileHandlesResponseParams.class */
    public static final class DirectoryOpenFileHandlesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public FileOpenResult[] results;

        private DirectoryOpenFileHandlesResponseParams(int version) {
            super(16, version);
        }

        public DirectoryOpenFileHandlesResponseParams() {
            this(0);
        }

        public static DirectoryOpenFileHandlesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryOpenFileHandlesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryOpenFileHandlesResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryOpenFileHandlesResponseParams result = new DirectoryOpenFileHandlesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.results = new FileOpenResult[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.results[i1] = FileOpenResult.decode(decoder2);
                }
                return result;
            } finally {
                decoder0.decreaseStackDepth();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.results == null) {
                encoder0.encodeNullPointer(8, false);
                return;
            }
            Encoder encoder1 = encoder0.encodePointerArray(this.results.length, 8, -1);
            for (int i0 = 0; i0 < this.results.length; i0++) {
                encoder1.encode((Struct) this.results[i0], 8 + (8 * i0), false);
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenFileHandlesResponseParamsForwardToCallback.class */
    static class DirectoryOpenFileHandlesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.OpenFileHandlesResponse mCallback;

        DirectoryOpenFileHandlesResponseParamsForwardToCallback(Directory.OpenFileHandlesResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2)) {
                    return false;
                }
                DirectoryOpenFileHandlesResponseParams response = DirectoryOpenFileHandlesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.results);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenFileHandlesResponseParamsProxyToResponder.class */
    static class DirectoryOpenFileHandlesResponseParamsProxyToResponder implements Directory.OpenFileHandlesResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryOpenFileHandlesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(FileOpenResult[] results) {
            DirectoryOpenFileHandlesResponseParams _response = new DirectoryOpenFileHandlesResponseParams();
            _response.results = results;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenDirectoryParams.class */
    static final class DirectoryOpenDirectoryParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String path;
        public InterfaceRequest<Directory> directory;
        public int openFlags;

        private DirectoryOpenDirectoryParams(int version) {
            super(24, version);
        }

        public DirectoryOpenDirectoryParams() {
            this(0);
        }

        public static DirectoryOpenDirectoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryOpenDirectoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryOpenDirectoryParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryOpenDirectoryParams result = new DirectoryOpenDirectoryParams(elementsOrVersion);
                result.path = decoder0.readString(8, false);
                result.directory = decoder0.readInterfaceRequest(16, true);
                result.openFlags = decoder0.readInt(20);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.path, 8, false);
            encoder0.encode((InterfaceRequest) this.directory, 16, true);
            encoder0.encode(this.openFlags, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenDirectoryResponseParams.class */
    public static final class DirectoryOpenDirectoryResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;

        private DirectoryOpenDirectoryResponseParams(int version) {
            super(16, version);
        }

        public DirectoryOpenDirectoryResponseParams() {
            this(0);
        }

        public static DirectoryOpenDirectoryResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryOpenDirectoryResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryOpenDirectoryResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryOpenDirectoryResponseParams result = new DirectoryOpenDirectoryResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenDirectoryResponseParamsForwardToCallback.class */
    static class DirectoryOpenDirectoryResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.OpenDirectoryResponse mCallback;

        DirectoryOpenDirectoryResponseParamsForwardToCallback(Directory.OpenDirectoryResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2)) {
                    return false;
                }
                DirectoryOpenDirectoryResponseParams response = DirectoryOpenDirectoryResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryOpenDirectoryResponseParamsProxyToResponder.class */
    static class DirectoryOpenDirectoryResponseParamsProxyToResponder implements Directory.OpenDirectoryResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryOpenDirectoryResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer error) {
            DirectoryOpenDirectoryResponseParams _response = new DirectoryOpenDirectoryResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryRenameParams.class */
    static final class DirectoryRenameParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String path;
        public String newPath;

        private DirectoryRenameParams(int version) {
            super(24, version);
        }

        public DirectoryRenameParams() {
            this(0);
        }

        public static DirectoryRenameParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryRenameParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryRenameParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryRenameParams result = new DirectoryRenameParams(elementsOrVersion);
                result.path = decoder0.readString(8, false);
                result.newPath = decoder0.readString(16, false);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.path, 8, false);
            encoder0.encode(this.newPath, 16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryRenameResponseParams.class */
    public static final class DirectoryRenameResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;

        private DirectoryRenameResponseParams(int version) {
            super(16, version);
        }

        public DirectoryRenameResponseParams() {
            this(0);
        }

        public static DirectoryRenameResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryRenameResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryRenameResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryRenameResponseParams result = new DirectoryRenameResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryRenameResponseParamsForwardToCallback.class */
    static class DirectoryRenameResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.RenameResponse mCallback;

        DirectoryRenameResponseParamsForwardToCallback(Directory.RenameResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2)) {
                    return false;
                }
                DirectoryRenameResponseParams response = DirectoryRenameResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryRenameResponseParamsProxyToResponder.class */
    static class DirectoryRenameResponseParamsProxyToResponder implements Directory.RenameResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryRenameResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer error) {
            DirectoryRenameResponseParams _response = new DirectoryRenameResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryReplaceParams.class */
    static final class DirectoryReplaceParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String path;
        public String newPath;

        private DirectoryReplaceParams(int version) {
            super(24, version);
        }

        public DirectoryReplaceParams() {
            this(0);
        }

        public static DirectoryReplaceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryReplaceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryReplaceParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryReplaceParams result = new DirectoryReplaceParams(elementsOrVersion);
                result.path = decoder0.readString(8, false);
                result.newPath = decoder0.readString(16, false);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.path, 8, false);
            encoder0.encode(this.newPath, 16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryReplaceResponseParams.class */
    public static final class DirectoryReplaceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;

        private DirectoryReplaceResponseParams(int version) {
            super(16, version);
        }

        public DirectoryReplaceResponseParams() {
            this(0);
        }

        public static DirectoryReplaceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryReplaceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryReplaceResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryReplaceResponseParams result = new DirectoryReplaceResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryReplaceResponseParamsForwardToCallback.class */
    static class DirectoryReplaceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.ReplaceResponse mCallback;

        DirectoryReplaceResponseParamsForwardToCallback(Directory.ReplaceResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2)) {
                    return false;
                }
                DirectoryReplaceResponseParams response = DirectoryReplaceResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryReplaceResponseParamsProxyToResponder.class */
    static class DirectoryReplaceResponseParamsProxyToResponder implements Directory.ReplaceResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryReplaceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer error) {
            DirectoryReplaceResponseParams _response = new DirectoryReplaceResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryDeleteParams.class */
    static final class DirectoryDeleteParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String path;
        public int deleteFlags;

        private DirectoryDeleteParams(int version) {
            super(24, version);
        }

        public DirectoryDeleteParams() {
            this(0);
        }

        public static DirectoryDeleteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryDeleteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryDeleteParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryDeleteParams result = new DirectoryDeleteParams(elementsOrVersion);
                result.path = decoder0.readString(8, false);
                result.deleteFlags = decoder0.readInt(16);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.path, 8, false);
            encoder0.encode(this.deleteFlags, 16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryDeleteResponseParams.class */
    public static final class DirectoryDeleteResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;

        private DirectoryDeleteResponseParams(int version) {
            super(16, version);
        }

        public DirectoryDeleteResponseParams() {
            this(0);
        }

        public static DirectoryDeleteResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryDeleteResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryDeleteResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryDeleteResponseParams result = new DirectoryDeleteResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryDeleteResponseParamsForwardToCallback.class */
    static class DirectoryDeleteResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.DeleteResponse mCallback;

        DirectoryDeleteResponseParamsForwardToCallback(Directory.DeleteResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(7, 2)) {
                    return false;
                }
                DirectoryDeleteResponseParams response = DirectoryDeleteResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryDeleteResponseParamsProxyToResponder.class */
    static class DirectoryDeleteResponseParamsProxyToResponder implements Directory.DeleteResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryDeleteResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer error) {
            DirectoryDeleteResponseParams _response = new DirectoryDeleteResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryExistsParams.class */
    static final class DirectoryExistsParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String path;

        private DirectoryExistsParams(int version) {
            super(16, version);
        }

        public DirectoryExistsParams() {
            this(0);
        }

        public static DirectoryExistsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryExistsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryExistsParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryExistsParams result = new DirectoryExistsParams(elementsOrVersion);
                result.path = decoder0.readString(8, false);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.path, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryExistsResponseParams.class */
    public static final class DirectoryExistsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;
        public boolean exists;

        private DirectoryExistsResponseParams(int version) {
            super(16, version);
        }

        public DirectoryExistsResponseParams() {
            this(0);
        }

        public static DirectoryExistsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryExistsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryExistsResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryExistsResponseParams result = new DirectoryExistsResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                result.exists = decoder0.readBoolean(12, 0);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.exists, 12, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryExistsResponseParamsForwardToCallback.class */
    static class DirectoryExistsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.ExistsResponse mCallback;

        DirectoryExistsResponseParamsForwardToCallback(Directory.ExistsResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(8, 2)) {
                    return false;
                }
                DirectoryExistsResponseParams response = DirectoryExistsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), Boolean.valueOf(response.exists));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryExistsResponseParamsProxyToResponder.class */
    static class DirectoryExistsResponseParamsProxyToResponder implements Directory.ExistsResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryExistsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer error, Boolean exists) {
            DirectoryExistsResponseParams _response = new DirectoryExistsResponseParams();
            _response.error = error.intValue();
            _response.exists = exists.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryIsWritableParams.class */
    static final class DirectoryIsWritableParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String path;

        private DirectoryIsWritableParams(int version) {
            super(16, version);
        }

        public DirectoryIsWritableParams() {
            this(0);
        }

        public static DirectoryIsWritableParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryIsWritableParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryIsWritableParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryIsWritableParams result = new DirectoryIsWritableParams(elementsOrVersion);
                result.path = decoder0.readString(8, false);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.path, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryIsWritableResponseParams.class */
    public static final class DirectoryIsWritableResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;
        public boolean isWritable;

        private DirectoryIsWritableResponseParams(int version) {
            super(16, version);
        }

        public DirectoryIsWritableResponseParams() {
            this(0);
        }

        public static DirectoryIsWritableResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryIsWritableResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryIsWritableResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryIsWritableResponseParams result = new DirectoryIsWritableResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                result.isWritable = decoder0.readBoolean(12, 0);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.isWritable, 12, 0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryIsWritableResponseParamsForwardToCallback.class */
    static class DirectoryIsWritableResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.IsWritableResponse mCallback;

        DirectoryIsWritableResponseParamsForwardToCallback(Directory.IsWritableResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(9, 2)) {
                    return false;
                }
                DirectoryIsWritableResponseParams response = DirectoryIsWritableResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), Boolean.valueOf(response.isWritable));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryIsWritableResponseParamsProxyToResponder.class */
    static class DirectoryIsWritableResponseParamsProxyToResponder implements Directory.IsWritableResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryIsWritableResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer error, Boolean isWritable) {
            DirectoryIsWritableResponseParams _response = new DirectoryIsWritableResponseParams();
            _response.error = error.intValue();
            _response.isWritable = isWritable.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryFlushParams.class */
    static final class DirectoryFlushParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private DirectoryFlushParams(int version) {
            super(8, version);
        }

        public DirectoryFlushParams() {
            this(0);
        }

        public static DirectoryFlushParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryFlushParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryFlushParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryFlushParams result = new DirectoryFlushParams(elementsOrVersion);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryFlushResponseParams.class */
    public static final class DirectoryFlushResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;

        private DirectoryFlushResponseParams(int version) {
            super(16, version);
        }

        public DirectoryFlushResponseParams() {
            this(0);
        }

        public static DirectoryFlushResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryFlushResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryFlushResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryFlushResponseParams result = new DirectoryFlushResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryFlushResponseParamsForwardToCallback.class */
    static class DirectoryFlushResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.FlushResponse mCallback;

        DirectoryFlushResponseParamsForwardToCallback(Directory.FlushResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(10, 2)) {
                    return false;
                }
                DirectoryFlushResponseParams response = DirectoryFlushResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryFlushResponseParamsProxyToResponder.class */
    static class DirectoryFlushResponseParamsProxyToResponder implements Directory.FlushResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryFlushResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer error) {
            DirectoryFlushResponseParams _response = new DirectoryFlushResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryStatFileParams.class */
    static final class DirectoryStatFileParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String path;

        private DirectoryStatFileParams(int version) {
            super(16, version);
        }

        public DirectoryStatFileParams() {
            this(0);
        }

        public static DirectoryStatFileParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryStatFileParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryStatFileParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryStatFileParams result = new DirectoryStatFileParams(elementsOrVersion);
                result.path = decoder0.readString(8, false);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.path, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryStatFileResponseParams.class */
    public static final class DirectoryStatFileResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;
        public FileInformation fileInformation;

        private DirectoryStatFileResponseParams(int version) {
            super(24, version);
        }

        public DirectoryStatFileResponseParams() {
            this(0);
        }

        public static DirectoryStatFileResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryStatFileResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryStatFileResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryStatFileResponseParams result = new DirectoryStatFileResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.fileInformation = FileInformation.decode(decoder1);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode((Struct) this.fileInformation, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryStatFileResponseParamsForwardToCallback.class */
    static class DirectoryStatFileResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.StatFileResponse mCallback;

        DirectoryStatFileResponseParamsForwardToCallback(Directory.StatFileResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(11, 2)) {
                    return false;
                }
                DirectoryStatFileResponseParams response = DirectoryStatFileResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.fileInformation);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryStatFileResponseParamsProxyToResponder.class */
    static class DirectoryStatFileResponseParamsProxyToResponder implements Directory.StatFileResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryStatFileResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer error, FileInformation fileInformation) {
            DirectoryStatFileResponseParams _response = new DirectoryStatFileResponseParams();
            _response.error = error.intValue();
            _response.fileInformation = fileInformation;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryCloneParams.class */
    static final class DirectoryCloneParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<Directory> directory;

        private DirectoryCloneParams(int version) {
            super(16, version);
        }

        public DirectoryCloneParams() {
            this(0);
        }

        public static DirectoryCloneParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryCloneParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryCloneParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryCloneParams result = new DirectoryCloneParams(elementsOrVersion);
                result.directory = decoder0.readInterfaceRequest(8, false);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((InterfaceRequest) this.directory, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryReadEntireFileParams.class */
    static final class DirectoryReadEntireFileParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String path;

        private DirectoryReadEntireFileParams(int version) {
            super(16, version);
        }

        public DirectoryReadEntireFileParams() {
            this(0);
        }

        public static DirectoryReadEntireFileParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryReadEntireFileParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryReadEntireFileParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryReadEntireFileParams result = new DirectoryReadEntireFileParams(elementsOrVersion);
                result.path = decoder0.readString(8, false);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.path, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryReadEntireFileResponseParams.class */
    public static final class DirectoryReadEntireFileResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;
        public byte[] data;

        private DirectoryReadEntireFileResponseParams(int version) {
            super(24, version);
        }

        public DirectoryReadEntireFileResponseParams() {
            this(0);
        }

        public static DirectoryReadEntireFileResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryReadEntireFileResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryReadEntireFileResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryReadEntireFileResponseParams result = new DirectoryReadEntireFileResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                result.data = decoder0.readBytes(16, 0, -1);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.data, 16, 0, -1);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryReadEntireFileResponseParamsForwardToCallback.class */
    static class DirectoryReadEntireFileResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.ReadEntireFileResponse mCallback;

        DirectoryReadEntireFileResponseParamsForwardToCallback(Directory.ReadEntireFileResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(13, 2)) {
                    return false;
                }
                DirectoryReadEntireFileResponseParams response = DirectoryReadEntireFileResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.data);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryReadEntireFileResponseParamsProxyToResponder.class */
    static class DirectoryReadEntireFileResponseParamsProxyToResponder implements Directory.ReadEntireFileResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryReadEntireFileResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer error, byte[] data) {
            DirectoryReadEntireFileResponseParams _response = new DirectoryReadEntireFileResponseParams();
            _response.error = error.intValue();
            _response.data = data;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(13, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryWriteFileParams.class */
    static final class DirectoryWriteFileParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String path;
        public byte[] data;

        private DirectoryWriteFileParams(int version) {
            super(24, version);
        }

        public DirectoryWriteFileParams() {
            this(0);
        }

        public static DirectoryWriteFileParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryWriteFileParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryWriteFileParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryWriteFileParams result = new DirectoryWriteFileParams(elementsOrVersion);
                result.path = decoder0.readString(8, false);
                result.data = decoder0.readBytes(16, 0, -1);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.path, 8, false);
            encoder0.encode(this.data, 16, 0, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryWriteFileResponseParams.class */
    public static final class DirectoryWriteFileResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;

        private DirectoryWriteFileResponseParams(int version) {
            super(16, version);
        }

        public DirectoryWriteFileResponseParams() {
            this(0);
        }

        public static DirectoryWriteFileResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DirectoryWriteFileResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DirectoryWriteFileResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                DirectoryWriteFileResponseParams result = new DirectoryWriteFileResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                FileError.validate(result.error);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryWriteFileResponseParamsForwardToCallback.class */
    static class DirectoryWriteFileResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Directory.WriteFileResponse mCallback;

        DirectoryWriteFileResponseParamsForwardToCallback(Directory.WriteFileResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(14, 2)) {
                    return false;
                }
                DirectoryWriteFileResponseParams response = DirectoryWriteFileResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/Directory_Internal$DirectoryWriteFileResponseParamsProxyToResponder.class */
    static class DirectoryWriteFileResponseParamsProxyToResponder implements Directory.WriteFileResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DirectoryWriteFileResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer error) {
            DirectoryWriteFileResponseParams _response = new DirectoryWriteFileResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(14, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
