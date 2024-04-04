package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ColorChooser.class */
public interface ColorChooser extends Interface {
    public static final Interface.Manager<ColorChooser, Proxy> MANAGER = ColorChooser_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ColorChooser$Proxy.class */
    public interface Proxy extends ColorChooser, Interface.Proxy {
    }

    void setSelectedColor(int i);
}
