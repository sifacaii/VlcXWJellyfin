package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioInputStreamClient.class */
public interface AudioInputStreamClient extends Interface {
    public static final Interface.Manager<AudioInputStreamClient, Proxy> MANAGER = AudioInputStreamClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioInputStreamClient$Proxy.class */
    public interface Proxy extends AudioInputStreamClient, Interface.Proxy {
    }

    void onError();

    void onMutedStateChanged(boolean z);
}
