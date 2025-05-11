package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.Size;
import org.chromium.gpu.mojom.VulkanYCbCrInfo;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/StreamVideoQuadState.class */
public final class StreamVideoQuadState extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int resourceId;
    public Size resourceSizeInPixels;
    public PointF uvTopLeft;
    public PointF uvBottomRight;
    public VulkanYCbCrInfo ycbcrInfo;

    private StreamVideoQuadState(int version) {
        super(48, version);
    }

    public StreamVideoQuadState() {
        this(0);
    }

    public static StreamVideoQuadState deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static StreamVideoQuadState deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static StreamVideoQuadState decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            StreamVideoQuadState result = new StreamVideoQuadState(elementsOrVersion);
            result.resourceId = decoder0.readInt(8);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.resourceSizeInPixels = Size.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.uvTopLeft = PointF.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, false);
            result.uvBottomRight = PointF.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(40, true);
            result.ycbcrInfo = VulkanYCbCrInfo.decode(decoder14);
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
        encoder0.encode((Struct) this.resourceSizeInPixels, 16, false);
        encoder0.encode((Struct) this.uvTopLeft, 24, false);
        encoder0.encode((Struct) this.uvBottomRight, 32, false);
        encoder0.encode((Struct) this.ycbcrInfo, 40, true);
    }
}
