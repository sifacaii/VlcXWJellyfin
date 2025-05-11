package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ConnectionType.class */
public final class ConnectionType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int CONNECTION_UNKNOWN = 0;
    public static final int CONNECTION_ETHERNET = 1;
    public static final int CONNECTION_WIFI = 2;
    public static final int CONNECTION_2G = 3;
    public static final int CONNECTION_3G = 4;
    public static final int CONNECTION_4G = 5;
    public static final int CONNECTION_NONE = 6;
    public static final int CONNECTION_BLUETOOTH = 7;
    public static final int CONNECTION_LAST = 7;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 7;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private ConnectionType() {
    }
}
