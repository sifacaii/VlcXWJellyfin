package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationConnectionCloseReason.class */
public final class PresentationConnectionCloseReason {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int CONNECTION_ERROR = 0;
    public static final int CLOSED = 1;
    public static final int WENT_AWAY = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PresentationConnectionCloseReason() {
    }
}
