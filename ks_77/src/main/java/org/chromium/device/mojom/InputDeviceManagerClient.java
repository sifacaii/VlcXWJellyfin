package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/InputDeviceManagerClient.class */
public interface InputDeviceManagerClient extends Interface {
    public static final Interface.Manager<InputDeviceManagerClient, Proxy> MANAGER = InputDeviceManagerClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/InputDeviceManagerClient$Proxy.class */
    public interface Proxy extends InputDeviceManagerClient, Interface.Proxy {
    }

    void inputDeviceAdded(InputDeviceInfo inputDeviceInfo);

    void inputDeviceRemoved(String str);
}
