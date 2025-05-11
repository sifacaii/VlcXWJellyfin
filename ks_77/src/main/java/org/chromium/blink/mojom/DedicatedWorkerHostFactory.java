package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.service_manager.mojom.InterfaceProvider;
import org.chromium.url.mojom.Origin;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DedicatedWorkerHostFactory.class */
public interface DedicatedWorkerHostFactory extends Interface {
    public static final Interface.Manager<DedicatedWorkerHostFactory, Proxy> MANAGER = DedicatedWorkerHostFactory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DedicatedWorkerHostFactory$Proxy.class */
    public interface Proxy extends DedicatedWorkerHostFactory, Interface.Proxy {
    }

    void createWorkerHost(Origin origin, InterfaceRequest<InterfaceProvider> interfaceRequest);

    void createWorkerHostAndStartScriptLoad(Url url, Origin origin, int i, FetchClientSettingsObject fetchClientSettingsObject, BlobUrlToken blobUrlToken, DedicatedWorkerHostFactoryClient dedicatedWorkerHostFactoryClient);
}
