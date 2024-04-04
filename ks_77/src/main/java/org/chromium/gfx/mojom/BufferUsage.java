package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/BufferUsage.class */
public final class BufferUsage {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int GPU_READ = 0;
    public static final int SCANOUT = 1;
    public static final int SCANOUT_CAMERA_READ_WRITE = 2;
    public static final int CAMERA_AND_CPU_READ_WRITE = 3;
    public static final int SCANOUT_CPU_READ_WRITE = 4;
    public static final int SCANOUT_VDA_WRITE = 5;
    public static final int GPU_READ_CPU_READ_WRITE = 6;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 6;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private BufferUsage() {
    }
}
