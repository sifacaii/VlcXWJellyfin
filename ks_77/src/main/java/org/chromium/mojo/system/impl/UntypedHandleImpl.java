package org.chromium.mojo.system.impl;

import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.SharedBufferHandle;
import org.chromium.mojo.system.UntypedHandle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/impl/UntypedHandleImpl.class */
public class UntypedHandleImpl extends HandleBase implements UntypedHandle {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UntypedHandleImpl(CoreImpl core, int mojoHandle) {
        super(core, mojoHandle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UntypedHandleImpl(HandleBase handle) {
        super(handle);
    }

    @Override // org.chromium.mojo.system.Handle
    public UntypedHandle pass() {
        return new UntypedHandleImpl(this);
    }

    @Override // org.chromium.mojo.system.UntypedHandle
    public MessagePipeHandle toMessagePipeHandle() {
        return new MessagePipeHandleImpl(this);
    }

    @Override // org.chromium.mojo.system.UntypedHandle
    public DataPipe.ConsumerHandle toDataPipeConsumerHandle() {
        return new DataPipeConsumerHandleImpl(this);
    }

    @Override // org.chromium.mojo.system.UntypedHandle
    public DataPipe.ProducerHandle toDataPipeProducerHandle() {
        return new DataPipeProducerHandleImpl(this);
    }

    @Override // org.chromium.mojo.system.UntypedHandle
    public SharedBufferHandle toSharedBufferHandle() {
        return new SharedBufferHandleImpl(this);
    }
}
