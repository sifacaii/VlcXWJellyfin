package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RequestPriority.class */
public final class RequestPriority {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int THROTTLED = 0;
    public static final int IDLE = 1;
    public static final int LOWEST = 2;
    public static final int LOW = 3;
    public static final int MEDIUM = 4;
    public static final int HIGHEST = 5;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 5;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private RequestPriority() {
    }
}
