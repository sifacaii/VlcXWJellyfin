package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/EmbeddedWorkerStartTiming.class */
public final class EmbeddedWorkerStartTiming extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public TimeTicks startWorkerReceivedTime;
    public TimeTicks scriptEvaluationStartTime;
    public TimeTicks scriptEvaluationEndTime;

    private EmbeddedWorkerStartTiming(int version) {
        super(32, version);
    }

    public EmbeddedWorkerStartTiming() {
        this(0);
    }

    public static EmbeddedWorkerStartTiming deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static EmbeddedWorkerStartTiming deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static EmbeddedWorkerStartTiming decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            EmbeddedWorkerStartTiming result = new EmbeddedWorkerStartTiming(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.startWorkerReceivedTime = TimeTicks.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.scriptEvaluationStartTime = TimeTicks.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, false);
            result.scriptEvaluationEndTime = TimeTicks.decode(decoder13);
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
        encoder0.encode((Struct) this.startWorkerReceivedTime, 8, false);
        encoder0.encode((Struct) this.scriptEvaluationStartTime, 16, false);
        encoder0.encode((Struct) this.scriptEvaluationEndTime, 24, false);
    }
}
