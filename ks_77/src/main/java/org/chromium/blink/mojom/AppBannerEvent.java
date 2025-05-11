package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppBannerEvent.class */
public interface AppBannerEvent extends Interface {
    public static final Interface.Manager<AppBannerEvent, Proxy> MANAGER = AppBannerEvent_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AppBannerEvent$Proxy.class */
    public interface Proxy extends AppBannerEvent, Interface.Proxy {
    }

    void bannerAccepted(String str);

    void bannerDismissed();
}
