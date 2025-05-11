package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/ColorSpace.class */
public final class ColorSpace extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int primaries;
    public int transfer;
    public int matrix;
    public int range;
    public float[] customPrimaryMatrix;
    public float[] customTransferParams;

    private ColorSpace(int version) {
        super(40, version);
    }

    public ColorSpace() {
        this(0);
    }

    public static ColorSpace deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ColorSpace deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ColorSpace decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ColorSpace result = new ColorSpace(elementsOrVersion);
            result.primaries = decoder0.readInt(8);
            ColorSpacePrimaryId.validate(result.primaries);
            result.transfer = decoder0.readInt(12);
            ColorSpaceTransferId.validate(result.transfer);
            result.matrix = decoder0.readInt(16);
            ColorSpaceMatrixId.validate(result.matrix);
            result.range = decoder0.readInt(20);
            ColorSpaceRangeId.validate(result.range);
            result.customPrimaryMatrix = decoder0.readFloats(24, 0, 9);
            result.customTransferParams = decoder0.readFloats(32, 0, 7);
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
        encoder0.encode(this.primaries, 8);
        encoder0.encode(this.transfer, 12);
        encoder0.encode(this.matrix, 16);
        encoder0.encode(this.range, 20);
        encoder0.encode(this.customPrimaryMatrix, 24, 0, 9);
        encoder0.encode(this.customTransferParams, 32, 0, 7);
    }
}
