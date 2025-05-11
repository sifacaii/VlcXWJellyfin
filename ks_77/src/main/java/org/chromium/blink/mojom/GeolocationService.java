package org.chromium.blink.mojom;

import org.chromium.device.mojom.Geolocation;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/GeolocationService.class */
public interface GeolocationService extends Interface {
    public static final Interface.Manager<GeolocationService, Proxy> MANAGER = GeolocationService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/GeolocationService$CreateGeolocationResponse.class */
    public interface CreateGeolocationResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/GeolocationService$Proxy.class */
    public interface Proxy extends GeolocationService, Interface.Proxy {
    }

    void createGeolocation(InterfaceRequest<Geolocation> interfaceRequest, boolean z, CreateGeolocationResponse createGeolocationResponse);
}
