package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/InsecureInputService.class */
public interface InsecureInputService extends Interface {
    public static final Interface.Manager<InsecureInputService, Proxy> MANAGER = InsecureInputService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/InsecureInputService$Proxy.class */
    public interface Proxy extends InsecureInputService, Interface.Proxy {
    }

    void didEditFieldInInsecureContext();
}
