package org.chromium.content.browser;

import android.os.Handler;
import android.os.Looper;
import org.chromium.base.JavaHandlerThread;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("content::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/LauncherThread.class */
public final class LauncherThread {
    private static final JavaHandlerThread sThread = new JavaHandlerThread("Chrome_ProcessLauncherThread", 0);
    private static final Handler sThreadHandler;
    private static Handler sHandler;

    static {
        sThread.maybeStart();
        sThreadHandler = new Handler(sThread.getLooper());
        sHandler = sThreadHandler;
    }

    public static void post(Runnable r) {
        sHandler.post(r);
    }

    public static void postDelayed(Runnable r, long delayMillis) {
        sHandler.postDelayed(r, delayMillis);
    }

    public static void removeCallbacks(Runnable r) {
        sHandler.removeCallbacks(r);
    }

    public static boolean runningOnLauncherThread() {
        return sHandler.getLooper() == Looper.myLooper();
    }

    public static Handler getHandler() {
        return sHandler;
    }

    @VisibleForTesting
    public static void setCurrentThreadAsLauncherThread() {
        sHandler = new Handler();
    }

    @VisibleForTesting
    public static void setLauncherThreadAsLauncherThread() {
        sHandler = sThreadHandler;
    }

    @CalledByNative
    private static JavaHandlerThread getHandlerThread() {
        return sThread;
    }

    private LauncherThread() {
    }
}
