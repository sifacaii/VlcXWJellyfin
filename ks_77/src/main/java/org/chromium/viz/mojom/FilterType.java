package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/FilterType.class */
public final class FilterType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int GRAYSCALE = 0;
    public static final int SEPIA = 1;
    public static final int SATURATE = 2;
    public static final int HUE_ROTATE = 3;
    public static final int INVERT = 4;
    public static final int BRIGHTNESS = 5;
    public static final int CONTRAST = 6;
    public static final int OPACITY = 7;
    public static final int BLUR = 8;
    public static final int DROP_SHADOW = 9;
    public static final int COLOR_MATRIX = 10;
    public static final int ZOOM = 11;
    public static final int REFERENCE = 12;
    public static final int SATURATING_BRIGHTNESS = 13;
    public static final int ALPHA_THRESHOLD = 14;
    public static final int FILTER_TYPE_LAST = 14;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 14;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private FilterType() {
    }
}
