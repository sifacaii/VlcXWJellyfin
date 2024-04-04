package org.chromium.components.download;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/components/download/ResumeMode.class */
public @interface ResumeMode {
    public static final int INVALID = 0;
    public static final int IMMEDIATE_CONTINUE = 1;
    public static final int IMMEDIATE_RESTART = 2;
    public static final int USER_CONTINUE = 3;
    public static final int USER_RESTART = 4;
}
