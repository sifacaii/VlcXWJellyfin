package org.chromium.content_public.common;

import org.chromium.base.annotations.JNINamespace;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/common/UseZoomForDSFPolicy.class */
public final class UseZoomForDSFPolicy {
    private static native boolean nativeIsUseZoomForDSFEnabled();

    public static boolean isUseZoomForDSFEnabled() {
        return nativeIsUseZoomForDSFEnabled();
    }

    private UseZoomForDSFPolicy() {
    }
}
