package org.chromium.content.browser;

import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;

@JNINamespace("content::android")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/ContentFeatureList.class */
public abstract class ContentFeatureList {
    public static final String BACKGROUND_MEDIA_RENDERER_HAS_MODERATE_BINDING = "BackgroundMediaRendererHasModerateBinding";
    public static final String SERVICE_GROUP_IMPORTANCE = "ServiceGroupImportance";

    private static native boolean nativeIsEnabled(String str);

    private ContentFeatureList() {
    }

    public static boolean isEnabled(String featureName) {
        return nativeIsEnabled(featureName);
    }
}
