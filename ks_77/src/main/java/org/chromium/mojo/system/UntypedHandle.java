package org.chromium.mojo.system;

import org.chromium.mojo.system.DataPipe;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/UntypedHandle.class */
public interface UntypedHandle extends Handle {
    @Override // org.chromium.mojo.system.Handle
    UntypedHandle pass();

    MessagePipeHandle toMessagePipeHandle();

    DataPipe.ConsumerHandle toDataPipeConsumerHandle();

    DataPipe.ProducerHandle toDataPipeProducerHandle();

    SharedBufferHandle toSharedBufferHandle();
}
