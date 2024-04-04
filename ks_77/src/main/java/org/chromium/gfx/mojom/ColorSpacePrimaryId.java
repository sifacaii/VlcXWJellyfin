package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/ColorSpacePrimaryId.class */
public final class ColorSpacePrimaryId {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int INVALID = 0;
    public static final int BT709 = 1;
    public static final int BT470M = 2;
    public static final int BT470BG = 3;
    public static final int SMPTE170M = 4;
    public static final int SMPTE240M = 5;
    public static final int FILM = 6;
    public static final int BT2020 = 7;
    public static final int SMPTEST428_1 = 8;
    public static final int SMPTEST431_2 = 9;
    public static final int SMPTEST432_1 = 10;
    public static final int XYZ_D50 = 11;
    public static final int ADOBE_RGB = 12;
    public static final int APPLE_GENERIC_RGB = 13;
    public static final int WIDE_GAMUT_COLOR_SPIN = 14;
    public static final int CUSTOM = 15;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 15;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ColorSpacePrimaryId() {
    }
}
