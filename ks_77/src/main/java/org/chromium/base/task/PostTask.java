package org.chromium.base.task;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("base")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/PostTask.class */
public class PostTask {
    private static final Object sLock;
    private static Set<TaskRunner> sPreNativeTaskRunners;
    private static final Executor sPrenativeThreadPoolExecutor;
    private static Executor sPrenativeThreadPoolExecutorOverride;
    private static final TaskExecutor[] sTaskExecutors;
    static final /* synthetic */ boolean $assertionsDisabled;

    private static native void nativePostDelayedTask(boolean z, int i, boolean z2, boolean z3, byte b, byte[] bArr, Runnable runnable, long j);

    static {
        $assertionsDisabled = !PostTask.class.desiredAssertionStatus();
        sLock = new Object();
        sPreNativeTaskRunners = Collections.newSetFromMap(new WeakHashMap());
        sPrenativeThreadPoolExecutor = new ChromeThreadPoolExecutor();
        sTaskExecutors = getInitialTaskExecutors();
    }

    private static TaskExecutor[] getInitialTaskExecutors() {
        TaskExecutor[] taskExecutors = new TaskExecutor[5];
        taskExecutors[0] = new DefaultTaskExecutor();
        return taskExecutors;
    }

    public static TaskRunner createTaskRunner(TaskTraits taskTraits) {
        TaskRunner createTaskRunner;
        synchronized (sLock) {
            createTaskRunner = getTaskExecutorForTraits(taskTraits).createTaskRunner(taskTraits);
        }
        return createTaskRunner;
    }

    public static SequencedTaskRunner createSequencedTaskRunner(TaskTraits taskTraits) {
        SequencedTaskRunner createSequencedTaskRunner;
        synchronized (sLock) {
            createSequencedTaskRunner = getTaskExecutorForTraits(taskTraits).createSequencedTaskRunner(taskTraits);
        }
        return createSequencedTaskRunner;
    }

    public static SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits taskTraits) {
        SingleThreadTaskRunner createSingleThreadTaskRunner;
        synchronized (sLock) {
            createSingleThreadTaskRunner = getTaskExecutorForTraits(taskTraits).createSingleThreadTaskRunner(taskTraits);
        }
        return createSingleThreadTaskRunner;
    }

    public static void postTask(TaskTraits taskTraits, Runnable task) {
        postDelayedTask(taskTraits, task, 0L);
    }

    public static void postDelayedTask(TaskTraits taskTraits, Runnable task, long delay) {
        synchronized (sLock) {
            if (sPreNativeTaskRunners != null || taskTraits.mIsChoreographerFrame) {
                getTaskExecutorForTraits(taskTraits).postDelayedTask(taskTraits, task, delay);
            } else {
                nativePostDelayedTask(taskTraits.mPrioritySetExplicitly, taskTraits.mPriority, taskTraits.mMayBlock, taskTraits.mUseThreadPool, taskTraits.mExtensionId, taskTraits.mExtensionData, task, delay);
            }
        }
    }

    public static void runOrPostTask(TaskTraits taskTraits, Runnable task) {
        if (getTaskExecutorForTraits(taskTraits).canRunTaskImmediately(taskTraits)) {
            task.run();
        } else {
            postTask(taskTraits, task);
        }
    }

    @Deprecated
    public static <T> T runSynchronously(TaskTraits taskTraits, Callable<T> c) {
        return (T) runSynchronouslyInternal(taskTraits, new FutureTask(c));
    }

    @Deprecated
    public static void runSynchronously(TaskTraits taskTraits, Runnable r) {
        runSynchronouslyInternal(taskTraits, new FutureTask(r, null));
    }

    private static <T> T runSynchronouslyInternal(TaskTraits taskTraits, FutureTask<T> task) {
        runOrPostTask(taskTraits, task);
        try {
            return task.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void registerTaskExecutor(int extensionId, TaskExecutor taskExecutor) {
        synchronized (sLock) {
            if (!$assertionsDisabled && extensionId == 0) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && extensionId > 4) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && sTaskExecutors[extensionId] != null) {
                throw new AssertionError();
            }
            sTaskExecutors[extensionId] = taskExecutor;
        }
    }

    public static void setPrenativeThreadPoolExecutorForTesting(Executor executor) {
        synchronized (sLock) {
            sPrenativeThreadPoolExecutorOverride = executor;
        }
    }

    public static void resetPrenativeThreadPoolExecutorForTesting() {
        synchronized (sLock) {
            sPrenativeThreadPoolExecutorOverride = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor getPrenativeThreadPoolExecutor() {
        synchronized (sLock) {
            if (sPrenativeThreadPoolExecutorOverride != null) {
                return sPrenativeThreadPoolExecutorOverride;
            }
            return sPrenativeThreadPoolExecutor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean registerPreNativeTaskRunnerLocked(TaskRunner taskRunner) {
        if (sPreNativeTaskRunners != null) {
            sPreNativeTaskRunners.add(taskRunner);
            return true;
        }
        return false;
    }

    private static TaskExecutor getTaskExecutorForTraits(TaskTraits traits) {
        return sTaskExecutors[traits.mExtensionId];
    }

    @CalledByNative
    private static void onNativeSchedulerReady() {
        synchronized (sLock) {
            Set<TaskRunner> preNativeTaskRunners = sPreNativeTaskRunners;
            sPreNativeTaskRunners = null;
            for (TaskRunner taskRunner : preNativeTaskRunners) {
                taskRunner.initNativeTaskRunner();
            }
        }
    }

    @CalledByNative
    private static void onNativeSchedulerShutdown() {
        synchronized (sLock) {
            sPreNativeTaskRunners = Collections.newSetFromMap(new WeakHashMap());
        }
    }
}
