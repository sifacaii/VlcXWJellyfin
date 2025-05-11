package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPortManager.class */
public interface SerialPortManager extends Interface {
    public static final Interface.Manager<SerialPortManager, Proxy> MANAGER = SerialPortManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPortManager$GetDevicesResponse.class */
    public interface GetDevicesResponse extends Callbacks.Callback1<SerialPortInfo[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPortManager$Proxy.class */
    public interface Proxy extends SerialPortManager, Interface.Proxy {
    }

    void getDevices(GetDevicesResponse getDevicesResponse);

    void getPort(UnguessableToken unguessableToken, InterfaceRequest<SerialPort> interfaceRequest, SerialPortConnectionWatcher serialPortConnectionWatcher);
}
