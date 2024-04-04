package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocketFactory.class */
public interface ProxyResolvingSocketFactory extends Interface {
    public static final Interface.Manager<ProxyResolvingSocketFactory, Proxy> MANAGER = ProxyResolvingSocketFactory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocketFactory$CreateProxyResolvingSocketResponse.class */
    public interface CreateProxyResolvingSocketResponse extends Callbacks.Callback5<Integer, IpEndPoint, IpEndPoint, DataPipe.ConsumerHandle, DataPipe.ProducerHandle> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyResolvingSocketFactory$Proxy.class */
    public interface Proxy extends ProxyResolvingSocketFactory, Interface.Proxy {
    }

    void createProxyResolvingSocket(Url url, ProxyResolvingSocketOptions proxyResolvingSocketOptions, MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag, InterfaceRequest<ProxyResolvingSocket> interfaceRequest, SocketObserver socketObserver, CreateProxyResolvingSocketResponse createProxyResolvingSocketResponse);
}
