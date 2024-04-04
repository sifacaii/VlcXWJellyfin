package org.chromium.base;

import android.os.StrictMode;
import java.io.Closeable;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/StrictModeContext.class */
public final class StrictModeContext implements Closeable {
    private final StrictMode.ThreadPolicy mThreadPolicy;
    private final StrictMode.VmPolicy mVmPolicy;

    private StrictModeContext(StrictMode.ThreadPolicy threadPolicy, StrictMode.VmPolicy vmPolicy) {
        this.mThreadPolicy = threadPolicy;
        this.mVmPolicy = vmPolicy;
    }

    private StrictModeContext(StrictMode.ThreadPolicy threadPolicy) {
        this(threadPolicy, null);
    }

    private StrictModeContext(StrictMode.VmPolicy vmPolicy) {
        this(null, vmPolicy);
    }

    public static StrictModeContext allowAllVmPolicies() {
        StrictMode.VmPolicy oldPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        return new StrictModeContext(oldPolicy);
    }

    public static StrictModeContext allowDiskWrites() {
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskWrites();
        return new StrictModeContext(oldPolicy);
    }

    public static StrictModeContext allowDiskReads() {
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
        return new StrictModeContext(oldPolicy);
    }

    public static StrictModeContext allowSlowCalls() {
        StrictMode.ThreadPolicy oldPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(oldPolicy).permitCustomSlowCalls().build());
        return new StrictModeContext(oldPolicy);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.mThreadPolicy != null) {
            StrictMode.setThreadPolicy(this.mThreadPolicy);
        }
        if (this.mVmPolicy != null) {
            StrictMode.setVmPolicy(this.mVmPolicy);
        }
    }
}
