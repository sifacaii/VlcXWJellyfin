package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/DecryptConfig.class */
public final class DecryptConfig extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int encryptionMode;
    public String keyId;
    public String iv;
    public SubsampleEntry[] subsamples;
    public EncryptionPattern encryptionPattern;

    private DecryptConfig(int version) {
        super(48, version);
    }

    public DecryptConfig() {
        this(0);
    }

    public static DecryptConfig deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DecryptConfig deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DecryptConfig decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            DecryptConfig result = new DecryptConfig(elementsOrVersion);
            result.encryptionMode = decoder0.readInt(8);
            EncryptionMode.validate(result.encryptionMode);
            result.keyId = decoder0.readString(16, false);
            result.iv = decoder0.readString(24, false);
            Decoder decoder1 = decoder0.readPointer(32, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.subsamples = new SubsampleEntry[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.subsamples[i1] = SubsampleEntry.decode(decoder2);
            }
            result.encryptionPattern = EncryptionPattern.decode(decoder0.readPointer(40, true));
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
        encoder0.encode(this.encryptionMode, 8);
        encoder0.encode(this.keyId, 16, false);
        encoder0.encode(this.iv, 24, false);
        if (this.subsamples == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.subsamples.length, 32, -1);
            for (int i0 = 0; i0 < this.subsamples.length; i0++) {
                encoder1.encode((Struct) this.subsamples[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode((Struct) this.encryptionPattern, 40, true);
    }
}
