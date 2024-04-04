package org.chromium.base.metrics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.chromium.base.TimeUtils;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;

@JNINamespace("base::android")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/metrics/RecordHistogram.class */
public class RecordHistogram {
    private static Throwable sDisabledBy;
    private static Map<String, Long> sCache;
    static final /* synthetic */ boolean $assertionsDisabled;

    private static native long nativeRecordCustomTimesHistogramMilliseconds(String str, long j, int i, int i2, int i3, int i4);

    private static native long nativeRecordBooleanHistogram(String str, long j, boolean z);

    private static native long nativeRecordEnumeratedHistogram(String str, long j, int i, int i2);

    private static native long nativeRecordCustomCountHistogram(String str, long j, int i, int i2, int i3, int i4);

    private static native long nativeRecordLinearCountHistogram(String str, long j, int i, int i2, int i3, int i4);

    private static native long nativeRecordSparseHistogram(String str, long j, int i);

    private static native int nativeGetHistogramValueCountForTesting(String str, int i);

    private static native int nativeGetHistogramTotalCountForTesting(String str);

    static {
        $assertionsDisabled = !RecordHistogram.class.desiredAssertionStatus();
        sCache = Collections.synchronizedMap(new HashMap());
    }

    @VisibleForTesting
    public static void setDisabledForTests(boolean disabled) {
        if (disabled && sDisabledBy != null) {
            throw new IllegalStateException("Histograms are already disabled.", sDisabledBy);
        }
        sDisabledBy = disabled ? new Throwable() : null;
    }

    private static long getCachedHistogramKey(String name) {
        Long key = sCache.get(name);
        if (key == null) {
            return 0L;
        }
        return key.longValue();
    }

    public static void recordBooleanHistogram(String name, boolean sample) {
        if (sDisabledBy != null) {
            return;
        }
        long key = getCachedHistogramKey(name);
        long result = nativeRecordBooleanHistogram(name, key, sample);
        if (result != key) {
            sCache.put(name, Long.valueOf(result));
        }
    }

    public static void recordEnumeratedHistogram(String name, int sample, int boundary) {
        if (sDisabledBy != null) {
            return;
        }
        long key = getCachedHistogramKey(name);
        long result = nativeRecordEnumeratedHistogram(name, key, sample, boundary);
        if (result != key) {
            sCache.put(name, Long.valueOf(result));
        }
    }

    public static void recordCountHistogram(String name, int sample) {
        recordCustomCountHistogram(name, sample, 1, TimeUtils.NANOSECONDS_PER_MILLISECOND, 50);
    }

    public static void recordCount100Histogram(String name, int sample) {
        recordCustomCountHistogram(name, sample, 1, 100, 50);
    }

    public static void recordCount1000Histogram(String name, int sample) {
        recordCustomCountHistogram(name, sample, 1, 1000, 50);
    }

    public static void recordCustomCountHistogram(String name, int sample, int min, int max, int numBuckets) {
        if (sDisabledBy != null) {
            return;
        }
        long key = getCachedHistogramKey(name);
        long result = nativeRecordCustomCountHistogram(name, key, sample, min, max, numBuckets);
        if (result != key) {
            sCache.put(name, Long.valueOf(result));
        }
    }

    public static void recordLinearCountHistogram(String name, int sample, int min, int max, int numBuckets) {
        if (sDisabledBy != null) {
            return;
        }
        long key = getCachedHistogramKey(name);
        long result = nativeRecordLinearCountHistogram(name, key, sample, min, max, numBuckets);
        if (result != key) {
            sCache.put(name, Long.valueOf(result));
        }
    }

    public static void recordPercentageHistogram(String name, int sample) {
        if (sDisabledBy != null) {
            return;
        }
        long key = getCachedHistogramKey(name);
        long result = nativeRecordEnumeratedHistogram(name, key, sample, 101);
        if (result != key) {
            sCache.put(name, Long.valueOf(result));
        }
    }

    public static void recordSparseHistogram(String name, int sample) {
        if (sDisabledBy != null) {
            return;
        }
        long key = getCachedHistogramKey(name);
        long result = nativeRecordSparseHistogram(name, key, sample);
        if (result != key) {
            sCache.put(name, Long.valueOf(result));
        }
    }

    public static void recordTimesHistogram(String name, long durationMs) {
        recordCustomTimesHistogramMilliseconds(name, durationMs, 1L, 10000L, 50);
    }

    public static void recordMediumTimesHistogram(String name, long durationMs) {
        recordCustomTimesHistogramMilliseconds(name, durationMs, 10L, 180000L, 50);
    }

    public static void recordLongTimesHistogram(String name, long durationMs) {
        recordCustomTimesHistogramMilliseconds(name, durationMs, 1L, 3600000L, 50);
    }

    public static void recordLongTimesHistogram100(String name, long durationMs) {
        recordCustomTimesHistogramMilliseconds(name, durationMs, 1L, 3600000L, 100);
    }

    public static void recordCustomTimesHistogram(String name, long durationMs, long min, long max, int numBuckets) {
        recordCustomTimesHistogramMilliseconds(name, durationMs, min, max, numBuckets);
    }

    public static void recordMemoryKBHistogram(String name, int sizeInKB) {
        recordCustomCountHistogram(name, sizeInKB, 1000, 500000, 50);
    }

    private static int clampToInt(long value) {
        if (value > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (value < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) value;
    }

    private static void recordCustomTimesHistogramMilliseconds(String name, long duration, long min, long max, int numBuckets) {
        if (sDisabledBy != null) {
            return;
        }
        long key = getCachedHistogramKey(name);
        if (!$assertionsDisabled && max != clampToInt(max)) {
            throw new AssertionError();
        }
        long result = nativeRecordCustomTimesHistogramMilliseconds(name, key, clampToInt(duration), clampToInt(min), clampToInt(max), numBuckets);
        if (result != key) {
            sCache.put(name, Long.valueOf(result));
        }
    }

    @VisibleForTesting
    public static int getHistogramValueCountForTesting(String name, int sample) {
        return nativeGetHistogramValueCountForTesting(name, sample);
    }

    @VisibleForTesting
    public static int getHistogramTotalCountForTesting(String name) {
        return nativeGetHistogramTotalCountForTesting(name);
    }
}
