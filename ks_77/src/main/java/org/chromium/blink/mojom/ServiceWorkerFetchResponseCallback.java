package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerFetchResponseCallback.class */
public interface ServiceWorkerFetchResponseCallback extends Interface {
    public static final Interface.Manager<ServiceWorkerFetchResponseCallback, Proxy> MANAGER = ServiceWorkerFetchResponseCallback_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerFetchResponseCallback$Proxy.class */
    public interface Proxy extends ServiceWorkerFetchResponseCallback, Interface.Proxy {
    }

    void onResponse(FetchApiResponse fetchApiResponse, ServiceWorkerFetchEventTiming serviceWorkerFetchEventTiming);

    void onResponseStream(FetchApiResponse fetchApiResponse, ServiceWorkerStreamHandle serviceWorkerStreamHandle, ServiceWorkerFetchEventTiming serviceWorkerFetchEventTiming);

    void onFallback(ServiceWorkerFetchEventTiming serviceWorkerFetchEventTiming);
}
