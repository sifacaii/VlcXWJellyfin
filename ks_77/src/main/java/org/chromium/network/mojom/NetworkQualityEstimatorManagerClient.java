package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkQualityEstimatorManagerClient.class */
public interface NetworkQualityEstimatorManagerClient extends Interface {
    public static final Interface.Manager<NetworkQualityEstimatorManagerClient, Proxy> MANAGER = NetworkQualityEstimatorManagerClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/NetworkQualityEstimatorManagerClient$Proxy.class */
    public interface Proxy extends NetworkQualityEstimatorManagerClient, Interface.Proxy {
    }

    void onNetworkQualityChanged(int i, TimeDelta timeDelta, TimeDelta timeDelta2, int i2);
}
