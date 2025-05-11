package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentShippingOption.class */
public final class PaymentShippingOption extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String id;
    public String label;
    public PaymentCurrencyAmount amount;
    public boolean selected;

    private PaymentShippingOption(int version) {
        super(40, version);
    }

    public PaymentShippingOption() {
        this(0);
    }

    public static PaymentShippingOption deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PaymentShippingOption deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentShippingOption decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PaymentShippingOption result = new PaymentShippingOption(elementsOrVersion);
            result.id = decoder0.readString(8, false);
            result.label = decoder0.readString(16, false);
            Decoder decoder1 = decoder0.readPointer(24, false);
            result.amount = PaymentCurrencyAmount.decode(decoder1);
            result.selected = decoder0.readBoolean(32, 0);
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
        encoder0.encode(this.id, 8, false);
        encoder0.encode(this.label, 16, false);
        encoder0.encode((Struct) this.amount, 24, false);
        encoder0.encode(this.selected, 32, 0);
    }
}
