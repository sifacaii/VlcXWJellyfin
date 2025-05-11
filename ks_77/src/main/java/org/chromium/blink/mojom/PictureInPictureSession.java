package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.viz.mojom.SurfaceId;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PictureInPictureSession.class */
public interface PictureInPictureSession extends Interface {
    public static final Interface.Manager<PictureInPictureSession, Proxy> MANAGER = PictureInPictureSession_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PictureInPictureSession$Proxy.class */
    public interface Proxy extends PictureInPictureSession, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PictureInPictureSession$StopResponse.class */
    public interface StopResponse extends Callbacks.Callback0 {
    }

    void update(int i, SurfaceId surfaceId, Size size, boolean z, boolean z2);

    void stop(StopResponse stopResponse);
}
