package org.chromium.base;

import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;

@JNINamespace("base::android")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/TimeUtils.class */
public class TimeUtils {
    public static final int NANOSECONDS_PER_MILLISECOND = 1000000;
    public static final int SECONDS_PER_MINUTE = 60;
    public static final int SECONDS_PER_HOUR = 3600;
    public static final int SECONDS_PER_DAY = 86400;

    public static native long nativeGetTimeTicksNowUs();

    private TimeUtils() {
    }
}
