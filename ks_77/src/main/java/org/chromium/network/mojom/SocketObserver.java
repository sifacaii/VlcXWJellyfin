package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SocketObserver.class */
public interface SocketObserver extends Interface {
    public static final Interface.Manager<SocketObserver, Proxy> MANAGER = SocketObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/SocketObserver$Proxy.class */
    public interface Proxy extends SocketObserver, Interface.Proxy {
    }

    void onReadError(int i);

    void onWriteError(int i);
}
