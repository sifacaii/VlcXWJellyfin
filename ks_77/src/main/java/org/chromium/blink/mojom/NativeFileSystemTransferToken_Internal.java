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
import org.chromium.mojo_base.mojom.UnguessableToken;

class NativeFileSystemTransferToken_Internal {
    public static final Interface.Manager<NativeFileSystemTransferToken, NativeFileSystemTransferToken.Proxy> MANAGER = new Interface.Manager<NativeFileSystemTransferToken, NativeFileSystemTransferToken.Proxy>() {
        public String getName() {
            return "blink.mojom.NativeFileSystemTransferToken";
        }

        public int getVersion() {
            return 0;
        }

        public NativeFileSystemTransferToken_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new NativeFileSystemTransferToken_Internal.Proxy(core, messageReceiver);
        }

        public NativeFileSystemTransferToken_Internal.Stub buildStub(Core core, NativeFileSystemTransferToken impl) {
            return new NativeFileSystemTransferToken_Internal.Stub(core, impl);
        }

        public NativeFileSystemTransferToken[] buildArray(int size) {
            return new NativeFileSystemTransferToken[size];
        }
    };

    private static final int GET_INTERNAL_ID_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements NativeFileSystemTransferToken.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getInternalId(NativeFileSystemTransferToken.GetInternalIdResponse callback) {
            NativeFileSystemTransferToken_Internal.NativeFileSystemTransferTokenGetInternalIdParams _message = new NativeFileSystemTransferToken_Internal.NativeFileSystemTransferTokenGetInternalIdParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new NativeFileSystemTransferToken_Internal.NativeFileSystemTransferTokenGetInternalIdResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<NativeFileSystemTransferToken> {
        Stub(Core core, NativeFileSystemTransferToken impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(NativeFileSystemTransferToken_Internal.MANAGER, messageWithHeader);
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
                                getCore(), NativeFileSystemTransferToken_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        NativeFileSystemTransferToken_Internal.NativeFileSystemTransferTokenGetInternalIdParams.deserialize(messageWithHeader.getPayload());
                        ((NativeFileSystemTransferToken)getImpl()).getInternalId(new NativeFileSystemTransferToken_Internal.NativeFileSystemTransferTokenGetInternalIdResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class NativeFileSystemTransferTokenGetInternalIdParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NativeFileSystemTransferTokenGetInternalIdParams(int version) {
            super(8, version);
        }

        public NativeFileSystemTransferTokenGetInternalIdParams() {
            this(0);
        }

        public static NativeFileSystemTransferTokenGetInternalIdParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemTransferTokenGetInternalIdParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemTransferTokenGetInternalIdParams decode(Decoder decoder0) {
            NativeFileSystemTransferTokenGetInternalIdParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemTransferTokenGetInternalIdParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class NativeFileSystemTransferTokenGetInternalIdResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public UnguessableToken id;

        private NativeFileSystemTransferTokenGetInternalIdResponseParams(int version) {
            super(16, version);
        }

        public NativeFileSystemTransferTokenGetInternalIdResponseParams() {
            this(0);
        }

        public static NativeFileSystemTransferTokenGetInternalIdResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static NativeFileSystemTransferTokenGetInternalIdResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static NativeFileSystemTransferTokenGetInternalIdResponseParams decode(Decoder decoder0) {
            NativeFileSystemTransferTokenGetInternalIdResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NativeFileSystemTransferTokenGetInternalIdResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.id = UnguessableToken.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.id, 8, false);
        }
    }

    static class NativeFileSystemTransferTokenGetInternalIdResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final NativeFileSystemTransferToken.GetInternalIdResponse mCallback;

        NativeFileSystemTransferTokenGetInternalIdResponseParamsForwardToCallback(NativeFileSystemTransferToken.GetInternalIdResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                NativeFileSystemTransferToken_Internal.NativeFileSystemTransferTokenGetInternalIdResponseParams response = NativeFileSystemTransferToken_Internal.NativeFileSystemTransferTokenGetInternalIdResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.id);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class NativeFileSystemTransferTokenGetInternalIdResponseParamsProxyToResponder implements NativeFileSystemTransferToken.GetInternalIdResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        NativeFileSystemTransferTokenGetInternalIdResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(UnguessableToken id) {
            NativeFileSystemTransferToken_Internal.NativeFileSystemTransferTokenGetInternalIdResponseParams _response = new NativeFileSystemTransferToken_Internal.NativeFileSystemTransferTokenGetInternalIdResponseParams();
            _response.id = id;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
