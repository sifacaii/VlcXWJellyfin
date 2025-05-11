package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/BufferFormat.class */
public final class BufferFormat {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int R_8 = 0;
    public static final int R_16 = 1;
    public static final int RG_88 = 2;
    public static final int BGR_565 = 3;
    public static final int RGBA_4444 = 4;
    public static final int RGBX_8888 = 5;
    public static final int RGBA_8888 = 6;
    public static final int BGRX_8888 = 7;
    public static final int BGRX_1010102 = 8;
    public static final int RGBX_1010102 = 9;
    public static final int BGRA_8888 = 10;
    public static final int RGBA_F16 = 11;
    public static final int YVU_420 = 12;
    public static final int YUV_420_BIPLANAR = 13;
    public static final int UYVY_422 = 14;
    public static final int P010 = 15;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 15;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private BufferFormat() {
    }
}
