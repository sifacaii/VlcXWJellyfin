package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.Pair;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.Watcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/ExecutorFactory.class */
public class ExecutorFactory {
    private static final ByteBuffer NOTIFY_BUFFER = null;
    private static final ThreadLocal<Executor> EXECUTORS = new ThreadLocal<>();

    ExecutorFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/ExecutorFactory$PipedExecutor.class */
    public static class PipedExecutor implements Executor, Watcher.Callback {
        private final MessagePipeHandle mWriteHandle;
        private final MessagePipeHandle mReadHandle;
        private final List<Runnable> mPendingActions;
        private final Object mLock;
        private final Watcher mWatcher;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ExecutorFactory.class.desiredAssertionStatus();
        }

        public PipedExecutor(Core core) {
            this.mWatcher = core.getWatcher();
            if (!$assertionsDisabled && this.mWatcher == null) {
                throw new AssertionError();
            }
            this.mLock = new Object();
            Pair<MessagePipeHandle, MessagePipeHandle> handles = core.createMessagePipe(new MessagePipeHandle.CreateOptions());
            this.mReadHandle = handles.first;
            this.mWriteHandle = handles.second;
            this.mPendingActions = new ArrayList();
            this.mWatcher.start(this.mReadHandle, Core.HandleSignals.READABLE, this);
        }

        @Override // org.chromium.mojo.system.Watcher.Callback
        public void onResult(int result) {
            if (result == 0 && readNotifyBufferMessage()) {
                runNextAction();
            } else {
                close();
            }
        }

        private void close() {
            synchronized (this.mLock) {
                this.mWriteHandle.close();
                this.mPendingActions.clear();
            }
            this.mWatcher.cancel();
            this.mWatcher.destroy();
            this.mReadHandle.close();
        }

        private boolean readNotifyBufferMessage() {
            try {
                ResultAnd<MessagePipeHandle.ReadMessageResult> readMessageResult = this.mReadHandle.readMessage(MessagePipeHandle.ReadFlags.NONE);
                if (readMessageResult.getMojoResult() == 0) {
                    return true;
                }
                return false;
            } catch (MojoException e) {
                return false;
            }
        }

        private void runNextAction() {
            Runnable toRun;
            synchronized (this.mLock) {
                toRun = this.mPendingActions.remove(0);
            }
            toRun.run();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            synchronized (this.mLock) {
                if (!this.mWriteHandle.isValid()) {
                    throw new IllegalStateException("Trying to execute an action on a closed executor.");
                }
                this.mPendingActions.add(command);
                this.mWriteHandle.writeMessage(ExecutorFactory.NOTIFY_BUFFER, null, MessagePipeHandle.WriteFlags.NONE);
            }
        }
    }

    public static Executor getExecutorForCurrentThread(Core core) {
        Executor executor = EXECUTORS.get();
        if (executor == null) {
            executor = new PipedExecutor(core);
            EXECUTORS.set(executor);
        }
        return executor;
    }
}
