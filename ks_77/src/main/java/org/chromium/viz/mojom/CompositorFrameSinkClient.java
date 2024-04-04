package org.chromium.viz.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSinkClient.class */
public interface CompositorFrameSinkClient extends Interface {
    public static final Interface.Manager<CompositorFrameSinkClient, Proxy> MANAGER = CompositorFrameSinkClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrameSinkClient$Proxy.class */
    public interface Proxy extends CompositorFrameSinkClient, Interface.Proxy {
    }

    void didReceiveCompositorFrameAck(ReturnedResource[] returnedResourceArr);

    void onBeginFrame(BeginFrameArgs beginFrameArgs, Map<Integer, FrameTimingDetails> map);

    void onBeginFramePausedChanged(boolean z);

    void reclaimResources(ReturnedResource[] returnedResourceArr);
}
