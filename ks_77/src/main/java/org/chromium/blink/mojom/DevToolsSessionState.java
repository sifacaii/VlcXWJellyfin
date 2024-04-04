package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DevToolsSessionState extends Struct {
    private static final int STRUCT_SIZE = 16;

    private static final DataHeader[] VERSION_ARRAY = new DataHeader[] { new DataHeader(16, 0) };

    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public Map<String, byte[]> entries;

    private DevToolsSessionState(int version) {
        super(16, version);
    }

    public DevToolsSessionState() {
        this(0);
    }

    public static DevToolsSessionState deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DevToolsSessionState deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DevToolsSessionState decode(Decoder decoder0) {
        DevToolsSessionState result;
        if (decoder0 == null)
            return null;
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new DevToolsSessionState(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            decoder1.readDataHeaderForMap();
            Decoder decoder2 = decoder1.readPointer(8, false);
            DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
            String[] keys0 = new String[si2.elementsOrVersion];
            int i2;
            for (i2 = 0; i2 < si2.elementsOrVersion; i2++)
                keys0[i2] = decoder2.readString(8 + 8 * i2, false);
            decoder2 = decoder1.readPointer(16, false);
            si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
            byte[][] values0 = new byte[si2.elementsOrVersion][];
            for (i2 = 0; i2 < si2.elementsOrVersion; i2++)
                values0[i2] = decoder2.readBytes(8 + 8 * i2, 1, -1);
            result.entries = (Map)new HashMap<>();
            for (int index0 = 0; index0 < keys0.length; index0++)
                result.entries.put(keys0[index0], values0[index0]);
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        if (this.entries == null) {
            encoder0.encodeNullPointer(8, false);
        } else {
            Encoder encoder1 = encoder0.encoderForMap(8);
            int size0 = this.entries.size();
            String[] keys0 = new String[size0];
            byte[][] values0 = new byte[size0][];
            int index0 = 0;
            for (Map.Entry<String, byte[]> entry0 : this.entries.entrySet()) {
                keys0[index0] = entry0.getKey();
                values0[index0] = entry0.getValue();
                index0++;
            }
            Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
            int i1;
            for (i1 = 0; i1 < keys0.length; i1++)
                encoder2.encode(keys0[i1], 8 + 8 * i1, false);
            encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
            for (i1 = 0; i1 < values0.length; i1++)
                encoder2.encode(values0[i1], 8 + 8 * i1, 1, -1);
        }
    }
}
