package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentResponse.class */
public final class PaymentResponse extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String methodName;
    public String stringifiedDetails;
    public PaymentAddress shippingAddress;
    public String shippingOption;
    public PayerDetail payer;

    private PaymentResponse(int version) {
        super(48, version);
    }

    public PaymentResponse() {
        this(0);
    }

    public static PaymentResponse deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PaymentResponse deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentResponse decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PaymentResponse result = new PaymentResponse(elementsOrVersion);
            result.methodName = decoder0.readString(8, false);
            result.stringifiedDetails = decoder0.readString(16, false);
            Decoder decoder1 = decoder0.readPointer(24, true);
            result.shippingAddress = PaymentAddress.decode(decoder1);
            result.shippingOption = decoder0.readString(32, true);
            Decoder decoder12 = decoder0.readPointer(40, false);
            result.payer = PayerDetail.decode(decoder12);
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
        encoder0.encode(this.methodName, 8, false);
        encoder0.encode(this.stringifiedDetails, 16, false);
        encoder0.encode((Struct) this.shippingAddress, 24, true);
        encoder0.encode(this.shippingOption, 32, true);
        encoder0.encode((Struct) this.payer, 40, false);
    }
}
