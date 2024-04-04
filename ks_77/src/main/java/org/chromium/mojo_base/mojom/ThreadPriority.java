package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo_base/mojom/ThreadPriority.class */
public final class ThreadPriority {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int BACKGROUND = 0;
    public static final int NORMAL = 1;
    public static final int DISPLAY = 2;
    public static final int REALTIME_AUDIO = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ThreadPriority() {
    }
}
