package org.chromium.base.task;

import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/SequencedTaskRunnerImpl.class */
public class SequencedTaskRunnerImpl extends TaskRunnerImpl implements SequencedTaskRunner {
    private AtomicInteger mPendingTasks;
    @GuardedBy("mLock")
    private int mNumUnfinishedNativeTasks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SequencedTaskRunnerImpl(TaskTraits traits) {
        super(traits, "SequencedTaskRunnerImpl", 1);
        this.mPendingTasks = new AtomicInteger();
        disableLifetimeCheck();
    }

    @Override // org.chromium.base.task.TaskRunnerImpl, org.chromium.base.task.TaskRunner
    public void initNativeTaskRunner() {
        synchronized (this.mLock) {
            migratePreNativeTasksToNative();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.base.task.TaskRunnerImpl
    public void schedulePreNativeTask() {
        if (this.mPendingTasks.getAndIncrement() == 0) {
            super.schedulePreNativeTask();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.base.task.TaskRunnerImpl
    public void runPreNativeTask() {
        super.runPreNativeTask();
        if (this.mPendingTasks.decrementAndGet() > 0) {
            super.schedulePreNativeTask();
        }
    }

    @Override // org.chromium.base.task.TaskRunnerImpl
    public void postDelayedTaskToNative(Runnable runnable, long delay) {
        synchronized (this.mLock) {
            int i = this.mNumUnfinishedNativeTasks;
            this.mNumUnfinishedNativeTasks = i + 1;
            if (i == 0) {
                initNativeTaskRunnerInternal();
            }
            Runnable r = () -> {
                runnable.run();
                synchronized (this.mLock) {
                    int i2 = this.mNumUnfinishedNativeTasks - 1;
                    this.mNumUnfinishedNativeTasks = i2;
                    if (i2 == 0) {
                        destroyInternal();
                    }
                }
            };
            super.postDelayedTaskToNative(r, delay);
        }
    }
}
