package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/BeginFrameArgsType.class */
public final class BeginFrameArgsType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int INVALID = 0;
    public static final int NORMAL = 1;
    public static final int MISSED = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private BeginFrameArgsType() {
    }
}
