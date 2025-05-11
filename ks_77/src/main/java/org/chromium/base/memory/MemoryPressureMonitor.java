package org.chromium.base.memory;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
import org.chromium.base.ContextUtils;
import org.chromium.base.MemoryPressureListener;
import org.chromium.base.Supplier;
import org.chromium.base.ThreadUtils;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.metrics.CachedMetrics;

@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/memory/MemoryPressureMonitor.class */
public class MemoryPressureMonitor {
    private static final int DEFAULT_THROTTLING_INTERVAL_MS = 60000;
    private final int mThrottlingIntervalMs;
    private Integer mThrottledPressure;
    private boolean mIsInsideThrottlingInterval;
    private boolean mPollingEnabled;
    private static final CachedMetrics.Count1MHistogramSample sGetMyMemoryStateSucceededTime;
    private static final CachedMetrics.Count1MHistogramSample sGetMyMemoryStateFailedTime;
    public static final MemoryPressureMonitor INSTANCE;
    static final /* synthetic */ boolean $assertionsDisabled;
    private int mLastReportedPressure = 0;
    private Supplier<Integer> mCurrentPressureSupplier = MemoryPressureMonitor::getCurrentMemoryPressure;
    private MemoryPressureCallback mReportingCallback = MemoryPressureListener::notifyMemoryPressure;
    private final Runnable mThrottlingIntervalTask = this::onThrottlingIntervalFinished;

    static {
        $assertionsDisabled = !MemoryPressureMonitor.class.desiredAssertionStatus();
        sGetMyMemoryStateSucceededTime = new CachedMetrics.Count1MHistogramSample("Android.MemoryPressureMonitor.GetMyMemoryState.Succeeded.Time");
        sGetMyMemoryStateFailedTime = new CachedMetrics.Count1MHistogramSample("Android.MemoryPressureMonitor.GetMyMemoryState.Failed.Time");
        INSTANCE = new MemoryPressureMonitor(DEFAULT_THROTTLING_INTERVAL_MS);
    }

    @VisibleForTesting
    protected MemoryPressureMonitor(int throttlingIntervalMs) {
        this.mThrottlingIntervalMs = throttlingIntervalMs;
    }

    public void registerComponentCallbacks() {
        ThreadUtils.assertOnUiThread();
        ContextUtils.getApplicationContext().registerComponentCallbacks(new ComponentCallbacks2() { // from class: org.chromium.base.memory.MemoryPressureMonitor.1
            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int level) {
                Integer pressure = MemoryPressureMonitor.memoryPressureFromTrimLevel(level);
                if (pressure != null) {
                    MemoryPressureMonitor.this.notifyPressure(pressure.intValue());
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
                MemoryPressureMonitor.this.notifyPressure(2);
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
            }
        });
    }

    public void enablePolling() {
        ThreadUtils.assertOnUiThread();
        if (this.mPollingEnabled) {
            return;
        }
        this.mPollingEnabled = true;
        if (!this.mIsInsideThrottlingInterval) {
            reportCurrentPressure();
        }
    }

    public void disablePolling() {
        ThreadUtils.assertOnUiThread();
        if (this.mPollingEnabled) {
            this.mPollingEnabled = false;
        }
    }

    public void notifyPressure(int pressure) {
        ThreadUtils.assertOnUiThread();
        if (this.mIsInsideThrottlingInterval) {
            this.mThrottledPressure = Integer.valueOf(pressure);
        } else {
            reportPressure(pressure);
        }
    }

    public int getLastReportedPressure() {
        ThreadUtils.assertOnUiThread();
        return this.mLastReportedPressure;
    }

    private void reportPressure(int pressure) {
        if (!$assertionsDisabled && this.mIsInsideThrottlingInterval) {
            throw new AssertionError("Can't report pressure when throttling.");
        }
        startThrottlingInterval();
        this.mLastReportedPressure = pressure;
        this.mReportingCallback.onPressure(pressure);
    }

    private void onThrottlingIntervalFinished() {
        this.mIsInsideThrottlingInterval = false;
        if (this.mThrottledPressure != null && this.mLastReportedPressure != this.mThrottledPressure.intValue()) {
            int throttledPressure = this.mThrottledPressure.intValue();
            this.mThrottledPressure = null;
            reportPressure(throttledPressure);
        } else if (this.mPollingEnabled && this.mLastReportedPressure == 2) {
            reportCurrentPressure();
        }
    }

    private void reportCurrentPressure() {
        Integer pressure = this.mCurrentPressureSupplier.get();
        if (pressure != null) {
            reportPressure(pressure.intValue());
        }
    }

    private void startThrottlingInterval() {
        ThreadUtils.postOnUiThreadDelayed(this.mThrottlingIntervalTask, this.mThrottlingIntervalMs);
        this.mIsInsideThrottlingInterval = true;
    }

    @VisibleForTesting
    public void setCurrentPressureSupplierForTesting(Supplier<Integer> supplier) {
        this.mCurrentPressureSupplier = supplier;
    }

    @VisibleForTesting
    public void setReportingCallbackForTesting(MemoryPressureCallback callback) {
        this.mReportingCallback = callback;
    }

    private static Integer getCurrentMemoryPressure() {
        long startNanos = elapsedRealtimeNanos();
        try {
            ActivityManager.RunningAppProcessInfo processInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(processInfo);
            recordRealtimeNanosDuration(sGetMyMemoryStateSucceededTime, startNanos);
            return memoryPressureFromTrimLevel(processInfo.lastTrimLevel);
        } catch (Exception e) {
            recordRealtimeNanosDuration(sGetMyMemoryStateFailedTime, startNanos);
            return null;
        }
    }

    private static void recordRealtimeNanosDuration(CachedMetrics.Count1MHistogramSample histogram, long startNanos) {
        long durationUs = TimeUnit.NANOSECONDS.toMicros(elapsedRealtimeNanos() - startNanos);
        histogram.record((int) Math.min(durationUs, 2147483647L));
    }

    private static long elapsedRealtimeNanos() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.elapsedRealtime() * 1000000;
    }

    @VisibleForTesting
    public static Integer memoryPressureFromTrimLevel(int level) {
        if (level >= 80 || level == 15) {
            return 2;
        }
        if (level >= 40) {
            return 1;
        }
        return null;
    }
}
