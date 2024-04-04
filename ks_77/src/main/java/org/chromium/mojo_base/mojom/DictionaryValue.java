package org.chromium.mojo_base.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo_base/mojom/DictionaryValue.class */
public final class DictionaryValue extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Map<String, Value> storage;

    private DictionaryValue(int version) {
        super(16, version);
    }

    public DictionaryValue() {
        this(0);
    }

    public static DictionaryValue deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DictionaryValue deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DictionaryValue decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            DictionaryValue result = new DictionaryValue(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            decoder1.readDataHeaderForMap();
            Decoder decoder2 = decoder1.readPointer(8, false);
            DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
            String[] keys0 = new String[si2.elementsOrVersion];
            for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                keys0[i2] = decoder2.readString(8 + (8 * i2), false);
            }
            Decoder decoder22 = decoder1.readPointer(16, false);
            DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
            Value[] values0 = new Value[si22.elementsOrVersion];
            for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
                values0[i22] = Value.decode(decoder22, 8 + (16 * i22));
            }
            result.storage = new HashMap();
            for (int index0 = 0; index0 < keys0.length; index0++) {
                result.storage.put(keys0[index0], values0[index0]);
            }
            return result;
        } finally {
            decoder0.decreaseStackDepth();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        if (this.storage == null) {
            encoder0.encodeNullPointer(8, false);
            return;
        }
        Encoder encoder1 = encoder0.encoderForMap(8);
        int size0 = this.storage.size();
        String[] keys0 = new String[size0];
        Value[] values0 = new Value[size0];
        int index0 = 0;
        for (Map.Entry<String, Value> entry0 : this.storage.entrySet()) {
            keys0[index0] = entry0.getKey();
            values0[index0] = entry0.getValue();
            index0++;
        }
        Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
        for (int i1 = 0; i1 < keys0.length; i1++) {
            encoder2.encode(keys0[i1], 8 + (8 * i1), false);
        }
        Encoder encoder22 = encoder1.encodeUnionArray(values0.length, 16, -1);
        for (int i12 = 0; i12 < values0.length; i12++) {
            encoder22.encode((Union) values0[i12], 8 + (16 * i12), false);
        }
    }
}
