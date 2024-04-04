package org.chromium.mojo.bindings;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/MessageReceiverWithResponder.class */
public interface MessageReceiverWithResponder extends MessageReceiver {
    boolean acceptWithResponder(Message message, MessageReceiver messageReceiver);
}
