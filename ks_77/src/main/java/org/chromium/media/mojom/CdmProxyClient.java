package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxyClient.class */
public interface CdmProxyClient extends Interface {
    public static final Interface.Manager<CdmProxyClient, Proxy> MANAGER = CdmProxyClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmProxyClient$Proxy.class */
    public interface Proxy extends CdmProxyClient, Interface.Proxy {
    }

    void notifyHardwareReset();
}
