package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/EncryptionScheme.class */
public final class EncryptionScheme extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int mode;
    public EncryptionPattern pattern;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/EncryptionScheme$CipherMode.class */
    public static final class CipherMode {
        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private CipherMode() {
        }
    }

    private EncryptionScheme(int version) {
        super(24, version);
    }

    public EncryptionScheme() {
        this(0);
    }

    public static EncryptionScheme deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static EncryptionScheme deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static EncryptionScheme decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            EncryptionScheme result = new EncryptionScheme(elementsOrVersion);
            result.mode = decoder0.readInt(8);
            CipherMode.validate(result.mode);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.pattern = EncryptionPattern.decode(decoder1);
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
        encoder0.encode(this.mode, 8);
        encoder0.encode((Struct) this.pattern, 16, false);
    }
}
