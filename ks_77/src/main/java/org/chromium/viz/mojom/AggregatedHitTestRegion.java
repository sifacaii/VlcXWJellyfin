package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Transform;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/AggregatedHitTestRegion.class */
public final class AggregatedHitTestRegion extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public FrameSinkId frameSinkId;
    public int flags;
    public int asyncHitTestReasons;
    public Rect rect;
    public int childCount;
    public Transform transform;

    private AggregatedHitTestRegion(int version) {
        super(48, version);
    }

    public AggregatedHitTestRegion() {
        this(0);
    }

    public static AggregatedHitTestRegion deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static AggregatedHitTestRegion deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static AggregatedHitTestRegion decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            AggregatedHitTestRegion result = new AggregatedHitTestRegion(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.frameSinkId = FrameSinkId.decode(decoder1);
            result.flags = decoder0.readInt(16);
            result.asyncHitTestReasons = decoder0.readInt(20);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.rect = Rect.decode(decoder12);
            result.childCount = decoder0.readInt(32);
            Decoder decoder13 = decoder0.readPointer(40, false);
            result.transform = Transform.decode(decoder13);
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
        encoder0.encode((Struct) this.frameSinkId, 8, false);
        encoder0.encode(this.flags, 16);
        encoder0.encode(this.asyncHitTestReasons, 20);
        encoder0.encode((Struct) this.rect, 24, false);
        encoder0.encode(this.childCount, 32);
        encoder0.encode((Struct) this.transform, 40, false);
    }
}
