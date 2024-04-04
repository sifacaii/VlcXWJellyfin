package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpConnectedSocket.class */
public interface TcpConnectedSocket extends Interface {
    public static final Interface.Manager<TcpConnectedSocket, Proxy> MANAGER = TcpConnectedSocket_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpConnectedSocket$Proxy.class */
    public interface Proxy extends TcpConnectedSocket, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpConnectedSocket$SetKeepAliveResponse.class */
    public interface SetKeepAliveResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpConnectedSocket$SetNoDelayResponse.class */
    public interface SetNoDelayResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpConnectedSocket$SetReceiveBufferSizeResponse.class */
    public interface SetReceiveBufferSizeResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpConnectedSocket$SetSendBufferSizeResponse.class */
    public interface SetSendBufferSizeResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TcpConnectedSocket$UpgradeToTlsResponse.class */
    public interface UpgradeToTlsResponse extends Callbacks.Callback4<Integer, DataPipe.ConsumerHandle, DataPipe.ProducerHandle, SslInfo> {
    }

    void upgradeToTls(HostPortPair hostPortPair, TlsClientSocketOptions tlsClientSocketOptions, MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag, InterfaceRequest<TlsClientSocket> interfaceRequest, SocketObserver socketObserver, UpgradeToTlsResponse upgradeToTlsResponse);

    void setSendBufferSize(int i, SetSendBufferSizeResponse setSendBufferSizeResponse);

    void setReceiveBufferSize(int i, SetReceiveBufferSizeResponse setReceiveBufferSizeResponse);

    void setNoDelay(boolean z, SetNoDelayResponse setNoDelayResponse);

    void setKeepAlive(boolean z, int i, SetKeepAliveResponse setKeepAliveResponse);
}
