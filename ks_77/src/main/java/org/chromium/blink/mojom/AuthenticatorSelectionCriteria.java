package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/AuthenticatorSelectionCriteria.class */
public final class AuthenticatorSelectionCriteria extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int authenticatorAttachment;
    public boolean requireResidentKey;
    public int userVerification;

    private AuthenticatorSelectionCriteria(int version) {
        super(24, version);
    }

    public AuthenticatorSelectionCriteria() {
        this(0);
    }

    public static AuthenticatorSelectionCriteria deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static AuthenticatorSelectionCriteria deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static AuthenticatorSelectionCriteria decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            AuthenticatorSelectionCriteria result = new AuthenticatorSelectionCriteria(elementsOrVersion);
            result.authenticatorAttachment = decoder0.readInt(8);
            AuthenticatorAttachment.validate(result.authenticatorAttachment);
            result.requireResidentKey = decoder0.readBoolean(12, 0);
            result.userVerification = decoder0.readInt(16);
            UserVerificationRequirement.validate(result.userVerification);
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
        encoder0.encode(this.authenticatorAttachment, 8);
        encoder0.encode(this.requireResidentKey, 12, 0);
        encoder0.encode(this.userVerification, 16);
    }
}
