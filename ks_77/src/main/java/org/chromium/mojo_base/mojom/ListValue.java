package org.chromium.mojo_base.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo_base/mojom/ListValue.class */
public final class ListValue extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Value[] storage;

    private ListValue(int version) {
        super(16, version);
    }

    public ListValue() {
        this(0);
    }

    public static ListValue deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ListValue deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ListValue decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ListValue result = new ListValue(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.storage = new Value[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                result.storage[i1] = Value.decode(decoder1, 8 + (16 * i1));
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
        Encoder encoder1 = encoder0.encodeUnionArray(this.storage.length, 8, -1);
        for (int i0 = 0; i0 < this.storage.length; i0++) {
            encoder1.encode((Union) this.storage[i0], 8 + (16 * i0), false);
        }
    }
}
