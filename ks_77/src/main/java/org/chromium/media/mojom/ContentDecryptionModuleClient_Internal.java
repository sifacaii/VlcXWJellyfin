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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class ContentDecryptionModuleClient_Internal {
    public static final Interface.Manager<ContentDecryptionModuleClient, ContentDecryptionModuleClient.Proxy> MANAGER = new Interface.Manager<ContentDecryptionModuleClient, ContentDecryptionModuleClient.Proxy>() {
        public String getName() {
            return "media.mojom.ContentDecryptionModuleClient";
        }

        public int getVersion() {
            return 0;
        }

        public ContentDecryptionModuleClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ContentDecryptionModuleClient_Internal.Proxy(core, messageReceiver);
        }

        public ContentDecryptionModuleClient_Internal.Stub buildStub(Core core, ContentDecryptionModuleClient impl) {
            return new ContentDecryptionModuleClient_Internal.Stub(core, impl);
        }

        public ContentDecryptionModuleClient[] buildArray(int size) {
            return new ContentDecryptionModuleClient[size];
        }
    };

    private static final int ON_SESSION_MESSAGE_ORDINAL = 0;

    private static final int ON_SESSION_CLOSED_ORDINAL = 1;

    private static final int ON_SESSION_KEYS_CHANGE_ORDINAL = 2;

    private static final int ON_SESSION_EXPIRATION_UPDATE_ORDINAL = 3;

    static final class Proxy extends Interface.AbstractProxy implements ContentDecryptionModuleClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onSessionMessage(String sessionId, int messageType, byte[] message) {
            ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionMessageParams _message = new ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionMessageParams();
            _message.sessionId = sessionId;
            _message.messageType = messageType;
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onSessionClosed(String sessionId) {
            ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionClosedParams _message = new ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionClosedParams();
            _message.sessionId = sessionId;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void onSessionKeysChange(String sessionId, boolean hasAdditionalUsableKey, CdmKeyInformation[] keysInfo) {
            ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionKeysChangeParams _message = new ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionKeysChangeParams();
            _message.sessionId = sessionId;
            _message.hasAdditionalUsableKey = hasAdditionalUsableKey;
            _message.keysInfo = keysInfo;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }

        public void onSessionExpirationUpdate(String sessionId, double newExpiryTimeSec) {
            ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionExpirationUpdateParams _message = new ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionExpirationUpdateParams();
            _message.sessionId = sessionId;
            _message.newExpiryTimeSec = newExpiryTimeSec;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3)));
        }
    }

    static final class Stub extends Interface.Stub<ContentDecryptionModuleClient> {
        Stub(Core core, ContentDecryptionModuleClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionMessageParams contentDecryptionModuleClientOnSessionMessageParams;
                ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionClosedParams contentDecryptionModuleClientOnSessionClosedParams;
                ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionKeysChangeParams contentDecryptionModuleClientOnSessionKeysChangeParams;
                ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionExpirationUpdateParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ContentDecryptionModuleClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        contentDecryptionModuleClientOnSessionMessageParams = ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionMessageParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModuleClient)getImpl()).onSessionMessage(contentDecryptionModuleClientOnSessionMessageParams.sessionId, contentDecryptionModuleClientOnSessionMessageParams.messageType, contentDecryptionModuleClientOnSessionMessageParams.message);
                        return true;
                    case 1:
                        contentDecryptionModuleClientOnSessionClosedParams = ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionClosedParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModuleClient)getImpl()).onSessionClosed(contentDecryptionModuleClientOnSessionClosedParams.sessionId);
                        return true;
                    case 2:
                        contentDecryptionModuleClientOnSessionKeysChangeParams = ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionKeysChangeParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModuleClient)getImpl()).onSessionKeysChange(contentDecryptionModuleClientOnSessionKeysChangeParams.sessionId, contentDecryptionModuleClientOnSessionKeysChangeParams.hasAdditionalUsableKey, contentDecryptionModuleClientOnSessionKeysChangeParams.keysInfo);
                        return true;
                    case 3:
                        data = ContentDecryptionModuleClient_Internal.ContentDecryptionModuleClientOnSessionExpirationUpdateParams.deserialize(messageWithHeader.getPayload());
                        ((ContentDecryptionModuleClient)getImpl()).onSessionExpirationUpdate(data.sessionId, data.newExpiryTimeSec);
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
                                getCore(), ContentDecryptionModuleClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ContentDecryptionModuleClientOnSessionMessageParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String sessionId;

        public int messageType;

        public byte[] message;

        private ContentDecryptionModuleClientOnSessionMessageParams(int version) {
            super(32, version);
        }

        public ContentDecryptionModuleClientOnSessionMessageParams() {
            this(0);
        }

        public static ContentDecryptionModuleClientOnSessionMessageParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleClientOnSessionMessageParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleClientOnSessionMessageParams decode(Decoder decoder0) {
            ContentDecryptionModuleClientOnSessionMessageParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleClientOnSessionMessageParams(elementsOrVersion);
                result.sessionId = decoder0.readString(8, false);
                result.messageType = decoder0.readInt(16);
                CdmMessageType.validate(result.messageType);
                result.message = decoder0.readBytes(24, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.sessionId, 8, false);
            encoder0.encode(this.messageType, 16);
            encoder0.encode(this.message, 24, 0, -1);
        }
    }

    static final class ContentDecryptionModuleClientOnSessionClosedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String sessionId;

        private ContentDecryptionModuleClientOnSessionClosedParams(int version) {
            super(16, version);
        }

        public ContentDecryptionModuleClientOnSessionClosedParams() {
            this(0);
        }

        public static ContentDecryptionModuleClientOnSessionClosedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleClientOnSessionClosedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleClientOnSessionClosedParams decode(Decoder decoder0) {
            ContentDecryptionModuleClientOnSessionClosedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleClientOnSessionClosedParams(elementsOrVersion);
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

    static final class ContentDecryptionModuleClientOnSessionKeysChangeParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String sessionId;

        public boolean hasAdditionalUsableKey;

        public CdmKeyInformation[] keysInfo;

        private ContentDecryptionModuleClientOnSessionKeysChangeParams(int version) {
            super(32, version);
        }

        public ContentDecryptionModuleClientOnSessionKeysChangeParams() {
            this(0);
        }

        public static ContentDecryptionModuleClientOnSessionKeysChangeParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleClientOnSessionKeysChangeParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleClientOnSessionKeysChangeParams decode(Decoder decoder0) {
            ContentDecryptionModuleClientOnSessionKeysChangeParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleClientOnSessionKeysChangeParams(elementsOrVersion);
                result.sessionId = decoder0.readString(8, false);
                result.hasAdditionalUsableKey = decoder0.readBoolean(16, 0);
                Decoder decoder1 = decoder0.readPointer(24, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.keysInfo = new CdmKeyInformation[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.keysInfo[i1] = CdmKeyInformation.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.sessionId, 8, false);
            encoder0.encode(this.hasAdditionalUsableKey, 16, 0);
            if (this.keysInfo == null) {
                encoder0.encodeNullPointer(24, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.keysInfo.length, 24, -1);
                for (int i0 = 0; i0 < this.keysInfo.length; i0++)
                    encoder1.encode(this.keysInfo[i0], 8 + 8 * i0, false);
            }
        }
    }

    static final class ContentDecryptionModuleClientOnSessionExpirationUpdateParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String sessionId;

        public double newExpiryTimeSec;

        private ContentDecryptionModuleClientOnSessionExpirationUpdateParams(int version) {
            super(24, version);
        }

        public ContentDecryptionModuleClientOnSessionExpirationUpdateParams() {
            this(0);
        }

        public static ContentDecryptionModuleClientOnSessionExpirationUpdateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ContentDecryptionModuleClientOnSessionExpirationUpdateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ContentDecryptionModuleClientOnSessionExpirationUpdateParams decode(Decoder decoder0) {
            ContentDecryptionModuleClientOnSessionExpirationUpdateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ContentDecryptionModuleClientOnSessionExpirationUpdateParams(elementsOrVersion);
                result.sessionId = decoder0.readString(8, false);
                result.newExpiryTimeSec = decoder0.readDouble(16);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.sessionId, 8, false);
            encoder0.encode(this.newExpiryTimeSec, 16);
        }
    }
}
