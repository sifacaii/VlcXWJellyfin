package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.service_manager.mojom.InterfaceProvider;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmService.class */
public interface CdmService extends Interface {
    public static final Interface.Manager<CdmService, Proxy> MANAGER = CdmService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmService$Proxy.class */
    public interface Proxy extends CdmService, Interface.Proxy {
    }

    void loadCdm(FilePath filePath);

    void createCdmFactory(InterfaceRequest<CdmFactory> interfaceRequest, InterfaceProvider interfaceProvider);
}
