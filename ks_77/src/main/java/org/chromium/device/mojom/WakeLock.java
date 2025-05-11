package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLock.class */
public interface WakeLock extends Interface {
    public static final Interface.Manager<WakeLock, Proxy> MANAGER = WakeLock_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLock$ChangeTypeResponse.class */
    public interface ChangeTypeResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLock$HasWakeLockForTestsResponse.class */
    public interface HasWakeLockForTestsResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLock$Proxy.class */
    public interface Proxy extends WakeLock, Interface.Proxy {
    }

    void requestWakeLock();

    void cancelWakeLock();

    void addClient(InterfaceRequest<WakeLock> interfaceRequest);

    void changeType(int i, ChangeTypeResponse changeTypeResponse);

    void hasWakeLockForTests(HasWakeLockForTestsResponse hasWakeLockForTestsResponse);
}
