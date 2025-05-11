package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentItem.class */
public final class PaymentItem extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String label;
    public PaymentCurrencyAmount amount;
    public boolean pending;

    private PaymentItem(int version) {
        super(32, version);
    }

    public PaymentItem() {
        this(0);
    }

    public static PaymentItem deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PaymentItem deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentItem decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PaymentItem result = new PaymentItem(elementsOrVersion);
            result.label = decoder0.readString(8, false);
            Decoder decoder1 = decoder0.readPointer(16, false);
            result.amount = PaymentCurrencyAmount.decode(decoder1);
            result.pending = decoder0.readBoolean(24, 0);
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
        encoder0.encode(this.label, 8, false);
        encoder0.encode((Struct) this.amount, 16, false);
        encoder0.encode(this.pending, 24, 0);
    }
}
