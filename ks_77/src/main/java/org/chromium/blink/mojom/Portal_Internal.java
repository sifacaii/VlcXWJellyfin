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
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

class Portal_Internal {
    public static final Interface.Manager<Portal, Portal.Proxy> MANAGER = new Interface.Manager<Portal, Portal.Proxy>() {
        public String getName() {
            return "blink.mojom.Portal";
        }

        public int getVersion() {
            return 0;
        }

        public Portal_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Portal_Internal.Proxy(core, messageReceiver);
        }

        public Portal_Internal.Stub buildStub(Core core, Portal impl) {
            return new Portal_Internal.Stub(core, impl);
        }

        public Portal[] buildArray(int size) {
            return new Portal[size];
        }
    };

    private static final int NAVIGATE_ORDINAL = 0;

    private static final int ACTIVATE_ORDINAL = 1;

    private static final int POST_MESSAGE_TO_GUEST_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements Portal.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void navigate(Url url, Referrer referrer) {
            Portal_Internal.PortalNavigateParams _message = new Portal_Internal.PortalNavigateParams();
            _message.url = url;
            _message.referrer = referrer;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void activate(TransferableMessage data, Portal.ActivateResponse callback) {
            Portal_Internal.PortalActivateParams _message = new Portal_Internal.PortalActivateParams();
            _message.data = data;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new Portal_Internal.PortalActivateResponseParamsForwardToCallback(callback));
        }

        public void postMessageToGuest(TransferableMessage message, Origin targetOrigin) {
            Portal_Internal.PortalPostMessageToGuestParams _message = new Portal_Internal.PortalPostMessageToGuestParams();
            _message.message = message;
            _message.targetOrigin = targetOrigin;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<Portal> {
        Stub(Core core, Portal impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                Portal_Internal.PortalNavigateParams portalNavigateParams;
                Portal_Internal.PortalPostMessageToGuestParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Portal_Internal.MANAGER, messageWithHeader);
                    case 0:
                        portalNavigateParams = Portal_Internal.PortalNavigateParams.deserialize(messageWithHeader.getPayload());
                        ((Portal)getImpl()).navigate(portalNavigateParams.url, portalNavigateParams.referrer);
                        return true;
                    case 2:
                        data = Portal_Internal.PortalPostMessageToGuestParams.deserialize(messageWithHeader.getPayload());
                        ((Portal)getImpl()).postMessageToGuest(data.message, data.targetOrigin);
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
                Portal_Internal.PortalActivateParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), Portal_Internal.MANAGER, messageWithHeader, receiver);
                    case 1:
                        data = Portal_Internal.PortalActivateParams.deserialize(messageWithHeader.getPayload());
                        ((Portal)getImpl()).activate(data.data, new Portal_Internal.PortalActivateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class PortalNavigateParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public Referrer referrer;

        private PortalNavigateParams(int version) {
            super(24, version);
        }

        public PortalNavigateParams() {
            this(0);
        }

        public static PortalNavigateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PortalNavigateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PortalNavigateParams decode(Decoder decoder0) {
            PortalNavigateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PortalNavigateParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.referrer = Referrer.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode(this.referrer, 16, false);
        }
    }

    static final class PortalActivateParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public TransferableMessage data;

        private PortalActivateParams(int version) {
            super(16, version);
        }

        public PortalActivateParams() {
            this(0);
        }

        public static PortalActivateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PortalActivateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PortalActivateParams decode(Decoder decoder0) {
            PortalActivateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PortalActivateParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.data = TransferableMessage.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.data, 8, false);
        }
    }

    static final class PortalActivateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean wasAdopted;

        private PortalActivateResponseParams(int version) {
            super(16, version);
        }

        public PortalActivateResponseParams() {
            this(0);
        }

        public static PortalActivateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PortalActivateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PortalActivateResponseParams decode(Decoder decoder0) {
            PortalActivateResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PortalActivateResponseParams(elementsOrVersion);
                result.wasAdopted = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.wasAdopted, 8, 0);
        }
    }

    static class PortalActivateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Portal.ActivateResponse mCallback;

        PortalActivateResponseParamsForwardToCallback(Portal.ActivateResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                Portal_Internal.PortalActivateResponseParams response = Portal_Internal.PortalActivateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.wasAdopted));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class PortalActivateResponseParamsProxyToResponder implements Portal.ActivateResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        PortalActivateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean wasAdopted) {
            Portal_Internal.PortalActivateResponseParams _response = new Portal_Internal.PortalActivateResponseParams();
            _response.wasAdopted = wasAdopted.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class PortalPostMessageToGuestParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public TransferableMessage message;

        public Origin targetOrigin;

        private PortalPostMessageToGuestParams(int version) {
            super(24, version);
        }

        public PortalPostMessageToGuestParams() {
            this(0);
        }

        public static PortalPostMessageToGuestParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static PortalPostMessageToGuestParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static PortalPostMessageToGuestParams decode(Decoder decoder0) {
            PortalPostMessageToGuestParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new PortalPostMessageToGuestParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.message = TransferableMessage.decode(decoder1);
                decoder1 = decoder0.readPointer(16, true);
                result.targetOrigin = Origin.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.message, 8, false);
            encoder0.encode((Struct)this.targetOrigin, 16, true);
        }
    }
}
