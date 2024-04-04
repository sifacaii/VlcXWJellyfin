package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/ColorSpaceRangeId.class */
public final class ColorSpaceRangeId {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int INVALID = 0;
    public static final int LIMITED = 1;
    public static final int FULL = 2;
    public static final int DERIVED = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ColorSpaceRangeId() {
    }
}
