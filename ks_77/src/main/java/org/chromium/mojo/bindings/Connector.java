package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;
import org.chromium.mojo.bindings.ExceptionHandler;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.Watcher;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/Connector.class */
public class Connector implements MessageReceiver, HandleOwner<MessagePipeHandle> {
    private final WatcherCallback mWatcherCallback;
    private final MessagePipeHandle mMessagePipeHandle;
    private final Watcher mWatcher;
    private MessageReceiver mIncomingMessageReceiver;
    private ConnectionErrorHandler mErrorHandler;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !Connector.class.desiredAssertionStatus();
    }

    public Connector(MessagePipeHandle messagePipeHandle) {
        this(messagePipeHandle, BindingsHelper.getWatcherForHandle(messagePipeHandle));
    }

    public Connector(MessagePipeHandle messagePipeHandle, Watcher watcher) {
        this.mWatcherCallback = new WatcherCallback();
        this.mMessagePipeHandle = messagePipeHandle;
        this.mWatcher = watcher;
    }

    public void setIncomingMessageReceiver(MessageReceiver incomingMessageReceiver) {
        this.mIncomingMessageReceiver = incomingMessageReceiver;
    }

    public void setErrorHandler(ConnectionErrorHandler errorHandler) {
        this.mErrorHandler = errorHandler;
    }

    public void start() {
        this.mWatcher.start(this.mMessagePipeHandle, Core.HandleSignals.READABLE, this.mWatcherCallback);
    }

    @Override // org.chromium.mojo.bindings.MessageReceiver
    public boolean accept(Message message) {
        try {
            this.mMessagePipeHandle.writeMessage(message.getData(), message.getHandles(), MessagePipeHandle.WriteFlags.NONE);
            return true;
        } catch (MojoException e) {
            onError(e);
            return false;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.chromium.mojo.bindings.HandleOwner
    public MessagePipeHandle passHandle() {
        cancelIfActive();
        MessagePipeHandle handle = this.mMessagePipeHandle.pass();
        if (this.mIncomingMessageReceiver != null) {
            this.mIncomingMessageReceiver.close();
        }
        return handle;
    }

    @Override // org.chromium.mojo.bindings.MessageReceiver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        cancelIfActive();
        this.mMessagePipeHandle.close();
        if (this.mIncomingMessageReceiver != null) {
            MessageReceiver incomingMessageReceiver = this.mIncomingMessageReceiver;
            this.mIncomingMessageReceiver = null;
            incomingMessageReceiver.close();
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/Connector$WatcherCallback.class */
    private class WatcherCallback implements Watcher.Callback {
        private WatcherCallback() {
        }

        @Override // org.chromium.mojo.system.Watcher.Callback
        public void onResult(int result) {
            Connector.this.onWatcherResult(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWatcherResult(int result) {
        if (result == 0) {
            readOutstandingMessages();
        } else {
            onError(new MojoException(result));
        }
    }

    private void onError(MojoException exception) {
        close();
        if (this.mErrorHandler != null) {
            try {
                this.mErrorHandler.onConnectionError(exception);
            } catch (RuntimeException e) {
                ExceptionHandler.DefaultExceptionHandler.getInstance().handleException(e);
            }
        }
    }

    private void readOutstandingMessages() {
        ResultAnd<Boolean> result;
        do {
            try {
                result = readAndDispatchMessage(this.mMessagePipeHandle, this.mIncomingMessageReceiver);
            } catch (MojoException e) {
                onError(e);
                return;
            }
        } while (result.getValue().booleanValue());
        if (result.getMojoResult() != 17) {
            onError(new MojoException(result.getMojoResult()));
        }
    }

    private void cancelIfActive() {
        this.mWatcher.cancel();
        this.mWatcher.destroy();
    }

    static ResultAnd<Boolean> readAndDispatchMessage(MessagePipeHandle handle, MessageReceiver receiver) {
        boolean accepted;
        ResultAnd<MessagePipeHandle.ReadMessageResult> result = handle.readMessage(MessagePipeHandle.ReadFlags.NONE);
        if (result.getMojoResult() != 0) {
            return new ResultAnd<>(result.getMojoResult(), false);
        }
        MessagePipeHandle.ReadMessageResult readResult = result.getValue();
        if ($assertionsDisabled || readResult != null) {
            if (receiver != null) {
                try {
                    accepted = receiver.accept(new Message(ByteBuffer.wrap(readResult.mData), readResult.mHandles));
                } catch (RuntimeException e) {
                    accepted = ExceptionHandler.DefaultExceptionHandler.getInstance().handleException(e);
                }
                return new ResultAnd<>(result.getMojoResult(), Boolean.valueOf(accepted));
            }
            return new ResultAnd<>(result.getMojoResult(), false);
        }
        throw new AssertionError();
    }
}
