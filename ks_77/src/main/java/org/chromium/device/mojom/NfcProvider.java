package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/NfcProvider.class */
public interface NfcProvider extends Interface {
    public static final Interface.Manager<NfcProvider, Proxy> MANAGER = NfcProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/NfcProvider$Proxy.class */
    public interface Proxy extends NfcProvider, Interface.Proxy {
    }

    void getNfcForHost(int i, InterfaceRequest<Nfc> interfaceRequest);
}
