package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager.class */
public interface AudioFocusManager extends Interface {
    public static final Interface.Manager<AudioFocusManager, Proxy> MANAGER = AudioFocusManager_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager$GetFocusRequestsResponse.class */
    public interface GetFocusRequestsResponse extends Callbacks.Callback1<AudioFocusRequestState[]> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager$Proxy.class */
    public interface Proxy extends AudioFocusManager, Interface.Proxy {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager$RequestAudioFocusResponse.class */
    public interface RequestAudioFocusResponse extends Callbacks.Callback1<UnguessableToken> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManager$RequestGroupedAudioFocusResponse.class */
    public interface RequestGroupedAudioFocusResponse extends Callbacks.Callback1<UnguessableToken> {
    }

    void requestAudioFocus(InterfaceRequest<AudioFocusRequestClient> interfaceRequest, MediaSession mediaSession, MediaSessionInfo mediaSessionInfo, int i, RequestAudioFocusResponse requestAudioFocusResponse);

    void requestGroupedAudioFocus(InterfaceRequest<AudioFocusRequestClient> interfaceRequest, MediaSession mediaSession, MediaSessionInfo mediaSessionInfo, int i, UnguessableToken unguessableToken, RequestGroupedAudioFocusResponse requestGroupedAudioFocusResponse);

    void getFocusRequests(GetFocusRequestsResponse getFocusRequestsResponse);

    void addObserver(AudioFocusObserver audioFocusObserver);

    void setSourceName(String str);

    void setEnforcementMode(int i);
}
