package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.SharedBufferHandle;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoBufferHandle.class */
public final class VideoBufferHandle extends Union {
    private SharedBufferHandle mSharedBufferHandle;
    private ReadOnlySharedMemoryRegion mReadOnlyShmemRegion;
    private SharedMemoryViaRawFileDescriptor mSharedMemoryViaRawFileDescriptor;
    private MailboxBufferHandleSet mMailboxHandles;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoBufferHandle$Tag.class */
    public static final class Tag {
        public static final int SharedBufferHandle = 0;
        public static final int ReadOnlyShmemRegion = 1;
        public static final int SharedMemoryViaRawFileDescriptor = 2;
        public static final int MailboxHandles = 3;
    }

    static {
        $assertionsDisabled = !VideoBufferHandle.class.desiredAssertionStatus();
    }

    public void setSharedBufferHandle(SharedBufferHandle sharedBufferHandle) {
        this.mTag = 0;
        this.mSharedBufferHandle = sharedBufferHandle;
    }

    public SharedBufferHandle getSharedBufferHandle() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mSharedBufferHandle;
        }
        throw new AssertionError();
    }

    public void setReadOnlyShmemRegion(ReadOnlySharedMemoryRegion readOnlyShmemRegion) {
        this.mTag = 1;
        this.mReadOnlyShmemRegion = readOnlyShmemRegion;
    }

    public ReadOnlySharedMemoryRegion getReadOnlyShmemRegion() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mReadOnlyShmemRegion;
        }
        throw new AssertionError();
    }

    public void setSharedMemoryViaRawFileDescriptor(SharedMemoryViaRawFileDescriptor sharedMemoryViaRawFileDescriptor) {
        this.mTag = 2;
        this.mSharedMemoryViaRawFileDescriptor = sharedMemoryViaRawFileDescriptor;
    }

    public SharedMemoryViaRawFileDescriptor getSharedMemoryViaRawFileDescriptor() {
        if ($assertionsDisabled || this.mTag == 2) {
            return this.mSharedMemoryViaRawFileDescriptor;
        }
        throw new AssertionError();
    }

    public void setMailboxHandles(MailboxBufferHandleSet mailboxHandles) {
        this.mTag = 3;
        this.mMailboxHandles = mailboxHandles;
    }

    public MailboxBufferHandleSet getMailboxHandles() {
        if ($assertionsDisabled || this.mTag == 3) {
            return this.mMailboxHandles;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Union
    public final void encode(Encoder encoder0, int offset) {
        encoder0.encode(16, offset);
        encoder0.encode(this.mTag, offset + 4);
        switch (this.mTag) {
            case 0:
                encoder0.encode((Handle) this.mSharedBufferHandle, offset + 8, false);
                return;
            case 1:
                encoder0.encode((Struct) this.mReadOnlyShmemRegion, offset + 8, false);
                return;
            case 2:
                encoder0.encode((Struct) this.mSharedMemoryViaRawFileDescriptor, offset + 8, false);
                return;
            case 3:
                encoder0.encode((Struct) this.mMailboxHandles, offset + 8, false);
                return;
            default:
                return;
        }
    }

    public static VideoBufferHandle deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final VideoBufferHandle decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        VideoBufferHandle result = new VideoBufferHandle();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                result.mSharedBufferHandle = decoder0.readSharedBufferHandle(offset + 8, false);
                result.mTag = 0;
                break;
            case 1:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                result.mReadOnlyShmemRegion = ReadOnlySharedMemoryRegion.decode(decoder1);
                result.mTag = 1;
                break;
            case 2:
                Decoder decoder12 = decoder0.readPointer(offset + 8, false);
                result.mSharedMemoryViaRawFileDescriptor = SharedMemoryViaRawFileDescriptor.decode(decoder12);
                result.mTag = 2;
                break;
            case 3:
                Decoder decoder13 = decoder0.readPointer(offset + 8, false);
                result.mMailboxHandles = MailboxBufferHandleSet.decode(decoder13);
                result.mTag = 3;
                break;
        }
        return result;
    }
}
