package org.chromium.base.task;

import android.os.Process;
import androidx.annotation.Nullable;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.LifetimeAssert;
import org.chromium.base.TraceEvent;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("base")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/TaskRunnerImpl.class */
public class TaskRunnerImpl implements TaskRunner {
    private final TaskTraits mTaskTraits;
    private final String mTraceEvent;
    private final int mTaskRunnerType;
    protected final Object mLock;
    @GuardedBy("mLock")
    protected long mNativeTaskRunnerAndroid;
    protected final Runnable mRunPreNativeTaskClosure;
    @GuardedBy("mLock")
    private boolean mIsDestroying;
    private final LifetimeAssert mLifetimeAssert;
    @Nullable
    protected LinkedList<Runnable> mPreNativeTasks;
    @Nullable
    protected List<Pair<Runnable, Long>> mPreNativeDelayedTasks;
    static final /* synthetic */ boolean $assertionsDisabled;

    private native long nativeInit(int i, boolean z, int i2, boolean z2, boolean z3, byte b, byte[] bArr);

    private native void nativeDestroy(long j);

    private native void nativePostDelayedTask(long j, Runnable runnable, long j2);

    /* JADX INFO: Access modifiers changed from: protected */
    public native boolean nativeBelongsToCurrentThread(long j);

    static {
        $assertionsDisabled = !TaskRunnerImpl.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TaskRunnerImpl(TaskTraits traits) {
        this(traits, "TaskRunnerImpl", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TaskRunnerImpl(TaskTraits traits, String traceCategory, int taskRunnerType) {
        this.mLock = new Object();
        this.mRunPreNativeTaskClosure = this::runPreNativeTask;
        this.mLifetimeAssert = LifetimeAssert.create(this);
        this.mPreNativeTasks = new LinkedList<>();
        this.mPreNativeDelayedTasks = new ArrayList();
        this.mTaskTraits = traits;
        this.mTraceEvent = traceCategory + ".PreNativeTask.run";
        this.mTaskRunnerType = taskRunnerType;
        if (!PostTask.registerPreNativeTaskRunnerLocked(this)) {
            initNativeTaskRunner();
        }
    }

    @Override // org.chromium.base.task.TaskRunner
    public void destroy() {
        synchronized (this.mLock) {
            LifetimeAssert.setSafeToGc(this.mLifetimeAssert, true);
            this.mIsDestroying = true;
            destroyInternal();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @GuardedBy("mLock")
    public void destroyInternal() {
        if (this.mNativeTaskRunnerAndroid != 0) {
            nativeDestroy(this.mNativeTaskRunnerAndroid);
        }
        this.mNativeTaskRunnerAndroid = 0L;
    }

    @Override // org.chromium.base.task.TaskRunner
    public void disableLifetimeCheck() {
        LifetimeAssert.setSafeToGc(this.mLifetimeAssert, true);
    }

    @Override // org.chromium.base.task.TaskRunner
    public void postTask(Runnable task) {
        postDelayedTask(task, 0L);
    }

    @Override // org.chromium.base.task.TaskRunner
    public void postDelayedTask(Runnable task, long delay) {
        synchronized (this.mLock) {
            if (!$assertionsDisabled && this.mIsDestroying) {
                throw new AssertionError();
            }
            if (this.mPreNativeTasks == null) {
                postDelayedTaskToNative(task, delay);
                return;
            }
            if (delay == 0) {
                this.mPreNativeTasks.add(task);
                schedulePreNativeTask();
            } else {
                Pair<Runnable, Long> preNativeDelayedTask = new Pair<>(task, Long.valueOf(delay));
                this.mPreNativeDelayedTasks.add(preNativeDelayedTask);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void schedulePreNativeTask() {
        PostTask.getPrenativeThreadPoolExecutor().execute(this.mRunPreNativeTaskClosure);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runPreNativeTask() {
        TraceEvent te = TraceEvent.scoped(this.mTraceEvent);
        Throwable th = null;
        try {
            synchronized (this.mLock) {
                if (this.mPreNativeTasks != null) {
                    Runnable task = this.mPreNativeTasks.poll();
                    switch (this.mTaskTraits.mPriority) {
                        case 1:
                            Process.setThreadPriority(0);
                            break;
                        case 2:
                            Process.setThreadPriority(-1);
                            break;
                        default:
                            Process.setThreadPriority(10);
                            break;
                    }
                    task.run();
                    if (te != null) {
                        if (0 != 0) {
                            try {
                                te.close();
                                return;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                                return;
                            }
                        }
                        te.close();
                    }
                } else if (te != null) {
                    if (0 != 0) {
                        try {
                            te.close();
                            return;
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                            return;
                        }
                    }
                    te.close();
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (te != null) {
                    if (th4 != null) {
                        try {
                            te.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                    } else {
                        te.close();
                    }
                }
                throw th5;
            }
        }
    }

    @Override // org.chromium.base.task.TaskRunner
    public void initNativeTaskRunner() {
        synchronized (this.mLock) {
            initNativeTaskRunnerInternal();
            migratePreNativeTasksToNative();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @GuardedBy("mLock")
    public void initNativeTaskRunnerInternal() {
        if (this.mNativeTaskRunnerAndroid == 0) {
            this.mNativeTaskRunnerAndroid = nativeInit(this.mTaskRunnerType, this.mTaskTraits.mPrioritySetExplicitly, this.mTaskTraits.mPriority, this.mTaskTraits.mMayBlock, this.mTaskTraits.mUseThreadPool, this.mTaskTraits.mExtensionId, this.mTaskTraits.mExtensionData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @GuardedBy("mLock")
    public void migratePreNativeTasksToNative() {
        if (this.mPreNativeTasks != null) {
            Iterator<Runnable> it = this.mPreNativeTasks.iterator();
            while (it.hasNext()) {
                postDelayedTaskToNative(it.next(), 0L);
            }
            for (Pair<Runnable, Long> task : this.mPreNativeDelayedTasks) {
                postDelayedTaskToNative((Runnable) task.first, ((Long) task.second).longValue());
            }
            this.mPreNativeTasks = null;
            this.mPreNativeDelayedTasks = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @GuardedBy("mLock")
    public void postDelayedTaskToNative(Runnable r, long delay) {
        nativePostDelayedTask(this.mNativeTaskRunnerAndroid, r, delay);
    }
}
