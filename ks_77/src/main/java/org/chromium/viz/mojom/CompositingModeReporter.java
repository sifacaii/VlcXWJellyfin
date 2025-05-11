package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositingModeReporter.class */
public interface CompositingModeReporter extends Interface {
    public static final Interface.Manager<CompositingModeReporter, Proxy> MANAGER = CompositingModeReporter_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositingModeReporter$Proxy.class */
    public interface Proxy extends CompositingModeReporter, Interface.Proxy {
    }

    void addCompositingModeWatcher(CompositingModeWatcher compositingModeWatcher);
}
