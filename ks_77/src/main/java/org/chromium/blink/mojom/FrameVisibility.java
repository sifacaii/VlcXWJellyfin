package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/FrameVisibility.class */
public final class FrameVisibility {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int RENDERED_OUT_OF_VIEWPORT = 0;
    public static final int RENDERED_IN_VIEWPORT = 1;
    public static final int NOT_RENDERED = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private FrameVisibility() {
    }
}
