package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManagerClient.class */
public interface P2pTrustedSocketManagerClient extends Interface {
    public static final Interface.Manager<P2pTrustedSocketManagerClient, Proxy> MANAGER = P2pTrustedSocketManagerClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManagerClient$Proxy.class */
    public interface Proxy extends P2pTrustedSocketManagerClient, Interface.Proxy {
    }

    void invalidSocketPortRangeRequested();

    void dumpPacket(byte[] bArr, long j, boolean z);
}
