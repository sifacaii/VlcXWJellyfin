package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.IpAddress;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/HostResolverRequestClient.class */
public interface HostResolverRequestClient extends Interface {
    public static final Interface.Manager<HostResolverRequestClient, Proxy> MANAGER = HostResolverRequestClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/HostResolverRequestClient$Proxy.class */
    public interface Proxy extends HostResolverRequestClient, Interface.Proxy {
    }

    void reportResult(int i, IpAddress[] ipAddressArr);
}
