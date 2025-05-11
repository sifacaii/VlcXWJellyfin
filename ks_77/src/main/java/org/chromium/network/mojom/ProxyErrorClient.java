package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyErrorClient.class */
public interface ProxyErrorClient extends Interface {
    public static final Interface.Manager<ProxyErrorClient, Proxy> MANAGER = ProxyErrorClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyErrorClient$Proxy.class */
    public interface Proxy extends ProxyErrorClient, Interface.Proxy {
    }

    void onPacScriptError(int i, String str);

    void onRequestMaybeFailedDueToProxySettings(int i);
}
