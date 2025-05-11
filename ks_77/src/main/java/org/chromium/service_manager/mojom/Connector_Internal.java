package org.chromium.service_manager.mojom;

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
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.service_manager.mojom.Connector;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal.class */
class Connector_Internal {
    public static final Interface.Manager<Connector, Connector.Proxy> MANAGER = new Interface.Manager<Connector, Connector.Proxy>() { // from class: org.chromium.service_manager.mojom.Connector_Internal.1
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public String getName() {
            return "service_manager.mojom.Connector";
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public int getVersion() {
            return 0;
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        /* renamed from: buildProxy */
        public Connector.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Stub buildStub(Core core, Connector impl) {
            return new Stub(core, impl);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.chromium.mojo.bindings.Interface.Manager
        public Connector[] buildArray(int size) {
            return new Connector[size];
        }
    };
    private static final int BIND_INTERFACE_ORDINAL = 0;
    private static final int QUERY_SERVICE_ORDINAL = 1;
    private static final int WARM_SERVICE_ORDINAL = 2;
    private static final int REGISTER_SERVICE_INSTANCE_ORDINAL = 3;
    private static final int CLONE_ORDINAL = 4;
    private static final int FILTER_INTERFACES_ORDINAL = 5;

    Connector_Internal() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$Proxy.class */
    public static final class Proxy extends Interface.AbstractProxy implements Connector.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        @Override // org.chromium.service_manager.mojom.Connector
        public void bindInterface(ServiceFilter filter, String interfaceName, MessagePipeHandle interfacePipe, int priority, Connector.BindInterfaceResponse callback) {
            ConnectorBindInterfaceParams _message = new ConnectorBindInterfaceParams();
            _message.filter = filter;
            _message.interfaceName = interfaceName;
            _message.interfacePipe = interfacePipe;
            _message.priority = priority;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)), new ConnectorBindInterfaceResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.service_manager.mojom.Connector
        public void queryService(String serviceName, Connector.QueryServiceResponse callback) {
            ConnectorQueryServiceParams _message = new ConnectorQueryServiceParams();
            _message.serviceName = serviceName;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)), new ConnectorQueryServiceResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.service_manager.mojom.Connector
        public void warmService(ServiceFilter filter, Connector.WarmServiceResponse callback) {
            ConnectorWarmServiceParams _message = new ConnectorWarmServiceParams();
            _message.filter = filter;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)), new ConnectorWarmServiceResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.service_manager.mojom.Connector
        public void registerServiceInstance(Identity identity, MessagePipeHandle service, InterfaceRequest<ProcessMetadata> metadataReceiver, Connector.RegisterServiceInstanceResponse callback) {
            ConnectorRegisterServiceInstanceParams _message = new ConnectorRegisterServiceInstanceParams();
            _message.identity = identity;
            _message.service = service;
            _message.metadataReceiver = metadataReceiver;
            getProxyHandler().getMessageReceiver().acceptWithResponder(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)), new ConnectorRegisterServiceInstanceResponseParamsForwardToCallback(callback));
        }

        @Override // org.chromium.service_manager.mojom.Connector
        public void clone(InterfaceRequest<Connector> request) {
            ConnectorCloneParams _message = new ConnectorCloneParams();
            _message.request = request;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
        }

        @Override // org.chromium.service_manager.mojom.Connector
        public void filterInterfaces(String spec, Identity source, InterfaceRequest<InterfaceProvider> sourceRequest, InterfaceProvider target) {
            ConnectorFilterInterfacesParams _message = new ConnectorFilterInterfacesParams();
            _message.spec = spec;
            _message.source = source;
            _message.sourceRequest = sourceRequest;
            _message.target = target;
            getProxyHandler().getMessageReceiver().accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$Stub.class */
    public static final class Stub extends Interface.Stub<Connector> {
        Stub(Core core, Connector impl) {
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
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(Connector_Internal.MANAGER, messageWithHeader);
                    case 4:
                        getImpl().clone(ConnectorCloneParams.deserialize(messageWithHeader.getPayload()).request);
                        return true;
                    case 5:
                        ConnectorFilterInterfacesParams data = ConnectorFilterInterfacesParams.deserialize(messageWithHeader.getPayload());
                        getImpl().filterInterfaces(data.spec, data.source, data.sourceRequest, data.target);
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
                        return InterfaceControlMessagesHelper.handleRun(getCore(), Connector_Internal.MANAGER, messageWithHeader, receiver);
                    case 0:
                        ConnectorBindInterfaceParams data = ConnectorBindInterfaceParams.deserialize(messageWithHeader.getPayload());
                        getImpl().bindInterface(data.filter, data.interfaceName, data.interfacePipe, data.priority, new ConnectorBindInterfaceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 1:
                        getImpl().queryService(ConnectorQueryServiceParams.deserialize(messageWithHeader.getPayload()).serviceName, new ConnectorQueryServiceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 2:
                        getImpl().warmService(ConnectorWarmServiceParams.deserialize(messageWithHeader.getPayload()).filter, new ConnectorWarmServiceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    case 3:
                        ConnectorRegisterServiceInstanceParams data2 = ConnectorRegisterServiceInstanceParams.deserialize(messageWithHeader.getPayload());
                        getImpl().registerServiceInstance(data2.identity, data2.service, data2.metadataReceiver, new ConnectorRegisterServiceInstanceResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorBindInterfaceParams.class */
    static final class ConnectorBindInterfaceParams extends Struct {
        private static final int STRUCT_SIZE = 32;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ServiceFilter filter;
        public String interfaceName;
        public MessagePipeHandle interfacePipe;
        public int priority;

        private ConnectorBindInterfaceParams(int version) {
            super(32, version);
            this.interfacePipe = InvalidHandle.INSTANCE;
        }

        public ConnectorBindInterfaceParams() {
            this(0);
        }

        public static ConnectorBindInterfaceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ConnectorBindInterfaceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ConnectorBindInterfaceParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ConnectorBindInterfaceParams result = new ConnectorBindInterfaceParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.filter = ServiceFilter.decode(decoder1);
                result.interfaceName = decoder0.readString(16, false);
                result.interfacePipe = decoder0.readMessagePipeHandle(24, false);
                result.priority = decoder0.readInt(28);
                BindInterfacePriority.validate(result.priority);
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
            encoder0.encode((Struct) this.filter, 8, false);
            encoder0.encode(this.interfaceName, 16, false);
            encoder0.encode((Handle) this.interfacePipe, 24, false);
            encoder0.encode(this.priority, 28);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorBindInterfaceResponseParams.class */
    public static final class ConnectorBindInterfaceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public Identity identity;

        private ConnectorBindInterfaceResponseParams(int version) {
            super(24, version);
        }

        public ConnectorBindInterfaceResponseParams() {
            this(0);
        }

        public static ConnectorBindInterfaceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ConnectorBindInterfaceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ConnectorBindInterfaceResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ConnectorBindInterfaceResponseParams result = new ConnectorBindInterfaceResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                ConnectResult.validate(result.result);
                Decoder decoder1 = decoder0.readPointer(16, true);
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
            encoder0.encode(this.result, 8);
            encoder0.encode((Struct) this.identity, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorBindInterfaceResponseParamsForwardToCallback.class */
    static class ConnectorBindInterfaceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Connector.BindInterfaceResponse mCallback;

        ConnectorBindInterfaceResponseParamsForwardToCallback(Connector.BindInterfaceResponse callback) {
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
                ConnectorBindInterfaceResponseParams response = ConnectorBindInterfaceResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result), response.identity);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorBindInterfaceResponseParamsProxyToResponder.class */
    static class ConnectorBindInterfaceResponseParamsProxyToResponder implements Connector.BindInterfaceResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        ConnectorBindInterfaceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer result, Identity identity) {
            ConnectorBindInterfaceResponseParams _response = new ConnectorBindInterfaceResponseParams();
            _response.result = result.intValue();
            _response.identity = identity;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorQueryServiceParams.class */
    static final class ConnectorQueryServiceParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String serviceName;

        private ConnectorQueryServiceParams(int version) {
            super(16, version);
        }

        public ConnectorQueryServiceParams() {
            this(0);
        }

        public static ConnectorQueryServiceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ConnectorQueryServiceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ConnectorQueryServiceParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ConnectorQueryServiceParams result = new ConnectorQueryServiceParams(elementsOrVersion);
                result.serviceName = decoder0.readString(8, false);
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
            encoder0.encode(this.serviceName, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorQueryServiceResponseParams.class */
    public static final class ConnectorQueryServiceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ServiceInfo info;

        private ConnectorQueryServiceResponseParams(int version) {
            super(16, version);
        }

        public ConnectorQueryServiceResponseParams() {
            this(0);
        }

        public static ConnectorQueryServiceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ConnectorQueryServiceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ConnectorQueryServiceResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ConnectorQueryServiceResponseParams result = new ConnectorQueryServiceResponseParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.info = ServiceInfo.decode(decoder1);
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
            encoder0.encode((Struct) this.info, 8, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorQueryServiceResponseParamsForwardToCallback.class */
    static class ConnectorQueryServiceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Connector.QueryServiceResponse mCallback;

        ConnectorQueryServiceResponseParamsForwardToCallback(Connector.QueryServiceResponse callback) {
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
                ConnectorQueryServiceResponseParams response = ConnectorQueryServiceResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(response.info);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorQueryServiceResponseParamsProxyToResponder.class */
    static class ConnectorQueryServiceResponseParamsProxyToResponder implements Connector.QueryServiceResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        ConnectorQueryServiceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(ServiceInfo info) {
            ConnectorQueryServiceResponseParams _response = new ConnectorQueryServiceResponseParams();
            _response.info = info;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorWarmServiceParams.class */
    static final class ConnectorWarmServiceParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public ServiceFilter filter;

        private ConnectorWarmServiceParams(int version) {
            super(16, version);
        }

        public ConnectorWarmServiceParams() {
            this(0);
        }

        public static ConnectorWarmServiceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ConnectorWarmServiceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ConnectorWarmServiceParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ConnectorWarmServiceParams result = new ConnectorWarmServiceParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.filter = ServiceFilter.decode(decoder1);
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
            encoder0.encode((Struct) this.filter, 8, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorWarmServiceResponseParams.class */
    public static final class ConnectorWarmServiceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;
        public Identity identity;

        private ConnectorWarmServiceResponseParams(int version) {
            super(24, version);
        }

        public ConnectorWarmServiceResponseParams() {
            this(0);
        }

        public static ConnectorWarmServiceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ConnectorWarmServiceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ConnectorWarmServiceResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ConnectorWarmServiceResponseParams result = new ConnectorWarmServiceResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                ConnectResult.validate(result.result);
                Decoder decoder1 = decoder0.readPointer(16, true);
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
            encoder0.encode(this.result, 8);
            encoder0.encode((Struct) this.identity, 16, true);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorWarmServiceResponseParamsForwardToCallback.class */
    static class ConnectorWarmServiceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Connector.WarmServiceResponse mCallback;

        ConnectorWarmServiceResponseParamsForwardToCallback(Connector.WarmServiceResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(2, 2)) {
                    return false;
                }
                ConnectorWarmServiceResponseParams response = ConnectorWarmServiceResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result), response.identity);
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorWarmServiceResponseParamsProxyToResponder.class */
    static class ConnectorWarmServiceResponseParamsProxyToResponder implements Connector.WarmServiceResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        ConnectorWarmServiceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback2
        public void call(Integer result, Identity identity) {
            ConnectorWarmServiceResponseParams _response = new ConnectorWarmServiceResponseParams();
            _response.result = result.intValue();
            _response.identity = identity;
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorRegisterServiceInstanceParams.class */
    static final class ConnectorRegisterServiceInstanceParams extends Struct {
        private static final int STRUCT_SIZE = 24;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public Identity identity;
        public MessagePipeHandle service;
        public InterfaceRequest<ProcessMetadata> metadataReceiver;

        private ConnectorRegisterServiceInstanceParams(int version) {
            super(24, version);
            this.service = InvalidHandle.INSTANCE;
        }

        public ConnectorRegisterServiceInstanceParams() {
            this(0);
        }

        public static ConnectorRegisterServiceInstanceParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ConnectorRegisterServiceInstanceParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ConnectorRegisterServiceInstanceParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ConnectorRegisterServiceInstanceParams result = new ConnectorRegisterServiceInstanceParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.identity = Identity.decode(decoder1);
                result.service = decoder0.readMessagePipeHandle(16, false);
                result.metadataReceiver = decoder0.readInterfaceRequest(20, true);
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
            encoder0.encode((Handle) this.service, 16, false);
            encoder0.encode((InterfaceRequest) this.metadataReceiver, 20, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorRegisterServiceInstanceResponseParams.class */
    public static final class ConnectorRegisterServiceInstanceResponseParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int result;

        private ConnectorRegisterServiceInstanceResponseParams(int version) {
            super(16, version);
        }

        public ConnectorRegisterServiceInstanceResponseParams() {
            this(0);
        }

        public static ConnectorRegisterServiceInstanceResponseParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ConnectorRegisterServiceInstanceResponseParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ConnectorRegisterServiceInstanceResponseParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ConnectorRegisterServiceInstanceResponseParams result = new ConnectorRegisterServiceInstanceResponseParams(elementsOrVersion);
                result.result = decoder0.readInt(8);
                ConnectResult.validate(result.result);
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
            encoder0.encode(this.result, 8);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorRegisterServiceInstanceResponseParamsForwardToCallback.class */
    static class ConnectorRegisterServiceInstanceResponseParamsForwardToCallback extends SideEffectFreeCloseable implements MessageReceiver {
        private final Connector.RegisterServiceInstanceResponse mCallback;

        ConnectorRegisterServiceInstanceResponseParamsForwardToCallback(Connector.RegisterServiceInstanceResponse callback) {
            this.mCallback = callback;
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            try {
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(3, 2)) {
                    return false;
                }
                ConnectorRegisterServiceInstanceResponseParams response = ConnectorRegisterServiceInstanceResponseParams.deserialize(messageWithHeader.getPayload());
                this.mCallback.call(Integer.valueOf(response.result));
                return true;
            } catch (DeserializationException e) {
                return false;
            }
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorRegisterServiceInstanceResponseParamsProxyToResponder.class */
    static class ConnectorRegisterServiceInstanceResponseParamsProxyToResponder implements Connector.RegisterServiceInstanceResponse {
        private final Core mCore;
        private final MessageReceiver mMessageReceiver;
        private final long mRequestId;

        ConnectorRegisterServiceInstanceResponseParamsProxyToResponder(Core core, MessageReceiver messageReceiver, long requestId) {
            this.mCore = core;
            this.mMessageReceiver = messageReceiver;
            this.mRequestId = requestId;
        }

        @Override // org.chromium.mojo.bindings.Callbacks.Callback1
        public void call(Integer result) {
            ConnectorRegisterServiceInstanceResponseParams _response = new ConnectorRegisterServiceInstanceResponseParams();
            _response.result = result.intValue();
            ServiceMessage _message = _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
            this.mMessageReceiver.accept(_message);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorCloneParams.class */
    static final class ConnectorCloneParams extends Struct {
        private static final int STRUCT_SIZE = 16;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public InterfaceRequest<Connector> request;

        private ConnectorCloneParams(int version) {
            super(16, version);
        }

        public ConnectorCloneParams() {
            this(0);
        }

        public static ConnectorCloneParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ConnectorCloneParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ConnectorCloneParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ConnectorCloneParams result = new ConnectorCloneParams(elementsOrVersion);
                result.request = decoder0.readInterfaceRequest(8, false);
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
            encoder0.encode((InterfaceRequest) this.request, 8, false);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/Connector_Internal$ConnectorFilterInterfacesParams.class */
    static final class ConnectorFilterInterfacesParams extends Struct {
        private static final int STRUCT_SIZE = 40;
        private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String spec;
        public Identity source;
        public InterfaceRequest<InterfaceProvider> sourceRequest;
        public InterfaceProvider target;

        private ConnectorFilterInterfacesParams(int version) {
            super(40, version);
        }

        public ConnectorFilterInterfacesParams() {
            this(0);
        }

        public static ConnectorFilterInterfacesParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ConnectorFilterInterfacesParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ConnectorFilterInterfacesParams decode(Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                ConnectorFilterInterfacesParams result = new ConnectorFilterInterfacesParams(elementsOrVersion);
                result.spec = decoder0.readString(8, false);
                Decoder decoder1 = decoder0.readPointer(16, false);
                result.source = Identity.decode(decoder1);
                result.sourceRequest = decoder0.readInterfaceRequest(24, false);
                result.target = (InterfaceProvider) decoder0.readServiceInterface(28, false, InterfaceProvider.MANAGER);
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
            encoder0.encode(this.spec, 8, false);
            encoder0.encode((Struct) this.source, 16, false);
            encoder0.encode((InterfaceRequest) this.sourceRequest, 24, false);
            encoder0.encode( this.target, 28, false,  InterfaceProvider.MANAGER);
        }
    }
}
