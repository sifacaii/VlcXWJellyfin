package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCapturePixelFormat.class */
public final class VideoCapturePixelFormat {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int UNKNOWN = 0;
    public static final int I420 = 1;
    public static final int YV12 = 2;
    public static final int I422 = 3;
    public static final int I420A = 4;
    public static final int I444 = 5;
    public static final int NV12 = 6;
    public static final int NV21 = 7;
    public static final int UYVY = 8;
    public static final int YUY2 = 9;
    public static final int ARGB = 10;
    public static final int XRGB = 11;
    public static final int RGB24 = 12;
    public static final int MJPEG = 13;
    public static final int MT21 = 14;
    public static final int YUV420P9 = 15;
    public static final int YUV420P10 = 16;
    public static final int YUV422P9 = 17;
    public static final int YUV422P10 = 18;
    public static final int YUV444P9 = 19;
    public static final int YUV444P10 = 20;
    public static final int YUV420P12 = 21;
    public static final int YUV422P12 = 22;
    public static final int YUV444P12 = 23;
    public static final int Y16 = 24;
    public static final int ABGR = 25;
    public static final int XBGR = 26;
    public static final int P016LE = 27;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 27;
    }

    public static void validate(int value) {
        if (!isKnownValue(value)) {
            throw new DeserializationException("Invalid enum value.");
        }
    }

    private VideoCapturePixelFormat() {
    }
}
