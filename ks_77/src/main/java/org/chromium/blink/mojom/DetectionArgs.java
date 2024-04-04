package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/DetectionArgs.class */
public final class DetectionArgs extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public long blinkWorkloadThreshold;
    public long privateFootprintThreshold;
    public long swapThreshold;
    public long virtualMemoryThresold;

    private DetectionArgs(int version) {
        super(40, version);
    }

    public DetectionArgs() {
        this(0);
    }

    public static DetectionArgs deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static DetectionArgs deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static DetectionArgs decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            DetectionArgs result = new DetectionArgs(elementsOrVersion);
            result.blinkWorkloadThreshold = decoder0.readLong(8);
            result.privateFootprintThreshold = decoder0.readLong(16);
            result.swapThreshold = decoder0.readLong(24);
            result.virtualMemoryThresold = decoder0.readLong(32);
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
        encoder0.encode(this.blinkWorkloadThreshold, 8);
        encoder0.encode(this.privateFootprintThreshold, 16);
        encoder0.encode(this.swapThreshold, 24);
        encoder0.encode(this.virtualMemoryThresold, 32);
    }
}
