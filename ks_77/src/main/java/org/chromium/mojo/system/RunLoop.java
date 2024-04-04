package org.chromium.mojo.system;

import java.io.Closeable;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/RunLoop.class */
public interface RunLoop extends Closeable {
    void run();

    void runUntilIdle();

    void quit();

    void postDelayedTask(Runnable runnable, long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
