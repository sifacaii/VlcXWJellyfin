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

class ServiceWorkerHost_Internal {
    public static final Interface.Manager<ServiceWorkerHost, ServiceWorkerHost.Proxy> MANAGER = new Interface.Manager<ServiceWorkerHost, ServiceWorkerHost.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerHost";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerHost_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerHost_Internal.Stub buildStub(Core core, ServiceWorkerHost impl) {
            return new ServiceWorkerHost_Internal.Stub(core, impl);
        }

        public ServiceWorkerHost[] buildArray(int size) {
            return new ServiceWorkerHost[size];
        }
    };

    private static final int SET_CACHED_METADATA_ORDINAL = 0;

    private static final int CLEAR_CACHED_METADATA_ORDINAL = 1;

    private static final int GET_CLIENTS_ORDINAL = 2;

    private static final int GET_CLIENT_ORDINAL = 3;

    private static final int OPEN_NEW_TAB_ORDINAL = 4;

    private static final int OPEN_PAYMENT_HANDLER_WINDOW_ORDINAL = 5;

    private static final int POST_MESSAGE_TO_CLIENT_ORDINAL = 6;

    private static final int FOCUS_CLIENT_ORDINAL = 7;

    private static final int NAVIGATE_CLIENT_ORDINAL = 8;

    private static final int SKIP_WAITING_ORDINAL = 9;

    private static final int CLAIM_CLIENTS_ORDINAL = 10;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void setCachedMetadata(Url url, byte[] data) {
            ServiceWorkerHost_Internal.ServiceWorkerHostSetCachedMetadataParams _message = new ServiceWorkerHost_Internal.ServiceWorkerHostSetCachedMetadataParams();
            _message.url = url;
            _message.data = data;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void clearCachedMetadata(Url url) {
            ServiceWorkerHost_Internal.ServiceWorkerHostClearCachedMetadataParams _message = new ServiceWorkerHost_Internal.ServiceWorkerHostClearCachedMetadataParams();
            _message.url = url;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void getClients(ServiceWorkerClientQueryOptions options, ServiceWorkerHost.GetClientsResponse callback) {
            ServiceWorkerHost_Internal.ServiceWorkerHostGetClientsParams _message = new ServiceWorkerHost_Internal.ServiceWorkerHostGetClientsParams();
            _message.options = options;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new ServiceWorkerHost_Internal.ServiceWorkerHostGetClientsResponseParamsForwardToCallback(callback));
        }

        public void getClient(String clientUuid, ServiceWorkerHost.GetClientResponse callback) {
            ServiceWorkerHost_Internal.ServiceWorkerHostGetClientParams _message = new ServiceWorkerHost_Internal.ServiceWorkerHostGetClientParams();
            _message.clientUuid = clientUuid;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new ServiceWorkerHost_Internal.ServiceWorkerHostGetClientResponseParamsForwardToCallback(callback));
        }

        public void openNewTab(Url url, ServiceWorkerHost.OpenNewTabResponse callback) {
            ServiceWorkerHost_Internal.ServiceWorkerHostOpenNewTabParams _message = new ServiceWorkerHost_Internal.ServiceWorkerHostOpenNewTabParams();
            _message.url = url;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new ServiceWorkerHost_Internal.ServiceWorkerHostOpenNewTabResponseParamsForwardToCallback(callback));
        }

        public void openPaymentHandlerWindow(Url url, ServiceWorkerHost.OpenPaymentHandlerWindowResponse callback) {
            ServiceWorkerHost_Internal.ServiceWorkerHostOpenPaymentHandlerWindowParams _message = new ServiceWorkerHost_Internal.ServiceWorkerHostOpenPaymentHandlerWindowParams();
            _message.url = url;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)), new ServiceWorkerHost_Internal.ServiceWorkerHostOpenPaymentHandlerWindowResponseParamsForwardToCallback(callback));
        }

        public void postMessageToClient(String clientUuid, TransferableMessage message) {
            ServiceWorkerHost_Internal.ServiceWorkerHostPostMessageToClientParams _message = new ServiceWorkerHost_Internal.ServiceWorkerHostPostMessageToClientParams();
            _message.clientUuid = clientUuid;
            _message.message = message;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6)));
        }

        public void focusClient(String clientUuid, ServiceWorkerHost.FocusClientResponse callback) {
            ServiceWorkerHost_Internal.ServiceWorkerHostFocusClientParams _message = new ServiceWorkerHost_Internal.ServiceWorkerHostFocusClientParams();
            _message.clientUuid = clientUuid;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)), new ServiceWorkerHost_Internal.ServiceWorkerHostFocusClientResponseParamsForwardToCallback(callback));
        }

        public void navigateClient(String clientUuid, Url url, ServiceWorkerHost.NavigateClientResponse callback) {
            ServiceWorkerHost_Internal.ServiceWorkerHostNavigateClientParams _message = new ServiceWorkerHost_Internal.ServiceWorkerHostNavigateClientParams();
            _message.clientUuid = clientUuid;
            _message.url = url;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)), new ServiceWorkerHost_Internal.ServiceWorkerHostNavigateClientResponseParamsForwardToCallback(callback));
        }

        public void skipWaiting(ServiceWorkerHost.SkipWaitingResponse callback) {
            ServiceWorkerHost_Internal.ServiceWorkerHostSkipWaitingParams _message = new ServiceWorkerHost_Internal.ServiceWorkerHostSkipWaitingParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)), new ServiceWorkerHost_Internal.ServiceWorkerHostSkipWaitingResponseParamsForwardToCallback(callback));
        }

        public void claimClients(ServiceWorkerHost.ClaimClientsResponse callback) {
            ServiceWorkerHost_Internal.ServiceWorkerHostClaimClientsParams _message = new ServiceWorkerHost_Internal.ServiceWorkerHostClaimClientsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)), new ServiceWorkerHost_Internal.ServiceWorkerHostClaimClientsResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerHost> {
        Stub(Core core, ServiceWorkerHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorkerHost_Internal.ServiceWorkerHostSetCachedMetadataParams serviceWorkerHostSetCachedMetadataParams;
                ServiceWorkerHost_Internal.ServiceWorkerHostClearCachedMetadataParams serviceWorkerHostClearCachedMetadataParams;
                ServiceWorkerHost_Internal.ServiceWorkerHostPostMessageToClientParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerHost_Internal.MANAGER, messageWithHeader);
                    case 0:
                        serviceWorkerHostSetCachedMetadataParams = ServiceWorkerHost_Internal.ServiceWorkerHostSetCachedMetadataParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerHost)getImpl()).setCachedMetadata(serviceWorkerHostSetCachedMetadataParams.url, serviceWorkerHostSetCachedMetadataParams.data);
                        return true;
                    case 1:
                        serviceWorkerHostClearCachedMetadataParams = ServiceWorkerHost_Internal.ServiceWorkerHostClearCachedMetadataParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerHost)getImpl()).clearCachedMetadata(serviceWorkerHostClearCachedMetadataParams.url);
                        return true;
                    case 6:
                        data = ServiceWorkerHost_Internal.ServiceWorkerHostPostMessageToClientParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerHost)getImpl()).postMessageToClient(data.clientUuid, data.message);
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
                ServiceWorkerHost_Internal.ServiceWorkerHostGetClientsParams serviceWorkerHostGetClientsParams;
                ServiceWorkerHost_Internal.ServiceWorkerHostGetClientParams serviceWorkerHostGetClientParams;
                ServiceWorkerHost_Internal.ServiceWorkerHostOpenNewTabParams serviceWorkerHostOpenNewTabParams;
                ServiceWorkerHost_Internal.ServiceWorkerHostOpenPaymentHandlerWindowParams serviceWorkerHostOpenPaymentHandlerWindowParams;
                ServiceWorkerHost_Internal.ServiceWorkerHostFocusClientParams serviceWorkerHostFocusClientParams;
                ServiceWorkerHost_Internal.ServiceWorkerHostNavigateClientParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), ServiceWorkerHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 2:
                        serviceWorkerHostGetClientsParams = ServiceWorkerHost_Internal.ServiceWorkerHostGetClientsParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerHost)getImpl()).getClients(serviceWorkerHostGetClientsParams.options, new ServiceWorkerHost_Internal.ServiceWorkerHostGetClientsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        serviceWorkerHostGetClientParams = ServiceWorkerHost_Internal.ServiceWorkerHostGetClientParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerHost)getImpl()).getClient(serviceWorkerHostGetClientParams.clientUuid, new ServiceWorkerHost_Internal.ServiceWorkerHostGetClientResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        serviceWorkerHostOpenNewTabParams = ServiceWorkerHost_Internal.ServiceWorkerHostOpenNewTabParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerHost)getImpl()).openNewTab(serviceWorkerHostOpenNewTabParams.url, new ServiceWorkerHost_Internal.ServiceWorkerHostOpenNewTabResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 5:
                        serviceWorkerHostOpenPaymentHandlerWindowParams = ServiceWorkerHost_Internal.ServiceWorkerHostOpenPaymentHandlerWindowParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerHost)getImpl()).openPaymentHandlerWindow(serviceWorkerHostOpenPaymentHandlerWindowParams.url, new ServiceWorkerHost_Internal.ServiceWorkerHostOpenPaymentHandlerWindowResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 7:
                        serviceWorkerHostFocusClientParams = ServiceWorkerHost_Internal.ServiceWorkerHostFocusClientParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerHost)getImpl()).focusClient(serviceWorkerHostFocusClientParams.clientUuid, new ServiceWorkerHost_Internal.ServiceWorkerHostFocusClientResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 8:
                        data = ServiceWorkerHost_Internal.ServiceWorkerHostNavigateClientParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerHost)getImpl()).navigateClient(data.clientUuid, data.url, new ServiceWorkerHost_Internal.ServiceWorkerHostNavigateClientResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 9:
                        ServiceWorkerHost_Internal.ServiceWorkerHostSkipWaitingParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerHost)getImpl()).skipWaiting(new ServiceWorkerHost_Internal.ServiceWorkerHostSkipWaitingResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 10:
                        ServiceWorkerHost_Internal.ServiceWorkerHostClaimClientsParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerHost)getImpl()).claimClients(new ServiceWorkerHost_Internal.ServiceWorkerHostClaimClientsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerHostSetCachedMetadataParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        public byte[] data;

        private ServiceWorkerHostSetCachedMetadataParams(int version) {
            super(24, version);
        }

        public ServiceWorkerHostSetCachedMetadataParams() {
            this(0);
        }

        public static ServiceWorkerHostSetCachedMetadataParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostSetCachedMetadataParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostSetCachedMetadataParams decode(Decoder decoder0) {
            ServiceWorkerHostSetCachedMetadataParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostSetCachedMetadataParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
                result.data = decoder0.readBytes(16, 0, -1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
            encoder0.encode(this.data, 16, 0, -1);
        }
    }

    static final class ServiceWorkerHostClearCachedMetadataParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        private ServiceWorkerHostClearCachedMetadataParams(int version) {
            super(16, version);
        }

        public ServiceWorkerHostClearCachedMetadataParams() {
            this(0);
        }

        public static ServiceWorkerHostClearCachedMetadataParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostClearCachedMetadataParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostClearCachedMetadataParams decode(Decoder decoder0) {
            ServiceWorkerHostClearCachedMetadataParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostClearCachedMetadataParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
        }
    }

    static final class ServiceWorkerHostGetClientsParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ServiceWorkerClientQueryOptions options;

        private ServiceWorkerHostGetClientsParams(int version) {
            super(16, version);
        }

        public ServiceWorkerHostGetClientsParams() {
            this(0);
        }

        public static ServiceWorkerHostGetClientsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostGetClientsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostGetClientsParams decode(Decoder decoder0) {
            ServiceWorkerHostGetClientsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostGetClientsParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.options = ServiceWorkerClientQueryOptions.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.options, 8, false);
        }
    }

    static final class ServiceWorkerHostGetClientsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ServiceWorkerClientInfo[] clients;

        private ServiceWorkerHostGetClientsResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerHostGetClientsResponseParams() {
            this(0);
        }

        public static ServiceWorkerHostGetClientsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostGetClientsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostGetClientsResponseParams decode(Decoder decoder0) {
            ServiceWorkerHostGetClientsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostGetClientsResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.clients = new ServiceWorkerClientInfo[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                    result.clients[i1] = ServiceWorkerClientInfo.decode(decoder2);
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            if (this.clients == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.clients.length, 8, -1);
                for (int i0 = 0; i0 < this.clients.length; i0++)
                    encoder1.encode(this.clients[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class ServiceWorkerHostGetClientsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerHost.GetClientsResponse mCallback;

        ServiceWorkerHostGetClientsResponseParamsForwardToCallback(ServiceWorkerHost.GetClientsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                ServiceWorkerHost_Internal.ServiceWorkerHostGetClientsResponseParams response = ServiceWorkerHost_Internal.ServiceWorkerHostGetClientsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.clients);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerHostGetClientsResponseParamsProxyToResponder implements ServiceWorkerHost.GetClientsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerHostGetClientsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(ServiceWorkerClientInfo[] clients) {
            ServiceWorkerHost_Internal.ServiceWorkerHostGetClientsResponseParams _response = new ServiceWorkerHost_Internal.ServiceWorkerHostGetClientsResponseParams();
            _response.clients = clients;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerHostGetClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String clientUuid;

        private ServiceWorkerHostGetClientParams(int version) {
            super(16, version);
        }

        public ServiceWorkerHostGetClientParams() {
            this(0);
        }

        public static ServiceWorkerHostGetClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostGetClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostGetClientParams decode(Decoder decoder0) {
            ServiceWorkerHostGetClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostGetClientParams(elementsOrVersion);
                result.clientUuid = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.clientUuid, 8, false);
        }
    }

    static final class ServiceWorkerHostGetClientResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ServiceWorkerClientInfo client;

        private ServiceWorkerHostGetClientResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerHostGetClientResponseParams() {
            this(0);
        }

        public static ServiceWorkerHostGetClientResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostGetClientResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostGetClientResponseParams decode(Decoder decoder0) {
            ServiceWorkerHostGetClientResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostGetClientResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.client = ServiceWorkerClientInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.client, 8, true);
        }
    }

    static class ServiceWorkerHostGetClientResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerHost.GetClientResponse mCallback;

        ServiceWorkerHostGetClientResponseParamsForwardToCallback(ServiceWorkerHost.GetClientResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                ServiceWorkerHost_Internal.ServiceWorkerHostGetClientResponseParams response = ServiceWorkerHost_Internal.ServiceWorkerHostGetClientResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.client);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerHostGetClientResponseParamsProxyToResponder implements ServiceWorkerHost.GetClientResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerHostGetClientResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(ServiceWorkerClientInfo client) {
            ServiceWorkerHost_Internal.ServiceWorkerHostGetClientResponseParams _response = new ServiceWorkerHost_Internal.ServiceWorkerHostGetClientResponseParams();
            _response.client = client;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerHostOpenNewTabParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        private ServiceWorkerHostOpenNewTabParams(int version) {
            super(16, version);
        }

        public ServiceWorkerHostOpenNewTabParams() {
            this(0);
        }

        public static ServiceWorkerHostOpenNewTabParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostOpenNewTabParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostOpenNewTabParams decode(Decoder decoder0) {
            ServiceWorkerHostOpenNewTabParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostOpenNewTabParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
        }
    }

    static final class ServiceWorkerHostOpenNewTabResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        public ServiceWorkerClientInfo client;

        public String errorMsg;

        private ServiceWorkerHostOpenNewTabResponseParams(int version) {
            super(32, version);
        }

        public ServiceWorkerHostOpenNewTabResponseParams() {
            this(0);
        }

        public static ServiceWorkerHostOpenNewTabResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostOpenNewTabResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostOpenNewTabResponseParams decode(Decoder decoder0) {
            ServiceWorkerHostOpenNewTabResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostOpenNewTabResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.client = ServiceWorkerClientInfo.decode(decoder1);
                result.errorMsg = decoder0.readString(24, true);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
            encoder0.encode(this.client, 16, true);
            encoder0.encode(this.errorMsg, 24, true);
        }
    }

    static class ServiceWorkerHostOpenNewTabResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerHost.OpenNewTabResponse mCallback;

        ServiceWorkerHostOpenNewTabResponseParamsForwardToCallback(ServiceWorkerHost.OpenNewTabResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                ServiceWorkerHost_Internal.ServiceWorkerHostOpenNewTabResponseParams response = ServiceWorkerHost_Internal.ServiceWorkerHostOpenNewTabResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), response.client, response.errorMsg);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerHostOpenNewTabResponseParamsProxyToResponder implements ServiceWorkerHost.OpenNewTabResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerHostOpenNewTabResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success, ServiceWorkerClientInfo client, String errorMsg) {
            ServiceWorkerHost_Internal.ServiceWorkerHostOpenNewTabResponseParams _response = new ServiceWorkerHost_Internal.ServiceWorkerHostOpenNewTabResponseParams();
            _response.success = success.booleanValue();
            _response.client = client;
            _response.errorMsg = errorMsg;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerHostOpenPaymentHandlerWindowParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url url;

        private ServiceWorkerHostOpenPaymentHandlerWindowParams(int version) {
            super(16, version);
        }

        public ServiceWorkerHostOpenPaymentHandlerWindowParams() {
            this(0);
        }

        public static ServiceWorkerHostOpenPaymentHandlerWindowParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostOpenPaymentHandlerWindowParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostOpenPaymentHandlerWindowParams decode(Decoder decoder0) {
            ServiceWorkerHostOpenPaymentHandlerWindowParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostOpenPaymentHandlerWindowParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.url = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.url, 8, false);
        }
    }

    static final class ServiceWorkerHostOpenPaymentHandlerWindowResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        public ServiceWorkerClientInfo client;

        public String errorMsg;

        private ServiceWorkerHostOpenPaymentHandlerWindowResponseParams(int version) {
            super(32, version);
        }

        public ServiceWorkerHostOpenPaymentHandlerWindowResponseParams() {
            this(0);
        }

        public static ServiceWorkerHostOpenPaymentHandlerWindowResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostOpenPaymentHandlerWindowResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostOpenPaymentHandlerWindowResponseParams decode(Decoder decoder0) {
            ServiceWorkerHostOpenPaymentHandlerWindowResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostOpenPaymentHandlerWindowResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.client = ServiceWorkerClientInfo.decode(decoder1);
                result.errorMsg = decoder0.readString(24, true);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
            encoder0.encode(this.client, 16, true);
            encoder0.encode(this.errorMsg, 24, true);
        }
    }

    static class ServiceWorkerHostOpenPaymentHandlerWindowResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerHost.OpenPaymentHandlerWindowResponse mCallback;

        ServiceWorkerHostOpenPaymentHandlerWindowResponseParamsForwardToCallback(ServiceWorkerHost.OpenPaymentHandlerWindowResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(5, 2))
                    return false;
                ServiceWorkerHost_Internal.ServiceWorkerHostOpenPaymentHandlerWindowResponseParams response = ServiceWorkerHost_Internal.ServiceWorkerHostOpenPaymentHandlerWindowResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), response.client, response.errorMsg);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerHostOpenPaymentHandlerWindowResponseParamsProxyToResponder implements ServiceWorkerHost.OpenPaymentHandlerWindowResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerHostOpenPaymentHandlerWindowResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success, ServiceWorkerClientInfo client, String errorMsg) {
            ServiceWorkerHost_Internal.ServiceWorkerHostOpenPaymentHandlerWindowResponseParams _response = new ServiceWorkerHost_Internal.ServiceWorkerHostOpenPaymentHandlerWindowResponseParams();
            _response.success = success.booleanValue();
            _response.client = client;
            _response.errorMsg = errorMsg;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerHostPostMessageToClientParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String clientUuid;

        public TransferableMessage message;

        private ServiceWorkerHostPostMessageToClientParams(int version) {
            super(24, version);
        }

        public ServiceWorkerHostPostMessageToClientParams() {
            this(0);
        }

        public static ServiceWorkerHostPostMessageToClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostPostMessageToClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostPostMessageToClientParams decode(Decoder decoder0) {
            ServiceWorkerHostPostMessageToClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostPostMessageToClientParams(elementsOrVersion);
                result.clientUuid = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.message = TransferableMessage.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.clientUuid, 8, false);
            encoder0.encode(this.message, 16, false);
        }
    }

    static final class ServiceWorkerHostFocusClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String clientUuid;

        private ServiceWorkerHostFocusClientParams(int version) {
            super(16, version);
        }

        public ServiceWorkerHostFocusClientParams() {
            this(0);
        }

        public static ServiceWorkerHostFocusClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostFocusClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostFocusClientParams decode(Decoder decoder0) {
            ServiceWorkerHostFocusClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostFocusClientParams(elementsOrVersion);
                result.clientUuid = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.clientUuid, 8, false);
        }
    }

    static final class ServiceWorkerHostFocusClientResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ServiceWorkerClientInfo client;

        private ServiceWorkerHostFocusClientResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerHostFocusClientResponseParams() {
            this(0);
        }

        public static ServiceWorkerHostFocusClientResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostFocusClientResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostFocusClientResponseParams decode(Decoder decoder0) {
            ServiceWorkerHostFocusClientResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostFocusClientResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.client = ServiceWorkerClientInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.client, 8, true);
        }
    }

    static class ServiceWorkerHostFocusClientResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerHost.FocusClientResponse mCallback;

        ServiceWorkerHostFocusClientResponseParamsForwardToCallback(ServiceWorkerHost.FocusClientResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(7, 2))
                    return false;
                ServiceWorkerHost_Internal.ServiceWorkerHostFocusClientResponseParams response = ServiceWorkerHost_Internal.ServiceWorkerHostFocusClientResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.client);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerHostFocusClientResponseParamsProxyToResponder implements ServiceWorkerHost.FocusClientResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerHostFocusClientResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(ServiceWorkerClientInfo client) {
            ServiceWorkerHost_Internal.ServiceWorkerHostFocusClientResponseParams _response = new ServiceWorkerHost_Internal.ServiceWorkerHostFocusClientResponseParams();
            _response.client = client;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(7, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerHostNavigateClientParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String clientUuid;

        public Url url;

        private ServiceWorkerHostNavigateClientParams(int version) {
            super(24, version);
        }

        public ServiceWorkerHostNavigateClientParams() {
            this(0);
        }

        public static ServiceWorkerHostNavigateClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostNavigateClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostNavigateClientParams decode(Decoder decoder0) {
            ServiceWorkerHostNavigateClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostNavigateClientParams(elementsOrVersion);
                result.clientUuid = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.url = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.clientUuid, 8, false);
            encoder0.encode((Struct)this.url, 16, false);
        }
    }

    static final class ServiceWorkerHostNavigateClientResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        public ServiceWorkerClientInfo client;

        public String errorMsg;

        private ServiceWorkerHostNavigateClientResponseParams(int version) {
            super(32, version);
        }

        public ServiceWorkerHostNavigateClientResponseParams() {
            this(0);
        }

        public static ServiceWorkerHostNavigateClientResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostNavigateClientResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostNavigateClientResponseParams decode(Decoder decoder0) {
            ServiceWorkerHostNavigateClientResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostNavigateClientResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
                Decoder decoder1 = decoder0.readPointer(16, true);
                result.client = ServiceWorkerClientInfo.decode(decoder1);
                result.errorMsg = decoder0.readString(24, true);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
            encoder0.encode(this.client, 16, true);
            encoder0.encode(this.errorMsg, 24, true);
        }
    }

    static class ServiceWorkerHostNavigateClientResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerHost.NavigateClientResponse mCallback;

        ServiceWorkerHostNavigateClientResponseParamsForwardToCallback(ServiceWorkerHost.NavigateClientResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(8, 2))
                    return false;
                ServiceWorkerHost_Internal.ServiceWorkerHostNavigateClientResponseParams response = ServiceWorkerHost_Internal.ServiceWorkerHostNavigateClientResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success), response.client, response.errorMsg);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerHostNavigateClientResponseParamsProxyToResponder implements ServiceWorkerHost.NavigateClientResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerHostNavigateClientResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success, ServiceWorkerClientInfo client, String errorMsg) {
            ServiceWorkerHost_Internal.ServiceWorkerHostNavigateClientResponseParams _response = new ServiceWorkerHost_Internal.ServiceWorkerHostNavigateClientResponseParams();
            _response.success = success.booleanValue();
            _response.client = client;
            _response.errorMsg = errorMsg;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(8, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerHostSkipWaitingParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerHostSkipWaitingParams(int version) {
            super(8, version);
        }

        public ServiceWorkerHostSkipWaitingParams() {
            this(0);
        }

        public static ServiceWorkerHostSkipWaitingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostSkipWaitingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostSkipWaitingParams decode(Decoder decoder0) {
            ServiceWorkerHostSkipWaitingParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostSkipWaitingParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerHostSkipWaitingResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean success;

        private ServiceWorkerHostSkipWaitingResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerHostSkipWaitingResponseParams() {
            this(0);
        }

        public static ServiceWorkerHostSkipWaitingResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostSkipWaitingResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostSkipWaitingResponseParams decode(Decoder decoder0) {
            ServiceWorkerHostSkipWaitingResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostSkipWaitingResponseParams(elementsOrVersion);
                result.success = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.success, 8, 0);
        }
    }

    static class ServiceWorkerHostSkipWaitingResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerHost.SkipWaitingResponse mCallback;

        ServiceWorkerHostSkipWaitingResponseParamsForwardToCallback(ServiceWorkerHost.SkipWaitingResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(9, 2))
                    return false;
                ServiceWorkerHost_Internal.ServiceWorkerHostSkipWaitingResponseParams response = ServiceWorkerHost_Internal.ServiceWorkerHostSkipWaitingResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Boolean.valueOf(response.success));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerHostSkipWaitingResponseParamsProxyToResponder implements ServiceWorkerHost.SkipWaitingResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerHostSkipWaitingResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Boolean success) {
            ServiceWorkerHost_Internal.ServiceWorkerHostSkipWaitingResponseParams _response = new ServiceWorkerHost_Internal.ServiceWorkerHostSkipWaitingResponseParams();
            _response.success = success.booleanValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(9, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerHostClaimClientsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerHostClaimClientsParams(int version) {
            super(8, version);
        }

        public ServiceWorkerHostClaimClientsParams() {
            this(0);
        }

        public static ServiceWorkerHostClaimClientsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostClaimClientsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostClaimClientsParams decode(Decoder decoder0) {
            ServiceWorkerHostClaimClientsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostClaimClientsParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerHostClaimClientsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public String errorMsg;

        private ServiceWorkerHostClaimClientsResponseParams(int version) {
            super(24, version);
        }

        public ServiceWorkerHostClaimClientsResponseParams() {
            this(0);
        }

        public static ServiceWorkerHostClaimClientsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerHostClaimClientsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerHostClaimClientsResponseParams decode(Decoder decoder0) {
            ServiceWorkerHostClaimClientsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerHostClaimClientsResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                ServiceWorkerErrorType.validate(result.error);
                result.errorMsg = decoder0.readString(16, true);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.errorMsg, 16, true);
        }
    }

    static class ServiceWorkerHostClaimClientsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerHost.ClaimClientsResponse mCallback;

        ServiceWorkerHostClaimClientsResponseParamsForwardToCallback(ServiceWorkerHost.ClaimClientsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(10, 2))
                    return false;
                ServiceWorkerHost_Internal.ServiceWorkerHostClaimClientsResponseParams response = ServiceWorkerHost_Internal.ServiceWorkerHostClaimClientsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.errorMsg);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerHostClaimClientsResponseParamsProxyToResponder implements ServiceWorkerHost.ClaimClientsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerHostClaimClientsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, String errorMsg) {
            ServiceWorkerHost_Internal.ServiceWorkerHostClaimClientsResponseParams _response = new ServiceWorkerHost_Internal.ServiceWorkerHostClaimClientsResponseParams();
            _response.error = error.intValue();
            _response.errorMsg = errorMsg;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(10, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
