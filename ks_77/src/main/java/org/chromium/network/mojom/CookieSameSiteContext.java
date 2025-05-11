package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieSameSiteContext.class */
public final class CookieSameSiteContext {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int CROSS_SITE = 0;
    public static final int SAME_SITE_LAX = 1;
    public static final int SAME_SITE_STRICT = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private CookieSameSiteContext() {
    }
}
