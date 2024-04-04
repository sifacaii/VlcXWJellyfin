package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SslConfigClient.class */
public interface SslConfigClient extends Interface {
    public static final Interface.Manager<SslConfigClient, Proxy> MANAGER = SslConfigClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SslConfigClient$Proxy.class */
    public interface Proxy extends SslConfigClient, Interface.Proxy {
    }

    void onSslConfigUpdated(SslConfig sslConfig);
}
