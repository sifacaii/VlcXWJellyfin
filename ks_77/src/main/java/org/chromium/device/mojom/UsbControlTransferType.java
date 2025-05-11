package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbControlTransferType.class */
public final class UsbControlTransferType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int STANDARD = 0;
    public static final int CLASS = 1;
    public static final int VENDOR = 2;
    public static final int RESERVED = 3;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private UsbControlTransferType() {
    }
}
