package org.chromium.viz.mojom;

import org.chromium.gpu.mojom.Mailbox;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink.class */
public interface CompositorFrameSink extends Interface {
    public static final Interface.Manager<CompositorFrameSink, Proxy> MANAGER = CompositorFrameSink_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink$Proxy.class */
    public interface Proxy extends CompositorFrameSink, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSink$SubmitCompositorFrameSyncResponse.class */
    public interface SubmitCompositorFrameSyncResponse extends Callbacks.Callback1<ReturnedResource[]> {
    }

    void setNeedsBeginFrame(boolean z);

    void setWantsAnimateOnlyBeginFrames();

    void submitCompositorFrame(LocalSurfaceId localSurfaceId, CompositorFrame compositorFrame, HitTestRegionList hitTestRegionList, long j);

    void submitCompositorFrameSync(LocalSurfaceId localSurfaceId, CompositorFrame compositorFrame, HitTestRegionList hitTestRegionList, long j, SubmitCompositorFrameSyncResponse submitCompositorFrameSyncResponse);

    void didNotProduceFrame(BeginFrameAck beginFrameAck);

    void didAllocateSharedBitmap(ReadOnlySharedMemoryRegion readOnlySharedMemoryRegion, Mailbox mailbox);

    void didDeleteSharedBitmap(Mailbox mailbox);
}
