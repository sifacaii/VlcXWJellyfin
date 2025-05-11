package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/IdleManager.class */
public interface IdleManager extends Interface {
    public static final Interface.Manager<IdleManager, Proxy> MANAGER = IdleManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/IdleManager$AddMonitorResponse.class */
    public interface AddMonitorResponse extends Callbacks.Callback1<IdleState> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/IdleManager$Proxy.class */
    public interface Proxy extends IdleManager, Interface.Proxy {
    }

    void addMonitor(TimeDelta timeDelta, IdleMonitor idleMonitor, AddMonitorResponse addMonitorResponse);
}
