package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PortalClient.class */
public interface PortalClient extends Interface {
    public static final Interface.Manager<PortalClient, Proxy> MANAGER = PortalClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PortalClient$Proxy.class */
    public interface Proxy extends PortalClient, Interface.Proxy {
    }

    void forwardMessageFromGuest(TransferableMessage transferableMessage, Origin origin, Origin origin2);

    void dispatchLoadEvent();
}
