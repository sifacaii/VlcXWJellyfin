package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocketReceiver.class */
public interface UdpSocketReceiver extends Interface {
    public static final Interface.Manager<UdpSocketReceiver, Proxy> MANAGER = UdpSocketReceiver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UdpSocketReceiver$Proxy.class */
    public interface Proxy extends UdpSocketReceiver, Interface.Proxy {
    }

    void onReceived(int i, IpEndPoint ipEndPoint, ReadOnlyBuffer readOnlyBuffer);
}
