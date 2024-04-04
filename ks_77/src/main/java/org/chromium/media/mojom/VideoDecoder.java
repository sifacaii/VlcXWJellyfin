package org.chromium.media.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoder.class */
public interface VideoDecoder extends Interface {
    public static final Interface.Manager<VideoDecoder, Proxy> MANAGER = VideoDecoder_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoder$DecodeResponse.class */
    public interface DecodeResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoder$GetSupportedConfigsResponse.class */
    public interface GetSupportedConfigsResponse extends Callbacks.Callback1<Map<Integer, SupportedVideoDecoderConfig[]>> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoder$InitializeResponse.class */
    public interface InitializeResponse extends Callbacks.Callback3<Boolean, Boolean, Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoder$Proxy.class */
    public interface Proxy extends VideoDecoder, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoDecoder$ResetResponse.class */
    public interface ResetResponse extends Callbacks.Callback0 {
    }

    void getSupportedConfigs(GetSupportedConfigsResponse getSupportedConfigsResponse);

    void construct(AssociatedInterfaceNotSupported associatedInterfaceNotSupported, AssociatedInterfaceNotSupported associatedInterfaceNotSupported2, InterfaceRequest<VideoFrameHandleReleaser> interfaceRequest, DataPipe.ConsumerHandle consumerHandle, CommandBufferId commandBufferId, int i, org.chromium.gfx.mojom.ColorSpace colorSpace);

    void initialize(VideoDecoderConfig videoDecoderConfig, boolean z, int i, InitializeResponse initializeResponse);

    void decode(DecoderBuffer decoderBuffer, DecodeResponse decodeResponse);

    void reset(ResetResponse resetResponse);

    void onOverlayInfoChanged(OverlayInfo overlayInfo);
}
