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
import org.chromium.mojo_base.mojom.FileInfo;
import org.chromium.mojo_base.mojom.FilePath;

class FileUtilitiesHost_Internal {
    public static final Interface.Manager<FileUtilitiesHost, FileUtilitiesHost.Proxy> MANAGER = new Interface.Manager<FileUtilitiesHost, FileUtilitiesHost.Proxy>() {
        public String getName() {
            return "blink.mojom.FileUtilitiesHost";
        }

        public int getVersion() {
            return 0;
        }

        public FileUtilitiesHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new FileUtilitiesHost_Internal.Proxy(core, messageReceiver);
        }

        public FileUtilitiesHost_Internal.Stub buildStub(Core core, FileUtilitiesHost impl) {
            return new FileUtilitiesHost_Internal.Stub(core, impl);
        }

        public FileUtilitiesHost[] buildArray(int size) {
            return new FileUtilitiesHost[size];
        }
    };

    private static final int GET_FILE_INFO_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements FileUtilitiesHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getFileInfo(FilePath path, FileUtilitiesHost.GetFileInfoResponse callback) {
            FileUtilitiesHost_Internal.FileUtilitiesHostGetFileInfoParams _message = new FileUtilitiesHost_Internal.FileUtilitiesHostGetFileInfoParams();
            _message.path = path;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new FileUtilitiesHost_Internal.FileUtilitiesHostGetFileInfoResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<FileUtilitiesHost> {
        Stub(Core core, FileUtilitiesHost impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(FileUtilitiesHost_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                FileUtilitiesHost_Internal.FileUtilitiesHostGetFileInfoParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), FileUtilitiesHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = FileUtilitiesHost_Internal.FileUtilitiesHostGetFileInfoParams.deserialize(messageWithHeader.getPayload());
                        ((FileUtilitiesHost)getImpl()).getFileInfo(data.path, new FileUtilitiesHost_Internal.FileUtilitiesHostGetFileInfoResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class FileUtilitiesHostGetFileInfoParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FilePath path;

        private FileUtilitiesHostGetFileInfoParams(int version) {
            super(16, version);
        }

        public FileUtilitiesHostGetFileInfoParams() {
            this(0);
        }

        public static FileUtilitiesHostGetFileInfoParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileUtilitiesHostGetFileInfoParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileUtilitiesHostGetFileInfoParams decode(Decoder decoder0) {
            FileUtilitiesHostGetFileInfoParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileUtilitiesHostGetFileInfoParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.path = FilePath.decode(decoder1);
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

    static final class FileUtilitiesHostGetFileInfoResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public FileInfo result;

        private FileUtilitiesHostGetFileInfoResponseParams(int version) {
            super(16, version);
        }

        public FileUtilitiesHostGetFileInfoResponseParams() {
            this(0);
        }

        public static FileUtilitiesHostGetFileInfoResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static FileUtilitiesHostGetFileInfoResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static FileUtilitiesHostGetFileInfoResponseParams decode(Decoder decoder0) {
            FileUtilitiesHostGetFileInfoResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new FileUtilitiesHostGetFileInfoResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.result = FileInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.result, 8, true);
        }
    }

    static class FileUtilitiesHostGetFileInfoResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final FileUtilitiesHost.GetFileInfoResponse mCallback;

        FileUtilitiesHostGetFileInfoResponseParamsForwardToCallback(FileUtilitiesHost.GetFileInfoResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                FileUtilitiesHost_Internal.FileUtilitiesHostGetFileInfoResponseParams response = FileUtilitiesHost_Internal.FileUtilitiesHostGetFileInfoResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class FileUtilitiesHostGetFileInfoResponseParamsProxyToResponder implements FileUtilitiesHost.GetFileInfoResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        FileUtilitiesHostGetFileInfoResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(FileInfo result) {
            FileUtilitiesHost_Internal.FileUtilitiesHostGetFileInfoResponseParams _response = new FileUtilitiesHost_Internal.FileUtilitiesHostGetFileInfoResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
