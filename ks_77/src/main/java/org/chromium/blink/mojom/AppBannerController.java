package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppBannerController.class */
public interface AppBannerController extends Interface {
    public static final Interface.Manager<AppBannerController, Proxy> MANAGER = AppBannerController_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppBannerController$BannerPromptRequestResponse.class */
    public interface BannerPromptRequestResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppBannerController$Proxy.class */
    public interface Proxy extends AppBannerController, Interface.Proxy {
    }

    void bannerPromptRequest(AppBannerService appBannerService, InterfaceRequest<AppBannerEvent> interfaceRequest, String[] strArr, boolean z, BannerPromptRequestResponse bannerPromptRequestResponse);
}
