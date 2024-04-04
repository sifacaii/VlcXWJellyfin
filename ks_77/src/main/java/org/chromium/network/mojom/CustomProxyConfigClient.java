package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CustomProxyConfigClient.class */
public interface CustomProxyConfigClient extends Interface {
    public static final Interface.Manager<CustomProxyConfigClient, Proxy> MANAGER = CustomProxyConfigClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CustomProxyConfigClient$MarkProxiesAsBadResponse.class */
    public interface MarkProxiesAsBadResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CustomProxyConfigClient$Proxy.class */
    public interface Proxy extends CustomProxyConfigClient, Interface.Proxy {
    }

    void onCustomProxyConfigUpdated(CustomProxyConfig customProxyConfig);

    void markProxiesAsBad(TimeDelta timeDelta, ProxyList proxyList, MarkProxiesAsBadResponse markProxiesAsBadResponse);

    void clearBadProxiesCache();
}
