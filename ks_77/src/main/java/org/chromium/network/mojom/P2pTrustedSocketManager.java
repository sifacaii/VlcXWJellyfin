package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManager.class */
public interface P2pTrustedSocketManager extends Interface {
    public static final Interface.Manager<P2pTrustedSocketManager, Proxy> MANAGER = P2pTrustedSocketManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/P2pTrustedSocketManager$Proxy.class */
    public interface Proxy extends P2pTrustedSocketManager, Interface.Proxy {
    }

    void startRtpDump(boolean z, boolean z2);

    void stopRtpDump(boolean z, boolean z2);
}
