package org.chromium.net;

import org.chromium.base.annotations.JNINamespace;

@JNINamespace("net")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/GURLUtils.class */
public final class GURLUtils {
    private static native String nativeGetOrigin(String str);

    private static native String nativeGetScheme(String str);

    public static String getOrigin(String url) {
        return nativeGetOrigin(url);
    }

    public static String getScheme(String url) {
        return nativeGetScheme(url);
    }
}
