package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.viz.mojom.SurfaceId;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PictureInPictureService.class */
public interface PictureInPictureService extends Interface {
    public static final Interface.Manager<PictureInPictureService, Proxy> MANAGER = PictureInPictureService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PictureInPictureService$Proxy.class */
    public interface Proxy extends PictureInPictureService, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PictureInPictureService$StartSessionResponse.class */
    public interface StartSessionResponse extends Callbacks.Callback2<PictureInPictureSession, Size> {
    }

    void startSession(int i, SurfaceId surfaceId, Size size, boolean z, boolean z2, PictureInPictureSessionObserver pictureInPictureSessionObserver, StartSessionResponse startSessionResponse);
}
