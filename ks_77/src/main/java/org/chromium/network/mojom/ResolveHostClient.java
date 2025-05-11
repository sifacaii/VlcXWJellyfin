package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolveHostClient.class */
public interface ResolveHostClient extends Interface {
    public static final Interface.Manager<ResolveHostClient, Proxy> MANAGER = ResolveHostClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolveHostClient$Proxy.class */
    public interface Proxy extends ResolveHostClient, Interface.Proxy {
    }

    void onComplete(int i, AddressList addressList);

    void onTextResults(String[] strArr);

    void onHostnameResults(HostPortPair[] hostPortPairArr);
}
