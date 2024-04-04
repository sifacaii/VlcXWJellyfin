package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/mojom/UsbTransferStatus.class */
public final class UsbTransferStatus {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int COMPLETED = 0;
    public static final int TRANSFER_ERROR = 1;
    public static final int TIMEOUT = 2;
    public static final int CANCELLED = 3;
    public static final int STALLED = 4;
    public static final int DISCONNECT = 5;
    public static final int BABBLE = 6;
    public static final int SHORT_PACKET = 7;
    public static final int PERMISSION_DENIED = 8;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 8;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private UsbTransferStatus() {
    }
}
