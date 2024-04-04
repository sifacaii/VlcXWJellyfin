package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLockProvider.class */
public interface WakeLockProvider extends Interface {
    public static final Interface.Manager<WakeLockProvider, Proxy> MANAGER = WakeLockProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLockProvider$GetActiveWakeLocksForTestsResponse.class */
    public interface GetActiveWakeLocksForTestsResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLockProvider$Proxy.class */
    public interface Proxy extends WakeLockProvider, Interface.Proxy {
    }

    void getWakeLockContextForId(int i, InterfaceRequest<WakeLockContext> interfaceRequest);

    void getWakeLockWithoutContext(int i, int i2, String str, InterfaceRequest<WakeLock> interfaceRequest);

    void notifyOnWakeLockDeactivation(int i, WakeLockObserver wakeLockObserver);

    void getActiveWakeLocksForTests(int i, GetActiveWakeLocksForTestsResponse getActiveWakeLocksForTestsResponse);
}
