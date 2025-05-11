package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/MakeCredentialAuthenticatorResponse.class */
public final class MakeCredentialAuthenticatorResponse extends Struct {
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(48, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public CommonCredentialInfo info;
    public byte[] attestationObject;
    public int[] transports;
    public boolean echoHmacCreateSecret;
    public boolean hmacCreateSecret;
    public boolean echoUserVerificationMethods;
    public UvmEntry[] userVerificationMethods;

    private MakeCredentialAuthenticatorResponse(int version) {
        super(48, version);
    }

    public MakeCredentialAuthenticatorResponse() {
        this(0);
    }

    public static MakeCredentialAuthenticatorResponse deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static MakeCredentialAuthenticatorResponse deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static MakeCredentialAuthenticatorResponse decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            MakeCredentialAuthenticatorResponse result = new MakeCredentialAuthenticatorResponse(elementsOrVersion);
            result.info = CommonCredentialInfo.decode(decoder0.readPointer(8, false));
            result.attestationObject = decoder0.readBytes(16, 0, -1);
            result.transports = decoder0.readInts(24, 0, -1);
            for (int i0 = 0; i0 < result.transports.length; i0++) {
                AuthenticatorTransport.validate(result.transports[i0]);
            }
            result.echoHmacCreateSecret = decoder0.readBoolean(32, 0);
            result.hmacCreateSecret = decoder0.readBoolean(32, 1);
            result.echoUserVerificationMethods = decoder0.readBoolean(32, 2);
            Decoder decoder1 = decoder0.readPointer(40, true);
            if (decoder1 == null) {
                result.userVerificationMethods = null;
            } else {
                DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
                result.userVerificationMethods = new UvmEntry[si1.elementsOrVersion];
                for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                    Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                    result.userVerificationMethods[i1] = UvmEntry.decode(decoder2);
                }
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
        encoder0.encode((Struct) this.info, 8, false);
        encoder0.encode(this.attestationObject, 16, 0, -1);
        encoder0.encode(this.transports, 24, 0, -1);
        encoder0.encode(this.echoHmacCreateSecret, 32, 0);
        encoder0.encode(this.hmacCreateSecret, 32, 1);
        encoder0.encode(this.echoUserVerificationMethods, 32, 2);
        if (this.userVerificationMethods == null) {
            encoder0.encodeNullPointer(40, true);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.userVerificationMethods.length, 40, -1);
        for (int i0 = 0; i0 < this.userVerificationMethods.length; i0++) {
            encoder1.encode((Struct) this.userVerificationMethods[i0], 8 + (8 * i0), false);
        }
    }
}
