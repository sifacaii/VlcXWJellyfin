package org.chromium.mojo.system;

import java.nio.ByteBuffer;
import java.util.List;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.SharedBufferHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/InvalidHandle.class */
public class InvalidHandle implements UntypedHandle, MessagePipeHandle, DataPipe.ConsumerHandle, DataPipe.ProducerHandle, SharedBufferHandle {
    public static final InvalidHandle INSTANCE = new InvalidHandle();

    private InvalidHandle() {
    }

    @Override // org.chromium.mojo.system.Handle, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // org.chromium.mojo.system.Handle
    public Core.HandleSignalsState querySignalsState() {
        throw new MojoException(3);
    }

    @Override // org.chromium.mojo.system.Handle
    public boolean isValid() {
        return false;
    }

    @Override // org.chromium.mojo.system.Handle
    public Core getCore() {
        return null;
    }

    @Override // org.chromium.mojo.system.UntypedHandle, org.chromium.mojo.system.Handle
    public InvalidHandle pass() {
        return this;
    }

    @Override // org.chromium.mojo.system.Handle
    public UntypedHandle toUntypedHandle() {
        return this;
    }

    @Override // org.chromium.mojo.system.Handle
    public int releaseNativeHandle() {
        return 0;
    }

    @Override // org.chromium.mojo.system.UntypedHandle
    public MessagePipeHandle toMessagePipeHandle() {
        return this;
    }

    @Override // org.chromium.mojo.system.UntypedHandle
    public DataPipe.ConsumerHandle toDataPipeConsumerHandle() {
        return this;
    }

    @Override // org.chromium.mojo.system.UntypedHandle
    public DataPipe.ProducerHandle toDataPipeProducerHandle() {
        return this;
    }

    @Override // org.chromium.mojo.system.UntypedHandle
    public SharedBufferHandle toSharedBufferHandle() {
        return this;
    }

    @Override // org.chromium.mojo.system.SharedBufferHandle
    public SharedBufferHandle duplicate(SharedBufferHandle.DuplicateOptions options) {
        throw new MojoException(3);
    }

    @Override // org.chromium.mojo.system.SharedBufferHandle
    public ByteBuffer map(long offset, long numBytes, SharedBufferHandle.MapFlags flags) {
        throw new MojoException(3);
    }

    @Override // org.chromium.mojo.system.SharedBufferHandle
    public void unmap(ByteBuffer buffer) {
        throw new MojoException(3);
    }

    @Override // org.chromium.mojo.system.DataPipe.ProducerHandle
    public ResultAnd<Integer> writeData(ByteBuffer elements, DataPipe.WriteFlags flags) {
        throw new MojoException(3);
    }

    @Override // org.chromium.mojo.system.DataPipe.ProducerHandle
    public ByteBuffer beginWriteData(int numBytes, DataPipe.WriteFlags flags) {
        throw new MojoException(3);
    }

    @Override // org.chromium.mojo.system.DataPipe.ProducerHandle
    public void endWriteData(int numBytesWritten) {
        throw new MojoException(3);
    }

    @Override // org.chromium.mojo.system.DataPipe.ConsumerHandle
    public int discardData(int numBytes, DataPipe.ReadFlags flags) {
        throw new MojoException(3);
    }

    @Override // org.chromium.mojo.system.DataPipe.ConsumerHandle
    public ResultAnd<Integer> readData(ByteBuffer elements, DataPipe.ReadFlags flags) {
        throw new MojoException(3);
    }

    @Override // org.chromium.mojo.system.DataPipe.ConsumerHandle
    public ByteBuffer beginReadData(int numBytes, DataPipe.ReadFlags flags) {
        throw new MojoException(3);
    }

    @Override // org.chromium.mojo.system.DataPipe.ConsumerHandle
    public void endReadData(int numBytesRead) {
        throw new MojoException(3);
    }

    @Override // org.chromium.mojo.system.MessagePipeHandle
    public void writeMessage(ByteBuffer bytes, List<? extends Handle> handles, MessagePipeHandle.WriteFlags flags) {
        throw new MojoException(3);
    }

    @Override // org.chromium.mojo.system.MessagePipeHandle
    public ResultAnd<MessagePipeHandle.ReadMessageResult> readMessage(MessagePipeHandle.ReadFlags flags) {
        throw new MojoException(3);
    }
}
