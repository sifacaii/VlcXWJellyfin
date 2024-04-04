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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class ServiceWorkerWorkerClientRegistry_Internal {
    public static final Interface.Manager<ServiceWorkerWorkerClientRegistry, ServiceWorkerWorkerClientRegistry.Proxy> MANAGER = new Interface.Manager<ServiceWorkerWorkerClientRegistry, ServiceWorkerWorkerClientRegistry.Proxy>() {
        public String getName() {
            return "blink.mojom.ServiceWorkerWorkerClientRegistry";
        }

        public int getVersion() {
            return 0;
        }

        public ServiceWorkerWorkerClientRegistry_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new ServiceWorkerWorkerClientRegistry_Internal.Proxy(core, messageReceiver);
        }

        public ServiceWorkerWorkerClientRegistry_Internal.Stub buildStub(Core core, ServiceWorkerWorkerClientRegistry impl) {
            return new ServiceWorkerWorkerClientRegistry_Internal.Stub(core, impl);
        }

        public ServiceWorkerWorkerClientRegistry[] buildArray(int size) {
            return new ServiceWorkerWorkerClientRegistry[size];
        }
    };

    private static final int REGISTER_WORKER_CLIENT_ORDINAL = 0;

    private static final int CLONE_WORKER_CLIENT_REGISTRY_ORDINAL = 1;

    static final class Proxy extends Interface.AbstractProxy implements ServiceWorkerWorkerClientRegistry.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void registerWorkerClient(ServiceWorkerWorkerClient client) {
            ServiceWorkerWorkerClientRegistry_Internal.ServiceWorkerWorkerClientRegistryRegisterWorkerClientParams _message = new ServiceWorkerWorkerClientRegistry_Internal.ServiceWorkerWorkerClientRegistryRegisterWorkerClientParams();
            _message.client = client;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void cloneWorkerClientRegistry(InterfaceRequest<ServiceWorkerWorkerClientRegistry> host) {
            ServiceWorkerWorkerClientRegistry_Internal.ServiceWorkerWorkerClientRegistryCloneWorkerClientRegistryParams _message = new ServiceWorkerWorkerClientRegistry_Internal.ServiceWorkerWorkerClientRegistryCloneWorkerClientRegistryParams();
            _message.host = host;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }
    }

    static final class Stub extends Interface.Stub<ServiceWorkerWorkerClientRegistry> {
        Stub(Core core, ServiceWorkerWorkerClientRegistry impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                ServiceWorkerWorkerClientRegistry_Internal.ServiceWorkerWorkerClientRegistryRegisterWorkerClientParams serviceWorkerWorkerClientRegistryRegisterWorkerClientParams;
                ServiceWorkerWorkerClientRegistry_Internal.ServiceWorkerWorkerClientRegistryCloneWorkerClientRegistryParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(ServiceWorkerWorkerClientRegistry_Internal.MANAGER, messageWithHeader);
                    case 0:
                        serviceWorkerWorkerClientRegistryRegisterWorkerClientParams = ServiceWorkerWorkerClientRegistry_Internal.ServiceWorkerWorkerClientRegistryRegisterWorkerClientParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerWorkerClientRegistry)getImpl()).registerWorkerClient(serviceWorkerWorkerClientRegistryRegisterWorkerClientParams.client);
                        return true;
                    case 1:
                        data = ServiceWorkerWorkerClientRegistry_Internal.ServiceWorkerWorkerClientRegistryCloneWorkerClientRegistryParams.deserialize(messageWithHeader.getPayload());
                        ((ServiceWorkerWorkerClientRegistry)getImpl()).cloneWorkerClientRegistry(data.host);
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
                                getCore(), ServiceWorkerWorkerClientRegistry_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class ServiceWorkerWorkerClientRegistryRegisterWorkerClientParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ServiceWorkerWorkerClient client;

        private ServiceWorkerWorkerClientRegistryRegisterWorkerClientParams(int version) {
            super(16, version);
        }

        public ServiceWorkerWorkerClientRegistryRegisterWorkerClientParams() {
            this(0);
        }

        public static ServiceWorkerWorkerClientRegistryRegisterWorkerClientParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerWorkerClientRegistryRegisterWorkerClientParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerWorkerClientRegistryRegisterWorkerClientParams decode(Decoder decoder0) {
            ServiceWorkerWorkerClientRegistryRegisterWorkerClientParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerWorkerClientRegistryRegisterWorkerClientParams(elementsOrVersion);
                result.client = (ServiceWorkerWorkerClient)decoder0.readServiceInterface(8, false, ServiceWorkerWorkerClient.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.client, 8, false, ServiceWorkerWorkerClient.MANAGER);
        }
    }

    static final class ServiceWorkerWorkerClientRegistryCloneWorkerClientRegistryParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceRequest<ServiceWorkerWorkerClientRegistry> host;

        private ServiceWorkerWorkerClientRegistryCloneWorkerClientRegistryParams(int version) {
            super(16, version);
        }

        public ServiceWorkerWorkerClientRegistryCloneWorkerClientRegistryParams() {
            this(0);
        }

        public static ServiceWorkerWorkerClientRegistryCloneWorkerClientRegistryParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static ServiceWorkerWorkerClientRegistryCloneWorkerClientRegistryParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static ServiceWorkerWorkerClientRegistryCloneWorkerClientRegistryParams decode(Decoder decoder0) {
            ServiceWorkerWorkerClientRegistryCloneWorkerClientRegistryParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ServiceWorkerWorkerClientRegistryCloneWorkerClientRegistryParams(elementsOrVersion);
                result.host = decoder0.readInterfaceRequest(8, false);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.host, 8, false);
        }
    }
}
