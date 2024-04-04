package org.chromium.base.task;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/TaskPriority.class */
public @interface TaskPriority {
    public static final int LOWEST = 0;
    public static final int BEST_EFFORT = 0;
    public static final int USER_VISIBLE = 1;
    public static final int USER_BLOCKING = 2;
    public static final int HIGHEST = 2;
}
