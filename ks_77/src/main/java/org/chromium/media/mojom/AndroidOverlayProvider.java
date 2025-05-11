package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AndroidOverlayProvider.class */
public interface AndroidOverlayProvider extends Interface {
    public static final Interface.Manager<AndroidOverlayProvider, Proxy> MANAGER = AndroidOverlayProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AndroidOverlayProvider$Proxy.class */
    public interface Proxy extends AndroidOverlayProvider, Interface.Proxy {
    }

    void createOverlay(InterfaceRequest<AndroidOverlay> interfaceRequest, AndroidOverlayClient androidOverlayClient, AndroidOverlayConfig androidOverlayConfig);
}
