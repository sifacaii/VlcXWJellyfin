package org.chromium.skia.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/skia/mojom/ImageInfo.class */
public final class ImageInfo extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int colorType;
    public int alphaType;
    public byte[] serializedColorSpace;
    public int width;
    public int height;

    private ImageInfo(int version) {
        super(32, version);
    }

    public ImageInfo() {
        this(0);
    }

    public static ImageInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ImageInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ImageInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ImageInfo result = new ImageInfo(elementsOrVersion);
            result.colorType = decoder0.readInt(8);
            ColorType.validate(result.colorType);
            result.alphaType = decoder0.readInt(12);
            AlphaType.validate(result.alphaType);
            result.serializedColorSpace = decoder0.readBytes(16, 0, -1);
            result.width = decoder0.readInt(24);
            result.height = decoder0.readInt(28);
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
        encoder0.encode(this.colorType, 8);
        encoder0.encode(this.alphaType, 12);
        encoder0.encode(this.serializedColorSpace, 16, 0, -1);
        encoder0.encode(this.width, 24);
        encoder0.encode(this.height, 28);
    }
}
