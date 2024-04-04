package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLockObserver.class */
public interface WakeLockObserver extends Interface {
    public static final Interface.Manager<WakeLockObserver, Proxy> MANAGER = WakeLockObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLockObserver$Proxy.class */
    public interface Proxy extends WakeLockObserver, Interface.Proxy {
    }

    void onWakeLockDeactivated(int i);
}
