package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/LandmarkType.class */
public final class LandmarkType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MOUTH = 0;
    public static final int EYE = 1;
    public static final int NOSE = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private LandmarkType() {
    }
}
