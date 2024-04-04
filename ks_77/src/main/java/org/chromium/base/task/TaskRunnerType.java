package org.chromium.base.task;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/TaskRunnerType.class */
public @interface TaskRunnerType {
    public static final int BASE = 0;
    public static final int SEQUENCED = 1;
    public static final int SINGLE_THREAD = 2;
}
