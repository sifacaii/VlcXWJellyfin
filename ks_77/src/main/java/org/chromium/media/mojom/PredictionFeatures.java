package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PredictionFeatures.class */
public final class PredictionFeatures extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int profile;
    public Size videoSize;
    public int framesPerSec;
    public String keySystem;
    public boolean useHwSecureCodecs;

    private PredictionFeatures(int version) {
        super(40, version);
        this.framesPerSec = 0;
        this.useHwSecureCodecs = false;
    }

    public PredictionFeatures() {
        this(0);
    }

    public static PredictionFeatures deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PredictionFeatures deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PredictionFeatures decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PredictionFeatures result = new PredictionFeatures(elementsOrVersion);
            result.profile = decoder0.readInt(8);
            VideoCodecProfile.validate(result.profile);
            result.framesPerSec = decoder0.readInt(12);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.videoSize = Size.decode(decoder1);
            result.keySystem = decoder0.readString(24, false);
            result.useHwSecureCodecs = decoder0.readBoolean(32, 0);
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
        encoder0.encode(this.profile, 8);
        encoder0.encode(this.framesPerSec, 12);
        encoder0.encode((Struct) this.videoSize, 16, false);
        encoder0.encode(this.keySystem, 24, false);
        encoder0.encode(this.useHwSecureCodecs, 32, 0);
    }
}
