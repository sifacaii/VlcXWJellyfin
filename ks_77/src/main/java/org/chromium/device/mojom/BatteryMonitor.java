package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BatteryMonitor.class */
public interface BatteryMonitor extends Interface {
    public static final Interface.Manager<BatteryMonitor, Proxy> MANAGER = BatteryMonitor_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BatteryMonitor$Proxy.class */
    public interface Proxy extends BatteryMonitor, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BatteryMonitor$QueryNextStatusResponse.class */
    public interface QueryNextStatusResponse extends Callbacks.Callback1<BatteryStatus> {
    }

    void queryNextStatus(QueryNextStatusResponse queryNextStatusResponse);
}
