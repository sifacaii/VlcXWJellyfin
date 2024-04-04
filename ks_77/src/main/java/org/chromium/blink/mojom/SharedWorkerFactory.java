package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.service_manager.mojom.InterfaceProvider;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SharedWorkerFactory.class */
public interface SharedWorkerFactory extends Interface {
    public static final Interface.Manager<SharedWorkerFactory, Proxy> MANAGER = SharedWorkerFactory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SharedWorkerFactory$Proxy.class */
    public interface Proxy extends SharedWorkerFactory, Interface.Proxy {
    }

    void createSharedWorker(SharedWorkerInfo sharedWorkerInfo, boolean z, UnguessableToken unguessableToken, RendererPreferences rendererPreferences, InterfaceRequest<RendererPreferenceWatcher> interfaceRequest, WorkerContentSettingsProxy workerContentSettingsProxy, ServiceWorkerProviderInfoForClient serviceWorkerProviderInfoForClient, UnguessableToken unguessableToken2, WorkerMainScriptLoadParams workerMainScriptLoadParams, UrlLoaderFactoryBundle urlLoaderFactoryBundle, ControllerServiceWorkerInfo controllerServiceWorkerInfo, SharedWorkerHost sharedWorkerHost, InterfaceRequest<SharedWorker> interfaceRequest2, InterfaceProvider interfaceProvider);
}
