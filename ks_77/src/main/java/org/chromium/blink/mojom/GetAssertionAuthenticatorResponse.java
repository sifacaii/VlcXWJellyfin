package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/GetAssertionAuthenticatorResponse.class */
public final class GetAssertionAuthenticatorResponse extends Struct {
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(56, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public CommonCredentialInfo info;
    public byte[] authenticatorData;
    public byte[] signature;
    public byte[] userHandle;
    public boolean echoAppidExtension;
    public boolean appidExtension;
    public boolean echoUserVerificationMethods;
    public UvmEntry[] userVerificationMethods;

    private GetAssertionAuthenticatorResponse(int version) {
        super(56, version);
    }

    public GetAssertionAuthenticatorResponse() {
        this(0);
    }

    public static GetAssertionAuthenticatorResponse deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static GetAssertionAuthenticatorResponse deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static GetAssertionAuthenticatorResponse decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            GetAssertionAuthenticatorResponse result = new GetAssertionAuthenticatorResponse(elementsOrVersion);
            result.info = CommonCredentialInfo.decode(decoder0.readPointer(8, false));
            result.authenticatorData = decoder0.readBytes(16, 0, -1);
            result.signature = decoder0.readBytes(24, 0, -1);
            result.userHandle = decoder0.readBytes(32, 1, -1);
            result.echoAppidExtension = decoder0.readBoolean(40, 0);
            result.appidExtension = decoder0.readBoolean(40, 1);
            result.echoUserVerificationMethods = decoder0.readBoolean(40, 2);
            Decoder decoder1 = decoder0.readPointer(48, true);
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
        encoder0.encode(this.authenticatorData, 16, 0, -1);
        encoder0.encode(this.signature, 24, 0, -1);
        encoder0.encode(this.userHandle, 32, 1, -1);
        encoder0.encode(this.echoAppidExtension, 40, 0);
        encoder0.encode(this.appidExtension, 40, 1);
        encoder0.encode(this.echoUserVerificationMethods, 40, 2);
        if (this.userVerificationMethods == null) {
            encoder0.encodeNullPointer(48, true);
            return;
        }
        Encoder encoder1 = encoder0.encodePointerArray(this.userVerificationMethods.length, 48, -1);
        for (int i0 = 0; i0 < this.userVerificationMethods.length; i0++) {
            encoder1.encode((Struct) this.userVerificationMethods[i0], 8 + (8 * i0), false);
        }
    }
}
