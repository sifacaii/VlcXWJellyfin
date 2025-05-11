package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PointF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/MasteringMetadata.class */
public final class MasteringMetadata extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public PointF primaryR;
    public PointF primaryG;
    public PointF primaryB;
    public PointF whitePoint;
    public float luminanceMax;
    public float luminanceMin;

    private MasteringMetadata(int version) {
        super(48, version);
    }

    public MasteringMetadata() {
        this(0);
    }

    public static MasteringMetadata deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static MasteringMetadata deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static MasteringMetadata decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            MasteringMetadata result = new MasteringMetadata(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.primaryR = PointF.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.primaryG = PointF.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, false);
            result.primaryB = PointF.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(32, false);
            result.whitePoint = PointF.decode(decoder14);
            result.luminanceMax = decoder0.readFloat(40);
            result.luminanceMin = decoder0.readFloat(44);
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
        encoder0.encode((Struct) this.primaryR, 8, false);
        encoder0.encode((Struct) this.primaryG, 16, false);
        encoder0.encode((Struct) this.primaryB, 24, false);
        encoder0.encode((Struct) this.whitePoint, 32, false);
        encoder0.encode(this.luminanceMax, 40);
        encoder0.encode(this.luminanceMin, 44);
    }
}
