package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Sensor.class */
public interface Sensor extends Interface {
    public static final Interface.Manager<Sensor, Proxy> MANAGER = Sensor_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Sensor$AddConfigurationResponse.class */
    public interface AddConfigurationResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Sensor$GetDefaultConfigurationResponse.class */
    public interface GetDefaultConfigurationResponse extends Callbacks.Callback1<SensorConfiguration> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/Sensor$Proxy.class */
    public interface Proxy extends Sensor, Interface.Proxy {
    }

    void getDefaultConfiguration(GetDefaultConfigurationResponse getDefaultConfigurationResponse);

    void addConfiguration(SensorConfiguration sensorConfiguration, AddConfigurationResponse addConfigurationResponse);

    void removeConfiguration(SensorConfiguration sensorConfiguration);

    void suspend();

    void resume();

    void configureReadingChangeNotifications(boolean z);
}
