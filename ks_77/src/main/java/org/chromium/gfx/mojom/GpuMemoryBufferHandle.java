package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/GpuMemoryBufferHandle.class */
public final class GpuMemoryBufferHandle extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public GpuMemoryBufferId id;
    public int offset;
    public int stride;
    public GpuMemoryBufferPlatformHandle platformHandle;

    private GpuMemoryBufferHandle(int version) {
        super(40, version);
    }

    public GpuMemoryBufferHandle() {
        this(0);
    }

    public static GpuMemoryBufferHandle deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static GpuMemoryBufferHandle deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuMemoryBufferHandle decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            GpuMemoryBufferHandle result = new GpuMemoryBufferHandle(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.id = GpuMemoryBufferId.decode(decoder1);
            result.offset = decoder0.readInt(16);
            result.stride = decoder0.readInt(20);
            result.platformHandle = GpuMemoryBufferPlatformHandle.decode(decoder0, 24);
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
        encoder0.encode((Struct) this.id, 8, false);
        encoder0.encode(this.offset, 16);
        encoder0.encode(this.stride, 20);
        encoder0.encode((Union) this.platformHandle, 24, true);
    }
}
