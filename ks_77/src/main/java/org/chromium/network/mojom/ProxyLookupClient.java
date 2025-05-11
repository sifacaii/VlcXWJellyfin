package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.proxy_resolver.mojom.ProxyInfo;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyLookupClient.class */
public interface ProxyLookupClient extends Interface {
    public static final Interface.Manager<ProxyLookupClient, Proxy> MANAGER = ProxyLookupClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyLookupClient$Proxy.class */
    public interface Proxy extends ProxyLookupClient, Interface.Proxy {
    }

    void onProxyLookupComplete(int i, ProxyInfo proxyInfo);
}
