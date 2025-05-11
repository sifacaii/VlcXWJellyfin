package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkQualityEstimatorManager.class */
public interface NetworkQualityEstimatorManager extends Interface {
    public static final Interface.Manager<NetworkQualityEstimatorManager, Proxy> MANAGER = NetworkQualityEstimatorManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkQualityEstimatorManager$Proxy.class */
    public interface Proxy extends NetworkQualityEstimatorManager, Interface.Proxy {
    }

    void requestNotifications(NetworkQualityEstimatorManagerClient networkQualityEstimatorManagerClient);
}
