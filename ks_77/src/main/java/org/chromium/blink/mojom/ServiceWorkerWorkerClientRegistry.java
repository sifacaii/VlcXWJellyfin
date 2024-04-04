package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerWorkerClientRegistry.class */
public interface ServiceWorkerWorkerClientRegistry extends Interface {
    public static final Interface.Manager<ServiceWorkerWorkerClientRegistry, Proxy> MANAGER = ServiceWorkerWorkerClientRegistry_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerWorkerClientRegistry$Proxy.class */
    public interface Proxy extends ServiceWorkerWorkerClientRegistry, Interface.Proxy {
    }

    void registerWorkerClient(ServiceWorkerWorkerClient serviceWorkerWorkerClient);

    void cloneWorkerClientRegistry(InterfaceRequest<ServiceWorkerWorkerClientRegistry> interfaceRequest);
}
