package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationErrorType.class */
public final class PresentationErrorType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int NO_AVAILABLE_SCREENS = 0;
    public static final int PRESENTATION_REQUEST_CANCELLED = 1;
    public static final int NO_PRESENTATION_FOUND = 2;
    public static final int PREVIOUS_START_IN_PROGRESS = 3;
    public static final int UNKNOWN = 4;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PresentationErrorType() {
    }
}
