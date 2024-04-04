package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentDetailsModifier.class */
public final class PaymentDetailsModifier extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public PaymentItem total;
    public PaymentItem[] additionalDisplayItems;
    public PaymentMethodData methodData;

    private PaymentDetailsModifier(int version) {
        super(32, version);
    }

    public PaymentDetailsModifier() {
        this(0);
    }

    public static PaymentDetailsModifier deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PaymentDetailsModifier deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentDetailsModifier decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PaymentDetailsModifier result = new PaymentDetailsModifier(elementsOrVersion);
            result.total = PaymentItem.decode(decoder0.readPointer(8, true));
            Decoder decoder1 = decoder0.readPointer(16, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.additionalDisplayItems = new PaymentItem[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.additionalDisplayItems[i1] = PaymentItem.decode(decoder2);
            }
            result.methodData = PaymentMethodData.decode(decoder0.readPointer(24, false));
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
        encoder0.encode((Struct) this.total, 8, true);
        if (this.additionalDisplayItems == null) {
            encoder0.encodeNullPointer(16, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.additionalDisplayItems.length, 16, -1);
            for (int i0 = 0; i0 < this.additionalDisplayItems.length; i0++) {
                encoder1.encode((Struct) this.additionalDisplayItems[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode((Struct) this.methodData, 24, false);
    }
}
