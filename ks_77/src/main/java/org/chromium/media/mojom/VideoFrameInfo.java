package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoFrameInfo.class */
public final class VideoFrameInfo extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public TimeDelta timestamp;
    public DictionaryValue metadata;
    public int pixelFormat;
    public Size codedSize;
    public Rect visibleRect;
    public org.chromium.gfx.mojom.ColorSpace colorSpace;
    public PlaneStrides strides;

    private VideoFrameInfo(int version) {
        super(64, version);
    }

    public VideoFrameInfo() {
        this(0);
    }

    public static VideoFrameInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoFrameInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoFrameInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoFrameInfo result = new VideoFrameInfo(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.timestamp = TimeDelta.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.metadata = DictionaryValue.decode(decoder12);
            result.pixelFormat = decoder0.readInt(24);
            VideoCapturePixelFormat.validate(result.pixelFormat);
            Decoder decoder13 = decoder0.readPointer(32, false);
            result.codedSize = Size.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(40, false);
            result.visibleRect = Rect.decode(decoder14);
            Decoder decoder15 = decoder0.readPointer(48, true);
            result.colorSpace = org.chromium.gfx.mojom.ColorSpace.decode(decoder15);
            Decoder decoder16 = decoder0.readPointer(56, true);
            result.strides = PlaneStrides.decode(decoder16);
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
        encoder0.encode((Struct) this.timestamp, 8, false);
        encoder0.encode((Struct) this.metadata, 16, false);
        encoder0.encode(this.pixelFormat, 24);
        encoder0.encode((Struct) this.codedSize, 32, false);
        encoder0.encode((Struct) this.visibleRect, 40, false);
        encoder0.encode((Struct) this.colorSpace, 48, true);
        encoder0.encode((Struct) this.strides, 56, true);
    }
}
