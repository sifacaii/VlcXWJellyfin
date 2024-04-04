package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ReferrerPolicy.class */
public final class ReferrerPolicy {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int ALWAYS = 0;
    public static final int DEFAULT = 1;
    public static final int NO_REFERRER_WHEN_DOWNGRADE = 2;
    public static final int NEVER = 3;
    public static final int ORIGIN = 4;
    public static final int ORIGIN_WHEN_CROSS_ORIGIN = 5;
    public static final int NO_REFERRER_WHEN_DOWNGRADE_ORIGIN_WHEN_CROSS_ORIGIN = 6;
    public static final int SAME_ORIGIN = 7;
    public static final int STRICT_ORIGIN = 8;
    public static final int LAST = 8;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 8;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ReferrerPolicy() {
    }
}
