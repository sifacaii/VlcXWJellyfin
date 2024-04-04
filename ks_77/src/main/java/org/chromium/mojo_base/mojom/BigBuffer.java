package org.chromium.mojo_base.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo_base/mojom/BigBuffer.class */
public final class BigBuffer extends Union {
    private byte[] mBytes;
    private BigBufferSharedMemoryRegion mSharedMemory;
    private boolean mInvalidBuffer;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo_base/mojom/BigBuffer$Tag.class */
    public static final class Tag {
        public static final int Bytes = 0;
        public static final int SharedMemory = 1;
        public static final int InvalidBuffer = 2;
    }

    static {
        $assertionsDisabled = !BigBuffer.class.desiredAssertionStatus();
    }

    public void setBytes(byte[] bytes) {
        this.mTag = 0;
        this.mBytes = bytes;
    }

    public byte[] getBytes() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mBytes;
        }
        throw new AssertionError();
    }

    public void setSharedMemory(BigBufferSharedMemoryRegion sharedMemory) {
        this.mTag = 1;
        this.mSharedMemory = sharedMemory;
    }

    public BigBufferSharedMemoryRegion getSharedMemory() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mSharedMemory;
        }
        throw new AssertionError();
    }

    public void setInvalidBuffer(boolean invalidBuffer) {
        this.mTag = 2;
        this.mInvalidBuffer = invalidBuffer;
    }

    public boolean getInvalidBuffer() {
        if ($assertionsDisabled || this.mTag == 2) {
            return this.mInvalidBuffer;
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
                encoder0.encode(this.mBytes, offset + 8, 0, -1);
                return;
            case 1:
                encoder0.encode((Struct) this.mSharedMemory, offset + 8, false);
                return;
            case 2:
                encoder0.encode(this.mInvalidBuffer, offset + 8, 0);
                return;
            default:
                return;
        }
    }

    public static BigBuffer deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final BigBuffer decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        BigBuffer result = new BigBuffer();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                result.mBytes = decoder0.readBytes(offset + 8, 0, -1);
                result.mTag = 0;
                break;
            case 1:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                result.mSharedMemory = BigBufferSharedMemoryRegion.decode(decoder1);
                result.mTag = 1;
                break;
            case 2:
                result.mInvalidBuffer = decoder0.readBoolean(offset + 8, 0);
                result.mTag = 2;
                break;
        }
        return result;
    }
}
