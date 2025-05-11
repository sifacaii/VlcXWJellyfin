package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/ScreenOrientation.class */
public interface ScreenOrientation extends Interface {
    public static final Interface.Manager<ScreenOrientation, Proxy> MANAGER = ScreenOrientation_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/ScreenOrientation$LockOrientationResponse.class */
    public interface LockOrientationResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/ScreenOrientation$Proxy.class */
    public interface Proxy extends ScreenOrientation, Interface.Proxy {
    }

    void lockOrientation(int i, LockOrientationResponse lockOrientationResponse);

    void unlockOrientation();
}
