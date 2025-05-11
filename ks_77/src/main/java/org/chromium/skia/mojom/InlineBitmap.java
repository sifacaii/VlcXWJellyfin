package org.chromium.skia.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/skia/mojom/InlineBitmap.class */
public final class InlineBitmap extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public ImageInfo imageInfo;
    public long rowBytes;
    public byte[] pixelData;

    private InlineBitmap(int version) {
        super(32, version);
    }

    public InlineBitmap() {
        this(0);
    }

    public static InlineBitmap deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static InlineBitmap deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static InlineBitmap decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            InlineBitmap result = new InlineBitmap(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.imageInfo = ImageInfo.decode(decoder1);
            result.rowBytes = decoder0.readLong(16);
            result.pixelData = decoder0.readBytes(24, 0, -1);
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
        encoder0.encode((Struct) this.imageInfo, 8, false);
        encoder0.encode(this.rowBytes, 16);
        encoder0.encode(this.pixelData, 24, 0, -1);
    }
}
