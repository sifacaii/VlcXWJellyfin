package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DisplayCutoutHost.class */
public interface DisplayCutoutHost extends Interface {
    public static final Interface.Manager<DisplayCutoutHost, Proxy> MANAGER = DisplayCutoutHost_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DisplayCutoutHost$Proxy.class */
    public interface Proxy extends DisplayCutoutHost, Interface.Proxy {
    }

    void notifyViewportFitChanged(int i);
}
