package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidConnectionClient.class */
public interface HidConnectionClient extends Interface {
    public static final Interface.Manager<HidConnectionClient, Proxy> MANAGER = HidConnectionClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/HidConnectionClient$Proxy.class */
    public interface Proxy extends HidConnectionClient, Interface.Proxy {
    }

    void onInputReport(byte b, byte[] bArr);
}
