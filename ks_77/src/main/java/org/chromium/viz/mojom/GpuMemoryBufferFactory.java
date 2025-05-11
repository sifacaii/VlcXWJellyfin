package org.chromium.viz.mojom;

import org.chromium.gfx.mojom.GpuMemoryBufferHandle;
import org.chromium.gfx.mojom.GpuMemoryBufferId;
import org.chromium.gfx.mojom.Size;
import org.chromium.gpu.mojom.SyncToken;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/GpuMemoryBufferFactory.class */
public interface GpuMemoryBufferFactory extends Interface {
    public static final Interface.Manager<GpuMemoryBufferFactory, Proxy> MANAGER = GpuMemoryBufferFactory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/GpuMemoryBufferFactory$CreateGpuMemoryBufferResponse.class */
    public interface CreateGpuMemoryBufferResponse extends Callbacks.Callback1<GpuMemoryBufferHandle> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/GpuMemoryBufferFactory$Proxy.class */
    public interface Proxy extends GpuMemoryBufferFactory, Interface.Proxy {
    }

    void createGpuMemoryBuffer(GpuMemoryBufferId gpuMemoryBufferId, Size size, int i, int i2, CreateGpuMemoryBufferResponse createGpuMemoryBufferResponse);

    void destroyGpuMemoryBuffer(GpuMemoryBufferId gpuMemoryBufferId, SyncToken syncToken);
}
