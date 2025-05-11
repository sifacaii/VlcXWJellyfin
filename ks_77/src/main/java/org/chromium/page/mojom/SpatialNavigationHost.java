package org.chromium.page.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/page/mojom/SpatialNavigationHost.class */
public interface SpatialNavigationHost extends Interface {
    public static final Interface.Manager<SpatialNavigationHost, Proxy> MANAGER = SpatialNavigationHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/page/mojom/SpatialNavigationHost$Proxy.class */
    public interface Proxy extends SpatialNavigationHost, Interface.Proxy {
    }

    void spatialNavigationStateChanged(SpatialNavigationState spatialNavigationState);
}
