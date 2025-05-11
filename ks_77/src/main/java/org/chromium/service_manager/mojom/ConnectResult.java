package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/ConnectResult.class */
public final class ConnectResult {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SUCCEEDED = 0;
    public static final int INVALID_ARGUMENT = 1;
    public static final int ACCESS_DENIED = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ConnectResult() {
    }
}
