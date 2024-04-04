package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ServiceWorkerClientType.class */
public final class ServiceWorkerClientType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int WINDOW = 0;
    public static final int DEDICATED_WORKER = 1;
    public static final int SHARED_WORKER = 2;
    public static final int ALL = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ServiceWorkerClientType() {
    }
}
