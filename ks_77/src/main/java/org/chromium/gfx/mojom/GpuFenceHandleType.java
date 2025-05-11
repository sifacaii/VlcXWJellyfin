package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/GpuFenceHandleType.class */
public final class GpuFenceHandleType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int EMPTY = 0;
    public static final int ANDROID_NATIVE_FENCE_SYNC = 1;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private GpuFenceHandleType() {
    }
}
