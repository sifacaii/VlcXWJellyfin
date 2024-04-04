package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/NfcClient.class */
public interface NfcClient extends Interface {
    public static final Interface.Manager<NfcClient, Proxy> MANAGER = NfcClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/NfcClient$Proxy.class */
    public interface Proxy extends NfcClient, Interface.Proxy {
    }

    void onWatch(int[] iArr, String str, NdefMessage ndefMessage);
}
