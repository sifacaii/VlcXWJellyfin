package org.chromium.device.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidManager.class */
public interface HidManager extends Interface {
    public static final Interface.Manager<HidManager, Proxy> MANAGER = HidManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidManager$ConnectResponse.class */
    public interface ConnectResponse extends Callbacks.Callback1<HidConnection> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidManager$GetDevicesAndSetClientResponse.class */
    public interface GetDevicesAndSetClientResponse extends Callbacks.Callback1<HidDeviceInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidManager$GetDevicesResponse.class */
    public interface GetDevicesResponse extends Callbacks.Callback1<HidDeviceInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidManager$Proxy.class */
    public interface Proxy extends HidManager, Interface.Proxy {
    }

    void getDevicesAndSetClient(AssociatedInterfaceNotSupported associatedInterfaceNotSupported, GetDevicesAndSetClientResponse getDevicesAndSetClientResponse);

    void getDevices(GetDevicesResponse getDevicesResponse);

    void connect(String str, HidConnectionClient hidConnectionClient, ConnectResponse connectResponse);
}
