package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/BufferUsageAndFormat.class */
public final class BufferUsageAndFormat extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int usage;
    public int format;

    private BufferUsageAndFormat(int version) {
        super(16, version);
    }

    public BufferUsageAndFormat() {
        this(0);
    }

    public static BufferUsageAndFormat deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static BufferUsageAndFormat deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static BufferUsageAndFormat decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            BufferUsageAndFormat result = new BufferUsageAndFormat(elementsOrVersion);
            result.usage = decoder0.readInt(8);
            BufferUsage.validate(result.usage);
            result.format = decoder0.readInt(12);
            BufferFormat.validate(result.format);
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
        encoder0.encode(this.usage, 8);
        encoder0.encode(this.format, 12);
    }
}
