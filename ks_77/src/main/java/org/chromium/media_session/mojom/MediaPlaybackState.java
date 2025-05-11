package org.chromium.media_session.mojom;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaPlaybackState.class */
public final class MediaPlaybackState {
    private static final boolean IS_EXTENSIBLE = true;
    public static final int PAUSED = 0;
    public static final int PLAYING = 1;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
    }

    private MediaPlaybackState() {
    }
}
