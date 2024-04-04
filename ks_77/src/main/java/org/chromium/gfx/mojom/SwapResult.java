package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/SwapResult.class */
public final class SwapResult {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int ACK = 0;
    public static final int FAILED = 1;
    public static final int NAK_RECREATE_BUFFERS = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private SwapResult() {
    }
}
