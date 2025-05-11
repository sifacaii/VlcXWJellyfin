package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
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
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.UnguessableToken;

class BlobUrlToken_Internal {
    public static final Interface.Manager<BlobUrlToken, BlobUrlToken.Proxy> MANAGER = new Interface.Manager<BlobUrlToken, BlobUrlToken.Proxy>() {
        public String getName() {
            return "blink.mojom.BlobURLToken";
        }

        public int getVersion() {
            return 0;
        }

        public BlobUrlToken_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new BlobUrlToken_Internal.Proxy(core, messageReceiver);
        }

        public BlobUrlToken_Internal.Stub buildStub(Core core, BlobUrlToken impl) {
            return new BlobUrlToken_Internal.Stub(core, impl);
        }

        public BlobUrlToken[] buildArray(int size) {
            return new BlobUrlToken[size];
        }
    };

    private static final int CLONE_ORDINAL = 0;

    private static final int GET_TOKEN_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements BlobUrlToken.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void clone(InterfaceRequest<BlobUrlToken> token) {
            BlobUrlToken_Internal.BlobUrlTokenCloneParams _message = new BlobUrlToken_Internal.BlobUrlTokenCloneParams();
            _message.token = token;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void getToken(BlobUrlToken.GetTokenResponse callback) {
            BlobUrlToken_Internal.BlobUrlTokenGetTokenParams _message = new BlobUrlToken_Internal.BlobUrlTokenGetTokenParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new BlobUrlToken_Internal.BlobUrlTokenGetTokenResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<BlobUrlToken> {
        Stub(Core core, BlobUrlToken impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                BlobUrlToken_Internal.BlobUrlTokenCloneParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(BlobUrlToken_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = BlobUrlToken_Internal.BlobUrlTokenCloneParams.deserialize(messageWithHeader.getPayload());
                        ((BlobUrlToken)getImpl()).clone(data.token);
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
                                getCore(), BlobUrlToken_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        BlobUrlToken_Internal.BlobUrlTokenGetTokenParams.deserialize(messageWithHeader.getPayload());
                        ((BlobUrlToken)getImpl()).getToken(new BlobUrlToken_Internal.BlobUrlTokenGetTokenResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class BlobUrlTokenCloneParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<BlobUrlToken> token;

        private BlobUrlTokenCloneParams(int version) {
            super(16, version);
        }

        public BlobUrlTokenCloneParams() {
            this(0);
        }

        public static BlobUrlTokenCloneParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobUrlTokenCloneParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobUrlTokenCloneParams decode(Decoder decoder0) {
            BlobUrlTokenCloneParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobUrlTokenCloneParams(elementsOrVersion);
                result.token = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.token, 8, false);
        }
    }

    static final class BlobUrlTokenGetTokenParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private BlobUrlTokenGetTokenParams(int version) {
            super(8, version);
        }

        public BlobUrlTokenGetTokenParams() {
            this(0);
        }

        public static BlobUrlTokenGetTokenParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobUrlTokenGetTokenParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobUrlTokenGetTokenParams decode(Decoder decoder0) {
            BlobUrlTokenGetTokenParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobUrlTokenGetTokenParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class BlobUrlTokenGetTokenResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UnguessableToken token;

        private BlobUrlTokenGetTokenResponseParams(int version) {
            super(16, version);
        }

        public BlobUrlTokenGetTokenResponseParams() {
            this(0);
        }

        public static BlobUrlTokenGetTokenResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static BlobUrlTokenGetTokenResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static BlobUrlTokenGetTokenResponseParams decode(Decoder decoder0) {
            BlobUrlTokenGetTokenResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new BlobUrlTokenGetTokenResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.token = UnguessableToken.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.token, 8, false);
        }
    }

    static class BlobUrlTokenGetTokenResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final BlobUrlToken.GetTokenResponse mCallback;

        BlobUrlTokenGetTokenResponseParamsForwardToCallback(BlobUrlToken.GetTokenResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                BlobUrlToken_Internal.BlobUrlTokenGetTokenResponseParams response = BlobUrlToken_Internal.BlobUrlTokenGetTokenResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.token);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class BlobUrlTokenGetTokenResponseParamsProxyToResponder implements BlobUrlToken.GetTokenResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        BlobUrlTokenGetTokenResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(UnguessableToken token) {
            BlobUrlToken_Internal.BlobUrlTokenGetTokenResponseParams _response = new BlobUrlToken_Internal.BlobUrlTokenGetTokenResponseParams();
            _response.token = token;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
