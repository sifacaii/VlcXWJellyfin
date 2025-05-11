package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/TimeZoneMonitorClient.class */
public interface TimeZoneMonitorClient extends Interface {
    public static final Interface.Manager<TimeZoneMonitorClient, Proxy> MANAGER = TimeZoneMonitorClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/TimeZoneMonitorClient$Proxy.class */
    public interface Proxy extends TimeZoneMonitorClient, Interface.Proxy {
    }

    void onTimeZoneChange(String str);
}
