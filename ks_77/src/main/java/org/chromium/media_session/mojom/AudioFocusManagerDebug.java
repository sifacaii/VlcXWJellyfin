package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManagerDebug.class */
public interface AudioFocusManagerDebug extends Interface {
    public static final Interface.Manager<AudioFocusManagerDebug, Proxy> MANAGER = AudioFocusManagerDebug_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManagerDebug$GetDebugInfoForRequestResponse.class */
    public interface GetDebugInfoForRequestResponse extends Callbacks.Callback1<MediaSessionDebugInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusManagerDebug$Proxy.class */
    public interface Proxy extends AudioFocusManagerDebug, Interface.Proxy {
    }

    void getDebugInfoForRequest(UnguessableToken unguessableToken, GetDebugInfoForRequestResponse getDebugInfoForRequestResponse);
}
