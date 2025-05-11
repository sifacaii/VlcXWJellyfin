package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheBackend.class */
public interface AppCacheBackend extends Interface {
    public static final Interface.Manager<AppCacheBackend, Proxy> MANAGER = AppCacheBackend_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppCacheBackend$Proxy.class */
    public interface Proxy extends AppCacheBackend, Interface.Proxy {
    }

    void registerHost(InterfaceRequest<AppCacheHost> interfaceRequest, AppCacheFrontend appCacheFrontend, UnguessableToken unguessableToken);
}
