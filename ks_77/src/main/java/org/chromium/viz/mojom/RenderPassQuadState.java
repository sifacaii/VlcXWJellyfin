package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
import org.chromium.gfx.mojom.Size;
import org.chromium.gfx.mojom.Vector2dF;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/RenderPassQuadState.class */
public final class RenderPassQuadState extends Struct {
    private static final int STRUCT_SIZE = 72;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(72, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public long renderPassId;
    public int maskResourceId;
    public RectF maskUvRect;
    public Size maskTextureSize;
    public boolean maskAppliesToBackdrop;
    public Vector2dF filtersScale;
    public PointF filtersOrigin;
    public RectF texCoordRect;
    public boolean forceAntiAliasingOff;
    public float backdropFilterQuality;

    private RenderPassQuadState(int version) {
        super(72, version);
    }

    public RenderPassQuadState() {
        this(0);
    }

    public static RenderPassQuadState deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static RenderPassQuadState deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static RenderPassQuadState decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            RenderPassQuadState result = new RenderPassQuadState(elementsOrVersion);
            result.renderPassId = decoder0.readLong(8);
            result.maskResourceId = decoder0.readInt(16);
            result.maskAppliesToBackdrop = decoder0.readBoolean(20, 0);
            result.forceAntiAliasingOff = decoder0.readBoolean(20, 1);
            Decoder decoder1 = decoder0.readPointer(24, false);
            result.maskUvRect = RectF.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(32, false);
            result.maskTextureSize = Size.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(40, false);
            result.filtersScale = Vector2dF.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(48, false);
            result.filtersOrigin = PointF.decode(decoder14);
            Decoder decoder15 = decoder0.readPointer(56, false);
            result.texCoordRect = RectF.decode(decoder15);
            result.backdropFilterQuality = decoder0.readFloat(64);
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
        encoder0.encode(this.renderPassId, 8);
        encoder0.encode(this.maskResourceId, 16);
        encoder0.encode(this.maskAppliesToBackdrop, 20, 0);
        encoder0.encode(this.forceAntiAliasingOff, 20, 1);
        encoder0.encode((Struct) this.maskUvRect, 24, false);
        encoder0.encode((Struct) this.maskTextureSize, 32, false);
        encoder0.encode((Struct) this.filtersScale, 40, false);
        encoder0.encode((Struct) this.filtersOrigin, 48, false);
        encoder0.encode((Struct) this.texCoordRect, 56, false);
        encoder0.encode(this.backdropFilterQuality, 64);
    }
}
