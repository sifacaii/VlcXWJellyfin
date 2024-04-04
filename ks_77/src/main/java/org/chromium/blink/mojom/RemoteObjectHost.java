package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RemoteObjectHost.class */
public interface RemoteObjectHost extends Interface {
    public static final Interface.Manager<RemoteObjectHost, Proxy> MANAGER = RemoteObjectHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/RemoteObjectHost$Proxy.class */
    public interface Proxy extends RemoteObjectHost, Interface.Proxy {
    }

    void getObject(int i, InterfaceRequest<RemoteObject> interfaceRequest);

    void releaseObject(int i);
}
