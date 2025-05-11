package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.network.mojom.MutablePartialNetworkTrafficAnnotationTag;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/PublicIpAddressGeolocationProvider.class */
public interface PublicIpAddressGeolocationProvider extends Interface {
    public static final Interface.Manager<PublicIpAddressGeolocationProvider, Proxy> MANAGER = PublicIpAddressGeolocationProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/PublicIpAddressGeolocationProvider$Proxy.class */
    public interface Proxy extends PublicIpAddressGeolocationProvider, Interface.Proxy {
    }

    void createGeolocation(MutablePartialNetworkTrafficAnnotationTag mutablePartialNetworkTrafficAnnotationTag, InterfaceRequest<Geolocation> interfaceRequest);
}
