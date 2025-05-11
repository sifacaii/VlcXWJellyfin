package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureParams.class */
public final class VideoCaptureParams extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public VideoCaptureFormat requestedFormat;
    public int bufferType;
    public int resolutionChangePolicy;
    public int powerLineFrequency;
    public boolean enableFaceDetection;

    private VideoCaptureParams(int version) {
        super(32, version);
    }

    public VideoCaptureParams() {
        this(0);
    }

    public static VideoCaptureParams deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoCaptureParams deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureParams decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoCaptureParams result = new VideoCaptureParams(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.requestedFormat = VideoCaptureFormat.decode(decoder1);
            result.bufferType = decoder0.readInt(16);
            VideoCaptureBufferType.validate(result.bufferType);
            result.resolutionChangePolicy = decoder0.readInt(20);
            ResolutionChangePolicy.validate(result.resolutionChangePolicy);
            result.powerLineFrequency = decoder0.readInt(24);
            PowerLineFrequency.validate(result.powerLineFrequency);
            result.enableFaceDetection = decoder0.readBoolean(28, 0);
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
        encoder0.encode((Struct) this.requestedFormat, 8, false);
        encoder0.encode(this.bufferType, 16);
        encoder0.encode(this.resolutionChangePolicy, 20);
        encoder0.encode(this.powerLineFrequency, 24);
        encoder0.encode(this.enableFaceDetection, 28, 0);
    }
}
