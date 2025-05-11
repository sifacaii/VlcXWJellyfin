package org.chromium.base.task;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/SerialExecutor.class */
class SerialExecutor implements Executor {
    final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();
    Runnable mActive;

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable r) {
        this.mTasks.offer(new Runnable() { // from class: org.chromium.base.task.SerialExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    r.run();
                } finally {
                    SerialExecutor.this.scheduleNext();
                }
            }
        });
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    protected synchronized void scheduleNext() {
        Runnable poll = this.mTasks.poll();
        this.mActive = poll;
        if (poll != null) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(this.mActive);
        }
    }
}
