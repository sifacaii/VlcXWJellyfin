package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/ResourceFormat.class */
public final class ResourceFormat {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int RGBA_8888 = 0;
    public static final int RGBA_4444 = 1;
    public static final int BGRA_8888 = 2;
    public static final int ALPHA_8 = 3;
    public static final int LUMINANCE_8 = 4;
    public static final int RGB_565 = 5;
    public static final int BGR_565 = 6;
    public static final int ETC1 = 7;
    public static final int RED_8 = 8;
    public static final int RG_88 = 9;
    public static final int LUMINANCE_F16 = 10;
    public static final int RGBA_F16 = 11;
    public static final int R16_EXT = 12;
    public static final int RGBX_8888 = 13;
    public static final int BGRX_8888 = 14;
    public static final int RGBX_1010102 = 15;
    public static final int BGRX_1010102 = 16;
    public static final int YVU_420 = 17;
    public static final int YUV_420_BIPLANAR = 18;
    public static final int UYVY_422 = 19;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 19;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ResourceFormat() {
    }
}
