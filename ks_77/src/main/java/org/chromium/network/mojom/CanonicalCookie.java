package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;

/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/network/mojom/CanonicalCookie.class */
public final class CanonicalCookie extends Struct {
    private static final int STRUCT_SIZE = 80;
    private static final DataHeader[] VERSION_ARRAY = {new DataHeader(80, 0)};
    private static final DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String name;
    public String value;
    public String domain;
    public String path;
    public Time creation;
    public Time expiry;
    public Time lastAccess;
    public boolean secure;
    public boolean httponly;
    public int siteRestrictions;
    public int priority;

    private CanonicalCookie(int version) {
        super(80, version);
        this.secure = false;
        this.httponly = false;
        this.siteRestrictions = 0;
        this.priority = 1;
    }

    public CanonicalCookie() {
        this(0);
    }

    public static CanonicalCookie deserialize(Message message) {
        return decode(new Decoder(message));
    }

    public static CanonicalCookie deserialize(ByteBuffer data) {
        return deserialize(new Message(data, new ArrayList()));
    }

    public static CanonicalCookie decode(Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        try {
            DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            int elementsOrVersion = mainDataHeader.elementsOrVersion;
            CanonicalCookie result = new CanonicalCookie(elementsOrVersion);
            result.name = decoder0.readString(8, false);
            result.value = decoder0.readString(16, false);
            result.domain = decoder0.readString(24, false);
            result.path = decoder0.readString(32, false);
            Decoder decoder1 = decoder0.readPointer(40, false);
            result.creation = Time.decode(decoder1);
            Decoder decoder12 = decoder0.readPointer(48, false);
            result.expiry = Time.decode(decoder12);
            Decoder decoder13 = decoder0.readPointer(56, false);
            result.lastAccess = Time.decode(decoder13);
            result.secure = decoder0.readBoolean(64, 0);
            result.httponly = decoder0.readBoolean(64, 1);
            result.siteRestrictions = decoder0.readInt(68);
            CookieSameSite.validate(result.siteRestrictions);
            result.priority = decoder0.readInt(72);
            CookiePriority.validate(result.priority);
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
        encoder0.encode(this.name, 8, false);
        encoder0.encode(this.value, 16, false);
        encoder0.encode(this.domain, 24, false);
        encoder0.encode(this.path, 32, false);
        encoder0.encode((Struct) this.creation, 40, false);
        encoder0.encode((Struct) this.expiry, 48, false);
        encoder0.encode((Struct) this.lastAccess, 56, false);
        encoder0.encode(this.secure, 64, 0);
        encoder0.encode(this.httponly, 64, 1);
        encoder0.encode(this.siteRestrictions, 68);
        encoder0.encode(this.priority, 72);
    }
}
