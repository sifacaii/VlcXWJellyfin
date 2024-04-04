package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerSubresourceLoaderUpdater.class */
public interface ServiceWorkerSubresourceLoaderUpdater extends Interface {
    public static final Interface.Manager<ServiceWorkerSubresourceLoaderUpdater, Proxy> MANAGER = ServiceWorkerSubresourceLoaderUpdater_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerSubresourceLoaderUpdater$Proxy.class */
    public interface Proxy extends ServiceWorkerSubresourceLoaderUpdater, Interface.Proxy {
    }

    void updateSubresourceLoaderFactories(UrlLoaderFactoryBundle urlLoaderFactoryBundle);
}
