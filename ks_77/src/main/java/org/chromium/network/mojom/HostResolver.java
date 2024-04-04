package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/HostResolver.class */
public interface HostResolver extends Interface {
    public static final Interface.Manager<HostResolver, Proxy> MANAGER = HostResolver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/HostResolver$MdnsListenResponse.class */
    public interface MdnsListenResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/HostResolver$Proxy.class */
    public interface Proxy extends HostResolver, Interface.Proxy {
    }

    void resolveHost(HostPortPair hostPortPair, ResolveHostParameters resolveHostParameters, ResolveHostClient resolveHostClient);

    void mdnsListen(HostPortPair hostPortPair, int i, MdnsListenClient mdnsListenClient, MdnsListenResponse mdnsListenResponse);
}
