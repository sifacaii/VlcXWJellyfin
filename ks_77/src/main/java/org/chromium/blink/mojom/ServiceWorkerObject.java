package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerObject.class */
public interface ServiceWorkerObject extends Interface {
    public static final Interface.Manager<ServiceWorkerObject, Proxy> MANAGER = ServiceWorkerObject_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerObject$Proxy.class */
    public interface Proxy extends ServiceWorkerObject, Interface.Proxy {
    }

    void stateChanged(int i);
}
