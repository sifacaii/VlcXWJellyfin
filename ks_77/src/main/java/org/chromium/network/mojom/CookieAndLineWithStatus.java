package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieAndLineWithStatus.class */
public final class CookieAndLineWithStatus extends Struct {
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(32, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public CanonicalCookie cookie;
    public String cookieString;
    public int status;

    private CookieAndLineWithStatus(int version) {
        super(32, version);
    }

    public CookieAndLineWithStatus() {
        this(0);
    }

    public static CookieAndLineWithStatus deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CookieAndLineWithStatus deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieAndLineWithStatus decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CookieAndLineWithStatus result = new CookieAndLineWithStatus(elementsOrVersion);
            Decoder decoder1 = decoder0.readPointer(8, true);
            result.cookie = CanonicalCookie.decode(decoder1);
            result.cookieString = decoder0.readString(16, false);
            result.status = decoder0.readInt(24);
            CookieInclusionStatus.validate(result.status);
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
        encoder0.encode((Struct) this.cookie, 8, true);
        encoder0.encode(this.cookieString, 16, false);
        encoder0.encode(this.status, 24);
    }
}
