package org.chromium.mojo.system;

import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.SharedBufferHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/Core.class */
public interface Core {
    public static final long DEADLINE_INFINITE = -1;

    long getTimeTicksNow();

    Pair<MessagePipeHandle, MessagePipeHandle> createMessagePipe(MessagePipeHandle.CreateOptions createOptions);

    Pair<DataPipe.ProducerHandle, DataPipe.ConsumerHandle> createDataPipe(DataPipe.CreateOptions createOptions);

    SharedBufferHandle createSharedBuffer(SharedBufferHandle.CreateOptions createOptions, long j);

    UntypedHandle acquireNativeHandle(int i);

    Watcher getWatcher();

    RunLoop createDefaultRunLoop();

    RunLoop getCurrentRunLoop();

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/Core$HandleSignals.class */
    public static class HandleSignals extends Flags<HandleSignals> {
        private static final int FLAG_NONE = 0;
        private static final int FLAG_READABLE = 1;
        private static final int FLAG_WRITABLE = 2;
        private static final int FLAG_PEER_CLOSED = 4;
        public static final HandleSignals NONE = none().immutable();
        public static final HandleSignals READABLE = none().setReadable(true).immutable();
        public static final HandleSignals WRITABLE = none().setWritable(true).immutable();

        public HandleSignals(int signals) {
            super(signals);
        }

        public HandleSignals setReadable(boolean readable) {
            return setFlag(1, readable);
        }

        public HandleSignals setWritable(boolean writable) {
            return setFlag(2, writable);
        }

        public HandleSignals setPeerClosed(boolean peerClosed) {
            return setFlag(4, peerClosed);
        }

        public static HandleSignals none() {
            return new HandleSignals(0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/Core$HandleSignalsState.class */
    public static class HandleSignalsState {
        private final HandleSignals mSatisfiedSignals;
        private final HandleSignals mSatisfiableSignals;

        public HandleSignalsState(HandleSignals satisfiedSignals, HandleSignals satisfiableSignals) {
            this.mSatisfiedSignals = satisfiedSignals;
            this.mSatisfiableSignals = satisfiableSignals;
        }

        public HandleSignals getSatisfiedSignals() {
            return this.mSatisfiedSignals;
        }

        public HandleSignals getSatisfiableSignals() {
            return this.mSatisfiableSignals;
        }
    }
}
