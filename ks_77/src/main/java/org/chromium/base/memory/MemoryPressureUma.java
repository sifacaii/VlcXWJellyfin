package org.chromium.base.memory;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.metrics.RecordHistogram;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/memory/MemoryPressureUma.class */
public class MemoryPressureUma implements ComponentCallbacks2 {
    private final String mHistogramName;
    private static MemoryPressureUma sInstance;
    static final /* synthetic */ boolean $assertionsDisabled;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/memory/MemoryPressureUma$Notification.class */
    private @interface Notification {
        public static final int UNKNOWN_TRIM_LEVEL = 0;
        public static final int TRIM_MEMORY_COMPLETE = 1;
        public static final int TRIM_MEMORY_MODERATE = 2;
        public static final int TRIM_MEMORY_BACKGROUND = 3;
        public static final int TRIM_MEMORY_UI_HIDDEN = 4;
        public static final int TRIM_MEMORY_RUNNING_CRITICAL = 5;
        public static final int TRIM_MEMORY_RUNNING_LOW = 6;
        public static final int TRIM_MEMORY_RUNNING_MODERATE = 7;
        public static final int ON_LOW_MEMORY = 8;
        public static final int NUM_ENTRIES = 9;
    }

    static {
        $assertionsDisabled = !MemoryPressureUma.class.desiredAssertionStatus();
    }

    public static void initializeForBrowser() {
        initializeInstance("Browser");
    }

    public static void initializeForChildService() {
        initializeInstance("ChildService");
    }

    private static void initializeInstance(String processType) {
        ThreadUtils.assertOnUiThread();
        if (!$assertionsDisabled && sInstance != null) {
            throw new AssertionError();
        }
        sInstance = new MemoryPressureUma(processType);
        ContextUtils.getApplicationContext().registerComponentCallbacks(sInstance);
    }

    private MemoryPressureUma(String processType) {
        this.mHistogramName = "Android.MemoryPressureNotification." + processType;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        record(8);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        switch (level) {
            case 5:
                record(7);
                return;
            case 10:
                record(6);
                return;
            case 15:
                record(5);
                return;
            case 20:
                record(4);
                return;
            case 40:
                record(3);
                return;
            case 60:
                record(2);
                return;
            case 80:
                record(1);
                return;
            default:
                record(0);
                return;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    private void record(int notification) {
        RecordHistogram.recordEnumeratedHistogram(this.mHistogramName, notification, 9);
    }
}
