package org.chromium.gfx.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.TimeTicks;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gfx/mojom/PresentationFeedback.class */
public final class PresentationFeedback extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public TimeTicks timestamp;
    public TimeDelta interval;
    public int flags;

    private PresentationFeedback(int version) {
        super(32, version);
    }

    public PresentationFeedback() {
        this(0);
    }

    public static PresentationFeedback deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PresentationFeedback deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PresentationFeedback decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PresentationFeedback result = new PresentationFeedback(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.timestamp = TimeTicks.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.interval = TimeDelta.decode(decoder12);
            result.flags = decoder0.readInt(24);
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
        encoder0.encode((Struct) this.interval, 16, false);
        encoder0.encode(this.flags, 24);
    }
}
