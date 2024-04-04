package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ColorChooserClient.class */
public interface ColorChooserClient extends Interface {
    public static final Interface.Manager<ColorChooserClient, Proxy> MANAGER = ColorChooserClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ColorChooserClient$Proxy.class */
    public interface Proxy extends ColorChooserClient, Interface.Proxy {
    }

    void didChooseColor(int i);
}
