package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.service_manager.mojom.InterfaceProvider;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DedicatedWorkerHostFactoryClient.class */
public interface DedicatedWorkerHostFactoryClient extends Interface {
    public static final Interface.Manager<DedicatedWorkerHostFactoryClient, Proxy> MANAGER = DedicatedWorkerHostFactoryClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DedicatedWorkerHostFactoryClient$Proxy.class */
    public interface Proxy extends DedicatedWorkerHostFactoryClient, Interface.Proxy {
    }

    void onWorkerHostCreated(InterfaceProvider interfaceProvider);

    void onScriptLoadStarted(ServiceWorkerProviderInfoForClient serviceWorkerProviderInfoForClient, WorkerMainScriptLoadParams workerMainScriptLoadParams, UrlLoaderFactoryBundle urlLoaderFactoryBundle, ControllerServiceWorkerInfo controllerServiceWorkerInfo);

    void onScriptLoadStartFailed();
}
