package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RequestContextFrameType.class */
public final class RequestContextFrameType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int AUXILIARY = 0;
    public static final int NESTED = 1;
    public static final int NONE = 2;
    public static final int TOP_LEVEL = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private RequestContextFrameType() {
    }
}
