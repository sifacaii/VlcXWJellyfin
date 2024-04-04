package org.chromium.blink.mojom.document_metadata;

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

class CopylessPaste_Internal {
    public static final Interface.Manager<CopylessPaste, CopylessPaste.Proxy> MANAGER = new Interface.Manager<CopylessPaste, CopylessPaste.Proxy>() {
        public String getName() {
            return "blink.mojom.document_metadata.CopylessPaste";
        }

        public int getVersion() {
            return 0;
        }

        public CopylessPaste_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new CopylessPaste_Internal.Proxy(core, messageReceiver);
        }

        public CopylessPaste_Internal.Stub buildStub(Core core, CopylessPaste impl) {
            return new CopylessPaste_Internal.Stub(core, impl);
        }

        public CopylessPaste[] buildArray(int size) {
            return new CopylessPaste[size];
        }
    };

    private static final int GET_ENTITIES_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements CopylessPaste.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void getEntities(CopylessPaste.GetEntitiesResponse callback) {
            CopylessPaste_Internal.CopylessPasteGetEntitiesParams _message = new CopylessPaste_Internal.CopylessPasteGetEntitiesParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new CopylessPaste_Internal.CopylessPasteGetEntitiesResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<CopylessPaste> {
        Stub(Core core, CopylessPaste impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(CopylessPaste_Internal.MANAGER, messageWithHeader);
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
                                getCore(), CopylessPaste_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        CopylessPaste_Internal.CopylessPasteGetEntitiesParams.deserialize(messageWithHeader.getPayload());
                        ((CopylessPaste)getImpl()).getEntities(new CopylessPaste_Internal.CopylessPasteGetEntitiesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class CopylessPasteGetEntitiesParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private CopylessPasteGetEntitiesParams(int version) {
            super(8, version);
        }

        public CopylessPasteGetEntitiesParams() {
            this(0);
        }

        public static CopylessPasteGetEntitiesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CopylessPasteGetEntitiesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CopylessPasteGetEntitiesParams decode(Decoder decoder0) {
            CopylessPasteGetEntitiesParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CopylessPasteGetEntitiesParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class CopylessPasteGetEntitiesResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public WebPage page;

        private CopylessPasteGetEntitiesResponseParams(int version) {
            super(16, version);
        }

        public CopylessPasteGetEntitiesResponseParams() {
            this(0);
        }

        public static CopylessPasteGetEntitiesResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static CopylessPasteGetEntitiesResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static CopylessPasteGetEntitiesResponseParams decode(Decoder decoder0) {
            CopylessPasteGetEntitiesResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new CopylessPasteGetEntitiesResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.page = WebPage.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.page, 8, true);
        }
    }

    static class CopylessPasteGetEntitiesResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final CopylessPaste.GetEntitiesResponse mCallback;

        CopylessPasteGetEntitiesResponseParamsForwardToCallback(CopylessPaste.GetEntitiesResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                CopylessPaste_Internal.CopylessPasteGetEntitiesResponseParams response = CopylessPaste_Internal.CopylessPasteGetEntitiesResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.page);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class CopylessPasteGetEntitiesResponseParamsProxyToResponder implements CopylessPaste.GetEntitiesResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        CopylessPasteGetEntitiesResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(WebPage page) {
            CopylessPaste_Internal.CopylessPasteGetEntitiesResponseParams _response = new CopylessPaste_Internal.CopylessPasteGetEntitiesResponseParams();
            _response.page = page;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
