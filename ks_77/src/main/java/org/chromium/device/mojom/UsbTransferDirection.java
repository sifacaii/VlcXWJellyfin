package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbTransferDirection.class */
public final class UsbTransferDirection {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int INBOUND = 0;
    public static final int OUTBOUND = 1;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private UsbTransferDirection() {
    }
}
