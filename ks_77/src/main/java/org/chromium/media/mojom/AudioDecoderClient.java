package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioDecoderClient.class */
public interface AudioDecoderClient extends Interface {
    public static final Interface.Manager<AudioDecoderClient, Proxy> MANAGER = AudioDecoderClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioDecoderClient$Proxy.class */
    public interface Proxy extends AudioDecoderClient, Interface.Proxy {
    }

    void onBufferDecoded(AudioBuffer audioBuffer);

    void onWaiting(int i);
}
