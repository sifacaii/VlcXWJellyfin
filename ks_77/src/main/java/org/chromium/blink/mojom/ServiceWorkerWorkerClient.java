package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerWorkerClient.class */
public interface ServiceWorkerWorkerClient extends Interface {
    public static final Interface.Manager<ServiceWorkerWorkerClient, Proxy> MANAGER = ServiceWorkerWorkerClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerWorkerClient$Proxy.class */
    public interface Proxy extends ServiceWorkerWorkerClient, Interface.Proxy {
    }

    void onControllerChanged(int i);
}
