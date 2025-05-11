package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/SurfaceQuadState.class */
public final class SurfaceQuadState extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public SurfaceRange surfaceRange;
    public int defaultBackgroundColor;
    public boolean stretchContentToFillBounds;
    public boolean isReflection;

    private SurfaceQuadState(int version) {
        super(24, version);
    }

    public SurfaceQuadState() {
        this(0);
    }

    public static SurfaceQuadState deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SurfaceQuadState deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SurfaceQuadState decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SurfaceQuadState result = new SurfaceQuadState(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.surfaceRange = SurfaceRange.decode(decoder1);
            result.defaultBackgroundColor = decoder0.readInt(16);
            result.stretchContentToFillBounds = decoder0.readBoolean(20, 0);
            result.isReflection = decoder0.readBoolean(20, 1);
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
        encoder0.encode((Struct) this.surfaceRange, 8, false);
        encoder0.encode(this.defaultBackgroundColor, 16);
        encoder0.encode(this.stretchContentToFillBounds, 20, 0);
        encoder0.encode(this.isReflection, 20, 1);
    }
}
