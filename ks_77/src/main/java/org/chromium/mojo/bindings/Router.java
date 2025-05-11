package org.chromium.mojo.bindings;

import org.chromium.mojo.system.MessagePipeHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/Router.class */
public interface Router extends MessageReceiverWithResponder, HandleOwner<MessagePipeHandle> {
    void start();

    void setIncomingMessageReceiver(MessageReceiverWithResponder messageReceiverWithResponder);

    void setErrorHandler(ConnectionErrorHandler connectionErrorHandler);
}
