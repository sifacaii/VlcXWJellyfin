package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Origin;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ClearDataFilter.class */
public final class ClearDataFilter extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int type;
    public String[] domains;
    public Origin[] origins;

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/ClearDataFilter$Type.class */
    public static final class Type {
        private static final boolean IS_EXTENSIBLE = false;
        public static final int DELETE_MATCHES = 0;
        public static final int KEEP_MATCHES = 1;

        public static boolean isKnownValue(int value) {
            return value >= 0 && value <= 1;
        }

        public static void validate(int value) {
            if (!isKnownValue(value)) {
                throw new DeserializationException("Invalid enum value.");
            }
        }

        private Type() {
        }
    }

    private ClearDataFilter(int version) {
        super(32, version);
    }

    public ClearDataFilter() {
        this(0);
    }

    public static ClearDataFilter deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static ClearDataFilter deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static ClearDataFilter decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            ClearDataFilter result = new ClearDataFilter(elementsOrVersion);
            result.type = decoder0.readInt(8);
            Type.validate(result.type);
            Decoder decoder1 = decoder0.readPointer(16, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.domains = new String[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                result.domains[i1] = decoder1.readString(8 + (8 * i1), false);
            }
            Decoder decoder12 = decoder0.readPointer(24, false);
            DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
            result.origins = new Origin[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder2 = decoder12.readPointer(8 + (8 * i12), false);
                result.origins[i12] = Origin.decode(decoder2);
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
        encoder0.encode(this.type, 8);
        if (this.domains == null) {
            encoder0.encodeNullPointer(16, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.domains.length, 16, -1);
            for (int i0 = 0; i0 < this.domains.length; i0++) {
                encoder1.encode(this.domains[i0], 8 + (8 * i0), false);
            }
        }
        if (this.origins == null) {
            encoder0.encodeNullPointer(24, false);
            return;
        }
        Encoder encoder12 = encoder0.encodePointerArray(this.origins.length, 24, -1);
        for (int i02 = 0; i02 < this.origins.length; i02++) {
            encoder12.encode((Struct) this.origins[i02], 8 + (8 * i02), false);
        }
    }
}
