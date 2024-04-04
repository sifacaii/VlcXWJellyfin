package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DisplayCutoutClient.class */
public interface DisplayCutoutClient extends Interface {
    public static final Interface.Manager<DisplayCutoutClient, Proxy> MANAGER = DisplayCutoutClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DisplayCutoutClient$Proxy.class */
    public interface Proxy extends DisplayCutoutClient, Interface.Proxy {
    }

    void setSafeArea(DisplayCutoutSafeArea displayCutoutSafeArea);
}
