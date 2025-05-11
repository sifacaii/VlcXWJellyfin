package org.chromium.mojo_base.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.SharedBufferHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo_base/mojom/BigBufferSharedMemoryRegion.class */
public final class BigBufferSharedMemoryRegion extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public SharedBufferHandle bufferHandle;
    public int size;

    private BigBufferSharedMemoryRegion(int version) {
        super(16, version);
        this.bufferHandle = InvalidHandle.INSTANCE;
    }

    public BigBufferSharedMemoryRegion() {
        this(0);
    }

    public static BigBufferSharedMemoryRegion deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static BigBufferSharedMemoryRegion deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static BigBufferSharedMemoryRegion decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            BigBufferSharedMemoryRegion result = new BigBufferSharedMemoryRegion(elementsOrVersion);
            result.bufferHandle = decoder0.readSharedBufferHandle(8, false);
            result.size = decoder0.readInt(12);
            decoder0.decreaseStackDepth();
            return result;
        } catch (Throwable th) {
            decoder0.decreaseStackDepth();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode((Handle) this.bufferHandle, 8, false);
        encoder0.encode(this.size, 12);
    }
}
