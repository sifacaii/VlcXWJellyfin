package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.MainDex;

@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/JNIUtils.class */
public class JNIUtils {
    private static Boolean sSelectiveJniRegistrationEnabled;
    private static ClassLoader sJniClassLoader;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !JNIUtils.class.desiredAssertionStatus();
    }

    @CalledByNative
    public static Object getClassLoader() {
        if (sJniClassLoader == null) {
            return JNIUtils.class.getClassLoader();
        }
        return sJniClassLoader;
    }

    public static void setClassLoader(ClassLoader classLoader) {
        sJniClassLoader = classLoader;
    }

    @CalledByNative
    public static boolean isSelectiveJniRegistrationEnabled() {
        if (sSelectiveJniRegistrationEnabled == null) {
            sSelectiveJniRegistrationEnabled = false;
        }
        return sSelectiveJniRegistrationEnabled.booleanValue();
    }

    public static void enableSelectiveJniRegistration() {
        if (!$assertionsDisabled && sSelectiveJniRegistrationEnabled != null) {
            throw new AssertionError();
        }
        sSelectiveJniRegistrationEnabled = true;
    }
}
