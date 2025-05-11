package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider.class */
public interface MediaMetricsProvider extends Interface {
    public static final Interface.Manager<MediaMetricsProvider, Proxy> MANAGER = MediaMetricsProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MediaMetricsProvider$Proxy.class */
    public interface Proxy extends MediaMetricsProvider, Interface.Proxy {
    }

    void initialize(boolean z, int i);

    void onError(int i);

    void setHasPlayed();

    void setHaveEnough();

    void setIsAdMedia();

    void setIsEme();

    void setTimeToMetadata(TimeDelta timeDelta);

    void setTimeToFirstFrame(TimeDelta timeDelta);

    void setTimeToPlayReady(TimeDelta timeDelta);

    void setContainerName(int i);

    void acquireWatchTimeRecorder(PlaybackProperties playbackProperties, InterfaceRequest<WatchTimeRecorder> interfaceRequest);

    void acquireVideoDecodeStatsRecorder(InterfaceRequest<VideoDecodeStatsRecorder> interfaceRequest);

    void addBytesReceived(long j);

    void setHasAudio(int i);

    void setHasVideo(int i);

    void setVideoPipelineInfo(PipelineDecoderInfo pipelineDecoderInfo);

    void setAudioPipelineInfo(PipelineDecoderInfo pipelineDecoderInfo);
}
