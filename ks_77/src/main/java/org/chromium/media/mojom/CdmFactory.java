package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmFactory.class */
public interface CdmFactory extends Interface {
    public static final Interface.Manager<CdmFactory, Proxy> MANAGER = CdmFactory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/CdmFactory$Proxy.class */
    public interface Proxy extends CdmFactory, Interface.Proxy {
    }

    void createCdm(String str, InterfaceRequest<ContentDecryptionModule> interfaceRequest);
}
