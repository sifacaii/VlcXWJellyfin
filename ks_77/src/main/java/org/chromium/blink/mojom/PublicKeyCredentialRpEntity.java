package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/blink/mojom/PublicKeyCredentialRpEntity.class */
public final class PublicKeyCredentialRpEntity extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String id;
    public String name;
    public Url icon;

    private PublicKeyCredentialRpEntity(int version) {
        super(32, version);
    }

    public PublicKeyCredentialRpEntity() {
        this(0);
    }

    public static PublicKeyCredentialRpEntity deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static PublicKeyCredentialRpEntity deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static PublicKeyCredentialRpEntity decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            PublicKeyCredentialRpEntity result = new PublicKeyCredentialRpEntity(elementsOrVersion);
            result.id = decoder0.readString(8, false);
            result.name = decoder0.readString(16, false);
            Decoder decoder1 = decoder0.readPointer(24, true);
            result.icon = Url.decode(decoder1);
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
        encoder0.encode(this.id, 8, false);
        encoder0.encode(this.name, 16, false);
        encoder0.encode((Struct) this.icon, 24, true);
    }
}
