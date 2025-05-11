package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.service_manager.mojom.InterfaceProvider;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaService.class */
public interface MediaService extends Interface {
    public static final Interface.Manager<MediaService, Proxy> MANAGER = MediaService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaService$Proxy.class */
    public interface Proxy extends MediaService, Interface.Proxy {
    }

    void createInterfaceFactory(InterfaceRequest<InterfaceFactory> interfaceRequest, InterfaceProvider interfaceProvider);
}
