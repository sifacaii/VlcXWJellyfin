package org.chromium.base;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.Thread;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;

@JNINamespace("base::android")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/JavaHandlerThread.class */
public class JavaHandlerThread {
    private final HandlerThread mThread;
    private Throwable mUnhandledException;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInitializeThread(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnLooperStopped(long j);

    static {
        $assertionsDisabled = !JavaHandlerThread.class.desiredAssertionStatus();
    }

    public JavaHandlerThread(String name, int priority) {
        this.mThread = new HandlerThread(name, priority);
    }

    @CalledByNative
    private static JavaHandlerThread create(String name, int priority) {
        return new JavaHandlerThread(name, priority);
    }

    public Looper getLooper() {
        if ($assertionsDisabled || hasStarted()) {
            return this.mThread.getLooper();
        }
        throw new AssertionError();
    }

    public void maybeStart() {
        if (hasStarted()) {
            return;
        }
        this.mThread.start();
    }

    @CalledByNative
    private void startAndInitialize(final long nativeThread, final long nativeEvent) {
        maybeStart();
        new Handler(this.mThread.getLooper()).post(new Runnable() { // from class: org.chromium.base.JavaHandlerThread.1
            @Override // java.lang.Runnable
            public void run() {
                JavaHandlerThread.this.nativeInitializeThread(nativeThread, nativeEvent);
            }
        });
    }

    @CalledByNative
    private void quitThreadSafely(final long nativeThread) {
        new Handler(this.mThread.getLooper()).post(new Runnable() { // from class: org.chromium.base.JavaHandlerThread.2
            @Override // java.lang.Runnable
            public void run() {
                JavaHandlerThread.this.mThread.quit();
                JavaHandlerThread.this.nativeOnLooperStopped(nativeThread);
            }
        });
        if (Build.VERSION.SDK_INT >= 18) {
            this.mThread.getLooper().quitSafely();
        }
    }

    @CalledByNative
    private void joinThread() {
        boolean joined = false;
        while (!joined) {
            try {
                this.mThread.join();
                joined = true;
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean hasStarted() {
        return this.mThread.getState() != Thread.State.NEW;
    }

    @CalledByNative
    private boolean isAlive() {
        return this.mThread.isAlive();
    }

    @CalledByNative
    private void listenForUncaughtExceptionsForTesting() {
        this.mThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: org.chromium.base.JavaHandlerThread.3
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread t, Throwable e) {
                JavaHandlerThread.this.mUnhandledException = e;
            }
        });
    }

    @CalledByNative
    private Throwable getUncaughtExceptionIfAny() {
        return this.mUnhandledException;
    }
}
