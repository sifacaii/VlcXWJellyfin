package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class NdefMessage extends Struct {
    private static final int STRUCT_SIZE = 24;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(24, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public static final int MAX_SIZE = 32768;

    public NdefRecord[] data;

    public String url;

    private NdefMessage(int version) {
        super(24, version);
    }

    public NdefMessage() {
        this(0);
    }

    public static NdefMessage deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NdefMessage deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NdefMessage decode(Decoder decoder0) {
        NdefMessage result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new NdefMessage(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.data = new NdefRecord[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + 8 * i1, false);
                result.data[i1] = NdefRecord.decode(decoder2);
            }
            result.url = decoder0.readString(16, true);
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        if (this.data == null) {
            encoder0.encodeNullPointer(8, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.data.length, 8, -1);
            for (int i0 = 0; i0 < this.data.length; i0++)
                encoder1.encode(this.data[i0], 8 + 8 * i0, false);
        }
        encoder0.encode(this.url, 16, true);
    }
}
