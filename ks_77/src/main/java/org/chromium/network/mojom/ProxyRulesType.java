package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ProxyRulesType.class */
public final class ProxyRulesType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int EMPTY = 0;
    public static final int PROXY_LIST = 1;
    public static final int PROXY_LIST_PER_SCHEME = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ProxyRulesType() {
    }
}
