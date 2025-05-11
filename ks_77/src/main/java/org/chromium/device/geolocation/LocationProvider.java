package org.chromium.device.geolocation;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/geolocation/LocationProvider.class */
public interface LocationProvider {
    void start(boolean z);

    void stop();

    boolean isRunning();
}
