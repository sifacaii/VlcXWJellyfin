package org.chromium.base.metrics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/JSONVerbosityLevel.class */
public @interface JSONVerbosityLevel {
    public static final int JSON_VERBOSITY_LEVEL_FULL = 0;
    public static final int JSON_VERBOSITY_LEVEL_OMIT_BUCKETS = 1;
}
