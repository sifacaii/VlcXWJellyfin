package org.chromium.viz.mojom;

import org.chromium.gfx.mojom.PointF;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/InputTargetClient.class */
public interface InputTargetClient extends Interface {
    public static final Interface.Manager<InputTargetClient, Proxy> MANAGER = InputTargetClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/InputTargetClient$FrameSinkIdAtResponse.class */
    public interface FrameSinkIdAtResponse extends Callbacks.Callback2<FrameSinkId, PointF> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/InputTargetClient$Proxy.class */
    public interface Proxy extends InputTargetClient, Interface.Proxy {
    }

    void frameSinkIdAt(PointF pointF, long j, FrameSinkIdAtResponse frameSinkIdAtResponse);
}
