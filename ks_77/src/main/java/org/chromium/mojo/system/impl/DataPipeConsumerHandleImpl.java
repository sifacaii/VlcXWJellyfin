package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.ResultAnd;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/impl/DataPipeConsumerHandleImpl.class */
class DataPipeConsumerHandleImpl extends HandleBase implements DataPipe.ConsumerHandle {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DataPipeConsumerHandleImpl(CoreImpl core, int mojoHandle) {
        super(core, mojoHandle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataPipeConsumerHandleImpl(HandleBase other) {
        super(other);
    }

    @Override // org.chromium.mojo.system.Handle
    public DataPipe.ConsumerHandle pass() {
        return new DataPipeConsumerHandleImpl(this);
    }

    @Override // org.chromium.mojo.system.DataPipe.ConsumerHandle
    public int discardData(int numBytes, DataPipe.ReadFlags flags) {
        return this.mCore.discardData(this, numBytes, flags);
    }

    @Override // org.chromium.mojo.system.DataPipe.ConsumerHandle
    public ResultAnd<Integer> readData(ByteBuffer elements, DataPipe.ReadFlags flags) {
        return this.mCore.readData(this, elements, flags);
    }

    @Override // org.chromium.mojo.system.DataPipe.ConsumerHandle
    public ByteBuffer beginReadData(int numBytes, DataPipe.ReadFlags flags) {
        return this.mCore.beginReadData(this, numBytes, flags);
    }

    @Override // org.chromium.mojo.system.DataPipe.ConsumerHandle
    public void endReadData(int numBytesRead) {
        this.mCore.endReadData(this, numBytesRead);
    }
}
