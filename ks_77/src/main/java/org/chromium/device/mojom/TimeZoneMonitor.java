package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/TimeZoneMonitor.class */
public interface TimeZoneMonitor extends Interface {
    public static final Interface.Manager<TimeZoneMonitor, Proxy> MANAGER = TimeZoneMonitor_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/TimeZoneMonitor$Proxy.class */
    public interface Proxy extends TimeZoneMonitor, Interface.Proxy {
    }

    void addClient(TimeZoneMonitorClient timeZoneMonitorClient);
}
