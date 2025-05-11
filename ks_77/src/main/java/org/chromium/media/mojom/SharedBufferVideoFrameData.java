package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.SharedBufferHandle;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/media/mojom/SharedBufferVideoFrameData.class */
public final class SharedBufferVideoFrameData extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public SharedBufferHandle frameData;
    public long frameDataSize;
    public int yStride;
    public int uStride;
    public int vStride;
    public long yOffset;
    public long uOffset;
    public long vOffset;

    private SharedBufferVideoFrameData(int version) {
        super(56, version);
        this.frameData = InvalidHandle.INSTANCE;
    }

    public SharedBufferVideoFrameData() {
        this(0);
    }

    public static SharedBufferVideoFrameData deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static SharedBufferVideoFrameData deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static SharedBufferVideoFrameData decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            SharedBufferVideoFrameData result = new SharedBufferVideoFrameData(elementsOrVersion);
            result.frameData = decoder0.readSharedBufferHandle(8, false);
            result.yStride = decoder0.readInt(12);
            result.frameDataSize = decoder0.readLong(16);
            result.uStride = decoder0.readInt(24);
            result.vStride = decoder0.readInt(28);
            result.yOffset = decoder0.readLong(32);
            result.uOffset = decoder0.readLong(40);
            result.vOffset = decoder0.readLong(48);
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
        encoder0.encode((Handle) this.frameData, 8, false);
        encoder0.encode(this.yStride, 12);
        encoder0.encode(this.frameDataSize, 16);
        encoder0.encode(this.uStride, 24);
        encoder0.encode(this.vStride, 28);
        encoder0.encode(this.yOffset, 32);
        encoder0.encode(this.uOffset, 40);
        encoder0.encode(this.vOffset, 48);
    }
}
