package org.chromium.url.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/url/mojom/Origin.class */
public final class Origin extends Struct {
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(40, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String scheme;
    public String host;
    public short port;
    public UnguessableToken nonceIfOpaque;

    private Origin(int version) {
        super(40, version);
    }

    public Origin() {
        this(0);
    }

    public static Origin deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static Origin deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static Origin decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            Origin result = new Origin(elementsOrVersion);
            result.scheme = decoder0.readString(8, false);
            result.host = decoder0.readString(16, false);
            result.port = decoder0.readShort(24);
            Decoder decoder1 = decoder0.readPointer(32, true);
            result.nonceIfOpaque = UnguessableToken.decode(decoder1);
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
        encoder0.encode(this.scheme, 8, false);
        encoder0.encode(this.host, 16, false);
        encoder0.encode(this.port, 24);
        encoder0.encode((Struct) this.nonceIfOpaque, 32, true);
    }
}
