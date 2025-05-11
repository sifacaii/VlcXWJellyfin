package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Geolocation.class */
public interface Geolocation extends Interface {
    public static final Interface.Manager<Geolocation, Proxy> MANAGER = Geolocation_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Geolocation$Proxy.class */
    public interface Proxy extends Geolocation, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Geolocation$QueryNextPositionResponse.class */
    public interface QueryNextPositionResponse extends Callbacks.Callback1<Geoposition> {
    }

    void setHighAccuracy(boolean z);

    void queryNextPosition(QueryNextPositionResponse queryNextPositionResponse);
}
