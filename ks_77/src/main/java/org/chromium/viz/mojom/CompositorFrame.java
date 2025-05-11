package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/CompositorFrame.class */
public final class CompositorFrame extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public CompositorFrameMetadata metadata;
    public TransferableResource[] resources;
    public RenderPass[] passes;

    private CompositorFrame(int version) {
        super(32, version);
    }

    public CompositorFrame() {
        this(0);
    }

    public static CompositorFrame deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CompositorFrame deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CompositorFrame decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CompositorFrame result = new CompositorFrame(elementsOrVersion);
            result.metadata = CompositorFrameMetadata.decode(decoder0.readPointer(8, false));
            Decoder decoder1 = decoder0.readPointer(16, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.resources = new TransferableResource[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.resources[i1] = TransferableResource.decode(decoder2);
            }
            Decoder decoder12 = decoder0.readPointer(24, false);
            DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
            result.passes = new RenderPass[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder12.readPointer(8 + (8 * i12), false);
                result.passes[i12] = RenderPass.decode(decoder22);
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
        encoder0.encode((Struct) this.metadata, 8, false);
        if (this.resources == null) {
            encoder0.encodeNullPointer(16, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.resources.length, 16, -1);
            for (int i0 = 0; i0 < this.resources.length; i0++) {
                encoder1.encode((Struct) this.resources[i0], 8 + (8 * i0), false);
            }
        }
        if (this.passes == null) {
            encoder0.encodeNullPointer(24, false);
            return;
        }
        Encoder encoder12 = encoder0.encodePointerArray(this.passes.length, 24, -1);
        for (int i02 = 0; i02 < this.passes.length; i02++) {
            encoder12.encode((Struct) this.passes[i02], 8 + (8 * i02), false);
        }
    }
}
