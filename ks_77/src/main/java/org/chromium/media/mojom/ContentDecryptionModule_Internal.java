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
import org.chromium.url.mojom.Origin;

class ContentDecryptionModule_Internal {
    public static final Interface.Manager<ContentDecryptionModule, ContentDecryptionModule.Proxy> MANAGER = new Interface.Manager<ContentDecryptionModule, ContentDecryptionModule.Proxy>() {
        public String getName() {
            return "media.mojom.ContentDecryptionModule";
        }

        public int getVersion() {
            return 0;
        }

        public ContentDecryptionModule_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ContentDecryptionModule_Internal.Proxy(core, messageReceiver);
        }

        public ContentDecryptionModule_Internal.Stub buildStub(Core core, ContentDecryptionModule impl) {
            return new ContentDecryptionModule_Internal.Stub(core, impl);
        }

        public ContentDecryptionModule[] buildArray(int size) {
            return new ContentDecryptionModule[size];
        }
    };

    private static final int SET_CLIENT_ORDINAL = 0;

    private static final int INITIALIZE_ORDINAL = 1;

    private static final int SET_SERVER_CERTIFICATE_ORDINAL = 2;

    private static final int GET_STATUS_FOR_POLICY_ORDINAL = 3;

    private static final int CREATE_SESSION_AND_GENERATE_REQUEST_ORDINAL = 4;

    private static final int LOAD_SESSION_ORDINAL = 5;

    private static final int UPDATE_SESSION_ORDINAL = 6;

    private static final int CLOSE_SESSION_ORDINAL = 7;

    private static final int REMOVE_SESSION_ORDINAL = 8;

    static final class Proxy extends Interface.AbstractProxy implements ContentDecryptionModule.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setClient(AssociatedInterfaceNotSupported client) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleSetClientParams _message = new ContentDecryptionModule_Internal.ContentDecryptionModuleSetClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void initialize(String keySystem, Origin securityOrigin, CdmConfig cdmConfig, ContentDecryptionModule.InitializeResponse callback) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleInitializeParams _message = new ContentDecryptionModule_Internal.ContentDecryptionModuleInitializeParams();
            _message.keySystem = keySystem;
            _message.securityOrigin = securityOrigin;
            _message.cdmConfig = cdmConfig;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new ContentDecryptionModule_Internal.ContentDecryptionModuleInitializeResponseParamsForwardToCallback(callback));
        }

        public void setServerCertificate(byte[] certificateData, ContentDecryptionModule.SetServerCertificateResponse callback) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleSetServerCertificateParams _message = new ContentDecryptionModule_Internal.ContentDecryptionModuleSetServerCertificateParams();
            _message.certificateData = certificateData;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new ContentDecryptionModule_Internal.ContentDecryptionModuleSetServerCertificateResponseParamsForwardToCallback(callback));
        }

        public void getStatusForPolicy(int minHdcpVersion, ContentDecryptionModule.GetStatusForPolicyResponse callback) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleGetStatusForPolicyParams _message = new ContentDecryptionModule_Internal.ContentDecryptionModuleGetStatusForPolicyParams();
            _message.minHdcpVersion = minHdcpVersion;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new ContentDecryptionModule_Internal.ContentDecryptionModuleGetStatusForPolicyResponseParamsForwardToCallback(callback));
        }

        public void createSessionAndGenerateRequest(int sessionType, int initDataType, byte[] initData, ContentDecryptionModule.CreateSessionAndGenerateRequestResponse callback) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleCreateSessionAndGenerateRequestParams _message = new ContentDecryptionModule_Internal.ContentDecryptionModuleCreateSessionAndGenerateRequestParams();
            _message.sessionType = sessionType;
            _message.initDataType = initDataType;
            _message.initData = initData;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new ContentDecryptionModule_Internal.ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParamsForwardToCallback(callback));
        }

        public void loadSession(int sessionType, String sessionId, ContentDecryptionModule.LoadSessionResponse callback) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleLoadSessionParams _message = new ContentDecryptionModule_Internal.ContentDecryptionModuleLoadSessionParams();
            _message.sessionType = sessionType;
            _message.sessionId = sessionId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new ContentDecryptionModule_Internal.ContentDecryptionModuleLoadSessionResponseParamsForwardToCallback(callback));
        }

        public void updateSession(String sessionId, byte[] response, ContentDecryptionModule.UpdateSessionResponse callback) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleUpdateSessionParams _message = new ContentDecryptionModule_Internal.ContentDecryptionModuleUpdateSessionParams();
            _message.sessionId = sessionId;
            _message.response = response;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new ContentDecryptionModule_Internal.ContentDecryptionModuleUpdateSessionResponseParamsForwardToCallback(callback));
        }

        public void closeSession(String sessionId, ContentDecryptionModule.CloseSessionResponse callback) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleCloseSessionParams _message = new ContentDecryptionModule_Internal.ContentDecryptionModuleCloseSessionParams();
            _message.sessionId = sessionId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new ContentDecryptionModule_Internal.ContentDecryptionModuleCloseSessionResponseParamsForwardToCallback(callback));
        }

        public void removeSession(String sessionId, ContentDecryptionModule.RemoveSessionResponse callback) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleRemoveSessionParams _message = new ContentDecryptionModule_Internal.ContentDecryptionModuleRemoveSessionParams();
            _message.sessionId = sessionId;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)), new ContentDecryptionModule_Internal.ContentDecryptionModuleRemoveSessionResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<ContentDecryptionModule> {
        Stub(Core core, ContentDecryptionModule impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ContentDecryptionModule_Internal.ContentDecryptionModuleSetClientParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ContentDecryptionModule_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = ContentDecryptionModule_Internal.ContentDecryptionModuleSetClientParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModule)getImpl()).setClient(data.client);
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
                ContentDecryptionModule_Internal.ContentDecryptionModuleInitializeParams contentDecryptionModuleInitializeParams;
                ContentDecryptionModule_Internal.ContentDecryptionModuleSetServerCertificateParams contentDecryptionModuleSetServerCertificateParams;
                ContentDecryptionModule_Internal.ContentDecryptionModuleGetStatusForPolicyParams contentDecryptionModuleGetStatusForPolicyParams;
                ContentDecryptionModule_Internal.ContentDecryptionModuleCreateSessionAndGenerateRequestParams contentDecryptionModuleCreateSessionAndGenerateRequestParams;
                ContentDecryptionModule_Internal.ContentDecryptionModuleLoadSessionParams contentDecryptionModuleLoadSessionParams;
                ContentDecryptionModule_Internal.ContentDecryptionModuleUpdateSessionParams contentDecryptionModuleUpdateSessionParams;
                ContentDecryptionModule_Internal.ContentDecryptionModuleCloseSessionParams contentDecryptionModuleCloseSessionParams;
                ContentDecryptionModule_Internal.ContentDecryptionModuleRemoveSessionParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), ContentDecryptionModule_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        contentDecryptionModuleInitializeParams = ContentDecryptionModule_Internal.ContentDecryptionModuleInitializeParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModule)getImpl()).initialize(contentDecryptionModuleInitializeParams.keySystem, contentDecryptionModuleInitializeParams.securityOrigin, contentDecryptionModuleInitializeParams.cdmConfig, new ContentDecryptionModule_Internal.ContentDecryptionModuleInitializeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        contentDecryptionModuleSetServerCertificateParams = ContentDecryptionModule_Internal.ContentDecryptionModuleSetServerCertificateParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModule)getImpl()).setServerCertificate(contentDecryptionModuleSetServerCertificateParams.certificateData, new ContentDecryptionModule_Internal.ContentDecryptionModuleSetServerCertificateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        contentDecryptionModuleGetStatusForPolicyParams = ContentDecryptionModule_Internal.ContentDecryptionModuleGetStatusForPolicyParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModule)getImpl()).getStatusForPolicy(contentDecryptionModuleGetStatusForPolicyParams.minHdcpVersion, new ContentDecryptionModule_Internal.ContentDecryptionModuleGetStatusForPolicyResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        contentDecryptionModuleCreateSessionAndGenerateRequestParams = ContentDecryptionModule_Internal.ContentDecryptionModuleCreateSessionAndGenerateRequestParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModule)getImpl()).createSessionAndGenerateRequest(contentDecryptionModuleCreateSessionAndGenerateRequestParams.sessionType, contentDecryptionModuleCreateSessionAndGenerateRequestParams.initDataType, contentDecryptionModuleCreateSessionAndGenerateRequestParams.initData, new ContentDecryptionModule_Internal.ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        contentDecryptionModuleLoadSessionParams = ContentDecryptionModule_Internal.ContentDecryptionModuleLoadSessionParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModule)getImpl()).loadSession(contentDecryptionModuleLoadSessionParams.sessionType, contentDecryptionModuleLoadSessionParams.sessionId, new ContentDecryptionModule_Internal.ContentDecryptionModuleLoadSessionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        contentDecryptionModuleUpdateSessionParams = ContentDecryptionModule_Internal.ContentDecryptionModuleUpdateSessionParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModule)getImpl()).updateSession(contentDecryptionModuleUpdateSessionParams.sessionId, contentDecryptionModuleUpdateSessionParams.response, new ContentDecryptionModule_Internal.ContentDecryptionModuleUpdateSessionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        contentDecryptionModuleCloseSessionParams = ContentDecryptionModule_Internal.ContentDecryptionModuleCloseSessionParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModule)getImpl()).closeSession(contentDecryptionModuleCloseSessionParams.sessionId, new ContentDecryptionModule_Internal.ContentDecryptionModuleCloseSessionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 8:
                        data = ContentDecryptionModule_Internal.ContentDecryptionModuleRemoveSessionParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModule)getImpl()).removeSession(data.sessionId, new ContentDecryptionModule_Internal.ContentDecryptionModuleRemoveSessionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ContentDecryptionModuleSetClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public AssociatedInterfaceNotSupported client;

        private ContentDecryptionModuleSetClientParams(int version) {
            super(16, version);
        }

        public ContentDecryptionModuleSetClientParams() {
            this(0);
        }

        public static ContentDecryptionModuleSetClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleSetClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleSetClientParams decode(Decoder decoder0) {
            ContentDecryptionModuleSetClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleSetClientParams(elementsOrVersion);
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

    static final class ContentDecryptionModuleInitializeParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String keySystem;

        public Origin securityOrigin;

        public CdmConfig cdmConfig;

        private ContentDecryptionModuleInitializeParams(int version) {
            super(32, version);
        }

        public ContentDecryptionModuleInitializeParams() {
            this(0);
        }

        public static ContentDecryptionModuleInitializeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleInitializeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleInitializeParams decode(Decoder decoder0) {
            ContentDecryptionModuleInitializeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleInitializeParams(elementsOrVersion);
                result.keySystem = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.securityOrigin = Origin.decode(decoder1);
                decoder1 = decoder0.readPointer(24, false);
                result.cdmConfig = CdmConfig.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.keySystem, 8, false);
            encoder0.encode((Struct)this.securityOrigin, 16, false);
            encoder0.encode(this.cdmConfig, 24, false);
        }
    }

    static final class ContentDecryptionModuleInitializeResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CdmPromiseResult result;

        public int cdmId;

        public Decryptor decryptor;

        private ContentDecryptionModuleInitializeResponseParams(int version) {
            super(32, version);
        }

        public ContentDecryptionModuleInitializeResponseParams() {
            this(0);
        }

        public static ContentDecryptionModuleInitializeResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleInitializeResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleInitializeResponseParams decode(Decoder decoder0) {
            ContentDecryptionModuleInitializeResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleInitializeResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = CdmPromiseResult.decode(decoder1);
                result.cdmId = decoder0.readInt(16);
                result.decryptor = (Decryptor)decoder0.readServiceInterface(20, true, Decryptor.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            encoder0.encode(this.cdmId, 16);
            encoder0.encode(this.decryptor, 20, true, Decryptor.MANAGER);
        }
    }

    static class ContentDecryptionModuleInitializeResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ContentDecryptionModule.InitializeResponse mCallback;

        ContentDecryptionModuleInitializeResponseParamsForwardToCallback(ContentDecryptionModule.InitializeResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                ContentDecryptionModule_Internal.ContentDecryptionModuleInitializeResponseParams response = ContentDecryptionModule_Internal.ContentDecryptionModuleInitializeResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, Integer.valueOf(response.cdmId), response.decryptor);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ContentDecryptionModuleInitializeResponseParamsProxyToResponder implements ContentDecryptionModule.InitializeResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ContentDecryptionModuleInitializeResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(CdmPromiseResult result, Integer cdmId, Decryptor decryptor) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleInitializeResponseParams _response = new ContentDecryptionModule_Internal.ContentDecryptionModuleInitializeResponseParams();
            _response.result = result;
            _response.cdmId = cdmId.intValue();
            _response.decryptor = decryptor;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ContentDecryptionModuleSetServerCertificateParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public byte[] certificateData;

        private ContentDecryptionModuleSetServerCertificateParams(int version) {
            super(16, version);
        }

        public ContentDecryptionModuleSetServerCertificateParams() {
            this(0);
        }

        public static ContentDecryptionModuleSetServerCertificateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleSetServerCertificateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleSetServerCertificateParams decode(Decoder decoder0) {
            ContentDecryptionModuleSetServerCertificateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleSetServerCertificateParams(elementsOrVersion);
                result.certificateData = decoder0.readBytes(8, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.certificateData, 8, 0, -1);
        }
    }

    static final class ContentDecryptionModuleSetServerCertificateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CdmPromiseResult result;

        private ContentDecryptionModuleSetServerCertificateResponseParams(int version) {
            super(16, version);
        }

        public ContentDecryptionModuleSetServerCertificateResponseParams() {
            this(0);
        }

        public static ContentDecryptionModuleSetServerCertificateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleSetServerCertificateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleSetServerCertificateResponseParams decode(Decoder decoder0) {
            ContentDecryptionModuleSetServerCertificateResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleSetServerCertificateResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = CdmPromiseResult.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class ContentDecryptionModuleSetServerCertificateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ContentDecryptionModule.SetServerCertificateResponse mCallback;

        ContentDecryptionModuleSetServerCertificateResponseParamsForwardToCallback(ContentDecryptionModule.SetServerCertificateResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                ContentDecryptionModule_Internal.ContentDecryptionModuleSetServerCertificateResponseParams response = ContentDecryptionModule_Internal.ContentDecryptionModuleSetServerCertificateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ContentDecryptionModuleSetServerCertificateResponseParamsProxyToResponder implements ContentDecryptionModule.SetServerCertificateResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ContentDecryptionModuleSetServerCertificateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(CdmPromiseResult result) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleSetServerCertificateResponseParams _response = new ContentDecryptionModule_Internal.ContentDecryptionModuleSetServerCertificateResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ContentDecryptionModuleGetStatusForPolicyParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int minHdcpVersion;

        private ContentDecryptionModuleGetStatusForPolicyParams(int version) {
            super(16, version);
        }

        public ContentDecryptionModuleGetStatusForPolicyParams() {
            this(0);
        }

        public static ContentDecryptionModuleGetStatusForPolicyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleGetStatusForPolicyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleGetStatusForPolicyParams decode(Decoder decoder0) {
            ContentDecryptionModuleGetStatusForPolicyParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleGetStatusForPolicyParams(elementsOrVersion);
                result.minHdcpVersion = decoder0.readInt(8);
                HdcpVersion.validate(result.minHdcpVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.minHdcpVersion, 8);
        }
    }

    static final class ContentDecryptionModuleGetStatusForPolicyResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CdmPromiseResult result;

        public int keyStatus;

        private ContentDecryptionModuleGetStatusForPolicyResponseParams(int version) {
            super(24, version);
        }

        public ContentDecryptionModuleGetStatusForPolicyResponseParams() {
            this(0);
        }

        public static ContentDecryptionModuleGetStatusForPolicyResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleGetStatusForPolicyResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleGetStatusForPolicyResponseParams decode(Decoder decoder0) {
            ContentDecryptionModuleGetStatusForPolicyResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleGetStatusForPolicyResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = CdmPromiseResult.decode(decoder1);
                result.keyStatus = decoder0.readInt(16);
                CdmKeyStatus.validate(result.keyStatus);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            encoder0.encode(this.keyStatus, 16);
        }
    }

    static class ContentDecryptionModuleGetStatusForPolicyResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ContentDecryptionModule.GetStatusForPolicyResponse mCallback;

        ContentDecryptionModuleGetStatusForPolicyResponseParamsForwardToCallback(ContentDecryptionModule.GetStatusForPolicyResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                ContentDecryptionModule_Internal.ContentDecryptionModuleGetStatusForPolicyResponseParams response = ContentDecryptionModule_Internal.ContentDecryptionModuleGetStatusForPolicyResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, Integer.valueOf(response.keyStatus));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ContentDecryptionModuleGetStatusForPolicyResponseParamsProxyToResponder implements ContentDecryptionModule.GetStatusForPolicyResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ContentDecryptionModuleGetStatusForPolicyResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(CdmPromiseResult result, Integer keyStatus) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleGetStatusForPolicyResponseParams _response = new ContentDecryptionModule_Internal.ContentDecryptionModuleGetStatusForPolicyResponseParams();
            _response.result = result;
            _response.keyStatus = keyStatus.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ContentDecryptionModuleCreateSessionAndGenerateRequestParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int sessionType;

        public int initDataType;

        public byte[] initData;

        private ContentDecryptionModuleCreateSessionAndGenerateRequestParams(int version) {
            super(24, version);
        }

        public ContentDecryptionModuleCreateSessionAndGenerateRequestParams() {
            this(0);
        }

        public static ContentDecryptionModuleCreateSessionAndGenerateRequestParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleCreateSessionAndGenerateRequestParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleCreateSessionAndGenerateRequestParams decode(Decoder decoder0) {
            ContentDecryptionModuleCreateSessionAndGenerateRequestParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleCreateSessionAndGenerateRequestParams(elementsOrVersion);
                result.sessionType = decoder0.readInt(8);
                CdmSessionType.validate(result.sessionType);
                result.initDataType = decoder0.readInt(12);
                EmeInitDataType.validate(result.initDataType);
                result.initData = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.sessionType, 8);
            encoder0.encode(this.initDataType, 12);
            encoder0.encode(this.initData, 16, 0, -1);
        }
    }

    static final class ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CdmPromiseResult result;

        public String sessionId;

        private ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams(int version) {
            super(24, version);
        }

        public ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams() {
            this(0);
        }

        public static ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams decode(Decoder decoder0) {
            ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = CdmPromiseResult.decode(decoder1);
                result.sessionId = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            encoder0.encode(this.sessionId, 16, false);
        }
    }

    static class ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ContentDecryptionModule.CreateSessionAndGenerateRequestResponse mCallback;

        ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParamsForwardToCallback(ContentDecryptionModule.CreateSessionAndGenerateRequestResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                ContentDecryptionModule_Internal.ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams response = ContentDecryptionModule_Internal.ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, response.sessionId);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParamsProxyToResponder implements ContentDecryptionModule.CreateSessionAndGenerateRequestResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(CdmPromiseResult result, String sessionId) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams _response = new ContentDecryptionModule_Internal.ContentDecryptionModuleCreateSessionAndGenerateRequestResponseParams();
            _response.result = result;
            _response.sessionId = sessionId;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ContentDecryptionModuleLoadSessionParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int sessionType;

        public String sessionId;

        private ContentDecryptionModuleLoadSessionParams(int version) {
            super(24, version);
        }

        public ContentDecryptionModuleLoadSessionParams() {
            this(0);
        }

        public static ContentDecryptionModuleLoadSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleLoadSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleLoadSessionParams decode(Decoder decoder0) {
            ContentDecryptionModuleLoadSessionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleLoadSessionParams(elementsOrVersion);
                result.sessionType = decoder0.readInt(8);
                CdmSessionType.validate(result.sessionType);
                result.sessionId = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.sessionType, 8);
            encoder0.encode(this.sessionId, 16, false);
        }
    }

    static final class ContentDecryptionModuleLoadSessionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CdmPromiseResult result;

        public String sessionId;

        private ContentDecryptionModuleLoadSessionResponseParams(int version) {
            super(24, version);
        }

        public ContentDecryptionModuleLoadSessionResponseParams() {
            this(0);
        }

        public static ContentDecryptionModuleLoadSessionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleLoadSessionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleLoadSessionResponseParams decode(Decoder decoder0) {
            ContentDecryptionModuleLoadSessionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleLoadSessionResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = CdmPromiseResult.decode(decoder1);
                result.sessionId = decoder0.readString(16, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
            encoder0.encode(this.sessionId, 16, false);
        }
    }

    static class ContentDecryptionModuleLoadSessionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ContentDecryptionModule.LoadSessionResponse mCallback;

        ContentDecryptionModuleLoadSessionResponseParamsForwardToCallback(ContentDecryptionModule.LoadSessionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                ContentDecryptionModule_Internal.ContentDecryptionModuleLoadSessionResponseParams response = ContentDecryptionModule_Internal.ContentDecryptionModuleLoadSessionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result, response.sessionId);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ContentDecryptionModuleLoadSessionResponseParamsProxyToResponder implements ContentDecryptionModule.LoadSessionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ContentDecryptionModuleLoadSessionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(CdmPromiseResult result, String sessionId) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleLoadSessionResponseParams _response = new ContentDecryptionModule_Internal.ContentDecryptionModuleLoadSessionResponseParams();
            _response.result = result;
            _response.sessionId = sessionId;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ContentDecryptionModuleUpdateSessionParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String sessionId;

        public byte[] response;

        private ContentDecryptionModuleUpdateSessionParams(int version) {
            super(24, version);
        }

        public ContentDecryptionModuleUpdateSessionParams() {
            this(0);
        }

        public static ContentDecryptionModuleUpdateSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleUpdateSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleUpdateSessionParams decode(Decoder decoder0) {
            ContentDecryptionModuleUpdateSessionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleUpdateSessionParams(elementsOrVersion);
                result.sessionId = decoder0.readString(8, false);
                result.response = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.sessionId, 8, false);
            encoder0.encode(this.response, 16, 0, -1);
        }
    }

    static final class ContentDecryptionModuleUpdateSessionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CdmPromiseResult result;

        private ContentDecryptionModuleUpdateSessionResponseParams(int version) {
            super(16, version);
        }

        public ContentDecryptionModuleUpdateSessionResponseParams() {
            this(0);
        }

        public static ContentDecryptionModuleUpdateSessionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleUpdateSessionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleUpdateSessionResponseParams decode(Decoder decoder0) {
            ContentDecryptionModuleUpdateSessionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleUpdateSessionResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = CdmPromiseResult.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class ContentDecryptionModuleUpdateSessionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ContentDecryptionModule.UpdateSessionResponse mCallback;

        ContentDecryptionModuleUpdateSessionResponseParamsForwardToCallback(ContentDecryptionModule.UpdateSessionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2))
                    return false;
                ContentDecryptionModule_Internal.ContentDecryptionModuleUpdateSessionResponseParams response = ContentDecryptionModule_Internal.ContentDecryptionModuleUpdateSessionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ContentDecryptionModuleUpdateSessionResponseParamsProxyToResponder implements ContentDecryptionModule.UpdateSessionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ContentDecryptionModuleUpdateSessionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(CdmPromiseResult result) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleUpdateSessionResponseParams _response = new ContentDecryptionModule_Internal.ContentDecryptionModuleUpdateSessionResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ContentDecryptionModuleCloseSessionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String sessionId;

        private ContentDecryptionModuleCloseSessionParams(int version) {
            super(16, version);
        }

        public ContentDecryptionModuleCloseSessionParams() {
            this(0);
        }

        public static ContentDecryptionModuleCloseSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleCloseSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleCloseSessionParams decode(Decoder decoder0) {
            ContentDecryptionModuleCloseSessionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleCloseSessionParams(elementsOrVersion);
                result.sessionId = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.sessionId, 8, false);
        }
    }

    static final class ContentDecryptionModuleCloseSessionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CdmPromiseResult result;

        private ContentDecryptionModuleCloseSessionResponseParams(int version) {
            super(16, version);
        }

        public ContentDecryptionModuleCloseSessionResponseParams() {
            this(0);
        }

        public static ContentDecryptionModuleCloseSessionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleCloseSessionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleCloseSessionResponseParams decode(Decoder decoder0) {
            ContentDecryptionModuleCloseSessionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleCloseSessionResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = CdmPromiseResult.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class ContentDecryptionModuleCloseSessionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ContentDecryptionModule.CloseSessionResponse mCallback;

        ContentDecryptionModuleCloseSessionResponseParamsForwardToCallback(ContentDecryptionModule.CloseSessionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(7, 2))
                    return false;
                ContentDecryptionModule_Internal.ContentDecryptionModuleCloseSessionResponseParams response = ContentDecryptionModule_Internal.ContentDecryptionModuleCloseSessionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ContentDecryptionModuleCloseSessionResponseParamsProxyToResponder implements ContentDecryptionModule.CloseSessionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ContentDecryptionModuleCloseSessionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(CdmPromiseResult result) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleCloseSessionResponseParams _response = new ContentDecryptionModule_Internal.ContentDecryptionModuleCloseSessionResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ContentDecryptionModuleRemoveSessionParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String sessionId;

        private ContentDecryptionModuleRemoveSessionParams(int version) {
            super(16, version);
        }

        public ContentDecryptionModuleRemoveSessionParams() {
            this(0);
        }

        public static ContentDecryptionModuleRemoveSessionParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleRemoveSessionParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleRemoveSessionParams decode(Decoder decoder0) {
            ContentDecryptionModuleRemoveSessionParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleRemoveSessionParams(elementsOrVersion);
                result.sessionId = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.sessionId, 8, false);
        }
    }

    static final class ContentDecryptionModuleRemoveSessionResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public CdmPromiseResult result;

        private ContentDecryptionModuleRemoveSessionResponseParams(int version) {
            super(16, version);
        }

        public ContentDecryptionModuleRemoveSessionResponseParams() {
            this(0);
        }

        public static ContentDecryptionModuleRemoveSessionResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleRemoveSessionResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleRemoveSessionResponseParams decode(Decoder decoder0) {
            ContentDecryptionModuleRemoveSessionResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleRemoveSessionResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.result = CdmPromiseResult.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.result, 8, false);
        }
    }

    static class ContentDecryptionModuleRemoveSessionResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ContentDecryptionModule.RemoveSessionResponse mCallback;

        ContentDecryptionModuleRemoveSessionResponseParamsForwardToCallback(ContentDecryptionModule.RemoveSessionResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(8, 2))
                    return false;
                ContentDecryptionModule_Internal.ContentDecryptionModuleRemoveSessionResponseParams response = ContentDecryptionModule_Internal.ContentDecryptionModuleRemoveSessionResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.result);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ContentDecryptionModuleRemoveSessionResponseParamsProxyToResponder implements ContentDecryptionModule.RemoveSessionResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ContentDecryptionModuleRemoveSessionResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(CdmPromiseResult result) {
            ContentDecryptionModule_Internal.ContentDecryptionModuleRemoveSessionResponseParams _response = new ContentDecryptionModule_Internal.ContentDecryptionModuleRemoveSessionResponseParams();
            _response.result = result;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
