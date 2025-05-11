package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverRequestClient.class */
public interface ProxyResolverRequestClient extends Interface {
    public static final Interface.Manager<ProxyResolverRequestClient, Proxy> MANAGER = ProxyResolverRequestClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverRequestClient$Proxy.class */
    public interface Proxy extends ProxyResolverRequestClient, Interface.Proxy {
    }

    void reportResult(int i, ProxyInfo proxyInfo);

    void alert(String str);

    void onError(int i, String str);

    void resolveDns(String str, int i, HostResolverRequestClient hostResolverRequestClient);
}
