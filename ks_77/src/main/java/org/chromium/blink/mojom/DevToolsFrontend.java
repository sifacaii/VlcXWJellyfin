package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsFrontend.class */
public interface DevToolsFrontend extends Interface {
    public static final Interface.Manager<DevToolsFrontend, Proxy> MANAGER = DevToolsFrontend_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DevToolsFrontend$Proxy.class */
    public interface Proxy extends DevToolsFrontend, Interface.Proxy {
    }

    void setupDevToolsFrontend(String str, AssociatedInterfaceNotSupported associatedInterfaceNotSupported);

    void setupDevToolsExtensionApi(String str);
}
