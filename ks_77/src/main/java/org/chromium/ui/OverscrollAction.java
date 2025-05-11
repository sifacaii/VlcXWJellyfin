package org.chromium.ui;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/OverscrollAction.class */
public @interface OverscrollAction {
    public static final int NONE = 0;
    public static final int PULL_TO_REFRESH = 1;
    public static final int HISTORY_NAVIGATION = 2;
}
