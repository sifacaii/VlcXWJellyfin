package org.chromium.media_session.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media_session/mojom/MediaImage.class */
public final class MediaImage extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url src;
    public String16 type;
    public Size[] sizes;

    private MediaImage(int version) {
        super(32, version);
    }

    public MediaImage() {
        this(0);
    }

    public static MediaImage deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static MediaImage deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static MediaImage decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            MediaImage result = new MediaImage(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.src = Url.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.type = String16.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, false);
            DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
            result.sizes = new Size[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder13.readPointer(8 + (8 * i1), false);
                result.sizes[i1] = Size.decode(decoder2);
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
        encoder0.encode((Struct) this.src, 8, false);
        encoder0.encode((Struct) this.type, 16, false);
        if (this.sizes == null) {
            encoder0.encodeNullPointer(24, false);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.sizes.length, 24, -1);
        for (int i0 = 0; i0 < this.sizes.length; i0++) {
            encoder1.encode((Struct) this.sizes[i0], 8 + (8 * i0), false);
        }
    }
}
