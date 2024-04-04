package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerImageObserver.class */
public interface MediaControllerImageObserver extends Interface {
    public static final Interface.Manager<MediaControllerImageObserver, Proxy> MANAGER = MediaControllerImageObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerImageObserver$Proxy.class */
    public interface Proxy extends MediaControllerImageObserver, Interface.Proxy {
    }

    void mediaControllerImageChanged(int i, MediaImageBitmap mediaImageBitmap);
}
