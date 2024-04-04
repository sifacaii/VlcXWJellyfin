package org.chromium.base.task;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/TaskExecutor.class */
public interface TaskExecutor {
    void postDelayedTask(TaskTraits taskTraits, Runnable runnable, long j);

    TaskRunner createTaskRunner(TaskTraits taskTraits);

    SequencedTaskRunner createSequencedTaskRunner(TaskTraits taskTraits);

    SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits taskTraits);

    boolean canRunTaskImmediately(TaskTraits taskTraits);
}
