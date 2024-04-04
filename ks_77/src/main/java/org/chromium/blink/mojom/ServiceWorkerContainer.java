package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerContainer.class */
public interface ServiceWorkerContainer extends Interface {
    public static final Interface.Manager<ServiceWorkerContainer, Proxy> MANAGER = ServiceWorkerContainer_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerContainer$Proxy.class */
    public interface Proxy extends ServiceWorkerContainer, Interface.Proxy {
    }

    void setController(ControllerServiceWorkerInfo controllerServiceWorkerInfo, boolean z);

    void postMessageToClient(ServiceWorkerObjectInfo serviceWorkerObjectInfo, TransferableMessage transferableMessage);

    void countFeature(int i);
}
