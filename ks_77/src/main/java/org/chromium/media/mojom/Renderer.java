package org.chromium.media.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer.class */
public interface Renderer extends Interface {
    public static final Interface.Manager<Renderer, Proxy> MANAGER = Renderer_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer$FlushResponse.class */
    public interface FlushResponse extends Callbacks.Callback0 {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer$InitializeResponse.class */
    public interface InitializeResponse extends Callbacks.Callback1<Boolean> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer$Proxy.class */
    public interface Proxy extends Renderer, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/Renderer$SetCdmResponse.class */
    public interface SetCdmResponse extends Callbacks.Callback1<Boolean> {
    }

    void initialize(AssociatedInterfaceNotSupported associatedInterfaceNotSupported, DemuxerStream[] demuxerStreamArr, MediaUrlParams mediaUrlParams, InitializeResponse initializeResponse);

    void flush(FlushResponse flushResponse);

    void startPlayingFrom(TimeDelta timeDelta);

    void setPlaybackRate(double d);

    void setVolume(float f);

    void setCdm(int i, SetCdmResponse setCdmResponse);
}
