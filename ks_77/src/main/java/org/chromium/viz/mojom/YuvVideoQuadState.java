package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.ColorSpace;
import org.chromium.gfx.mojom.RectF;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/YuvVideoQuadState.class */
public final class YuvVideoQuadState extends Struct {
    private static final int STRUCT_SIZE = 80;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(80, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public RectF yaTexCoordRect;
    public RectF uvTexCoordRect;
    public Size yaTexSize;
    public Size uvTexSize;
    public int yPlaneResourceId;
    public int uPlaneResourceId;
    public int vPlaneResourceId;
    public int aPlaneResourceId;
    public float resourceOffset;
    public float resourceMultiplier;
    public int bitsPerChannel;
    public ColorSpace videoColorSpace;
    public int protectedVideoType;

    private YuvVideoQuadState(int version) {
        super(80, version);
    }

    public YuvVideoQuadState() {
        this(0);
    }

    public static YuvVideoQuadState deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static YuvVideoQuadState deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static YuvVideoQuadState decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            YuvVideoQuadState result = new YuvVideoQuadState(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.yaTexCoordRect = RectF.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.uvTexCoordRect = RectF.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, false);
            result.yaTexSize = Size.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(32, false);
            result.uvTexSize = Size.decode(decoder14);
            result.yPlaneResourceId = decoder0.readInt(40);
            result.uPlaneResourceId = decoder0.readInt(44);
            result.vPlaneResourceId = decoder0.readInt(48);
            result.aPlaneResourceId = decoder0.readInt(52);
            result.resourceOffset = decoder0.readFloat(56);
            result.resourceMultiplier = decoder0.readFloat(60);
            result.bitsPerChannel = decoder0.readInt(64);
            result.protectedVideoType = decoder0.readInt(68);
            ProtectedVideoState.validate(result.protectedVideoType);
            Decoder decoder15 = decoder0.readPointer(72, false);
            result.videoColorSpace = ColorSpace.decode(decoder15);
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
        encoder0.encode((Struct) this.yaTexCoordRect, 8, false);
        encoder0.encode((Struct) this.uvTexCoordRect, 16, false);
        encoder0.encode((Struct) this.yaTexSize, 24, false);
        encoder0.encode((Struct) this.uvTexSize, 32, false);
        encoder0.encode(this.yPlaneResourceId, 40);
        encoder0.encode(this.uPlaneResourceId, 44);
        encoder0.encode(this.vPlaneResourceId, 48);
        encoder0.encode(this.aPlaneResourceId, 52);
        encoder0.encode(this.resourceOffset, 56);
        encoder0.encode(this.resourceMultiplier, 60);
        encoder0.encode(this.bitsPerChannel, 64);
        encoder0.encode(this.protectedVideoType, 68);
        encoder0.encode((Struct) this.videoColorSpace, 72, false);
    }
}
