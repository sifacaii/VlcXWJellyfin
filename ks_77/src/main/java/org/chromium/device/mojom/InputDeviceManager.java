package org.chromium.device.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/InputDeviceManager.class */
public interface InputDeviceManager extends Interface {
    public static final Interface.Manager<InputDeviceManager, Proxy> MANAGER = InputDeviceManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/InputDeviceManager$GetDevicesAndSetClientResponse.class */
    public interface GetDevicesAndSetClientResponse extends Callbacks.Callback1<InputDeviceInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/InputDeviceManager$GetDevicesResponse.class */
    public interface GetDevicesResponse extends Callbacks.Callback1<InputDeviceInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/InputDeviceManager$Proxy.class */
    public interface Proxy extends InputDeviceManager, Interface.Proxy {
    }

    void getDevicesAndSetClient(AssociatedInterfaceNotSupported associatedInterfaceNotSupported, GetDevicesAndSetClientResponse getDevicesAndSetClientResponse);

    void getDevices(GetDevicesResponse getDevicesResponse);
}
