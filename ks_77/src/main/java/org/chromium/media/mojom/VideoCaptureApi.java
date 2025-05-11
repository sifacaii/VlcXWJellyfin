package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureApi.class */
public final class VideoCaptureApi {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int LINUX_V4L2_SINGLE_PLANE = 0;
    public static final int WIN_MEDIA_FOUNDATION = 1;
    public static final int WIN_MEDIA_FOUNDATION_SENSOR = 2;
    public static final int WIN_DIRECT_SHOW = 3;
    public static final int MACOSX_AVFOUNDATION = 4;
    public static final int MACOSX_DECKLINK = 5;
    public static final int ANDROID_API1 = 6;
    public static final int ANDROID_API2_LEGACY = 7;
    public static final int ANDROID_API2_FULL = 8;
    public static final int ANDROID_API2_LIMITED = 9;
    public static final int VIRTUAL_DEVICE = 10;
    public static final int UNKNOWN = 11;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 11;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private VideoCaptureApi() {
    }
}
