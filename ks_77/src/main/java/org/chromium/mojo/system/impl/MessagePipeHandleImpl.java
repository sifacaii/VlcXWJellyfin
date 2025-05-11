package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import java.util.List;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.ResultAnd;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/impl/MessagePipeHandleImpl.class */
class MessagePipeHandleImpl extends HandleBase implements MessagePipeHandle {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MessagePipeHandleImpl(CoreImpl core, int mojoHandle) {
        super(core, mojoHandle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessagePipeHandleImpl(HandleBase handle) {
        super(handle);
    }

    @Override // org.chromium.mojo.system.Handle
    public MessagePipeHandle pass() {
        return new MessagePipeHandleImpl(this);
    }

    @Override // org.chromium.mojo.system.MessagePipeHandle
    public void writeMessage(ByteBuffer bytes, List<? extends Handle> handles, MessagePipeHandle.WriteFlags flags) {
        this.mCore.writeMessage(this, bytes, handles, flags);
    }

    @Override // org.chromium.mojo.system.MessagePipeHandle
    public ResultAnd<MessagePipeHandle.ReadMessageResult> readMessage(MessagePipeHandle.ReadFlags flags) {
        return this.mCore.readMessage(this, flags);
    }
}
