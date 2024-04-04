package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NavigationInitiator.class */
public interface NavigationInitiator extends Interface {
    public static final Interface.Manager<NavigationInitiator, Proxy> MANAGER = NavigationInitiator_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/NavigationInitiator$Proxy.class */
    public interface Proxy extends NavigationInitiator, Interface.Proxy {
    }

    void sendViolationReport(CspViolationParams cspViolationParams);
}
