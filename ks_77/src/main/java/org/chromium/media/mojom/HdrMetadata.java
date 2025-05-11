package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/HdrMetadata.class */
public final class HdrMetadata extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public MasteringMetadata masteringMetadata;
    public int maxContentLightLevel;
    public int maxFrameAverageLightLevel;

    private HdrMetadata(int version) {
        super(24, version);
    }

    public HdrMetadata() {
        this(0);
    }

    public static HdrMetadata deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static HdrMetadata deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static HdrMetadata decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            HdrMetadata result = new HdrMetadata(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.masteringMetadata = MasteringMetadata.decode(decoder1);
            result.maxContentLightLevel = decoder0.readInt(16);
            result.maxFrameAverageLightLevel = decoder0.readInt(20);
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
        encoder0.encode((Struct) this.masteringMetadata, 8, false);
        encoder0.encode(this.maxContentLightLevel, 16);
        encoder0.encode(this.maxFrameAverageLightLevel, 20);
    }
}
