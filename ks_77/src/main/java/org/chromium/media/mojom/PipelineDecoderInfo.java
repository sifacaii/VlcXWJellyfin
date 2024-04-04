package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/PipelineDecoderInfo.class */
public final class PipelineDecoderInfo extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String decoderName;
    public boolean isPlatformDecoder;
    public boolean isDecryptingDemuxerStream;

    private PipelineDecoderInfo(int version) {
        super(24, version);
        this.isPlatformDecoder = false;
        this.isDecryptingDemuxerStream = false;
    }

    public PipelineDecoderInfo() {
        this(0);
    }

    public static PipelineDecoderInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PipelineDecoderInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PipelineDecoderInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PipelineDecoderInfo result = new PipelineDecoderInfo(elementsOrVersion);
            result.decoderName = decoder0.readString(8, false);
            result.isPlatformDecoder = decoder0.readBoolean(16, 0);
            result.isDecryptingDemuxerStream = decoder0.readBoolean(16, 1);
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
        encoder0.encode(this.decoderName, 8, false);
        encoder0.encode(this.isPlatformDecoder, 16, 0);
        encoder0.encode(this.isDecryptingDemuxerStream, 16, 1);
    }
}
