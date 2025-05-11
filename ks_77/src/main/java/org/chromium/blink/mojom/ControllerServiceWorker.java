package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ControllerServiceWorker.class */
public interface ControllerServiceWorker extends Interface {
    public static final Interface.Manager<ControllerServiceWorker, Proxy> MANAGER = ControllerServiceWorker_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ControllerServiceWorker$DispatchFetchEventForSubresourceResponse.class */
    public interface DispatchFetchEventForSubresourceResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ControllerServiceWorker$Proxy.class */
    public interface Proxy extends ControllerServiceWorker, Interface.Proxy {
    }

    void dispatchFetchEventForSubresource(DispatchFetchEventParams dispatchFetchEventParams, ServiceWorkerFetchResponseCallback serviceWorkerFetchResponseCallback, DispatchFetchEventForSubresourceResponse dispatchFetchEventForSubresourceResponse);

    void clone(InterfaceRequest<ControllerServiceWorker> interfaceRequest);
}
