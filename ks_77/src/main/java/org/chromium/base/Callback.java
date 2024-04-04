package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/Callback.class */
public interface Callback<T> {
    void onResult(T t);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/Callback$Helper.class */
    public static abstract class Helper {
        @CalledByNative("Helper")
        static void onObjectResultFromNative(Callback callback, Object result) {
            callback.onResult(result);
        }

        @CalledByNative("Helper")
        static void onBooleanResultFromNative(Callback callback, boolean result) {
            callback.onResult(Boolean.valueOf(result));
        }

        @CalledByNative("Helper")
        static void onIntResultFromNative(Callback callback, int result) {
            callback.onResult(Integer.valueOf(result));
        }

        @CalledByNative("Helper")
        static void runRunnable(Runnable runnable) {
            runnable.run();
        }
    }
}
