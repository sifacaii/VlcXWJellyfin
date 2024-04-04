package org.chromium.blink.mojom;

import org.chromium.device.mojom.WakeLock;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WakeLockService.class */
public interface WakeLockService extends Interface {
    public static final Interface.Manager<WakeLockService, Proxy> MANAGER = WakeLockService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WakeLockService$Proxy.class */
    public interface Proxy extends WakeLockService, Interface.Proxy {
    }

    void getWakeLock(int i, int i2, String str, InterfaceRequest<WakeLock> interfaceRequest);
}
