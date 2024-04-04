package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/InvalidateTypes.class */
public @interface InvalidateTypes {
    public static final int URL = 1;
    public static final int TAB = 2;
    public static final int LOAD = 4;
    public static final int TITLE = 8;
    public static final int ALL = 15;
}
