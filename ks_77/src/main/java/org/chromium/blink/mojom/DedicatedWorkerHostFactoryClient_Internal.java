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
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;
import org.chromium.service_manager.mojom.InterfaceProvider;

class DedicatedWorkerHostFactoryClient_Internal {
    public static final Interface.Manager<DedicatedWorkerHostFactoryClient, DedicatedWorkerHostFactoryClient.Proxy> MANAGER = new Interface.Manager<DedicatedWorkerHostFactoryClient, DedicatedWorkerHostFactoryClient.Proxy>() {
        public String getName() {
            return "blink.mojom.DedicatedWorkerHostFactoryClient";
        }

        public int getVersion() {
            return 0;
        }

        public DedicatedWorkerHostFactoryClient_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new DedicatedWorkerHostFactoryClient_Internal.Proxy(core, messageReceiver);
        }

        public DedicatedWorkerHostFactoryClient_Internal.Stub buildStub(Core core, DedicatedWorkerHostFactoryClient impl) {
            return new DedicatedWorkerHostFactoryClient_Internal.Stub(core, impl);
        }

        public DedicatedWorkerHostFactoryClient[] buildArray(int size) {
            return new DedicatedWorkerHostFactoryClient[size];
        }
    };

    private static final int ON_WORKER_HOST_CREATED_ORDINAL = 0;

    private static final int ON_SCRIPT_LOAD_STARTED_ORDINAL = 1;

    private static final int ON_SCRIPT_LOAD_START_FAILED_ORDINAL = 2;

    static final class Proxy extends Interface.AbstractProxy implements DedicatedWorkerHostFactoryClient.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void onWorkerHostCreated(InterfaceProvider interfaceProvider) {
            DedicatedWorkerHostFactoryClient_Internal.DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams _message = new DedicatedWorkerHostFactoryClient_Internal.DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams();
            _message.interfaceProvider = interfaceProvider;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }

        public void onScriptLoadStarted(ServiceWorkerProviderInfoForClient serviceWorkerProviderInfo, WorkerMainScriptLoadParams mainScriptLoadParams, UrlLoaderFactoryBundle subresourceLoaderFactories, ControllerServiceWorkerInfo controllerInfo) {
            DedicatedWorkerHostFactoryClient_Internal.DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams _message = new DedicatedWorkerHostFactoryClient_Internal.DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams();
            _message.serviceWorkerProviderInfo = serviceWorkerProviderInfo;
            _message.mainScriptLoadParams = mainScriptLoadParams;
            _message.subresourceLoaderFactories = subresourceLoaderFactories;
            _message.controllerInfo = controllerInfo;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(1)));
        }

        public void onScriptLoadStartFailed() {
            DedicatedWorkerHostFactoryClient_Internal.DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams _message = new DedicatedWorkerHostFactoryClient_Internal.DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams();
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(2)));
        }
    }

    static final class Stub extends Interface.Stub<DedicatedWorkerHostFactoryClient> {
        Stub(Core core, DedicatedWorkerHostFactoryClient impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                DedicatedWorkerHostFactoryClient_Internal.DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams dedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams;
                DedicatedWorkerHostFactoryClient_Internal.DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(DedicatedWorkerHostFactoryClient_Internal.MANAGER, messageWithHeader);
                    case 0:
                        dedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams = DedicatedWorkerHostFactoryClient_Internal.DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams.deserialize(messageWithHeader.getPayload());
                        ((DedicatedWorkerHostFactoryClient)getImpl()).onWorkerHostCreated(dedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams.interfaceProvider);
                        return true;
                    case 1:
                        data = DedicatedWorkerHostFactoryClient_Internal.DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams.deserialize(messageWithHeader.getPayload());
                        ((DedicatedWorkerHostFactoryClient)getImpl()).onScriptLoadStarted(data.serviceWorkerProviderInfo, data.mainScriptLoadParams, data.subresourceLoaderFactories, data.controllerInfo);
                        return true;
                    case 2:
                        DedicatedWorkerHostFactoryClient_Internal.DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams.deserialize(messageWithHeader.getPayload());
                        ((DedicatedWorkerHostFactoryClient)getImpl()).onScriptLoadStartFailed();
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
                                getCore(), DedicatedWorkerHostFactoryClient_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams extends Struct {
        private static final int STRUCT_SIZE = 16;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public InterfaceProvider interfaceProvider;

        private DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams(int version) {
            super(16, version);
        }

        public DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams() {
            this(0);
        }

        public static DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams decode(Decoder decoder0) {
            DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DedicatedWorkerHostFactoryClientOnWorkerHostCreatedParams(elementsOrVersion);
                result.interfaceProvider = (InterfaceProvider)decoder0.readServiceInterface(8, false, InterfaceProvider.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.interfaceProvider, 8, false, InterfaceProvider.MANAGER);
        }
    }

    static final class DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams extends Struct {
        private static final int STRUCT_SIZE = 40;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(40, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public ServiceWorkerProviderInfoForClient serviceWorkerProviderInfo;

        public WorkerMainScriptLoadParams mainScriptLoadParams;

        public UrlLoaderFactoryBundle subresourceLoaderFactories;

        public ControllerServiceWorkerInfo controllerInfo;

        private DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams(int version) {
            super(40, version);
        }

        public DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams() {
            this(0);
        }

        public static DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams decode(Decoder decoder0) {
            DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DedicatedWorkerHostFactoryClientOnScriptLoadStartedParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, true);
                result.serviceWorkerProviderInfo = ServiceWorkerProviderInfoForClient.decode(decoder1);
                decoder1 = decoder0.readPointer(16, false);
                result.mainScriptLoadParams = WorkerMainScriptLoadParams.decode(decoder1);
                decoder1 = decoder0.readPointer(24, false);
                result.subresourceLoaderFactories = UrlLoaderFactoryBundle.decode(decoder1);
                decoder1 = decoder0.readPointer(32, true);
                result.controllerInfo = ControllerServiceWorkerInfo.decode(decoder1);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.serviceWorkerProviderInfo, 8, true);
            encoder0.encode(this.mainScriptLoadParams, 16, false);
            encoder0.encode(this.subresourceLoaderFactories, 24, false);
            encoder0.encode(this.controllerInfo, 32, true);
        }
    }

    static final class DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams extends Struct {
        private static final int STRUCT_SIZE = 8;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(8, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams(int version) {
            super(8, version);
        }

        public DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams() {
            this(0);
        }

        public static DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams decode(Decoder decoder0) {
            DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DedicatedWorkerHostFactoryClientOnScriptLoadStartFailedParams(elementsOrVersion);
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
