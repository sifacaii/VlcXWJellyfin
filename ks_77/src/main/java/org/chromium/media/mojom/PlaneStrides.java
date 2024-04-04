package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PlaneStrides.class */
public final class PlaneStrides extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int[] strideByPlane;

    private PlaneStrides(int version) {
        super(16, version);
    }

    public PlaneStrides() {
        this(0);
    }

    public static PlaneStrides deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PlaneStrides deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PlaneStrides decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PlaneStrides result = new PlaneStrides(elementsOrVersion);
            result.strideByPlane = decoder0.readInts(8, 0, 4);
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
        encoder0.encode(this.strideByPlane, 8, 0, 4);
    }
}
