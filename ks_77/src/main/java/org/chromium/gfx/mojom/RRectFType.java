package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/RRectFType.class */
public final class RRectFType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int EMPTY = 0;
    public static final int RECT = 1;
    public static final int SINGLE = 2;
    public static final int SIMPLE = 3;
    public static final int OVAL = 4;
    public static final int COMPLEX = 5;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 5;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private RRectFType() {
    }
}
