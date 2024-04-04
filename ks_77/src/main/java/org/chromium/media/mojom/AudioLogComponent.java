package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/AudioLogComponent.class */
public final class AudioLogComponent {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int INPUT_CONTROLLER = 0;
    public static final int OUTPUT_CONTROLLER = 1;
    public static final int OUTPUT_STREAM = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private AudioLogComponent() {
    }
}
