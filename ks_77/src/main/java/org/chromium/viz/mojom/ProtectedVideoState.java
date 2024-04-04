package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/ProtectedVideoState.class */
public final class ProtectedVideoState {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int CLEAR = 0;
    public static final int SOFTWARE_PROTECTED = 1;
    public static final int HARDWARE_PROTECTED = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ProtectedVideoState() {
    }
}
