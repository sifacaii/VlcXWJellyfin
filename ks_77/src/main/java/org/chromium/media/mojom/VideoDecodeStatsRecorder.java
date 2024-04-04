package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecodeStatsRecorder.class */
public interface VideoDecodeStatsRecorder extends Interface {
    public static final Interface.Manager<VideoDecodeStatsRecorder, Proxy> MANAGER = VideoDecodeStatsRecorder_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecodeStatsRecorder$Proxy.class */
    public interface Proxy extends VideoDecodeStatsRecorder, Interface.Proxy {
    }

    void startNewRecord(PredictionFeatures predictionFeatures);

    void updateRecord(PredictionTargets predictionTargets);
}
