package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/DrawQuad.class */
public final class DrawQuad extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Rect rect;
    public Rect visibleRect;
    public boolean needsBlending;
    public SharedQuadState sqs;
    public DrawQuadState drawQuadState;

    private DrawQuad(int version) {
        super(56, version);
    }

    public DrawQuad() {
        this(0);
    }

    public static DrawQuad deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DrawQuad deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DrawQuad decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            DrawQuad result = new DrawQuad(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.rect = Rect.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.visibleRect = Rect.decode(decoder12);
            result.needsBlending = decoder0.readBoolean(24, 0);
            Decoder decoder13 = decoder0.readPointer(32, true);
            result.sqs = SharedQuadState.decode(decoder13);
            result.drawQuadState = DrawQuadState.decode(decoder0, 40);
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
        encoder0.encode((Struct) this.rect, 8, false);
        encoder0.encode((Struct) this.visibleRect, 16, false);
        encoder0.encode(this.needsBlending, 24, 0);
        encoder0.encode((Struct) this.sqs, 32, true);
        encoder0.encode((Union) this.drawQuadState, 40, false);
    }
}
