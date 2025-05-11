package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.content.browser.accessibility.captioning.CaptioningChangeDelegate;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentDetails.class */
public final class PaymentDetails extends Struct {
    private static final int STRUCT_SIZE = 72;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(72, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public PaymentItem total;
    public PaymentItem[] displayItems;
    public PaymentShippingOption[] shippingOptions;
    public PaymentDetailsModifier[] modifiers;
    public String error;
    public AddressErrors shippingAddressErrors;
    public String id;
    public String stringifiedPaymentMethodErrors;

    private PaymentDetails(int version) {
        super(72, version);
        this.error = CaptioningChangeDelegate.DEFAULT_CAPTIONING_PREF_VALUE;
    }

    public PaymentDetails() {
        this(0);
    }

    public static PaymentDetails deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PaymentDetails deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentDetails decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PaymentDetails result = new PaymentDetails(elementsOrVersion);
            result.total = PaymentItem.decode(decoder0.readPointer(8, true));
            Decoder decoder1 = decoder0.readPointer(16, true);
            if (decoder1 == null) {
                result.displayItems = null;
            } else {
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.displayItems = new PaymentItem[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.displayItems[i1] = PaymentItem.decode(decoder2);
                }
            }
            Decoder decoder12 = decoder0.readPointer(24, true);
            if (decoder12 == null) {
                result.shippingOptions = null;
            } else {
                DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
                result.shippingOptions = new PaymentShippingOption[si12.elementsOrVersion];
                for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                    Decoder decoder22 = decoder12.readPointer(8 + (8 * i12), false);
                    result.shippingOptions[i12] = PaymentShippingOption.decode(decoder22);
                }
            }
            Decoder decoder13 = decoder0.readPointer(32, true);
            if (decoder13 == null) {
                result.modifiers = null;
            } else {
                DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
                result.modifiers = new PaymentDetailsModifier[si13.elementsOrVersion];
                for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
                    Decoder decoder23 = decoder13.readPointer(8 + (8 * i13), false);
                    result.modifiers[i13] = PaymentDetailsModifier.decode(decoder23);
                }
            }
            result.error = decoder0.readString(40, false);
            result.shippingAddressErrors = AddressErrors.decode(decoder0.readPointer(48, true));
            result.id = decoder0.readString(56, true);
            result.stringifiedPaymentMethodErrors = decoder0.readString(64, true);
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
        if (this.displayItems == null) {
            encoder0.encodeNullPointer(16, true);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.displayItems.length, 16, -1);
            for (int i0 = 0; i0 < this.displayItems.length; i0++) {
                encoder1.encode((Struct) this.displayItems[i0], 8 + (8 * i0), false);
            }
        }
        if (this.shippingOptions == null) {
            encoder0.encodeNullPointer(24, true);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.shippingOptions.length, 24, -1);
            for (int i02 = 0; i02 < this.shippingOptions.length; i02++) {
                encoder12.encode((Struct) this.shippingOptions[i02], 8 + (8 * i02), false);
            }
        }
        if (this.modifiers == null) {
            encoder0.encodeNullPointer(32, true);
        } else {
            Encoder encoder13 = encoder0.encodePointerArray(this.modifiers.length, 32, -1);
            for (int i03 = 0; i03 < this.modifiers.length; i03++) {
                encoder13.encode((Struct) this.modifiers[i03], 8 + (8 * i03), false);
            }
        }
        encoder0.encode(this.error, 40, false);
        encoder0.encode((Struct) this.shippingAddressErrors, 48, true);
        encoder0.encode(this.id, 56, true);
        encoder0.encode(this.stringifiedPaymentMethodErrors, 64, true);
    }
}
