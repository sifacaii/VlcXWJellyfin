package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.BlurTileMode;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/FilterOperation.class */
public final class FilterOperation extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int type;
    public float amount;
    public float outerThreshold;
    public Point dropShadowOffset;
    public int dropShadowColor;
    public PaintFilter imageFilter;
    public float[] matrix;
    public int zoomInset;
    public int blurTileMode;
    public Rect[] shape;

    private FilterOperation(int version) {
        super(64, version);
    }

    public FilterOperation() {
        this(0);
    }

    public static FilterOperation deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static FilterOperation deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static FilterOperation decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            FilterOperation result = new FilterOperation(elementsOrVersion);
            result.type = decoder0.readInt(8);
            FilterType.validate(result.type);
            result.amount = decoder0.readFloat(12);
            result.outerThreshold = decoder0.readFloat(16);
            result.dropShadowColor = decoder0.readInt(20);
            Decoder decoder1 = decoder0.readPointer(24, false);
            result.dropShadowOffset = Point.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(32, false);
            result.imageFilter = PaintFilter.decode(decoder12);
            result.matrix = decoder0.readFloats(40, 1, 20);
            result.zoomInset = decoder0.readInt(48);
            result.blurTileMode = decoder0.readInt(52);
            BlurTileMode.validate(result.blurTileMode);
            Decoder decoder13 = decoder0.readPointer(56, true);
            if (decoder13 == null) {
                result.shape = null;
            } else {
                DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
                result.shape = new Rect[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder13.readPointer(8 + (8 * i1), false);
                    result.shape[i1] = Rect.decode(decoder2);
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
        encoder0.encode(this.type, 8);
        encoder0.encode(this.amount, 12);
        encoder0.encode(this.outerThreshold, 16);
        encoder0.encode(this.dropShadowColor, 20);
        encoder0.encode((Struct) this.dropShadowOffset, 24, false);
        encoder0.encode((Struct) this.imageFilter, 32, false);
        encoder0.encode(this.matrix, 40, 1, 20);
        encoder0.encode(this.zoomInset, 48);
        encoder0.encode(this.blurTileMode, 52);
        if (this.shape == null) {
            encoder0.encodeNullPointer(56, true);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.shape.length, 56, -1);
        for (int i0 = 0; i0 < this.shape.length; i0++) {
            encoder1.encode((Struct) this.shape[i0], 8 + (8 * i0), false);
        }
    }
}
