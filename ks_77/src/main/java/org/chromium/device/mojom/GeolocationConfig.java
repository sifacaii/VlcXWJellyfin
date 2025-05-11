package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/GeolocationConfig.class */
public interface GeolocationConfig extends Interface {
    public static final Interface.Manager<GeolocationConfig, Proxy> MANAGER = GeolocationConfig_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/GeolocationConfig$IsHighAccuracyLocationBeingCapturedResponse.class */
    public interface IsHighAccuracyLocationBeingCapturedResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/GeolocationConfig$Proxy.class */
    public interface Proxy extends GeolocationConfig, Interface.Proxy {
    }

    void isHighAccuracyLocationBeingCaptured(IsHighAccuracyLocationBeingCapturedResponse isHighAccuracyLocationBeingCapturedResponse);
}
