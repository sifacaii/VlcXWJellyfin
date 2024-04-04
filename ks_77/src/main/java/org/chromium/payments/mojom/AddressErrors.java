package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/AddressErrors.class */
public final class AddressErrors extends Struct {
    private static final int STRUCT_SIZE = 88;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(88, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String addressLine;
    public String city;
    public String country;
    public String dependentLocality;
    public String organization;
    public String phone;
    public String postalCode;
    public String recipient;
    public String region;
    public String sortingCode;

    private AddressErrors(int version) {
        super(88, version);
    }

    public AddressErrors() {
        this(0);
    }

    public static AddressErrors deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static AddressErrors deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static AddressErrors decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            AddressErrors result = new AddressErrors(elementsOrVersion);
            result.addressLine = decoder0.readString(8, false);
            result.city = decoder0.readString(16, false);
            result.country = decoder0.readString(24, false);
            result.dependentLocality = decoder0.readString(32, false);
            result.organization = decoder0.readString(40, false);
            result.phone = decoder0.readString(48, false);
            result.postalCode = decoder0.readString(56, false);
            result.recipient = decoder0.readString(64, false);
            result.region = decoder0.readString(72, false);
            result.sortingCode = decoder0.readString(80, false);
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
        encoder0.encode(this.addressLine, 8, false);
        encoder0.encode(this.city, 16, false);
        encoder0.encode(this.country, 24, false);
        encoder0.encode(this.dependentLocality, 32, false);
        encoder0.encode(this.organization, 40, false);
        encoder0.encode(this.phone, 48, false);
        encoder0.encode(this.postalCode, 56, false);
        encoder0.encode(this.recipient, 64, false);
        encoder0.encode(this.region, 72, false);
        encoder0.encode(this.sortingCode, 80, false);
    }
}
