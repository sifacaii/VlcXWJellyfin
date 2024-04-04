package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystemClient.class */
public interface BluetoothSystemClient extends Interface {
    public static final Interface.Manager<BluetoothSystemClient, Proxy> MANAGER = BluetoothSystemClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystemClient$Proxy.class */
    public interface Proxy extends BluetoothSystemClient, Interface.Proxy {
    }

    void onStateChanged(int i);

    void onScanStateChanged(int i);
}
