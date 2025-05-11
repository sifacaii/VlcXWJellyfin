package org.chromium.mojo.system.impl;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.mojo.system.RunLoop;

/* JADX INFO: Access modifiers changed from: package-private */
@JNINamespace("mojo::android")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/impl/BaseRunLoop.class */
public class BaseRunLoop implements RunLoop {
    private long mRunLoopID = nativeCreateBaseRunLoop();
    private final CoreImpl mCore;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native long nativeCreateBaseRunLoop();

    private native void nativeRun();

    private native void nativeRunUntilIdle();

    private native void nativeQuit();

    private native void nativePostDelayedTask(long j, Runnable runnable, long j2);

    private native void nativeDeleteMessageLoop(long j);

    static {
        $assertionsDisabled = !BaseRunLoop.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseRunLoop(CoreImpl core) {
        this.mCore = core;
    }

    @Override // org.chromium.mojo.system.RunLoop
    public void run() {
        if (!$assertionsDisabled && this.mRunLoopID == 0) {
            throw new AssertionError("The run loop cannot run once closed");
        }
        nativeRun();
    }

    @Override // org.chromium.mojo.system.RunLoop
    public void runUntilIdle() {
        if (!$assertionsDisabled && this.mRunLoopID == 0) {
            throw new AssertionError("The run loop cannot run once closed");
        }
        nativeRunUntilIdle();
    }

    @Override // org.chromium.mojo.system.RunLoop
    public void quit() {
        if (!$assertionsDisabled && this.mRunLoopID == 0) {
            throw new AssertionError("The run loop cannot be quitted run once closed");
        }
        nativeQuit();
    }

    @Override // org.chromium.mojo.system.RunLoop
    public void postDelayedTask(Runnable runnable, long delay) {
        if (!$assertionsDisabled && this.mRunLoopID == 0) {
            throw new AssertionError("The run loop cannot run tasks once closed");
        }
        nativePostDelayedTask(this.mRunLoopID, runnable, delay);
    }

    @Override // org.chromium.mojo.system.RunLoop, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.mRunLoopID == 0) {
            return;
        }
        if (!$assertionsDisabled && this.mCore.getCurrentRunLoop() != this) {
            throw new AssertionError("Only the current run loop can be closed");
        }
        this.mCore.clearCurrentRunLoop();
        nativeDeleteMessageLoop(this.mRunLoopID);
        this.mRunLoopID = 0L;
    }

    @CalledByNative
    private static void runRunnable(Runnable runnable) {
        runnable.run();
    }
}
