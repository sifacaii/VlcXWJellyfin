package org.chromium.mojo.system;

import java.nio.ByteBuffer;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/DataPipe.class */
public interface DataPipe {

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/DataPipe$ConsumerHandle.class */
    public interface ConsumerHandle extends Handle {
        @Override // org.chromium.mojo.system.Handle
        ConsumerHandle pass();

        int discardData(int i, ReadFlags readFlags);

        ResultAnd<Integer> readData(ByteBuffer byteBuffer, ReadFlags readFlags);

        ByteBuffer beginReadData(int i, ReadFlags readFlags);

        void endReadData(int i);
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/DataPipe$ProducerHandle.class */
    public interface ProducerHandle extends Handle {
        @Override // org.chromium.mojo.system.Handle
        ProducerHandle pass();

        ResultAnd<Integer> writeData(ByteBuffer byteBuffer, WriteFlags writeFlags);

        ByteBuffer beginWriteData(int i, WriteFlags writeFlags);

        void endWriteData(int i);
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/DataPipe$CreateFlags.class */
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/DataPipe$CreateOptions.class */
    public static class CreateOptions {
        private CreateFlags mFlags = CreateFlags.none();
        private int mElementNumBytes;
        private int mCapacityNumBytes;

        public CreateFlags getFlags() {
            return this.mFlags;
        }

        public int getElementNumBytes() {
            return this.mElementNumBytes;
        }

        public void setElementNumBytes(int elementNumBytes) {
            this.mElementNumBytes = elementNumBytes;
        }

        public int getCapacityNumBytes() {
            return this.mCapacityNumBytes;
        }

        public void setCapacityNumBytes(int capacityNumBytes) {
            this.mCapacityNumBytes = capacityNumBytes;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/DataPipe$WriteFlags.class */
    public static class WriteFlags extends Flags<WriteFlags> {
        private static final int FLAG_NONE = 0;
        private static final int FLAG_ALL_OR_NONE = 1;
        public static final WriteFlags NONE = none().immutable();

        private WriteFlags(int flags) {
            super(flags);
        }

        public WriteFlags setAllOrNone(boolean allOrNone) {
            return setFlag(1, allOrNone);
        }

        public static WriteFlags none() {
            return new WriteFlags(0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/DataPipe$ReadFlags.class */
    public static class ReadFlags extends Flags<ReadFlags> {
        private static final int FLAG_NONE = 0;
        private static final int FLAG_ALL_OR_NONE = 1;
        private static final int FLAG_QUERY = 4;
        private static final int FLAG_PEEK = 8;
        public static final ReadFlags NONE = none().immutable();

        private ReadFlags(int flags) {
            super(flags);
        }

        public ReadFlags setAllOrNone(boolean allOrNone) {
            return setFlag(1, allOrNone);
        }

        public ReadFlags query(boolean query) {
            return setFlag(4, query);
        }

        public ReadFlags peek(boolean peek) {
            return setFlag(8, peek);
        }

        public static ReadFlags none() {
            return new ReadFlags(0);
        }
    }
}
