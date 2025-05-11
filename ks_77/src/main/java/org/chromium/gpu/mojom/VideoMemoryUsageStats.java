package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/VideoMemoryUsageStats.class */
public final class VideoMemoryUsageStats extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Map<Integer, VideoMemoryProcessStats> processMap;
    public long bytesAllocated;

    private VideoMemoryUsageStats(int version) {
        super(24, version);
    }

    public VideoMemoryUsageStats() {
        this(0);
    }

    public static VideoMemoryUsageStats deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VideoMemoryUsageStats deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VideoMemoryUsageStats decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VideoMemoryUsageStats result = new VideoMemoryUsageStats(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            decoder1.readDataHeaderForMap();
            int[] keys0 = decoder1.readInts(8, 0, -1);
            Decoder decoder2 = decoder1.readPointer(16, false);
            DataHeader si2 = decoder2.readDataHeaderForPointerArray(keys0.length);
            VideoMemoryProcessStats[] values0 = new VideoMemoryProcessStats[si2.elementsOrVersion];
            for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
                Decoder decoder3 = decoder2.readPointer(8 + (8 * i2), false);
                values0[i2] = VideoMemoryProcessStats.decode(decoder3);
            }
            result.processMap = new HashMap();
            for (int index0 = 0; index0 < keys0.length; index0++) {
                result.processMap.put(Integer.valueOf(keys0[index0]), values0[index0]);
            }
            result.bytesAllocated = decoder0.readLong(16);
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
        if (this.processMap == null) {
            encoder0.encodeNullPointer(8, false);
        } else {
            Encoder encoder1 = encoder0.encoderForMap(8);
            int size0 = this.processMap.size();
            int[] keys0 = new int[size0];
            VideoMemoryProcessStats[] values0 = new VideoMemoryProcessStats[size0];
            int index0 = 0;
            for (Map.Entry<Integer, VideoMemoryProcessStats> entry0 : this.processMap.entrySet()) {
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
        encoder0.encode(this.bytesAllocated, 16);
    }
}
