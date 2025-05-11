package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/VideoEncodeAcceleratorSupportedProfile.class */
public final class VideoEncodeAcceleratorSupportedProfile extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int profile;
    public Size maxResolution;
    public int maxFramerateNumerator;
    public int maxFramerateDenominator;

    private VideoEncodeAcceleratorSupportedProfile(int version) {
        super(32, version);
    }

    public VideoEncodeAcceleratorSupportedProfile() {
        this(0);
    }

    public static VideoEncodeAcceleratorSupportedProfile deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoEncodeAcceleratorSupportedProfile deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoEncodeAcceleratorSupportedProfile decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoEncodeAcceleratorSupportedProfile result = new VideoEncodeAcceleratorSupportedProfile(elementsOrVersion);
            result.profile = decoder0.readInt(8);
            VideoCodecProfile.validate(result.profile);
            result.maxFramerateNumerator = decoder0.readInt(12);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.maxResolution = Size.decode(decoder1);
            result.maxFramerateDenominator = decoder0.readInt(24);
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
        encoder0.encode(this.maxFramerateNumerator, 12);
        encoder0.encode((Struct) this.maxResolution, 16, false);
        encoder0.encode(this.maxFramerateDenominator, 24);
    }
}
