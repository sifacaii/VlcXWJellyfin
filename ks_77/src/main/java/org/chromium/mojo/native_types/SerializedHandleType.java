package org.chromium.mojo.native_types;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/native_types/SerializedHandleType.class */
public final class SerializedHandleType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MOJO_HANDLE = 0;
    public static final int PLATFORM_FILE = 1;
    public static final int WIN_HANDLE = 2;
    public static final int MACH_PORT = 3;
    public static final int FUCHSIA_HANDLE = 4;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private SerializedHandleType() {
    }
}
