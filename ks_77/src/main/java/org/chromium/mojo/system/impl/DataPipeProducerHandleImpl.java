package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.ResultAnd;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/impl/DataPipeProducerHandleImpl.class */
class DataPipeProducerHandleImpl extends HandleBase implements DataPipe.ProducerHandle {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DataPipeProducerHandleImpl(CoreImpl core, int mojoHandle) {
        super(core, mojoHandle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataPipeProducerHandleImpl(HandleBase handle) {
        super(handle);
    }

    @Override // org.chromium.mojo.system.Handle
    public DataPipe.ProducerHandle pass() {
        return new DataPipeProducerHandleImpl(this);
    }

    @Override // org.chromium.mojo.system.DataPipe.ProducerHandle
    public ResultAnd<Integer> writeData(ByteBuffer elements, DataPipe.WriteFlags flags) {
        return this.mCore.writeData(this, elements, flags);
    }

    @Override // org.chromium.mojo.system.DataPipe.ProducerHandle
    public ByteBuffer beginWriteData(int numBytes, DataPipe.WriteFlags flags) {
        return this.mCore.beginWriteData(this, numBytes, flags);
    }

    @Override // org.chromium.mojo.system.DataPipe.ProducerHandle
    public void endWriteData(int numBytesWritten) {
        this.mCore.endWriteData(this, numBytesWritten);
    }
}
