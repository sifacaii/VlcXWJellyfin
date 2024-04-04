package org.chromium.blink_public.platform;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink_public/platform/WebDisplayMode.class */
public @interface WebDisplayMode {
    public static final int UNDEFINED = 0;
    public static final int BROWSER = 1;
    public static final int MINIMAL_UI = 2;
    public static final int STANDALONE = 3;
    public static final int FULLSCREEN = 4;
    public static final int LAST = 4;
}
