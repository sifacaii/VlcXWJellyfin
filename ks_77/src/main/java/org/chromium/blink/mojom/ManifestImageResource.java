package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestImageResource.class */
public final class ManifestImageResource extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url src;
    public String16 type;
    public Size[] sizes;
    public int[] purpose;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/ManifestImageResource$Purpose.class */
    public static final class Purpose {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int ANY = 0;
        public static final int BADGE = 1;
        public static final int MASKABLE = 2;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 2;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Purpose() {
        }
    }

    private ManifestImageResource(int version) {
        super(40, version);
    }

    public ManifestImageResource() {
        this(0);
    }

    public static ManifestImageResource deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ManifestImageResource deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ManifestImageResource decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ManifestImageResource result = new ManifestImageResource(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.src = Url.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, true);
            result.type = String16.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, false);
            DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
            result.sizes = new Size[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder13.readPointer(8 + (8 * i1), false);
                result.sizes[i1] = Size.decode(decoder2);
            }
            result.purpose = decoder0.readInts(32, 0, -1);
            for (int i0 = 0; i0 < result.purpose.length; i0++) {
                Purpose.validate(result.purpose[i0]);
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
        encoder0.encode((Struct) this.type, 16, true);
        if (this.sizes == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.sizes.length, 24, -1);
            for (int i0 = 0; i0 < this.sizes.length; i0++) {
                encoder1.encode((Struct) this.sizes[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.purpose, 32, 0, -1);
    }
}
