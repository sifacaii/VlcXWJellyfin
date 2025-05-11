package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentOptions.class */
public final class PaymentOptions extends Struct {
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(16, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean requestPayerName;
    public boolean requestPayerEmail;
    public boolean requestPayerPhone;
    public boolean requestShipping;
    public int shippingType;

    private PaymentOptions(int version) {
        super(16, version);
    }

    public PaymentOptions() {
        this(0);
    }

    public static PaymentOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PaymentOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PaymentOptions result = new PaymentOptions(elementsOrVersion);
            result.requestPayerName = decoder0.readBoolean(8, 0);
            result.requestPayerEmail = decoder0.readBoolean(8, 1);
            result.requestPayerPhone = decoder0.readBoolean(8, 2);
            result.requestShipping = decoder0.readBoolean(8, 3);
            result.shippingType = decoder0.readInt(12);
            PaymentShippingType.validate(result.shippingType);
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
        encoder0.encode(this.requestPayerName, 8, 0);
        encoder0.encode(this.requestPayerEmail, 8, 1);
        encoder0.encode(this.requestPayerPhone, 8, 2);
        encoder0.encode(this.requestShipping, 8, 3);
        encoder0.encode(this.shippingType, 12);
    }
}
