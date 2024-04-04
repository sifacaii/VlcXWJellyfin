package org.chromium.device.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDeviceManager.class */
public interface UsbDeviceManager extends Interface {
    public static final Interface.Manager<UsbDeviceManager, Proxy> MANAGER = UsbDeviceManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDeviceManager$EnumerateDevicesAndSetClientResponse.class */
    public interface EnumerateDevicesAndSetClientResponse extends Callbacks.Callback1<UsbDeviceInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDeviceManager$GetDevicesResponse.class */
    public interface GetDevicesResponse extends Callbacks.Callback1<UsbDeviceInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDeviceManager$Proxy.class */
    public interface Proxy extends UsbDeviceManager, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbDeviceManager$RefreshDeviceInfoResponse.class */
    public interface RefreshDeviceInfoResponse extends Callbacks.Callback1<UsbDeviceInfo> {
    }

    void enumerateDevicesAndSetClient(AssociatedInterfaceNotSupported associatedInterfaceNotSupported, EnumerateDevicesAndSetClientResponse enumerateDevicesAndSetClientResponse);

    void getDevices(UsbEnumerationOptions usbEnumerationOptions, GetDevicesResponse getDevicesResponse);

    void getDevice(String str, InterfaceRequest<UsbDevice> interfaceRequest, UsbDeviceClient usbDeviceClient);

    void refreshDeviceInfo(String str, RefreshDeviceInfoResponse refreshDeviceInfoResponse);

    void setClient(AssociatedInterfaceNotSupported associatedInterfaceNotSupported);
}
