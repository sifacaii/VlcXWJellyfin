package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DataElementBlob extends Struct {
    private static final int STRUCT_SIZE = 32;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(32, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public Blob blob;

    public long offset;

    public long length;

    private DataElementBlob(int version) {
        super(32, version);
    }

    public DataElementBlob() {
        this(0);
    }

    public static DataElementBlob deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DataElementBlob deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DataElementBlob decode(Decoder decoder0) {
        DataElementBlob result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new DataElementBlob(elementsOrVersion);
            result.blob = (Blob)decoder0.readServiceInterface(8, false, Blob.MANAGER);
            result.offset = decoder0.readLong(16);
            result.length = decoder0.readLong(24);
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.blob, 8, false, Blob.MANAGER);
        encoder0.encode(this.offset, 16);
        encoder0.encode(this.length, 24);
    }
}
