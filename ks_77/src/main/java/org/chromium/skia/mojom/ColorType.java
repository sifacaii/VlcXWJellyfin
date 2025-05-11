package org.chromium.skia.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/skia/mojom/ColorType.class */
public final class ColorType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int UNKNOWN = 0;
    public static final int ALPHA_8 = 1;
    public static final int RGB_565 = 2;
    public static final int ARGB_4444 = 3;
    public static final int RGBA_8888 = 4;
    public static final int BGRA_8888 = 5;
    public static final int INDEX_8 = 6;
    public static final int GRAY_8 = 7;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 7;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ColorType() {
    }
}
