package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/ui/mojom/LatencyInfo.class */
public final class LatencyInfo extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String traceName;
    public Map<Integer, TimeTicks> latencyComponents;
    public long traceId;
    public long ukmSourceId;
    public boolean coalesced;
    public boolean began;
    public boolean terminated;
    public int sourceEventType;
    public float scrollUpdateDelta;
    public float predictedScrollUpdateDelta;

    private LatencyInfo(int version) {
        super(56, version);
    }

    public LatencyInfo() {
        this(0);
    }

    public static LatencyInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static LatencyInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static LatencyInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            LatencyInfo result = new LatencyInfo(elementsOrVersion);
            result.traceName = decoder0.readString(8, false);
            Decoder decoder1 = decoder0.readPointer(16, false);
            decoder1.readDataHeaderForMap();
            int[] keys0 = decoder1.readInts(8, 0, -1);
            for (int i : keys0) {
                LatencyComponentType.validate(i);
            }
            Decoder decoder2 = decoder1.readPointer(16, false);
            DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
            TimeTicks[] values0 = new TimeTicks[si2.elementsOrVersion];
            for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                Decoder decoder3 = decoder2.readPointer(8 + (8 * i2), false);
                values0[i2] = TimeTicks.decode(decoder3);
            }
            result.latencyComponents = new HashMap();
            for (int index0 = 0; index0 < keys0.length; index0++) {
                result.latencyComponents.put(Integer.valueOf(keys0[index0]), values0[index0]);
            }
            result.traceId = decoder0.readLong(24);
            result.ukmSourceId = decoder0.readLong(32);
            result.coalesced = decoder0.readBoolean(40, 0);
            result.began = decoder0.readBoolean(40, 1);
            result.terminated = decoder0.readBoolean(40, 2);
            result.sourceEventType = decoder0.readInt(44);
            SourceEventType.validate(result.sourceEventType);
            result.scrollUpdateDelta = decoder0.readFloat(48);
            result.predictedScrollUpdateDelta = decoder0.readFloat(52);
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
        encoder0.encode(this.traceName, 8, false);
        if (this.latencyComponents == null) {
            encoder0.encodeNullPointer(16, false);
        } else {
            Encoder encoder1 = encoder0.encoderForMap(16);
            int size0 = this.latencyComponents.size();
            int[] keys0 = new int[size0];
            TimeTicks[] values0 = new TimeTicks[size0];
            int index0 = 0;
            for (Map.Entry<Integer, TimeTicks> entry0 : this.latencyComponents.entrySet()) {
                keys0[index0] = entry0.getKey().intValue();
                values0[index0] = entry0.getValue();
                index0++;
            }
            encoder1.encode(keys0, 8, 0, -1);
            Encoder encoder2 = encoder1.encodePointerArray(values0.length, 16, -1);
            for (int i1 = 0; i1 < values0.length; i1++) {
                encoder2.encode((Struct) values0[i1], 8 + (8 * i1), false);
            }
        }
        encoder0.encode(this.traceId, 24);
        encoder0.encode(this.ukmSourceId, 32);
        encoder0.encode(this.coalesced, 40, 0);
        encoder0.encode(this.began, 40, 1);
        encoder0.encode(this.terminated, 40, 2);
        encoder0.encode(this.sourceEventType, 44);
        encoder0.encode(this.scrollUpdateDelta, 48);
        encoder0.encode(this.predictedScrollUpdateDelta, 52);
    }
}
