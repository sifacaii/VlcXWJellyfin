package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import org.chromium.mojo.system.SharedBufferHandle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/impl/SharedBufferHandleImpl.class */
public class SharedBufferHandleImpl extends HandleBase implements SharedBufferHandle {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedBufferHandleImpl(CoreImpl core, int mojoHandle) {
        super(core, mojoHandle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedBufferHandleImpl(HandleBase handle) {
        super(handle);
    }

    @Override // org.chromium.mojo.system.Handle
    public SharedBufferHandle pass() {
        return new SharedBufferHandleImpl(this);
    }

    @Override // org.chromium.mojo.system.SharedBufferHandle
    public SharedBufferHandle duplicate(SharedBufferHandle.DuplicateOptions options) {
        return this.mCore.duplicate(this, options);
    }

    @Override // org.chromium.mojo.system.SharedBufferHandle
    public ByteBuffer map(long offset, long numBytes, SharedBufferHandle.MapFlags flags) {
        return this.mCore.map(this, offset, numBytes, flags);
    }

    @Override // org.chromium.mojo.system.SharedBufferHandle
    public void unmap(ByteBuffer buffer) {
        this.mCore.unmap(buffer);
    }
}
