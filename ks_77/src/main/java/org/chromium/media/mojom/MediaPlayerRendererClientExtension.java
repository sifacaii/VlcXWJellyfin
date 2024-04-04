package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererClientExtension.class */
public interface MediaPlayerRendererClientExtension extends Interface {
    public static final Interface.Manager<MediaPlayerRendererClientExtension, Proxy> MANAGER = MediaPlayerRendererClientExtension_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaPlayerRendererClientExtension$Proxy.class */
    public interface Proxy extends MediaPlayerRendererClientExtension, Interface.Proxy {
    }

    void onVideoSizeChange(Size size);

    void onDurationChange(TimeDelta timeDelta);
}
