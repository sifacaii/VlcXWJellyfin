package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/ImageDecodeAcceleratorSubsampling.class */
public final class ImageDecodeAcceleratorSubsampling {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int K420 = 0;
    public static final int K422 = 1;
    public static final int K444 = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ImageDecodeAcceleratorSubsampling() {
    }
}
