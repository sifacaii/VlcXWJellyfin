package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLockContext.class */
public interface WakeLockContext extends Interface {
    public static final Interface.Manager<WakeLockContext, Proxy> MANAGER = WakeLockContext_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLockContext$Proxy.class */
    public interface Proxy extends WakeLockContext, Interface.Proxy {
    }

    void getWakeLock(int i, int i2, String str, InterfaceRequest<WakeLock> interfaceRequest);
}
