package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ColorChooserFactory.class */
public interface ColorChooserFactory extends Interface {
    public static final Interface.Manager<ColorChooserFactory, Proxy> MANAGER = ColorChooserFactory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ColorChooserFactory$Proxy.class */
    public interface Proxy extends ColorChooserFactory, Interface.Proxy {
    }

    void openColorChooser(InterfaceRequest<ColorChooser> interfaceRequest, ColorChooserClient colorChooserClient, int i, ColorSuggestion[] colorSuggestionArr);
}
