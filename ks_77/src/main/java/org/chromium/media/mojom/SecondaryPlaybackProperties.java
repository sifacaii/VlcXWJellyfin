package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/SecondaryPlaybackProperties.class */
public final class SecondaryPlaybackProperties extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int audioCodec;
    public int videoCodec;
    public String audioDecoderName;
    public String videoDecoderName;
    public int audioEncryptionScheme;
    public int videoEncryptionScheme;
    public Size naturalSize;

    private SecondaryPlaybackProperties(int version) {
        super(48, version);
    }

    public SecondaryPlaybackProperties() {
        this(0);
    }

    public static SecondaryPlaybackProperties deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SecondaryPlaybackProperties deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SecondaryPlaybackProperties decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SecondaryPlaybackProperties result = new SecondaryPlaybackProperties(elementsOrVersion);
            result.audioCodec = decoder0.readInt(8);
            AudioCodec.validate(result.audioCodec);
            result.videoCodec = decoder0.readInt(12);
            VideoCodec.validate(result.videoCodec);
            result.audioDecoderName = decoder0.readString(16, false);
            result.videoDecoderName = decoder0.readString(24, false);
            result.audioEncryptionScheme = decoder0.readInt(32);
            EncryptionMode.validate(result.audioEncryptionScheme);
            result.videoEncryptionScheme = decoder0.readInt(36);
            EncryptionMode.validate(result.videoEncryptionScheme);
            Decoder decoder1 = decoder0.readPointer(40, false);
            result.naturalSize = Size.decode(decoder1);
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
        encoder0.encode(this.audioCodec, 8);
        encoder0.encode(this.videoCodec, 12);
        encoder0.encode(this.audioDecoderName, 16, false);
        encoder0.encode(this.videoDecoderName, 24, false);
        encoder0.encode(this.audioEncryptionScheme, 32);
        encoder0.encode(this.videoEncryptionScheme, 36);
        encoder0.encode((Struct) this.naturalSize, 40, false);
    }
}
