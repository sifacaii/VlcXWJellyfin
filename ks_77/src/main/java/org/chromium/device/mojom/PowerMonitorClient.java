package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/PowerMonitorClient.class */
public interface PowerMonitorClient extends Interface {
    public static final Interface.Manager<PowerMonitorClient, Proxy> MANAGER = PowerMonitorClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/PowerMonitorClient$Proxy.class */
    public interface Proxy extends PowerMonitorClient, Interface.Proxy {
    }

    void powerStateChange(boolean z);

    void suspend();

    void resume();
}
