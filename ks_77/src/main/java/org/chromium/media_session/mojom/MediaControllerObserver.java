package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerObserver.class */
public interface MediaControllerObserver extends Interface {
    public static final Interface.Manager<MediaControllerObserver, Proxy> MANAGER = MediaControllerObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerObserver$Proxy.class */
    public interface Proxy extends MediaControllerObserver, Interface.Proxy {
    }

    void mediaSessionInfoChanged(MediaSessionInfo mediaSessionInfo);

    void mediaSessionMetadataChanged(MediaMetadata mediaMetadata);

    void mediaSessionActionsChanged(int[] iArr);

    void mediaSessionChanged(UnguessableToken unguessableToken);

    void mediaSessionPositionChanged(MediaPosition mediaPosition);
}
