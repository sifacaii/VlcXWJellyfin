package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ControllerServiceWorkerConnector.class */
public interface ControllerServiceWorkerConnector extends Interface {
    public static final Interface.Manager<ControllerServiceWorkerConnector, Proxy> MANAGER = ControllerServiceWorkerConnector_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ControllerServiceWorkerConnector$Proxy.class */
    public interface Proxy extends ControllerServiceWorkerConnector, Interface.Proxy {
    }

    void updateController(ControllerServiceWorker controllerServiceWorker);
}
