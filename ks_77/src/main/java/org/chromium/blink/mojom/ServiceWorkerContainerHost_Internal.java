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
import org.chromium.url.mojom.Url;

class ServiceWorkerContainerHost_Internal {
    public static final Interface.Manager<ServiceWorkerContainerHost, ServiceWorkerContainerHost.Proxy> MANAGER = new Interface.Manager<ServiceWorkerContainerHost, ServiceWorkerContainerHost.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerContainerHost";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerContainerHost_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerContainerHost_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerContainerHost_Internal.Stub buildStub(Core core, ServiceWorkerContainerHost impl) {
            return new ServiceWorkerContainerHost_Internal.Stub(core, impl);
        }

        public ServiceWorkerContainerHost[] buildArray(int size) {
            return new ServiceWorkerContainerHost[size];
        }
    };

    private static final int REGISTER_ORDINAL = 0;

    private static final int GET_REGISTRATION_ORDINAL = 1;

    private static final int GET_REGISTRATIONS_ORDINAL = 2;

    private static final int GET_REGISTRATION_FOR_READY_ORDINAL = 3;

    private static final int ENSURE_CONTROLLER_SERVICE_WORKER_ORDINAL = 4;

    private static final int CLONE_CONTAINER_HOST_ORDINAL = 5;

    private static final int PING_ORDINAL = 6;

    private static final int HINT_TO_UPDATE_SERVICE_WORKER_ORDINAL = 7;

    private static final int ON_EXECUTION_READY_ORDINAL = 8;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerContainerHost.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void register(Url scriptUrl, ServiceWorkerRegistrationOptions options, ServiceWorkerContainerHost.RegisterResponse callback) {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostRegisterParams _message = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostRegisterParams();
            _message.scriptUrl = scriptUrl;
            _message.options = options;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostRegisterResponseParamsForwardToCallback(callback));
        }

        public void getRegistration(Url clientUrl, ServiceWorkerContainerHost.GetRegistrationResponse callback) {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationParams _message = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationParams();
            _message.clientUrl = clientUrl;
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationResponseParamsForwardToCallback(callback));
        }

        public void getRegistrations(ServiceWorkerContainerHost.GetRegistrationsResponse callback) {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationsParams _message = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationsParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationsResponseParamsForwardToCallback(callback));
        }

        public void getRegistrationForReady(ServiceWorkerContainerHost.GetRegistrationForReadyResponse callback) {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationForReadyParams _message = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationForReadyParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationForReadyResponseParamsForwardToCallback(callback));
        }

        public void ensureControllerServiceWorker(InterfaceRequest<ControllerServiceWorker> receiver, int purpose) {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostEnsureControllerServiceWorkerParams _message = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostEnsureControllerServiceWorkerParams();
            _message.receiver = receiver;
            _message.purpose = purpose;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(4)));
        }

        public void cloneContainerHost(InterfaceRequest<ServiceWorkerContainerHost> containerHost) {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostCloneContainerHostParams _message = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostCloneContainerHostParams();
            _message.containerHost = containerHost;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(5)));
        }

        public void ping(ServiceWorkerContainerHost.PingResponse callback) {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostPingParams _message = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostPingParams();
            getProxyHandler().getMessageReceiver().acceptWithResponder((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)), new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostPingResponseParamsForwardToCallback(callback));
        }

        public void hintToUpdateServiceWorker() {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostHintToUpdateServiceWorkerParams _message = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostHintToUpdateServiceWorkerParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(7)));
        }

        public void onExecutionReady() {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostOnExecutionReadyParams _message = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostOnExecutionReadyParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(8)));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerContainerHost> {
        Stub(Core core, ServiceWorkerContainerHost impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostEnsureControllerServiceWorkerParams serviceWorkerContainerHostEnsureControllerServiceWorkerParams;
                ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostCloneContainerHostParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerContainerHost_Internal.MANAGER, messageWithHeader);
                    case 4:
                        serviceWorkerContainerHostEnsureControllerServiceWorkerParams = ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostEnsureControllerServiceWorkerParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerContainerHost)getImpl()).ensureControllerServiceWorker(serviceWorkerContainerHostEnsureControllerServiceWorkerParams.receiver, serviceWorkerContainerHostEnsureControllerServiceWorkerParams.purpose);
                        return true;
                    case 5:
                        data = ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostCloneContainerHostParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerContainerHost)getImpl()).cloneContainerHost(data.containerHost);
                        return true;
                    case 7:
                        ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostHintToUpdateServiceWorkerParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerContainerHost)getImpl()).hintToUpdateServiceWorker();
                        return true;
                    case 8:
                        ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostOnExecutionReadyParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerContainerHost)getImpl()).onExecutionReady();
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
                ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostRegisterParams serviceWorkerContainerHostRegisterParams;
                ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1))
                    return false;
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(
                                getCore(), ServiceWorkerContainerHost_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        serviceWorkerContainerHostRegisterParams = ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostRegisterParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerContainerHost)getImpl()).register(serviceWorkerContainerHostRegisterParams.scriptUrl, serviceWorkerContainerHostRegisterParams.options, new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostRegisterResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        data = ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerContainerHost)getImpl()).getRegistration(data.clientUrl, new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationsParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerContainerHost)getImpl()).getRegistrations(new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationsResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationForReadyParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerContainerHost)getImpl()).getRegistrationForReady(new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationForReadyResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 6:
                        ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostPingParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerContainerHost)getImpl()).ping(new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostPingResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerContainerHostRegisterParams extends Struct {
        private static final int STRUCT_SIZE = 24;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url scriptUrl;

        public ServiceWorkerRegistrationOptions options;

        private ServiceWorkerContainerHostRegisterParams(int version) {
            super(24, version);
        }

        public ServiceWorkerContainerHostRegisterParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostRegisterParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostRegisterParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostRegisterParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostRegisterParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostRegisterParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.scriptUrl = Url.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.options = ServiceWorkerRegistrationOptions.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.scriptUrl, 8, false);
            encoder0.encode(this.options, 16, false);
        }
    }

    static final class ServiceWorkerContainerHostRegisterResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public String errorMsg;

        public ServiceWorkerRegistrationObjectInfo registration;

        private ServiceWorkerContainerHostRegisterResponseParams(int version) {
            super(32, version);
        }

        public ServiceWorkerContainerHostRegisterResponseParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostRegisterResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostRegisterResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostRegisterResponseParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostRegisterResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostRegisterResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                ServiceWorkerErrorType.validate(result.error);
                result.errorMsg = decoder0.readString(16, true);
                Decoder decoder1 = decoder0.readPointer(24, true);
                result.registration = ServiceWorkerRegistrationObjectInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.errorMsg, 16, true);
            encoder0.encode(this.registration, 24, true);
        }
    }

    static class ServiceWorkerContainerHostRegisterResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerContainerHost.RegisterResponse mCallback;

        ServiceWorkerContainerHostRegisterResponseParamsForwardToCallback(ServiceWorkerContainerHost.RegisterResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2))
                    return false;
                ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostRegisterResponseParams response = ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostRegisterResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.errorMsg, response.registration);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerContainerHostRegisterResponseParamsProxyToResponder implements ServiceWorkerContainerHost.RegisterResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerContainerHostRegisterResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, String errorMsg, ServiceWorkerRegistrationObjectInfo registration) {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostRegisterResponseParams _response = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostRegisterResponseParams();
            _response.error = error.intValue();
            _response.errorMsg = errorMsg;
            _response.registration = registration;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerContainerHostGetRegistrationParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public Url clientUrl;

        private ServiceWorkerContainerHostGetRegistrationParams(int version) {
            super(16, version);
        }

        public ServiceWorkerContainerHostGetRegistrationParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostGetRegistrationParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostGetRegistrationParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostGetRegistrationParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostGetRegistrationParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostGetRegistrationParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.clientUrl = Url.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct)this.clientUrl, 8, false);
        }
    }

    static final class ServiceWorkerContainerHostGetRegistrationResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public String errorMsg;

        public ServiceWorkerRegistrationObjectInfo registration;

        private ServiceWorkerContainerHostGetRegistrationResponseParams(int version) {
            super(32, version);
        }

        public ServiceWorkerContainerHostGetRegistrationResponseParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostGetRegistrationResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostGetRegistrationResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostGetRegistrationResponseParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostGetRegistrationResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostGetRegistrationResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                ServiceWorkerErrorType.validate(result.error);
                result.errorMsg = decoder0.readString(16, true);
                Decoder decoder1 = decoder0.readPointer(24, true);
                result.registration = ServiceWorkerRegistrationObjectInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.errorMsg, 16, true);
            encoder0.encode(this.registration, 24, true);
        }
    }

    static class ServiceWorkerContainerHostGetRegistrationResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerContainerHost.GetRegistrationResponse mCallback;

        ServiceWorkerContainerHostGetRegistrationResponseParamsForwardToCallback(ServiceWorkerContainerHost.GetRegistrationResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2))
                    return false;
                ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationResponseParams response = ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.errorMsg, response.registration);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerContainerHostGetRegistrationResponseParamsProxyToResponder implements ServiceWorkerContainerHost.GetRegistrationResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerContainerHostGetRegistrationResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, String errorMsg, ServiceWorkerRegistrationObjectInfo registration) {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationResponseParams _response = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationResponseParams();
            _response.error = error.intValue();
            _response.errorMsg = errorMsg;
            _response.registration = registration;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerContainerHostGetRegistrationsParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerContainerHostGetRegistrationsParams(int version) {
            super(8, version);
        }

        public ServiceWorkerContainerHostGetRegistrationsParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostGetRegistrationsParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostGetRegistrationsParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostGetRegistrationsParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostGetRegistrationsParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostGetRegistrationsParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerContainerHostGetRegistrationsResponseParams extends Struct {
        private static final int STRUCT_SIZE = 32;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public int error;

        public String errorMsg;

        public ServiceWorkerRegistrationObjectInfo[] infos;

        private ServiceWorkerContainerHostGetRegistrationsResponseParams(int version) {
            super(32, version);
        }

        public ServiceWorkerContainerHostGetRegistrationsResponseParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostGetRegistrationsResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostGetRegistrationsResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostGetRegistrationsResponseParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostGetRegistrationsResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostGetRegistrationsResponseParams(elementsOrVersion);
                result.error = decoder0.readInt(8);
                ServiceWorkerErrorType.validate(result.error);
                result.errorMsg = decoder0.readString(16, true);
                Decoder decoder1 = decoder0.readPointer(24, true);
                if (decoder1 == null) {
                    result.infos = null;
                } else {
                    DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                    result.infos = new ServiceWorkerRegistrationObjectInfo[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                        Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                        result.infos[i1] = ServiceWorkerRegistrationObjectInfo.decode(decoder2);
                    }
                }
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.error, 8);
            encoder0.encode(this.errorMsg, 16, true);
            if (this.infos == null) {
                encoder0.encodeNullPointer(24, true);
            } else {
                Encoder encoder1 = encoder0.encodePointerArray(this.infos.length, 24, -1);
                for (int i0 = 0; i0 < this.infos.length; i0++)
                    encoder1.encode(this.infos[i0], 8 + 8 * i0, false);
            }
        }
    }

    static class ServiceWorkerContainerHostGetRegistrationsResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerContainerHost.GetRegistrationsResponse mCallback;

        ServiceWorkerContainerHostGetRegistrationsResponseParamsForwardToCallback(ServiceWorkerContainerHost.GetRegistrationsResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2))
                    return false;
                ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationsResponseParams response = ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationsResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.error), response.errorMsg, response.infos);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerContainerHostGetRegistrationsResponseParamsProxyToResponder implements ServiceWorkerContainerHost.GetRegistrationsResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerContainerHostGetRegistrationsResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(Integer error, String errorMsg, ServiceWorkerRegistrationObjectInfo[] infos) {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationsResponseParams _response = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationsResponseParams();
            _response.error = error.intValue();
            _response.errorMsg = errorMsg;
            _response.infos = infos;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerContainerHostGetRegistrationForReadyParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerContainerHostGetRegistrationForReadyParams(int version) {
            super(8, version);
        }

        public ServiceWorkerContainerHostGetRegistrationForReadyParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostGetRegistrationForReadyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostGetRegistrationForReadyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostGetRegistrationForReadyParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostGetRegistrationForReadyParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostGetRegistrationForReadyParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerContainerHostGetRegistrationForReadyResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ServiceWorkerRegistrationObjectInfo registration;

        private ServiceWorkerContainerHostGetRegistrationForReadyResponseParams(int version) {
            super(16, version);
        }

        public ServiceWorkerContainerHostGetRegistrationForReadyResponseParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostGetRegistrationForReadyResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostGetRegistrationForReadyResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostGetRegistrationForReadyResponseParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostGetRegistrationForReadyResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostGetRegistrationForReadyResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.registration = ServiceWorkerRegistrationObjectInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.registration, 8, true);
        }
    }

    static class ServiceWorkerContainerHostGetRegistrationForReadyResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerContainerHost.GetRegistrationForReadyResponse mCallback;

        ServiceWorkerContainerHostGetRegistrationForReadyResponseParamsForwardToCallback(ServiceWorkerContainerHost.GetRegistrationForReadyResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2))
                    return false;
                ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationForReadyResponseParams response = ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationForReadyResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.registration);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerContainerHostGetRegistrationForReadyResponseParamsProxyToResponder implements ServiceWorkerContainerHost.GetRegistrationForReadyResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerContainerHostGetRegistrationForReadyResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call(ServiceWorkerRegistrationObjectInfo registration) {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationForReadyResponseParams _response = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostGetRegistrationForReadyResponseParams();
            _response.registration = registration;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerContainerHostEnsureControllerServiceWorkerParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<ControllerServiceWorker> receiver;

        public int purpose;

        private ServiceWorkerContainerHostEnsureControllerServiceWorkerParams(int version) {
            super(16, version);
        }

        public ServiceWorkerContainerHostEnsureControllerServiceWorkerParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostEnsureControllerServiceWorkerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostEnsureControllerServiceWorkerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostEnsureControllerServiceWorkerParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostEnsureControllerServiceWorkerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostEnsureControllerServiceWorkerParams(elementsOrVersion);
                result.receiver = decoder0.readInterfaceRequest(8, false);
                result.purpose = decoder0.readInt(12);
                ControllerServiceWorkerPurpose.validate(result.purpose);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.receiver, 8, false);
            encoder0.encode(this.purpose, 12);
        }
    }

    static final class ServiceWorkerContainerHostCloneContainerHostParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<ServiceWorkerContainerHost> containerHost;

        private ServiceWorkerContainerHostCloneContainerHostParams(int version) {
            super(16, version);
        }

        public ServiceWorkerContainerHostCloneContainerHostParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostCloneContainerHostParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostCloneContainerHostParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostCloneContainerHostParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostCloneContainerHostParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostCloneContainerHostParams(elementsOrVersion);
                result.containerHost = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.containerHost, 8, false);
        }
    }

    static final class ServiceWorkerContainerHostPingParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerContainerHostPingParams(int version) {
            super(8, version);
        }

        public ServiceWorkerContainerHostPingParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostPingParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostPingParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostPingParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostPingParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostPingParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerContainerHostPingResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerContainerHostPingResponseParams(int version) {
            super(8, version);
        }

        public ServiceWorkerContainerHostPingResponseParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostPingResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostPingResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostPingResponseParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostPingResponseParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostPingResponseParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static class ServiceWorkerContainerHostPingResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final ServiceWorkerContainerHost.PingResponse mCallback;

        ServiceWorkerContainerHostPingResponseParamsForwardToCallback(ServiceWorkerContainerHost.PingResponse callback) {
            this.mCallback = callback;
        }

        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(6, 2))
                    return false;
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    static class ServiceWorkerContainerHostPingResponseParamsProxyToResponder implements ServiceWorkerContainerHost.PingResponse {
        private final Core mCore;

        private final MessageReceiver mMessageReceiver;

        private final long mRequestId;

        ServiceWorkerContainerHostPingResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        public void call() {
            ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostPingResponseParams _response = new ServiceWorkerContainerHost_Internal.ServiceWorkerContainerHostPingResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(6, 2, this.mRequestId));
            this.mMessageReceiver.accept((Message)_message);
        }
    }

    static final class ServiceWorkerContainerHostHintToUpdateServiceWorkerParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerContainerHostHintToUpdateServiceWorkerParams(int version) {
            super(8, version);
        }

        public ServiceWorkerContainerHostHintToUpdateServiceWorkerParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostHintToUpdateServiceWorkerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostHintToUpdateServiceWorkerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostHintToUpdateServiceWorkerParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostHintToUpdateServiceWorkerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostHintToUpdateServiceWorkerParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    static final class ServiceWorkerContainerHostOnExecutionReadyParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceWorkerContainerHostOnExecutionReadyParams(int version) {
            super(8, version);
        }

        public ServiceWorkerContainerHostOnExecutionReadyParams() {
            this(0);
        }

        public static ServiceWorkerContainerHostOnExecutionReadyParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerContainerHostOnExecutionReadyParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerContainerHostOnExecutionReadyParams decode(Decoder decoder0) {
            ServiceWorkerContainerHostOnExecutionReadyParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerContainerHostOnExecutionReadyParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }
}
