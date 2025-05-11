package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/CanMakePaymentEventData.class */
public final class CanMakePaymentEventData extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public Url topOrigin;
    public Url paymentRequestOrigin;
    public PaymentMethodData[] methodData;
    public PaymentDetailsModifier[] modifiers;

    private CanMakePaymentEventData(int version) {
        super(40, version);
    }

    public CanMakePaymentEventData() {
        this(0);
    }

    public static CanMakePaymentEventData deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CanMakePaymentEventData deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CanMakePaymentEventData decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CanMakePaymentEventData result = new CanMakePaymentEventData(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.topOrigin = Url.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.paymentRequestOrigin = Url.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(24, false);
            DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
            result.methodData = new PaymentMethodData[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder13.readPointer(8 + (8 * i1), false);
                result.methodData[i1] = PaymentMethodData.decode(decoder2);
            }
            Decoder decoder14 = decoder0.readPointer(32, false);
            DataHeader si12 = decoder14.readDataHeaderForPointerArray(-1);
            result.modifiers = new PaymentDetailsModifier[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder14.readPointer(8 + (8 * i12), false);
                result.modifiers[i12] = PaymentDetailsModifier.decode(decoder22);
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
        encoder0.encode((Struct) this.topOrigin, 8, false);
        encoder0.encode((Struct) this.paymentRequestOrigin, 16, false);
        if (this.methodData == null) {
            encoder0.encodeNullPointer(24, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.methodData.length, 24, -1);
            for (int i0 = 0; i0 < this.methodData.length; i0++) {
                encoder1.encode((Struct) this.methodData[i0], 8 + (8 * i0), false);
            }
        }
        if (this.modifiers == null) {
            encoder0.encodeNullPointer(32, false);
            return;
        }
        Encoder encoder12 = encoder0.encodePointerArray(this.modifiers.length, 32, -1);
        for (int i02 = 0; i02 < this.modifiers.length; i02++) {
            encoder12.encode((Struct) this.modifiers[i02], 8 + (8 * i02), false);
        }
    }
}
