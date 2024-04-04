package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/AndroidVideoCaptureFrameDropReason.class */
public @interface AndroidVideoCaptureFrameDropReason {
    public static final int ANDROID_API_1_UNEXPECTED_DATA_LENGTH = 8;
    public static final int ANDROID_API_2_ACQUIRED_IMAGE_IS_NULL = 9;
}
