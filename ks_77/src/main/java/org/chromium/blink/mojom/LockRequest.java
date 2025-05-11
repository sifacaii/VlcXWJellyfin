package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/LockRequest.class */
public interface LockRequest extends Interface {
    public static final Interface.Manager<LockRequest, Proxy> MANAGER = LockRequest_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/LockRequest$Proxy.class */
    public interface Proxy extends LockRequest, Interface.Proxy {
    }

    void granted(AssociatedInterfaceNotSupported associatedInterfaceNotSupported);

    void failed();

    void abort(String str);
}
