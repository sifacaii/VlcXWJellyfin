package org.chromium.mojo.bindings;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.Watcher;

@SuppressLint({"UseSparseArrays"})
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/RouterImpl.class */
public class RouterImpl implements Router {
    private final Connector mConnector;
    private MessageReceiverWithResponder mIncomingMessageReceiver;
    private long mNextRequestId;
    private Map<Long, MessageReceiver> mResponders;
    private final Executor mExecutor;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !RouterImpl.class.desiredAssertionStatus();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/RouterImpl$HandleIncomingMessageThunk.class */
    private class HandleIncomingMessageThunk implements MessageReceiver {
        private HandleIncomingMessageThunk() {
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            return RouterImpl.this.handleIncomingMessage(message);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            RouterImpl.this.handleConnectorClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/RouterImpl$ResponderThunk.class */
    public class ResponderThunk implements MessageReceiver {
        private boolean mAcceptWasInvoked;

        ResponderThunk() {
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(Message message) {
            this.mAcceptWasInvoked = true;
            return RouterImpl.this.accept(message);
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            RouterImpl.this.close();
        }

        protected void finalize() throws Throwable {
            if (!this.mAcceptWasInvoked) {
                RouterImpl.this.closeOnHandleThread();
            }
            super.finalize();
        }
    }

    public RouterImpl(MessagePipeHandle messagePipeHandle) {
        this(messagePipeHandle, BindingsHelper.getWatcherForHandle(messagePipeHandle));
    }

    public RouterImpl(MessagePipeHandle messagePipeHandle, Watcher watcher) {
        this.mNextRequestId = 1L;
        this.mResponders = new HashMap();
        this.mConnector = new Connector(messagePipeHandle, watcher);
        this.mConnector.setIncomingMessageReceiver(new HandleIncomingMessageThunk());
        Core core = messagePipeHandle.getCore();
        if (core != null) {
            this.mExecutor = ExecutorFactory.getExecutorForCurrentThread(core);
        } else {
            this.mExecutor = null;
        }
    }

    @Override // org.chromium.mojo.bindings.Router
    public void start() {
        this.mConnector.start();
    }

    @Override // org.chromium.mojo.bindings.Router
    public void setIncomingMessageReceiver(MessageReceiverWithResponder incomingMessageReceiver) {
        this.mIncomingMessageReceiver = incomingMessageReceiver;
    }

    @Override // org.chromium.mojo.bindings.MessageReceiver
    public boolean accept(Message message) {
        return this.mConnector.accept(message);
    }

    @Override // org.chromium.mojo.bindings.MessageReceiverWithResponder
    public boolean acceptWithResponder(Message message, MessageReceiver responder) {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        if ($assertionsDisabled || messageWithHeader.getHeader().hasFlag(1)) {
            long j = this.mNextRequestId;
            this.mNextRequestId = j + 1;
            long requestId = j;
            if (requestId == 0) {
                long j2 = this.mNextRequestId;
                this.mNextRequestId = j2 + 1;
                requestId = j2;
            }
            if (this.mResponders.containsKey(Long.valueOf(requestId))) {
                throw new IllegalStateException("Unable to find a new request identifier.");
            }
            messageWithHeader.setRequestId(requestId);
            if (!this.mConnector.accept(messageWithHeader)) {
                return false;
            }
            this.mResponders.put(Long.valueOf(requestId), responder);
            return true;
        }
        throw new AssertionError();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.chromium.mojo.bindings.HandleOwner
    public MessagePipeHandle passHandle() {
        return this.mConnector.passHandle();
    }

    @Override // org.chromium.mojo.bindings.MessageReceiver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mConnector.close();
    }

    @Override // org.chromium.mojo.bindings.Router
    public void setErrorHandler(ConnectionErrorHandler errorHandler) {
        this.mConnector.setErrorHandler(errorHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleIncomingMessage(Message message) {
        MessageHeader header = message.asServiceMessage().getHeader();
        if (header.hasFlag(1)) {
            if (this.mIncomingMessageReceiver != null) {
                return this.mIncomingMessageReceiver.acceptWithResponder(message, new ResponderThunk());
            }
            close();
            return false;
        } else if (header.hasFlag(2)) {
            long requestId = header.getRequestId();
            MessageReceiver responder = this.mResponders.get(Long.valueOf(requestId));
            if (responder == null) {
                return false;
            }
            this.mResponders.remove(Long.valueOf(requestId));
            return responder.accept(message);
        } else if (this.mIncomingMessageReceiver != null) {
            return this.mIncomingMessageReceiver.accept(message);
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleConnectorClose() {
        if (this.mIncomingMessageReceiver != null) {
            this.mIncomingMessageReceiver.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeOnHandleThread() {
        if (this.mExecutor != null) {
            this.mExecutor.execute(new Runnable() { // from class: org.chromium.mojo.bindings.RouterImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    RouterImpl.this.close();
                }
            });
        }
    }
}
