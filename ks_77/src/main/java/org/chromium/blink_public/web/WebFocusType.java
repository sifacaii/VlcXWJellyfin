package org.chromium.blink_public.web;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink_public/web/WebFocusType.class */
public @interface WebFocusType {
    public static final int NONE = 0;
    public static final int FORWARD = 1;
    public static final int BACKWARD = 2;
    public static final int SPATIAL_NAVIGATION = 3;
    public static final int MOUSE = 4;
    public static final int ACCESS_KEY = 5;
    public static final int PAGE = 6;
    public static final int LAST = 6;
}
