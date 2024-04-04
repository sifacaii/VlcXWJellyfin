package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PublicKeyCredentialCreationOptions.class */
public final class PublicKeyCredentialCreationOptions extends Struct {
    private static final int STRUCT_SIZE = 88;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(88, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public PublicKeyCredentialRpEntity relyingParty;
    public PublicKeyCredentialUserEntity user;
    public byte[] challenge;
    public PublicKeyCredentialParameters[] publicKeyParameters;
    public TimeDelta adjustedTimeout;
    public PublicKeyCredentialDescriptor[] excludeCredentials;
    public AuthenticatorSelectionCriteria authenticatorSelection;
    public int attestation;
    public CableRegistration cableRegistrationData;
    public boolean hmacCreateSecret;
    public boolean userVerificationMethods;
    public int protectionPolicy;
    public boolean enforceProtectionPolicy;

    private PublicKeyCredentialCreationOptions(int version) {
        super(88, version);
    }

    public PublicKeyCredentialCreationOptions() {
        this(0);
    }

    public static PublicKeyCredentialCreationOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PublicKeyCredentialCreationOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PublicKeyCredentialCreationOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PublicKeyCredentialCreationOptions result = new PublicKeyCredentialCreationOptions(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, false);
            result.relyingParty = PublicKeyCredentialRpEntity.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(16, false);
            result.user = PublicKeyCredentialUserEntity.decode(decoder12);
            result.challenge = decoder0.readBytes(24, 0, -1);
            Decoder decoder13 = decoder0.readPointer(32, false);
            DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
            result.publicKeyParameters = new PublicKeyCredentialParameters[si1.elementsOrVersion];
            for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
                Decoder decoder2 = decoder13.readPointer(8 + (8 * i1), false);
                result.publicKeyParameters[i1] = PublicKeyCredentialParameters.decode(decoder2);
            }
            Decoder decoder14 = decoder0.readPointer(40, false);
            result.adjustedTimeout = TimeDelta.decode(decoder14);
            Decoder decoder15 = decoder0.readPointer(48, false);
            DataHeader si12 = decoder15.readDataHeaderForPointerArray(-1);
            result.excludeCredentials = new PublicKeyCredentialDescriptor[si12.elementsOrVersion];
            for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
                Decoder decoder22 = decoder15.readPointer(8 + (8 * i12), false);
                result.excludeCredentials[i12] = PublicKeyCredentialDescriptor.decode(decoder22);
            }
            Decoder decoder16 = decoder0.readPointer(56, true);
            result.authenticatorSelection = AuthenticatorSelectionCriteria.decode(decoder16);
            result.attestation = decoder0.readInt(64);
            AttestationConveyancePreference.validate(result.attestation);
            result.hmacCreateSecret = decoder0.readBoolean(68, 0);
            result.userVerificationMethods = decoder0.readBoolean(68, 1);
            result.enforceProtectionPolicy = decoder0.readBoolean(68, 2);
            Decoder decoder17 = decoder0.readPointer(72, true);
            result.cableRegistrationData = CableRegistration.decode(decoder17);
            result.protectionPolicy = decoder0.readInt(80);
            ProtectionPolicy.validate(result.protectionPolicy);
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
        encoder0.encode((Struct) this.relyingParty, 8, false);
        encoder0.encode((Struct) this.user, 16, false);
        encoder0.encode(this.challenge, 24, 0, -1);
        if (this.publicKeyParameters == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            Encoder encoder1 = encoder0.encodePointerArray(this.publicKeyParameters.length, 32, -1);
            for (int i0 = 0; i0 < this.publicKeyParameters.length; i0++) {
                encoder1.encode((Struct) this.publicKeyParameters[i0], 8 + (8 * i0), false);
            }
        }
        encoder0.encode((Struct) this.adjustedTimeout, 40, false);
        if (this.excludeCredentials == null) {
            encoder0.encodeNullPointer(48, false);
        } else {
            Encoder encoder12 = encoder0.encodePointerArray(this.excludeCredentials.length, 48, -1);
            for (int i02 = 0; i02 < this.excludeCredentials.length; i02++) {
                encoder12.encode((Struct) this.excludeCredentials[i02], 8 + (8 * i02), false);
            }
        }
        encoder0.encode((Struct) this.authenticatorSelection, 56, true);
        encoder0.encode(this.attestation, 64);
        encoder0.encode(this.hmacCreateSecret, 68, 0);
        encoder0.encode(this.userVerificationMethods, 68, 1);
        encoder0.encode(this.enforceProtectionPolicy, 68, 2);
        encoder0.encode((Struct) this.cableRegistrationData, 72, true);
        encoder0.encode(this.protectionPolicy, 80);
    }
}
