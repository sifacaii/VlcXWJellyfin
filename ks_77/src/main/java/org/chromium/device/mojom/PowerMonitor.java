package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/PowerMonitor.class */
public interface PowerMonitor extends Interface {
    public static final Interface.Manager<PowerMonitor, Proxy> MANAGER = PowerMonitor_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/PowerMonitor$Proxy.class */
    public interface Proxy extends PowerMonitor, Interface.Proxy {
    }

    void addClient(PowerMonitorClient powerMonitorClient);
}
