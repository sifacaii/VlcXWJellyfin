package org.chromium.mojo.system;

import java.nio.ByteBuffer;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/SharedBufferHandle.class */
public interface SharedBufferHandle extends Handle {
    @Override // org.chromium.mojo.system.Handle
    SharedBufferHandle pass();

    SharedBufferHandle duplicate(DuplicateOptions duplicateOptions);

    ByteBuffer map(long j, long j2, MapFlags mapFlags);

    void unmap(ByteBuffer byteBuffer);

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/SharedBufferHandle$CreateFlags.class */
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

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/SharedBufferHandle$CreateOptions.class */
    public static class CreateOptions {
        private CreateFlags mFlags = CreateFlags.NONE;

        public CreateFlags getFlags() {
            return this.mFlags;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/SharedBufferHandle$DuplicateFlags.class */
    public static class DuplicateFlags extends Flags<DuplicateFlags> {
        private static final int FLAG_NONE = 0;
        public static final DuplicateFlags NONE = none().immutable();

        protected DuplicateFlags(int flags) {
            super(flags);
        }

        public static DuplicateFlags none() {
            return new DuplicateFlags(0);
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/SharedBufferHandle$DuplicateOptions.class */
    public static class DuplicateOptions {
        private DuplicateFlags mFlags = DuplicateFlags.NONE;

        public DuplicateFlags getFlags() {
            return this.mFlags;
        }
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/system/SharedBufferHandle$MapFlags.class */
    public static class MapFlags extends Flags<MapFlags> {
        private static final int FLAG_NONE = 0;
        public static final MapFlags NONE = none().immutable();

        protected MapFlags(int flags) {
            super(flags);
        }

        public static MapFlags none() {
            return new MapFlags(0);
        }
    }
}
