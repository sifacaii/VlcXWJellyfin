package org.chromium.media_session.mojom;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/AudioFocusType.class */
public final class AudioFocusType {
    private static final boolean IS_EXTENSIBLE = true;
    public static final int GAIN = 0;
    public static final int GAIN_TRANSIENT_MAY_DUCK = 1;
    public static final int GAIN_TRANSIENT = 2;
    public static final int AMBIENT = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
    }

    private AudioFocusType() {
    }
}
