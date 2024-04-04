package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media_session.mojom.MediaImage;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/SpecMediaMetadata.class */
public final class SpecMediaMetadata extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String16 title;
    public String16 artist;
    public String16 album;
    public MediaImage[] artwork;

    private SpecMediaMetadata(int version) {
        super(40, version);
    }

    public SpecMediaMetadata() {
        this(0);
    }

    public static SpecMediaMetadata deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SpecMediaMetadata deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SpecMediaMetadata decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SpecMediaMetadata result = new SpecMediaMetadata(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.title = String16.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.artist = String16.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, false);
            result.album = String16.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(32, false);
            DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
            result.artwork = new MediaImage[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder14.readPointer(8 + (8 * i1), false);
                result.artwork[i1] = MediaImage.decode(decoder2);
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
        encoder0.encode((Struct) this.title, 8, false);
        encoder0.encode((Struct) this.artist, 16, false);
        encoder0.encode((Struct) this.album, 24, false);
        if (this.artwork == null) {
            encoder0.encodeNullPointer(32, false);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.artwork.length, 32, -1);
        for (int i0 = 0; i0 < this.artwork.length; i0++) {
            encoder1.encode((Struct) this.artwork[i0], 8 + (8 * i0), false);
        }
    }
}
