package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbTransferType.class */
public final class UsbTransferType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int CONTROL = 0;
    public static final int ISOCHRONOUS = 1;
    public static final int BULK = 2;
    public static final int INTERRUPT = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private UsbTransferType() {
    }
}
