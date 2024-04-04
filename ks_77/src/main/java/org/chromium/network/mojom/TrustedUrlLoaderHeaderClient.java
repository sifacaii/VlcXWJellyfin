package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedUrlLoaderHeaderClient.class */
public interface TrustedUrlLoaderHeaderClient extends Interface {
    public static final Interface.Manager<TrustedUrlLoaderHeaderClient, Proxy> MANAGER = TrustedUrlLoaderHeaderClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/TrustedUrlLoaderHeaderClient$Proxy.class */
    public interface Proxy extends TrustedUrlLoaderHeaderClient, Interface.Proxy {
    }

    void onLoaderCreated(int i, InterfaceRequest<TrustedHeaderClient> interfaceRequest);
}
