package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverFactoryRequestClient.class */
public interface ProxyResolverFactoryRequestClient extends Interface {
    public static final Interface.Manager<ProxyResolverFactoryRequestClient, Proxy> MANAGER = ProxyResolverFactoryRequestClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverFactoryRequestClient$Proxy.class */
    public interface Proxy extends ProxyResolverFactoryRequestClient, Interface.Proxy {
    }

    void reportResult(int i);

    void alert(String str);

    void onError(int i, String str);

    void resolveDns(String str, int i, HostResolverRequestClient hostResolverRequestClient);
}
