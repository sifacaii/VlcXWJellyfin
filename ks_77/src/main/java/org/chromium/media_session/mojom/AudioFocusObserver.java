package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Interface;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusObserver.class */
public interface AudioFocusObserver extends Interface {
    public static final Interface.Manager<AudioFocusObserver, Proxy> MANAGER = AudioFocusObserver_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusObserver$Proxy.class */
    public interface Proxy extends AudioFocusObserver, Interface.Proxy {
    }

    void onFocusGained(AudioFocusRequestState audioFocusRequestState);

    void onFocusLost(AudioFocusRequestState audioFocusRequestState);
}
