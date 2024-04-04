package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ResolverType.class */
public final class ResolverType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int RESOLVER_TYPE_FAIL = 0;
    public static final int RESOLVER_TYPE_SYSTEM = 1;
    public static final int RESOLVER_TYPE_IP_LITERAL = 2;
    public static final int RESOLVER_TYPE_DIRECT_LOOKUP = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ResolverType() {
    }
}
