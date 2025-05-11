package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SessionStorageNamespace.class */
public interface SessionStorageNamespace extends Interface {
    public static final Interface.Manager<SessionStorageNamespace, Proxy> MANAGER = SessionStorageNamespace_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SessionStorageNamespace$Proxy.class */
    public interface Proxy extends SessionStorageNamespace, Interface.Proxy {
    }

    void openArea(Origin origin, AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);

    void clone(String str);
}
