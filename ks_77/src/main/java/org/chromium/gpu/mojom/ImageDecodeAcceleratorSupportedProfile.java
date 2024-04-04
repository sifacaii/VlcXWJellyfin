package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/ImageDecodeAcceleratorSupportedProfile.class */
public final class ImageDecodeAcceleratorSupportedProfile extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int imageType;
    public Size minEncodedDimensions;
    public Size maxEncodedDimensions;
    public int[] subsamplings;

    private ImageDecodeAcceleratorSupportedProfile(int version) {
        super(40, version);
    }

    public ImageDecodeAcceleratorSupportedProfile() {
        this(0);
    }

    public static ImageDecodeAcceleratorSupportedProfile deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ImageDecodeAcceleratorSupportedProfile deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ImageDecodeAcceleratorSupportedProfile decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ImageDecodeAcceleratorSupportedProfile result = new ImageDecodeAcceleratorSupportedProfile(elementsOrVersion);
            result.imageType = decoder0.readInt(8);
            ImageDecodeAcceleratorType.validate(result.imageType);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.minEncodedDimensions = Size.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.maxEncodedDimensions = Size.decode(decoder12);
            result.subsamplings = decoder0.readInts(32, 0, -1);
            for (int i0 = 0; i0 < result.subsamplings.length; i0++) {
                ImageDecodeAcceleratorSubsampling.validate(result.subsamplings[i0]);
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
        encoder0.encode(this.imageType, 8);
        encoder0.encode((Struct) this.minEncodedDimensions, 16, false);
        encoder0.encode((Struct) this.maxEncodedDimensions, 24, false);
        encoder0.encode(this.subsamplings, 32, 0, -1);
    }
}
