package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.BufferFormat;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/GpuFeatureInfo.class */
public final class GpuFeatureInfo extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int[] statusValues;
    public int[] enabledGpuDriverBugWorkarounds;
    public String disabledExtensions;
    public String disabledWebglExtensions;
    public int[] appliedGpuBlacklistEntries;
    public int[] appliedGpuDriverBugListEntries;
    public int[] supportedBufferFormatsForAllocationAndTexturing;

    private GpuFeatureInfo(int version) {
        super(64, version);
    }

    public GpuFeatureInfo() {
        this(0);
    }

    public static GpuFeatureInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static GpuFeatureInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static GpuFeatureInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            GpuFeatureInfo result = new GpuFeatureInfo(elementsOrVersion);
            result.statusValues = decoder0.readInts(8, 0, -1);
            for (int i0 = 0; i0 < result.statusValues.length; i0++) {
                GpuFeatureStatus.validate(result.statusValues[i0]);
            }
            result.enabledGpuDriverBugWorkarounds = decoder0.readInts(16, 0, -1);
            result.disabledExtensions = decoder0.readString(24, false);
            result.disabledWebglExtensions = decoder0.readString(32, false);
            result.appliedGpuBlacklistEntries = decoder0.readInts(40, 0, -1);
            result.appliedGpuDriverBugListEntries = decoder0.readInts(48, 0, -1);
            result.supportedBufferFormatsForAllocationAndTexturing = decoder0.readInts(56, 0, -1);
            for (int i02 = 0; i02 < result.supportedBufferFormatsForAllocationAndTexturing.length; i02++) {
                BufferFormat.validate(result.supportedBufferFormatsForAllocationAndTexturing[i02]);
            }
            return result;
        } finally {
            decoder0.decreaseStackDepth();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.chromium.mojo.bindings.Struct
    public final void encode(Encoder encoder) {
        Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        encoder0.encode(this.statusValues, 8, 0, -1);
        encoder0.encode(this.enabledGpuDriverBugWorkarounds, 16, 0, -1);
        encoder0.encode(this.disabledExtensions, 24, false);
        encoder0.encode(this.disabledWebglExtensions, 32, false);
        encoder0.encode(this.appliedGpuBlacklistEntries, 40, 0, -1);
        encoder0.encode(this.appliedGpuDriverBugListEntries, 48, 0, -1);
        encoder0.encode(this.supportedBufferFormatsForAllocationAndTexturing, 56, 0, -1);
    }
}
