package org.chromium.mojo.system;

import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/MessagePipeHandle.class */
public interface MessagePipeHandle extends Handle {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/MessagePipeHandle$ReadMessageResult.class */
    public static class ReadMessageResult {
        public byte[] mData;
        public int[] mRawHandles;
        public List<UntypedHandle> mHandles;
    }

    @Override // org.chromium.mojo.system.Handle
    MessagePipeHandle pass();

    void writeMessage(ByteBuffer byteBuffer, List<? extends Handle> list, WriteFlags writeFlags);

    ResultAnd<ReadMessageResult> readMessage(ReadFlags readFlags);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/MessagePipeHandle$CreateFlags.class */
    public static class CreateFlags extends Flags<CreateFlags> {
        private static final int FLAG_NONE = 0;
        public static final CreateFlags NONE = none().immutable();

        protected CreateFlags(int flags) {
            super(flags);
        }

        public static CreateFlags none() {
            return new CreateFlags(0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/MessagePipeHandle$CreateOptions.class */
    public static class CreateOptions {
        private CreateFlags mFlags = CreateFlags.NONE;

        public CreateFlags getFlags() {
            return this.mFlags;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/MessagePipeHandle$WriteFlags.class */
    public static class WriteFlags extends Flags<WriteFlags> {
        private static final int FLAG_NONE = 0;
        public static final WriteFlags NONE = none().immutable();

        private WriteFlags(int flags) {
            super(flags);
        }

        public static WriteFlags none() {
            return new WriteFlags(0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/MessagePipeHandle$ReadFlags.class */
    public static class ReadFlags extends Flags<ReadFlags> {
        private static final int FLAG_NONE = 0;
        public static final ReadFlags NONE = none().immutable();

        private ReadFlags(int flags) {
            super(flags);
        }

        public static ReadFlags none() {
            return new ReadFlags(0);
        }
    }
}
