package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentAddress.class */
public final class PaymentAddress extends Struct {
    private static final int STRUCT_SIZE = 88;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(88, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String country;
    public String[] addressLine;
    public String region;
    public String city;
    public String dependentLocality;
    public String postalCode;
    public String sortingCode;
    public String organization;
    public String recipient;
    public String phone;

    private PaymentAddress(int version) {
        super(88, version);
    }

    public PaymentAddress() {
        this(0);
    }

    public static PaymentAddress deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PaymentAddress deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentAddress decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PaymentAddress result = new PaymentAddress(elementsOrVersion);
            result.country = decoder0.readString(8, false);
            Decoder decoder1 = decoder0.readPointer(16, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.addressLine = new String[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                result.addressLine[i1] = decoder1.readString(8 + (8 * i1), false);
            }
            result.region = decoder0.readString(24, false);
            result.city = decoder0.readString(32, false);
            result.dependentLocality = decoder0.readString(40, false);
            result.postalCode = decoder0.readString(48, false);
            result.sortingCode = decoder0.readString(56, false);
            result.organization = decoder0.readString(64, false);
            result.recipient = decoder0.readString(72, false);
            result.phone = decoder0.readString(80, false);
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
        encoder0.encode(this.country, 8, false);
        if (this.addressLine == null) {
            encoder0.encodeNullPointer(16, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.addressLine.length, 16, -1);
            for (int i0 = 0; i0 < this.addressLine.length; i0++) {
                encoder1.encode(this.addressLine[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.region, 24, false);
        encoder0.encode(this.city, 32, false);
        encoder0.encode(this.dependentLocality, 40, false);
        encoder0.encode(this.postalCode, 48, false);
        encoder0.encode(this.sortingCode, 56, false);
        encoder0.encode(this.organization, 64, false);
        encoder0.encode(this.recipient, 72, false);
        encoder0.encode(this.phone, 80, false);
    }
}
