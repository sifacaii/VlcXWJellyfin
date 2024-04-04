package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManagerListener.class */
public interface ServiceManagerListener extends Interface {
    public static final Interface.Manager<ServiceManagerListener, Proxy> MANAGER = ServiceManagerListener_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ServiceManagerListener$Proxy.class */
    public interface Proxy extends ServiceManagerListener, Interface.Proxy {
    }

    void onInit(RunningServiceInfo[] runningServiceInfoArr);

    void onServiceCreated(RunningServiceInfo runningServiceInfo);

    void onServiceStarted(Identity identity, int i);

    void onServicePidReceived(Identity identity, int i);

    void onServiceFailedToStart(Identity identity);

    void onServiceStopped(Identity identity);
}
