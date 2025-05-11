package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AssociatedInterfaceProvider.class */
public interface AssociatedInterfaceProvider extends Interface {
    public static final Interface.Manager<AssociatedInterfaceProvider, Proxy> MANAGER = AssociatedInterfaceProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AssociatedInterfaceProvider$Proxy.class */
    public interface Proxy extends AssociatedInterfaceProvider, Interface.Proxy {
    }

    void getAssociatedInterface(String str, AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);
}
