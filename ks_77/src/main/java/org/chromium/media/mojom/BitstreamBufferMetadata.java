package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/BitstreamBufferMetadata.class */
public final class BitstreamBufferMetadata extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int payloadSizeBytes;
    public boolean keyFrame;
    public TimeDelta timestamp;
    public Vp8Metadata vp8;

    private BitstreamBufferMetadata(int version) {
        super(32, version);
    }

    public BitstreamBufferMetadata() {
        this(0);
    }

    public static BitstreamBufferMetadata deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static BitstreamBufferMetadata deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static BitstreamBufferMetadata decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            BitstreamBufferMetadata result = new BitstreamBufferMetadata(elementsOrVersion);
            result.payloadSizeBytes = decoder0.readInt(8);
            result.keyFrame = decoder0.readBoolean(12, 0);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.timestamp = TimeDelta.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, true);
            result.vp8 = Vp8Metadata.decode(decoder12);
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
        encoder0.encode(this.payloadSizeBytes, 8);
        encoder0.encode(this.keyFrame, 12, 0);
        encoder0.encode((Struct) this.timestamp, 16, false);
        encoder0.encode((Struct) this.vp8, 24, true);
    }
}
