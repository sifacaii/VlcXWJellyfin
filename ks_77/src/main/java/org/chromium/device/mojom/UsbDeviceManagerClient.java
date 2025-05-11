package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDeviceManagerClient.class */
public interface UsbDeviceManagerClient extends Interface {
    public static final Interface.Manager<UsbDeviceManagerClient, Proxy> MANAGER = UsbDeviceManagerClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDeviceManagerClient$Proxy.class */
    public interface Proxy extends UsbDeviceManagerClient, Interface.Proxy {
    }

    void onDeviceAdded(UsbDeviceInfo usbDeviceInfo);

    void onDeviceRemoved(UsbDeviceInfo usbDeviceInfo);
}
