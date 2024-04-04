package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CookieOptions.class */
public final class CookieOptions extends Struct {
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(24, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean excludeHttponly;
    public int sameSiteCookieContext;
    public boolean updateAccessTime;
    public Time serverTime;
    public boolean returnExcludedCookies;

    private CookieOptions(int version) {
        super(24, version);
        this.excludeHttponly = true;
        this.sameSiteCookieContext = 0;
        this.updateAccessTime = true;
        this.returnExcludedCookies = false;
    }

    public CookieOptions() {
        this(0);
    }

    public static CookieOptions deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CookieOptions deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CookieOptions decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CookieOptions result = new CookieOptions(elementsOrVersion);
            result.excludeHttponly = decoder0.readBoolean(8, 0);
            result.updateAccessTime = decoder0.readBoolean(8, 1);
            result.returnExcludedCookies = decoder0.readBoolean(8, 2);
            result.sameSiteCookieContext = decoder0.readInt(12);
            CookieSameSiteContext.validate(result.sameSiteCookieContext);
            Decoder decoder1 = decoder0.readPointer(16, true);
            result.serverTime = Time.decode(decoder1);
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
        encoder0.encode(this.excludeHttponly, 8, 0);
        encoder0.encode(this.updateAccessTime, 8, 1);
        encoder0.encode(this.returnExcludedCookies, 8, 2);
        encoder0.encode(this.sameSiteCookieContext, 12);
        encoder0.encode((Struct) this.serverTime, 16, true);
    }
}
