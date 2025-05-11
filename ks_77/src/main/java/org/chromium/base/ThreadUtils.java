package org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.chromium.base.annotations.CalledByNative;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/ThreadUtils.class */
public class ThreadUtils {
    private static final Object sLock;
    private static boolean sWillOverride;
    private static Handler sUiThreadHandler;
    private static boolean sThreadAssertsDisabled;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ThreadUtils.class.desiredAssertionStatus();
        sLock = new Object();
    }

    public static void setWillOverrideUiThread(boolean willOverrideUiThread) {
        synchronized (sLock) {
            sWillOverride = willOverrideUiThread;
        }
    }

    public static void setUiThread(Looper looper) {
        synchronized (sLock) {
            if (looper == null) {
                sUiThreadHandler = null;
            } else if (sUiThreadHandler != null && sUiThreadHandler.getLooper() != looper) {
                throw new RuntimeException("UI thread looper is already set to " + sUiThreadHandler.getLooper() + " (Main thread looper is " + Looper.getMainLooper() + "), cannot set to new looper " + looper);
            } else {
                sUiThreadHandler = new Handler(looper);
            }
        }
    }

    public static Handler getUiThreadHandler() {
        Handler handler;
        synchronized (sLock) {
            if (sUiThreadHandler == null) {
                if (sWillOverride) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                sUiThreadHandler = new Handler(Looper.getMainLooper());
            }
            handler = sUiThreadHandler;
        }
        return handler;
    }

    @Deprecated
    public static void runOnUiThreadBlocking(Runnable r) {
        if (runningOnUiThread()) {
            r.run();
            return;
        }
        FutureTask<Void> task = new FutureTask<>(r, null);
        postOnUiThread((FutureTask) task);
        try {
            task.get();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred while waiting for runnable", e);
        }
    }

    @VisibleForTesting
    @Deprecated
    public static <T> T runOnUiThreadBlockingNoException(Callable<T> c) {
        try {
            return (T) runOnUiThreadBlocking(c);
        } catch (ExecutionException e) {
            throw new RuntimeException("Error occurred waiting for callable", e);
        }
    }

    @Deprecated
    public static <T> T runOnUiThreadBlocking(Callable<T> c) throws ExecutionException {
        FutureTask<T> task = new FutureTask<>(c);
        runOnUiThread((FutureTask) task);
        try {
            return task.get();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted waiting for callable", e);
        }
    }

    @Deprecated
    public static <T> FutureTask<T> runOnUiThread(FutureTask<T> task) {
        if (runningOnUiThread()) {
            task.run();
        } else {
            postOnUiThread((FutureTask) task);
        }
        return task;
    }

    @Deprecated
    public static <T> FutureTask<T> runOnUiThread(Callable<T> c) {
        return runOnUiThread(new FutureTask(c));
    }

    @Deprecated
    public static void runOnUiThread(Runnable r) {
        if (runningOnUiThread()) {
            r.run();
        } else {
            getUiThreadHandler().post(r);
        }
    }

    @Deprecated
    public static <T> FutureTask<T> postOnUiThread(FutureTask<T> task) {
        getUiThreadHandler().post(task);
        return task;
    }

    @Deprecated
    public static void postOnUiThread(Runnable task) {
        getUiThreadHandler().post(task);
    }

    @VisibleForTesting
    @Deprecated
    public static void postOnUiThreadDelayed(Runnable task, long delayMillis) {
        getUiThreadHandler().postDelayed(task, delayMillis);
    }

    public static void assertOnUiThread() {
        if (!sThreadAssertsDisabled && !$assertionsDisabled && !runningOnUiThread()) {
            throw new AssertionError("Must be called on the UI thread.");
        }
    }

    public static void checkUiThread() {
        if (!sThreadAssertsDisabled && !runningOnUiThread()) {
            throw new IllegalStateException("Must be called on the UI thread.");
        }
    }

    public static void assertOnBackgroundThread() {
        if (!sThreadAssertsDisabled && !$assertionsDisabled && runningOnUiThread()) {
            throw new AssertionError("Must be called on a thread other than UI.");
        }
    }

    public static void setThreadAssertsDisabledForTesting(boolean disabled) {
        sThreadAssertsDisabled = disabled;
    }

    public static boolean runningOnUiThread() {
        return getUiThreadHandler().getLooper() == Looper.myLooper();
    }

    public static Looper getUiThreadLooper() {
        return getUiThreadHandler().getLooper();
    }

    @CalledByNative
    public static void setThreadPriorityAudio(int tid) {
        Process.setThreadPriority(tid, -16);
    }

    @CalledByNative
    private static boolean isThreadPriorityAudio(int tid) {
        return Process.getThreadPriority(tid) == -16;
    }
}
