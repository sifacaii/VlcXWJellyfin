package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAcceleratorProvider.class */
public interface VideoEncodeAcceleratorProvider extends Interface {
    public static final Interface.Manager<VideoEncodeAcceleratorProvider, Proxy> MANAGER = VideoEncodeAcceleratorProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAcceleratorProvider$Proxy.class */
    public interface Proxy extends VideoEncodeAcceleratorProvider, Interface.Proxy {
    }

    void createVideoEncodeAccelerator(InterfaceRequest<VideoEncodeAccelerator> interfaceRequest);
}
