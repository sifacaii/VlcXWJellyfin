package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaSessionClient.class */
public interface MediaSessionClient extends Interface {
    public static final Interface.Manager<MediaSessionClient, Proxy> MANAGER = MediaSessionClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaSessionClient$Proxy.class */
    public interface Proxy extends MediaSessionClient, Interface.Proxy {
    }

    void didReceiveAction(int i, MediaSessionActionDetails mediaSessionActionDetails);
}
