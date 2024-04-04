package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPortClient.class */
public interface SerialPortClient extends Interface {
    public static final Interface.Manager<SerialPortClient, Proxy> MANAGER = SerialPortClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/SerialPortClient$Proxy.class */
    public interface Proxy extends SerialPortClient, Interface.Proxy {
    }

    void onReadError(int i);

    void onSendError(int i);
}
