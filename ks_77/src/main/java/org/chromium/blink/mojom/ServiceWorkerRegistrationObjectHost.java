package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerRegistrationObjectHost.class */
public interface ServiceWorkerRegistrationObjectHost extends Interface {
    public static final Interface.Manager<ServiceWorkerRegistrationObjectHost, Proxy> MANAGER = ServiceWorkerRegistrationObjectHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerRegistrationObjectHost$EnableNavigationPreloadResponse.class */
    public interface EnableNavigationPreloadResponse extends Callbacks.Callback2<Integer, String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerRegistrationObjectHost$GetNavigationPreloadStateResponse.class */
    public interface GetNavigationPreloadStateResponse extends Callbacks.Callback3<Integer, String, NavigationPreloadState> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerRegistrationObjectHost$Proxy.class */
    public interface Proxy extends ServiceWorkerRegistrationObjectHost, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerRegistrationObjectHost$SetNavigationPreloadHeaderResponse.class */
    public interface SetNavigationPreloadHeaderResponse extends Callbacks.Callback2<Integer, String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerRegistrationObjectHost$UnregisterResponse.class */
    public interface UnregisterResponse extends Callbacks.Callback2<Integer, String> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerRegistrationObjectHost$UpdateResponse.class */
    public interface UpdateResponse extends Callbacks.Callback2<Integer, String> {
    }

    void update(UpdateResponse updateResponse);

    void unregister(UnregisterResponse unregisterResponse);

    void enableNavigationPreload(boolean z, EnableNavigationPreloadResponse enableNavigationPreloadResponse);

    void getNavigationPreloadState(GetNavigationPreloadStateResponse getNavigationPreloadStateResponse);

    void setNavigationPreloadHeader(String str, SetNavigationPreloadHeaderResponse setNavigationPreloadHeaderResponse);
}
