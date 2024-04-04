package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceControl.class */
public interface ServiceControl extends Interface {
    public static final Interface.Manager<ServiceControl, Proxy> MANAGER = ServiceControl_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceControl$Proxy.class */
    public interface Proxy extends ServiceControl, Interface.Proxy {
    }

    void requestQuit();
}
