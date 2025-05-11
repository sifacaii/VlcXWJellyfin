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
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.service_manager.mojom.InterfaceProvider;

class SharedWorkerFactory_Internal {
    public static final Interface.Manager<SharedWorkerFactory, SharedWorkerFactory.Proxy> MANAGER = new Interface.Manager<SharedWorkerFactory, SharedWorkerFactory.Proxy>() {
        public String getName() {
            return "blink.mojom.SharedWorkerFactory";
        }

        public int getVersion() {
            return 0;
        }

        public SharedWorkerFactory_Internal.Proxy buildProxy(Core core, MessageReceiverWithResponder messageReceiver) {
            return new SharedWorkerFactory_Internal.Proxy(core, messageReceiver);
        }

        public SharedWorkerFactory_Internal.Stub buildStub(Core core, SharedWorkerFactory impl) {
            return new SharedWorkerFactory_Internal.Stub(core, impl);
        }

        public SharedWorkerFactory[] buildArray(int size) {
            return new SharedWorkerFactory[size];
        }
    };

    private static final int CREATE_SHARED_WORKER_ORDINAL = 0;

    static final class Proxy extends Interface.AbstractProxy implements SharedWorkerFactory.Proxy {
        Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }

        public void createSharedWorker(SharedWorkerInfo info, boolean pauseOnStart, UnguessableToken devtoolsWorkerToken, RendererPreferences rendererPreferences, InterfaceRequest<RendererPreferenceWatcher> preferenceWatcherRequest, WorkerContentSettingsProxy contentSettings, ServiceWorkerProviderInfoForClient serviceWorkerProviderInfo, UnguessableToken appcacheHostId, WorkerMainScriptLoadParams mainScriptLoadParams, UrlLoaderFactoryBundle subresourceLoaderFactories, ControllerServiceWorkerInfo controllerInfo, SharedWorkerHost host, InterfaceRequest<SharedWorker> sharedWorker, InterfaceProvider interfaceProvider) {
            SharedWorkerFactory_Internal.SharedWorkerFactoryCreateSharedWorkerParams _message = new SharedWorkerFactory_Internal.SharedWorkerFactoryCreateSharedWorkerParams();
            _message.info = info;
            _message.pauseOnStart = pauseOnStart;
            _message.devtoolsWorkerToken = devtoolsWorkerToken;
            _message.rendererPreferences = rendererPreferences;
            _message.preferenceWatcherRequest = preferenceWatcherRequest;
            _message.contentSettings = contentSettings;
            _message.serviceWorkerProviderInfo = serviceWorkerProviderInfo;
            _message.appcacheHostId = appcacheHostId;
            _message.mainScriptLoadParams = mainScriptLoadParams;
            _message.subresourceLoaderFactories = subresourceLoaderFactories;
            _message.controllerInfo = controllerInfo;
            _message.host = host;
            _message.sharedWorker = sharedWorker;
            _message.interfaceProvider = interfaceProvider;
            getProxyHandler().getMessageReceiver().accept((Message)_message
                    .serializeWithHeader(
                            getProxyHandler().getCore(), new MessageHeader(0)));
        }
    }

    static final class Stub extends Interface.Stub<SharedWorkerFactory> {
        Stub(Core core, SharedWorkerFactory impl) {
            super(core, impl);
        }

        public boolean accept(Message message) {
            try {
                SharedWorkerFactory_Internal.SharedWorkerFactoryCreateSharedWorkerParams data;
                ServiceMessage messageWithHeader = message.asServiceMessage();
                MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(0))
                    return false;
                switch (header.getType()) {
                    case -2:
                        return InterfaceControlMessagesHelper.handleRunOrClosePipe(SharedWorkerFactory_Internal.MANAGER, messageWithHeader);
                    case 0:
                        data = SharedWorkerFactory_Internal.SharedWorkerFactoryCreateSharedWorkerParams.deserialize(messageWithHeader.getPayload());
                        ((SharedWorkerFactory)getImpl()).createSharedWorker(data.info, data.pauseOnStart, data.devtoolsWorkerToken, data.rendererPreferences, data.preferenceWatcherRequest, data.contentSettings, data.serviceWorkerProviderInfo, data.appcacheHostId, data.mainScriptLoadParams, data.subresourceLoaderFactories, data.controllerInfo, data.host, data.sharedWorker, data.interfaceProvider);
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
                                getCore(), SharedWorkerFactory_Internal.MANAGER, messageWithHeader, receiver);
                }
                return false;
            } catch (DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }

    static final class SharedWorkerFactoryCreateSharedWorkerParams extends Struct {
        private static final int STRUCT_SIZE = 112;

        private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(112, 0) };

        private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        public SharedWorkerInfo info;

        public boolean pauseOnStart;

        public UnguessableToken devtoolsWorkerToken;

        public RendererPreferences rendererPreferences;

        public InterfaceRequest<RendererPreferenceWatcher> preferenceWatcherRequest;

        public WorkerContentSettingsProxy contentSettings;

        public ServiceWorkerProviderInfoForClient serviceWorkerProviderInfo;

        public UnguessableToken appcacheHostId;

        public WorkerMainScriptLoadParams mainScriptLoadParams;

        public UrlLoaderFactoryBundle subresourceLoaderFactories;

        public ControllerServiceWorkerInfo controllerInfo;

        public SharedWorkerHost host;

        public InterfaceRequest<SharedWorker> sharedWorker;

        public InterfaceProvider interfaceProvider;

        private SharedWorkerFactoryCreateSharedWorkerParams(int version) {
            super(112, version);
        }

        public SharedWorkerFactoryCreateSharedWorkerParams() {
            this(0);
        }

        public static SharedWorkerFactoryCreateSharedWorkerParams deserialize(Message message) {
            return decode(new Decoder(message));
        }

        public static SharedWorkerFactoryCreateSharedWorkerParams deserialize(ByteBuffer data) {
            return deserialize(new Message(data, new ArrayList()));
        }

        public static SharedWorkerFactoryCreateSharedWorkerParams decode(Decoder decoder0) {
            SharedWorkerFactoryCreateSharedWorkerParams result;
            if (decoder0 == null)
                return null;
            decoder0.increaseStackDepth();
            try {
                DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new SharedWorkerFactoryCreateSharedWorkerParams(elementsOrVersion);
                Decoder decoder1 = decoder0.readPointer(8, false);
                result.info = SharedWorkerInfo.decode(decoder1);
                result.pauseOnStart = decoder0.readBoolean(16, 0);
                result.preferenceWatcherRequest = decoder0.readInterfaceRequest(20, false);
                decoder1 = decoder0.readPointer(24, false);
                result.devtoolsWorkerToken = UnguessableToken.decode(decoder1);
                decoder1 = decoder0.readPointer(32, false);
                result.rendererPreferences = RendererPreferences.decode(decoder1);
                result.contentSettings = (WorkerContentSettingsProxy)decoder0.readServiceInterface(40, false, WorkerContentSettingsProxy.MANAGER);
                decoder1 = decoder0.readPointer(48, true);
                result.serviceWorkerProviderInfo = ServiceWorkerProviderInfoForClient.decode(decoder1);
                decoder1 = decoder0.readPointer(56, true);
                result.appcacheHostId = UnguessableToken.decode(decoder1);
                decoder1 = decoder0.readPointer(64, false);
                result.mainScriptLoadParams = WorkerMainScriptLoadParams.decode(decoder1);
                decoder1 = decoder0.readPointer(72, false);
                result.subresourceLoaderFactories = UrlLoaderFactoryBundle.decode(decoder1);
                decoder1 = decoder0.readPointer(80, true);
                result.controllerInfo = ControllerServiceWorkerInfo.decode(decoder1);
                result.host = (SharedWorkerHost)decoder0.readServiceInterface(88, false, SharedWorkerHost.MANAGER);
                result.sharedWorker = decoder0.readInterfaceRequest(96, false);
                result.interfaceProvider = (InterfaceProvider)decoder0.readServiceInterface(100, false, InterfaceProvider.MANAGER);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        public final void encode(Encoder encoder) {
            Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            encoder0.encode(this.info, 8, false);
            encoder0.encode(this.pauseOnStart, 16, 0);
            encoder0.encode(this.preferenceWatcherRequest, 20, false);
            encoder0.encode((Struct)this.devtoolsWorkerToken, 24, false);
            encoder0.encode(this.rendererPreferences, 32, false);
            encoder0.encode(this.contentSettings, 40, false, WorkerContentSettingsProxy.MANAGER);
            encoder0.encode(this.serviceWorkerProviderInfo, 48, true);
            encoder0.encode((Struct)this.appcacheHostId, 56, true);
            encoder0.encode(this.mainScriptLoadParams, 64, false);
            encoder0.encode(this.subresourceLoaderFactories, 72, false);
            encoder0.encode(this.controllerInfo, 80, true);
            encoder0.encode(this.host, 88, false, SharedWorkerHost.MANAGER);
            encoder0.encode(this.sharedWorker, 96, false);
            encoder0.encode(this.interfaceProvider, 100, false, InterfaceProvider.MANAGER);
        }
    }
}
