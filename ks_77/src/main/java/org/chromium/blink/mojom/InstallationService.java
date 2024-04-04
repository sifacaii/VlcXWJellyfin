package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/InstallationService.class */
public interface InstallationService extends Interface {
    public static final Interface.Manager<InstallationService, Proxy> MANAGER = InstallationService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/InstallationService$Proxy.class */
    public interface Proxy extends InstallationService, Interface.Proxy {
    }

    void onInstall();
}
