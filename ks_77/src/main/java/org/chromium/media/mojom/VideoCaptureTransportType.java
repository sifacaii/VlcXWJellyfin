package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureTransportType.class */
public final class VideoCaptureTransportType {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MACOSX_USB_OR_BUILT_IN = 0;
    public static final int OTHER_TRANSPORT = 1;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private VideoCaptureTransportType() {
    }
}
