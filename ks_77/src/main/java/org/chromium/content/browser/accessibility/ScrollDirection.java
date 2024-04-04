package org.chromium.content.browser.accessibility;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/accessibility/ScrollDirection.class */
public @interface ScrollDirection {
    public static final int FORWARD = 0;
    public static final int BACKWARD = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    public static final int LEFT = 4;
    public static final int RIGHT = 5;
}
