package org.chromium.content_public.browser;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.ThreadUtils;
import org.chromium.base.task.PostTask;
import org.chromium.base.task.SequencedTaskRunner;
import org.chromium.base.task.SingleThreadTaskRunner;
import org.chromium.base.task.SingleThreadTaskRunnerImpl;
import org.chromium.base.task.TaskExecutor;
import org.chromium.base.task.TaskRunner;
import org.chromium.base.task.TaskTraits;
import org.chromium.content.browser.UiThreadTaskTraitsImpl;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content_public/browser/BrowserTaskExecutor.class */
public class BrowserTaskExecutor implements TaskExecutor {
    @GuardedBy("mTaskRunners")
    private final WeakHashMap<TaskTraits, WeakReference<SingleThreadTaskRunner>> mTaskRunners = new WeakHashMap<>();
    private static boolean sRegistered;
    private static boolean sShouldPrioritizeBootstrapTasks;

    @Override // org.chromium.base.task.TaskExecutor
    public TaskRunner createTaskRunner(TaskTraits taskTraits) {
        return createSingleThreadTaskRunner(taskTraits);
    }

    @Override // org.chromium.base.task.TaskExecutor
    public SequencedTaskRunner createSequencedTaskRunner(TaskTraits taskTraits) {
        return createSingleThreadTaskRunner(taskTraits);
    }

    @Override // org.chromium.base.task.TaskExecutor
    public SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits taskTraits) {
        SingleThreadTaskRunner taskRunner;
        synchronized (this.mTaskRunners) {
            WeakReference<SingleThreadTaskRunner> weakRef = this.mTaskRunners.get(taskTraits);
            if (weakRef == null || (taskRunner = weakRef.get()) == null) {
                SingleThreadTaskRunner taskRunner2 = new SingleThreadTaskRunnerImpl(ThreadUtils.getUiThreadHandler(), taskTraits, shouldPrioritizeTraits(taskTraits));
                taskRunner2.disableLifetimeCheck();
                this.mTaskRunners.put(taskTraits, new WeakReference<>(taskRunner2));
                return taskRunner2;
            }
            return taskRunner;
        }
    }

    @Override // org.chromium.base.task.TaskExecutor
    public void postDelayedTask(TaskTraits taskTraits, Runnable task, long delay) {
        createSingleThreadTaskRunner(taskTraits).postDelayedTask(task, delay);
    }

    @Override // org.chromium.base.task.TaskExecutor
    public boolean canRunTaskImmediately(TaskTraits traits) {
        return createSingleThreadTaskRunner(traits).belongsToCurrentThread();
    }

    public static void register() {
        if (sRegistered) {
            return;
        }
        sRegistered = true;
        PostTask.registerTaskExecutor(UiThreadTaskTraitsImpl.DESCRIPTOR.getId(), new BrowserTaskExecutor());
    }

    public static boolean getShouldPrioritizeBootstrapTasks() {
        return sShouldPrioritizeBootstrapTasks;
    }

    public static void setShouldPrioritizeBootstrapTasks(boolean shouldPrioritizeBootstrapTasks) {
        sShouldPrioritizeBootstrapTasks = shouldPrioritizeBootstrapTasks;
    }

    private static boolean shouldPrioritizeTraits(TaskTraits taskTraits) {
        UiThreadTaskTraitsImpl impl;
        if (sShouldPrioritizeBootstrapTasks && (impl = (UiThreadTaskTraitsImpl) taskTraits.getExtension(UiThreadTaskTraitsImpl.DESCRIPTOR)) != null) {
            switch (impl.getTaskType()) {
                case 1:
                case 2:
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }
}
