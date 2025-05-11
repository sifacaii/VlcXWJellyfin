package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PictureInPictureSessionObserver.class */
public interface PictureInPictureSessionObserver extends Interface {
    public static final Interface.Manager<PictureInPictureSessionObserver, Proxy> MANAGER = PictureInPictureSessionObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PictureInPictureSessionObserver$Proxy.class */
    public interface Proxy extends PictureInPictureSessionObserver, Interface.Proxy {
    }

    void onWindowSizeChanged(Size size);

    void onStopped();
}
