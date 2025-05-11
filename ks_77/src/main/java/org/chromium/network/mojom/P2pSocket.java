package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocket.class */
public interface P2pSocket extends Interface {
    public static final Interface.Manager<P2pSocket, Proxy> MANAGER = P2pSocket_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocket$Proxy.class */
    public interface Proxy extends P2pSocket, Interface.Proxy {
    }

    void send(byte[] bArr, P2pPacketInfo p2pPacketInfo, MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag);

    void setOption(int i, int i2);
}
