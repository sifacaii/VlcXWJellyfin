package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererExtension.class */
public interface MediaPlayerRendererExtension extends Interface {
    public static final Interface.Manager<MediaPlayerRendererExtension, Proxy> MANAGER = MediaPlayerRendererExtension_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererExtension$InitiateScopedSurfaceRequestResponse.class */
    public interface InitiateScopedSurfaceRequestResponse extends Callbacks.Callback1<UnguessableToken> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererExtension$Proxy.class */
    public interface Proxy extends MediaPlayerRendererExtension, Interface.Proxy {
    }

    void initiateScopedSurfaceRequest(InitiateScopedSurfaceRequestResponse initiateScopedSurfaceRequestResponse);
}
