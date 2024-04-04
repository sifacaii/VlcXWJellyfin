package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentMethodChangeResponse.class */
public final class PaymentMethodChangeResponse extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public PaymentCurrencyAmount total;
    public PaymentHandlerModifier[] modifiers;
    public String error;
    public String stringifiedPaymentMethodErrors;

    private PaymentMethodChangeResponse(int version) {
        super(40, version);
        this.error = CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
    }

    public PaymentMethodChangeResponse() {
        this(0);
    }

    public static PaymentMethodChangeResponse deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PaymentMethodChangeResponse deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentMethodChangeResponse decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PaymentMethodChangeResponse result = new PaymentMethodChangeResponse(elementsOrVersion);
            result.total = PaymentCurrencyAmount.decode(decoder0.readPointer(8, true));
            Decoder decoder1 = decoder0.readPointer(16, true);
            if (decoder1 == null) {
                result.modifiers = null;
            } else {
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.modifiers = new PaymentHandlerModifier[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.modifiers[i1] = PaymentHandlerModifier.decode(decoder2);
                }
            }
            result.error = decoder0.readString(24, false);
            result.stringifiedPaymentMethodErrors = decoder0.readString(32, true);
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
        if (this.modifiers == null) {
            encoder0.encodeNullPointer(16, true);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.modifiers.length, 16, -1);
            for (int i0 = 0; i0 < this.modifiers.length; i0++) {
                encoder1.encode((Struct) this.modifiers[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.error, 24, false);
        encoder0.encode(this.stringifiedPaymentMethodErrors, 32, true);
    }
}
