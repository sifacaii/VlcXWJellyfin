package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/GeolocationContext.class */
public interface GeolocationContext extends Interface {
    public static final Interface.Manager<GeolocationContext, Proxy> MANAGER = GeolocationContext_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/GeolocationContext$Proxy.class */
    public interface Proxy extends GeolocationContext, Interface.Proxy {
    }

    void bindGeolocation(InterfaceRequest<Geolocation> interfaceRequest);

    void setOverride(Geoposition geoposition);

    void clearOverride();
}
