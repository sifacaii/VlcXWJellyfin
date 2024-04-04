package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/RestrictedCookieManagerRole.class */
public final class RestrictedCookieManagerRole {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int SCRIPT = 0;
    public static final int NETWORK = 1;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private RestrictedCookieManagerRole() {
    }
}
