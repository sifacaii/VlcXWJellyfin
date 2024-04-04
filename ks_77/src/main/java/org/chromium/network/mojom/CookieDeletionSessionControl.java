package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieDeletionSessionControl.class */
public final class CookieDeletionSessionControl {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int IGNORE_CONTROL = 0;
    public static final int SESSION_COOKIES = 1;
    public static final int PERSISTENT_COOKIES = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private CookieDeletionSessionControl() {
    }
}
