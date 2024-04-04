package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerRegistrationObject.class */
public interface ServiceWorkerRegistrationObject extends Interface {
    public static final Interface.Manager<ServiceWorkerRegistrationObject, Proxy> MANAGER = ServiceWorkerRegistrationObject_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerRegistrationObject$Proxy.class */
    public interface Proxy extends ServiceWorkerRegistrationObject, Interface.Proxy {
    }

    void setServiceWorkerObjects(ChangedServiceWorkerObjectsMask changedServiceWorkerObjectsMask, ServiceWorkerObjectInfo serviceWorkerObjectInfo, ServiceWorkerObjectInfo serviceWorkerObjectInfo2, ServiceWorkerObjectInfo serviceWorkerObjectInfo3);

    void setUpdateViaCache(int i);

    void updateFound();
}
