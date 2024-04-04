package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureState.class */
public final class VideoCaptureState {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int STARTED = 0;
    public static final int PAUSED = 1;
    public static final int RESUMED = 2;
    public static final int STOPPED = 3;
    public static final int FAILED = 4;
    public static final int ENDED = 5;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 5;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private VideoCaptureState() {
    }
}
