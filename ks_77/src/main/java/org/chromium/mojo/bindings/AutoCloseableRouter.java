package org.chromium.mojo.bindings;

import java.util.concurrent.Executor;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/AutoCloseableRouter.class */
public class AutoCloseableRouter implements Router {
    private final Router mRouter;
    private final Executor mExecutor;
    private final Exception mAllocationException = new Exception("AutocloseableRouter allocated at:");
    private boolean mClosed;

    public AutoCloseableRouter(Core core, Router router) {
        this.mRouter = router;
        this.mExecutor = ExecutorFactory.getExecutorForCurrentThread(core);
    }

    @Override // org.chromium.mojo.bindings.Router
    public void setIncomingMessageReceiver(MessageReceiverWithResponder incomingMessageReceiver) {
        this.mRouter.setIncomingMessageReceiver(incomingMessageReceiver);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.chromium.mojo.bindings.HandleOwner
    public MessagePipeHandle passHandle() {
        return this.mRouter.passHandle();
    }

    @Override // org.chromium.mojo.bindings.MessageReceiver
    public boolean accept(Message message) {
        return this.mRouter.accept(message);
    }

    @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
    public boolean acceptWithResponder(Message message, MessageReceiver responder) {
        return this.mRouter.acceptWithResponder(message, responder);
    }

    @Override // org.chromium.mojo.bindings.Router
    public void start() {
        this.mRouter.start();
    }

    @Override // org.chromium.mojo.bindings.Router
    public void setErrorHandler(ConnectionErrorHandler errorHandler) {
        this.mRouter.setErrorHandler(errorHandler);
    }

    @Override // org.chromium.mojo.bindings.MessageReceiver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mRouter.close();
        this.mClosed = true;
    }

    protected void finalize() throws Throwable {
        if (!this.mClosed) {
            this.mExecutor.execute(new Runnable() { // from class: org.chromium.mojo.bindings.AutoCloseableRouter.1
                @Override // java.lang.Runnable
                public void run() {
                    AutoCloseableRouter.this.close();
                }
            });
            throw new IllegalStateException("Warning: Router objects should be explicitly closed when no longer required otherwise you may leak handles.", this.mAllocationException);
        } else {
            super.finalize();
        }
    }
}
