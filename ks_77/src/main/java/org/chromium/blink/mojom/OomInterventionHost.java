package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/OomInterventionHost.class */
public interface OomInterventionHost extends Interface {
    public static final Interface.Manager<OomInterventionHost, Proxy> MANAGER = OomInterventionHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/OomInterventionHost$Proxy.class */
    public interface Proxy extends OomInterventionHost, Interface.Proxy {
    }

    void onHighMemoryUsage();
}
