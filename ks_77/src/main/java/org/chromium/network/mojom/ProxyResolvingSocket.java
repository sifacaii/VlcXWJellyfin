package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocket.class */
public interface ProxyResolvingSocket extends Interface {
    public static final Interface.Manager<ProxyResolvingSocket, Proxy> MANAGER = ProxyResolvingSocket_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocket$Proxy.class */
    public interface Proxy extends ProxyResolvingSocket, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocket$UpgradeToTlsResponse.class */
    public interface UpgradeToTlsResponse extends Callbacks.Callback3<Integer, DataPipe.ConsumerHandle, DataPipe.ProducerHandle> {
    }

    void upgradeToTls(HostPortPair hostPortPair, MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag, InterfaceRequest<TlsClientSocket> interfaceRequest, SocketObserver socketObserver, UpgradeToTlsResponse upgradeToTlsResponse);
}
