package org.chromium.service_manager.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/service_manager/mojom/CapabilitySet.class */
public final class CapabilitySet extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String[] capabilities;

    private CapabilitySet(int version) {
        super(16, version);
    }

    public CapabilitySet() {
        this(0);
    }

    public static CapabilitySet deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CapabilitySet deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CapabilitySet decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CapabilitySet result = new CapabilitySet(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.capabilities = new String[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                result.capabilities[i1] = decoder1.readString(8 + (8 * i1), false);
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
        if (this.capabilities == null) {
            encoder0.encodeNullPointer(8, false);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.capabilities.length, 8, -1);
        for (int i0 = 0; i0 < this.capabilities.length; i0++) {
            encoder1.encode(this.capabilities[i0], 8 + (8 * i0), false);
        }
    }
}
