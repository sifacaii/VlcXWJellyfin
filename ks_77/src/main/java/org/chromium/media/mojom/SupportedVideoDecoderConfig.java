package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/SupportedVideoDecoderConfig.class */
public final class SupportedVideoDecoderConfig extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int profileMin;
    public int profileMax;
    public Size codedSizeMin;
    public Size codedSizeMax;
    public boolean allowEncrypted;
    public boolean requireEncrypted;

    private SupportedVideoDecoderConfig(int version) {
        super(40, version);
    }

    public SupportedVideoDecoderConfig() {
        this(0);
    }

    public static SupportedVideoDecoderConfig deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SupportedVideoDecoderConfig deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SupportedVideoDecoderConfig decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SupportedVideoDecoderConfig result = new SupportedVideoDecoderConfig(elementsOrVersion);
            result.profileMin = decoder0.readInt(8);
            VideoCodecProfile.validate(result.profileMin);
            result.profileMax = decoder0.readInt(12);
            VideoCodecProfile.validate(result.profileMax);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.codedSizeMin = Size.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.codedSizeMax = Size.decode(decoder12);
            result.allowEncrypted = decoder0.readBoolean(32, 0);
            result.requireEncrypted = decoder0.readBoolean(32, 1);
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
        encoder0.encode(this.profileMin, 8);
        encoder0.encode(this.profileMax, 12);
        encoder0.encode((Struct) this.codedSizeMin, 16, false);
        encoder0.encode((Struct) this.codedSizeMax, 24, false);
        encoder0.encode(this.allowEncrypted, 32, 0);
        encoder0.encode(this.requireEncrypted, 32, 1);
    }
}
