package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoderClient.class */
public interface VideoDecoderClient extends Interface {
    public static final Interface.Manager<VideoDecoderClient, Proxy> MANAGER = VideoDecoderClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoderClient$Proxy.class */
    public interface Proxy extends VideoDecoderClient, Interface.Proxy {
    }

    void onVideoFrameDecoded(VideoFrame videoFrame, boolean z, UnguessableToken unguessableToken);

    void onWaiting(int i);

    void requestOverlayInfo(boolean z);
}
