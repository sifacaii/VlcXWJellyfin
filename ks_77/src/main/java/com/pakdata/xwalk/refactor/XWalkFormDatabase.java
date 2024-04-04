package com.pakdata.xwalk.refactor;

import org.chromium.base.annotations.JNINamespace;

@JNINamespace("xwalk")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/XWalkFormDatabase.class */
public class XWalkFormDatabase {
    private static native boolean nativeHasFormData();

    private static native void nativeClearFormData();

    public static boolean hasFormData() {
        return nativeHasFormData();
    }

    public static void clearFormData() {
        nativeClearFormData();
    }
}
