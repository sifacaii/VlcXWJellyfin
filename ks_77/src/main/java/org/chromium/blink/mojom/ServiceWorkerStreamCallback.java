package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerStreamCallback.class */
public interface ServiceWorkerStreamCallback extends Interface {
    public static final Interface.Manager<ServiceWorkerStreamCallback, Proxy> MANAGER = ServiceWorkerStreamCallback_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerStreamCallback$Proxy.class */
    public interface Proxy extends ServiceWorkerStreamCallback, Interface.Proxy {
    }

    void onCompleted();

    void onAborted();
}
