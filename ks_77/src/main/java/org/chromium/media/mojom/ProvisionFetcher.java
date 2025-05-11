package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ProvisionFetcher.class */
public interface ProvisionFetcher extends Interface {
    public static final Interface.Manager<ProvisionFetcher, Proxy> MANAGER = ProvisionFetcher_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ProvisionFetcher$Proxy.class */
    public interface Proxy extends ProvisionFetcher, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/ProvisionFetcher$RetrieveResponse.class */
    public interface RetrieveResponse extends Callbacks.Callback2<Boolean, String> {
    }

    void retrieve(String str, String str2, RetrieveResponse retrieveResponse);
}
