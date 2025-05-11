package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystemFactory.class */
public interface BluetoothSystemFactory extends Interface {
    public static final Interface.Manager<BluetoothSystemFactory, Proxy> MANAGER = BluetoothSystemFactory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/BluetoothSystemFactory$Proxy.class */
    public interface Proxy extends BluetoothSystemFactory, Interface.Proxy {
    }

    void create(InterfaceRequest<BluetoothSystem> interfaceRequest, BluetoothSystemClient bluetoothSystemClient);
}
