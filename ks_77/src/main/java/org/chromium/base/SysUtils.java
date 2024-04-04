package org.chromium.base;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.metrics.CachedMetrics;

@JNINamespace("base::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/SysUtils.class */
public class SysUtils {
    private static final int ANDROID_LOW_MEMORY_DEVICE_THRESHOLD_MB = 512;
    private static final int ANDROID_O_LOW_MEMORY_DEVICE_THRESHOLD_MB = 1024;
    private static final int BYTES_PER_GIGABYTE = 1073741824;
    private static final long HIGH_END_DEVICE_DISK_CAPACITY_GB = 24;
    private static final String TAG = "SysUtils";
    private static Boolean sLowEndDevice;
    private static Integer sAmountOfPhysicalMemoryKB;
    private static Boolean sHighEndDiskDevice;
    private static CachedMetrics.BooleanHistogramSample sLowEndMatches;
    static final /* synthetic */ boolean $assertionsDisabled;

    private static native void nativeLogPageFaultCountToTracing();

    static {
        $assertionsDisabled = !SysUtils.class.desiredAssertionStatus();
        sLowEndMatches = new CachedMetrics.BooleanHistogramSample("Android.SysUtilsLowEndMatches");
    }

    private SysUtils() {
    }

    /* JADX WARN: Finally extract failed */
    private static int detectAmountOfPhysicalMemoryKB() {
        Pattern pattern = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
        try {
            try {
                FileReader fileReader = new FileReader("/proc/meminfo");
                try {
                    BufferedReader reader = new BufferedReader(fileReader);
                    while (true) {
                        try {
                            String line = reader.readLine();
                            if (line == null) {
                                android.util.Log.w(TAG, "/proc/meminfo lacks a MemTotal entry?");
                                break;
                            }
                            Matcher m = pattern.matcher(line);
                            if (m.find()) {
                                int totalMemoryKB = Integer.parseInt(m.group(1));
                                if (totalMemoryKB > 1024) {
                                    fileReader.close();
                                    StrictMode.setThreadPolicy(oldPolicy);
                                    return totalMemoryKB;
                                }
                                android.util.Log.w(TAG, "Invalid /proc/meminfo total size in kB: " + m.group(1));
                            }
                        } finally {
                            reader.close();
                        }
                    }
                    reader.close();
                    fileReader.close();
                    StrictMode.setThreadPolicy(oldPolicy);
                    return 0;
                } catch (Throwable th) {
                    fileReader.close();
                    throw th;
                }
            } catch (Exception e) {
                android.util.Log.w(TAG, "Cannot get total physical size from /proc/meminfo", e);
                StrictMode.setThreadPolicy(oldPolicy);
                return 0;
            }
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(oldPolicy);
            throw th2;
        }
    }

    @CalledByNative
    public static boolean isLowEndDevice() {
        if (sLowEndDevice == null) {
            sLowEndDevice = Boolean.valueOf(detectLowEndDevice());
        }
        return sLowEndDevice.booleanValue();
    }

    public static int amountOfPhysicalMemoryKB() {
        if (sAmountOfPhysicalMemoryKB == null) {
            sAmountOfPhysicalMemoryKB = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
        }
        return sAmountOfPhysicalMemoryKB.intValue();
    }

    @CalledByNative
    public static boolean isCurrentlyLowMemory() {
        ActivityManager am = (ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(info);
        return info.lowMemory;
    }

    @VisibleForTesting
    public static void resetForTesting() {
        sLowEndDevice = null;
        sAmountOfPhysicalMemoryKB = null;
    }

    public static boolean hasCamera(Context context) {
        PackageManager pm = context.getPackageManager();
        boolean hasCamera = pm.hasSystemFeature("android.hardware.camera");
        if (Build.VERSION.SDK_INT >= 17) {
            hasCamera |= pm.hasSystemFeature("android.hardware.camera.any");
        }
        return hasCamera;
    }

    @TargetApi(19)
    private static boolean detectLowEndDevice() {
        boolean isLowEnd;
        if ($assertionsDisabled || CommandLine.isInitialized()) {
            if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_LOW_END_DEVICE_MODE)) {
                return true;
            }
            if (CommandLine.getInstance().hasSwitch(BaseSwitches.DISABLE_LOW_END_DEVICE_MODE)) {
                return false;
            }
            sAmountOfPhysicalMemoryKB = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
            if (sAmountOfPhysicalMemoryKB.intValue() <= 0) {
                isLowEnd = false;
            } else if (Build.VERSION.SDK_INT >= 26) {
                isLowEnd = sAmountOfPhysicalMemoryKB.intValue() / 1024 <= 1024;
            } else {
                isLowEnd = sAmountOfPhysicalMemoryKB.intValue() / 1024 <= 512;
            }
            Context appContext = ContextUtils.getApplicationContext();
            boolean isLowRam = false;
            if (appContext != null && Build.VERSION.SDK_INT >= 19) {
                isLowRam = ((ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity")).isLowRamDevice();
            }
            sLowEndMatches.record(isLowEnd == isLowRam);
            return isLowEnd;
        }
        throw new AssertionError();
    }

    public static void logPageFaultCountToTracing() {
        nativeLogPageFaultCountToTracing();
    }

    public static boolean isHighEndDiskDevice() {
        if (sHighEndDiskDevice == null) {
            sHighEndDiskDevice = Boolean.valueOf(detectHighEndDiskDevice());
        }
        return sHighEndDiskDevice.booleanValue();
    }

    private static boolean detectHighEndDiskDevice() {
        try {
            StrictModeContext ignored = StrictModeContext.allowDiskReads();
            StatFs dataStats = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            long totalGBytes = dataStats.getTotalBytes() / 1073741824;
            boolean z = totalGBytes >= HIGH_END_DEVICE_DISK_CAPACITY_GB;
            if (ignored != null) {
                if (0 != 0) {
                    ignored.close();
                } else {
                    ignored.close();
                }
            }
            return z;
        } catch (IllegalArgumentException e) {
            android.util.Log.v(TAG, "Cannot get disk data capacity", e);
            return false;
        }
    }
}
