package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/IdleMonitor.class */
public interface IdleMonitor extends Interface {
    public static final Interface.Manager<IdleMonitor, Proxy> MANAGER = IdleMonitor_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/IdleMonitor$Proxy.class */
    public interface Proxy extends IdleMonitor, Interface.Proxy {
    }

    void update(IdleState idleState);
}
