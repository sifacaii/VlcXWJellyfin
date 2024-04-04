package org.chromium.base.task;

import android.view.Choreographer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/ChoreographerTaskRunner.class */
public final class ChoreographerTaskRunner implements SingleThreadTaskRunner {
    private final Choreographer mChoreographer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChoreographerTaskRunner(Choreographer choreographer) {
        this.mChoreographer = choreographer;
    }

    @Override // org.chromium.base.task.SingleThreadTaskRunner
    public boolean belongsToCurrentThread() {
        try {
            return this.mChoreographer == Choreographer.getInstance();
        } catch (IllegalStateException e) {
            return false;
        }
    }

    @Override // org.chromium.base.task.TaskRunner
    public void postTask(final Runnable task) {
        this.mChoreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: org.chromium.base.task.ChoreographerTaskRunner.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long frameTimeNanos) {
                task.run();
            }
        });
    }

    @Override // org.chromium.base.task.TaskRunner
    public void destroy() {
    }

    @Override // org.chromium.base.task.TaskRunner
    public void disableLifetimeCheck() {
    }

    @Override // org.chromium.base.task.TaskRunner
    public void postDelayedTask(final Runnable task, long delayMillis) {
        this.mChoreographer.postFrameCallbackDelayed(new Choreographer.FrameCallback() { // from class: org.chromium.base.task.ChoreographerTaskRunner.2
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long frameTimeNanos) {
                task.run();
            }
        }, delayMillis);
    }

    @Override // org.chromium.base.task.TaskRunner
    public void initNativeTaskRunner() {
    }
}
