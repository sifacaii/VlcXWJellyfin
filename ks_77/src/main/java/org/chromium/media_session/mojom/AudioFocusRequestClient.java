package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestClient.class */
public interface AudioFocusRequestClient extends Interface {
    public static final Interface.Manager<AudioFocusRequestClient, Proxy> MANAGER = AudioFocusRequestClient_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestClient$Proxy.class */
    public interface Proxy extends AudioFocusRequestClient, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusRequestClient$RequestAudioFocusResponse.class */
    public interface RequestAudioFocusResponse extends Callbacks.Callback0 {
    }

    void requestAudioFocus(MediaSessionInfo mediaSessionInfo, int i, RequestAudioFocusResponse requestAudioFocusResponse);

    void abandonAudioFocus();

    void mediaSessionInfoChanged(MediaSessionInfo mediaSessionInfo);
}
