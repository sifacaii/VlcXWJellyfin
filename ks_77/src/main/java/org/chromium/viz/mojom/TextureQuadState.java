package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/TextureQuadState.class */
public final class TextureQuadState extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int resourceId;
    public Size resourceSizeInPixels;
    public boolean premultipliedAlpha;
    public PointF uvTopLeft;
    public PointF uvBottomRight;
    public int backgroundColor;
    public float[] vertexOpacity;
    public boolean yFlipped;
    public boolean nearestNeighbor;
    public boolean secureOutputOnly;
    public int protectedVideoType;

    private TextureQuadState(int version) {
        super(56, version);
    }

    public TextureQuadState() {
        this(0);
    }

    public static TextureQuadState deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static TextureQuadState deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static TextureQuadState decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            TextureQuadState result = new TextureQuadState(elementsOrVersion);
            result.resourceId = decoder0.readInt(8);
            result.premultipliedAlpha = decoder0.readBoolean(12, 0);
            result.yFlipped = decoder0.readBoolean(12, 1);
            result.nearestNeighbor = decoder0.readBoolean(12, 2);
            result.secureOutputOnly = decoder0.readBoolean(12, 3);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.resourceSizeInPixels = Size.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.uvTopLeft = PointF.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, false);
            result.uvBottomRight = PointF.decode(decoder13);
            result.backgroundColor = decoder0.readInt(40);
            result.protectedVideoType = decoder0.readInt(44);
            ProtectedVideoState.validate(result.protectedVideoType);
            result.vertexOpacity = decoder0.readFloats(48, 0, 4);
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
        encoder0.encode(this.resourceId, 8);
        encoder0.encode(this.premultipliedAlpha, 12, 0);
        encoder0.encode(this.yFlipped, 12, 1);
        encoder0.encode(this.nearestNeighbor, 12, 2);
        encoder0.encode(this.secureOutputOnly, 12, 3);
        encoder0.encode((Struct) this.resourceSizeInPixels, 16, false);
        encoder0.encode((Struct) this.uvTopLeft, 24, false);
        encoder0.encode((Struct) this.uvBottomRight, 32, false);
        encoder0.encode(this.backgroundColor, 40);
        encoder0.encode(this.protectedVideoType, 44);
        encoder0.encode(this.vertexOpacity, 48, 0, 4);
    }
}
