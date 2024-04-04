package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigPollerClient.class */
public interface ProxyConfigPollerClient extends Interface {
    public static final Interface.Manager<ProxyConfigPollerClient, Proxy> MANAGER = ProxyConfigPollerClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigPollerClient$Proxy.class */
    public interface Proxy extends ProxyConfigPollerClient, Interface.Proxy {
    }

    void onLazyProxyConfigPoll();
}
