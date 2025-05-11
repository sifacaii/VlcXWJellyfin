package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
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

class CdmStorage_Internal {
    public static final Interface.Manager<CdmStorage, CdmStorage.Proxy> MANAGER = new Interface.Manager<CdmStorage, CdmStorage.Proxy>() {
        public String getName() {
            return "media.mojom.CdmStorage";
        }

        public int getVersion() {
            return 0;
        }

        public CdmStorage_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CdmStorage_Internal.Proxy(core, messageReceiver);
        }

        public CdmStorage_Internal.Stub buildStub(Core core, CdmStorage impl) {
            return new CdmStorage_Internal.Stub(core, impl);
        }

        public CdmStorage[] buildArray(int size) {
            return new CdmStorage[size];
        }
    };

    private static final int OPEN_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements CdmStorage.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void open(String fileName, CdmStorage.OpenResponse callback) {
            CdmStorage_Internal.CdmStorageOpenParams _message = new CdmStorage_Internal.CdmStorageOpenParams();
            _message.fileName = fileName;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new CdmStorage_Internal.CdmStorageOpenResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<CdmStorage> {
        Stub(Core core, CdmStorage impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CdmStorage_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                CdmStorage_Internal.CdmStorageOpenParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), CdmStorage_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = CdmStorage_Internal.CdmStorageOpenParams.deserialize(messageWithHeader.getPayload());
                        ((CdmStorage)getImpl()).open(data.fileName, new CdmStorage_Internal.CdmStorageOpenResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CdmStorageOpenParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String fileName;

        private CdmStorageOpenParams(int version) {
            super(16, version);
        }

        public CdmStorageOpenParams() {
            this(0);
        }

        public static CdmStorageOpenParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmStorageOpenParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmStorageOpenParams decode(Decoder decoder0) {
            CdmStorageOpenParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmStorageOpenParams(elementsOrVersion);
                result.fileName = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.fileName, 8, false);
        }
    }

    static final class CdmStorageOpenResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public AssociatedInterfaceNotSupported cdmFile;

        private CdmStorageOpenResponseParams(int version) {
            super(24, version);
        }

        public CdmStorageOpenResponseParams() {
            this(0);
        }

        public static CdmStorageOpenResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmStorageOpenResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmStorageOpenResponseParams decode(Decoder decoder0) {
            CdmStorageOpenResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmStorageOpenResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                CdmStorage.Status.validate(result.status);
                result.cdmFile = decoder0.readAssociatedServiceInterfaceNotSupported(12, true);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.cdmFile, 12, true);
        }
    }

    static class CdmStorageOpenResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CdmStorage.OpenResponse mCallback;

        CdmStorageOpenResponseParamsForwardToCallback(CdmStorage.OpenResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                CdmStorage_Internal.CdmStorageOpenResponseParams response = CdmStorage_Internal.CdmStorageOpenResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.cdmFile);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CdmStorageOpenResponseParamsProxyToResponder implements CdmStorage.OpenResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CdmStorageOpenResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, AssociatedInterfaceNotSupported cdmFile) {
            CdmStorage_Internal.CdmStorageOpenResponseParams _response = new CdmStorage_Internal.CdmStorageOpenResponseParams();
            _response.status = status.intValue();
            _response.cdmFile = cdmFile;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
