package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/payments/mojom/PaymentMethodData.class */
public final class PaymentMethodData extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String supportedMethod;
    public String stringifiedData;
    public int environment;
    public int minGooglePlayServicesVersion;
    public int apiVersion;
    public int[] supportedNetworks;
    public int[] supportedTypes;

    private PaymentMethodData(int version) {
        super(56, version);
    }

    public PaymentMethodData() {
        this(0);
    }

    public static PaymentMethodData deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PaymentMethodData deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PaymentMethodData decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PaymentMethodData result = new PaymentMethodData(elementsOrVersion);
            result.supportedMethod = decoder0.readString(8, false);
            result.stringifiedData = decoder0.readString(16, false);
            result.environment = decoder0.readInt(24);
            AndroidPayEnvironment.validate(result.environment);
            result.minGooglePlayServicesVersion = decoder0.readInt(28);
            result.apiVersion = decoder0.readInt(32);
            result.supportedNetworks = decoder0.readInts(40, 0, -1);
            for (int i0 = 0; i0 < result.supportedNetworks.length; i0++) {
                BasicCardNetwork.validate(result.supportedNetworks[i0]);
            }
            result.supportedTypes = decoder0.readInts(48, 0, -1);
            for (int i02 = 0; i02 < result.supportedTypes.length; i02++) {
                BasicCardType.validate(result.supportedTypes[i02]);
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
        encoder0.encode(this.supportedMethod, 8, false);
        encoder0.encode(this.stringifiedData, 16, false);
        encoder0.encode(this.environment, 24);
        encoder0.encode(this.minGooglePlayServicesVersion, 28);
        encoder0.encode(this.apiVersion, 32);
        encoder0.encode(this.supportedNetworks, 40, 0, -1);
        encoder0.encode(this.supportedTypes, 48, 0, -1);
    }
}
