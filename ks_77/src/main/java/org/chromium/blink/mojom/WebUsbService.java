package org.chromium.blink.mojom;

import org.chromium.device.mojom.UsbDevice;
import org.chromium.device.mojom.UsbDeviceFilter;
import org.chromium.device.mojom.UsbDeviceInfo;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebUsbService.class */
public interface WebUsbService extends Interface {
    public static final Interface.Manager<WebUsbService, Proxy> MANAGER = WebUsbService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebUsbService$GetDevicesResponse.class */
    public interface GetDevicesResponse extends Callbacks.Callback1<UsbDeviceInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebUsbService$GetPermissionResponse.class */
    public interface GetPermissionResponse extends Callbacks.Callback1<UsbDeviceInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/WebUsbService$Proxy.class */
    public interface Proxy extends WebUsbService, Interface.Proxy {
    }

    void getDevices(GetDevicesResponse getDevicesResponse);

    void getDevice(String str, InterfaceRequest<UsbDevice> interfaceRequest);

    void getPermission(UsbDeviceFilter[] usbDeviceFilterArr, GetPermissionResponse getPermissionResponse);

    void setClient(AssociatedInterfaceNotSupported associatedInterfaceNotSupported);
}
