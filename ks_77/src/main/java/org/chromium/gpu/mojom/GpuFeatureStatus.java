package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/GpuFeatureStatus.class */
public final class GpuFeatureStatus {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int ENABLED = 0;
    public static final int BLACKLISTED = 1;
    public static final int DISABLED = 2;
    public static final int SOFTWARE = 3;
    public static final int UNDEFINED = 4;
    public static final int MAX = 5;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 5;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private GpuFeatureStatus() {
    }
}
