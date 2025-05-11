package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDeviceClient.class */
public interface UsbDeviceClient extends Interface {
    public static final Interface.Manager<UsbDeviceClient, Proxy> MANAGER = UsbDeviceClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDeviceClient$Proxy.class */
    public interface Proxy extends UsbDeviceClient, Interface.Proxy {
    }

    void onDeviceOpened();

    void onDeviceClosed();
}
