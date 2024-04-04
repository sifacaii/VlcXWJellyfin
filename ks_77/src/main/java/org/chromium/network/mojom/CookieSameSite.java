package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieSameSite.class */
public final class CookieSameSite {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int UNSPECIFIED = -1;
    public static final int NO_RESTRICTION = 0;
    public static final int LAX_MODE = 1;
    public static final int STRICT_MODE = 2;
    public static final int EXTENDED_MODE = 3;

    public static boolean isKnownValue(int value) {
        return value >= -1 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private CookieSameSite() {
    }
}
