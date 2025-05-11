package org.chromium.media.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioDecoder.class */
public interface AudioDecoder extends Interface {
    public static final Interface.Manager<AudioDecoder, Proxy> MANAGER = AudioDecoder_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioDecoder$DecodeResponse.class */
    public interface DecodeResponse extends Callbacks.Callback1<Integer> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioDecoder$InitializeResponse.class */
    public interface InitializeResponse extends Callbacks.Callback2<Boolean, Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioDecoder$Proxy.class */
    public interface Proxy extends AudioDecoder, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioDecoder$ResetResponse.class */
    public interface ResetResponse extends Callbacks.Callback0 {
    }

    void construct(AssociatedInterfaceNotSupported associatedInterfaceNotSupported);

    void initialize(AudioDecoderConfig audioDecoderConfig, int i, InitializeResponse initializeResponse);

    void setDataSource(DataPipe.ConsumerHandle consumerHandle);

    void decode(DecoderBuffer decoderBuffer, DecodeResponse decodeResponse);

    void reset(ResetResponse resetResponse);
}
