package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PublicKeyCredentialRequestOptions.class */
public final class PublicKeyCredentialRequestOptions extends Struct {
    private static final int STRUCT_SIZE = 64;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(64, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public byte[] challenge;
    public TimeDelta adjustedTimeout;
    public String relyingPartyId;
    public PublicKeyCredentialDescriptor[] allowCredentials;
    public int userVerification;
    public String appid;
    public CableAuthentication[] cableAuthenticationData;
    public boolean userVerificationMethods;

    private PublicKeyCredentialRequestOptions(int version) {
        super(64, version);
    }

    public PublicKeyCredentialRequestOptions() {
        this(0);
    }

    public static PublicKeyCredentialRequestOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PublicKeyCredentialRequestOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PublicKeyCredentialRequestOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PublicKeyCredentialRequestOptions result = new PublicKeyCredentialRequestOptions(elementsOrVersion);
            result.challenge = decoder0.readBytes(8, 0, -1);
            result.adjustedTimeout = TimeDelta.decode(decoder0.readPointer(16, false));
            result.relyingPartyId = decoder0.readString(24, false);
            Decoder decoder1 = decoder0.readPointer(32, false);
            DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
            result.allowCredentials = new PublicKeyCredentialDescriptor[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder1.readPointer(8 + (8 * i1), false);
                result.allowCredentials[i1] = PublicKeyCredentialDescriptor.decode(decoder2);
            }
            result.userVerification = decoder0.readInt(40);
            UserVerificationRequirement.validate(result.userVerification);
            result.userVerificationMethods = decoder0.readBoolean(44, 0);
            result.appid = decoder0.readString(48, true);
            Decoder decoder12 = decoder0.readPointer(56, false);
            DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
            result.cableAuthenticationData = new CableAuthentication[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder12.readPointer(8 + (8 * i12), false);
                result.cableAuthenticationData[i12] = CableAuthentication.decode(decoder22);
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
        encoder0.encode(this.challenge, 8, 0, -1);
        encoder0.encode((Struct) this.adjustedTimeout, 16, false);
        encoder0.encode(this.relyingPartyId, 24, false);
        if (this.allowCredentials == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.allowCredentials.length, 32, -1);
            for (int i0 = 0; i0 < this.allowCredentials.length; i0++) {
                encoder1.encode((Struct) this.allowCredentials[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode(this.userVerification, 40);
        encoder0.encode(this.userVerificationMethods, 44, 0);
        encoder0.encode(this.appid, 48, true);
        if (this.cableAuthenticationData == null) {
            encoder0.encodeNullPointer(56, false);
            return;
        }
        Encoder encoder12 = encoder0.encodePointerArray(this.cableAuthenticationData.length, 56, -1);
        for (int i02 = 0; i02 < this.cableAuthenticationData.length; i02++) {
            encoder12.encode((Struct) this.cableAuthenticationData[i02], 8 + (8 * i02), false);
        }
    }
}
