package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SensorProvider.class */
public interface SensorProvider extends Interface {
    public static final Interface.Manager<SensorProvider, Proxy> MANAGER = SensorProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SensorProvider$GetSensorResponse.class */
    public interface GetSensorResponse extends Callbacks.Callback2<Integer, SensorInitParams> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SensorProvider$Proxy.class */
    public interface Proxy extends SensorProvider, Interface.Proxy {
    }

    void getSensor(int i, GetSensorResponse getSensorResponse);
}
