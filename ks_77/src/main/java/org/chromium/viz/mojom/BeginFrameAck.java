package org.chromium.viz.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/viz/mojom/BeginFrameAck.class */
public final class BeginFrameAck extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public long sourceId;
    public long sequenceNumber;
    public long traceId;
    public boolean hasDamage;

    private BeginFrameAck(int version) {
        super(40, version);
    }

    public BeginFrameAck() {
        this(0);
    }

    public static BeginFrameAck deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static BeginFrameAck deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static BeginFrameAck decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            BeginFrameAck result = new BeginFrameAck(elementsOrVersion);
            result.sourceId = decoder0.readLong(8);
            result.sequenceNumber = decoder0.readLong(16);
            result.traceId = decoder0.readLong(24);
            result.hasDamage = decoder0.readBoolean(32, 0);
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
        encoder0.encode(this.sourceId, 8);
        encoder0.encode(this.sequenceNumber, 16);
        encoder0.encode(this.traceId, 24);
        encoder0.encode(this.hasDamage, 32, 0);
    }
}
