package org.chromium.base;

import android.app.Activity;
import java.util.Iterator;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.memory.MemoryPressureCallback;

@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/MemoryPressureListener.class */
public class MemoryPressureListener {
    private static final String ACTION_LOW_MEMORY = "org.chromium.base.ACTION_LOW_MEMORY";
    private static final String ACTION_TRIM_MEMORY = "org.chromium.base.ACTION_TRIM_MEMORY";
    private static final String ACTION_TRIM_MEMORY_RUNNING_CRITICAL = "org.chromium.base.ACTION_TRIM_MEMORY_RUNNING_CRITICAL";
    private static final String ACTION_TRIM_MEMORY_MODERATE = "org.chromium.base.ACTION_TRIM_MEMORY_MODERATE";
    private static final ObserverList<MemoryPressureCallback> sCallbacks = new ObserverList<>();

    private static native void nativeOnMemoryPressure(int i);

    @CalledByNative
    private static void addNativeCallback() {
        addCallback(MemoryPressureListener::nativeOnMemoryPressure);
    }

    public static void addCallback(MemoryPressureCallback callback) {
        sCallbacks.addObserver(callback);
    }

    public static void removeCallback(MemoryPressureCallback callback) {
        sCallbacks.removeObserver(callback);
    }

    public static void notifyMemoryPressure(int pressure) {
        Iterator<MemoryPressureCallback> it = sCallbacks.iterator();
        while (it.hasNext()) {
            MemoryPressureCallback callback = it.next();
            callback.onPressure(pressure);
        }
    }

    public static boolean handleDebugIntent(Activity activity, String action) {
        if (ACTION_LOW_MEMORY.equals(action)) {
            simulateLowMemoryPressureSignal(activity);
            return true;
        } else if (ACTION_TRIM_MEMORY.equals(action)) {
            simulateTrimMemoryPressureSignal(activity, 80);
            return true;
        } else if (ACTION_TRIM_MEMORY_RUNNING_CRITICAL.equals(action)) {
            simulateTrimMemoryPressureSignal(activity, 15);
            return true;
        } else if (ACTION_TRIM_MEMORY_MODERATE.equals(action)) {
            simulateTrimMemoryPressureSignal(activity, 60);
            return true;
        } else {
            return false;
        }
    }

    private static void simulateLowMemoryPressureSignal(Activity activity) {
        activity.getApplication().onLowMemory();
        activity.onLowMemory();
    }

    private static void simulateTrimMemoryPressureSignal(Activity activity, int level) {
        activity.getApplication().onTrimMemory(level);
        activity.onTrimMemory(level);
    }
}
