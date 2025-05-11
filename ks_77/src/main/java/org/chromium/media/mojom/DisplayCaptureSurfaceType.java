package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DisplayCaptureSurfaceType.class */
public final class DisplayCaptureSurfaceType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MONITOR = 0;
    public static final int WINDOW = 1;
    public static final int APPLICATION = 2;
    public static final int BROWSER = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private DisplayCaptureSurfaceType() {
    }
}
