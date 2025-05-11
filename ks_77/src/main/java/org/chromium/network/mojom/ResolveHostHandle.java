package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolveHostHandle.class */
public interface ResolveHostHandle extends Interface {
    public static final Interface.Manager<ResolveHostHandle, Proxy> MANAGER = ResolveHostHandle_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolveHostHandle$Proxy.class */
    public interface Proxy extends ResolveHostHandle, Interface.Proxy {
    }

    void cancel(int i);
}
