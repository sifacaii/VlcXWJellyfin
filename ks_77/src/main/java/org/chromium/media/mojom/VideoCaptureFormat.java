package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoCaptureFormat.class */
public final class VideoCaptureFormat extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Size frameSize;
    public float frameRate;
    public int pixelFormat;

    private VideoCaptureFormat(int version) {
        super(24, version);
    }

    public VideoCaptureFormat() {
        this(0);
    }

    public static VideoCaptureFormat deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoCaptureFormat deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoCaptureFormat decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoCaptureFormat result = new VideoCaptureFormat(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.frameSize = Size.decode(decoder1);
            result.frameRate = decoder0.readFloat(16);
            result.pixelFormat = decoder0.readInt(20);
            VideoCapturePixelFormat.validate(result.pixelFormat);
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
        encoder0.encode((Struct) this.frameSize, 8, false);
        encoder0.encode(this.frameRate, 16);
        encoder0.encode(this.pixelFormat, 20);
    }
}
