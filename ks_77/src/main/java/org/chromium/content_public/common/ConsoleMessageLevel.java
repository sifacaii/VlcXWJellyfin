package org.chromium.content_public.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/common/ConsoleMessageLevel.class */
public @interface ConsoleMessageLevel {
    public static final int VERBOSE = 0;
    public static final int INFO = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;
    public static final int LAST = 3;
}
