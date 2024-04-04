package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/proxy_resolver/mojom/HostResolveOperation.class */
public final class HostResolveOperation {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int DNS_RESOLVE = 0;
    public static final int DNS_RESOLVE_EX = 1;
    public static final int MY_IP_ADDRESS = 2;
    public static final int MY_IP_ADDRESS_EX = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private HostResolveOperation() {
    }
}
