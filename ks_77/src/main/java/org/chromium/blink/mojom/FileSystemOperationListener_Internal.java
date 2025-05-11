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
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.FileError;

class FileSystemOperationListener_Internal {
    public static final Interface.Manager<FileSystemOperationListener, FileSystemOperationListener.Proxy> MANAGER = new Interface.Manager<FileSystemOperationListener, FileSystemOperationListener.Proxy>() {
        public String getName() {
            return "blink.mojom.FileSystemOperationListener";
        }

        public int getVersion() {
            return 0;
        }

        public FileSystemOperationListener_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new FileSystemOperationListener_Internal.Proxy(core, messageReceiver);
        }

        public FileSystemOperationListener_Internal.Stub buildStub(Core core, FileSystemOperationListener impl) {
            return new FileSystemOperationListener_Internal.Stub(core, impl);
        }

        public FileSystemOperationListener[] buildArray(int size) {
            return new FileSystemOperationListener[size];
        }
    };

    private static final int RESULTS_RETRIEVED_ORDINAL = 0;

    private static final int DID_WRITE_ORDINAL = 1;

    private static final int ERROR_OCCURRED_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements FileSystemOperationListener.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void resultsRetrieved(DirectoryEntry[] entries, boolean hasMore) {
            FileSystemOperationListener_Internal.FileSystemOperationListenerResultsRetrievedParams _message = new FileSystemOperationListener_Internal.FileSystemOperationListenerResultsRetrievedParams();
            _message.entries = entries;
            _message.hasMore = hasMore;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void didWrite(long byteCount, boolean complete) {
            FileSystemOperationListener_Internal.FileSystemOperationListenerDidWriteParams _message = new FileSystemOperationListener_Internal.FileSystemOperationListenerDidWriteParams();
            _message.byteCount = byteCount;
            _message.complete = complete;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void errorOccurred(int errorCode) {
            FileSystemOperationListener_Internal.FileSystemOperationListenerErrorOccurredParams _message = new FileSystemOperationListener_Internal.FileSystemOperationListenerErrorOccurredParams();
            _message.errorCode = errorCode;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<FileSystemOperationListener> {
        Stub(Core core, FileSystemOperationListener impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                FileSystemOperationListener_Internal.FileSystemOperationListenerResultsRetrievedParams fileSystemOperationListenerResultsRetrievedParams;
                FileSystemOperationListener_Internal.FileSystemOperationListenerDidWriteParams fileSystemOperationListenerDidWriteParams;
                FileSystemOperationListener_Internal.FileSystemOperationListenerErrorOccurredParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FileSystemOperationListener_Internal.MANAGER, messageWithHeader);
                    case 0:
                        fileSystemOperationListenerResultsRetrievedParams = FileSystemOperationListener_Internal.FileSystemOperationListenerResultsRetrievedParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemOperationListener)getImpl()).resultsRetrieved(fileSystemOperationListenerResultsRetrievedParams.entries, fileSystemOperationListenerResultsRetrievedParams.hasMore);
                        return true;
                    case 1:
                        fileSystemOperationListenerDidWriteParams = FileSystemOperationListener_Internal.FileSystemOperationListenerDidWriteParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemOperationListener)getImpl()).didWrite(fileSystemOperationListenerDidWriteParams.byteCount, fileSystemOperationListenerDidWriteParams.complete);
                        return true;
                    case 2:
                        data = FileSystemOperationListener_Internal.FileSystemOperationListenerErrorOccurredParams.deserialize(messageWithHeader.getPayload());
                        ((FileSystemOperationListener)getImpl()).errorOccurred(data.errorCode);
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
                                getCore(), FileSystemOperationListener_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class FileSystemOperationListenerResultsRetrievedParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DirectoryEntry[] entries;

        public boolean hasMore;

        private FileSystemOperationListenerResultsRetrievedParams(int version) {
            super(24, version);
        }

        public FileSystemOperationListenerResultsRetrievedParams() {
            this(0);
        }

        public static FileSystemOperationListenerResultsRetrievedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemOperationListenerResultsRetrievedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemOperationListenerResultsRetrievedParams decode(Decoder decoder0) {
            FileSystemOperationListenerResultsRetrievedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemOperationListenerResultsRetrievedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.entries = new DirectoryEntry[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.entries[i1] = DirectoryEntry.decode(decoder2);
                }
                result.hasMore = decoder0.readBoolean(16, 0);
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
            encoder0.encode(this.hasMore, 16, 0);
        }
    }

    static final class FileSystemOperationListenerDidWriteParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public long byteCount;

        public boolean complete;

        private FileSystemOperationListenerDidWriteParams(int version) {
            super(24, version);
        }

        public FileSystemOperationListenerDidWriteParams() {
            this(0);
        }

        public static FileSystemOperationListenerDidWriteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemOperationListenerDidWriteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemOperationListenerDidWriteParams decode(Decoder decoder0) {
            FileSystemOperationListenerDidWriteParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemOperationListenerDidWriteParams(elementsOrVersion);
                result.byteCount = decoder0.readLong(8);
                result.complete = decoder0.readBoolean(16, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.byteCount, 8);
            encoder0.encode(this.complete, 16, 0);
        }
    }

    static final class FileSystemOperationListenerErrorOccurredParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int errorCode;

        private FileSystemOperationListenerErrorOccurredParams(int version) {
            super(16, version);
        }

        public FileSystemOperationListenerErrorOccurredParams() {
            this(0);
        }

        public static FileSystemOperationListenerErrorOccurredParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileSystemOperationListenerErrorOccurredParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileSystemOperationListenerErrorOccurredParams decode(Decoder decoder0) {
            FileSystemOperationListenerErrorOccurredParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileSystemOperationListenerErrorOccurredParams(elementsOrVersion);
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
}
