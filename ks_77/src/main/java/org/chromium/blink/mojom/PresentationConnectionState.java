package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PresentationConnectionState.class */
public final class PresentationConnectionState {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int CONNECTING = 0;
    public static final int CONNECTED = 1;
    public static final int CLOSED = 2;
    public static final int TERMINATED = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private PresentationConnectionState() {
    }
}
