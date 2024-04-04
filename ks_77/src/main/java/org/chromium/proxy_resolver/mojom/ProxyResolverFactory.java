package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverFactory.class */
public interface ProxyResolverFactory extends Interface {
    public static final Interface.Manager<ProxyResolverFactory, Proxy> MANAGER = ProxyResolverFactory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/ProxyResolverFactory$Proxy.class */
    public interface Proxy extends ProxyResolverFactory, Interface.Proxy {
    }

    void createResolver(String str, InterfaceRequest<ProxyResolver> interfaceRequest, ProxyResolverFactoryRequestClient proxyResolverFactoryRequestClient);
}
