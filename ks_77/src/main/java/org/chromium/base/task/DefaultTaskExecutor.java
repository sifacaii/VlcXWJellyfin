package org.chromium.base.task;

import android.view.Choreographer;
import java.util.HashMap;
import java.util.Map;
import org.chromium.base.ThreadUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/DefaultTaskExecutor.class */
public class DefaultTaskExecutor implements TaskExecutor {
    private final Map<TaskTraits, TaskRunner> mTraitsToRunnerMap = new HashMap();

    @Override // org.chromium.base.task.TaskExecutor
    public TaskRunner createTaskRunner(TaskTraits taskTraits) {
        return taskTraits.mIsChoreographerFrame ? createChoreographerTaskRunner() : new TaskRunnerImpl(taskTraits);
    }

    @Override // org.chromium.base.task.TaskExecutor
    public SequencedTaskRunner createSequencedTaskRunner(TaskTraits taskTraits) {
        return taskTraits.mIsChoreographerFrame ? createChoreographerTaskRunner() : new SequencedTaskRunnerImpl(taskTraits);
    }

    @Override // org.chromium.base.task.TaskExecutor
    public SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits taskTraits) {
        return taskTraits.mIsChoreographerFrame ? createChoreographerTaskRunner() : new SingleThreadTaskRunnerImpl(null, taskTraits);
    }

    @Override // org.chromium.base.task.TaskExecutor
    public synchronized void postDelayedTask(TaskTraits taskTraits, Runnable task, long delay) {
        if (taskTraits.hasExtension()) {
            TaskRunner runner = createTaskRunner(taskTraits);
            runner.postDelayedTask(task, delay);
            runner.destroy();
            return;
        }
        TaskRunner runner2 = this.mTraitsToRunnerMap.get(taskTraits);
        if (runner2 == null) {
            runner2 = createTaskRunner(taskTraits);
            runner2.disableLifetimeCheck();
            this.mTraitsToRunnerMap.put(taskTraits, runner2);
        }
        runner2.postDelayedTask(task, delay);
    }

    @Override // org.chromium.base.task.TaskExecutor
    public boolean canRunTaskImmediately(TaskTraits traits) {
        return false;
    }

    private synchronized ChoreographerTaskRunner createChoreographerTaskRunner() {
        return (ChoreographerTaskRunner) ThreadUtils.runOnUiThreadBlockingNoException(() -> {
            return new ChoreographerTaskRunner(Choreographer.getInstance());
        });
    }
}
