package org.chromium.filesystem.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.filesystem.mojom.FileSystem;
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

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem_Internal.class */
class FileSystem_Internal {
    public static final Interface.Manager<FileSystem, FileSystem.Proxy> MANAGER = new Interface.Manager<FileSystem, FileSystem.Proxy>() { // from class: org.chromium.filesystem.mojom.FileSystem_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "filesystem.mojom.FileSystem";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public FileSystem.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, FileSystem impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public FileSystem[] buildArray(int size) {
            return new FileSystem[size];
        }
    };
    private static final int OPEN_TEMP_DIRECTORY_ORDINAL = 0;
    private static final int OPEN_PERSISTENT_FILE_SYSTEM_ORDINAL = 1;

    FileSystem_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements FileSystem.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.filesystem.mojom.FileSystem
        public void openTempDirectory(InterfaceRequest<Directory> directory, FileSystem.OpenTempDirectoryResponse callback) {
            FileSystemOpenTempDirectoryParams _message = new FileSystemOpenTempDirectoryParams();
            _message.directory = directory;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new FileSystemOpenTempDirectoryResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.filesystem.mojom.FileSystem
        public void openPersistentFileSystem(InterfaceRequest<Directory> directory, FileSystem.OpenPersistentFileSystemResponse callback) {
            FileSystemOpenPersistentFileSystemParams _message = new FileSystemOpenPersistentFileSystemParams();
            _message.directory = directory;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new FileSystemOpenPersistentFileSystemResponseParamsForwardToCallback(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<FileSystem> {
        Stub(Core core, FileSystem impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FileSystem_Internal.MANAGER, messageWithHeader);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), FileSystem_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        FileSystemOpenTempDirectoryParams data = FileSystemOpenTempDirectoryParams.deserialize(messageWithHeader.getPayload());
                        getImpl().openTempDirectory(data.directory, new FileSystemOpenTempDirectoryResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        FileSystemOpenPersistentFileSystemParams data2 = FileSystemOpenPersistentFileSystemParams.deserialize(messageWithHeader.getPayload());
                        getImpl().openPersistentFileSystem(data2.directory, new FileSystemOpenPersistentFileSystemResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem_Internal$FileSystemOpenTempDirectoryParams.class */
    static final class FileSystemOpenTempDirectoryParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<Directory> directory;

        private FileSystemOpenTempDirectoryParams(int version) {
            super(16, version);
        }

        public FileSystemOpenTempDirectoryParams() {
            this(0);
        }

        public static FileSystemOpenTempDirectoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemOpenTempDirectoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemOpenTempDirectoryParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                FileSystemOpenTempDirectoryParams result = new FileSystemOpenTempDirectoryParams(elementsOrVersion);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem_Internal$FileSystemOpenTempDirectoryResponseParams.class */
    public static final class FileSystemOpenTempDirectoryResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;

        private FileSystemOpenTempDirectoryResponseParams(int version) {
            super(16, version);
        }

        public FileSystemOpenTempDirectoryResponseParams() {
            this(0);
        }

        public static FileSystemOpenTempDirectoryResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemOpenTempDirectoryResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemOpenTempDirectoryResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                FileSystemOpenTempDirectoryResponseParams result = new FileSystemOpenTempDirectoryResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem_Internal$FileSystemOpenTempDirectoryResponseParamsForwardToCallback.class */
    static class FileSystemOpenTempDirectoryResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystem.OpenTempDirectoryResponse mCallback;

        FileSystemOpenTempDirectoryResponseParamsForwardToCallback(FileSystem.OpenTempDirectoryResponse callback) {
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
                FileSystemOpenTempDirectoryResponseParams response = FileSystemOpenTempDirectoryResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem_Internal$FileSystemOpenTempDirectoryResponseParamsProxyToResponder.class */
    static class FileSystemOpenTempDirectoryResponseParamsProxyToResponder implements FileSystem.OpenTempDirectoryResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        FileSystemOpenTempDirectoryResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer error) {
            FileSystemOpenTempDirectoryResponseParams _response = new FileSystemOpenTempDirectoryResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem_Internal$FileSystemOpenPersistentFileSystemParams.class */
    static final class FileSystemOpenPersistentFileSystemParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<Directory> directory;

        private FileSystemOpenPersistentFileSystemParams(int version) {
            super(16, version);
        }

        public FileSystemOpenPersistentFileSystemParams() {
            this(0);
        }

        public static FileSystemOpenPersistentFileSystemParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemOpenPersistentFileSystemParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemOpenPersistentFileSystemParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                FileSystemOpenPersistentFileSystemParams result = new FileSystemOpenPersistentFileSystemParams(elementsOrVersion);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem_Internal$FileSystemOpenPersistentFileSystemResponseParams.class */
    public static final class FileSystemOpenPersistentFileSystemResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;

        private FileSystemOpenPersistentFileSystemResponseParams(int version) {
            super(16, version);
        }

        public FileSystemOpenPersistentFileSystemResponseParams() {
            this(0);
        }

        public static FileSystemOpenPersistentFileSystemResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemOpenPersistentFileSystemResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemOpenPersistentFileSystemResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                FileSystemOpenPersistentFileSystemResponseParams result = new FileSystemOpenPersistentFileSystemResponseParams(elementsOrVersion);
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem_Internal$FileSystemOpenPersistentFileSystemResponseParamsForwardToCallback.class */
    static class FileSystemOpenPersistentFileSystemResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileSystem.OpenPersistentFileSystemResponse mCallback;

        FileSystemOpenPersistentFileSystemResponseParamsForwardToCallback(FileSystem.OpenPersistentFileSystemResponse callback) {
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
                FileSystemOpenPersistentFileSystemResponseParams response = FileSystemOpenPersistentFileSystemResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/filesystem/mojom/FileSystem_Internal$FileSystemOpenPersistentFileSystemResponseParamsProxyToResponder.class */
    static class FileSystemOpenPersistentFileSystemResponseParamsProxyToResponder implements FileSystem.OpenPersistentFileSystemResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        FileSystemOpenPersistentFileSystemResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer error) {
            FileSystemOpenPersistentFileSystemResponseParams _response = new FileSystemOpenPersistentFileSystemResponseParams();
            _response.error = error.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }
}
