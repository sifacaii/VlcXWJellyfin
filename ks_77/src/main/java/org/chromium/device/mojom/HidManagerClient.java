package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidManagerClient.class */
public interface HidManagerClient extends Interface {
    public static final Interface.Manager<HidManagerClient, Proxy> MANAGER = HidManagerClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidManagerClient$Proxy.class */
    public interface Proxy extends HidManagerClient, Interface.Proxy {
    }

    void deviceAdded(HidDeviceInfo hidDeviceInfo);

    void deviceRemoved(HidDeviceInfo hidDeviceInfo);
}
