package org.chromium.base.task;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("base")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/task/SingleThreadTaskRunnerImpl.class */
public class SingleThreadTaskRunnerImpl extends TaskRunnerImpl implements SingleThreadTaskRunner {
    @Nullable
    private final Handler mHandler;
    private final boolean mPostTaskAtFrontOfQueue;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !SingleThreadTaskRunnerImpl.class.desiredAssertionStatus();
    }

    public SingleThreadTaskRunnerImpl(Handler handler, TaskTraits traits, boolean postTaskAtFrontOfQueue) {
        super(traits, "SingleThreadTaskRunnerImpl", 2);
        this.mHandler = handler;
        this.mPostTaskAtFrontOfQueue = postTaskAtFrontOfQueue;
    }

    public SingleThreadTaskRunnerImpl(Handler handler, TaskTraits traits) {
        this(handler, traits, false);
    }

    @Override // org.chromium.base.task.SingleThreadTaskRunner
    public boolean belongsToCurrentThread() {
        synchronized (this.mLock) {
            if (this.mNativeTaskRunnerAndroid != 0) {
                return nativeBelongsToCurrentThread(this.mNativeTaskRunnerAndroid);
            } else if (this.mHandler != null) {
                return this.mHandler.getLooper().getThread() == Thread.currentThread();
            } else if ($assertionsDisabled) {
                return false;
            } else {
                throw new AssertionError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.base.task.TaskRunnerImpl
    public void schedulePreNativeTask() {
        if (this.mHandler == null) {
            return;
        }
        if (this.mPostTaskAtFrontOfQueue) {
            postAtFrontOfQueue();
        } else {
            this.mHandler.post(this.mRunPreNativeTaskClosure);
        }
    }

    @SuppressLint({"NewApi"})
    private void postAtFrontOfQueue() {
        if (Build.VERSION.SDK_INT >= 21) {
            Message message = Message.obtain(this.mHandler, this.mRunPreNativeTaskClosure);
            message.setAsynchronous(true);
            this.mHandler.sendMessageAtFrontOfQueue(message);
            return;
        }
        this.mHandler.postAtFrontOfQueue(this.mRunPreNativeTaskClosure);
    }
}
