package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigClient.class */
public interface ProxyConfigClient extends Interface {
    public static final Interface.Manager<ProxyConfigClient, Proxy> MANAGER = ProxyConfigClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigClient$FlushProxyConfigResponse.class */
    public interface FlushProxyConfigResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyConfigClient$Proxy.class */
    public interface Proxy extends ProxyConfigClient, Interface.Proxy {
    }

    void onProxyConfigUpdated(ProxyConfigWithAnnotation proxyConfigWithAnnotation);

    void flushProxyConfig(FlushProxyConfigResponse flushProxyConfigResponse);
}
