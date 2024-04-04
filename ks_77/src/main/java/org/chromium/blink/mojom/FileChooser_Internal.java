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
import org.chromium.mojo_base.mojom.FilePath;

class FileChooser_Internal {
    public static final Interface.Manager<FileChooser, FileChooser.Proxy> MANAGER = new Interface.Manager<FileChooser, FileChooser.Proxy>() {
        public String getName() {
            return "blink.mojom.FileChooser";
        }

        public int getVersion() {
            return 0;
        }

        public FileChooser_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new FileChooser_Internal.Proxy(core, messageReceiver);
        }

        public FileChooser_Internal.Stub buildStub(Core core, FileChooser impl) {
            return new FileChooser_Internal.Stub(core, impl);
        }

        public FileChooser[] buildArray(int size) {
            return new FileChooser[size];
        }
    };

    private static final int OPEN_FILE_CHOOSER_ORDINAL = 0;

    private static final int ENUMERATE_CHOSEN_DIRECTORY_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements FileChooser.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void openFileChooser(FileChooserParams params, FileChooser.OpenFileChooserResponse callback) {
            FileChooser_Internal.FileChooserOpenFileChooserParams _message = new FileChooser_Internal.FileChooserOpenFileChooserParams();
            _message.params = params;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new FileChooser_Internal.FileChooserOpenFileChooserResponseParamsForwardToCallback(callback));
        }

        public void enumerateChosenDirectory(FilePath directoryPath, FileChooser.EnumerateChosenDirectoryResponse callback) {
            FileChooser_Internal.FileChooserEnumerateChosenDirectoryParams _message = new FileChooser_Internal.FileChooserEnumerateChosenDirectoryParams();
            _message.directoryPath = directoryPath;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new FileChooser_Internal.FileChooserEnumerateChosenDirectoryResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<FileChooser> {
        Stub(Core core, FileChooser impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FileChooser_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                FileChooser_Internal.FileChooserOpenFileChooserParams fileChooserOpenFileChooserParams;
                FileChooser_Internal.FileChooserEnumerateChosenDirectoryParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), FileChooser_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        fileChooserOpenFileChooserParams = FileChooser_Internal.FileChooserOpenFileChooserParams.deserialize(messageWithHeader.getPayload());
                        ((FileChooser)getImpl()).openFileChooser(fileChooserOpenFileChooserParams.params, new FileChooser_Internal.FileChooserOpenFileChooserResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        data = FileChooser_Internal.FileChooserEnumerateChosenDirectoryParams.deserialize(messageWithHeader.getPayload());
                        ((FileChooser)getImpl()).enumerateChosenDirectory(data.directoryPath, new FileChooser_Internal.FileChooserEnumerateChosenDirectoryResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class FileChooserOpenFileChooserParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FileChooserParams params;

        private FileChooserOpenFileChooserParams(int version) {
            super(16, version);
        }

        public FileChooserOpenFileChooserParams() {
            this(0);
        }

        public static FileChooserOpenFileChooserParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileChooserOpenFileChooserParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileChooserOpenFileChooserParams decode(Decoder decoder0) {
            FileChooserOpenFileChooserParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileChooserOpenFileChooserParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.params = FileChooserParams.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.params, 8, false);
        }
    }

    static final class FileChooserOpenFileChooserResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FileChooserResult result;

        private FileChooserOpenFileChooserResponseParams(int version) {
            super(16, version);
        }

        public FileChooserOpenFileChooserResponseParams() {
            this(0);
        }

        public static FileChooserOpenFileChooserResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileChooserOpenFileChooserResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileChooserOpenFileChooserResponseParams decode(Decoder decoder0) {
            FileChooserOpenFileChooserResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileChooserOpenFileChooserResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.result = FileChooserResult.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, true);
        }
    }

    static class FileChooserOpenFileChooserResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileChooser.OpenFileChooserResponse mCallback;

        FileChooserOpenFileChooserResponseParamsForwardToCallback(FileChooser.OpenFileChooserResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                FileChooser_Internal.FileChooserOpenFileChooserResponseParams response = FileChooser_Internal.FileChooserOpenFileChooserResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileChooserOpenFileChooserResponseParamsProxyToResponder implements FileChooser.OpenFileChooserResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileChooserOpenFileChooserResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(FileChooserResult result) {
            FileChooser_Internal.FileChooserOpenFileChooserResponseParams _response = new FileChooser_Internal.FileChooserOpenFileChooserResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class FileChooserEnumerateChosenDirectoryParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FilePath directoryPath;

        private FileChooserEnumerateChosenDirectoryParams(int version) {
            super(16, version);
        }

        public FileChooserEnumerateChosenDirectoryParams() {
            this(0);
        }

        public static FileChooserEnumerateChosenDirectoryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileChooserEnumerateChosenDirectoryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileChooserEnumerateChosenDirectoryParams decode(Decoder decoder0) {
            FileChooserEnumerateChosenDirectoryParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileChooserEnumerateChosenDirectoryParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.directoryPath = FilePath.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.directoryPath, 8, false);
        }
    }

    static final class FileChooserEnumerateChosenDirectoryResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FileChooserResult result;

        private FileChooserEnumerateChosenDirectoryResponseParams(int version) {
            super(16, version);
        }

        public FileChooserEnumerateChosenDirectoryResponseParams() {
            this(0);
        }

        public static FileChooserEnumerateChosenDirectoryResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileChooserEnumerateChosenDirectoryResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileChooserEnumerateChosenDirectoryResponseParams decode(Decoder decoder0) {
            FileChooserEnumerateChosenDirectoryResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileChooserEnumerateChosenDirectoryResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.result = FileChooserResult.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, true);
        }
    }

    static class FileChooserEnumerateChosenDirectoryResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileChooser.EnumerateChosenDirectoryResponse mCallback;

        FileChooserEnumerateChosenDirectoryResponseParamsForwardToCallback(FileChooser.EnumerateChosenDirectoryResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                FileChooser_Internal.FileChooserEnumerateChosenDirectoryResponseParams response = FileChooser_Internal.FileChooserEnumerateChosenDirectoryResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileChooserEnumerateChosenDirectoryResponseParamsProxyToResponder implements FileChooser.EnumerateChosenDirectoryResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileChooserEnumerateChosenDirectoryResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(FileChooserResult result) {
            FileChooser_Internal.FileChooserEnumerateChosenDirectoryResponseParams _response = new FileChooser_Internal.FileChooserEnumerateChosenDirectoryResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
