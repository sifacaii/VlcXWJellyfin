package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PortalHost.class */
public interface PortalHost extends Interface {
    public static final Interface.Manager<PortalHost, Proxy> MANAGER = PortalHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PortalHost$Proxy.class */
    public interface Proxy extends PortalHost, Interface.Proxy {
    }

    void postMessageToHost(TransferableMessage transferableMessage, Origin origin);
}
