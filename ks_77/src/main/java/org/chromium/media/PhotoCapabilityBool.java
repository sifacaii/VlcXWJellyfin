package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/PhotoCapabilityBool.class */
public @interface PhotoCapabilityBool {
    public static final int SUPPORTS_TORCH = 0;
    public static final int TORCH = 1;
    public static final int RED_EYE_REDUCTION = 2;
    public static final int NUM_ENTRIES = 3;
}
