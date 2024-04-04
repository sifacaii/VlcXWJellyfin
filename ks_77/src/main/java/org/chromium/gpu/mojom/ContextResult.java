package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/ContextResult.class */
public final class ContextResult {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SUCCESS = 0;
    public static final int TRANSIENT_FAILURE = 1;
    public static final int FATAL_FAILURE = 2;
    public static final int SURFACE_FAILURE = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ContextResult() {
    }
}
