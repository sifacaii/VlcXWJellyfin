package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecodePerfHistory.class */
public interface VideoDecodePerfHistory extends Interface {
    public static final Interface.Manager<VideoDecodePerfHistory, Proxy> MANAGER = VideoDecodePerfHistory_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecodePerfHistory$GetPerfInfoResponse.class */
    public interface GetPerfInfoResponse extends Callbacks.Callback2<Boolean, Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecodePerfHistory$Proxy.class */
    public interface Proxy extends VideoDecodePerfHistory, Interface.Proxy {
    }

    void getPerfInfo(PredictionFeatures predictionFeatures, GetPerfInfoResponse getPerfInfoResponse);
}
