package org.chromium.base;

import dalvik.system.BaseDexClassLoader;
import org.chromium.base.annotations.CalledByNative;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/BundleUtils.class */
public class BundleUtils {
    private static final boolean sIsBundle;

    static {
        boolean isBundle;
        try {
            Class.forName("org.chromium.base.BundleCanary");
            isBundle = true;
        } catch (ClassNotFoundException e) {
            isBundle = false;
        }
        sIsBundle = isBundle;
    }

    @CalledByNative
    public static boolean isBundle() {
        return sIsBundle;
    }

    @CalledByNative
    private static String getNativeLibraryPath(String libraryName) {
        StrictModeContext ignored = StrictModeContext.allowDiskReads();
        Throwable th = null;
        try {
            String findLibrary = ((BaseDexClassLoader) ContextUtils.getApplicationContext().getClassLoader()).findLibrary(libraryName);
            if (ignored != null) {
                if (0 != 0) {
                    try {
                        ignored.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                } else {
                    ignored.close();
                }
            }
            return findLibrary;
        } finally {
        }
    }
}
