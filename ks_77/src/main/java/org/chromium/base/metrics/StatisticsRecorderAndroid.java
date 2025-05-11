package org.chromium.base.metrics;

import org.chromium.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/StatisticsRecorderAndroid.class */
public final class StatisticsRecorderAndroid {
    private static native String nativeToJson(int i);

    private StatisticsRecorderAndroid() {
    }

    public static String toJson(int verbosityLevel) {
        return nativeToJson(verbosityLevel);
    }
}
