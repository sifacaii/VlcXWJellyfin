package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket.class */
public interface UdpSocket extends Interface {
    public static final Interface.Manager<UdpSocket, Proxy> MANAGER = UdpSocket_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket$BindResponse.class */
    public interface BindResponse extends Callbacks.Callback2<Integer, IpEndPoint> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket$ConnectResponse.class */
    public interface ConnectResponse extends Callbacks.Callback2<Integer, IpEndPoint> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket$JoinGroupResponse.class */
    public interface JoinGroupResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket$LeaveGroupResponse.class */
    public interface LeaveGroupResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket$Proxy.class */
    public interface Proxy extends UdpSocket, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket$SendResponse.class */
    public interface SendResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket$SendToResponse.class */
    public interface SendToResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket$SetBroadcastResponse.class */
    public interface SetBroadcastResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket$SetReceiveBufferSizeResponse.class */
    public interface SetReceiveBufferSizeResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocket$SetSendBufferSizeResponse.class */
    public interface SetSendBufferSizeResponse extends Callbacks.Callback1<Integer> {
    }

    void bind(IpEndPoint ipEndPoint, UdpSocketOptions udpSocketOptions, BindResponse bindResponse);

    void connect(IpEndPoint ipEndPoint, UdpSocketOptions udpSocketOptions, ConnectResponse connectResponse);

    void setBroadcast(boolean z, SetBroadcastResponse setBroadcastResponse);

    void setSendBufferSize(int i, SetSendBufferSizeResponse setSendBufferSizeResponse);

    void setReceiveBufferSize(int i, SetReceiveBufferSizeResponse setReceiveBufferSizeResponse);

    void joinGroup(IpAddress ipAddress, JoinGroupResponse joinGroupResponse);

    void leaveGroup(IpAddress ipAddress, LeaveGroupResponse leaveGroupResponse);

    void receiveMore(int i);

    void receiveMoreWithBufferSize(int i, int i2);

    void sendTo(IpEndPoint ipEndPoint, ReadOnlyBuffer readOnlyBuffer, MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag, SendToResponse sendToResponse);

    void send(ReadOnlyBuffer readOnlyBuffer, MutableNetworkTrafficAnnotationTag mutableNetworkTrafficAnnotationTag, SendResponse sendResponse);

    @Override // org.chromium.mojo.bindings.Interface, java.io.Closeable, java.lang.AutoCloseable
    void close();
}
