package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerManager.class */
public interface MediaControllerManager extends Interface {
    public static final Interface.Manager<MediaControllerManager, Proxy> MANAGER = MediaControllerManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaControllerManager$Proxy.class */
    public interface Proxy extends MediaControllerManager, Interface.Proxy {
    }

    void createMediaControllerForSession(InterfaceRequest<MediaController> interfaceRequest, UnguessableToken unguessableToken);

    void createActiveMediaController(InterfaceRequest<MediaController> interfaceRequest);

    void suspendAllSessions();
}
