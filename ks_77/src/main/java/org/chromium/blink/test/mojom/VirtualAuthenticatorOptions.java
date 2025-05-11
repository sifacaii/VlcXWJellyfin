package org.chromium.blink.test.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.mojom.AuthenticatorAttachment;
import org.chromium.blink.mojom.AuthenticatorTransport;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/test/mojom/VirtualAuthenticatorOptions.class */
public final class VirtualAuthenticatorOptions extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int protocol;
    public int transport;
    public int attachment;
    public boolean hasResidentKey;
    public boolean hasUserVerification;

    private VirtualAuthenticatorOptions(int version) {
        super(24, version);
    }

    public VirtualAuthenticatorOptions() {
        this(0);
    }

    public static VirtualAuthenticatorOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static VirtualAuthenticatorOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static VirtualAuthenticatorOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            VirtualAuthenticatorOptions result = new VirtualAuthenticatorOptions(elementsOrVersion);
            result.protocol = decoder0.readInt(8);
            ClientToAuthenticatorProtocol.validate(result.protocol);
            result.transport = decoder0.readInt(12);
            AuthenticatorTransport.validate(result.transport);
            result.attachment = decoder0.readInt(16);
            AuthenticatorAttachment.validate(result.attachment);
            result.hasResidentKey = decoder0.readBoolean(20, 0);
            result.hasUserVerification = decoder0.readBoolean(20, 1);
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
        encoder0.encode(this.protocol, 8);
        encoder0.encode(this.transport, 12);
        encoder0.encode(this.attachment, 16);
        encoder0.encode(this.hasResidentKey, 20, 0);
        encoder0.encode(this.hasUserVerification, 20, 1);
    }
}
