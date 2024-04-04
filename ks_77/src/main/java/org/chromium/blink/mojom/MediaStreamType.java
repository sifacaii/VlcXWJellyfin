package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MediaStreamType.class */
public final class MediaStreamType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int NO_SERVICE = 0;
    public static final int DEVICE_AUDIO_CAPTURE = 1;
    public static final int DEVICE_VIDEO_CAPTURE = 2;
    public static final int GUM_TAB_AUDIO_CAPTURE = 3;
    public static final int GUM_TAB_VIDEO_CAPTURE = 4;
    public static final int GUM_DESKTOP_VIDEO_CAPTURE = 5;
    public static final int GUM_DESKTOP_AUDIO_CAPTURE = 6;
    public static final int DISPLAY_VIDEO_CAPTURE = 7;
    public static final int DISPLAY_AUDIO_CAPTURE = 8;
    public static final int NUM_MEDIA_TYPES = 9;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 9;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private MediaStreamType() {
    }
}
