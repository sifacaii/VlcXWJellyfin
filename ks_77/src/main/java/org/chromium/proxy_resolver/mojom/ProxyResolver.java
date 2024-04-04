package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolver.class */
public interface ProxyResolver extends Interface {
    public static final Interface.Manager<ProxyResolver, Proxy> MANAGER = ProxyResolver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolver$Proxy.class */
    public interface Proxy extends ProxyResolver, Interface.Proxy {
    }

    void getProxyForUrl(Url url, ProxyResolverRequestClient proxyResolverRequestClient);
}
