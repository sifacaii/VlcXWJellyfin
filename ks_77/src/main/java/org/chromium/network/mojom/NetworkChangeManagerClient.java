package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManagerClient.class */
public interface NetworkChangeManagerClient extends Interface {
    public static final Interface.Manager<NetworkChangeManagerClient, Proxy> MANAGER = NetworkChangeManagerClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManagerClient$Proxy.class */
    public interface Proxy extends NetworkChangeManagerClient, Interface.Proxy {
    }

    void onInitialConnectionType(int i);

    void onNetworkChanged(int i);
}
