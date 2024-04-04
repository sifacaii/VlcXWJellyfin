package org.chromium.service_manager.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
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
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.service_manager.mojom.Service;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service_Internal.class */
class Service_Internal {
    public static final Interface.Manager<Service, Service.Proxy> MANAGER = new Interface.Manager<Service, Service.Proxy>() { // from class: org.chromium.service_manager.mojom.Service_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "service_manager.mojom.Service";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public Service.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, Service impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Service[] buildArray(int size) {
            return new Service[size];
        }
    };
    private static final int ON_START_ORDINAL = 0;
    private static final int ON_BIND_INTERFACE_ORDINAL = 1;
    private static final int CREATE_PACKAGED_SERVICE_INSTANCE_ORDINAL = 2;

    Service_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements Service.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.service_manager.mojom.Service
        public void onStart(Identity identity, Service.OnStartResponse callback) {
            ServiceOnStartParams _message = new ServiceOnStartParams();
            _message.identity = identity;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ServiceOnStartResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.service_manager.mojom.Service
        public void onBindInterface(BindSourceInfo source, String interfaceName, MessagePipeHandle interfacePipe, Service.OnBindInterfaceResponse callback) {
            ServiceOnBindInterfaceParams _message = new ServiceOnBindInterfaceParams();
            _message.source = source;
            _message.interfaceName = interfaceName;
            _message.interfacePipe = interfacePipe;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new ServiceOnBindInterfaceResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.service_manager.mojom.Service
        public void createPackagedServiceInstance(Identity identity, InterfaceRequest<Service> receiver, ProcessMetadata metadata) {
            ServiceCreatePackagedServiceInstanceParams _message = new ServiceCreatePackagedServiceInstanceParams();
            _message.identity = identity;
            _message.receiver = receiver;
            _message.metadata = metadata;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<Service> {
        Stub(Core core, Service impl) {
            super(core, impl);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0)) {
                    return false;
                }
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Service_Internal.MANAGER, messageWithHeader);
                    case 2:
                        ServiceCreatePackagedServiceInstanceParams data = ServiceCreatePackagedServiceInstanceParams.deserialize(messageWithHeader.getPayload());
                        getImpl().createPackagedServiceInstance(data.identity, data.receiver, data.metadata);
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
        public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1)) {
                    return false;
                }
                switch (header.getType()) {
                    case -1:
                        return InterfaceControlMessagesHelper.handleRun(getCore(), Service_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        getImpl().onStart(ServiceOnStartParams.deserialize(messageWithHeader.getPayload()).identity, new ServiceOnStartResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        ServiceOnBindInterfaceParams data = ServiceOnBindInterfaceParams.deserialize(messageWithHeader.getPayload());
                        getImpl().onBindInterface(data.source, data.interfaceName, data.interfacePipe, new ServiceOnBindInterfaceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    default:
                        return false;
                }
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service_Internal$ServiceOnStartParams.class */
    static final class ServiceOnStartParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Identity identity;

        private ServiceOnStartParams(int version) {
            super(16, version);
        }

        public ServiceOnStartParams() {
            this(0);
        }

        public static ServiceOnStartParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceOnStartParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceOnStartParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ServiceOnStartParams result = new ServiceOnStartParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.identity = Identity.decode(decoder1);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct) this.identity, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service_Internal$ServiceOnStartResponseParams.class */
    public static final class ServiceOnStartResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<Connector> connectorRequest;
        public AssociatedInterfaceRequestNotSupported controlRequest;

        private ServiceOnStartResponseParams(int version) {
            super(16, version);
        }

        public ServiceOnStartResponseParams() {
            this(0);
        }

        public static ServiceOnStartResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceOnStartResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceOnStartResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ServiceOnStartResponseParams result = new ServiceOnStartResponseParams(elementsOrVersion);
                result.connectorRequest = decoder0.readInterfaceRequest(8, true);
                result.controlRequest = decoder0.readAssociatedInterfaceRequestNotSupported(12, true);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((InterfaceRequest) this.connectorRequest, 8, true);
            encoder0.encode(this.controlRequest, 12, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service_Internal$ServiceOnStartResponseParamsForwardToCallback.class */
    static class ServiceOnStartResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Service.OnStartResponse mCallback;

        ServiceOnStartResponseParamsForwardToCallback(Service.OnStartResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0, 2)) {
                    return false;
                }
                ServiceOnStartResponseParams response = ServiceOnStartResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.connectorRequest, response.controlRequest);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service_Internal$ServiceOnStartResponseParamsProxyToResponder.class */
    static class ServiceOnStartResponseParamsProxyToResponder implements Service.OnStartResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        ServiceOnStartResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(InterfaceRequest<Connector> connectorRequest, AssociatedInterfaceRequestNotSupported controlRequest) {
            ServiceOnStartResponseParams _response = new ServiceOnStartResponseParams();
            _response.connectorRequest = connectorRequest;
            _response.controlRequest = controlRequest;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service_Internal$ServiceOnBindInterfaceParams.class */
    static final class ServiceOnBindInterfaceParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public BindSourceInfo source;
        public String interfaceName;
        public MessagePipeHandle interfacePipe;

        private ServiceOnBindInterfaceParams(int version) {
            super(32, version);
            this.interfacePipe = InvalidHandle.INSTANCE;
        }

        public ServiceOnBindInterfaceParams() {
            this(0);
        }

        public static ServiceOnBindInterfaceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceOnBindInterfaceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceOnBindInterfaceParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ServiceOnBindInterfaceParams result = new ServiceOnBindInterfaceParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.source = BindSourceInfo.decode(decoder1);
                result.interfaceName = decoder0.readString(16, false);
                result.interfacePipe = decoder0.readMessagePipeHandle(24, false);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct) this.source, 8, false);
            encoder0.encode(this.interfaceName, 16, false);
            encoder0.encode((Handle) this.interfacePipe, 24, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service_Internal$ServiceOnBindInterfaceResponseParams.class */
    static final class ServiceOnBindInterfaceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 8;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(8, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private ServiceOnBindInterfaceResponseParams(int version) {
            super(8, version);
        }

        public ServiceOnBindInterfaceResponseParams() {
            this(0);
        }

        public static ServiceOnBindInterfaceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceOnBindInterfaceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceOnBindInterfaceResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ServiceOnBindInterfaceResponseParams result = new ServiceOnBindInterfaceResponseParams(elementsOrVersion);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service_Internal$ServiceOnBindInterfaceResponseParamsForwardToCallback.class */
    static class ServiceOnBindInterfaceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Service.OnBindInterfaceResponse mCallback;

        ServiceOnBindInterfaceResponseParamsForwardToCallback(Service.OnBindInterfaceResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(1, 2)) {
                    return false;
                }
                this.mCallback.call();
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service_Internal$ServiceOnBindInterfaceResponseParamsProxyToResponder.class */
    static class ServiceOnBindInterfaceResponseParamsProxyToResponder implements Service.OnBindInterfaceResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        ServiceOnBindInterfaceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback0
        public void call() {
            ServiceOnBindInterfaceResponseParams _response = new ServiceOnBindInterfaceResponseParams();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Service_Internal$ServiceCreatePackagedServiceInstanceParams.class */
    static final class ServiceCreatePackagedServiceInstanceParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Identity identity;
        public InterfaceRequest<Service> receiver;
        public ProcessMetadata metadata;

        private ServiceCreatePackagedServiceInstanceParams(int version) {
            super(32, version);
        }

        public ServiceCreatePackagedServiceInstanceParams() {
            this(0);
        }

        public static ServiceCreatePackagedServiceInstanceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceCreatePackagedServiceInstanceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceCreatePackagedServiceInstanceParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ServiceCreatePackagedServiceInstanceParams result = new ServiceCreatePackagedServiceInstanceParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.identity = Identity.decode(decoder1);
                result.receiver = decoder0.readInterfaceRequest(16, false);
                result.metadata = (ProcessMetadata) decoder0.readServiceInterface(20, false, ProcessMetadata.MANAGER);
                decoder0.decreaseStackDepth();
                return result;
            } catch (Throwable th) {
                decoder0.decreaseStackDepth();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.chromium.mojo.bindings.Struct
        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode((Struct) this.identity, 8, false);
            encoder0.encode((InterfaceRequest) this.receiver, 16, false);
            encoder0.encode(this.metadata, 20, false, ProcessMetadata.MANAGER);
        }
    }
}
