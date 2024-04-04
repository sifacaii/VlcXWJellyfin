package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/GeolocationControl.class */
public interface GeolocationControl extends Interface {
    public static final Interface.Manager<GeolocationControl, Proxy> MANAGER = GeolocationControl_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/GeolocationControl$Proxy.class */
    public interface Proxy extends GeolocationControl, Interface.Proxy {
    }

    void userDidOptIntoLocationServices();
}
