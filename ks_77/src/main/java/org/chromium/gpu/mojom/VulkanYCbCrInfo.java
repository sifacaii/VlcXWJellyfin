package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/gpu/mojom/VulkanYCbCrInfo.class */
public final class VulkanYCbCrInfo extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int suggestedYcbcrModel;
    public int suggestedYcbcrRange;
    public int suggestedXchromaOffset;
    public int suggestedYchromaOffset;
    public long externalFormat;
    public int formatFeatures;

    private VulkanYCbCrInfo(int version) {
        super(40, version);
    }

    public VulkanYCbCrInfo() {
        this(0);
    }

    public static VulkanYCbCrInfo deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VulkanYCbCrInfo deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VulkanYCbCrInfo decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VulkanYCbCrInfo result = new VulkanYCbCrInfo(elementsOrVersion);
            result.suggestedYcbcrModel = decoder0.readInt(8);
            result.suggestedYcbcrRange = decoder0.readInt(12);
            result.suggestedXchromaOffset = decoder0.readInt(16);
            result.suggestedYchromaOffset = decoder0.readInt(20);
            result.externalFormat = decoder0.readLong(24);
            result.formatFeatures = decoder0.readInt(32);
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
        encoder0.encode(this.suggestedYcbcrModel, 8);
        encoder0.encode(this.suggestedYcbcrRange, 12);
        encoder0.encode(this.suggestedXchromaOffset, 16);
        encoder0.encode(this.suggestedYchromaOffset, 20);
        encoder0.encode(this.externalFormat, 24);
        encoder0.encode(this.formatFeatures, 32);
    }
}
