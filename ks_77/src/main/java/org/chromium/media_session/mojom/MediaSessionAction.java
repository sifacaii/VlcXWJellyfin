package org.chromium.media_session.mojom;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSessionAction.class */
public final class MediaSessionAction {
    private static final boolean IS_EXTENSIBLE = true;
    public static final int PLAY = 0;
    public static final int PAUSE = 1;
    public static final int PREVIOUS_TRACK = 2;
    public static final int NEXT_TRACK = 3;
    public static final int SEEK_BACKWARD = 4;
    public static final int SEEK_FORWARD = 5;
    public static final int SKIP_AD = 6;
    public static final int STOP = 7;
    public static final int SEEK_TO = 8;
    public static final int SCRUB_TO = 9;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 9;
    }

    public static void validate(int value) {
    }

    private MediaSessionAction() {
    }
}
