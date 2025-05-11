package org.chromium.base.task;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/TaskRunner.class */
public interface TaskRunner {
    void postTask(Runnable runnable);

    void destroy();

    void disableLifetimeCheck();

    void postDelayedTask(Runnable runnable, long j);

    void initNativeTaskRunner();
}
