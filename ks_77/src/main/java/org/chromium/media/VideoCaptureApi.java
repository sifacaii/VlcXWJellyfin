package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/VideoCaptureApi.class */
public @interface VideoCaptureApi {
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
}
