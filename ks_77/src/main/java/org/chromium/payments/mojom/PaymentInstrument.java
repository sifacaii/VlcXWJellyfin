package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.mojom.ManifestImageResource;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentInstrument.class */
public final class PaymentInstrument extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String name;
    public ManifestImageResource[] icons;
    public String method;
    public String stringifiedCapabilities;
    public int[] supportedNetworks;
    public int[] supportedTypes;

    private PaymentInstrument(int version) {
        super(56, version);
    }

    public PaymentInstrument() {
        this(0);
    }

    public static PaymentInstrument deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PaymentInstrument deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentInstrument decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PaymentInstrument result = new PaymentInstrument(elementsOrVersion);
            result.name = decoder0.readString(8, false);
            Decoder decoder1 = decoder0.readPointer(16, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.icons = new ManifestImageResource[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.icons[i1] = ManifestImageResource.decode(decoder2);
            }
            result.method = decoder0.readString(24, false);
            result.stringifiedCapabilities = decoder0.readString(32, false);
            result.supportedNetworks = decoder0.readInts(40, 0, -1);
            for (int i0 = 0; i0 < result.supportedNetworks.length; i0++) {
                BasicCardNetwork.validate(result.supportedNetworks[i0]);
            }
            result.supportedTypes = decoder0.readInts(48, 0, -1);
            for (int i02 = 0; i02 < result.supportedTypes.length; i02++) {
                BasicCardType.validate(result.supportedTypes[i02]);
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
        encoder0.encode(this.name, 8, false);
        if (this.icons == null) {
            encoder0.encodeNullPointer(16, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.icons.length, 16, -1);
            for (int i0 = 0; i0 < this.icons.length; i0++) {
                encoder1.encode((Struct) this.icons[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.method, 24, false);
        encoder0.encode(this.stringifiedCapabilities, 32, false);
        encoder0.encode(this.supportedNetworks, 40, 0, -1);
        encoder0.encode(this.supportedTypes, 48, 0, -1);
    }
}
