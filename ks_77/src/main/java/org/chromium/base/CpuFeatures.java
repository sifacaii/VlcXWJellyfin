package org.chromium.base;

import org.chromium.base.annotations.JNINamespace;

@JNINamespace("base::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/CpuFeatures.class */
public abstract class CpuFeatures {
    private static native int nativeGetCoreCount();

    private static native long nativeGetCpuFeatures();

    public static int getCount() {
        return nativeGetCoreCount();
    }

    public static long getMask() {
        return nativeGetCpuFeatures();
    }
}
