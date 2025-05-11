package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.TimeTicks;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient.class */
public interface RendererClient extends Interface {
    public static final Interface.Manager<RendererClient, Proxy> MANAGER = RendererClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/RendererClient$Proxy.class */
    public interface Proxy extends RendererClient, Interface.Proxy {
    }

    void onTimeUpdate(TimeDelta timeDelta, TimeDelta timeDelta2, TimeTicks timeTicks);

    void onBufferingStateChange(int i, int i2);

    void onEnded();

    void onError();

    void onAudioConfigChange(AudioDecoderConfig audioDecoderConfig);

    void onVideoConfigChange(VideoDecoderConfig videoDecoderConfig);

    void onVideoNaturalSizeChange(Size size);

    void onVideoOpacityChange(boolean z);

    void onStatisticsUpdate(PipelineStatistics pipelineStatistics);

    void onWaiting(int i);
}
