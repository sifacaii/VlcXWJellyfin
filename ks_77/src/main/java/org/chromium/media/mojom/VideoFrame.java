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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.DictionaryValue;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/VideoFrame.class */
public final class VideoFrame extends Struct {
    private static final int STRUCT_SIZE = 80;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(80, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int format;
    public Size codedSize;
    public Rect visibleRect;
    public Size naturalSize;
    public TimeDelta timestamp;
    public VideoFrameData data;
    public DictionaryValue metadata;
    public org.chromium.gfx.mojom.ColorSpace colorSpace;

    private VideoFrame(int version) {
        super(80, version);
    }

    public VideoFrame() {
        this(0);
    }

    public static VideoFrame deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoFrame deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoFrame decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoFrame result = new VideoFrame(elementsOrVersion);
            result.format = decoder0.readInt(8);
            VideoPixelFormat.validate(result.format);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.codedSize = Size.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(24, false);
            result.visibleRect = Rect.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(32, false);
            result.naturalSize = Size.decode(decoder13);
            Decoder decoder14 = decoder0.readPointer(40, false);
            result.timestamp = TimeDelta.decode(decoder14);
            result.data = VideoFrameData.decode(decoder0, 48);
            Decoder decoder15 = decoder0.readPointer(64, false);
            result.metadata = DictionaryValue.decode(decoder15);
            Decoder decoder16 = decoder0.readPointer(72, false);
            result.colorSpace = org.chromium.gfx.mojom.ColorSpace.decode(decoder16);
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
        encoder0.encode(this.format, 8);
        encoder0.encode((Struct) this.codedSize, 16, false);
        encoder0.encode((Struct) this.visibleRect, 24, false);
        encoder0.encode((Struct) this.naturalSize, 32, false);
        encoder0.encode((Struct) this.timestamp, 40, false);
        encoder0.encode((Union) this.data, 48, false);
        encoder0.encode((Struct) this.metadata, 64, false);
        encoder0.encode((Struct) this.colorSpace, 72, false);
    }
}
