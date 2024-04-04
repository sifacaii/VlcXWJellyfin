package org.chromium.skia.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/skia/mojom/BlurTileMode.class */
public final class BlurTileMode {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int CLAMP = 0;
    public static final int REPEAT = 1;
    public static final int CLAMP_TO_BLACK = 2;
    public static final int BLUR_TILE_MODE_LAST = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private BlurTileMode() {
    }
}
