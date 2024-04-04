package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/KeySystemCapability.class */
public final class KeySystemCapability extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int[] videoCodecs;
    public boolean supportsVp9Profile2;
    public int[] encryptionSchemes;
    public int[] hwSecureVideoCodecs;
    public int[] hwSecureEncryptionSchemes;
    public int[] sessionTypes;

    private KeySystemCapability(int version) {
        super(56, version);
    }

    public KeySystemCapability() {
        this(0);
    }

    public static KeySystemCapability deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static KeySystemCapability deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static KeySystemCapability decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            KeySystemCapability result = new KeySystemCapability(elementsOrVersion);
            result.videoCodecs = decoder0.readInts(8, 0, -1);
            for (int i0 = 0; i0 < result.videoCodecs.length; i0++) {
                VideoCodec.validate(result.videoCodecs[i0]);
            }
            result.supportsVp9Profile2 = decoder0.readBoolean(16, 0);
            result.encryptionSchemes = decoder0.readInts(24, 0, -1);
            for (int i02 = 0; i02 < result.encryptionSchemes.length; i02++) {
                EncryptionMode.validate(result.encryptionSchemes[i02]);
            }
            result.hwSecureVideoCodecs = decoder0.readInts(32, 0, -1);
            for (int i03 = 0; i03 < result.hwSecureVideoCodecs.length; i03++) {
                VideoCodec.validate(result.hwSecureVideoCodecs[i03]);
            }
            result.hwSecureEncryptionSchemes = decoder0.readInts(40, 0, -1);
            for (int i04 = 0; i04 < result.hwSecureEncryptionSchemes.length; i04++) {
                EncryptionMode.validate(result.hwSecureEncryptionSchemes[i04]);
            }
            result.sessionTypes = decoder0.readInts(48, 0, -1);
            for (int i05 = 0; i05 < result.sessionTypes.length; i05++) {
                CdmSessionType.validate(result.sessionTypes[i05]);
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
        encoder0.encode(this.videoCodecs, 8, 0, -1);
        encoder0.encode(this.supportsVp9Profile2, 16, 0);
        encoder0.encode(this.encryptionSchemes, 24, 0, -1);
        encoder0.encode(this.hwSecureVideoCodecs, 32, 0, -1);
        encoder0.encode(this.hwSecureEncryptionSchemes, 40, 0, -1);
        encoder0.encode(this.sessionTypes, 48, 0, -1);
    }
}
