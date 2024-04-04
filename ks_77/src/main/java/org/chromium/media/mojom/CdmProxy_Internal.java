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

class CdmProxy_Internal {
    public static final Interface.Manager<CdmProxy, CdmProxy.Proxy> MANAGER = new Interface.Manager<CdmProxy, CdmProxy.Proxy>() {
        public String getName() {
            return "media.mojom.CdmProxy";
        }

        public int getVersion() {
            return 0;
        }

        public CdmProxy_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CdmProxy_Internal.Proxy(core, messageReceiver);
        }

        public CdmProxy_Internal.Stub buildStub(Core core, CdmProxy impl) {
            return new CdmProxy_Internal.Stub(core, impl);
        }

        public CdmProxy[] buildArray(int size) {
            return new CdmProxy[size];
        }
    };

    private static final int INITIALIZE_ORDINAL = 0;

    private static final int PROCESS_ORDINAL = 1;

    private static final int CREATE_MEDIA_CRYPTO_SESSION_ORDINAL = 2;

    private static final int SET_KEY_ORDINAL = 3;

    private static final int REMOVE_KEY_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements CdmProxy.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void initialize(AssociatedInterfaceNotSupported client, CdmProxy.InitializeResponse callback) {
            CdmProxy_Internal.CdmProxyInitializeParams _message = new CdmProxy_Internal.CdmProxyInitializeParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new CdmProxy_Internal.CdmProxyInitializeResponseParamsForwardToCallback(callback));
        }

        public void process(int func, int cryptoSessionId, byte[] inputData, int outputDataSize, CdmProxy.ProcessResponse callback) {
            CdmProxy_Internal.CdmProxyProcessParams _message = new CdmProxy_Internal.CdmProxyProcessParams();
            _message.func = func;
            _message.cryptoSessionId = cryptoSessionId;
            _message.inputData = inputData;
            _message.outputDataSize = outputDataSize;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new CdmProxy_Internal.CdmProxyProcessResponseParamsForwardToCallback(callback));
        }

        public void createMediaCryptoSession(byte[] inputData, CdmProxy.CreateMediaCryptoSessionResponse callback) {
            CdmProxy_Internal.CdmProxyCreateMediaCryptoSessionParams _message = new CdmProxy_Internal.CdmProxyCreateMediaCryptoSessionParams();
            _message.inputData = inputData;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new CdmProxy_Internal.CdmProxyCreateMediaCryptoSessionResponseParamsForwardToCallback(callback));
        }

        public void setKey(int cryptoSessionId, byte[] keyId, int keyType, byte[] keyBlob, CdmProxy.SetKeyResponse callback) {
            CdmProxy_Internal.CdmProxySetKeyParams _message = new CdmProxy_Internal.CdmProxySetKeyParams();
            _message.cryptoSessionId = cryptoSessionId;
            _message.keyId = keyId;
            _message.keyType = keyType;
            _message.keyBlob = keyBlob;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new CdmProxy_Internal.CdmProxySetKeyResponseParamsForwardToCallback(callback));
        }

        public void removeKey(int cryptoSessionId, byte[] keyId, CdmProxy.RemoveKeyResponse callback) {
            CdmProxy_Internal.CdmProxyRemoveKeyParams _message = new CdmProxy_Internal.CdmProxyRemoveKeyParams();
            _message.cryptoSessionId = cryptoSessionId;
            _message.keyId = keyId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new CdmProxy_Internal.CdmProxyRemoveKeyResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<CdmProxy> {
        Stub(Core core, CdmProxy impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CdmProxy_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                CdmProxy_Internal.CdmProxyInitializeParams cdmProxyInitializeParams;
                CdmProxy_Internal.CdmProxyProcessParams cdmProxyProcessParams;
                CdmProxy_Internal.CdmProxyCreateMediaCryptoSessionParams cdmProxyCreateMediaCryptoSessionParams;
                CdmProxy_Internal.CdmProxySetKeyParams cdmProxySetKeyParams;
                CdmProxy_Internal.CdmProxyRemoveKeyParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), CdmProxy_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        cdmProxyInitializeParams = CdmProxy_Internal.CdmProxyInitializeParams.deserialize(messageWithHeader.getPayload());
                        ((CdmProxy)getImpl()).initialize(cdmProxyInitializeParams.client, new CdmProxy_Internal.CdmProxyInitializeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        cdmProxyProcessParams = CdmProxy_Internal.CdmProxyProcessParams.deserialize(messageWithHeader.getPayload());
                        ((CdmProxy)getImpl()).process(cdmProxyProcessParams.func, cdmProxyProcessParams.cryptoSessionId, cdmProxyProcessParams.inputData, cdmProxyProcessParams.outputDataSize, new CdmProxy_Internal.CdmProxyProcessResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        cdmProxyCreateMediaCryptoSessionParams = CdmProxy_Internal.CdmProxyCreateMediaCryptoSessionParams.deserialize(messageWithHeader.getPayload());
                        ((CdmProxy)getImpl()).createMediaCryptoSession(cdmProxyCreateMediaCryptoSessionParams.inputData, new CdmProxy_Internal.CdmProxyCreateMediaCryptoSessionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        cdmProxySetKeyParams = CdmProxy_Internal.CdmProxySetKeyParams.deserialize(messageWithHeader.getPayload());
                        ((CdmProxy)getImpl()).setKey(cdmProxySetKeyParams.cryptoSessionId, cdmProxySetKeyParams.keyId, cdmProxySetKeyParams.keyType, cdmProxySetKeyParams.keyBlob, new CdmProxy_Internal.CdmProxySetKeyResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        data = CdmProxy_Internal.CdmProxyRemoveKeyParams.deserialize(messageWithHeader.getPayload());
                        ((CdmProxy)getImpl()).removeKey(data.cryptoSessionId, data.keyId, new CdmProxy_Internal.CdmProxyRemoveKeyResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CdmProxyInitializeParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported client;

        private CdmProxyInitializeParams(int version) {
            super(16, version);
        }

        public CdmProxyInitializeParams() {
            this(0);
        }

        public static CdmProxyInitializeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmProxyInitializeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmProxyInitializeParams decode(Decoder decoder0) {
            CdmProxyInitializeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmProxyInitializeParams(elementsOrVersion);
                result.client = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.client, 8, false);
        }
    }

    static final class CdmProxyInitializeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public int protocol;

        public int cryptoSessionId;

        public int cdmId;

        private CdmProxyInitializeResponseParams(int version) {
            super(24, version);
        }

        public CdmProxyInitializeResponseParams() {
            this(0);
        }

        public static CdmProxyInitializeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmProxyInitializeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmProxyInitializeResponseParams decode(Decoder decoder0) {
            CdmProxyInitializeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmProxyInitializeResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                CdmProxy.Status.validate(result.status);
                result.protocol = decoder0.readInt(12);
                CdmProxy.Protocol.validate(result.protocol);
                result.cryptoSessionId = decoder0.readInt(16);
                result.cdmId = decoder0.readInt(20);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.protocol, 12);
            encoder0.encode(this.cryptoSessionId, 16);
            encoder0.encode(this.cdmId, 20);
        }
    }

    static class CdmProxyInitializeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CdmProxy.InitializeResponse mCallback;

        CdmProxyInitializeResponseParamsForwardToCallback(CdmProxy.InitializeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                CdmProxy_Internal.CdmProxyInitializeResponseParams response = CdmProxy_Internal.CdmProxyInitializeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), Integer.valueOf(response.protocol), Integer.valueOf(response.cryptoSessionId), Integer.valueOf(response.cdmId));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CdmProxyInitializeResponseParamsProxyToResponder implements CdmProxy.InitializeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CdmProxyInitializeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, Integer protocol, Integer cryptoSessionId, Integer cdmId) {
            CdmProxy_Internal.CdmProxyInitializeResponseParams _response = new CdmProxy_Internal.CdmProxyInitializeResponseParams();
            _response.status = status.intValue();
            _response.protocol = protocol.intValue();
            _response.cryptoSessionId = cryptoSessionId.intValue();
            _response.cdmId = cdmId.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CdmProxyProcessParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int func;

        public int cryptoSessionId;

        public byte[] inputData;

        public int outputDataSize;

        private CdmProxyProcessParams(int version) {
            super(32, version);
        }

        public CdmProxyProcessParams() {
            this(0);
        }

        public static CdmProxyProcessParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmProxyProcessParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmProxyProcessParams decode(Decoder decoder0) {
            CdmProxyProcessParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmProxyProcessParams(elementsOrVersion);
                result.func = decoder0.readInt(8);
                CdmProxy.Function.validate(result.func);
                result.cryptoSessionId = decoder0.readInt(12);
                result.inputData = decoder0.readBytes(16, 0, -1);
                result.outputDataSize = decoder0.readInt(24);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.func, 8);
            encoder0.encode(this.cryptoSessionId, 12);
            encoder0.encode(this.inputData, 16, 0, -1);
            encoder0.encode(this.outputDataSize, 24);
        }
    }

    static final class CdmProxyProcessResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public byte[] outputData;

        private CdmProxyProcessResponseParams(int version) {
            super(24, version);
        }

        public CdmProxyProcessResponseParams() {
            this(0);
        }

        public static CdmProxyProcessResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmProxyProcessResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmProxyProcessResponseParams decode(Decoder decoder0) {
            CdmProxyProcessResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmProxyProcessResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                CdmProxy.Status.validate(result.status);
                result.outputData = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.outputData, 16, 0, -1);
        }
    }

    static class CdmProxyProcessResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CdmProxy.ProcessResponse mCallback;

        CdmProxyProcessResponseParamsForwardToCallback(CdmProxy.ProcessResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                CdmProxy_Internal.CdmProxyProcessResponseParams response = CdmProxy_Internal.CdmProxyProcessResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), response.outputData);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CdmProxyProcessResponseParamsProxyToResponder implements CdmProxy.ProcessResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CdmProxyProcessResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, byte[] outputData) {
            CdmProxy_Internal.CdmProxyProcessResponseParams _response = new CdmProxy_Internal.CdmProxyProcessResponseParams();
            _response.status = status.intValue();
            _response.outputData = outputData;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CdmProxyCreateMediaCryptoSessionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte[] inputData;

        private CdmProxyCreateMediaCryptoSessionParams(int version) {
            super(16, version);
        }

        public CdmProxyCreateMediaCryptoSessionParams() {
            this(0);
        }

        public static CdmProxyCreateMediaCryptoSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmProxyCreateMediaCryptoSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmProxyCreateMediaCryptoSessionParams decode(Decoder decoder0) {
            CdmProxyCreateMediaCryptoSessionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmProxyCreateMediaCryptoSessionParams(elementsOrVersion);
                result.inputData = decoder0.readBytes(8, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.inputData, 8, 0, -1);
        }
    }

    static final class CdmProxyCreateMediaCryptoSessionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        public int cryptoSessionId;

        public long outputData;

        private CdmProxyCreateMediaCryptoSessionResponseParams(int version) {
            super(24, version);
        }

        public CdmProxyCreateMediaCryptoSessionResponseParams() {
            this(0);
        }

        public static CdmProxyCreateMediaCryptoSessionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmProxyCreateMediaCryptoSessionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmProxyCreateMediaCryptoSessionResponseParams decode(Decoder decoder0) {
            CdmProxyCreateMediaCryptoSessionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmProxyCreateMediaCryptoSessionResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                CdmProxy.Status.validate(result.status);
                result.cryptoSessionId = decoder0.readInt(12);
                result.outputData = decoder0.readLong(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.status, 8);
            encoder0.encode(this.cryptoSessionId, 12);
            encoder0.encode(this.outputData, 16);
        }
    }

    static class CdmProxyCreateMediaCryptoSessionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CdmProxy.CreateMediaCryptoSessionResponse mCallback;

        CdmProxyCreateMediaCryptoSessionResponseParamsForwardToCallback(CdmProxy.CreateMediaCryptoSessionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                CdmProxy_Internal.CdmProxyCreateMediaCryptoSessionResponseParams response = CdmProxy_Internal.CdmProxyCreateMediaCryptoSessionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status), Integer.valueOf(response.cryptoSessionId), Long.valueOf(response.outputData));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CdmProxyCreateMediaCryptoSessionResponseParamsProxyToResponder implements CdmProxy.CreateMediaCryptoSessionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CdmProxyCreateMediaCryptoSessionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status, Integer cryptoSessionId, Long outputData) {
            CdmProxy_Internal.CdmProxyCreateMediaCryptoSessionResponseParams _response = new CdmProxy_Internal.CdmProxyCreateMediaCryptoSessionResponseParams();
            _response.status = status.intValue();
            _response.cryptoSessionId = cryptoSessionId.intValue();
            _response.outputData = outputData.longValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CdmProxySetKeyParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int cryptoSessionId;

        public byte[] keyId;

        public int keyType;

        public byte[] keyBlob;

        private CdmProxySetKeyParams(int version) {
            super(32, version);
        }

        public CdmProxySetKeyParams() {
            this(0);
        }

        public static CdmProxySetKeyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmProxySetKeyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmProxySetKeyParams decode(Decoder decoder0) {
            CdmProxySetKeyParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmProxySetKeyParams(elementsOrVersion);
                result.cryptoSessionId = decoder0.readInt(8);
                result.keyType = decoder0.readInt(12);
                CdmProxy.KeyType.validate(result.keyType);
                result.keyId = decoder0.readBytes(16, 0, -1);
                result.keyBlob = decoder0.readBytes(24, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.cryptoSessionId, 8);
            encoder0.encode(this.keyType, 12);
            encoder0.encode(this.keyId, 16, 0, -1);
            encoder0.encode(this.keyBlob, 24, 0, -1);
        }
    }

    static final class CdmProxySetKeyResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private CdmProxySetKeyResponseParams(int version) {
            super(16, version);
        }

        public CdmProxySetKeyResponseParams() {
            this(0);
        }

        public static CdmProxySetKeyResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmProxySetKeyResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmProxySetKeyResponseParams decode(Decoder decoder0) {
            CdmProxySetKeyResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmProxySetKeyResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                CdmProxy.Status.validate(result.status);
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

    static class CdmProxySetKeyResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CdmProxy.SetKeyResponse mCallback;

        CdmProxySetKeyResponseParamsForwardToCallback(CdmProxy.SetKeyResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                CdmProxy_Internal.CdmProxySetKeyResponseParams response = CdmProxy_Internal.CdmProxySetKeyResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CdmProxySetKeyResponseParamsProxyToResponder implements CdmProxy.SetKeyResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CdmProxySetKeyResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            CdmProxy_Internal.CdmProxySetKeyResponseParams _response = new CdmProxy_Internal.CdmProxySetKeyResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CdmProxyRemoveKeyParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int cryptoSessionId;

        public byte[] keyId;

        private CdmProxyRemoveKeyParams(int version) {
            super(24, version);
        }

        public CdmProxyRemoveKeyParams() {
            this(0);
        }

        public static CdmProxyRemoveKeyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmProxyRemoveKeyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmProxyRemoveKeyParams decode(Decoder decoder0) {
            CdmProxyRemoveKeyParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmProxyRemoveKeyParams(elementsOrVersion);
                result.cryptoSessionId = decoder0.readInt(8);
                result.keyId = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.cryptoSessionId, 8);
            encoder0.encode(this.keyId, 16, 0, -1);
        }
    }

    static final class CdmProxyRemoveKeyResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private CdmProxyRemoveKeyResponseParams(int version) {
            super(16, version);
        }

        public CdmProxyRemoveKeyResponseParams() {
            this(0);
        }

        public static CdmProxyRemoveKeyResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CdmProxyRemoveKeyResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CdmProxyRemoveKeyResponseParams decode(Decoder decoder0) {
            CdmProxyRemoveKeyResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CdmProxyRemoveKeyResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                CdmProxy.Status.validate(result.status);
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

    static class CdmProxyRemoveKeyResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CdmProxy.RemoveKeyResponse mCallback;

        CdmProxyRemoveKeyResponseParamsForwardToCallback(CdmProxy.RemoveKeyResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                CdmProxy_Internal.CdmProxyRemoveKeyResponseParams response = CdmProxy_Internal.CdmProxyRemoveKeyResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CdmProxyRemoveKeyResponseParamsProxyToResponder implements CdmProxy.RemoveKeyResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CdmProxyRemoveKeyResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            CdmProxy_Internal.CdmProxyRemoveKeyResponseParams _response = new CdmProxy_Internal.CdmProxyRemoveKeyResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
