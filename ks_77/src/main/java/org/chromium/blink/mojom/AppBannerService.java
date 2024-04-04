package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppBannerService.class */
public interface AppBannerService extends Interface {
    public static final Interface.Manager<AppBannerService, Proxy> MANAGER = AppBannerService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppBannerService$Proxy.class */
    public interface Proxy extends AppBannerService, Interface.Proxy {
    }

    void displayAppBanner();
}
