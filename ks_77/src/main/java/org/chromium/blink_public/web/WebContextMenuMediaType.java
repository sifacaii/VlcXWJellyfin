package org.chromium.blink_public.web;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink_public/web/WebContextMenuMediaType.class */
public @interface WebContextMenuMediaType {
    public static final int NONE = 0;
    public static final int IMAGE = 1;
    public static final int VIDEO = 2;
    public static final int AUDIO = 3;
    public static final int CANVAS = 4;
    public static final int FILE = 5;
    public static final int PLUGIN = 6;
    public static final int LAST = 6;
}
