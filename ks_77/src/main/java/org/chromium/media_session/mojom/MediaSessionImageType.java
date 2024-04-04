package org.chromium.media_session.mojom;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaSessionImageType.class */
public final class MediaSessionImageType {
    private static final boolean IS_EXTENSIBLE = true;
    public static final int ARTWORK = 0;
    public static final int SOURCE_ICON = 1;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
    }

    private MediaSessionImageType() {
    }
}
