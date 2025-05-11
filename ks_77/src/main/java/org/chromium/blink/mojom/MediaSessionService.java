package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaSessionService.class */
public interface MediaSessionService extends Interface {
    public static final Interface.Manager<MediaSessionService, Proxy> MANAGER = MediaSessionService_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaSessionService$Proxy.class */
    public interface Proxy extends MediaSessionService, Interface.Proxy {
    }

    void setClient(MediaSessionClient mediaSessionClient);

    void setPlaybackState(int i);

    void setMetadata(SpecMediaMetadata specMediaMetadata);

    void enableAction(int i);

    void disableAction(int i);
}
