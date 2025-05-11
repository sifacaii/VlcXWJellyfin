package org.chromium.content.browser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.metrics.RecordHistogram;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ServicificationStartupUma.class */
public class ServicificationStartupUma {
    private int[] mPendingCommits = new int[4];
    private boolean mIsNativeInitialized = false;
    private static final ServicificationStartupUma sInstance = new ServicificationStartupUma();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ServicificationStartupUma$ServicificationStartup.class */
    public @interface ServicificationStartup {
        public static final int CHROME_COLD = 0;
        public static final int CHROME_HALF_WARM = 1;
        public static final int SERVICE_MANAGER_COLD = 2;
        public static final int SERVICE_MANAGER_WARM = 3;
        public static final int NUM_ENTRIES = 4;
    }

    public static ServicificationStartupUma getInstance() {
        return sInstance;
    }

    public static int getStartupMode(boolean isFullBrowserStarted, boolean isServiceManagerStarted, boolean startServiceManagerOnly) {
        if (isFullBrowserStarted) {
            return -1;
        }
        if (isServiceManagerStarted) {
            if (startServiceManagerOnly) {
                return 3;
            }
            return 1;
        } else if (startServiceManagerOnly) {
            return 2;
        } else {
            return 0;
        }
    }

    public void record(int startupMode) {
        if (startupMode < 0) {
            return;
        }
        if (this.mIsNativeInitialized) {
            recordStartupMode(startupMode);
            return;
        }
        int[] iArr = this.mPendingCommits;
        iArr[startupMode] = iArr[startupMode] + 1;
    }

    public void commit() {
        this.mIsNativeInitialized = true;
        for (int i = 0; i < 4; i++) {
            if (this.mPendingCommits[i] > 0) {
                for (int count = 0; count < this.mPendingCommits[i]; count++) {
                    recordStartupMode(i);
                }
                this.mPendingCommits[i] = 0;
            }
        }
    }

    private ServicificationStartupUma() {
    }

    private void recordStartupMode(int startupMode) {
        RecordHistogram.recordEnumeratedHistogram("Servicification.Startup2", startupMode, 4);
    }
}
