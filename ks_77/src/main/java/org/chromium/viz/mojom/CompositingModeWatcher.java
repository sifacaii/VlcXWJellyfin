package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositingModeWatcher.class */
public interface CompositingModeWatcher extends Interface {
    public static final Interface.Manager<CompositingModeWatcher, Proxy> MANAGER = CompositingModeWatcher_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositingModeWatcher$Proxy.class */
    public interface Proxy extends CompositingModeWatcher, Interface.Proxy {
    }

    void compositingModeFallbackToSoftware();
}
