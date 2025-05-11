package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SensorClient.class */
public interface SensorClient extends Interface {
    public static final Interface.Manager<SensorClient, Proxy> MANAGER = SensorClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SensorClient$Proxy.class */
    public interface Proxy extends SensorClient, Interface.Proxy {
    }

    void raiseError();

    void sensorReadingChanged();
}
