package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/ChildProcessImportance.class */
public @interface ChildProcessImportance {
    public static final int NORMAL = 0;
    public static final int MODERATE = 1;
    public static final int IMPORTANT = 2;
}
