package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket.class */
public interface TcpBoundSocket extends Interface {
    public static final Interface.Manager<TcpBoundSocket, Proxy> MANAGER = TcpBoundSocket_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket$ConnectResponse.class */
    public interface ConnectResponse extends Callbacks.Callback5<Integer, IpEndPoint, IpEndPoint, DataPipe.ConsumerHandle, DataPipe.ProducerHandle> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket$ListenResponse.class */
    public interface ListenResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpBoundSocket$Proxy.class */
    public interface Proxy extends TcpBoundSocket, Interface.Proxy {
    }

    void listen(int i, InterfaceRequest<TcpServerSocket> interfaceRequest, ListenResponse listenResponse);

    void connect(AddressList addressList, TcpConnectedSocketOptions tcpConnectedSocketOptions, InterfaceRequest<TcpConnectedSocket> interfaceRequest, SocketObserver socketObserver, ConnectResponse connectResponse);
}
