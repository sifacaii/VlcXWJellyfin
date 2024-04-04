package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManager.class */
public interface NetworkChangeManager extends Interface {
    public static final Interface.Manager<NetworkChangeManager, Proxy> MANAGER = NetworkChangeManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkChangeManager$Proxy.class */
    public interface Proxy extends NetworkChangeManager, Interface.Proxy {
    }

    void requestNotifications(NetworkChangeManagerClient networkChangeManagerClient);

    void onNetworkChanged(boolean z, boolean z2, boolean z3, int i, boolean z4, int i2);
}
