package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerEventStatus.class */
public final class ServiceWorkerEventStatus {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int COMPLETED = 0;
    public static final int REJECTED = 1;
    public static final int ABORTED = 2;
    public static final int TIMEOUT = 3;
    public static final int MAX = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ServiceWorkerEventStatus() {
    }
}
