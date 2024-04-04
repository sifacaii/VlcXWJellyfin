package org.chromium.device.nfc;

import org.chromium.device.mojom.NdefMessage;
import org.chromium.device.mojom.NdefRecord;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/device/nfc/NdefMessageValidator.class */
public final class NdefMessageValidator {
    public static boolean isValid(NdefMessage message) {
        if (message == null || message.data == null || message.data.length == 0) {
            return false;
        }
        for (int i = 0; i < message.data.length; i++) {
            if (!isValid(message.data[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(NdefRecord record) {
        if (record == null) {
            return false;
        }
        if (record.recordType == 0) {
            return true;
        }
        return (record.data == null || record.mediaType == null || record.mediaType.isEmpty()) ? false : true;
    }
}
