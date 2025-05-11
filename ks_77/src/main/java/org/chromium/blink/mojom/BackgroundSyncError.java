package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/BackgroundSyncError.class */
public final class BackgroundSyncError {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int NONE = 0;
    public static final int STORAGE = 1;
    public static final int NOT_FOUND = 2;
    public static final int NO_SERVICE_WORKER = 3;
    public static final int NOT_ALLOWED = 4;
    public static final int PERMISSION_DENIED = 5;
    public static final int MAX = 5;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 5;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private BackgroundSyncError() {
    }
}
