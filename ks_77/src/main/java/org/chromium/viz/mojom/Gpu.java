package org.chromium.viz.mojom;

import org.chromium.gpu.mojom.GpuFeatureInfo;
import org.chromium.gpu.mojom.GpuInfo;
import org.chromium.media.mojom.VideoEncodeAcceleratorProvider;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.MessagePipeHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/Gpu.class */
public interface Gpu extends Interface {
    public static final Interface.Manager<Gpu, Proxy> MANAGER = Gpu_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/Gpu$EstablishGpuChannelResponse.class */
    public interface EstablishGpuChannelResponse extends Callbacks.Callback4<Integer, MessagePipeHandle, GpuInfo, GpuFeatureInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/Gpu$Proxy.class */
    public interface Proxy extends Gpu, Interface.Proxy {
    }

    void createGpuMemoryBufferFactory(InterfaceRequest<GpuMemoryBufferFactory> interfaceRequest);

    void establishGpuChannel(EstablishGpuChannelResponse establishGpuChannelResponse);

    void createVideoEncodeAcceleratorProvider(InterfaceRequest<VideoEncodeAcceleratorProvider> interfaceRequest);
}
