package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManager.class */
public interface ServiceManager extends Interface {
    public static final Interface.Manager<ServiceManager, Proxy> MANAGER = ServiceManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManager$Proxy.class */
    public interface Proxy extends ServiceManager, Interface.Proxy {
    }

    void addListener(ServiceManagerListener serviceManagerListener);
}
