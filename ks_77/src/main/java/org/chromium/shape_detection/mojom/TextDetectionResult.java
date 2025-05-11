package org.chromium.shape_detection.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/shape_detection/mojom/TextDetectionResult.class */
public final class TextDetectionResult extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String rawValue;
    public RectF boundingBox;
    public PointF[] cornerPoints;

    private TextDetectionResult(int version) {
        super(32, version);
    }

    public TextDetectionResult() {
        this(0);
    }

    public static TextDetectionResult deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static TextDetectionResult deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static TextDetectionResult decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            TextDetectionResult result = new TextDetectionResult(elementsOrVersion);
            result.rawValue = decoder0.readString(8, false);
            result.boundingBox = RectF.decode(decoder0.readPointer(16, false));
            Decoder decoder1 = decoder0.readPointer(24, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.cornerPoints = new PointF[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.cornerPoints[i1] = PointF.decode(decoder2);
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
        encoder0.encode(this.rawValue, 8, false);
        encoder0.encode((Struct) this.boundingBox, 16, false);
        if (this.cornerPoints == null) {
            encoder0.encodeNullPointer(24, false);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.cornerPoints.length, 24, -1);
        for (int i0 = 0; i0 < this.cornerPoints.length; i0++) {
            encoder1.encode((Struct) this.cornerPoints[i0], 8 + (8 * i0), false);
        }
    }
}
