package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.TimeTicks;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketClient.class */
public interface P2pSocketClient extends Interface {
    public static final Interface.Manager<P2pSocketClient, Proxy> MANAGER = P2pSocketClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketClient$Proxy.class */
    public interface Proxy extends P2pSocketClient, Interface.Proxy {
    }

    void socketCreated(IpEndPoint ipEndPoint, IpEndPoint ipEndPoint2);

    void sendComplete(P2pSendPacketMetrics p2pSendPacketMetrics);

    void incomingTcpConnection(IpEndPoint ipEndPoint, P2pSocket p2pSocket, InterfaceRequest<P2pSocketClient> interfaceRequest);

    void dataReceived(IpEndPoint ipEndPoint, byte[] bArr, TimeTicks timeTicks);
}
