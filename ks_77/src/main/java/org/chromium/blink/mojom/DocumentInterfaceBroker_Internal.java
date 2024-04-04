package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.test.mojom.VirtualAuthenticatorManager;
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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.UnguessableToken;

class DocumentInterfaceBroker_Internal {
    public static final Interface.Manager<DocumentInterfaceBroker, DocumentInterfaceBroker.Proxy> MANAGER = new Interface.Manager<DocumentInterfaceBroker, DocumentInterfaceBroker.Proxy>() {
        public String getName() {
            return "blink.mojom.DocumentInterfaceBroker";
        }

        public int getVersion() {
            return 0;
        }

        public DocumentInterfaceBroker_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new DocumentInterfaceBroker_Internal.Proxy(core, messageReceiver);
        }

        public DocumentInterfaceBroker_Internal.Stub buildStub(Core core, DocumentInterfaceBroker impl) {
            return new DocumentInterfaceBroker_Internal.Stub(core, impl);
        }

        public DocumentInterfaceBroker[] buildArray(int size) {
            return new DocumentInterfaceBroker[size];
        }
    };

    private static final int GET_AUDIO_CONTEXT_MANAGER_ORDINAL = 0;

    private static final int GET_AUTHENTICATOR_ORDINAL = 1;

    private static final int GET_CREDENTIAL_MANAGER_ORDINAL = 2;

    private static final int GET_FRAME_HOST_TEST_INTERFACE_ORDINAL = 3;

    private static final int GET_PUSH_MESSAGING_ORDINAL = 4;

    private static final int GET_VIRTUAL_AUTHENTICATOR_MANAGER_ORDINAL = 5;

    private static final int REGISTER_APP_CACHE_HOST_ORDINAL = 6;

    static final class Proxy extends Interface.AbstractProxy implements DocumentInterfaceBroker.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getAudioContextManager(InterfaceRequest<AudioContextManager> receiver) {
            DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetAudioContextManagerParams _message = new DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetAudioContextManagerParams();
            _message.receiver = receiver;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void getAuthenticator(InterfaceRequest<Authenticator> receiver) {
            DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetAuthenticatorParams _message = new DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetAuthenticatorParams();
            _message.receiver = receiver;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void getCredentialManager(InterfaceRequest<CredentialManager> receiver) {
            DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetCredentialManagerParams _message = new DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetCredentialManagerParams();
            _message.receiver = receiver;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void getFrameHostTestInterface(InterfaceRequest<FrameHostTestInterface> receiver) {
            DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetFrameHostTestInterfaceParams _message = new DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetFrameHostTestInterfaceParams();
            _message.receiver = receiver;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }

        public void getPushMessaging(InterfaceRequest<PushMessaging> receiver) {
            DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetPushMessagingParams _message = new DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetPushMessagingParams();
            _message.receiver = receiver;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }

        public void getVirtualAuthenticatorManager(InterfaceRequest<VirtualAuthenticatorManager> receiver) {
            DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetVirtualAuthenticatorManagerParams _message = new DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetVirtualAuthenticatorManagerParams();
            _message.receiver = receiver;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5)));
        }

        public void registerAppCacheHost(InterfaceRequest<AppCacheHost> hostReceiver, AppCacheFrontend frontendRemote, UnguessableToken hostId) {
            DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerRegisterAppCacheHostParams _message = new DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerRegisterAppCacheHostParams();
            _message.hostReceiver = hostReceiver;
            _message.frontendRemote = frontendRemote;
            _message.hostId = hostId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6)));
        }
    }

    static final class Stub extends Interface.Stub<DocumentInterfaceBroker> {
        Stub(Core core, DocumentInterfaceBroker impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetAudioContextManagerParams documentInterfaceBrokerGetAudioContextManagerParams;
                DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetAuthenticatorParams documentInterfaceBrokerGetAuthenticatorParams;
                DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetCredentialManagerParams documentInterfaceBrokerGetCredentialManagerParams;
                DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetFrameHostTestInterfaceParams documentInterfaceBrokerGetFrameHostTestInterfaceParams;
                DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetPushMessagingParams documentInterfaceBrokerGetPushMessagingParams;
                DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetVirtualAuthenticatorManagerParams documentInterfaceBrokerGetVirtualAuthenticatorManagerParams;
                DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerRegisterAppCacheHostParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DocumentInterfaceBroker_Internal.MANAGER, messageWithHeader);
                    case 0:
                        documentInterfaceBrokerGetAudioContextManagerParams = DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetAudioContextManagerParams.deserialize(messageWithHeader.getPayload());
                        ((DocumentInterfaceBroker)getImpl()).getAudioContextManager(documentInterfaceBrokerGetAudioContextManagerParams.receiver);
                        return true;
                    case 1:
                        documentInterfaceBrokerGetAuthenticatorParams = DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetAuthenticatorParams.deserialize(messageWithHeader.getPayload());
                        ((DocumentInterfaceBroker)getImpl()).getAuthenticator(documentInterfaceBrokerGetAuthenticatorParams.receiver);
                        return true;
                    case 2:
                        documentInterfaceBrokerGetCredentialManagerParams = DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetCredentialManagerParams.deserialize(messageWithHeader.getPayload());
                        ((DocumentInterfaceBroker)getImpl()).getCredentialManager(documentInterfaceBrokerGetCredentialManagerParams.receiver);
                        return true;
                    case 3:
                        documentInterfaceBrokerGetFrameHostTestInterfaceParams = DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetFrameHostTestInterfaceParams.deserialize(messageWithHeader.getPayload());
                        ((DocumentInterfaceBroker)getImpl()).getFrameHostTestInterface(documentInterfaceBrokerGetFrameHostTestInterfaceParams.receiver);
                        return true;
                    case 4:
                        documentInterfaceBrokerGetPushMessagingParams = DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetPushMessagingParams.deserialize(messageWithHeader.getPayload());
                        ((DocumentInterfaceBroker)getImpl()).getPushMessaging(documentInterfaceBrokerGetPushMessagingParams.receiver);
                        return true;
                    case 5:
                        documentInterfaceBrokerGetVirtualAuthenticatorManagerParams = DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerGetVirtualAuthenticatorManagerParams.deserialize(messageWithHeader.getPayload());
                        ((DocumentInterfaceBroker)getImpl()).getVirtualAuthenticatorManager(documentInterfaceBrokerGetVirtualAuthenticatorManagerParams.receiver);
                        return true;
                    case 6:
                        data = DocumentInterfaceBroker_Internal.DocumentInterfaceBrokerRegisterAppCacheHostParams.deserialize(messageWithHeader.getPayload());
                        ((DocumentInterfaceBroker)getImpl()).registerAppCacheHost(data.hostReceiver, data.frontendRemote, data.hostId);
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
                                getCore(), DocumentInterfaceBroker_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class DocumentInterfaceBrokerGetAudioContextManagerParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<AudioContextManager> receiver;

        private DocumentInterfaceBrokerGetAudioContextManagerParams(int version) {
            super(16, version);
        }

        public DocumentInterfaceBrokerGetAudioContextManagerParams() {
            this(0);
        }

        public static DocumentInterfaceBrokerGetAudioContextManagerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DocumentInterfaceBrokerGetAudioContextManagerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DocumentInterfaceBrokerGetAudioContextManagerParams decode(Decoder decoder0) {
            DocumentInterfaceBrokerGetAudioContextManagerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DocumentInterfaceBrokerGetAudioContextManagerParams(elementsOrVersion);
                result.receiver = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.receiver, 8, false);
        }
    }

    static final class DocumentInterfaceBrokerGetAuthenticatorParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<Authenticator> receiver;

        private DocumentInterfaceBrokerGetAuthenticatorParams(int version) {
            super(16, version);
        }

        public DocumentInterfaceBrokerGetAuthenticatorParams() {
            this(0);
        }

        public static DocumentInterfaceBrokerGetAuthenticatorParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DocumentInterfaceBrokerGetAuthenticatorParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DocumentInterfaceBrokerGetAuthenticatorParams decode(Decoder decoder0) {
            DocumentInterfaceBrokerGetAuthenticatorParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DocumentInterfaceBrokerGetAuthenticatorParams(elementsOrVersion);
                result.receiver = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.receiver, 8, false);
        }
    }

    static final class DocumentInterfaceBrokerGetCredentialManagerParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<CredentialManager> receiver;

        private DocumentInterfaceBrokerGetCredentialManagerParams(int version) {
            super(16, version);
        }

        public DocumentInterfaceBrokerGetCredentialManagerParams() {
            this(0);
        }

        public static DocumentInterfaceBrokerGetCredentialManagerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DocumentInterfaceBrokerGetCredentialManagerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DocumentInterfaceBrokerGetCredentialManagerParams decode(Decoder decoder0) {
            DocumentInterfaceBrokerGetCredentialManagerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DocumentInterfaceBrokerGetCredentialManagerParams(elementsOrVersion);
                result.receiver = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.receiver, 8, false);
        }
    }

    static final class DocumentInterfaceBrokerGetFrameHostTestInterfaceParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<FrameHostTestInterface> receiver;

        private DocumentInterfaceBrokerGetFrameHostTestInterfaceParams(int version) {
            super(16, version);
        }

        public DocumentInterfaceBrokerGetFrameHostTestInterfaceParams() {
            this(0);
        }

        public static DocumentInterfaceBrokerGetFrameHostTestInterfaceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DocumentInterfaceBrokerGetFrameHostTestInterfaceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DocumentInterfaceBrokerGetFrameHostTestInterfaceParams decode(Decoder decoder0) {
            DocumentInterfaceBrokerGetFrameHostTestInterfaceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DocumentInterfaceBrokerGetFrameHostTestInterfaceParams(elementsOrVersion);
                result.receiver = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.receiver, 8, false);
        }
    }

    static final class DocumentInterfaceBrokerGetPushMessagingParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<PushMessaging> receiver;

        private DocumentInterfaceBrokerGetPushMessagingParams(int version) {
            super(16, version);
        }

        public DocumentInterfaceBrokerGetPushMessagingParams() {
            this(0);
        }

        public static DocumentInterfaceBrokerGetPushMessagingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DocumentInterfaceBrokerGetPushMessagingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DocumentInterfaceBrokerGetPushMessagingParams decode(Decoder decoder0) {
            DocumentInterfaceBrokerGetPushMessagingParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DocumentInterfaceBrokerGetPushMessagingParams(elementsOrVersion);
                result.receiver = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.receiver, 8, false);
        }
    }

    static final class DocumentInterfaceBrokerGetVirtualAuthenticatorManagerParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<VirtualAuthenticatorManager> receiver;

        private DocumentInterfaceBrokerGetVirtualAuthenticatorManagerParams(int version) {
            super(16, version);
        }

        public DocumentInterfaceBrokerGetVirtualAuthenticatorManagerParams() {
            this(0);
        }

        public static DocumentInterfaceBrokerGetVirtualAuthenticatorManagerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DocumentInterfaceBrokerGetVirtualAuthenticatorManagerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DocumentInterfaceBrokerGetVirtualAuthenticatorManagerParams decode(Decoder decoder0) {
            DocumentInterfaceBrokerGetVirtualAuthenticatorManagerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DocumentInterfaceBrokerGetVirtualAuthenticatorManagerParams(elementsOrVersion);
                result.receiver = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.receiver, 8, false);
        }
    }

    static final class DocumentInterfaceBrokerRegisterAppCacheHostParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<AppCacheHost> hostReceiver;

        public AppCacheFrontend frontendRemote;

        public UnguessableToken hostId;

        private DocumentInterfaceBrokerRegisterAppCacheHostParams(int version) {
            super(32, version);
        }

        public DocumentInterfaceBrokerRegisterAppCacheHostParams() {
            this(0);
        }

        public static DocumentInterfaceBrokerRegisterAppCacheHostParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DocumentInterfaceBrokerRegisterAppCacheHostParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DocumentInterfaceBrokerRegisterAppCacheHostParams decode(Decoder decoder0) {
            DocumentInterfaceBrokerRegisterAppCacheHostParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DocumentInterfaceBrokerRegisterAppCacheHostParams(elementsOrVersion);
                result.hostReceiver = decoder0.readInterfaceRequest(8, false);
                result.frontendRemote = (AppCacheFrontend)decoder0.readServiceInterface(12, false, AppCacheFrontend.MANAGER);
                Decoder decoder1 = decoder0.readPointer(24, false);
                result.hostId = UnguessableToken.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.hostReceiver, 8, false);
            encoder0.encode(this.frontendRemote, 12, false, AppCacheFrontend.MANAGER);
            encoder0.encode((Struct)this.hostId, 24, false);
        }
    }
}
