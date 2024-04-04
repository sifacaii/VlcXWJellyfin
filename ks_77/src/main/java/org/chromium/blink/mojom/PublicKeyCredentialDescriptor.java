package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PublicKeyCredentialDescriptor.class */
public final class PublicKeyCredentialDescriptor extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int type;
    public byte[] id;
    public int[] transports;

    private PublicKeyCredentialDescriptor(int version) {
        super(32, version);
    }

    public PublicKeyCredentialDescriptor() {
        this(0);
    }

    public static PublicKeyCredentialDescriptor deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PublicKeyCredentialDescriptor deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PublicKeyCredentialDescriptor decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PublicKeyCredentialDescriptor result = new PublicKeyCredentialDescriptor(elementsOrVersion);
            result.type = decoder0.readInt(8);
            PublicKeyCredentialType.validate(result.type);
            result.id = decoder0.readBytes(16, 0, -1);
            result.transports = decoder0.readInts(24, 0, -1);
            for (int i0 = 0; i0 < result.transports.length; i0++) {
                AuthenticatorTransport.validate(result.transports[i0]);
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
        encoder0.encode(this.type, 8);
        encoder0.encode(this.id, 16, 0, -1);
        encoder0.encode(this.transports, 24, 0, -1);
    }
}
