package org.chromium.media.mojom;

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

class CdmFile_Internal {
    public static final Interface.Manager<CdmFile, CdmFile.Proxy> MANAGER = new Interface.Manager<CdmFile, CdmFile.Proxy>() {
        public String getName() {
            return "media.mojom.CdmFile";
        }

        public int getVersion() {
            return 0;
        }

        public CdmFile_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CdmFile_Internal.Proxy(core, messageReceiver);
        }

        public CdmFile_Internal.Stub buildStub(Core core, CdmFile impl) {
            return new CdmFile_Internal.Stub(core, impl);
        }

        public CdmFile[] buildArray(int size) {
            return new CdmFile[size];
        }
    };

    private static final int READ_ORDINAL = 0;

    private static final int WRITE_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements CdmFile.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void read(CdmFile.ReadResponse callback) {
            CdmFile_Internal.CdmFileReadParams _message = new CdmFile_Internal.CdmFileReadParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new CdmFile_Internal.CdmFileReadResponseParamsForwardToCallback(callback));
        }

        public void write(byte[] data, CdmFile.WriteResponse callback) {
            CdmFile_Internal.CdmFileWriteParams _message = new CdmFile_Internal.CdmFileWriteParams();
            _message.data = data;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new CdmFile_Internal.CdmFileWriteResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<CdmFile> {
        Stub(Core core, CdmFile impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CdmFile_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                CdmFile_Internal.CdmFileWriteParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), CdmFile_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        CdmFile_Internal.CdmFileReadParams.deserialize(messageWithHeader.getPayload());
                        ((CdmFile)getImpl()).read(new CdmFile_Internal.CdmFileReadResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        data = CdmFile_Internal.CdmFileWriteParams.deserialize(messageWithHeader.getPayload());
                        ((CdmFile)getImpl()).write(data.data, new CdmFile_Internal.CdmFileWriteResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CdmFileReadParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private CdmFileReadParams(int version) {
            super(8, version);
        }

        public CdmFileReadParams() {
            this(0);
        }

        public static CdmFileReadParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmFileReadParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmFileReadParams decode(Decoder decoder0) {
            CdmFileReadParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmFileReadParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class CdmFileReadResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public byte[] data;

        private CdmFileReadResponseParams(int version) {
            super(24, version);
        }

        public CdmFileReadResponseParams() {
            this(0);
        }

        public static CdmFileReadResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmFileReadResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmFileReadResponseParams decode(Decoder decoder0) {
            CdmFileReadResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmFileReadResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                CdmFile.Status.validate(result.status);
                result.data = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.data, 16, 0, -1);
        }
    }

    static class CdmFileReadResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CdmFile.ReadResponse mCallback;

        CdmFileReadResponseParamsForwardToCallback(CdmFile.ReadResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                CdmFile_Internal.CdmFileReadResponseParams response = CdmFile_Internal.CdmFileReadResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.data);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CdmFileReadResponseParamsProxyToResponder implements CdmFile.ReadResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CdmFileReadResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, byte[] data) {
            CdmFile_Internal.CdmFileReadResponseParams _response = new CdmFile_Internal.CdmFileReadResponseParams();
            _response.status = status.intValue();
            _response.data = data;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CdmFileWriteParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte[] data;

        private CdmFileWriteParams(int version) {
            super(16, version);
        }

        public CdmFileWriteParams() {
            this(0);
        }

        public static CdmFileWriteParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmFileWriteParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmFileWriteParams decode(Decoder decoder0) {
            CdmFileWriteParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmFileWriteParams(elementsOrVersion);
                result.data = decoder0.readBytes(8, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.data, 8, 0, -1);
        }
    }

    static final class CdmFileWriteResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private CdmFileWriteResponseParams(int version) {
            super(16, version);
        }

        public CdmFileWriteResponseParams() {
            this(0);
        }

        public static CdmFileWriteResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmFileWriteResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmFileWriteResponseParams decode(Decoder decoder0) {
            CdmFileWriteResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmFileWriteResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                CdmFile.Status.validate(result.status);
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

    static class CdmFileWriteResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CdmFile.WriteResponse mCallback;

        CdmFileWriteResponseParamsForwardToCallback(CdmFile.WriteResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                CdmFile_Internal.CdmFileWriteResponseParams response = CdmFile_Internal.CdmFileWriteResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CdmFileWriteResponseParamsProxyToResponder implements CdmFile.WriteResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CdmFileWriteResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            CdmFile_Internal.CdmFileWriteResponseParams _response = new CdmFile_Internal.CdmFileWriteResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
