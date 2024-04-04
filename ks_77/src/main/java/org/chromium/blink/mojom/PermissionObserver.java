package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PermissionObserver.class */
public interface PermissionObserver extends Interface {
    public static final Interface.Manager<PermissionObserver, Proxy> MANAGER = PermissionObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PermissionObserver$Proxy.class */
    public interface Proxy extends PermissionObserver, Interface.Proxy {
    }

    void onPermissionStatusChange(int i);
}
