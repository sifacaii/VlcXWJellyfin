package org.chromium.media.mojom;

import org.chromium.gpu.mojom.SyncToken;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoFrameHandleReleaser.class */
public interface VideoFrameHandleReleaser extends Interface {
    public static final Interface.Manager<VideoFrameHandleReleaser, Proxy> MANAGER = VideoFrameHandleReleaser_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoFrameHandleReleaser$Proxy.class */
    public interface Proxy extends VideoFrameHandleReleaser, Interface.Proxy {
    }

    void releaseVideoFrame(UnguessableToken unguessableToken, SyncToken syncToken);
}
