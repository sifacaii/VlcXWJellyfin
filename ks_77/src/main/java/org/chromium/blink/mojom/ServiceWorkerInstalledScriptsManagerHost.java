package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerInstalledScriptsManagerHost.class */
public interface ServiceWorkerInstalledScriptsManagerHost extends Interface {
    public static final Interface.Manager<ServiceWorkerInstalledScriptsManagerHost, Proxy> MANAGER = ServiceWorkerInstalledScriptsManagerHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerInstalledScriptsManagerHost$Proxy.class */
    public interface Proxy extends ServiceWorkerInstalledScriptsManagerHost, Interface.Proxy {
    }

    void requestInstalledScript(Url url);
}
