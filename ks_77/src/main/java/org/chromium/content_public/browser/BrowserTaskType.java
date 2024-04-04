package org.chromium.content_public.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/BrowserTaskType.class */
public @interface BrowserTaskType {
    public static final int DEFAULT = 0;
    public static final int BOOTSTRAP = 1;
    public static final int NAVIGATION = 2;
    public static final int PRECONNECT = 3;
    public static final int BROWSER_TASK_TYPE_LAST = 4;
}
