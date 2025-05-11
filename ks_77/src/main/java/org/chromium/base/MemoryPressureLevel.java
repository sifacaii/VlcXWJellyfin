package org.chromium.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/MemoryPressureLevel.class */
public @interface MemoryPressureLevel {
    public static final int NONE = 0;
    public static final int MODERATE = 1;
    public static final int CRITICAL = 2;
}
