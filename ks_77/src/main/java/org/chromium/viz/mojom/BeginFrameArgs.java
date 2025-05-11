package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.TimeTicks;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/BeginFrameArgs.class */
public final class BeginFrameArgs extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public TimeTicks frameTime;
    public TimeTicks deadline;
    public TimeDelta interval;
    public long sourceId;
    public long sequenceNumber;
    public long traceId;
    public int type;
    public boolean onCriticalPath;
    public boolean animateOnly;

    private BeginFrameArgs(int version) {
        super(64, version);
    }

    public BeginFrameArgs() {
        this(0);
    }

    public static BeginFrameArgs deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static BeginFrameArgs deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static BeginFrameArgs decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            BeginFrameArgs result = new BeginFrameArgs(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.frameTime = TimeTicks.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.deadline = TimeTicks.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, false);
            result.interval = TimeDelta.decode(decoder13);
            result.sourceId = decoder0.readLong(32);
            result.sequenceNumber = decoder0.readLong(40);
            result.traceId = decoder0.readLong(48);
            result.type = decoder0.readInt(56);
            BeginFrameArgsType.validate(result.type);
            result.onCriticalPath = decoder0.readBoolean(60, 0);
            result.animateOnly = decoder0.readBoolean(60, 1);
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
        encoder0.encode((Struct) this.frameTime, 8, false);
        encoder0.encode((Struct) this.deadline, 16, false);
        encoder0.encode((Struct) this.interval, 24, false);
        encoder0.encode(this.sourceId, 32);
        encoder0.encode(this.sequenceNumber, 40);
        encoder0.encode(this.traceId, 48);
        encoder0.encode(this.type, 56);
        encoder0.encode(this.onCriticalPath, 60, 0);
        encoder0.encode(this.animateOnly, 60, 1);
    }
}
