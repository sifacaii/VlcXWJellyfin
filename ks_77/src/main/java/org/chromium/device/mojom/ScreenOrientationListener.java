package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/ScreenOrientationListener.class */
public interface ScreenOrientationListener extends Interface {
    public static final Interface.Manager<ScreenOrientationListener, Proxy> MANAGER = ScreenOrientationListener_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/ScreenOrientationListener$IsAutoRotateEnabledByUserResponse.class */
    public interface IsAutoRotateEnabledByUserResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/ScreenOrientationListener$Proxy.class */
    public interface Proxy extends ScreenOrientationListener, Interface.Proxy {
    }

    void isAutoRotateEnabledByUser(IsAutoRotateEnabledByUserResponse isAutoRotateEnabledByUserResponse);
}
