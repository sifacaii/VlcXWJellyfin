package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.mojom.Url;

public final class EmbeddedWorkerStartParams extends Struct {
    private static final int STRUCT_SIZE = 128;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(128, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public long serviceWorkerVersionId;

    public Url scope;

    public Url scriptUrl;

    public int scriptType;

    public String userAgent;

    public int workerDevtoolsAgentRouteId;

    public UnguessableToken devtoolsWorkerToken;

    public boolean pauseAfterDownload;

    public boolean waitForDebugger;

    public boolean isInstalled;

    public int v8CacheOptions;

    public RendererPreferences rendererPreferences;

    public InterfaceRequest<ServiceWorker> serviceWorkerRequest;

    public InterfaceRequest<ControllerServiceWorker> controllerReceiver;

    public ServiceWorkerInstalledScriptsInfo installedScriptsInfo;

    public AssociatedInterfaceNotSupported instanceHost;

    public ServiceWorkerProviderInfoForStartWorker providerInfo;

    public WorkerContentSettingsProxy contentSettingsProxy;

    public InterfaceRequest<RendererPreferenceWatcher> preferenceWatcherRequest;

    public UrlLoaderFactoryBundle subresourceLoaderFactories;

    public InterfaceRequest<ServiceWorkerSubresourceLoaderUpdater> subresourceLoaderUpdater;

    private EmbeddedWorkerStartParams(int version) {
        super(128, version);
    }

    public EmbeddedWorkerStartParams() {
        this(0);
    }

    public static EmbeddedWorkerStartParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static EmbeddedWorkerStartParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerStartParams decode(Decoder decoder0) {
        EmbeddedWorkerStartParams result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new EmbeddedWorkerStartParams(elementsOrVersion);
            result.serviceWorkerVersionId = decoder0.readLong(8);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.scope = Url.decode(decoder1);
            decoder1 = decoder0.readPointer(24, false);
            result.scriptUrl = Url.decode(decoder1);
            result.scriptType = decoder0.readInt(32);
            ScriptType.validate(result.scriptType);
            result.workerDevtoolsAgentRouteId = decoder0.readInt(36);
            result.userAgent = decoder0.readString(40, false);
            decoder1 = decoder0.readPointer(48, false);
            result.devtoolsWorkerToken = UnguessableToken.decode(decoder1);
            result.pauseAfterDownload = decoder0.readBoolean(56, 0);
            result.waitForDebugger = decoder0.readBoolean(56, 1);
            result.isInstalled = decoder0.readBoolean(56, 2);
            result.v8CacheOptions = decoder0.readInt(60);
            V8CacheOptions.validate(result.v8CacheOptions);
            decoder1 = decoder0.readPointer(64, false);
            result.rendererPreferences = RendererPreferences.decode(decoder1);
            result.serviceWorkerRequest = decoder0.readInterfaceRequest(72, false);
            result.controllerReceiver = decoder0.readInterfaceRequest(76, false);
            decoder1 = decoder0.readPointer(80, true);
            result.installedScriptsInfo = ServiceWorkerInstalledScriptsInfo.decode(decoder1);
            result.instanceHost = decoder0.readAssociatedServiceInterfaceNotSupported(88, false);
            decoder1 = decoder0.readPointer(96, false);
            result.providerInfo = ServiceWorkerProviderInfoForStartWorker.decode(decoder1);
            result.contentSettingsProxy = (WorkerContentSettingsProxy)decoder0.readServiceInterface(104, false, WorkerContentSettingsProxy.MANAGER);
            result.preferenceWatcherRequest = decoder0.readInterfaceRequest(112, false);
            result.subresourceLoaderUpdater = decoder0.readInterfaceRequest(116, false);
            decoder1 = decoder0.readPointer(120, false);
            result.subresourceLoaderFactories = UrlLoaderFactoryBundle.decode(decoder1);
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.serviceWorkerVersionId, 8);
        encoder0.encode((Struct)this.scope, 16, false);
        encoder0.encode((Struct)this.scriptUrl, 24, false);
        encoder0.encode(this.scriptType, 32);
        encoder0.encode(this.workerDevtoolsAgentRouteId, 36);
        encoder0.encode(this.userAgent, 40, false);
        encoder0.encode((Struct)this.devtoolsWorkerToken, 48, false);
        encoder0.encode(this.pauseAfterDownload, 56, 0);
        encoder0.encode(this.waitForDebugger, 56, 1);
        encoder0.encode(this.isInstalled, 56, 2);
        encoder0.encode(this.v8CacheOptions, 60);
        encoder0.encode(this.rendererPreferences, 64, false);
        encoder0.encode(this.serviceWorkerRequest, 72, false);
        encoder0.encode(this.controllerReceiver, 76, false);
        encoder0.encode(this.installedScriptsInfo, 80, true);
        encoder0.encode(this.instanceHost, 88, false);
        encoder0.encode(this.providerInfo, 96, false);
        encoder0.encode(this.contentSettingsProxy, 104, false, WorkerContentSettingsProxy.MANAGER);
        encoder0.encode(this.preferenceWatcherRequest, 112, false);
        encoder0.encode(this.subresourceLoaderUpdater, 116, false);
        encoder0.encode(this.subresourceLoaderFactories, 120, false);
    }
}
