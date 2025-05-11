package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerObjectHost.class */
public interface ServiceWorkerObjectHost extends Interface {
    public static final Interface.Manager<ServiceWorkerObjectHost, Proxy> MANAGER = ServiceWorkerObjectHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerObjectHost$Proxy.class */
    public interface Proxy extends ServiceWorkerObjectHost, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerObjectHost$TerminateForTestingResponse.class */
    public interface TerminateForTestingResponse extends Callbacks.Callback0 {
    }

    void postMessageToServiceWorker(TransferableMessage transferableMessage);

    void terminateForTesting(TerminateForTestingResponse terminateForTestingResponse);
}
