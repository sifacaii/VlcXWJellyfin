package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/FlingingRendererClientExtension.class */
public interface FlingingRendererClientExtension extends Interface {
    public static final Interface.Manager<FlingingRendererClientExtension, Proxy> MANAGER = FlingingRendererClientExtension_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/FlingingRendererClientExtension$Proxy.class */
    public interface Proxy extends FlingingRendererClientExtension, Interface.Proxy {
    }

    void onRemotePlayStateChange(int i);
}
