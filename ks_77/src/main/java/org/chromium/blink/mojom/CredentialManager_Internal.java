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
import org.chromium.url.mojom.Url;

class CredentialManager_Internal {
    public static final Interface.Manager<CredentialManager, CredentialManager.Proxy> MANAGER = new Interface.Manager<CredentialManager, CredentialManager.Proxy>() {
        public String getName() {
            return "blink.mojom.CredentialManager";
        }

        public int getVersion() {
            return 0;
        }

        public CredentialManager_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CredentialManager_Internal.Proxy(core, messageReceiver);
        }

        public CredentialManager_Internal.Stub buildStub(Core core, CredentialManager impl) {
            return new CredentialManager_Internal.Stub(core, impl);
        }

        public CredentialManager[] buildArray(int size) {
            return new CredentialManager[size];
        }
    };

    private static final int STORE_ORDINAL = 0;

    private static final int PREVENT_SILENT_ACCESS_ORDINAL = 1;

    private static final int GET_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements CredentialManager.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void store(CredentialInfo credential, CredentialManager.StoreResponse callback) {
            CredentialManager_Internal.CredentialManagerStoreParams _message = new CredentialManager_Internal.CredentialManagerStoreParams();
            _message.credential = credential;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new CredentialManager_Internal.CredentialManagerStoreResponseParamsForwardToCallback(callback));
        }

        public void preventSilentAccess(CredentialManager.PreventSilentAccessResponse callback) {
            CredentialManager_Internal.CredentialManagerPreventSilentAccessParams _message = new CredentialManager_Internal.CredentialManagerPreventSilentAccessParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new CredentialManager_Internal.CredentialManagerPreventSilentAccessResponseParamsForwardToCallback(callback));
        }

        public void get(int mediation, boolean includePasswords, Url[] federations, CredentialManager.GetResponse callback) {
            CredentialManager_Internal.CredentialManagerGetParams _message = new CredentialManager_Internal.CredentialManagerGetParams();
            _message.mediation = mediation;
            _message.includePasswords = includePasswords;
            _message.federations = federations;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new CredentialManager_Internal.CredentialManagerGetResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<CredentialManager> {
        Stub(Core core, CredentialManager impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CredentialManager_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                CredentialManager_Internal.CredentialManagerStoreParams credentialManagerStoreParams;
                CredentialManager_Internal.CredentialManagerGetParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), CredentialManager_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        credentialManagerStoreParams = CredentialManager_Internal.CredentialManagerStoreParams.deserialize(messageWithHeader.getPayload());
                        ((CredentialManager)getImpl()).store(credentialManagerStoreParams.credential, new CredentialManager_Internal.CredentialManagerStoreResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        CredentialManager_Internal.CredentialManagerPreventSilentAccessParams.deserialize(messageWithHeader.getPayload());
                        ((CredentialManager)getImpl()).preventSilentAccess(new CredentialManager_Internal.CredentialManagerPreventSilentAccessResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        data = CredentialManager_Internal.CredentialManagerGetParams.deserialize(messageWithHeader.getPayload());
                        ((CredentialManager)getImpl()).get(data.mediation, data.includePasswords, data.federations, new CredentialManager_Internal.CredentialManagerGetResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CredentialManagerStoreParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CredentialInfo credential;

        private CredentialManagerStoreParams(int version) {
            super(16, version);
        }

        public CredentialManagerStoreParams() {
            this(0);
        }

        public static CredentialManagerStoreParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CredentialManagerStoreParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CredentialManagerStoreParams decode(Decoder decoder0) {
            CredentialManagerStoreParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CredentialManagerStoreParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.credential = CredentialInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.credential, 8, false);
        }
    }

    static final class CredentialManagerStoreResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private CredentialManagerStoreResponseParams(int version) {
            super(8, version);
        }

        public CredentialManagerStoreResponseParams() {
            this(0);
        }

        public static CredentialManagerStoreResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CredentialManagerStoreResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CredentialManagerStoreResponseParams decode(Decoder decoder0) {
            CredentialManagerStoreResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CredentialManagerStoreResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class CredentialManagerStoreResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CredentialManager.StoreResponse mCallback;

        CredentialManagerStoreResponseParamsForwardToCallback(CredentialManager.StoreResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CredentialManagerStoreResponseParamsProxyToResponder implements CredentialManager.StoreResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CredentialManagerStoreResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            CredentialManager_Internal.CredentialManagerStoreResponseParams _response = new CredentialManager_Internal.CredentialManagerStoreResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CredentialManagerPreventSilentAccessParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private CredentialManagerPreventSilentAccessParams(int version) {
            super(8, version);
        }

        public CredentialManagerPreventSilentAccessParams() {
            this(0);
        }

        public static CredentialManagerPreventSilentAccessParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CredentialManagerPreventSilentAccessParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CredentialManagerPreventSilentAccessParams decode(Decoder decoder0) {
            CredentialManagerPreventSilentAccessParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CredentialManagerPreventSilentAccessParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class CredentialManagerPreventSilentAccessResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private CredentialManagerPreventSilentAccessResponseParams(int version) {
            super(8, version);
        }

        public CredentialManagerPreventSilentAccessResponseParams() {
            this(0);
        }

        public static CredentialManagerPreventSilentAccessResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CredentialManagerPreventSilentAccessResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CredentialManagerPreventSilentAccessResponseParams decode(Decoder decoder0) {
            CredentialManagerPreventSilentAccessResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CredentialManagerPreventSilentAccessResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class CredentialManagerPreventSilentAccessResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CredentialManager.PreventSilentAccessResponse mCallback;

        CredentialManagerPreventSilentAccessResponseParamsForwardToCallback(CredentialManager.PreventSilentAccessResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CredentialManagerPreventSilentAccessResponseParamsProxyToResponder implements CredentialManager.PreventSilentAccessResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CredentialManagerPreventSilentAccessResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            CredentialManager_Internal.CredentialManagerPreventSilentAccessResponseParams _response = new CredentialManager_Internal.CredentialManagerPreventSilentAccessResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class CredentialManagerGetParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int mediation;

        public boolean includePasswords;

        public Url[] federations;

        private CredentialManagerGetParams(int version) {
            super(24, version);
        }

        public CredentialManagerGetParams() {
            this(0);
        }

        public static CredentialManagerGetParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CredentialManagerGetParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CredentialManagerGetParams decode(Decoder decoder0) {
            CredentialManagerGetParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CredentialManagerGetParams(elementsOrVersion);
                result.mediation = decoder0.readInt(8);
                CredentialMediationRequirement.validate(result.mediation);
                result.includePasswords = decoder0.readBoolean(12, 0);
                Decoder decoder1 = decoder0.readPointer(16, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.federations = new Url[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.federations[i1] = Url.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.mediation, 8);
            encoder0.encode(this.includePasswords, 12, 0);
            if (this.federations == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.federations.length, 16, -1);
                for (int i0 = 0; i0 < this.federations.length; i0++)
                    encoder1.encode((Struct)this.federations[i0], 8 + 8 * i0, false);
            }
        }
    }

    static final class CredentialManagerGetResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public CredentialInfo credential;

        private CredentialManagerGetResponseParams(int version) {
            super(24, version);
        }

        public CredentialManagerGetResponseParams() {
            this(0);
        }

        public static CredentialManagerGetResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CredentialManagerGetResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CredentialManagerGetResponseParams decode(Decoder decoder0) {
            CredentialManagerGetResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CredentialManagerGetResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                CredentialManagerError.validate(result.error);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.credential = CredentialInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.credential, 16, true);
        }
    }

    static class CredentialManagerGetResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CredentialManager.GetResponse mCallback;

        CredentialManagerGetResponseParamsForwardToCallback(CredentialManager.GetResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                CredentialManager_Internal.CredentialManagerGetResponseParams response = CredentialManager_Internal.CredentialManagerGetResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.credential);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CredentialManagerGetResponseParamsProxyToResponder implements CredentialManager.GetResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CredentialManagerGetResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, CredentialInfo credential) {
            CredentialManager_Internal.CredentialManagerGetResponseParams _response = new CredentialManager_Internal.CredentialManagerGetResponseParams();
            _response.error = error.intValue();
            _response.credential = credential;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
