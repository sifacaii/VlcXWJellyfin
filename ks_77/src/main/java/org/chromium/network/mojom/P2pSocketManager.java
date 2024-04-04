package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketManager.class */
public interface P2pSocketManager extends Interface {
    public static final Interface.Manager<P2pSocketManager, Proxy> MANAGER = P2pSocketManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketManager$GetHostAddressResponse.class */
    public interface GetHostAddressResponse extends Callbacks.Callback1<IpAddress[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pSocketManager$Proxy.class */
    public interface Proxy extends P2pSocketManager, Interface.Proxy {
    }

    void startNetworkNotifications(P2pNetworkNotificationClient p2pNetworkNotificationClient);

    void getHostAddress(String str, boolean z, GetHostAddressResponse getHostAddressResponse);

    void createSocket(int i, IpEndPoint ipEndPoint, P2pPortRange p2pPortRange, P2pHostAndIpEndPoint p2pHostAndIpEndPoint, P2pSocketClient p2pSocketClient, InterfaceRequest<P2pSocket> interfaceRequest);
}
