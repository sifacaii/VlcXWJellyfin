package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/UpdateNetworkIsolationKeyOnRedirect.class */
public final class UpdateNetworkIsolationKeyOnRedirect {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int DO_NOT_UPDATE = 0;
    public static final int UPDATE_TOP_FRAME_AND_FRAME_ORIGIN = 1;
    public static final int UPDATE_FRAME_ORIGIN = 2;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private UpdateNetworkIsolationKeyOnRedirect() {
    }
}
