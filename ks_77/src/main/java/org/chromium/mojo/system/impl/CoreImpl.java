package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.Pair;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.RunLoop;
import org.chromium.mojo.system.SharedBufferHandle;
import org.chromium.mojo.system.UntypedHandle;
import org.chromium.mojo.system.Watcher;

@JNINamespace("mojo::android")
@MainDex
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/impl/CoreImpl.class */
public class CoreImpl implements Core {
    private static final int MOJO_READ_DATA_FLAG_DISCARD = 2;
    private static final int HANDLE_SIZE = 4;
    private static final int FLAG_SIZE = 4;
    static final int INVALID_HANDLE = 0;
    private final ThreadLocal<BaseRunLoop> mCurrentRunLoop;
    private final int mByteBufferOffset;

    private native long nativeGetTimeTicksNow();

    private native ResultAnd<IntegerPair> nativeCreateMessagePipe(ByteBuffer byteBuffer);

    private native ResultAnd<IntegerPair> nativeCreateDataPipe(ByteBuffer byteBuffer);

    private native ResultAnd<Integer> nativeCreateSharedBuffer(ByteBuffer byteBuffer, long j);

    private native int nativeClose(int i);

    private native int nativeQueryHandleSignalsState(int i, ByteBuffer byteBuffer);

    private native int nativeWriteMessage(int i, ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3);

    private native ResultAnd<MessagePipeHandle.ReadMessageResult> nativeReadMessage(int i, int i2);

    private native ResultAnd<Integer> nativeReadData(int i, ByteBuffer byteBuffer, int i2, int i3);

    private native ResultAnd<ByteBuffer> nativeBeginReadData(int i, int i2, int i3);

    private native int nativeEndReadData(int i, int i2);

    private native ResultAnd<Integer> nativeWriteData(int i, ByteBuffer byteBuffer, int i2, int i3);

    private native ResultAnd<ByteBuffer> nativeBeginWriteData(int i, int i2, int i3);

    private native int nativeEndWriteData(int i, int i2);

    private native ResultAnd<Integer> nativeDuplicate(int i, ByteBuffer byteBuffer);

    private native ResultAnd<ByteBuffer> nativeMap(int i, long j, long j2, int i2);

    private native int nativeUnmap(ByteBuffer byteBuffer);

    private native int nativeGetNativeBufferOffset(ByteBuffer byteBuffer, int i);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/impl/CoreImpl$LazyHolder.class */
    private static class LazyHolder {
        private static final Core INSTANCE = new CoreImpl();

        private LazyHolder() {
        }
    }

    public static Core getInstance() {
        return LazyHolder.INSTANCE;
    }

    private CoreImpl() {
        this.mCurrentRunLoop = new ThreadLocal<>();
        this.mByteBufferOffset = nativeGetNativeBufferOffset(ByteBuffer.allocateDirect(8), 8);
    }

    @Override // org.chromium.mojo.system.Core
    public long getTimeTicksNow() {
        return nativeGetTimeTicksNow();
    }

    @Override // org.chromium.mojo.system.Core
    public Pair<MessagePipeHandle, MessagePipeHandle> createMessagePipe(MessagePipeHandle.CreateOptions options) {
        ByteBuffer optionsBuffer = null;
        if (options != null) {
            optionsBuffer = allocateDirectBuffer(8);
            optionsBuffer.putInt(0, 8);
            optionsBuffer.putInt(4, options.getFlags().getFlags());
        }
        ResultAnd<IntegerPair> result = nativeCreateMessagePipe(optionsBuffer);
        if (result.getMojoResult() != 0) {
            throw new MojoException(result.getMojoResult());
        }
        return Pair.create(new MessagePipeHandleImpl(this, ((Integer) result.getValue().first).intValue()), new MessagePipeHandleImpl(this, ((Integer) result.getValue().second).intValue()));
    }

    @Override // org.chromium.mojo.system.Core
    public Pair<DataPipe.ProducerHandle, DataPipe.ConsumerHandle> createDataPipe(DataPipe.CreateOptions options) {
        ByteBuffer optionsBuffer = null;
        if (options != null) {
            optionsBuffer = allocateDirectBuffer(16);
            optionsBuffer.putInt(0, 16);
            optionsBuffer.putInt(4, options.getFlags().getFlags());
            optionsBuffer.putInt(8, options.getElementNumBytes());
            optionsBuffer.putInt(12, options.getCapacityNumBytes());
        }
        ResultAnd<IntegerPair> result = nativeCreateDataPipe(optionsBuffer);
        if (result.getMojoResult() != 0) {
            throw new MojoException(result.getMojoResult());
        }
        return Pair.create(new DataPipeProducerHandleImpl(this, ((Integer) result.getValue().first).intValue()), new DataPipeConsumerHandleImpl(this, ((Integer) result.getValue().second).intValue()));
    }

    @Override // org.chromium.mojo.system.Core
    public SharedBufferHandle createSharedBuffer(SharedBufferHandle.CreateOptions options, long numBytes) {
        ByteBuffer optionsBuffer = null;
        if (options != null) {
            optionsBuffer = allocateDirectBuffer(8);
            optionsBuffer.putInt(0, 8);
            optionsBuffer.putInt(4, options.getFlags().getFlags());
        }
        ResultAnd<Integer> result = nativeCreateSharedBuffer(optionsBuffer, numBytes);
        if (result.getMojoResult() != 0) {
            throw new MojoException(result.getMojoResult());
        }
        return new SharedBufferHandleImpl(this, result.getValue().intValue());
    }

    @Override // org.chromium.mojo.system.Core
    public UntypedHandle acquireNativeHandle(int handle) {
        return new UntypedHandleImpl(this, handle);
    }

    @Override // org.chromium.mojo.system.Core
    public Watcher getWatcher() {
        return new WatcherImpl();
    }

    @Override // org.chromium.mojo.system.Core
    public RunLoop createDefaultRunLoop() {
        if (this.mCurrentRunLoop.get() != null) {
            throw new MojoException(9);
        }
        BaseRunLoop runLoop = new BaseRunLoop(this);
        this.mCurrentRunLoop.set(runLoop);
        return runLoop;
    }

    @Override // org.chromium.mojo.system.Core
    public RunLoop getCurrentRunLoop() {
        return this.mCurrentRunLoop.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearCurrentRunLoop() {
        this.mCurrentRunLoop.remove();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int closeWithResult(int mojoHandle) {
        return nativeClose(mojoHandle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close(int mojoHandle) {
        int mojoResult = nativeClose(mojoHandle);
        if (mojoResult != 0) {
            throw new MojoException(mojoResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Core.HandleSignalsState queryHandleSignalsState(int mojoHandle) {
        ByteBuffer buffer = allocateDirectBuffer(8);
        int result = nativeQueryHandleSignalsState(mojoHandle, buffer);
        if (result != 0) {
            throw new MojoException(result);
        }
        return new Core.HandleSignalsState(new Core.HandleSignals(buffer.getInt(0)), new Core.HandleSignals(buffer.getInt(4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeMessage(MessagePipeHandleImpl pipeHandle, ByteBuffer bytes, List<? extends Handle> handles, MessagePipeHandle.WriteFlags flags) {
        ByteBuffer handlesBuffer = null;
        if (handles != null && !handles.isEmpty()) {
            handlesBuffer = allocateDirectBuffer(handles.size() * 4);
            for (Handle handle : handles) {
                handlesBuffer.putInt(getMojoHandle(handle));
            }
            handlesBuffer.position(0);
        }
        int mojoResult = nativeWriteMessage(pipeHandle.getMojoHandle(), bytes, bytes == null ? 0 : bytes.limit(), handlesBuffer, flags.getFlags());
        if (mojoResult != 0) {
            throw new MojoException(mojoResult);
        }
        if (handles != null) {
            for (Handle handle2 : handles) {
                if (handle2.isValid()) {
                    ((HandleBase) handle2).invalidateHandle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultAnd<MessagePipeHandle.ReadMessageResult> readMessage(MessagePipeHandleImpl handle, MessagePipeHandle.ReadFlags flags) {
        ResultAnd<MessagePipeHandle.ReadMessageResult> result = nativeReadMessage(handle.getMojoHandle(), flags.getFlags());
        if (result.getMojoResult() != 0 && result.getMojoResult() != 17) {
            throw new MojoException(result.getMojoResult());
        }
        MessagePipeHandle.ReadMessageResult readResult = result.getValue();
        int[] rawHandles = readResult.mRawHandles;
        if (rawHandles != null && rawHandles.length != 0) {
            readResult.mHandles = new ArrayList(rawHandles.length);
            for (int rawHandle : rawHandles) {
                readResult.mHandles.add(new UntypedHandleImpl(this, rawHandle));
            }
        } else {
            readResult.mHandles = new ArrayList(0);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int discardData(DataPipeConsumerHandleImpl handle, int numBytes, DataPipe.ReadFlags flags) {
        ResultAnd<Integer> result = nativeReadData(handle.getMojoHandle(), null, numBytes, flags.getFlags() | 2);
        if (result.getMojoResult() != 0) {
            throw new MojoException(result.getMojoResult());
        }
        return result.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultAnd<Integer> readData(DataPipeConsumerHandleImpl handle, ByteBuffer elements, DataPipe.ReadFlags flags) {
        ResultAnd<Integer> result = nativeReadData(handle.getMojoHandle(), elements, elements == null ? 0 : elements.capacity(), flags.getFlags());
        if (result.getMojoResult() != 0 && result.getMojoResult() != 17) {
            throw new MojoException(result.getMojoResult());
        }
        if (result.getMojoResult() == 0 && elements != null) {
            elements.limit(result.getValue().intValue());
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer beginReadData(DataPipeConsumerHandleImpl handle, int numBytes, DataPipe.ReadFlags flags) {
        ResultAnd<ByteBuffer> result = nativeBeginReadData(handle.getMojoHandle(), numBytes, flags.getFlags());
        if (result.getMojoResult() != 0) {
            throw new MojoException(result.getMojoResult());
        }
        return result.getValue().asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endReadData(DataPipeConsumerHandleImpl handle, int numBytesRead) {
        int result = nativeEndReadData(handle.getMojoHandle(), numBytesRead);
        if (result != 0) {
            throw new MojoException(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResultAnd<Integer> writeData(DataPipeProducerHandleImpl handle, ByteBuffer elements, DataPipe.WriteFlags flags) {
        return nativeWriteData(handle.getMojoHandle(), elements, elements.limit(), flags.getFlags());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer beginWriteData(DataPipeProducerHandleImpl handle, int numBytes, DataPipe.WriteFlags flags) {
        ResultAnd<ByteBuffer> result = nativeBeginWriteData(handle.getMojoHandle(), numBytes, flags.getFlags());
        if (result.getMojoResult() != 0) {
            throw new MojoException(result.getMojoResult());
        }
        return result.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endWriteData(DataPipeProducerHandleImpl handle, int numBytesWritten) {
        int result = nativeEndWriteData(handle.getMojoHandle(), numBytesWritten);
        if (result != 0) {
            throw new MojoException(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedBufferHandle duplicate(SharedBufferHandleImpl handle, SharedBufferHandle.DuplicateOptions options) {
        ByteBuffer optionsBuffer = null;
        if (options != null) {
            optionsBuffer = allocateDirectBuffer(8);
            optionsBuffer.putInt(0, 8);
            optionsBuffer.putInt(4, options.getFlags().getFlags());
        }
        ResultAnd<Integer> result = nativeDuplicate(handle.getMojoHandle(), optionsBuffer);
        if (result.getMojoResult() != 0) {
            throw new MojoException(result.getMojoResult());
        }
        return new SharedBufferHandleImpl(this, result.getValue().intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBuffer map(SharedBufferHandleImpl handle, long offset, long numBytes, SharedBufferHandle.MapFlags flags) {
        ResultAnd<ByteBuffer> result = nativeMap(handle.getMojoHandle(), offset, numBytes, flags.getFlags());
        if (result.getMojoResult() != 0) {
            throw new MojoException(result.getMojoResult());
        }
        return result.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unmap(ByteBuffer buffer) {
        int result = nativeUnmap(buffer);
        if (result != 0) {
            throw new MojoException(result);
        }
    }

    private int getMojoHandle(Handle handle) {
        if (handle.isValid()) {
            return ((HandleBase) handle).getMojoHandle();
        }
        return 0;
    }

    private static boolean isUnrecoverableError(int code) {
        switch (code) {
            case 0:
            case 1:
            case 4:
            case 9:
                return false;
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return true;
        }
    }

    private static int filterMojoResultForWait(int code) {
        if (isUnrecoverableError(code)) {
            throw new MojoException(code);
        }
        return code;
    }

    private ByteBuffer allocateDirectBuffer(int capacity) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(capacity + this.mByteBufferOffset);
        if (this.mByteBufferOffset != 0) {
            buffer.position(this.mByteBufferOffset);
            buffer = buffer.slice();
        }
        return buffer.order(ByteOrder.nativeOrder());
    }

    @CalledByNative
    private static ResultAnd<ByteBuffer> newResultAndBuffer(int mojoResult, ByteBuffer buffer) {
        return new ResultAnd<>(mojoResult, buffer);
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/impl/CoreImpl$IntegerPair.class */
    private static final class IntegerPair extends Pair<Integer, Integer> {
        public IntegerPair(Integer first, Integer second) {
            super(first, second);
        }
    }

    @CalledByNative
    private static ResultAnd<MessagePipeHandle.ReadMessageResult> newReadMessageResult(int mojoResult, byte[] data, int[] rawHandles) {
        MessagePipeHandle.ReadMessageResult result = new MessagePipeHandle.ReadMessageResult();
        if (mojoResult == 0) {
            result.mData = data;
            result.mRawHandles = rawHandles;
        }
        return new ResultAnd<>(mojoResult, result);
    }

    @CalledByNative
    private static ResultAnd<Integer> newResultAndInteger(int mojoResult, int numBytesRead) {
        return new ResultAnd<>(mojoResult, Integer.valueOf(numBytesRead));
    }

    @CalledByNative
    private static ResultAnd<IntegerPair> newNativeCreationResult(int mojoResult, int mojoHandle1, int mojoHandle2) {
        return new ResultAnd<>(mojoResult, new IntegerPair(Integer.valueOf(mojoHandle1), Integer.valueOf(mojoHandle2)));
    }
}
