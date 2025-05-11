package org.chromium.media_session.mojom;

import org.chromium.mojo.bindings.Callbacks;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession.class */
public interface MediaSession extends Interface {
    public static final Interface.Manager<MediaSession, Proxy> MANAGER = MediaSession_Internal.MANAGER;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession$GetDebugInfoResponse.class */
    public interface GetDebugInfoResponse extends Callbacks.Callback1<MediaSessionDebugInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession$GetMediaImageBitmapResponse.class */
    public interface GetMediaImageBitmapResponse extends Callbacks.Callback1<MediaImageBitmap> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession$GetMediaSessionInfoResponse.class */
    public interface GetMediaSessionInfoResponse extends Callbacks.Callback1<MediaSessionInfo> {
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession$Proxy.class */
    public interface Proxy extends MediaSession, Interface.Proxy {
    }

    void getMediaSessionInfo(GetMediaSessionInfoResponse getMediaSessionInfoResponse);

    void getDebugInfo(GetDebugInfoResponse getDebugInfoResponse);

    void startDucking();

    void stopDucking();

    void suspend(int i);

    void resume(int i);

    void addObserver(MediaSessionObserver mediaSessionObserver);

    void previousTrack();

    void nextTrack();

    void seek(TimeDelta timeDelta);

    void stop(int i);

    void skipAd();

    void getMediaImageBitmap(MediaImage mediaImage, int i, int i2, GetMediaImageBitmapResponse getMediaImageBitmapResponse);

    void seekTo(TimeDelta timeDelta);

    void scrubTo(TimeDelta timeDelta);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSession$SuspendType.class */
    public static final class SuspendType {
        private static final boolean IS_EXTENSIBLE = true;
        public static final int SYSTEM = 0;
        public static final int UI = 1;
        public static final int CONTENT = 2;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 2;
        }

        public static void validate(int value) {
        }

        private SuspendType() {
        }
    }
}
