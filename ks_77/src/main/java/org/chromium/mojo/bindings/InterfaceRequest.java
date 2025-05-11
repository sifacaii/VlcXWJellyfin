package org.chromium.mojo.bindings;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.MessagePipeHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/bindings/InterfaceRequest.class */
public class InterfaceRequest<P extends Interface> implements HandleOwner<MessagePipeHandle> {
    private final MessagePipeHandle mHandle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterfaceRequest(MessagePipeHandle handle) {
        this.mHandle = handle;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.chromium.mojo.bindings.HandleOwner
    public MessagePipeHandle passHandle() {
        return this.mHandle.pass();
    }

    @Override // org.chromium.mojo.bindings.HandleOwner, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mHandle.close();
    }

    public static InterfaceRequest asInterfaceRequestUnsafe(MessagePipeHandle handle) {
        return new InterfaceRequest(handle);
    }
}
