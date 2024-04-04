package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioOutputStreamProviderClient.class */
public interface AudioOutputStreamProviderClient extends Interface {
    public static final Interface.Manager<AudioOutputStreamProviderClient, Proxy> MANAGER = AudioOutputStreamProviderClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioOutputStreamProviderClient$Proxy.class */
    public interface Proxy extends AudioOutputStreamProviderClient, Interface.Proxy {
    }

    void created(AudioOutputStream audioOutputStream, ReadWriteAudioDataPipe readWriteAudioDataPipe);
}
