package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioOutputStreamProvider.class */
public interface AudioOutputStreamProvider extends Interface {
    public static final Interface.Manager<AudioOutputStreamProvider, Proxy> MANAGER = AudioOutputStreamProvider_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioOutputStreamProvider$Proxy.class */
    public interface Proxy extends AudioOutputStreamProvider, Interface.Proxy {
    }

    void acquire(AudioParameters audioParameters, AudioOutputStreamProviderClient audioOutputStreamProviderClient, UnguessableToken unguessableToken);
}
