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

class ServiceWorkerRegistrationObjectHost_Internal {
    public static final Interface.Manager<ServiceWorkerRegistrationObjectHost, ServiceWorkerRegistrationObjectHost.Proxy> MANAGER = new Interface.Manager<ServiceWorkerRegistrationObjectHost, ServiceWorkerRegistrationObjectHost.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerRegistrationObjectHost";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerRegistrationObjectHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerRegistrationObjectHost_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerRegistrationObjectHost_Internal.Stub buildStub(Core core, ServiceWorkerRegistrationObjectHost impl) {
            return new ServiceWorkerRegistrationObjectHost_Internal.Stub(core, impl);
        }

        public ServiceWorkerRegistrationObjectHost[] buildArray(int size) {
            return new ServiceWorkerRegistrationObjectHost[size];
        }
    };

    private static final int UPDATE_ORDINAL = 0;

    private static final int UNREGISTER_ORDINAL = 1;

    private static final int ENABLE_NAVIGATION_PRELOAD_ORDINAL = 2;

    private static final int GET_NAVIGATION_PRELOAD_STATE_ORDINAL = 3;

    private static final int SET_NAVIGATION_PRELOAD_HEADER_ORDINAL = 4;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerRegistrationObjectHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void update(ServiceWorkerRegistrationObjectHost.UpdateResponse callback) {
            ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUpdateParams _message = new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUpdateParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUpdateResponseParamsForwardToCallback(callback));
        }

        public void unregister(ServiceWorkerRegistrationObjectHost.UnregisterResponse callback) {
            ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUnregisterParams _message = new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUnregisterParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUnregisterResponseParamsForwardToCallback(callback));
        }

        public void enableNavigationPreload(boolean enable, ServiceWorkerRegistrationObjectHost.EnableNavigationPreloadResponse callback) {
            ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams _message = new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams();
            _message.enable = enable;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParamsForwardToCallback(callback));
        }

        public void getNavigationPreloadState(ServiceWorkerRegistrationObjectHost.GetNavigationPreloadStateResponse callback) {
            ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams _message = new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParamsForwardToCallback(callback));
        }

        public void setNavigationPreloadHeader(String value, ServiceWorkerRegistrationObjectHost.SetNavigationPreloadHeaderResponse callback) {
            ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams _message = new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams();
            _message.value = value;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)), new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParamsForwardToCallback(callback));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerRegistrationObjectHost> {
        Stub(Core core, ServiceWorkerRegistrationObjectHost impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerRegistrationObjectHost_Internal.MANAGER, messageWithHeader);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams serviceWorkerRegistrationObjectHostEnableNavigationPreloadParams;
                ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), ServiceWorkerRegistrationObjectHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUpdateParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerRegistrationObjectHost)getImpl()).update(new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUpdateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUnregisterParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerRegistrationObjectHost)getImpl()).unregister(new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUnregisterResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        serviceWorkerRegistrationObjectHostEnableNavigationPreloadParams = ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerRegistrationObjectHost)getImpl()).enableNavigationPreload(serviceWorkerRegistrationObjectHostEnableNavigationPreloadParams.enable, new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerRegistrationObjectHost)getImpl()).getNavigationPreloadState(new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 4:
                        data = ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerRegistrationObjectHost)getImpl()).setNavigationPreloadHeader(data.value, new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerRegistrationObjectHostUpdateParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerRegistrationObjectHostUpdateParams(int version) {
            super(8, version);
        }

        public ServiceWorkerRegistrationObjectHostUpdateParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectHostUpdateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectHostUpdateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectHostUpdateParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectHostUpdateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectHostUpdateParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerRegistrationObjectHostUpdateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public String errorMsg;

        private ServiceWorkerRegistrationObjectHostUpdateResponseParams(int version) {
            super(24, version);
        }

        public ServiceWorkerRegistrationObjectHostUpdateResponseParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectHostUpdateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectHostUpdateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectHostUpdateResponseParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectHostUpdateResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectHostUpdateResponseParams(elementsOrVersion);
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

    static class ServiceWorkerRegistrationObjectHostUpdateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerRegistrationObjectHost.UpdateResponse mCallback;

        ServiceWorkerRegistrationObjectHostUpdateResponseParamsForwardToCallback(ServiceWorkerRegistrationObjectHost.UpdateResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUpdateResponseParams response = ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUpdateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.errorMsg);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerRegistrationObjectHostUpdateResponseParamsProxyToResponder implements ServiceWorkerRegistrationObjectHost.UpdateResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerRegistrationObjectHostUpdateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, String errorMsg) {
            ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUpdateResponseParams _response = new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUpdateResponseParams();
            _response.error = error.intValue();
            _response.errorMsg = errorMsg;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerRegistrationObjectHostUnregisterParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerRegistrationObjectHostUnregisterParams(int version) {
            super(8, version);
        }

        public ServiceWorkerRegistrationObjectHostUnregisterParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectHostUnregisterParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectHostUnregisterParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectHostUnregisterParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectHostUnregisterParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectHostUnregisterParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerRegistrationObjectHostUnregisterResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public String errorMsg;

        private ServiceWorkerRegistrationObjectHostUnregisterResponseParams(int version) {
            super(24, version);
        }

        public ServiceWorkerRegistrationObjectHostUnregisterResponseParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectHostUnregisterResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectHostUnregisterResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectHostUnregisterResponseParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectHostUnregisterResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectHostUnregisterResponseParams(elementsOrVersion);
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

    static class ServiceWorkerRegistrationObjectHostUnregisterResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerRegistrationObjectHost.UnregisterResponse mCallback;

        ServiceWorkerRegistrationObjectHostUnregisterResponseParamsForwardToCallback(ServiceWorkerRegistrationObjectHost.UnregisterResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUnregisterResponseParams response = ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUnregisterResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.errorMsg);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerRegistrationObjectHostUnregisterResponseParamsProxyToResponder implements ServiceWorkerRegistrationObjectHost.UnregisterResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerRegistrationObjectHostUnregisterResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, String errorMsg) {
            ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUnregisterResponseParams _response = new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostUnregisterResponseParams();
            _response.error = error.intValue();
            _response.errorMsg = errorMsg;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public boolean enable;

        private ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams(int version) {
            super(16, version);
        }

        public ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectHostEnableNavigationPreloadParams(elementsOrVersion);
                result.enable = decoder0.readBoolean(8, 0);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.enable, 8, 0);
        }
    }

    static final class ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public String errorMsg;

        private ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams(int version) {
            super(24, version);
        }

        public ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams(elementsOrVersion);
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

    static class ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerRegistrationObjectHost.EnableNavigationPreloadResponse mCallback;

        ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParamsForwardToCallback(ServiceWorkerRegistrationObjectHost.EnableNavigationPreloadResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams response = ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.errorMsg);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParamsProxyToResponder implements ServiceWorkerRegistrationObjectHost.EnableNavigationPreloadResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, String errorMsg) {
            ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams _response = new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostEnableNavigationPreloadResponseParams();
            _response.error = error.intValue();
            _response.errorMsg = errorMsg;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams(int version) {
            super(8, version);
        }

        public ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public String errorMsg;

        public NavigationPreloadState state;

        private ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams(int version) {
            super(32, version);
        }

        public ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                ServiceWorkerErrorType.validate(result.error);
                result.errorMsg = decoder0.readString(16, true);
                Decoder decoder1 = decoder0.readPointer(24, true);
                result.state = NavigationPreloadState.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.errorMsg, 16, true);
            encoder0.encode(this.state, 24, true);
        }
    }

    static class ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerRegistrationObjectHost.GetNavigationPreloadStateResponse mCallback;

        ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParamsForwardToCallback(ServiceWorkerRegistrationObjectHost.GetNavigationPreloadStateResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams response = ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.errorMsg, response.state);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParamsProxyToResponder implements ServiceWorkerRegistrationObjectHost.GetNavigationPreloadStateResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, String errorMsg, NavigationPreloadState state) {
            ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams _response = new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostGetNavigationPreloadStateResponseParams();
            _response.error = error.intValue();
            _response.errorMsg = errorMsg;
            _response.state = state;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public String value;

        private ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams(int version) {
            super(16, version);
        }

        public ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderParams(elementsOrVersion);
                result.value = decoder0.readString(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.value, 8, false);
        }
    }

    static final class ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public String errorMsg;

        private ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams(int version) {
            super(24, version);
        }

        public ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams() {
            this(0);
        }

        public static ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams decode(Decoder decoder0) {
            ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams(elementsOrVersion);
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

    static class ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerRegistrationObjectHost.SetNavigationPreloadHeaderResponse mCallback;

        ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParamsForwardToCallback(ServiceWorkerRegistrationObjectHost.SetNavigationPreloadHeaderResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(4, 2))
                    return false;
                ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams response = ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.errorMsg);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParamsProxyToResponder implements ServiceWorkerRegistrationObjectHost.SetNavigationPreloadHeaderResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, String errorMsg) {
            ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams _response = new ServiceWorkerRegistrationObjectHost_Internal.ServiceWorkerRegistrationObjectHostSetNavigationPreloadHeaderResponseParams();
            _response.error = error.intValue();
            _response.errorMsg = errorMsg;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }
}
