package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpServerSocket.class */
public interface TcpServerSocket extends Interface {
    public static final Interface.Manager<TcpServerSocket, Proxy> MANAGER = TcpServerSocket_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpServerSocket$AcceptResponse.class */
    public interface AcceptResponse extends Callbacks.Callback5<Integer, IpEndPoint, TcpConnectedSocket, DataPipe.ConsumerHandle, DataPipe.ProducerHandle> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpServerSocket$Proxy.class */
    public interface Proxy extends TcpServerSocket, Interface.Proxy {
    }

    void accept(SocketObserver socketObserver, AcceptResponse acceptResponse);
}
