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

class ControllerServiceWorker_Internal {
    public static final Interface.Manager<ControllerServiceWorker, ControllerServiceWorker.Proxy> MANAGER = new Interface.Manager<ControllerServiceWorker, ControllerServiceWorker.Proxy>() {
        public String getName() {
            return "blink.mojom.ControllerServiceWorker";
        }

        public int getVersion() {
            return 0;
        }

        public ControllerServiceWorker_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ControllerServiceWorker_Internal.Proxy(core, messageReceiver);
        }

        public ControllerServiceWorker_Internal.Stub buildStub(Core core, ControllerServiceWorker impl) {
            return new ControllerServiceWorker_Internal.Stub(core, impl);
        }

        public ControllerServiceWorker[] buildArray(int size) {
            return new ControllerServiceWorker[size];
        }
    };

    private static final int DISPATCH_FETCH_EVENT_FOR_SUBRESOURCE_ORDINAL = 0;

    private static final int CLONE_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements ControllerServiceWorker.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void dispatchFetchEventForSubresource(DispatchFetchEventParams params, ServiceWorkerFetchResponseCallback responseCallback, ControllerServiceWorker.DispatchFetchEventForSubresourceResponse callback) {
            ControllerServiceWorker_Internal.ControllerServiceWorkerDispatchFetchEventForSubresourceParams _message = new ControllerServiceWorker_Internal.ControllerServiceWorkerDispatchFetchEventForSubresourceParams();
            _message.params = params;
            _message.responseCallback = responseCallback;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ControllerServiceWorker_Internal.ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParamsForwardToCallback(callback));
        }

        public void clone(InterfaceRequest<ControllerServiceWorker> receiver) {
            ControllerServiceWorker_Internal.ControllerServiceWorkerCloneParams _message = new ControllerServiceWorker_Internal.ControllerServiceWorkerCloneParams();
            _message.receiver = receiver;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<ControllerServiceWorker> {
        Stub(Core core, ControllerServiceWorker impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ControllerServiceWorker_Internal.ControllerServiceWorkerCloneParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ControllerServiceWorker_Internal.MANAGER, messageWithHeader);
                    case 1:
                        data = ControllerServiceWorker_Internal.ControllerServiceWorkerCloneParams.deserialize(messageWithHeader.getPayload());
                        ((ControllerServiceWorker)getImpl()).clone(data.receiver);
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
                ControllerServiceWorker_Internal.ControllerServiceWorkerDispatchFetchEventForSubresourceParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), ControllerServiceWorker_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        data = ControllerServiceWorker_Internal.ControllerServiceWorkerDispatchFetchEventForSubresourceParams.deserialize(messageWithHeader.getPayload());
                        ((ControllerServiceWorker)getImpl()).dispatchFetchEventForSubresource(data.params, data.responseCallback, new ControllerServiceWorker_Internal.ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ControllerServiceWorkerDispatchFetchEventForSubresourceParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public DispatchFetchEventParams params;

        public ServiceWorkerFetchResponseCallback responseCallback;

        private ControllerServiceWorkerDispatchFetchEventForSubresourceParams(int version) {
            super(24, version);
        }

        public ControllerServiceWorkerDispatchFetchEventForSubresourceParams() {
            this(0);
        }

        public static ControllerServiceWorkerDispatchFetchEventForSubresourceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ControllerServiceWorkerDispatchFetchEventForSubresourceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ControllerServiceWorkerDispatchFetchEventForSubresourceParams decode(Decoder decoder0) {
            ControllerServiceWorkerDispatchFetchEventForSubresourceParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ControllerServiceWorkerDispatchFetchEventForSubresourceParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.params = DispatchFetchEventParams.decode(decoder1);
                result.responseCallback = (ServiceWorkerFetchResponseCallback)decoder0.readServiceInterface(16, false, ServiceWorkerFetchResponseCallback.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.params, 8, false);
            encoder0.encode(this.responseCallback, 16, false, ServiceWorkerFetchResponseCallback.MANAGER);
        }
    }

    static final class ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int status;

        private ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams(int version) {
            super(16, version);
        }

        public ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams() {
            this(0);
        }

        public static ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams decode(Decoder decoder0) {
            ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams(elementsOrVersion);
                result.status = decoder0.readInt(8);
                ServiceWorkerEventStatus.validate(result.status);
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

    static class ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ControllerServiceWorker.DispatchFetchEventForSubresourceResponse mCallback;

        ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParamsForwardToCallback(ControllerServiceWorker.DispatchFetchEventForSubresourceResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                ControllerServiceWorker_Internal.ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams response = ControllerServiceWorker_Internal.ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.status));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParamsProxyToResponder implements ControllerServiceWorker.DispatchFetchEventForSubresourceResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer status) {
            ControllerServiceWorker_Internal.ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams _response = new ControllerServiceWorker_Internal.ControllerServiceWorkerDispatchFetchEventForSubresourceResponseParams();
            _response.status = status.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ControllerServiceWorkerCloneParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<ControllerServiceWorker> receiver;

        private ControllerServiceWorkerCloneParams(int version) {
            super(16, version);
        }

        public ControllerServiceWorkerCloneParams() {
            this(0);
        }

        public static ControllerServiceWorkerCloneParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ControllerServiceWorkerCloneParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ControllerServiceWorkerCloneParams decode(Decoder decoder0) {
            ControllerServiceWorkerCloneParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ControllerServiceWorkerCloneParams(elementsOrVersion);
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
}
