package org.chromium.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/AndroidMeteringMode.class */
public @interface AndroidMeteringMode {
    public static final int NOT_SET = 0;
    public static final int NONE = 1;
    public static final int FIXED = 2;
    public static final int SINGLE_SHOT = 3;
    public static final int CONTINUOUS = 4;
    public static final int NUM_ENTRIES = 5;
}
