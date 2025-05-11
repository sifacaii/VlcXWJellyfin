package org.chromium.content.browser;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.blink.mojom.CloneableMessage;
import org.chromium.blink.mojom.SerializedArrayBufferContents;
import org.chromium.blink.mojom.SerializedBlob;
import org.chromium.blink.mojom.TransferableMessage;
import org.chromium.content_public.browser.MessagePort;
import org.chromium.mojo.bindings.Connector;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.Pair;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.mojo_base.BigBufferUtil;
import org.chromium.skia.mojom.Bitmap;

@JNINamespace("content")
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/AppWebMessagePort.class */
public class AppWebMessagePort implements MessagePort {
    private static final String TAG = "AppWebMessagePort";
    private static final MessageHeader MESSAGE_HEADER = new MessageHeader(0);
    private boolean mClosed;
    private boolean mTransferred;
    private boolean mStarted;
    private boolean mWatching;
    private Core mMojoCore;
    private Connector mConnector;

    /* JADX INFO: Access modifiers changed from: private */
    public static native String nativeDecodeStringMessage(byte[] bArr);

    private static native byte[] nativeEncodeStringMessage(String str);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/AppWebMessagePort$MessageHandler.class */
    private static class MessageHandler extends Handler implements MessageReceiver {
        private static final int MESSAGE_RECEIVED = 1;
        private final MessagePort.MessageCallback mMessageCallback;

        /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/content/browser/AppWebMessagePort$MessageHandler$MessagePortMessage.class */
        private static class MessagePortMessage {
            public byte[] encodedMessage;
            public AppWebMessagePort[] ports;

            private MessagePortMessage() {
            }
        }

        public MessageHandler(Looper looper, MessagePort.MessageCallback callback) {
            super(looper);
            this.mMessageCallback = callback;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                MessagePortMessage message = (MessagePortMessage) msg.obj;
                String decodedMessage = AppWebMessagePort.nativeDecodeStringMessage(message.encodedMessage);
                if (decodedMessage == null) {
                    Log.w(AppWebMessagePort.TAG, "Undecodable message received, dropping message", new Object[0]);
                    return;
                } else {
                    this.mMessageCallback.onMessage(decodedMessage, message.ports);
                    return;
                }
            }
            throw new IllegalStateException("undefined message");
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver
        public boolean accept(org.chromium.mojo.bindings.Message mojoMessage) {
            try {
                TransferableMessage msg = TransferableMessage.deserialize(mojoMessage.asServiceMessage().getPayload());
                AppWebMessagePort[] ports = new AppWebMessagePort[msg.ports.length];
                for (int i = 0; i < ports.length; i++) {
                    ports[i] = new AppWebMessagePort(msg.ports[i]);
                }
                MessagePortMessage portMsg = new MessagePortMessage();
                portMsg.encodedMessage = BigBufferUtil.getBytesFromBigBuffer(msg.message.encodedMessage);
                portMsg.ports = ports;
                sendMessage(obtainMessage(1, portMsg));
                return true;
            } catch (DeserializationException e) {
                Log.w(AppWebMessagePort.TAG, "Error deserializing message", e);
                return false;
            }
        }

        @Override // org.chromium.mojo.bindings.MessageReceiver, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    private AppWebMessagePort(MessagePipeHandle messagePipeHandle) {
        this.mMojoCore = messagePipeHandle.getCore();
        this.mConnector = new Connector(messagePipeHandle);
    }

    public static AppWebMessagePort[] createPair() {
        Pair<MessagePipeHandle, MessagePipeHandle> handles = CoreImpl.getInstance().createMessagePipe(new MessagePipeHandle.CreateOptions());
        AppWebMessagePort[] ports = {new AppWebMessagePort(handles.first), new AppWebMessagePort(handles.second)};
        return ports;
    }

    public static AppWebMessagePort create(MessagePipeHandle handle) {
        return new AppWebMessagePort(handle);
    }

    private MessagePipeHandle passHandle() {
        this.mTransferred = true;
        MessagePipeHandle handle = this.mConnector.passHandle();
        this.mConnector = null;
        return handle;
    }

    @CalledByNative
    private int releaseNativeHandle() {
        return passHandle().releaseNativeHandle();
    }

    @Override // org.chromium.content_public.browser.MessagePort
    public void close() {
        if (this.mTransferred) {
            throw new IllegalStateException("Port is already transferred");
        }
        if (this.mClosed) {
            return;
        }
        this.mClosed = true;
        this.mConnector.close();
        this.mConnector = null;
    }

    @Override // org.chromium.content_public.browser.MessagePort
    public boolean isClosed() {
        return this.mClosed;
    }

    @Override // org.chromium.content_public.browser.MessagePort
    public boolean isTransferred() {
        return this.mTransferred;
    }

    @Override // org.chromium.content_public.browser.MessagePort
    public boolean isStarted() {
        return this.mStarted;
    }

    @Override // org.chromium.content_public.browser.MessagePort
    public void setMessageCallback(MessagePort.MessageCallback messageCallback, Handler handler) {
        if (isClosed() || isTransferred()) {
            throw new IllegalStateException("Port is already closed or transferred");
        }
        this.mStarted = true;
        if (messageCallback == null) {
            this.mConnector.setIncomingMessageReceiver(null);
        } else {
            this.mConnector.setIncomingMessageReceiver(new MessageHandler(handler == null ? Looper.getMainLooper() : handler.getLooper(), messageCallback));
        }
        if (!this.mWatching) {
            this.mConnector.start();
            this.mWatching = true;
        }
    }

    @Override // org.chromium.content_public.browser.MessagePort
    public void postMessage(String message, MessagePort[] sentPorts) throws IllegalStateException {
        if (isClosed() || isTransferred()) {
            throw new IllegalStateException("Port is already closed or transferred");
        }
        MessagePipeHandle[] ports = new MessagePipeHandle[sentPorts == null ? 0 : sentPorts.length];
        if (sentPorts != null) {
            for (MessagePort port : sentPorts) {
                if (port.equals(this)) {
                    throw new IllegalStateException("Source port cannot be transferred");
                }
                if (port.isClosed() || port.isTransferred()) {
                    throw new IllegalStateException("Port is already closed or transferred");
                }
                if (port.isStarted()) {
                    throw new IllegalStateException("Port is already started");
                }
            }
            for (int i = 0; i < sentPorts.length; i++) {
                ports[i] = ((AppWebMessagePort) sentPorts[i]).passHandle();
            }
        }
        this.mStarted = true;
        TransferableMessage msg = new TransferableMessage();
        msg.message = new CloneableMessage();
        msg.message.encodedMessage = BigBufferUtil.createBigBufferFromBytes(nativeEncodeStringMessage(message));
        msg.message.blobs = new SerializedBlob[0];
        msg.arrayBufferContentsArray = new SerializedArrayBufferContents[0];
        msg.imageBitmapContentsArray = new Bitmap[0];
        msg.ports = ports;
        msg.streamChannels = new MessagePipeHandle[0];
        this.mConnector.accept(msg.serializeWithHeader(this.mMojoCore, MESSAGE_HEADER));
    }
}
