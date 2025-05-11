package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.RRectF;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Transform;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/SharedQuadState.class */
public final class SharedQuadState extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Transform quadToTargetTransform;
    public Rect quadLayerRect;
    public Rect visibleQuadLayerRect;
    public RRectF roundedCornerBounds;
    public Rect clipRect;
    public boolean isClipped;
    public boolean areContentsOpaque;
    public float opacity;
    public int blendMode;
    public int sortingContextId;

    private SharedQuadState(int version) {
        super(64, version);
    }

    public SharedQuadState() {
        this(0);
    }

    public static SharedQuadState deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SharedQuadState deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedQuadState decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SharedQuadState result = new SharedQuadState(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.quadToTargetTransform = Transform.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.quadLayerRect = Rect.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, false);
            result.visibleQuadLayerRect = Rect.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(32, false);
            result.roundedCornerBounds = RRectF.decode(decoder14);
            Decoder decoder15 = decoder0.readPointer(40, false);
            result.clipRect = Rect.decode(decoder15);
            result.isClipped = decoder0.readBoolean(48, 0);
            result.areContentsOpaque = decoder0.readBoolean(48, 1);
            result.opacity = decoder0.readFloat(52);
            result.blendMode = decoder0.readInt(56);
            result.sortingContextId = decoder0.readInt(60);
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
        encoder0.encode((Struct) this.quadToTargetTransform, 8, false);
        encoder0.encode((Struct) this.quadLayerRect, 16, false);
        encoder0.encode((Struct) this.visibleQuadLayerRect, 24, false);
        encoder0.encode((Struct) this.roundedCornerBounds, 32, false);
        encoder0.encode((Struct) this.clipRect, 40, false);
        encoder0.encode(this.isClipped, 48, 0);
        encoder0.encode(this.areContentsOpaque, 48, 1);
        encoder0.encode(this.opacity, 52);
        encoder0.encode(this.blendMode, 56);
        encoder0.encode(this.sortingContextId, 60);
    }
}
