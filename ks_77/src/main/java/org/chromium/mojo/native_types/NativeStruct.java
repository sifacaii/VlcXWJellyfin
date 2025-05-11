package org.chromium.mojo.native_types;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/mojo/native_types/NativeStruct.class */
public final class NativeStruct extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public byte[] data;
    public SerializedHandle[] handles;

    private NativeStruct(int version) {
        super(24, version);
    }

    public NativeStruct() {
        this(0);
    }

    public static NativeStruct deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static NativeStruct deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static NativeStruct decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            NativeStruct result = new NativeStruct(elementsOrVersion);
            result.data = decoder0.readBytes(8, 0, -1);
            Decoder decoder1 = decoder0.readPointer(16, true);
            if (decoder1 == null) {
                result.handles = null;
            } else {
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.handles = new SerializedHandle[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.handles[i1] = SerializedHandle.decode(decoder2);
                }
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
        encoder0.encode(this.data, 8, 0, -1);
        if (this.handles == null) {
            encoder0.encodeNullPointer(16, true);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.handles.length, 16, -1);
        for (int i0 = 0; i0 < this.handles.length; i0++) {
            encoder1.encode((Struct) this.handles[i0], 8 + (8 * i0), false);
        }
    }
}
