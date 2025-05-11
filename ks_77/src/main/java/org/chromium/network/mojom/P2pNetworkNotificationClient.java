package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pNetworkNotificationClient.class */
public interface P2pNetworkNotificationClient extends Interface {
    public static final Interface.Manager<P2pNetworkNotificationClient, Proxy> MANAGER = P2pNetworkNotificationClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pNetworkNotificationClient$Proxy.class */
    public interface Proxy extends P2pNetworkNotificationClient, Interface.Proxy {
    }

    void networkListChanged(NetworkInterface[] networkInterfaceArr, IpAddress ipAddress, IpAddress ipAddress2);
}
