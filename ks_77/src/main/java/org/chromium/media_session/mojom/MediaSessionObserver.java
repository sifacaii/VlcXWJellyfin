package org.chromium.media_session.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSessionObserver.class */
public interface MediaSessionObserver extends Interface {
    public static final Interface.Manager<MediaSessionObserver, Proxy> MANAGER = MediaSessionObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSessionObserver$Proxy.class */
    public interface Proxy extends MediaSessionObserver, Interface.Proxy {
    }

    void mediaSessionInfoChanged(MediaSessionInfo mediaSessionInfo);

    void mediaSessionMetadataChanged(MediaMetadata mediaMetadata);

    void mediaSessionActionsChanged(int[] iArr);

    void mediaSessionImagesChanged(Map<Integer, MediaImage[]> map);

    void mediaSessionPositionChanged(MediaPosition mediaPosition);
}
