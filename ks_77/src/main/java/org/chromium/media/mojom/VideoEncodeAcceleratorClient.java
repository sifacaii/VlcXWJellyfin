package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAcceleratorClient.class */
public interface VideoEncodeAcceleratorClient extends Interface {
    public static final Interface.Manager<VideoEncodeAcceleratorClient, Proxy> MANAGER = VideoEncodeAcceleratorClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoEncodeAcceleratorClient$Proxy.class */
    public interface Proxy extends VideoEncodeAcceleratorClient, Interface.Proxy {
    }

    void requireBitstreamBuffers(int i, Size size, int i2);

    void bitstreamBufferReady(int i, BitstreamBufferMetadata bitstreamBufferMetadata);

    void notifyError(int i);
}
