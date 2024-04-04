package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.UnsafeSharedMemoryRegion;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/GpuMemoryBufferPlatformHandle.class */
public final class GpuMemoryBufferPlatformHandle extends Union {
    private UnsafeSharedMemoryRegion mSharedMemoryHandle;
    private AHardwareBufferHandle mAndroidHardwareBufferHandle;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/GpuMemoryBufferPlatformHandle$Tag.class */
    public static final class Tag {
        public static final int SharedMemoryHandle = 0;
        public static final int AndroidHardwareBufferHandle = 1;
    }

    static {
        $assertionsDisabled = !GpuMemoryBufferPlatformHandle.class.desiredAssertionStatus();
    }

    public void setSharedMemoryHandle(UnsafeSharedMemoryRegion sharedMemoryHandle) {
        this.mTag = 0;
        this.mSharedMemoryHandle = sharedMemoryHandle;
    }

    public UnsafeSharedMemoryRegion getSharedMemoryHandle() {
        if ($assertionsDisabled || this.mTag == 0) {
            return this.mSharedMemoryHandle;
        }
        throw new AssertionError();
    }

    public void setAndroidHardwareBufferHandle(AHardwareBufferHandle androidHardwareBufferHandle) {
        this.mTag = 1;
        this.mAndroidHardwareBufferHandle = androidHardwareBufferHandle;
    }

    public AHardwareBufferHandle getAndroidHardwareBufferHandle() {
        if ($assertionsDisabled || this.mTag == 1) {
            return this.mAndroidHardwareBufferHandle;
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
                encoder0.encode((Struct) this.mSharedMemoryHandle, offset + 8, false);
                return;
            case 1:
                encoder0.encode((Struct) this.mAndroidHardwareBufferHandle, offset + 8, false);
                return;
            default:
                return;
        }
    }

    public static GpuMemoryBufferPlatformHandle deserialize(Message message) {
        return decode(new Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final GpuMemoryBufferPlatformHandle decode(Decoder decoder0, int offset) {
        DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        GpuMemoryBufferPlatformHandle result = new GpuMemoryBufferPlatformHandle();
        switch (dataHeader.elementsOrVersion) {
            case 0:
                Decoder decoder1 = decoder0.readPointer(offset + 8, false);
                result.mSharedMemoryHandle = UnsafeSharedMemoryRegion.decode(decoder1);
                result.mTag = 0;
                break;
            case 1:
                Decoder decoder12 = decoder0.readPointer(offset + 8, false);
                result.mAndroidHardwareBufferHandle = AHardwareBufferHandle.decode(decoder12);
                result.mTag = 1;
                break;
        }
        return result;
    }
}
