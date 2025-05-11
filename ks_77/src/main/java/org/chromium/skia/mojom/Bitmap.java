package org.chromium.skia.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.BigBuffer;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/skia/mojom/Bitmap.class */
public final class Bitmap extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public ImageInfo imageInfo;
    public long rowBytes;
    public BigBuffer pixelData;

    private Bitmap(int version) {
        super(40, version);
    }

    public Bitmap() {
        this(0);
    }

    public static Bitmap deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static Bitmap deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static Bitmap decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            Bitmap result = new Bitmap(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.imageInfo = ImageInfo.decode(decoder1);
            result.rowBytes = decoder0.readLong(16);
            result.pixelData = BigBuffer.decode(decoder0, 24);
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
        encoder0.encode((Union) this.pixelData, 24, false);
    }
}
