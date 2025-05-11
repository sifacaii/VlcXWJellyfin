package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/SubpixelRendering.class */
public final class SubpixelRendering {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int NONE = 0;
    public static final int RGB = 1;
    public static final int BGR = 2;
    public static final int VRGB = 3;
    public static final int VBGR = 4;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private SubpixelRendering() {
    }
}
