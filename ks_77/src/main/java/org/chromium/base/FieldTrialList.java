package org.chromium.base;

import org.chromium.base.annotations.MainDex;

@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/FieldTrialList.class */
public class FieldTrialList {
    private static native String nativeFindFullName(String str);

    private static native boolean nativeTrialExists(String str);

    private static native String nativeGetVariationParameter(String str, String str2);

    private static native void nativeLogActiveTrials();

    private FieldTrialList() {
    }

    public static String findFullName(String trialName) {
        return nativeFindFullName(trialName);
    }

    public static boolean trialExists(String trialName) {
        return nativeTrialExists(trialName);
    }

    public static String getVariationParameter(String trialName, String parameterKey) {
        return nativeGetVariationParameter(trialName, parameterKey);
    }

    public static void logActiveTrials() {
        nativeLogActiveTrials();
    }
}
