package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DataElementBytes extends Struct {
    private static final int STRUCT_SIZE = 32;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public static final long MAXIMUM_EMBEDDED_DATA_SIZE = 256000L;

    public long length;

    public byte[] embeddedData;

    public BytesProvider data;

    private DataElementBytes(int version) {
        super(32, version);
    }

    public DataElementBytes() {
        this(0);
    }

    public static DataElementBytes deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DataElementBytes deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DataElementBytes decode(Decoder decoder0) {
        DataElementBytes result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new DataElementBytes(elementsOrVersion);
            result.length = decoder0.readLong(8);
            result.embeddedData = decoder0.readBytes(16, 1, -1);
            result.data = (BytesProvider)decoder0.readServiceInterface(24, false, BytesProvider.MANAGER);
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.length, 8);
        encoder0.encode(this.embeddedData, 16, 1, -1);
        encoder0.encode(this.data, 24, false, BytesProvider.MANAGER);
    }
}
