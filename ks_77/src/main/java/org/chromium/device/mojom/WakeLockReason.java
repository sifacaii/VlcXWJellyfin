package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/WakeLockReason.class */
public final class WakeLockReason {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int AUDIO_PLAYBACK = 0;
    public static final int VIDEO_PLAYBACK = 1;
    public static final int OTHER = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private WakeLockReason() {
    }
}
