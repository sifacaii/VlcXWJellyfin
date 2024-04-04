package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/ImageDecodeAcceleratorType.class */
public final class ImageDecodeAcceleratorType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int JPEG = 0;
    public static final int WEB_P = 1;
    public static final int UNKNOWN = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ImageDecodeAcceleratorType() {
    }
}
