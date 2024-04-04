package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerInstalledScriptsManager.class */
public interface ServiceWorkerInstalledScriptsManager extends Interface {
    public static final Interface.Manager<ServiceWorkerInstalledScriptsManager, Proxy> MANAGER = ServiceWorkerInstalledScriptsManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerInstalledScriptsManager$Proxy.class */
    public interface Proxy extends ServiceWorkerInstalledScriptsManager, Interface.Proxy {
    }

    void transferInstalledScript(ServiceWorkerScriptInfo serviceWorkerScriptInfo);
}
