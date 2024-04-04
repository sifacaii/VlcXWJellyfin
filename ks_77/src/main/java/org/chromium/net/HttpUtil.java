package org.chromium.net;

import org.chromium.base.annotations.JNINamespace;

@JNINamespace("net")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/net/HttpUtil.class */
public final class HttpUtil {
    private static native boolean nativeIsAllowedHeader(String str, String str2);

    public static boolean isAllowedHeader(String headerName, String headerValue) {
        return nativeIsAllowedHeader(headerName, headerValue);
    }
}
