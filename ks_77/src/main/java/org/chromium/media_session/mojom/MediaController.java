package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaController.class */
public interface MediaController extends Interface {
    public static final Interface.Manager<MediaController, Proxy> MANAGER = MediaController_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaController$Proxy.class */
    public interface Proxy extends MediaController, Interface.Proxy {
    }

    void suspend();

    void resume();

    void stop();

    void toggleSuspendResume();

    void addObserver(MediaControllerObserver mediaControllerObserver);

    void previousTrack();

    void nextTrack();

    void seek(TimeDelta timeDelta);

    void observeImages(int i, int i2, int i3, MediaControllerImageObserver mediaControllerImageObserver);

    void seekTo(TimeDelta timeDelta);

    void scrubTo(TimeDelta timeDelta);
}
